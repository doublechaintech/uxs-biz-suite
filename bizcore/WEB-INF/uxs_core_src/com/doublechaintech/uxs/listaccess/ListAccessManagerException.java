
package com.doublechaintech.uxs.listaccess;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class ListAccessManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public ListAccessManagerException(String string) {
		super(string);
	}
	public ListAccessManagerException(Message message) {
		super(message);
	}
	public ListAccessManagerException(List<Message> messageList) {
		super(messageList);
	}

}


