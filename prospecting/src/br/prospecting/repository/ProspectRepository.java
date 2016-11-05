package br.prospecting.repository;

import java.util.List;

import br.prospecting.bal.Prospect;
/**
 * Provides business database operations over prospect. 
 * @author Eli James
 *
 */
public interface ProspectRepository extends GenericRepository<Prospect> {
	
	/**
	 * Find a list of {@link Prospect} according to {@link ProspectSearchFields}. This should be sorted by registration date in descending order.
	 * 
	 * @param prospectSearchFields A {@link ProspectSearchFields} to configure the search. See {@link ProspectSearchFields}.
	 * @return A list of {@link Prospect}.
	 */
	public List<Prospect> list(ProspectSearchFields prospectSearchFields) throws DBException;
}
