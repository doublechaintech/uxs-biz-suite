
package com.doublechaintech.uxs.catalog;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class CatalogManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public CatalogManagerException(String string) {
		super(string);
	}
	public CatalogManagerException(Message message) {
		super(message);
	}
	public CatalogManagerException(List<Message> messageList) {
		super(messageList);
	}

}


