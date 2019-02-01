<%@ taglib prefix="s" uri="/struts-tags" %>

<h4>HOME &gt; Reference Tables &gt; Users</h4>
<hr />

<div>
	<a href="<s:url action="displayUsers.action" />" id="sysUsersButton" class="btnTabLinks" >System Users</a>
	<a href="<s:url action="displayRoles.action" />" id="roleButton" class="btnTabLinks">Roles</a>
	<a href="#" id="privButton" class="btnTabLinksSel">User Privileges</a>
</div>
<br class="clearfloat" />
	
<!-- Content of Tab System User -->
<div id="userprivilege_area">	

	<table width="957" class="mainTabContainer">
	<s:if test="%{map.view != 'success-page'}">
	<tr>
		<td width="716"><br />
			<div>
				<a href="<s:url action="addUserPrivilege" />"><img src="images/icon_add2_sm.jpg" alt="add" border="0"></a>
      		</div>
		</td>
	</tr>

	<tr>
		<td>
			<div class="listInd" width="939" border="0">
				<table width="921" border="0" class="tablesorter" id="tblListDetails">
				<thead>
					<tr>
						<th width="50" class="tblColHeader">Privilege Code</th>
						<th width="100" class="tblColHeader">Description</th>
						<th width="100" class="tblColHeader">Sub-Module</th>
						<th width="100" class="tblColHeader">Function</th>
						<th width="100" class="tblColHeader">Status</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="userprivileges" status="status">
            		<tr id="<s:property value="userprivilegeCode" />" class="mouseOutDetails" onmouseover="mouse_overDetails(this.id)" onmouseout="mouse_outDetails(this.id)" onclick="getRecord(this.id, 'viewUserPrivilegeDetails')">
           		        <td class="paddingDetails"><s:property value="userprivilegeCode"/></td>
			            <td class="paddingDetails"><s:property value="userprivilegeDesc"/></td>
			            <td class="paddingDetails"><s:property value="userprivilegeSubmodule"/></td>
			            <td class="paddingDetails"><s:property value="userprivilegeFunc"/></td>
			            <td class="paddingDetails"><s:property value="userprivilegeStatus"/></td>
					</tr>
					</s:iterator>
				</tbody>	
            	</table>
          		<br />
			</div>
		</td>
	</tr>
	</s:if>
          
	<tr>
		<td>
			<!-- s:property value="#session.view" / -->	
			<!-- s:property value="map.view"/ -->		
			
			<!-- Add UserPrivileges -->
			<s:if test="%{map.view == 'add'}">
			<div id="userprivilege_add_area" >
				<jsp:include page="userprivilegeAdd.jsp" />
			</div>
			</s:if>

			<!-- Edit UserPrivileges -->
			<s:if test="%{map.view == 'edit'}">
			<div id="userprivilege_edit_area" >
				<jsp:include page="userprivilegeAdd.jsp" />
			</div>
			</s:if>		
						
			<!-- View UserPrivileges -->
			<s:if test="%{map.view == 'view'}">
			<div>
				<jsp:include page="userprivilegeView.jsp" />
			</div>
			</s:if>		

			<!-- Success/Error Message -->
			<s:if test="%{map.view == 'success-page'}">
			<div id="userprivilege_success_area" >
				<jsp:include page="userprivilegeSuccessPage.jsp" />
			</div>
			</s:if>

		</td>
	</tr>
</table>
<br />
</div>
