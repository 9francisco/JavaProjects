<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="indicatorForm">
<s:form action="addUserPrivilegeSave" method="POST" name="userprivilegeForm"> 
	<div class="formTitle">
		<span style="float:left">USER PRIVILEGE FORM</span>
		<s:if test="%{map.view == 'add'}">
			<a href="#" onclick="hideSubPage('userprivilege_add_area');"><img src="images/btn_cancel2.jpg" alt="cancel" border="0"  style="float:right"></a>
		</s:if>

		<s:if test="%{map.view == 'edit'}">
			<a href="#" onclick="hideSubPage('userprivilege_edit_area');"><img src="images/btn_cancel2.jpg" alt="cancel" border="0"  style="float:right"></a>
		</s:if>

		<s:submit type="image" src="images/btn_save2.jpg" cssStyle="float:right"></s:submit>
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
							<td width="150"><s:textfield name="userprivilege.userprivilegeCode"  size="10"/></td>

							<td width="130" class="formFields">Description:</td>
							<td width="368"><s:textfield name="userprivilege.userprivilegeDesc"  size="50"/></td>

							<td width="200">&nbsp;</td>
						</tr>
						<tr>
              				<td width="130" class="formFields">Sub-Module:</td>
              				<td width="150"><s:textfield name="userprivilege.userprivilegeSubmodule"  size="25"/></td>

              				<td width="130" class="formFields">Function:</td>
              				<td width="150"><s:textfield name="userprivilege.userprivilegeFunc"  size="25"/></td>

              				<td width="200">&nbsp;</td>
						</tr>
						<tr>
              				<td width="130" class="formFields">Status:</td>
              				<td width="150">
								<s:select name="userprivilege.userprivilegeStatus"
										list="{'Active','Deleted'}"
										required="true"
										
								/>              				
              				</td>
							<td class="formFields">Appointable:</td>
			              	<td>
			              		<table width="200">
			                		<tr>
				                  		<td colspan="2" width="188">
				                    		<s:radio name="userprivilege.userprivilegeAppointable" list="#{'0':'No','1':'Yes'}" value="0" />
				                    	</td>
			                		</tr>
			              		</table>
              				</td>
              				<td width="200">&nbsp;</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>

		<tr><td colspan="4"><br /><s:hidden name="userprivilege.Id" /><hr/ ><br /></td></tr>
			

	</table>
	<br />
</s:form>
</div>

    
