
package com.doublechaintech.uxs.leveltwocategory;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class LevelTwoCategoryManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public LevelTwoCategoryManagerException(String string) {
		super(string);
	}
	public LevelTwoCategoryManagerException(Message message) {
		super(message);
	}
	public LevelTwoCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


