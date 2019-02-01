<%@taglib uri="/struts-tags" prefix="s"%> 
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<div class="indicatorForm">
<s:form action="addOfficeSave" method="post" theme="simple">
	<div class="formTitle">
		<span style="float:left">OFFICE FORM</span>
		<s:if test="%{map.view == 'add'}">
			<a href="#" onclick="hideSubPage('officeDetails_add_area');"><img src="images/btn_cancel2.jpg" alt="cancel" border="0"  style="float:right"></a>
		</s:if>

		<s:if test="%{map.view == 'edit'}">
			<a href="#" onclick="hideSubPage('officeDetails_edit_area');"><img src="images/btn_cancel2.jpg" alt="cancel" border="0"  style="float:right"></a>
		</s:if>

		<s:submit type="image" theme="simple" src="images/btn_save2.jpg" cssStyle="float:right"></s:submit>
		<br />
	</div>
	<br />

	<table width="733" border="0">
		<tr>
			<td width="315" class="formFields">Office Name:</td>
			<td width="368"><s:textfield name="office.officeDesc" size="50" theme="simple"/></td>
			
			<td width="315" class="formFields">Office Code:</td>
			<td width="368"><s:hidden name="office.deleted" /><s:hidden name="office.Id" /><s:textfield name="office.officeCode"  size="20" theme="simple"/></td>
		</tr>
		<tr>
			<td width="110" height="19" class="formFields">Office Head:</td>
			<td>
				<s:select name="office.officeHeadManNo"
						list="systemUsers"
						required="true"
						listKey="userID"
						listValue="%{lastName + ', ' + firstName + ' ' + middleInitial}"		
						value="assignedOfficeHead"	
						headerKey="-1" 
						headerValue="-Select-"
				/>
			</td>		
		</tr>
		
		<tr><td colspan="4"><br /><hr/ ><br /></td></tr>

		<tr>
			<td width="442" valign="top" colspan="2">
				<!--span class="boxTitleHead2">&nbsp;Hierarchy&nbsp;</span-->
				<div class="detLeft2" style="height:150px">
					<table width="430" border="0">
						<tr>
							<td width="110" height="19" class="formFields">Hierarchy Level:</td>
							<td colspan="2">
								<s:select name="office.officeGLevel"
										list="{'G0','G1','G2','G3','G4'}"
										required="true"
										theme="simple"						
								/>
							</td>
						</tr>
						<tr>
							<td class="formFields">Hierarchy Code:</td>
							<td colspan="2"><s:textfield name="office.officeHierarchy"  size="5" theme="simple"/></td>
						</tr>
						<tr>
							<td class="formFields">Effective Date [Start]:</td>
							<td><sx:datetimepicker name="office.effDateStart"/></td>
						</tr>
						<tr>
							<td class="formFields">[End]:</td>
							<s:if test="%{map.view == 'add'}">
								<td><sx:datetimepicker name="office.effDateEnd" value="%{'12/31/2099'}"  /></td>
							</s:if>
							<s:if test="%{map.view == 'edit'}">
							<td><sx:datetimepicker name="office.effDateEnd"/></td>
							</s:if>							
							
						</tr>
					</table>
				</div>
			</td>		
			<td valign="top" colspan="2">
				<!--span class="boxTitleHead2">&nbsp;Office Head&nbsp;</span-->
				<div class="detLeft2" style="height:150px">
					<table width="430" border="0">
						<tr>
							<td class="formFields">PCT of the Office:</td>
							<td>
								<!--s:select name="office.pctOffice"
										list="{'OC000001','OC000002', 'OC000003', 'OC000004'}"
										theme="simple"	
										cssStyle="width:330px"
								/-->
								<s:select name="office.pctOffice"
										list="officesDropdown"
										required="true"
										listKey="officeCode"
										listValue="officeDesc"		
								/>
							</td>						
						</tr>
						<tr>
							<td class="formFields">Excellence Awards Category:</td>
							<td>
								<s:select name="office.awardsCategory"
										list="{'AC000001', 'AC000002', 'AC000003', 'AC000004'}"
										theme="simple"
										cssStyle="width:250px"
								/>
							</td>						
						</tr>
					</table>
				</div>
			</td>

		</tr>
	</table>


</s:form>

</div>

