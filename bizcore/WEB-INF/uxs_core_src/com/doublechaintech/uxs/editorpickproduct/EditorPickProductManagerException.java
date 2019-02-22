
package com.doublechaintech.uxs.editorpickproduct;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class EditorPickProductManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public EditorPickProductManagerException(String string) {
		super(string);
	}
	public EditorPickProductManagerException(Message message) {
		super(message);
	}
	public EditorPickProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


