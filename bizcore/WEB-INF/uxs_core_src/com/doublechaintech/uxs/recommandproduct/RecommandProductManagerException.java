
package com.doublechaintech.uxs.recommandproduct;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class RecommandProductManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public RecommandProductManagerException(String string) {
		super(string);
	}
	public RecommandProductManagerException(Message message) {
		super(message);
	}
	public RecommandProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


