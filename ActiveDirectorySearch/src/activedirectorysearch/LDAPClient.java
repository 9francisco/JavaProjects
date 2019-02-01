/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activedirectorysearch;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPSearchResults;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LDAPClient {

    private int ldapVersion;
    private int ldapPort;
    private int sslPort;
    private String host;
    private boolean isAnonymous;
    private String adminDN;         
    private String adminpasswd;     
    private String DNSearchRoot;
    private String userNameDN;

    public LDAPClient() {
    }

    public LDAPClient(int ldapVersion, int ldapPort) {
        this.ldapVersion = ldapVersion;
        this.ldapPort = ldapPort;
    }

    public LDAPClient(int ldapVersion, int ldapPort, int sslPort) {
        this.ldapVersion = ldapVersion;
        this.ldapPort = ldapPort;
        this.sslPort = sslPort;
    }

    public LDAPClient(int ldapVersion, int ldapPort, int sslPort, String host) {
        this.ldapVersion = ldapVersion;
        this.ldapPort = ldapPort;
        this.sslPort = sslPort;
        this.host = host;
    }

    public LDAPClient(int ldapVersion, int ldapPort, int sslPort, String host, boolean isAnonymous) {
        this.ldapVersion = ldapVersion;
        this.ldapPort = ldapPort;
        this.sslPort = sslPort;
        this.host = host;
        this.isAnonymous = isAnonymous;
    }

    public String getDNSearchRoot() {
        return DNSearchRoot;
    }

    public void setDNSearchRoot(String DNSearchRoot) {
        this.DNSearchRoot = DNSearchRoot;
    }

    public String getUserNameDN() {
        return userNameDN;
    }

    public void setUserNameDN(String userNameDN) {
        this.userNameDN = userNameDN;
    }

    public boolean isIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public String getAdminDN() {
        return adminDN;
    }

    public void setAdminDN(String adminDN) {
        this.adminDN = adminDN;
    }

    public String getAdminpasswd() {
        return adminpasswd;
    }

    public void setAdminpasswd(String adminpasswd) {
        this.adminpasswd = adminpasswd;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getLdapPort() {
        return ldapPort;
    }

    public void setLdapPort(int ldapPort) {
        this.ldapPort = ldapPort;
    }

    public int getLdapVersion() {
        return ldapVersion;
    }

    public void setLdapVersion(int ldapVersion) {
        this.ldapVersion = ldapVersion;
    }

    public int getSslPort() {
        return sslPort;
    }

    public void setSslPort(int sslPort) {
        this.sslPort = sslPort;
    }

    public String getLogonServer() {
        String strRet = "";
        try {
            //String currentUser = System.getProperty("user.name");
            String strPathInfo = "C:\\Documents and Settings\\" + System.getProperty("user.name") + "\\Start Menu\\Info.txt";

            File file = new File(strPathInfo);
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            DataInputStream dis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(bis);
                while (dis.available() != 0) {
                    String str = dis.readLine();
                    if (str.contains("Logon Server")) {
                        strRet = str.substring(str.indexOf(":") + 1, str.length());
                        System.out.println("Logon Server is :" + strRet);
                        return strRet.trim();
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException: " + e.toString());
            } catch (IOException e) {
                System.out.println("IOException: " + e.toString());
            } finally {
                fis.close();
                bis.close();
                dis.close();
            }
        } catch (Exception e) {
            System.out.println("Error getCurrentLogonServer: " + e.toString());
        }
        return strRet;
    }

    public boolean authenticate(String username, String password, boolean isAnonymous) {

        try {

            if (username == null || password == null) {
                return false;
            }

            if (username.trim().length() == 0 || password.trim().length() == 0) {
                return false;
            }

            LDAPConnection conn = new LDAPConnection();
            try {
                conn.connect(getHost(), getLdapPort());
            } catch (LDAPException ex) {
                System.out.println("Error LDAPConnection: " + ex.toString());
                return false;
            }

            if (!isAnonymous) {
                try {
                    conn.bind(LDAPConnection.LDAP_V3, adminDN, adminpasswd.getBytes());
                } catch (LDAPException ex) {
                    System.out.println("Error authenticate: " + ex.toString());
                    return false;
                }
            }

            LDAPSearchResults res = null;
            String[] attrs = {LDAPConnection.NO_ATTRS};
            try {
                res = conn.search(DNSearchRoot, LDAPConnection.SCOPE_SUB, userNameDN + "=" + username, attrs, false);
            } catch (LDAPException ex) {
                System.out.println("Error username search: " + ex.toString());
                return false;
            }

            if (res == null) {
                return false;
            }

            boolean success = false;

            String userDN = null;
            if /*while*/ (res.hasMore()) {
                try {
                    LDAPEntry entry = (LDAPEntry) res.next();
                    userDN = entry.getDN();
                    System.out.println("userDN: " + userDN);
                    success = true;
                } catch (LDAPException ex) {
                    System.out.println("Error authenticate: " + ex.toString());
                    return false;
                }
            }

            if (!success) {
                return false;
            }

            try {
                conn.bind(LDAPConnection.LDAP_V3, userDN, password.getBytes());
            } catch (LDAPException ex) {
                System.out.println("Error password search: " + ex.toString());
                return false;
            }

            return true;
        } catch (Exception e) {
            System.out.println("Error authenticate: " + e.toString());
            return false;
        }
    }

    public void authenticateUser(String username, String password, String _domain, String host, String dn) throws NamingException {
        String ATTRIBUTE_FOR_USER = "sAMAccountName";
        String returnedAtts[] = {"sn", "givenName", "mail"};
        String searchFilter = "(&(objectClass=user)(" + ATTRIBUTE_FOR_USER + "=" + username + "))";
        //Create the search controls

        SearchControls searchCtls = new SearchControls();
        searchCtls.setReturningAttributes(returnedAtts);
        //Specify the search scope

        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        String searchBase = dn;
        Hashtable environment = new Hashtable();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        //Using starndard Port, check your instalation

        environment.put(Context.PROVIDER_URL, "ldap://" + host + ":389");
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");

        //environment.put(Context.SECURITY_PRINCIPAL, username + "@" + _domain);
        environment.put(Context.SECURITY_PRINCIPAL, username);
        environment.put(Context.SECURITY_CREDENTIALS, password);
        LdapContext ctxGC = null;
        try {
            ctxGC = new InitialLdapContext(environment, null);
            //    Search for objects in the GC using the filter

            NamingEnumeration answer = ctxGC.search(searchBase, searchFilter, searchCtls);
            while (answer.hasMoreElements()) {
                SearchResult sr = (SearchResult) answer.next();
                Attributes attrs = sr.getAttributes();
                if (attrs != null) {
                    //return attrs;
                }
            }

        } catch (NamingException e) {
            System.out.println("authenticateUser: " + e.toString());
            e.printStackTrace();
        }
    //return null;
    }
}
