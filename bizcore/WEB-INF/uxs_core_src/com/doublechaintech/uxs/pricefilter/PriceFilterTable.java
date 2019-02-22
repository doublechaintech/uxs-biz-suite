
package com.doublechaintech.uxs.pricefilter;
import com.doublechaintech.uxs.AccessKey;


public class PriceFilterTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="price_filter_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PRICE_START = "price_start";
	static final String COLUMN_PRICE_END = "price_end";
	static final String COLUMN_PROFILE = "profile";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_PRICE_START, COLUMN_PRICE_END, COLUMN_PROFILE, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_PRICE_START, COLUMN_PRICE_END, COLUMN_PROFILE
		};
	
	
}


