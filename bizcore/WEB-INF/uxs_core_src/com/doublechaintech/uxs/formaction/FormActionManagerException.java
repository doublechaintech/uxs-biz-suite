
package com.doublechaintech.uxs.formaction;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class FormActionManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public FormActionManagerException(String string) {
		super(string);
	}
	public FormActionManagerException(Message message) {
		super(message);
	}
	public FormActionManagerException(List<Message> messageList) {
		super(messageList);
	}

}












