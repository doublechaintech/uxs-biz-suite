
package com.doublechaintech.uxs.topratedproduct;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class TopRatedProductManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public TopRatedProductManagerException(String string) {
		super(string);
	}
	public TopRatedProductManagerException(Message message) {
		super(message);
	}
	public TopRatedProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


