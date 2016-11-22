package com.sistemavacinacao.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sistemavacinacao.entity.DependenceType;
import com.sistemavacinacao.entity.Disease;
import com.sistemavacinacao.entity.VaccineType;

@FacesConverter(value="diseaseConverter")
public class DiseaseConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		if (value != null && !"".equals(value)) {

			Disease entity = (Disease) value;

			this.addAttribute(component, entity);

			Integer codigo = entity.getIdDisease();
			if (codigo != 0) {
				return String.valueOf(codigo);
			}
		}

		return (String) value;
	}

	protected void addAttribute(UIComponent component, Disease o) {
		String key = Integer.toString(o.getIdDisease()); 
		this.getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
