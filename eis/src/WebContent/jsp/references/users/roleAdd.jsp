<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<script>
function delete_privileges() {
dojo.event.topic.publish("delete_privileges");
}
function add_privileges() {
dojo.event.topic.publish("add_privileges");
}

</script> 
<sx:head debug="false" cache="false" compressed="true"/>

<div class="indicatorForm">
<s:form action="addRoleSave" method="POST" name="roleForm" id="add_role"> 
	<div class="formTitle">
		<span style="float:left">ROLE FORM</span>
		<s:if test="%{map.view == 'add'}">
			<a href="#" onclick="hideSubPage('role_add_area');"><img src="images/btn_cancel2.jpg" alt="cancel" border="0"  style="float:right"></a>
		</s:if>

		<s:if test="%{map.view == 'edit'}">
			<a href="#" onclick="hideSubPage('role_edit_area');"><img src="images/btn_cancel2.jpg" alt="cancel" border="0"  style="float:right"></a>
		</s:if>

		<s:submit type="image" src="images/btn_save2.jpg" cssStyle="float:right"></s:submit>
		<br />
	</div>
	<br />
	<table width="900" border="0">
		<tr>
			<td width="70" class="formFields">Role Code:</td>
			<td width="70"><s:textfield name="role.roleCode" size="10" /></td>
			<td width="50" class="formFields" style="text-align:left">Description:</td>
			<td width="300"><s:textfield name="role.roleDescription" size="50" /></td>						
		</tr>

		<tr><td colspan="4"><br /><s:hidden name="role.Id" /><hr/ ><br /></td></tr>
		
			<tr>
              	<td width="442" valign="top" colspan="2">
              	<span class="boxTitleHead">PRIVILEGES MASTER LIST&nbsp;</span>

               	<div class="detLeft2" style="height:200px; overflow:auto; background:#fff">
         		<table width="400" border="0" class="tblDetails">
            		<tr>
						<td>
							<s:checkboxlist name="listPrivileges" 
										list="privileges"
										required="true"
										listKey="%{userprivilegeCode}"
										listValue="%{userprivilegeDesc}"
										value="assignedPrivilegesCode"
										theme="checkboxlist-fix"
										template="checkboxlist"
										templateDir="/WEB-INF/template"
										label="Privileges">
							</s:checkboxlist>
							
						</td>
              		</tr>
            	</table>
              	</div>
              	
              	<div class="subDetailButtons" align="right">
					<table width="80" border="0">
				   	<tr>
						<td width="61" ><a href="#" onclick="javascript:add_privileges();return false;">select</a></td>
				 	</tr>
				  	</table>
           		 </div>
               	</td>

            	<td valign="top" colspan="2">
            	<span class="boxTitleHead">ASSIGNED PRIVILEGES&nbsp;</span>
            	
               	<div class="detLeft2" style="height:200px; overflow:auto; background:#fff">
         		<table width="400" border="0" class="tblDetails">
            		<tr>
            			<td>
                    	<s:url id="a_url" action="populatePrivileges" />
                    	<sx:div showLoadingText="false"
						id="details" href="%{a_url}" theme="ajax"
						listenTopics="add_privileges" formId="add_role">
						</sx:div>
						</td> 
					</tr>
            	</table>
              	</div>
              	
              	</td>

            </tr>

	</table>
	<br />
</s:form>
</div>

    
