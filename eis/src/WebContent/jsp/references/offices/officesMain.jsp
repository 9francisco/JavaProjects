<h4>HOME &gt; Reference Tables &gt; Offices</h4>
<hr />

<div>
	<a href="#" id="officeDetailsButton" class="btnTabLinksSel" onclick="showPage('officeDetails_area',this.id)";>Office Details</a>
	<a href="#" id="uploadOfficesButton" class="btnTabLinks" onclick="showPage('uploadOffices_area', this.id);">Upload Offices</a>
</div>
<br class="clearfloat" />

<!-- Content of the Tabs -->
<div id="officeDetails_area">
	<jsp:include page="officeDetails.jsp"/>
</div>
<div id="uploadOffices_area">
	<!--  jsp:include page="uploadOffices.jsp"/ -->
</div>
