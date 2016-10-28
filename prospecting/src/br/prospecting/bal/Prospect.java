package br.prospecting.bal;

import java.time.LocalDateTime;
import br.prospecting.datetime.DateTimePatternedFormat;

public class Prospect extends ModelBase {
	
	// Can be the company name or a person name.
	private String name;
	
	// The prospect full address
	private String address;
	
	// This is time when the prospect is added
	private LocalDateTime registrationDate;
	
	private int status;
	private Origin origin;
	private Sector sector;

	
	public String getRegistrationDateText() {
		return this.registrationDate.format(DateTimePatternedFormat.get());
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Origin getOrigin() {
		return origin;
	}


	public void setOrigin(Origin origin) {
		this.origin = origin;
	}


	public Sector getSector() {
		return sector;
	}


	public void setSector(Sector sector) {
		this.sector = sector;
	}
}
