
package com.doublechaintech.uxs.categoryfilter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.profile.Profile;

public class CategoryFilterMapper extends BaseRowMapper<CategoryFilter>{
	
	protected CategoryFilter internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		CategoryFilter categoryFilter = getCategoryFilter();		
		 		
 		setId(categoryFilter, rs, rowNumber); 		
 		setName(categoryFilter, rs, rowNumber); 		
 		setInternalId(categoryFilter, rs, rowNumber); 		
 		setProfile(categoryFilter, rs, rowNumber); 		
 		setVersion(categoryFilter, rs, rowNumber);

		return categoryFilter;
	}
	
	protected CategoryFilter getCategoryFilter(){
		return new CategoryFilter();
	}		
		
	protected void setId(CategoryFilter categoryFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(CategoryFilterTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		categoryFilter.setId(id);
	}
		
	protected void setName(CategoryFilter categoryFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(CategoryFilterTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		categoryFilter.setName(name);
	}
		
	protected void setInternalId(CategoryFilter categoryFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String internalId = rs.getString(CategoryFilterTable.COLUMN_INTERNAL_ID);
		if(internalId == null){
			//do nothing when nothing found in database
			return;
		}
		
		categoryFilter.setInternalId(internalId);
	}
		 		
 	protected void setProfile(CategoryFilter categoryFilter, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(CategoryFilterTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = categoryFilter.getProfile();
 		if( profile != null ){
 			//if the root object 'categoryFilter' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		categoryFilter.setProfile(createEmptyProfile(profileId));
 	}
 	
	protected void setVersion(CategoryFilter categoryFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(CategoryFilterTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		categoryFilter.setVersion(version);
	}
		
		

 	protected Profile  createEmptyProfile(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
}


