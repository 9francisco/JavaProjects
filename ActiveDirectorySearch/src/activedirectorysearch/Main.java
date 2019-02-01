/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activedirectorysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

//            LDAPClient ldap = new LDAPClient();
//            ldap.setHost("TEST123");
//            ldap.setLdapPort(389);
//            ldap.setAdminDN("cn=tassysacc,cn=Users,dc=test,dc=testgroup");
//            ldap.setAdminpasswd("tassysacc");
//            ldap.setDNSearchRoot("dc=test,dc=testgroup");
//            ldap.setUserNameDN("cn");
//            ldap.authenticate("123456", "123", false);

//*************************************
//            String line;
//            boolean more = false;
//
//            String[] cmd = {"cmd.exe", "/c", "nslookup"};
//            Pattern pattern = Pattern.compile("Default Server:");
//            Matcher matcher = pattern.matcher("");
//
//            Process p = Runtime.getRuntime().exec(cmd);
//
//            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//            while ((line = input.readLine()) != null) {
//                matcher.reset(line);
//
//                if (matcher.find()) {
//                    String[] results = line.split(": ");
//                    System.out.println(results[1].trim());
//                }
//            }
//            ADAuthenticator ad = new ADAuthenticator();
//            ad.authenticate("123456", "123");
        } catch (Exception e) {
            System.out.println("Error Main: " + e.toString());
        }
    }
}
