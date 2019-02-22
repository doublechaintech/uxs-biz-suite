
package com.doublechaintech.uxs.useralert;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class UserAlertManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public UserAlertManagerException(String string) {
		super(string);
	}
	public UserAlertManagerException(Message message) {
		super(message);
	}
	public UserAlertManagerException(List<Message> messageList) {
		super(messageList);
	}

}


