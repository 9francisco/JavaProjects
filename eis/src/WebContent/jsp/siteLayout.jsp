<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<jsp:directive.include file="/includes/include.jsp"/>
<s:if test="#session.logged!='true'">
<jsp:forward page="login.jsp" /> 
</s:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>
<link href="css/opmMain.css" rel="stylesheet" type="text/css" />
<link href="css/tablesorter/blue/style.css" rel="stylesheet" type="text/css"/>
<link href="css/redmond/jquery-ui-1.8.2.custom.css" rel="stylesheet" type="text/css"/>
<script src="jscript/main.js" type="text/javascript"></script>
<script src="jscript/menu.js" type="text/javascript"></script>
<script src="jscript/jquery.js" type="text/javascript"></script>
<script src="jscript/jquery.tablesorter.js" type="text/javascript"></script>
<script src="jscript/jquery.ui.core.js" type="text/javascript"></script>
<script src="jscript/jquery.ui.datepicker.js" type="text/javascript"></script>
<script src="jscript/custom.js" type="text/javascript"></script>
</head>

<body class="twoColFixLtHdr">
<div id="container">
  <div id="header">
	<tiles:insertAttribute name="header" />
  </div>
  
  <div id="topMenu1">
	<tiles:insertAttribute name="topMenu1" />
  </div>
  
  <div id="topMenu2">
 	<tiles:insertAttribute name="topMenu2" />
  </div>
  
  <div id="mainContent">
 	<tiles:insertAttribute name="mainContent" />
    <!-- end #mainContent -->
  </div>
  
	<!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats --><br class="clearfloat" />

  <div id="footer">
	<tiles:insertAttribute name="footer" />	
  <!-- end #footer --></div>

<!-- end #container -->
</div>
</body>
</html>