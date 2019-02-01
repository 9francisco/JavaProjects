<%@ taglib prefix="s" uri="/struts-tags" %>



<h4>HOME &gt; Reference Tables &gt; Users</h4>
<hr />

<div>
	<a href="#" id="sysUsersButton" class="btnTabLinksSel" >System Users</a>
	<a href="<s:url action="displayRoles.action" />" id="roleButton" class="btnTabLinks">Roles</a>
	<a href="<s:url action="displayUserPrivileges.action" />" id="privButton" class="btnTabLinks">Privileges</a>
</div>
<br class="clearfloat" />

<!-- Content of Tab System User -->
<div id="sysUsers_area">

	<table width="957" class="mainTabContainer">
	<s:if test="%{map.view != 'success-page'}">
	<tr>
		<td width="716"><br />
			<div>
				<a href="<s:url action="addUser" />" ><img src="images/icon_add2_sm.jpg" alt="add" border="0"></a>
			</div>
		</td>
	</tr>
	<tr>
		<td>
        	<div class="listInd" width="939" border="0">
				<table width="921" border="0" class="tablesorter" id="tblListDetails">
				<thead>
					<tr>
						<th width="100" class="tblColHeader">User ID</th>
						<th width="100" class="tblColHeader">Last Name</th>
						<th width="50" class="tblColHeader">M.I.</th>
						<th width="100" class="tblColHeader">First Name</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="users" status="status">

            		<tr id="<s:property value="userID"/>" class="mouseOutDetails" onmouseover="mouse_overDetails(this.id)" onmouseout="mouse_outDetails(this.id)" onclick="getRecord(this.id, 'viewUserDetails')">
           		        <td class="paddingDetails"><s:property value="userID"/></td>
			            <td class="paddingDetails"><s:property value="lastName"/></td>
			            <td class="paddingDetails"><s:property value="middleInitial"/></td>
			            <td class="paddingDetails"><s:property value="firstName"/></td>				            
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
			
			<!-- Add Users -->
			<s:if test="%{map.view == 'add'}">
			<div id="user_add_area" >
				<jsp:include page="userAdd.jsp" />
			</div>
			</s:if>

			<!-- Edit Users -->
			<s:if test="%{map.view == 'edit'}">
			<div id="user_edit_area" >
				<jsp:include page="userAdd.jsp" />
			</div>
			</s:if>		
						
			<!-- View Users -->
			<s:if test="%{map.view == 'view'}">
			<div>
				<jsp:include page="userView.jsp" />
			</div>
			</s:if>		

			<!-- Success/Error Message -->
			<s:if test="%{map.view == 'success-page'}">
			<div id="user_success_area" >
				<jsp:include page="userSuccessPage.jsp" />
			</div>
			</s:if>


		</td>
	</tr>
	</table>

<br />
</div>


    
