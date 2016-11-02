package br.prospecting.repository;

import java.util.List;

import br.prospecting.bal.Origin;

public interface OriginRepository extends GenericRepository<Origin> {
	
	/**
	 * Returns a list of all origins. In this case, it's not necessary to limit the list size, since it's relatively small, because it does not increase too much overtime.
	 * @return All origins.
	 */
	public List<Origin> list();
	
}
