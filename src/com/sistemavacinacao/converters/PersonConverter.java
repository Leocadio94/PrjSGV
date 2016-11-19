package com.sistemavacinacao.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sistemavacinacao.entity.Person;
import com.sistemavacinacao.entity.Vaccine;

@FacesConverter(value="personConverter")
public class PersonConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		if (value != null && !"".equals(value)) {

			Person entity = (Person) value;

			this.addAttribute(component, entity);

			Long codigo = entity.getCpf();
			if (codigo != 0) {
				return String.valueOf(codigo);
			}
		}

		return (String) value;
	}

	protected void addAttribute(UIComponent component, Person o) {
		String key = Long.toString(o.getCpf()); 
		this.getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
