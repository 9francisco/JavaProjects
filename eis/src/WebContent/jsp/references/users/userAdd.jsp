<%@taglib uri="/struts-tags" prefix="s"%> 

<div class="indicatorForm">
<s:form action="addUserSave" method="post" theme="simple" name="userForm">
	<div class="formTitle">
		<span style="float:left">SYSTEM USER FORM</span>
		<s:if test="%{map.view == 'add'}">
			<a href="#" onclick="hideSubPage('user_add_area');"><img src="images/btn_cancel2.jpg" alt="cancel" border="0" style="float:right"></a>
		</s:if>

		<s:if test="%{map.view == 'edit'}">
			<a href="#" onclick="hideSubPage('user_edit_area');"><img src="images/btn_cancel2.jpg" alt="cancel" border="0" style="float:right"></a>
		</s:if>
	
		<s:submit type="image" theme="simple" src="images/btn_save2.jpg" cssStyle="float:right"></s:submit>
		<br />
	</div>
	<br />

	<table width="900" border="0">
		<tr>
			<td width="315" class="formFields">User ID:</td>
			<td width="368"><s:textfield name="user.userID" size="40"  tabindex="1" /></td>
			
			<td width="315" class="formFields">Role:</td>
			<td width="368"><s:textfield name="role.roleCode"  size="5" tabindex="2" /></td>
		</tr>

		<tr>
			<td class="formFields">Default Office:</td>
			<td colspan="2">
				<s:select name="user.officeCode"
						list="officesDropdown"
						required="true"
						listKey="officeCode"
						listValue="officeDesc"	
				/>
			</td>
		</tr>
		
        <tr><td colspan="3"><br/ ></td></tr>
        
		<tr>
			<td class="formFields">Last Name:</td>
			<td><s:textfield name="user.lastName" size="40" tabindex="4" /></td>
						
			<td class="formFields">Contact No:</td>
			<td><s:textfield name="user.contactNo"  size="40" tabindex="7" /></td>	
		</tr>
		
		<tr>
			<td class="formFields">Middle Initial:</td>
			<td><s:textfield name="user.middleInitial" size="5" tabindex="5" /></td>

			<td class="formFields">Email:</td>
			<td><s:textfield name="user.email"  size="40" tabindex="8" /></td>

		</tr>
		
		<tr>
			<td class="formFields">First Name:</td>
			<td><s:textfield name="user.firstName "size="40" tabindex="6" /></td>

			<td class="formFields">CC:</td>
			<td><s:textfield name="user.email2"  size="40" tabindex="9" /></td>
		</tr>

		<tr><td colspan="4"><br /><hr/ ></td></tr>

		<tr>
			<td colspan="4"><s:hidden name="user.Id" /><s:hidden name="user.password" /><s:hidden name="user.deleted" /></td>
		</tr>

		<tr>
			<td colspan="4" align="right">
				<a href="#"><img src="images/btn_privileges.jpg" alt="cancel" border="0" style="float:right"></a>
			</td>
		</tr>
	</table>


</s:form>

</div>

