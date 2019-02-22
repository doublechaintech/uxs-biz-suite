
package com.doublechaintech.uxs.brand;
import com.doublechaintech.uxs.AccessKey;


public class BrandTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="brand_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_BRAND_NAME = "brand_name";
	static final String COLUMN_LOGO = "logo";
	static final String COLUMN_REMARK = "remark";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_BRAND_NAME, COLUMN_LOGO, COLUMN_REMARK, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_BRAND_NAME, COLUMN_LOGO, COLUMN_REMARK, COLUMN_PLATFORM
		};
	
	
}


