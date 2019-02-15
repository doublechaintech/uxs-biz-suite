
package com.doublechaintech.uxs.target;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.profile.Profile;

public class TargetMapper extends BaseRowMapper<Target>{
	
	protected Target internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Target target = getTarget();		
		 		
 		setId(target, rs, rowNumber); 		
 		setName(target, rs, rowNumber); 		
 		setProfile(target, rs, rowNumber); 		
 		setBanner(target, rs, rowNumber); 		
 		setLocation(target, rs, rowNumber); 		
 		setLastUpdate(target, rs, rowNumber); 		
 		setVersion(target, rs, rowNumber);

		return target;
	}
	
	protected Target getTarget(){
		return new Target();
	}		
		
	protected void setId(Target target, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TargetTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		target.setId(id);
	}
		
	protected void setName(Target target, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TargetTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		target.setName(name);
	}
		 		
 	protected void setProfile(Target target, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(TargetTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = target.getProfile();
 		if( profile != null ){
 			//if the root object 'target' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		target.setProfile(createEmptyProfile(profileId));
 	}
 	 		
 	protected void setBanner(Target target, ResultSet rs, int rowNumber) throws SQLException{
 		String bannerId = rs.getString(TargetTable.COLUMN_BANNER);
 		if( bannerId == null){
 			return;
 		}
 		if( bannerId.isEmpty()){
 			return;
 		}
 		Banner banner = target.getBanner();
 		if( banner != null ){
 			//if the root object 'target' already have the property, just set the id for it;
 			banner.setId(bannerId);
 			
 			return;
 		}
 		target.setBanner(createEmptyBanner(bannerId));
 	}
 	
	protected void setLocation(Target target, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String location = rs.getString(TargetTable.COLUMN_LOCATION);
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		target.setLocation(location);
	}
		
	protected void setLastUpdate(Target target, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdate = rs.getTimestamp(TargetTable.COLUMN_LAST_UPDATE);
		if(lastUpdate == null){
			//do nothing when nothing found in database
			return;
		}
		
		target.setLastUpdate(convertToDateTime(lastUpdate));
	}
		
	protected void setVersion(Target target, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TargetTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		target.setVersion(version);
	}
		
		

 	protected Profile  createEmptyProfile(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
 	protected Banner  createEmptyBanner(String bannerId){
 		Banner banner = new Banner();
 		banner.setId(bannerId);
 		banner.setVersion(Integer.MAX_VALUE);
 		return banner;
 	}
 	
}


