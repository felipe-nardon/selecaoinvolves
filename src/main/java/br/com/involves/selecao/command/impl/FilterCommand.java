package br.com.involves.selecao.command.impl;

import java.util.List;
import java.util.stream.Collectors;

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
public class FilterCommand extends CommandTemplate {
	
	public FilterCommand() {
		
	}

	@Override
	public String execute(List<City> cities, String command, City header) {
		String properties = command.toLowerCase().replaceAll(CommandEnum.FILTER.getCommand(), Constants.EMPTY);
		String[] searchProperty = properties.split(Constants.BLANK, 2);
		
		if (searchProperty.length != 2) {
			return "Informe a propriedade e valor a serem filtrados";
		}
		
		PropertyEnum selectedProperty = Property.getName(searchProperty[0]);
		if (selectedProperty == null) {
			return "Propriedade inválida";
		}
		
		List<City> filteredList = cities.stream()
				.parallel()
				.filter(line -> Property.getValue(line, selectedProperty).equalsIgnoreCase(searchProperty[1]))
				.sequential()
				.collect(Collectors.toList());
		
		StringBuilder result = new StringBuilder();
		result.append(header);
		result.append(Constants.NEW_LINE);
		filteredList.forEach(city -> {
			result.append(city);
			result.append(Constants.NEW_LINE);
		});
		result.append(String.format("Total de registro da propriedade [%s] e valor [%s]: %d", searchProperty[0], searchProperty[1], filteredList.size()));
		return result.toString();
	}

}
