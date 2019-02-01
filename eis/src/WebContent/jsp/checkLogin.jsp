<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html" import="java.util.*"%>
<html>
    <head>
        <title></title>
  </head>
    <body>
      <s:if test="#session.logged-in != 'true'">
      <jsp:forward page="../../login.jsp" />  
      </s:if>
    </body>
</html>  
