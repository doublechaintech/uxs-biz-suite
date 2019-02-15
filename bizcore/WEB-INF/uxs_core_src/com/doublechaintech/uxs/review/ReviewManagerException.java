
package com.doublechaintech.uxs.review;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class ReviewManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public ReviewManagerException(String string) {
		super(string);
	}
	public ReviewManagerException(Message message) {
		super(message);
	}
	public ReviewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


