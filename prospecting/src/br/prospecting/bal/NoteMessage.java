package br.prospecting.bal;

import java.time.LocalDateTime;

public class NoteMessage extends ModelBase {
	
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
