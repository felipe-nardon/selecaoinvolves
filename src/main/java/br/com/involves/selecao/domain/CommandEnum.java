package br.com.involves.selecao.domain;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public enum CommandEnum {
	COUNT("count *", "count * \t\t\t - total de registros"),
	COUNT_DISTINCT("count distinct ", "count distinct [propriedade] \t - total distinto de uma propriedade"),
	FILTER("filter ", "filter [propriedade] [valor] \t - filtra por propriedade / valor"),
	EXIT("exit", "exit \t\t\t\t - sair");
    
    private final String command;
    private final String description;
    
    CommandEnum(String command, String description) {
        this.command = command;
        this.description = description;
    }
    
    public String getCommand() {
        return command;
    }
    
    public String getDescription() {
    	return description;
    }
    
}
