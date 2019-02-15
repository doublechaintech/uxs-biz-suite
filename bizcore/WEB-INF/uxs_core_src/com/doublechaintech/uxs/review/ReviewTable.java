
package com.doublechaintech.uxs.review;
import com.doublechaintech.uxs.AccessKey;


public class ReviewTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="review_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_CONTENT = "content";
	static final String COLUMN_USER = "user";
	static final String COLUMN_PRODUCT = "product";
	static final String COLUMN_UPDATE_TIME = "update_time";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_CONTENT, COLUMN_USER, COLUMN_PRODUCT, COLUMN_UPDATE_TIME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_CONTENT, COLUMN_USER, COLUMN_PRODUCT, COLUMN_UPDATE_TIME
		};
	
	
}


