
package com.doublechaintech.uxs.banner;
//import com.doublechaintech.uxs.EntityNotFoundException;
import com.doublechaintech.uxs.UxsException;
import com.doublechaintech.uxs.Message;
import java.util.List;

public class BannerManagerException extends UxsException {
	private static final long serialVersionUID = 1L;
	public BannerManagerException(String string) {
		super(string);
	}
	public BannerManagerException(Message message) {
		super(message);
	}
	public BannerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


