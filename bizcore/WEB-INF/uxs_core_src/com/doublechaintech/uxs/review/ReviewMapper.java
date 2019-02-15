
package com.doublechaintech.uxs.review;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.profile.Profile;

public class ReviewMapper extends BaseRowMapper<Review>{
	
	protected Review internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Review review = getReview();		
		 		
 		setId(review, rs, rowNumber); 		
 		setTitle(review, rs, rowNumber); 		
 		setContent(review, rs, rowNumber); 		
 		setUser(review, rs, rowNumber); 		
 		setProduct(review, rs, rowNumber); 		
 		setUpdateTime(review, rs, rowNumber); 		
 		setVersion(review, rs, rowNumber);

		return review;
	}
	
	protected Review getReview(){
		return new Review();
	}		
		
	protected void setId(Review review, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ReviewTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		review.setId(id);
	}
		
	protected void setTitle(Review review, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(ReviewTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		review.setTitle(title);
	}
		
	protected void setContent(Review review, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String content = rs.getString(ReviewTable.COLUMN_CONTENT);
		if(content == null){
			//do nothing when nothing found in database
			return;
		}
		
		review.setContent(content);
	}
		 		
 	protected void setUser(Review review, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(ReviewTable.COLUMN_USER);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = review.getUser();
 		if( profile != null ){
 			//if the root object 'review' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		review.setUser(createEmptyUser(profileId));
 	}
 	 		
 	protected void setProduct(Review review, ResultSet rs, int rowNumber) throws SQLException{
 		String productId = rs.getString(ReviewTable.COLUMN_PRODUCT);
 		if( productId == null){
 			return;
 		}
 		if( productId.isEmpty()){
 			return;
 		}
 		Product product = review.getProduct();
 		if( product != null ){
 			//if the root object 'review' already have the property, just set the id for it;
 			product.setId(productId);
 			
 			return;
 		}
 		review.setProduct(createEmptyProduct(productId));
 	}
 	
	protected void setUpdateTime(Review review, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(ReviewTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		review.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(Review review, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ReviewTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		review.setVersion(version);
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


