package br.prospecting.bal;


/**
 * The origin describes where a company come from (or found).
 * Eg: Social medias, phone, face visit or etc ...
 */
public class Origin extends BaseModel {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
