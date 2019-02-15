
package com.doublechaintech.uxs.review;
import com.doublechaintech.uxs.EntityNotFoundException;

public class ReviewVersionChangedException extends ReviewManagerException {
	private static final long serialVersionUID = 1L;
	public ReviewVersionChangedException(String string) {
		super(string);
	}


}


