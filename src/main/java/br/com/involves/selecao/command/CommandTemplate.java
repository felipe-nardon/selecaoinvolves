package br.com.involves.selecao.command;

import java.util.List;

import br.com.involves.selecao.domain.City;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public abstract class CommandTemplate {

	public abstract String execute(List<City> cities, String command, City header);
	
}
