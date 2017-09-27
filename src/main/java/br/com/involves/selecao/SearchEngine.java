package br.com.involves.selecao;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Scanner;

import br.com.involves.selecao.command.CommandTemplate;
import br.com.involves.selecao.command.impl.ExitCommand;
import br.com.involves.selecao.command.validate.CommandValidate;
import br.com.involves.selecao.dao.FileTemplate;
import br.com.involves.selecao.dao.impl.CsvReadImpl;
import br.com.involves.selecao.domain.City;
import br.com.involves.selecao.menu.Menu;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public class SearchEngine {

	private static SearchEngine instance;
	private List<City> cities;
	private City header;
	
	public SearchEngine() {
		
	}
	
	private void initialize(String fileName) throws IOException {
		FileTemplate file = new CsvReadImpl();
		setCities(file.read(fileName));
		setHeader(getCities().get(0));
		getCities().remove(0);
	}
	
	public void run(String fileName) {
		Scanner scan = new Scanner(System.in);
		
		try {
			initialize(fileName);
			
			String line = null;
			CommandTemplate command = null;
			do {
				System.out.println(Menu.getInstance().showOptions());
				System.out.print("Comando: ");
				line = scan.nextLine();
				command = CommandValidate.getCommand(line);
				System.out.println(command.execute(getCities(), line, getHeader()));
			} while (!(command instanceof ExitCommand));
			
			System.out.println("Programa finalizado!");
		} catch (IOException | UncheckedIOException e) {
			System.err.println("Erro ao carregar arquivo");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Erro ao executar a aplicação");
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}
	
	public static SearchEngine getInstance() {
		if (instance == null) {
			instance = new SearchEngine();
		}
		return instance;
	}
	
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	public City getHeader() {
		return header;
	}

	public void setHeader(City header) {
		this.header = header;
	}
	
}
