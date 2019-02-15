
package com.doublechaintech.uxs.blog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.profile.Profile;

public class BlogMapper extends BaseRowMapper<Blog>{
	
	protected Blog internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Blog blog = getBlog();		
		 		
 		setId(blog, rs, rowNumber); 		
 		setTitle(blog, rs, rowNumber); 		
 		setContent(blog, rs, rowNumber); 		
 		setUser(blog, rs, rowNumber); 		
 		setProduct(blog, rs, rowNumber); 		
 		setUpdateTime(blog, rs, rowNumber); 		
 		setVersion(blog, rs, rowNumber);

		return blog;
	}
	
	protected Blog getBlog(){
		return new Blog();
	}		
		
	protected void setId(Blog blog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(BlogTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		blog.setId(id);
	}
		
	protected void setTitle(Blog blog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(BlogTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		blog.setTitle(title);
	}
		
	protected void setContent(Blog blog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String content = rs.getString(BlogTable.COLUMN_CONTENT);
		if(content == null){
			//do nothing when nothing found in database
			return;
		}
		
		blog.setContent(content);
	}
		 		
 	protected void setUser(Blog blog, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(BlogTable.COLUMN_USER);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = blog.getUser();
 		if( profile != null ){
 			//if the root object 'blog' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		blog.setUser(createEmptyUser(profileId));
 	}
 	 		
 	protected void setProduct(Blog blog, ResultSet rs, int rowNumber) throws SQLException{
 		String productId = rs.getString(BlogTable.COLUMN_PRODUCT);
 		if( productId == null){
 			return;
 		}
 		if( productId.isEmpty()){
 			return;
 		}
 		Product product = blog.getProduct();
 		if( product != null ){
 			//if the root object 'blog' already have the property, just set the id for it;
 			product.setId(productId);
 			
 			return;
 		}
 		blog.setProduct(createEmptyProduct(productId));
 	}
 	
	protected void setUpdateTime(Blog blog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date updateTime = rs.getTimestamp(BlogTable.COLUMN_UPDATE_TIME);
		if(updateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		blog.setUpdateTime(convertToDateTime(updateTime));
	}
		
	protected void setVersion(Blog blog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(BlogTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		blog.setVersion(version);
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


