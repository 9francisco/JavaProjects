<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>


<h4>HOME &gt; Reference Tables &gt; Users</h4>
<hr />

<div>
	<a href="<s:url action="displayUsers.action" />" id="sysUsersButton" class="btnTabLinks" >System Users</a>
	<a href="#" id="roleButton" class="btnTabLinksSel">Roles</a>
	<a href="<s:url action="displayUserPrivileges.action" />" id="privButton" class="btnTabLinks">Privileges</a>
</div>
<br class="clearfloat" />
	
<!-- Content of Tab System User -->
<div id="role_area">	

	<table width="957" class="mainTabContainer">
	<s:if test="%{map.view != 'success-page'}">
	<tr>
		<td width="716"><br />
			<div>
				<a href="<s:url action="addRole" />"><img src="images/icon_add2_sm.jpg" alt="add" border="0"></a>
      		</div>
		</td>
	</tr>
	<tr>
		<td>
        	<div class="listInd" width="939" border="0">
          		<table width="921" border="0" class="tablesorter" id="tblListDetails">
          		<thead>
					<tr>
						<th width="100" class="tblColHeader">Role Code</th>
						<th width="225" class="tblColHeader">Description</th>
					</tr>
				</thead>
				<tbody>	
					<s:iterator value="roles" status="status">
					<tr id="<s:property value="roleCode" />" class="mouseOutDetails" onmouseover="mouse_overDetails(this.id)" onmouseout="mouse_outDetails(this.id)" onclick="getRecord(this.id, 'viewRoleDetails')">
						<td class="paddingDetails"><s:property value="roleCode" /></td>
						<td class="paddingDetails"><s:property value="roleDescription" /></td>
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
			
			<!-- Add Roles -->
			<s:if test="%{map.view == 'add'}">
			<div id="role_add_area" >
				<jsp:include page="roleAdd.jsp" />
			</div>
			</s:if>

			<!-- Edit Roles -->
			<s:if test="%{map.view == 'edit'}">
			<div id="role_edit_area" >
				<jsp:include page="roleAdd.jsp" />
			</div>
			</s:if>		
						
			<!-- View Roles -->
			<s:if test="%{map.view == 'view'}">
			<div>
				<jsp:include page="roleView.jsp" />
			</div>
			</s:if>		

			<!-- Success/Error Message -->
			<s:if test="%{map.view == 'success-page'}">
			<div id="role_success_area" >
				<jsp:include page="roleSuccessPage.jsp" />
			</div>
			</s:if>


		</td>
	</tr>
</table>
<br />
</div>
