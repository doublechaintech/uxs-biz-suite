
package com.doublechaintech.uxs.catalog;
import com.doublechaintech.uxs.EntityNotFoundException;

public class CatalogVersionChangedException extends CatalogManagerException {
	private static final long serialVersionUID = 1L;
	public CatalogVersionChangedException(String string) {
		super(string);
	}


}


