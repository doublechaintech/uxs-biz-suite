
package com.doublechaintech.uxs.site;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.platform.Platform;

public class SiteMapper extends BaseRowMapper<Site>{
	
	protected Site internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Site site = getSite();		
		 		
 		setId(site, rs, rowNumber); 		
 		setName(site, rs, rowNumber); 		
 		setIntroduction(site, rs, rowNumber); 		
 		setPlatform(site, rs, rowNumber); 		
 		setLastUpdateTime(site, rs, rowNumber); 		
 		setVersion(site, rs, rowNumber);

		return site;
	}
	
	protected Site getSite(){
		return new Site();
	}		
		
	protected void setId(Site site, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SiteTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		site.setId(id);
	}
		
	protected void setName(Site site, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(SiteTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		site.setName(name);
	}
		
	protected void setIntroduction(Site site, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String introduction = rs.getString(SiteTable.COLUMN_INTRODUCTION);
		if(introduction == null){
			//do nothing when nothing found in database
			return;
		}
		
		site.setIntroduction(introduction);
	}
		 		
 	protected void setPlatform(Site site, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(SiteTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = site.getPlatform();
 		if( platform != null ){
 			//if the root object 'site' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		site.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setLastUpdateTime(Site site, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(SiteTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		site.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(Site site, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SiteTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		site.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


