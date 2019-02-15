
package com.doublechaintech.uxs.objectaccess;
import com.doublechaintech.uxs.EntityNotFoundException;

public class ObjectAccessVersionChangedException extends ObjectAccessManagerException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessVersionChangedException(String string) {
		super(string);
	}


}


