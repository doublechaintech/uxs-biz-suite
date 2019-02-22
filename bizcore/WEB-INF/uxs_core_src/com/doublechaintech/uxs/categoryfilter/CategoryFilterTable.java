
package com.doublechaintech.uxs.categoryfilter;
import com.doublechaintech.uxs.AccessKey;


public class CategoryFilterTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="category_filter_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_INTERNAL_ID = "internal_id";
	static final String COLUMN_PROFILE = "profile";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_INTERNAL_ID, COLUMN_PROFILE, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_INTERNAL_ID, COLUMN_PROFILE
		};
	
	
}


