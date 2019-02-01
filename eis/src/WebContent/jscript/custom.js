jQuery(document).ready(function() {
	// do something here


 	  $("#reset").click(function() {
 	     	$("form").each(function(){
 				this.reset();
 	     	});
 	   	  });

 	  $("#tblListDetails").tablesorter(); 	
 	  
 	//add Indicator in Maintenance: Indicators: Strategy/Metric Management
 	  $('#addIndicatorSaveTarget').submit(function(){
 		  alert("Form submitted.");
 		  return false;
 	  });
 	
 	  
 	  
});