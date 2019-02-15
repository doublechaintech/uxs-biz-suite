
package com.doublechaintech.uxs.product;
import com.doublechaintech.uxs.EntityNotFoundException;

public class ProductVersionChangedException extends ProductManagerException {
	private static final long serialVersionUID = 1L;
	public ProductVersionChangedException(String string) {
		super(string);
	}


}


