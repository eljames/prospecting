package br.prospecting.bal;

import java.time.LocalDateTime;
import br.prospecting.datetime.DateTimePatternedFormat;

public class Prospect extends BaseModel {
	
	// Can be the company name or a person name.
	private String name;
	
	// The prospect full address
	private String address;
	
	// The phone number
	private String phoneNumber;
	
	// The time when the prospect is added
	private LocalDateTime registrationDate;
	
	private int status;
	private Sector sector;
	private Origin origin;

	
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
