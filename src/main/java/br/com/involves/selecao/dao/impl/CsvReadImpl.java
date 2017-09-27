package br.com.involves.selecao.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.involves.selecao.commons.Constants;
import br.com.involves.selecao.dao.FileTemplate;
import br.com.involves.selecao.domain.City;
import br.com.involves.selecao.domain.PropertyEnum;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public class CsvReadImpl extends FileTemplate {
	
	public CsvReadImpl() {
	
	}

	@Override
	public List<City> read(String fileName) throws IOException {
		InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
		if (in == null) {
			throw new FileNotFoundException(String.format("Arquivo %s não encontrado", fileName));
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8.name()));
		List<City> result = reader
				.lines()
				.map(mapToCity)
				.collect(Collectors.toList());
		
		if (result.isEmpty()) {
			throw new IOException("Arquivo vazio");
		}
		return result;
	}

	private Function<String, City> mapToCity = (line) -> {
		String[] collumns = line.split(Constants.COMMA);
		
		if (collumns.length != PropertyEnum.values().length) {
			String msg = String.format("Arquivo deve conter %s colunas", PropertyEnum.values().length);
			throw new UncheckedIOException(msg, new IOException());
		}
		
		City city = new City();
		city.setIbgeId(collumns[0]);
		city.setUf(collumns[1]);
		city.setName(collumns[2]);
		city.setCapital(collumns[3]);
		city.setLon(collumns[4]);
		city.setLat(collumns[5]);
		city.setNoAccents(collumns[6]);
		city.setAlternativeNames(collumns[7]);
		city.setMicroRegion(collumns[8]);
		city.setMesoRegion(collumns[9]);
		return city;
	};
}
