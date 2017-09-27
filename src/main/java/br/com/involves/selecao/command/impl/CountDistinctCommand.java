package br.com.involves.selecao.command.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import br.com.involves.selecao.command.CommandTemplate;
import br.com.involves.selecao.commons.Constants;
import br.com.involves.selecao.domain.City;
import br.com.involves.selecao.domain.CommandEnum;
import br.com.involves.selecao.domain.Property;
import br.com.involves.selecao.domain.PropertyEnum;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public class CountDistinctCommand extends CommandTemplate {
	
	public CountDistinctCommand() {
		
	}

	@Override
	public String execute(List<City> cities, String command, City header) {
		String searchProperty = command.toLowerCase().replaceAll(CommandEnum.COUNT_DISTINCT.getCommand(), Constants.EMPTY);
		
		PropertyEnum selectedProperty = Property.getName(searchProperty);
		if (selectedProperty == null) {
			return "Propriedade inválida";
		}
		
		Long count = cities.stream()
				.parallel()
				.filter(distinctByProperty(line -> Property.getValue(line, selectedProperty)))
				.sequential()
				.count();
		return String.format("Total de registro da propriedade [%s]: %d", searchProperty, count);
	}
	
	private static Predicate<City> distinctByProperty(Function<City, String> property) {
	    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
	    return line -> seen.putIfAbsent(property.apply(line), Boolean.TRUE) == null;
	}

}
