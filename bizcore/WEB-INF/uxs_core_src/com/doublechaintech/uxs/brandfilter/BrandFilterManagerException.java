
package com.doublechaintech.uxs.brandfilter;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class BrandFilterManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public BrandFilterManagerException(String string) {
		super(string);
	}
	public BrandFilterManagerException(Message message) {
		super(message);
	}
	public BrandFilterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


