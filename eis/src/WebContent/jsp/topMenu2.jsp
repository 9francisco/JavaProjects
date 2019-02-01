<%@include file="/includes/include.jsp"%>


<ul class="menu" id="menu">
	<li><a href="<s:url action="welcome.action" />" class="menulink">Home</a></li>
	
	<li><a href="#" class="menulink">Transactions</a>
		<ul>
			<li class="topline"><a href="#">GAP Encoding</a></li>
			<li><a href="#">GAR Encoding</a></li>
			<li><a href="#">GAP/GAR Approval</a></li>
			<li><a href="#">PCT Approval</a></li>
			<li><a href="#">Modify Automated GAR</a></li>
		</ul>
	</li>

	<li><a href="#" class="menulink">Maintenance</a>
		<ul>
			<li class="topline"><a href="<s:url action="displayOffices.action"/>">Offices</a></li>
			<li><a href="#" class="sub">Indicators</a>
				<ul>
					<li class="topline"><a href="<s:url action="strategyMetricsMng.action"/>">Strategy/Metrics Management</a></li>
					<li><a href="<s:url action="displayRequestedIndicators.action"/>">Requested Indicators</a></li>
					<li><a href="<s:url action="displayStandardIndicators.action"/>">Standard Indicators</a></li>
					<li><a href="<s:url action="displayAutoPartialIndicators.action"/>">Automated/Partial Indicators</a></li>
				</ul>
			</li>
			<li><a href="<s:url action="displayUsers.action" />">Users</a></li>
			<li><a href="#">Data Loading</a></li>
			<li><a href="#">System Computation</a></li>
		</ul>
	</li>
	
	<li><a href="#" class="menulink">Inquiry</a>
		<ul>
			<li class="topline"><a href="#">GAP/GAR Status Inquiry</a></li>
			<li><a href="#">Performance Ranking</a></li>
		</ul>
	</li>
	
</ul>	
	
<div style="clear:both"></div>

<script type="text/javascript">
	var menu=new menu.dd("menu");
	menu.init("menu","menuhover");
</script>

