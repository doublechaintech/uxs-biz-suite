
package com.doublechaintech.uxs.product;
import com.doublechaintech.uxs.EntityNotFoundException;
public class ProductNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(String string) {
		super(string);
	}

}

