package br.com.involves.selecao.command.impl;

import java.util.List;

import br.com.involves.selecao.command.CommandTemplate;
import br.com.involves.selecao.domain.City;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public class ExitCommand extends CommandTemplate {

	public ExitCommand() {
		
	}
	
	@Override
	public String execute(List<City> cities, String command, City header) {
		return "Finalizando...";
	}

}
