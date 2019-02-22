
package com.doublechaintech.uxs.editorpickproduct;
import com.doublechaintech.uxs.AccessKey;


public class EditorPickProductTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="editor_pick_product_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PARENT_CATEGORY = "parent_category";
	static final String COLUMN_BRAND = "brand";
	static final String COLUMN_PRODUCT_COVER_IMAGE = "product_cover_image";
	static final String COLUMN_ORIGIN = "origin";
	static final String COLUMN_CATALOG = "catalog";
	static final String COLUMN_PROFILE = "profile";
	static final String COLUMN_REMARK = "remark";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_PARENT_CATEGORY, COLUMN_BRAND, COLUMN_PRODUCT_COVER_IMAGE, COLUMN_ORIGIN, COLUMN_CATALOG, COLUMN_PROFILE, COLUMN_REMARK, COLUMN_LAST_UPDATE_TIME, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_PARENT_CATEGORY, COLUMN_BRAND, COLUMN_PRODUCT_COVER_IMAGE, COLUMN_ORIGIN, COLUMN_CATALOG, COLUMN_PROFILE, COLUMN_REMARK, COLUMN_LAST_UPDATE_TIME, COLUMN_PLATFORM
		};
	
	
}


