package br.com.involves.selecao.domain;

import java.lang.reflect.Field;

import br.com.involves.selecao.commons.Constants;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public class Property {

	private Property() {
		
	}
	
	public static PropertyEnum getName(String property) {
		for (PropertyEnum prop : PropertyEnum.values()) {
			if (prop.getCsvName().equals(property)) {
				return prop;
			}
		}
		return null;
	}
	
	public static String getValue(City city, PropertyEnum selectedProperty) {
		Field[] fields = city.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getName().equals(selectedProperty.getJavaName())) {
				try {
					return field.get(city).toString();
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
	    }
		return Constants.EMPTY;
	}
}
