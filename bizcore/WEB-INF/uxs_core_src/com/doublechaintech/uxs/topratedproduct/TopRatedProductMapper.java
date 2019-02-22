
package com.doublechaintech.uxs.topratedproduct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;

public class TopRatedProductMapper extends BaseRowMapper<TopRatedProduct>{
	
	protected TopRatedProduct internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TopRatedProduct topRatedProduct = getTopRatedProduct();		
		 		
 		setId(topRatedProduct, rs, rowNumber); 		
 		setName(topRatedProduct, rs, rowNumber); 		
 		setParentCategory(topRatedProduct, rs, rowNumber); 		
 		setBrand(topRatedProduct, rs, rowNumber); 		
 		setProductCoverImage(topRatedProduct, rs, rowNumber); 		
 		setOrigin(topRatedProduct, rs, rowNumber); 		
 		setCatalog(topRatedProduct, rs, rowNumber); 		
 		setRemark(topRatedProduct, rs, rowNumber); 		
 		setLastUpdateTime(topRatedProduct, rs, rowNumber); 		
 		setProfile(topRatedProduct, rs, rowNumber); 		
 		setPlatform(topRatedProduct, rs, rowNumber); 		
 		setVersion(topRatedProduct, rs, rowNumber);

		return topRatedProduct;
	}
	
	protected TopRatedProduct getTopRatedProduct(){
		return new TopRatedProduct();
	}		
		
	protected void setId(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TopRatedProductTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		topRatedProduct.setId(id);
	}
		
	protected void setName(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TopRatedProductTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		topRatedProduct.setName(name);
	}
		 		
 	protected void setParentCategory(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String levelNCategoryId = rs.getString(TopRatedProductTable.COLUMN_PARENT_CATEGORY);
 		if( levelNCategoryId == null){
 			return;
 		}
 		if( levelNCategoryId.isEmpty()){
 			return;
 		}
 		LevelNCategory levelNCategory = topRatedProduct.getParentCategory();
 		if( levelNCategory != null ){
 			//if the root object 'topRatedProduct' already have the property, just set the id for it;
 			levelNCategory.setId(levelNCategoryId);
 			
 			return;
 		}
 		topRatedProduct.setParentCategory(createEmptyParentCategory(levelNCategoryId));
 	}
 	 		
 	protected void setBrand(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String brandId = rs.getString(TopRatedProductTable.COLUMN_BRAND);
 		if( brandId == null){
 			return;
 		}
 		if( brandId.isEmpty()){
 			return;
 		}
 		Brand brand = topRatedProduct.getBrand();
 		if( brand != null ){
 			//if the root object 'topRatedProduct' already have the property, just set the id for it;
 			brand.setId(brandId);
 			
 			return;
 		}
 		topRatedProduct.setBrand(createEmptyBrand(brandId));
 	}
 	
	protected void setProductCoverImage(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String productCoverImage = rs.getString(TopRatedProductTable.COLUMN_PRODUCT_COVER_IMAGE);
		if(productCoverImage == null){
			//do nothing when nothing found in database
			return;
		}
		
		topRatedProduct.setProductCoverImage(productCoverImage);
	}
		
	protected void setOrigin(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String origin = rs.getString(TopRatedProductTable.COLUMN_ORIGIN);
		if(origin == null){
			//do nothing when nothing found in database
			return;
		}
		
		topRatedProduct.setOrigin(origin);
	}
		 		
 	protected void setCatalog(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String catalogId = rs.getString(TopRatedProductTable.COLUMN_CATALOG);
 		if( catalogId == null){
 			return;
 		}
 		if( catalogId.isEmpty()){
 			return;
 		}
 		Catalog catalog = topRatedProduct.getCatalog();
 		if( catalog != null ){
 			//if the root object 'topRatedProduct' already have the property, just set the id for it;
 			catalog.setId(catalogId);
 			
 			return;
 		}
 		topRatedProduct.setCatalog(createEmptyCatalog(catalogId));
 	}
 	
	protected void setRemark(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(TopRatedProductTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		topRatedProduct.setRemark(remark);
	}
		
	protected void setLastUpdateTime(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(TopRatedProductTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		topRatedProduct.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		 		
 	protected void setProfile(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(TopRatedProductTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = topRatedProduct.getProfile();
 		if( profile != null ){
 			//if the root object 'topRatedProduct' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		topRatedProduct.setProfile(createEmptyProfile(profileId));
 	}
 	 		
 	protected void setPlatform(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(TopRatedProductTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = topRatedProduct.getPlatform();
 		if( platform != null ){
 			//if the root object 'topRatedProduct' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		topRatedProduct.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(TopRatedProduct topRatedProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TopRatedProductTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		topRatedProduct.setVersion(version);
	}
		
		

 	protected LevelNCategory  createEmptyParentCategory(String levelNCategoryId){
 		LevelNCategory levelNCategory = new LevelNCategory();
 		levelNCategory.setId(levelNCategoryId);
 		levelNCategory.setVersion(Integer.MAX_VALUE);
 		return levelNCategory;
 	}
 	
 	protected Brand  createEmptyBrand(String brandId){
 		Brand brand = new Brand();
 		brand.setId(brandId);
 		brand.setVersion(Integer.MAX_VALUE);
 		return brand;
 	}
 	
 	protected Catalog  createEmptyCatalog(String catalogId){
 		Catalog catalog = new Catalog();
 		catalog.setId(catalogId);
 		catalog.setVersion(Integer.MAX_VALUE);
 		return catalog;
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


