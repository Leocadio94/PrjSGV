$(document).ready(function() {
	var url = this.location.pathname;
    $('a[href="' + url.substring(url.lastIndexOf('/')+1) + '"]').parent().addClass('active');
});