
package com.doublechaintech.uxs.blog;
import com.doublechaintech.uxs.EntityNotFoundException;

public class BlogVersionChangedException extends BlogManagerException {
	private static final long serialVersionUID = 1L;
	public BlogVersionChangedException(String string) {
		super(string);
	}


}


