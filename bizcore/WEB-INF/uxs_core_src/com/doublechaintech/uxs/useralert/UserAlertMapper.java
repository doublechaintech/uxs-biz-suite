
package com.doublechaintech.uxs.useralert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;

public class UserAlertMapper extends BaseRowMapper<UserAlert>{
	
	protected UserAlert internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		UserAlert userAlert = getUserAlert();		
		 		
 		setId(userAlert, rs, rowNumber); 		
 		setMessage(userAlert, rs, rowNumber); 		
 		setProfile(userAlert, rs, rowNumber); 		
 		setLocation(userAlert, rs, rowNumber); 		
 		setLastUpdate(userAlert, rs, rowNumber); 		
 		setPlatform(userAlert, rs, rowNumber); 		
 		setVersion(userAlert, rs, rowNumber);

		return userAlert;
	}
	
	protected UserAlert getUserAlert(){
		return new UserAlert();
	}		
		
	protected void setId(UserAlert userAlert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(UserAlertTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAlert.setId(id);
	}
		
	protected void setMessage(UserAlert userAlert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String message = rs.getString(UserAlertTable.COLUMN_MESSAGE);
		if(message == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAlert.setMessage(message);
	}
		 		
 	protected void setProfile(UserAlert userAlert, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(UserAlertTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = userAlert.getProfile();
 		if( profile != null ){
 			//if the root object 'userAlert' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		userAlert.setProfile(createEmptyProfile(profileId));
 	}
 	
	protected void setLocation(UserAlert userAlert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String location = rs.getString(UserAlertTable.COLUMN_LOCATION);
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAlert.setLocation(location);
	}
		
	protected void setLastUpdate(UserAlert userAlert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdate = rs.getTimestamp(UserAlertTable.COLUMN_LAST_UPDATE);
		if(lastUpdate == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAlert.setLastUpdate(convertToDateTime(lastUpdate));
	}
		 		
 	protected void setPlatform(UserAlert userAlert, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(UserAlertTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = userAlert.getPlatform();
 		if( platform != null ){
 			//if the root object 'userAlert' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		userAlert.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(UserAlert userAlert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(UserAlertTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAlert.setVersion(version);
	}
		
		

 	protected Profile  createEmptyProfile(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


