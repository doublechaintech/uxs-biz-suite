
package com.doublechaintech.uxs.target;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class TargetManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public TargetManagerException(String string) {
		super(string);
	}
	public TargetManagerException(Message message) {
		super(message);
	}
	public TargetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


