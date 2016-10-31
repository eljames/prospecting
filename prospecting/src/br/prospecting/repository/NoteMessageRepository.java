package br.prospecting.repository;

import java.util.List;

import br.prospecting.bal.NoteMessage;


/**
 * Interface for note message database operations.
 * 
 * @author Eli James
 *
 */
public interface NoteMessageRepository {
	
	/**
	 * Adds a {@link NoteMessage} to a prospect.
	 * 
	 * @param noteMessage
	 * @param prospect
	 */
	public void save(NoteMessage noteMessage, long idProspect);
	
	
	/**
	 * Returns a note message list, with a specific page and limit per page. It should be sorted by post date in descending order.
	 * 
	 * @param page
	 * @param limit
	 * @return Note Message List
	 */
	public List<NoteMessage> list(int page, int limit);
	
	/**
	 * Remove a note message.
	 * @param id
	 */
	public void remove(long id);
	
	/**
	 * Update a note message. It should not update the post date, for only message correction purpose.
	 * 
	 * @param noteMessage
	 */
	public void update(NoteMessage noteMessage);
}
