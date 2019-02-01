<%@taglib uri="/struts-tags" prefix="s"%> 

<br /><br />

<script type="text/javascript">

var errormsg = '';

function validate()
{

    var validated = '';


    if (document.pword.oldpassword.value==""){
        validated = 'no';
        errormsg = ' enter your old password.';
    }else if (document.pword.newpassword.value==""){
        validated = 'no';
        errormsg = ' enter a new password';
    }else if (document.pword.oldpassword.value==document.pword.newpassword.value){
        validated = 'no';
        errormsg = ' do not use the same password again.';
	}else if (document.pword.confirmpassword.value==""){
	    validated = 'no';
	    errormsg = ' confirm your new password.';
	}
    else if (document.pword.newpassword.value!=document.pword.confirmpassword.value){
        validated = 'no';
        errormsg = ' check your new passwords.';
    }

    if (validated == ''){
        document.changepassword.submit();
    }else{
        alert ('Please' + errormsg);
        return false;
    }

}
</script>

<s:form name="pword" action="modifyPassword" method="post" theme="simple" onsubmit="JavaScript:if(!validate()){return false;}" >
<div class="formTitle">
	<span style="float:left">Change Password</span>
		<a href="<s:url action="accountSettings.action" />"><img src="images/btn_cancel2.jpg" alt="cancel" border="0" style="float:right"></a>
		<s:submit type="image" theme="simple" src="images/btn_save2.jpg" cssStyle="float:right"></s:submit>
	<br />
</div>

	<!-- Success/Error Message -->
	<s:if test="%{map.view == 'success-page'}">
	<div id="password_success_area" >
		<jsp:include page="modifyPasswordSuccess.jsp" />
	</div>
	</s:if>

<s:hidden name="user.password" />
<s:hidden name="user.userID" value="#session.userid"/>
<br />

<table border="0">
	<tr>
		<td class="formFields">Old Password:</td>
		<td><s:password name="oldpassword"  size="40" theme="simple" /></td>
	</tr>

	<tr>
		<td class="formFields">New Password:</td>
		<td><s:password name="newpassword"  size="40" theme="simple" /></td>
	</tr>
	<tr>
		<td class="formFields">Confirm Password:</td>
		<td><s:password name="confirmpassword"  size="40" theme="simple"/></td>
	</tr>
</table>
</s:form>
<br /><br />





