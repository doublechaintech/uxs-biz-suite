
package com.doublechaintech.uxs.pricefilter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.profile.Profile;

public class PriceFilterMapper extends BaseRowMapper<PriceFilter>{
	
	protected PriceFilter internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PriceFilter priceFilter = getPriceFilter();		
		 		
 		setId(priceFilter, rs, rowNumber); 		
 		setName(priceFilter, rs, rowNumber); 		
 		setPriceStart(priceFilter, rs, rowNumber); 		
 		setPriceEnd(priceFilter, rs, rowNumber); 		
 		setProfile(priceFilter, rs, rowNumber); 		
 		setVersion(priceFilter, rs, rowNumber);

		return priceFilter;
	}
	
	protected PriceFilter getPriceFilter(){
		return new PriceFilter();
	}		
		
	protected void setId(PriceFilter priceFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(PriceFilterTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		priceFilter.setId(id);
	}
		
	protected void setName(PriceFilter priceFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(PriceFilterTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		priceFilter.setName(name);
	}
		
	protected void setPriceStart(PriceFilter priceFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal priceStart = rs.getBigDecimal(PriceFilterTable.COLUMN_PRICE_START);
		if(priceStart == null){
			//do nothing when nothing found in database
			return;
		}
		
		priceFilter.setPriceStart(priceStart);
	}
		
	protected void setPriceEnd(PriceFilter priceFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal priceEnd = rs.getBigDecimal(PriceFilterTable.COLUMN_PRICE_END);
		if(priceEnd == null){
			//do nothing when nothing found in database
			return;
		}
		
		priceFilter.setPriceEnd(priceEnd);
	}
		 		
 	protected void setProfile(PriceFilter priceFilter, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(PriceFilterTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = priceFilter.getProfile();
 		if( profile != null ){
 			//if the root object 'priceFilter' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		priceFilter.setProfile(createEmptyProfile(profileId));
 	}
 	
	protected void setVersion(PriceFilter priceFilter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(PriceFilterTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		priceFilter.setVersion(version);
	}
		
		

 	protected Profile  createEmptyProfile(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
}


