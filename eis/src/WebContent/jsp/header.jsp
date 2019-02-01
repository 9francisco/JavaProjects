<%@include file="/includes/include.jsp"%>

    <br />
    <br />
    <br />
    <br />
    <span style="float:right; padding-top:10px">
	             <s:url action="accountSettings" id="as">
                    <s:param name="user.userID" value="#session.userid"/>
                </s:url>
		<a href="<s:property value="#as"/>" class="bannerLinks">account settings</a> |
        <a href="<s:url action="logoutUser.action" />" class="bannerLinks">logout</a> |
        <a href="#" class="bannerLinks">help</a>
    </span>

    <p><!-- end #header -->
    </p>