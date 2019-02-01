<%@ taglib prefix="s" uri="/struts-tags" %>



<h4>HOME &gt; Reference Tables &gt; Indicators &gt; Requested Indicators</h4>
<hr />

<div>
	<a href="#" id="standardIndButton" class="btnTabLinksSel" >Requested Indicators</a>
</div>
<br class="clearfloat" />

<!-- Content of Tab Requested Indicators -->
<div>

	<table width="957" class="mainTabContainer">
	<s:if test="%{map.view != 'success-page'}">
		<tr>
            <td width="716"><br />
              <div class="subSearch" width="920" border="0">
              <s:form action="displayRequestedIndicators" method="POST" id="search_perfYear">
                <table width="920" border="0" class="subSearch">
                  <tr>
                    <td width="110" height="19" class="formFields">Performance Year:</td>
                    <td width="50">
						<s:select name="search_year"
								list="{' -Select- ','2009','2010','2011','2012','2013','2014'}"
								required="true"					
						/>                    
                    </td>
                    <td width="50" height="19" class="formFields">View:</td>
                    <td width="70">
						<s:select name="search_view"
								list="{' -Select- ','All','Pending','Approved','Disapproved'}"
								required="true"					
						/>                    
                    </td>
                    
                    <td width="15"><s:submit type="button" label="GO" cssClass="btnLinks" /></td>
                    <td width="200">&nbsp;</td>

					<td width="80">&nbsp;</td>
					<td width="80"><a href="#"  class="btnLinks1">EXPORT</a></td>
					
                  </tr>
                </table>
                </s:form>
              </div>
              <br /></td>
          </tr>
	<tr>
		<td>
        	<div class="listInd" width="939" border="0">
				<table width="921" border="0" class="tblDetails">
					<tr>
		              <th width="18" height="18">&nbsp;</th>
		              <th width="135" class="tblColHeader">Office</th>
		              <th width="286" class="tblColHeader">Performance Indicator</th>
		              <th width="125" class="tblColHeader">Status</th>
		              <th width="286" class="tblColHeader">Approved Performance Indicator</th>
					</tr>
					
					<s:iterator value="requestedIndicators" status="status">
            		<tr id="<s:property value="indicatorRequestNo"/>" class="mouseOutDetails" onmouseover="mouse_overDetails(this.id)" onmouseout="mouse_outDetails(this.id)" onclick="getRecord(this.id, 'viewStandardIndicatorDetails')">
						<td width="10" class="nowrap">&nbsp;</td>
			            <td class="nowrap"><s:property value="indicatorOfficeCode"/></td>							
           		        <td class="nowrap"><s:property value="indicatorPerfAreaCode"/></td>
			            <td class="nowrap"><s:property value="indicatorRequestStatus"/></td>
			            <td class="nowrap"><s:property value="indicatorApprovedIndicatorCode"/></td>			            
					</tr>
					</s:iterator>
            	</table>
          		<br />
			</div>
			<br />
			
		</td>
	</tr>
	</s:if>
	<tr>
		<td><br />
			

			<!-- s:property value="#session.view" / -->	
			<!-- s:property value="map.view"/ -->		
			
			<!-- View Request -->
			<s:if test="%{map.view == 'view'}">
			<div id="standardIndicators_add_area" >
				<jsp:include page="requestedIndicatorView.jsp" />
			</div>
			</s:if>

			<!-- Success/Error Message -->
			<s:if test="%{map.view == 'success-page'}">
			<div id="user_success_area" >
				<jsp:include page="requestedIndicatorSuccess.jsp" />
			</div>
			</s:if>


		</td>
	</tr>
	</table>

<br />
</div>


    
