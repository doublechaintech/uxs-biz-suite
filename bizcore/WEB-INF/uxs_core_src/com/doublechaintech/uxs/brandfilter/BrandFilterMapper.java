
package com.doublechaintech.uxs.brandfilter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.profile.Profile;

public class BrandFilterMapper extends BaseRowMapper<BrandFilter>{
	
	protected BrandFilter internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		BrandFilter brandFilter = getBrandFilter();		
		 		
 		setId(brandFilter, rs, rowNumber); 		
 		setName(brandFilter, rs, rowNumber); 		
 		setInternalId(brandFilter, rs, rowNumber); 		
 		setProfile(brandFilter, rs, rowNumber); 		
 		setVersion(brandFilter, rs, rowNumber);

		return brandFilter;
	}
	
	protected BrandFilter getBrandFilter(){
		return new BrandFilter();
	}		
		
	protected void setId(BrandFilter brandFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(BrandFilterTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		brandFilter.setId(id);
	}
		
	protected void setName(BrandFilter brandFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(BrandFilterTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		brandFilter.setName(name);
	}
		
	protected void setInternalId(BrandFilter brandFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String internalId = rs.getString(BrandFilterTable.COLUMN_INTERNAL_ID);
		if(internalId == null){
			//do nothing when nothing found in database
			return;
		}
		
		brandFilter.setInternalId(internalId);
	}
		 		
 	protected void setProfile(BrandFilter brandFilter, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(BrandFilterTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = brandFilter.getProfile();
 		if( profile != null ){
 			//if the root object 'brandFilter' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		brandFilter.setProfile(createEmptyProfile(profileId));
 	}
 	
	protected void setVersion(BrandFilter brandFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(BrandFilterTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		brandFilter.setVersion(version);
	}
		
		

 	protected Profile  createEmptyProfile(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
}


