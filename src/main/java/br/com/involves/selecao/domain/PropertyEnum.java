package br.com.involves.selecao.domain;

/**
 * @author Felipe Nardos dos Santos
 *
 */
public enum PropertyEnum {
	IBGE_ID("ibgeId", "ibge_id"),
	UF("uf", "uf"),
	NAME("name", "name"),
	CAPITAL("capital", "capital"),
	LON("lon", "lon"),
	LAT("lat", "lat"),
	NO_ACCENTS("noAccents", "no_accents"),
	ALTERNATIVE_NAMES("alternativeNames", "alternative_names"),
	MICROREGION("microregion", "microregion"),
	MESOREGION("mesoregion", "mesoregion"),;
	
    private final String javaName;
    private final String csvName;
    
    PropertyEnum(String javaName, String csvName) {
        this.javaName = javaName;
        this.csvName = csvName;
    }
    
    public String getJavaName() {
        return javaName;
    }
    
    public String getCsvName() {
    	return csvName;
    }
    
}
