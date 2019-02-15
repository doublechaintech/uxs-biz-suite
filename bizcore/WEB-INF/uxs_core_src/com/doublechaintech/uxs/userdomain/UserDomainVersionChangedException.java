
package com.doublechaintech.uxs.userdomain;
import com.doublechaintech.uxs.EntityNotFoundException;

public class UserDomainVersionChangedException extends UserDomainManagerException {
	private static final long serialVersionUID = 1L;
	public UserDomainVersionChangedException(String string) {
		super(string);
	}


}


