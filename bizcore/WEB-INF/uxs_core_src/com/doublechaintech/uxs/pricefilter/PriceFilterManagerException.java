
package com.doublechaintech.uxs.pricefilter;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class PriceFilterManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public PriceFilterManagerException(String string) {
		super(string);
	}
	public PriceFilterManagerException(Message message) {
		super(message);
	}
	public PriceFilterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


