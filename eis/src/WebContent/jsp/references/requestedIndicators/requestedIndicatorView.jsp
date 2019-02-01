<%@taglib uri="/struts-tags" prefix="s"%> 

<div class="indicatorForm">
<s:form action="approveRequestedIndicatorSave" method="post" theme="simple">
	<div class="formTitle">
		<span style="float:left">REQUESTED INDICATOR DETAILS</span>
	</div>
	<br />

	<table width="733" border="0">
		<tr>
			<td width="315" class="formFields">Office Name:</td>
			<td width="368"><s:property value="office.officeDesc"/></td>
			
			<td width="315" class="formFields">Status:</td>
			<td width="368"><s:property value="office.Id" /></td>
		</tr>

       	<tr><td colspan="4"><br /><hr/ ><br /></td></tr>	

		<tr>
           	<td valign="top" colspan="2">
            	<span class="boxTitleHead2">&nbsp;REQUESTED&nbsp;</span>
               	<div class="detLeft2" style="height:150px">
                <table width="430" border="0">
                  	<tr>
                   		<td class="formFields" width="150">Balanced ScoreCard Perspective:</td>
                     	<td colspan="2"><s:property value="requestedIndicator.reqBsc"/></td>
                 	</tr>
                  	<tr>
                   		<td class="formFields">Corporate Thrust:</td>
                     	<td colspan="2"><s:property value="requestedIndicator.reqCorpThrust" /></td>
                 	</tr>
                  	<tr>
                   		<td class="formFields">Performance Area:</td>
                     	<td colspan="2"><s:property value="requestedIndicator.reqPerfArea" /></td>
                 	</tr>
                  	<tr>
                   		<td class="formFields">Performance Indicator:</td>
                     	<td colspan="2"><s:property value="requestedIndicator.reqPerfIndicator"/></td>
                 	</tr>
             	</table>
              	</div>
              	</td>

       <td width="442" valign="top" colspan="2">
              	<span class="boxTitleHead2">&nbsp;APPROVED&nbsp;</span>
               	<div class="detLeft2" style="height:150px">
                <table width="430" border="0">
                  	<tr>
                   		<td class="formFields" width="150">Balanced ScoreCard Perspective:</td>
                     	<td colspan="2"><s:property value="requestedIndicator.appBsc"/></td>
                 	</tr>
                  	<tr>
                   		<td class="formFields">Corporate Thrust:</td>
                     	<td colspan="2"><s:property value="requestedIndicator.appCorpThrust" /></td>
                 	</tr>
                  	<tr>
                   		<td class="formFields">Performance Area:</td>
                     	<td colspan="2"><s:property value="requestedIndicator.appPerfArea" /></td>
                 	</tr>
                  	<tr>
                   		<td class="formFields">Performance Indicator:</td>
                     	<td colspan="2"><s:property value="requestedIndicator.appPerfIndicator"/></td>
                 	</tr>
             	</table>
              	</div>
               	</td>
            </tr>

            <tr><td colspan="4"><br /><hr/ ><br /></td></tr>		
		
		<tr>
			<td width="110" height="19" class="formFields">Brief Description:</td>
			<td><s:property value="requestedIndicator.description"/></td>		
		</tr>
		<tr>			
			<td width="110" height="19" class="formFields">Target Goal:</td>
			<td><s:property value="requestedIndicator.description"/></td>	
		</tr>
		<tr>	
			<td width="110" height="19" class="formFields">Weight:</td>
			<td><s:property value="requestedIndicator.description"/></td>	
		</tr>
		<tr>	
			<td width="110" height="19" class="formFields">Stretch Goal:</td>
			<td><s:property value="requestedIndicator.description"/></td>	
		</tr>
		<tr>	
			<td width="110" height="19" class="formFields">In covenant?</td>
			<td><s:property value="requestedIndicator.description"/></td>							
		</tr>
		
		<tr><td colspan="4"><br /><hr/ ><br /></td></tr>

		<tr>
			<td class="formFields">System Admin Remarks:</td>
			<td colspan="3"><s:textarea name="requestedIndicator.remarks" cols="80" rows="5"/></td>
		</tr>

       	<tr>
        	<td colspan="4" align="center">
        		<br />
       			<s:submit type="button" name="Approve" id="Approve" value="Approve" />
				<s:submit type="button" name="Disapprove" id="Disapprove" value="Disapprove" />
      		</td>
       	</tr>
	</table>
</s:form>

</div>
