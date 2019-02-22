
package com.doublechaintech.uxs.newproduct;
import com.doublechaintech.uxs.EntityNotFoundException;

public class NewProductVersionChangedException extends NewProductManagerException {
	private static final long serialVersionUID = 1L;
	public NewProductVersionChangedException(String string) {
		super(string);
	}


}


