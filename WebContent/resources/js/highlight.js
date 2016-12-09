function highlightDays(date) {
	var carter = "#{vaccinationCardMB.currentDates}";
	var dates = carter;
	dates = dates.replace("[", "");
	dates = dates.replace("]", "");
	dates = dates.replace(" ", "");
	dates = dates.split(",");

	var dateF = ('0' + date.getDate()).slice(-2) + '/'
			+ ('0' + (date.getMonth() + 1)).slice(-2) + '/'
			+ date.getFullYear();
	var cssclass = "";
	for (var i = 0; i < dates.length + 1; i++) {
		if (dateF === dates[i]) {
			cssclass = "pdate-selected";
		}
	}

	return [ true, cssclass ];
}