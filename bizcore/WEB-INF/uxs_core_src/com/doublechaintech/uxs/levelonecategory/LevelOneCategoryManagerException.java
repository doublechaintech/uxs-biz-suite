
package com.doublechaintech.uxs.levelonecategory;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class LevelOneCategoryManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public LevelOneCategoryManagerException(String string) {
		super(string);
	}
	public LevelOneCategoryManagerException(Message message) {
		super(message);
	}
	public LevelOneCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


