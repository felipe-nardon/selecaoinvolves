package br.com.involves.selecao.menu;

import br.com.involves.selecao.commons.Constants;
import br.com.involves.selecao.domain.CommandEnum;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public class Menu {

	private static Menu instance;
	public String options;
	
	public Menu() {
		
	}
	
	public String showOptions() {
		return getOptions();
	}
	
	private String getOptions() {
		if (options == null) {
			String newLine = Constants.NEW_LINE;
			StringBuilder sb = new StringBuilder();
			sb.append(newLine);
			sb.append("--------------------------------------------------------------------");
			sb.append(newLine);
			sb.append("Opções:");
			sb.append(newLine);
			for (CommandEnum command : CommandEnum.values()) {
				sb.append(command.getDescription());
				sb.append(newLine);
			}
			options = sb.toString();
		}
		return options;
	}
	
	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}

}
