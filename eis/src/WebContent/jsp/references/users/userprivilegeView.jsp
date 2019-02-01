<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="indicatorForm">
<s:form action="addUserPrivilegeSave" method="POST" name="userprivilegeForm"> 
	<div class="formTitle">
		<span style="float:left">USER PRIVILEGE DETAILS</span>
		<s:if test="%{map.view == 'view'}">
			<a id="<s:property value="userprivilege.Id"/>" href="#" onclick="deleteRecord(this.id, 'deleteUserPrivilege')"><img src="images/btn_delete.jpg" alt="delete" border="0" style="float:right"></a>
			<a id="<s:property value="userprivilege.Id"/>" href="#" onclick="getRecordEdit(this.id, 'editUserPrivilegeInput')"><img src="images/btn_edit.jpg" alt="edit" border="0" style="float:right"></a>
		</s:if>
		<br />
	</div>
	<br />
	
	<table width="733" border="0">
		<tr>
			<td colspan="4">
				<div>
					<table width="900">
						<tr>
							<td width="130" class="formFields">Privilege Code:</td>
							<td width="150"><s:textfield name="userprivilege.userprivilegeCode"  size="10" readonly="true"/></td>

							<td width="130" class="formFields">Description:</td>
							<td width="368"><s:textfield name="userprivilege.userprivilegeDesc"  size="50" readonly="true"/></td>

							<td width="200">&nbsp;</td>
						</tr>
						<tr>
              				<td width="130" class="formFields">Sub-Module:</td>
              				<td width="150"><s:textfield name="userprivilege.userprivilegeSubmodule"  size="25" readonly="true"/></td>

              				<td width="130" class="formFields">Function:</td>
              				<td width="150"><s:textfield name="userprivilege.userprivilegeFunc"  size="25" readonly="true"/></td>

              				<td width="200">&nbsp;</td>
						</tr>
						<tr>
              				<td width="130" class="formFields">Status:</td>
              				<td width="150">
								<s:textfield name="userprivilege.userprivilegeStatus" size="15" readonly="true"/>              				
              				</td>
              				<td width="130" class="formFields">Appointable:</td>
              				<td width="150">
              				<s:textfield name="userprivilege.userprivilegeAppointable" size="5" readonly="true"/>
              				<s:hidden name="userprivilege.Id" /></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<br />
</s:form>
</div>

    
