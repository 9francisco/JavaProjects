<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<script>
function show_details() {
dojo.event.topic.publish("show_detail");
}
</script> 
<sx:head debug="false" cache="false" compressed="true"/>
<table width="957" class="mainTabContainer">
	<s:if test="%{map.view != 'success-page'}">
	<tr>
		<td width="716"><br />
			<div class="subSearch" width="920" border="0">
			<s:form action="displayOffices" method="POST"   id="search_office">
				<table width="920" border="0" class="subSearch">
					<tr>
                  		<!--td width="150">
							<s:checkbox name="view"   fieldValue="true" value="true"/>
                  			VIEW ALL
                  		</td-->
						<td width="110" height="19" class="formFields">Hierarchy Level:</td>
						<td width="50">
							<s:select name="search_glevel"
									list="{' -Select- ','ALL','G0','G1','G2','G3','G4'}"
									required="true"
									 
									onchange="javascript:show_details();return false;" 						
							/>
                   		</td>
                    	<td width="60" height="19" class="formFields">Office:</td>

                    	<td width="30">
                    	<s:url id="d_url" action="populateOffices" />
                    	<sx:div showLoadingText="false"
						id="details" href="%{d_url}" theme="ajax"
						listenTopics="show_detail" formId="search_office">
						</sx:div> 

                    	</td>
                    	
						<td width="40"><s:submit type="button" label="GO"   cssClass="btnLinks" /></td>
						<td width="250">&nbsp;</td>
					</tr>
				</table>
            </s:form>
			</div>
		</td>
	</tr>
	<tr>
		<td width="716"><br />
			<div>
				<a href="<s:url action="addOffice" />"><img src="images/icon_add2_sm.jpg" alt="add" border="0"></a>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="listInd" width="939" border="0">
				<table width="921" border="0" class="tablesorter" id="tblListDetails">
				<thead>
					<tr>
              			<th width="286" class="tblColHeader">Office Name</th>
              			<th width="125" class="tblColHeader">Office Code</th>
              			<th width="286" class="tblColHeader">Office Head</th>
              		</tr>
              	</thead>
              	<tbody>
              		<s:iterator value="offices" status="status">
					<tr id="<s:property value="officeCode"/>" class="mouseOutDetails" onmouseover="mouse_overDetails(this.id)" onmouseout="mouse_outDetails(this.id)" onclick="getRecord(this.id,'viewOfficeDetails')">
	              		<td class="paddingDetails"><s:property value="officeDesc"/></td>
	              		<td class="paddingDetails"><s:property value="officeCode"/></td>
	              		<td class="paddingDetails"><s:hidden name="officeHeadManNo"/>,&nbsp;<s:property value="lastName"/>&nbsp;<s:property value="firstName" />,&nbsp;<s:property value="middleName"/></td>
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
			<!-- Add Offices -->
			<s:if test="%{map.view == 'add'}">
			<div id="officeDetails_add_area" >
				<jsp:include page="officeDetailsAdd.jsp" />
			</div>
			</s:if>
			
			<!-- Edit Offices -->
			<s:if test="%{map.view == 'edit'}">
			<div id="officeDetails_edit_area">
				<jsp:include page="officeDetailsAdd.jsp" />
			</div>
			</s:if>
			
			<!-- View Offices -->
			<s:if test="%{map.view == 'view'}">
			<div id="officeDetails_view_area">
				<jsp:include page="officeDetailsView.jsp" />
			</div>
			</s:if>

			<!-- Success/Error Message -->
			<s:if test="%{map.view == 'success-page'}">
			<div id="officeDetails_success_area" >
				<jsp:include page="officeDetailsSuccess.jsp" />
			</div>
			</s:if>

		</td>
	</tr>
</table>
<br />

    
