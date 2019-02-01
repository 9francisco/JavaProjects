<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:property value="map.populate" />
<s:if test="%{map.populate == 'privileges'}">
	
	<!-- s:checkboxlist name="listPrivilegesAssigned" list="listPrivileges"
					required="true" -->
	<!-- /s:checkboxlist -->	
	
	<s:property value="listPrivileges"/>
	<!--  s:property value="listSelectedPrivileges" /-->

</s:if> 


