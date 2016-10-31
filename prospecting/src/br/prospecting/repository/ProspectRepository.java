package br.prospecting.repository;

import java.util.List;

import br.prospecting.bal.Prospect;
/**
 * Provides business database operations over prospect. 
 * @author Eli James
 *
 */
public interface ProspectRepository {
	
	/**
	 * Persist a prospect.
	 * @param prospect A {@link Prospect} object.
	 */
	public void save(Prospect prospect);
	
	/**
	 * Update a prospect. It must include the prospect id on {@link Prospect} object parameter.
	 * 
	 * @param prospect A {@link Prospect} object.
	 */
	public void update(Prospect prospect);
	
	/**
	 * Get a prospect by id.
	 * 
	 * @param id The id corresponding to a prospect.
	 * @return A {@link Prospect} object if exists, null otherwise.
	 */
	public Prospect get(long id);
	
	
	/**
	 * Find a list of {@link Prospect} according to {@link ProspectSearchFields}. This should be sorted by registration date in descending order.
	 * 
	 * @param prospectSearchFields A {@link ProspectSearchFields} to configure the search. See {@link ProspectSearchFields}.
	 * @return A list of {@link Prospect}.
	 */
	public List<Prospect> list(ProspectSearchFields prospectSearchFields);
	
	/**
	 * Remove a {@link Prospect} by id. Furthermore this should remove all its own dependencies, like {@NoteMessage} objects.
	 * 
	 * @param prospect
	 */
	public void remove(long id);
}
