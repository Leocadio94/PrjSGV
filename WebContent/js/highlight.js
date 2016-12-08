function highlightDays(date) {
	var carter = "${vaccinationCardMB.currentDates}";
	var dates = carter;
	dates = dates.replace("[", "");
	dates = dates.replace("]", "");
	dates = dates.replace(" ", "");
	dates = dates.split(",");

	var cssclass = "";
	for (var i = 0; i < dates.length; i++) {
		if (date === new Date(dates[i])) {
			cssclass = "pdate-selected";
		}
	}
	
	return [ true, cssclass ];
}