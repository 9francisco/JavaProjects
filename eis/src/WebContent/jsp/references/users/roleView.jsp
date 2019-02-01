<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="indicatorForm">
<s:form action="addRoleSave" method="POST" name="roleForm"> 
	<div class="formTitle">
		<span style="float:left">ROLE DETAILS</span>
		<s:if test="%{map.view == 'view'}">
			<a id="<s:property value="role.Id"/>" href="#" onclick="deleteRecord(this.id, 'deleteRole')"><img src="images/btn_delete.jpg" alt="delete" border="0" style="float:right"></a>
			<a id="<s:property value="role.Id"/>" href="#" onclick="getRecordEdit(this.id, 'editRoleInput')"><img src="images/btn_edit.jpg" alt="edit" border="0" style="float:right"></a>
		</s:if>
		<br />
	</div>
	<br />
	<table width="900" border="0">
		<tr>
			<td width="70" class="formFields">Role Code:</td>
			<td width="70"><s:textfield name="role.roleCode" size="10" readonly="true"/></td>
			<td width="50" class="formFields" style="text-align:left">Description:</td>
			<td width="300"><s:textfield name="role.roleDescription" size="50" readonly="true"/></td>						
		</tr>

		<tr><td colspan="4"><br /><s:hidden name="role.Id" /><hr/ ><br /></td></tr>

		<tr>
			<td class="formFields">Privileges:<br /></td>
			<td colspan="3">&nbsp;</td>
		</tr>

		<s:iterator value="assignedPrivileges" status="status">
		<tr>
			<td>&nbsp;</td>
			<td class="nowrap"><s:property value="rolePrivilegeDescription" /><s:hidden value="rolePrivilegeCode" /></td>
		</tr>
		</s:iterator>

			

	</table>
	<br />
</s:form>
</div>

    
