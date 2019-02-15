
package com.doublechaintech.uxs.rating;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.profile.Profile;

public class RatingMapper extends BaseRowMapper<Rating>{
	
	protected Rating internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Rating rating = getRating();		
		 		
 		setId(rating, rs, rowNumber); 		
 		setUser(rating, rs, rowNumber); 		
 		setProduct(rating, rs, rowNumber); 		
 		setScore(rating, rs, rowNumber); 		
 		setUpdateTime(rating, rs, rowNumber); 		
 		setVersion(rating, rs, rowNumber);

		return rating;
	}
	
	protected Rating getRating(){
		return new Rating();
	}		
		
	protected void setId(Rating rating, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RatingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		rating.setId(id);
	}
		 		
 	protected void setUser(Rating rating, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(RatingTable.COLUMN_USER);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = rating.getUser();
 		if( profile != null ){
 			//if the root object 'rating' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		rating.setUser(createEmptyUser(profileId));
 	}
 	 		
 	protected void setProduct(Rating rating, ResultSet rs, int rowNumber) throws SQLException{
 		String productId = rs.getString(RatingTable.COLUMN_PRODUCT);
 		if( productId == null){
 			return;
 		}
 		if( productId.isEmpty()){
 			return;
 		}
 		Product product = rating.getProduct();
 		if( product != null ){
 			//if the root object 'rating' already have the property, just set the id for it;
 			product.setId(productId);
 			
 			return;
 		}
 		rating.setProduct(createEmptyProduct(productId));
 	}
 	
	protected void setScore(Rating rating, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer score = rs.getInt(RatingTable.COLUMN_SCORE);
		if(score == null){
			//do nothing when nothing found in database
			return;
		}
		
		rating.setScore(score);
	}
		
	protected void setUpdateTime(Rating rating, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(RatingTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		rating.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(Rating rating, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RatingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		rating.setVersion(version);
	}
		
		

 	protected Profile  createEmptyUser(String profileId){
 		Profile profile = new Profile();
 		profile.setId(profileId);
 		profile.setVersion(Integer.MAX_VALUE);
 		return profile;
 	}
 	
 	protected Product  createEmptyProduct(String productId){
 		Product product = new Product();
 		product.setId(productId);
 		product.setVersion(Integer.MAX_VALUE);
 		return product;
 	}
 	
}


