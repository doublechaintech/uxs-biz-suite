
package com.doublechaintech.uxs.rating;
import com.doublechaintech.uxs.EntityNotFoundException;

public class RatingVersionChangedException extends RatingManagerException {
	private static final long serialVersionUID = 1L;
	public RatingVersionChangedException(String string) {
		super(string);
	}


}


