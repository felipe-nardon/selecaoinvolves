package br.com.involves.selecao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.involves.selecao.utils.Utils;

public class MainTest {
	
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
	public void countCommandTest() {
		utils.setSystemIn("count *");
		Main.main(null);
		assertTrue(utils.getOut().toString().contains("Total de registros: "));
	}
	
	@Test
	public void countDistinctCommandTest() {
		utils.setSystemIn("count distinct uf");
		Main.main(null);
		assertTrue(utils.getOut().toString().contains("Total de registro da propriedade [uf]: "));
	}

	@Test
	public void filterCommandTest() {
		utils.setSystemIn("filter uf rs");
		Main.main(null);
		assertTrue(utils.getOut().toString().contains("Total de registro da propriedade [uf] e valor [rs]: "));
	}
	
	@Test
	public void invalidCommandTest() {
		utils.setSystemIn("count");
		Main.main(null);
		assertTrue(utils.getOut().toString().contains("Comando inválido!"));
	}
	
	@Test
	public void invalidPropertyTest1() {
		utils.setSystemIn("count distinct population");
		Main.main(null);
		assertTrue(utils.getOut().toString().contains("Propriedade inválida"));
	}
	
	@Test
	public void invalidPropertyTest2() {
		utils.setSystemIn("filter population 1000");
		Main.main(null);
		assertTrue(utils.getOut().toString().contains("Propriedade inválida"));
	}
	
	@Test
	public void wrongParametersTest() {
		utils.setSystemIn("filter uf");
		Main.main(null);
		assertTrue(utils.getOut().toString().contains("Informe a propriedade e valor a serem filtrados"));
	}
}
