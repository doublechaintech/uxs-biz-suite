
package com.doublechaintech.uxs.newproduct;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class NewProductManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public NewProductManagerException(String string) {
		super(string);
	}
	public NewProductManagerException(Message message) {
		super(message);
	}
	public NewProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


