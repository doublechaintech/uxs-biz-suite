
package com.doublechaintech.uxs.blog;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class BlogManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public BlogManagerException(String string) {
		super(string);
	}
	public BlogManagerException(Message message) {
		super(message);
	}
	public BlogManagerException(List<Message> messageList) {
		super(messageList);
	}

}


