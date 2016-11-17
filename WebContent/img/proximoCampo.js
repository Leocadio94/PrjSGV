function proximoCampo(atual, proximo) {
		if (atual.value.length >= atual.maxLength) {
			document.getElementById(proximo).focus();
		}
	}