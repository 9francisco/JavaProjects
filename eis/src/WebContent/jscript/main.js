function getRecord(id, module)
{
	if (module == "viewUserDetails")
	{
		location.href = "viewUserDetails.action?user.userID="+id;
	}
	
	if (module == "viewRoleDetails")
	{
		location.href = "viewRoleDetails.action?role.roleCode="+id;
	}

	if (module == "viewUserPrivilegeDetails")
	{
		location.href = "viewUserPrivilegeDetails.action?userprivilege.userprivilegeCode="+id;
	}

	if (module == "viewOfficeDetails")
	{
		location.href = "viewOfficeDetails.action?office.officeCode="+id;
	}	
	
}

function getRecordEdit(id, module)
{
	if (module == "editUserInput")
	{
		location.href = "editUserInput.action?user.Id="+id;
	}
	
	if (module == "editRoleInput")
	{
		location.href="editRoleInput.action?role.Id="+id;
	}
	
	if (module == "editUserPrivilegeInput")
	{
		location.href="editUserPrivilegeInput.action?userprivilege.Id="+id;
	}
	
	if (module == "editOfficeInput")
	{
		location.href="editOfficeInput.action?office.officeCode="+id;
	}	
	
	if (module == "editStrategyMetricBSCInput")
	{
		location.href = "editStrategyMetric.action?search_strategyMetricName=BSC&&strategyMetric="+id;
	}
	
	if (module == "editStrategyMetricCTInput")
	{
		location.href = "editStrategyMetric.action?search_strategyMetricName=CT&&strategyMetric="+id;
	}
	
	if (module == "editStrategyMetricPAInput")
	{
		location.href = "editStrategyMetric.action?search_strategyMetricName=PA&&strategyMetric="+id;
	}
	
}

function deleteRecord(id, module)
{
	if (id != null)
	{
		var answer = confirm("Are you sure you want to delete this record?");
		
		if (answer)
		{
			
			if (module == "deleteUser")
			{
				window.location = "deleteUser.action?user.Id="+id;
			}
			
			if (module == "deleteRole")
			{
				window.location = "deleteRole.action?role.Id="+id;
			}
			
			if (module == "deleteUserPrivilege")
			{
				window.location = "deleteUserPrivilege.action?userprivilege.Id="+id;
			}

			if (module == "deleteOffice")
			{
				location.href = "deleteOffice.action?office.officeCode="+id;
			}			
			
		}
		else
		{
			alert ("Record not deleted.");
		}
	}

}



function mouse_overDetails(id)
{
	document.getElementById(id).className='mouseOverDetails';
}

function mouse_outDetails(id)
{
	document.getElementById(id).className='mouseOutDetails';
}

function OpenPopup (c) 
{
	window.open(c,
	'_blank',
	'width=490,height=500,scrollbars=yes,resizable=no,toolbar=no,directories=no,location=no,menubar=no,status=no,left=50,top=50');
}

function OpenPopup2 (c) 
{
	window.open(c,
	'_blank',
	'width=760,height=500,scrollbars=yes,resizable=no,toolbar=no,directories=no,location=no,menubar=no,status=no,left=50,top=50');
}

function showSubPage(page){
	//hideSubAll();
	document.getElementById(page).style.display = "block";
}

function hideSubPage(page){
	document.getElementById(page).style.display = "none";
}
