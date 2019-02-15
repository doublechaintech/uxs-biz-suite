
package com.doublechaintech.uxs.loginhistory;
import com.doublechaintech.uxs.EntityNotFoundException;

public class LoginHistoryVersionChangedException extends LoginHistoryManagerException {
	private static final long serialVersionUID = 1L;
	public LoginHistoryVersionChangedException(String string) {
		super(string);
	}


}


