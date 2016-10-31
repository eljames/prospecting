package br.prospecting.repository;

import br.prospecting.bal.Prospect;

/**
 * Contains fields for searching {@link Prospect} objects according to name, page, limit and status. 
 * If the page is 2, and limit 10, it will show from 11 to 20 (returns 10 objects). If the page is 5 and limit is 10, it will show from 41 to 50 (returns 10 objects).
 * Furthermore, it can search prospects by name and status.  If the name is void or null, a {@link ProspectRepository} will return a list of {@link Prospect} with any name.
 * If status is -1, it will return with any status.
 */

public class ProspectSearchFields {
	

	private String name;
	private String page;
	private String limit;
	private String status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
