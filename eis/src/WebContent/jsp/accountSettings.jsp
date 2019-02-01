<%@taglib uri="/struts-tags" prefix="s"%> 

<br /><br />

	             <s:url action="changePassword" id="cp">
                    <s:param name="user.userID" value="#session.userid"/>
                </s:url>
<div class="formTitle">
	<span style="float:left">User Profile</span>
	<a href="<s:property value="#cp"/>">
	<!-- a href="jsp/changePassword.jsp" / -->
	<img src="images/btn_changePass.jpg" alt="change password" border="0" style="float:right"></a>

	<br />
</div>
	
<br />
<table border="0">
	<tr>
		<td class="fieldName">User ID:</td>
		<td><s:property value="user.userID"/></td>
	</tr>
	<tr>
		<td class="fieldName">Role:</td>
		<td><s:property value="user.roleCode"/></td>
	</tr>

	<tr>
		<td class="fieldName">Default Office:</td>
		<td><s:property value="user.officeCode"/></td>
	</tr>

	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>

	<tr>
		<td class="fieldName">Name:</td>
		<td><s:property value="user.firstName"/>&nbsp;<s:property value="user.middleInitial"/>&nbsp;<s:property value="user.lastName"/></td>
	</tr>

	<tr>
		<td class="fieldName">Contact No:</td>
		<td><s:property value="user.contactNo"/></td>
	</tr>
	<tr>
		<td class="fieldName">Email:</td>
		<td><s:property value="user.email"/></td>
	</tr>
	<tr>
		<td class="fieldName">CC:</td>
		<td><s:property value="user.email2"/></td>
	</tr>
	
</table>

<br /><br />




