
package com.doublechaintech.uxs.site;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class SiteManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public SiteManagerException(String string) {
		super(string);
	}
	public SiteManagerException(Message message) {
		super(message);
	}
	public SiteManagerException(List<Message> messageList) {
		super(messageList);
	}

}


