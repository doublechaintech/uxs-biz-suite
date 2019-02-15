
package com.doublechaintech.uxs.loginhistory;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class LoginHistoryManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public LoginHistoryManagerException(String string) {
		super(string);
	}
	public LoginHistoryManagerException(Message message) {
		super(message);
	}
	public LoginHistoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


