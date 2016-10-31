package br.prospecting.repository;

/**
 *  This interface abstracts commons data base operations.
 * <p>
 * 
 * T: Generic Class Type
 * 
 * @author Eli James
 *
 * @param <T>
 */
public interface GenericRepository<T> {
	
	/**
	 * Persist a T object.
	 * @param T A  object.
	 */
	public void save(T obj) throws DBException;
	
	
	/**
	 * Get a T by id.
	 * 
	 * @param id The id corresponding to a T.
	 * @return A T object if exists, null otherwise.
	 */
	public T get(long id) throws DBException;
	
	/**
	 * Update a T. It must include the prospect id on T object parameter.
	 * 
	 * @param T.
	 */
	
	public void update(T obj) throws DBException;
	
	/**
	 * Remove a T object by id. Furthermore, this should remove all its own dependencies.
	 * 
	 * @param id
	 */
	public void remove(long id) throws DBException;
}
