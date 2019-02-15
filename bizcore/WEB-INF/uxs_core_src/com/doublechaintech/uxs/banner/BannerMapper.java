
package com.doublechaintech.uxs.banner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.platform.Platform;

public class BannerMapper extends BaseRowMapper<Banner>{
	
	protected Banner internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Banner banner = getBanner();		
		 		
 		setId(banner, rs, rowNumber); 		
 		setName(banner, rs, rowNumber); 		
 		setImagePath(banner, rs, rowNumber); 		
 		setLastUpdate(banner, rs, rowNumber); 		
 		setPlatform(banner, rs, rowNumber); 		
 		setVersion(banner, rs, rowNumber);

		return banner;
	}
	
	protected Banner getBanner(){
		return new Banner();
	}		
		
	protected void setId(Banner banner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(BannerTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		banner.setId(id);
	}
		
	protected void setName(Banner banner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(BannerTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		banner.setName(name);
	}
		
	protected void setImagePath(Banner banner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String imagePath = rs.getString(BannerTable.COLUMN_IMAGE_PATH);
		if(imagePath == null){
			//do nothing when nothing found in database
			return;
		}
		
		banner.setImagePath(imagePath);
	}
		
	protected void setLastUpdate(Banner banner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdate = rs.getTimestamp(BannerTable.COLUMN_LAST_UPDATE);
		if(lastUpdate == null){
			//do nothing when nothing found in database
			return;
		}
		
		banner.setLastUpdate(convertToDateTime(lastUpdate));
	}
		 		
 	protected void setPlatform(Banner banner, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(BannerTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = banner.getPlatform();
 		if( platform != null ){
 			//if the root object 'banner' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		banner.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(Banner banner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(BannerTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		banner.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


