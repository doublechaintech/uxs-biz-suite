
package com.doublechaintech.uxs.levelncategory;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class LevelNCategoryManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public LevelNCategoryManagerException(String string) {
		super(string);
	}
	public LevelNCategoryManagerException(Message message) {
		super(message);
	}
	public LevelNCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


