<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="search_glevel != null">
<s:select name="search_officename" list="officenames"
			required="true"
			theme="simple"
			cssStyle="width:250px"
			headerKey="-1" 
			headerValue="-Select-"
			>
</s:select>
</s:if> 

