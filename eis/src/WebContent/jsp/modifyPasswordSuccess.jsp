<%@taglib uri="/struts-tags" prefix="s"%> 
<s:url action="accountSettings" id="as">
    <s:param name="user.userID" value="#session.userid"/>
</s:url>

<div style="padding:5px">
	<s:actionmessage/><a href="<s:property value="#as"/>">return to account settings</a>
</div>