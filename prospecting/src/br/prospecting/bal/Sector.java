package br.prospecting.bal;

/**
 * Each sector represents a type of company business.
 * Eg: IT Company, real estate, Bakery, Supermarket, etc.
 * 
 * @author Eli James
 *
 */
public class Sector extends BaseModel {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
