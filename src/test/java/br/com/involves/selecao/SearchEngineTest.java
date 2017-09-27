package br.com.involves.selecao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.involves.selecao.utils.Utils;

public class SearchEngineTest {

	Utils utils = new Utils();

	@Before
	public void setUpStreams() {
	    utils.setUpStreams();
	}

	@After
	public void cleanUpStreams() {
		utils.cleanUpStreams();
		utils.printStreams();
	}
	
	@Test
	public void FileNotFoundTest() {
		String fileName = "city.csv";
		SearchEngine.getInstance().run(fileName);
		assertTrue(utils.getErr().toString().contains(String.format("Arquivo %s não encontrado", fileName)));
	}
	
	@Test
	public void EmptyFileTest() {
		String fileName = "vazio.csv";
		SearchEngine.getInstance().run(fileName);
		assertTrue(utils.getErr().toString().contains("Arquivo vazio"));
	}
	
	@Test
	public void ErrorFileTest() {
		String fileName = "erro.csv";
		SearchEngine.getInstance().run(fileName);
		assertTrue(utils.getErr().toString().contains("Arquivo deve conter 10 colunas"));
	}

}
