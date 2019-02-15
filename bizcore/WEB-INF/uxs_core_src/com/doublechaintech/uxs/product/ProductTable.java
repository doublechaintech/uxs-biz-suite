
package com.doublechaintech.uxs.product;
import com.doublechaintech.uxs.AccessKey;


public class ProductTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="product_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_AVARAGE_SCORE = "avarage_score";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_PLATFORM, COLUMN_AVARAGE_SCORE, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_PLATFORM, COLUMN_AVARAGE_SCORE
		};
	
	
}


