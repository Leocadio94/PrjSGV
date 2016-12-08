function highlightDays(date) {
	var carter = "#{vaccinationCardMB.currentDates}";
	var dates = carter;
	dates = dates.replace("[", "");
	dates = dates.replace("]", "");
	dates = dates.replace(" ", "");
	dates = dates.split(",");

	var dateF = date.getDay() + "/" + date.getMonth() + "/" + date.getFullYear();
	console.log(dateF);
	var cssclass = "";
	for (var i = 0; i < dates.length; i++) {
		console.log(dates[i]);
		if (dateF === dates[i]) {
			cssclass = "pdate-selected";
		}
	}

	return [ true, cssclass ];
}