<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>EIS - OPM Login</title>
<!--[if IE 5]>
<style type="text/css">
/* place css box model fixes for IE 5* in this conditional comment */
.twoColFixLtHdr #sidebar1 { width: 230px; }
</style>
<![endif]--><!--[if IE]>
<style type="text/css">
/* place css fixes for all versions of IE in this conditional comment */
.twoColFixLtHdr #sidebar1 { padding-top: 30px; }
.twoColFixLtHdr #mainContent { zoom: 1; }
/* the above proprietary zoom property gives IE the hasLayout it needs to avoid several bugs */
</style>
<![endif]-->
<link href="css/layout2.css" rel="stylesheet" type="text/css" />
</head>

<body >
<center>
<br />
<table class="login">
	<tr>
		<td class="login" valign="top" style="background: url(images/login.jpg);height:50px;">&nbsp;</td>
	</tr>
	<tr>
		<td>
		<div>
		<br />
		<s:form action="loginUser" method="post" theme="simple">
		<table align="center">
			<tr>
				<td class="formFields">USER ID:</td>
				<td ><s:textfield name="user.userID" size="10" theme="simple" cssStyle="width:100px" /></td>
			</tr>
			<tr>
				<td class="formFields">PASSWORD:</td>
				<td ><s:password name="user.password"  size="10" theme="simple" cssStyle="width:100px"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="right"><s:submit method="authenticate" value="%{getText('button.label.login')}" align="center" /></td>
			</tr>
		</table>
		</s:form>
		<br />
		</div>
		</td>
	</tr>
</table>
<a href="Page1.html" style="color:#ccc; font-family: arial; font-size: 10px;"> enter </a>
</center>
</body>
</html>

