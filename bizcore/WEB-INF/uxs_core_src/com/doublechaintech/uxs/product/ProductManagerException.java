
package com.doublechaintech.uxs.product;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class ProductManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public ProductManagerException(String string) {
		super(string);
	}
	public ProductManagerException(Message message) {
		super(message);
	}
	public ProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


