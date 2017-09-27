package br.com.involves.selecao.domain;

import java.util.StringJoiner;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public class City {

	private String ibgeId;
	private String uf;
	private String name;
	private String capital;
	private String lon;
	private String lat;
	private String noAccents;
	private String alternativeNames;
	private String microRegion;
	private String mesoRegion;
	
	public City() {
		
	}

	public String getIbgeId() {
		return ibgeId;
	}

	public void setIbgeId(String ibgeId) {
		this.ibgeId = ibgeId;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}

	public String getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	public String getMicroRegion() {
		return microRegion;
	}

	public void setMicroRegion(String microRegion) {
		this.microRegion = microRegion;
	}

	public String getMesoRegion() {
		return mesoRegion;
	}

	public void setMesoRegion(String mesoRegion) {
		this.mesoRegion = mesoRegion;
	}
	
	@Override
	public String toString() {
		StringJoiner result = new StringJoiner(", ");
		result.add(this.getIbgeId());
		result.add(this.getName());
		result.add(this.getCapital());
		result.add(this.getLon());
		result.add(this.getLat());
		result.add(this.getNoAccents());
		result.add(this.getAlternativeNames());
		result.add(this.getMicroRegion());
		result.add(this.getMesoRegion());
		return String.format("[%s]", result);
	}
	
}
