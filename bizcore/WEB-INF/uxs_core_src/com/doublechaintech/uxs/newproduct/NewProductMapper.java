
package com.doublechaintech.uxs.newproduct;
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

public class NewProductMapper extends BaseRowMapper<NewProduct>{
	
	protected NewProduct internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		NewProduct newProduct = getNewProduct();		
		 		
 		setId(newProduct, rs, rowNumber); 		
 		setName(newProduct, rs, rowNumber); 		
 		setParentCategory(newProduct, rs, rowNumber); 		
 		setBrand(newProduct, rs, rowNumber); 		
 		setProductCoverImage(newProduct, rs, rowNumber); 		
 		setOrigin(newProduct, rs, rowNumber); 		
 		setCatalog(newProduct, rs, rowNumber); 		
 		setProfile(newProduct, rs, rowNumber); 		
 		setRemark(newProduct, rs, rowNumber); 		
 		setLastUpdateTime(newProduct, rs, rowNumber); 		
 		setPlatform(newProduct, rs, rowNumber); 		
 		setVersion(newProduct, rs, rowNumber);

		return newProduct;
	}
	
	protected NewProduct getNewProduct(){
		return new NewProduct();
	}		
		
	protected void setId(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(NewProductTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		newProduct.setId(id);
	}
		
	protected void setName(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(NewProductTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		newProduct.setName(name);
	}
		 		
 	protected void setParentCategory(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String levelNCategoryId = rs.getString(NewProductTable.COLUMN_PARENT_CATEGORY);
 		if( levelNCategoryId == null){
 			return;
 		}
 		if( levelNCategoryId.isEmpty()){
 			return;
 		}
 		LevelNCategory levelNCategory = newProduct.getParentCategory();
 		if( levelNCategory != null ){
 			//if the root object 'newProduct' already have the property, just set the id for it;
 			levelNCategory.setId(levelNCategoryId);
 			
 			return;
 		}
 		newProduct.setParentCategory(createEmptyParentCategory(levelNCategoryId));
 	}
 	 		
 	protected void setBrand(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String brandId = rs.getString(NewProductTable.COLUMN_BRAND);
 		if( brandId == null){
 			return;
 		}
 		if( brandId.isEmpty()){
 			return;
 		}
 		Brand brand = newProduct.getBrand();
 		if( brand != null ){
 			//if the root object 'newProduct' already have the property, just set the id for it;
 			brand.setId(brandId);
 			
 			return;
 		}
 		newProduct.setBrand(createEmptyBrand(brandId));
 	}
 	
	protected void setProductCoverImage(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String productCoverImage = rs.getString(NewProductTable.COLUMN_PRODUCT_COVER_IMAGE);
		if(productCoverImage == null){
			//do nothing when nothing found in database
			return;
		}
		
		newProduct.setProductCoverImage(productCoverImage);
	}
		
	protected void setOrigin(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String origin = rs.getString(NewProductTable.COLUMN_ORIGIN);
		if(origin == null){
			//do nothing when nothing found in database
			return;
		}
		
		newProduct.setOrigin(origin);
	}
		 		
 	protected void setCatalog(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String catalogId = rs.getString(NewProductTable.COLUMN_CATALOG);
 		if( catalogId == null){
 			return;
 		}
 		if( catalogId.isEmpty()){
 			return;
 		}
 		Catalog catalog = newProduct.getCatalog();
 		if( catalog != null ){
 			//if the root object 'newProduct' already have the property, just set the id for it;
 			catalog.setId(catalogId);
 			
 			return;
 		}
 		newProduct.setCatalog(createEmptyCatalog(catalogId));
 	}
 	 		
 	protected void setProfile(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(NewProductTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = newProduct.getProfile();
 		if( profile != null ){
 			//if the root object 'newProduct' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		newProduct.setProfile(createEmptyProfile(profileId));
 	}
 	
	protected void setRemark(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(NewProductTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		newProduct.setRemark(remark);
	}
		
	protected void setLastUpdateTime(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(NewProductTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		newProduct.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		 		
 	protected void setPlatform(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(NewProductTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = newProduct.getPlatform();
 		if( platform != null ){
 			//if the root object 'newProduct' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		newProduct.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(NewProduct newProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(NewProductTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		newProduct.setVersion(version);
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


