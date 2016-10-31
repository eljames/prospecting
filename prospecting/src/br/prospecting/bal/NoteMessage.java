package br.prospecting.bal;

import java.time.LocalDateTime;

/**
 * A note message can be leave with a freely message to describe what happens with the prospect.
 * Eg: "Return call and talk to John"
 * Each note message has its own post date time. A post date show what time and date the message was added.
 * @author Eli James
 *
 */
public class NoteMessage extends BaseModel {
	
	private String message;
	private LocalDateTime postDate;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
	
}
