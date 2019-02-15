
package com.doublechaintech.uxs.profile;
import com.doublechaintech.uxs.EntityNotFoundException;

public class ProfileVersionChangedException extends ProfileManagerException {
	private static final long serialVersionUID = 1L;
	public ProfileVersionChangedException(String string) {
		super(string);
	}


}


