<%@taglib uri="/struts-tags" prefix="s"%> 

<div class="indicatorForm">

	<div class="formTitle">
		<span style="float:left">SYSTEM USER DETAILS</span>
		<s:if test="%{map.view == 'view'}">
			<a id="<s:property value="user.Id"/>" href="#" onclick="deleteRecord(this.id, 'deleteUser')"><img src="images/btn_delete.jpg" alt="delete" border="0" style="float:right"></a>
			<a id="<s:property value="user.Id"/>" href="#" onclick="getRecordEdit(this.id, 'editUserInput')"><img src="images/btn_edit.jpg" alt="edit" border="0" style="float:right"></a>
		</s:if>
		
		<br />
	</div>
	<br />

	<table width="900" border="0">
		<tr>
			<td width="315" class="formFields">User ID:</td>
			<td width="368"><s:textfield name="user.userID" size="40"   readonly="true"/></td>
			
			<td width="315" class="formFields">Role:</td>
			<td width="368"><s:textfield name="role.roleCode"  size="5"   readonly="true"/></td>
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
			<td><s:textfield name="user.lastName" size="40"  readonly="true" /></td>
						
			<td class="formFields">Contact No:</td>
			<td><s:textfield name="user.contactNo"  size="40"  readonly="true" /></td>	
		</tr>
		
		<tr>
			<td class="formFields">Middle Initial:</td>
			<td><s:textfield name="user.middleInitial" size="5"  readonly="true" /></td>

			<td class="formFields">Email:</td>
			<td><s:textfield name="user.email"  size="40"  readonly="true" /></td>

		</tr>
		
		<tr>
			<td class="formFields">First Name:</td>
			<td><s:textfield name="user.firstName"size="40"  readonly="true" /></td>

			<td class="formFields">CC:</td>
			<td><s:textfield name="user.email2"  size="40"   readonly="true"/></td>
		</tr>

		<tr>
			<td colspan="4"><s:hidden name="user.Id" /></td>
		</tr>

		<tr><td colspan="4"><br /><hr/ ></td></tr>

		<tr>
			<td colspan="4" align="right">
				<a href="#"><img src="images/btn_privileges.jpg" alt="cancel" border="0" style="float:right"></a>
			</td>
		</tr>
	</table>




</div>

