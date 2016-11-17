$(document).ready(function() {
	$("#signup").show();
	$("#login").hide();
	
	$('#myTabs a[href="#signup"]').click(function (e) {
	  e.preventDefault();
	  $("#signup").show();
	  $("#login").hide();
	});
	
	$('#myTabs a[href="#login"]').click(function (e) {
	  e.preventDefault();
	  $("#login").show();
	  $("#signup").hide();
	});
});