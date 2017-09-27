package br.com.involves.selecao.dao;

import java.io.IOException;
import java.util.List;

import br.com.involves.selecao.domain.City;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public abstract class FileTemplate {

	public abstract List<City> read(String filename) throws IOException;
	
}
