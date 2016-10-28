package br.prospecting.repository;

import br.prospecting.bal.Prospect;

/**
 * Contains fields for searching {@link Prospect} objects according to name, page, limit and status. 
 * If the page is 2, and limit 10, it will show from 10 to 19 (returns 10 objects). If the page is 5 and limit is 10, it will show from 40 to 49 (returns 10 objects).
 */

public class ProspectSearchFields {
	
	/**
	 *  The name to search for. If the name is void or null, a {@link ProspectRepository} will return a list of {@link Prospect} regarding only the page and limit.
	 */
	private String name;
	
	/**
	 * The page number to offset. It must be greater than 1.
	 */
	private String page;
	
	/**
	 * The max number of {@link Prospect} per page. It must be greater than 1.
	 */
	private String limit;
	
	/**
	 * 
	 */
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
