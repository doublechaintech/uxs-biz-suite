
package com.doublechaintech.uxs.categoryfilter;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class CategoryFilterManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public CategoryFilterManagerException(String string) {
		super(string);
	}
	public CategoryFilterManagerException(Message message) {
		super(message);
	}
	public CategoryFilterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


