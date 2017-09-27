package br.com.involves.selecao.command.validate;

import br.com.involves.selecao.command.CommandTemplate;
import br.com.involves.selecao.command.impl.CountCommand;
import br.com.involves.selecao.command.impl.CountDistinctCommand;
import br.com.involves.selecao.command.impl.ExitCommand;
import br.com.involves.selecao.command.impl.FilterCommand;
import br.com.involves.selecao.command.impl.InvalidCommand;
import br.com.involves.selecao.domain.CommandEnum;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public class CommandValidate {
	
	private CommandValidate() {
		
	}
	
	public static CommandTemplate getCommand(String line) {
		if (isCount(line)) {
			return new CountCommand();
    	} else if (isCountDistinct(line)) {
    		return new CountDistinctCommand();
    	} else if (isFilter(line)) {
    		return new FilterCommand();
    	} else if (isExit(line)) {
    		return new ExitCommand();
    	} else {
    		return new InvalidCommand();
    	}
	}

	private static boolean isCount(String command) {
		return command.equalsIgnoreCase(CommandEnum.COUNT.getCommand());
	}
	
	private static boolean isCountDistinct(String command) {
		return command.toLowerCase().contains(CommandEnum.COUNT_DISTINCT.getCommand());
	}
	
	private static boolean isFilter(String command) {
		return command.toLowerCase().contains(CommandEnum.FILTER.getCommand());
	}
	
	private static boolean isExit(String command) {
		return command.toLowerCase().contains(CommandEnum.EXIT.getCommand());
	}
}
