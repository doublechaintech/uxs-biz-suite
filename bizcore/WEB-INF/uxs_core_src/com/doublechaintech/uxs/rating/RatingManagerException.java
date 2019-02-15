
package com.doublechaintech.uxs.rating;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class RatingManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public RatingManagerException(String string) {
		super(string);
	}
	public RatingManagerException(Message message) {
		super(message);
	}
	public RatingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


