
package com.doublechaintech.uxs.brand;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class BrandManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public BrandManagerException(String string) {
		super(string);
	}
	public BrandManagerException(Message message) {
		super(message);
	}
	public BrandManagerException(List<Message> messageList) {
		super(messageList);
	}

}


