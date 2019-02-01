<%@taglib uri="/struts-tags" prefix="s"%> 
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<div class="indicatorForm">
<s:form action="addOfficeSave" method="post" theme="simple">
	<div class="formTitle">
		<span style="float:left">OFFICE DETAILS</span>
		<s:if test="%{map.view == 'view'}">
			<a id="<s:property value="office.officeCode"/>" href="#" onclick="deleteRecord(this.id, 'deleteOffice')"><img src="images/btn_delete.jpg" alt="delete" border="0" style="float:right"></a>
			<a id="<s:property value="office.officeCode"/>" href="#" onclick="getRecordEdit(this.id, 'editOfficeInput')"><img src="images/btn_edit.jpg" alt="edit" border="0" style="float:right"></a>
		</s:if>		
		<br />
	</div>
	<br />

	<table width="733" border="0">
		<tr>
			<td width="315" class="formFields">Office Name:</td>
			<td width="368"><s:textfield name="office.officeDesc" size="50" readonly="true"/></td>
			
			<td width="315" class="formFields">Office Code:</td>
			<td width="368"><s:hidden name="office.deleted" /><s:hidden name="office.Id" /><s:textfield name="office.officeCode"  size="20" readonly="true"/></td>
		</tr>
		<tr>
			<td width="110" height="19" class="formFields">Office Head:</td>
			<td>
				<s:select name="office.officeHeadManNo"
						list="systemUsers"
						required="true"
						listKey="userID"
						listValue="%{lastName + ', ' + firstName + ' ' + middleInitial}"	
						disabled="true"	
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
										disabled="true"					
								/>
							</td>
						</tr>
						<tr>
							<td class="formFields">Hierarchy Code:</td>
							<td colspan="2"><s:textfield name="office.officeHierarchy"  size="5" readonly="true"/></td>
						</tr>
						<tr>
							<td class="formFields">Effective Date [Start]:</td>
							<td><sx:datetimepicker name="office.effDateStart" disabled="true"/></td>
						</tr>
						<tr>
							<td class="formFields">[End]:</td>
							<td><sx:datetimepicker name="office.effDateEnd" disabled="true"/></td>
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
								<s:select name="office.pctOffice"
										list="officesDropdown"
										required="true"
										listKey="officeCode"
										listValue="officeDesc"	
										disabled="true"	
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
										disabled="true"
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

