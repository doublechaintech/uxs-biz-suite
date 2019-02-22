
package com.doublechaintech.uxs.recommandproduct;
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

public class RecommandProductMapper extends BaseRowMapper<RecommandProduct>{
	
	protected RecommandProduct internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RecommandProduct recommandProduct = getRecommandProduct();		
		 		
 		setId(recommandProduct, rs, rowNumber); 		
 		setName(recommandProduct, rs, rowNumber); 		
 		setParentCategory(recommandProduct, rs, rowNumber); 		
 		setBrand(recommandProduct, rs, rowNumber); 		
 		setProductCoverImage(recommandProduct, rs, rowNumber); 		
 		setOrigin(recommandProduct, rs, rowNumber); 		
 		setCatalog(recommandProduct, rs, rowNumber); 		
 		setRemark(recommandProduct, rs, rowNumber); 		
 		setLastUpdateTime(recommandProduct, rs, rowNumber); 		
 		setProfile(recommandProduct, rs, rowNumber); 		
 		setPlatform(recommandProduct, rs, rowNumber); 		
 		setVersion(recommandProduct, rs, rowNumber);

		return recommandProduct;
	}
	
	protected RecommandProduct getRecommandProduct(){
		return new RecommandProduct();
	}		
		
	protected void setId(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RecommandProductTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		recommandProduct.setId(id);
	}
		
	protected void setName(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(RecommandProductTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		recommandProduct.setName(name);
	}
		 		
 	protected void setParentCategory(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String levelNCategoryId = rs.getString(RecommandProductTable.COLUMN_PARENT_CATEGORY);
 		if( levelNCategoryId == null){
 			return;
 		}
 		if( levelNCategoryId.isEmpty()){
 			return;
 		}
 		LevelNCategory levelNCategory = recommandProduct.getParentCategory();
 		if( levelNCategory != null ){
 			//if the root object 'recommandProduct' already have the property, just set the id for it;
 			levelNCategory.setId(levelNCategoryId);
 			
 			return;
 		}
 		recommandProduct.setParentCategory(createEmptyParentCategory(levelNCategoryId));
 	}
 	 		
 	protected void setBrand(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String brandId = rs.getString(RecommandProductTable.COLUMN_BRAND);
 		if( brandId == null){
 			return;
 		}
 		if( brandId.isEmpty()){
 			return;
 		}
 		Brand brand = recommandProduct.getBrand();
 		if( brand != null ){
 			//if the root object 'recommandProduct' already have the property, just set the id for it;
 			brand.setId(brandId);
 			
 			return;
 		}
 		recommandProduct.setBrand(createEmptyBrand(brandId));
 	}
 	
	protected void setProductCoverImage(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String productCoverImage = rs.getString(RecommandProductTable.COLUMN_PRODUCT_COVER_IMAGE);
		if(productCoverImage == null){
			//do nothing when nothing found in database
			return;
		}
		
		recommandProduct.setProductCoverImage(productCoverImage);
	}
		
	protected void setOrigin(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String origin = rs.getString(RecommandProductTable.COLUMN_ORIGIN);
		if(origin == null){
			//do nothing when nothing found in database
			return;
		}
		
		recommandProduct.setOrigin(origin);
	}
		 		
 	protected void setCatalog(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String catalogId = rs.getString(RecommandProductTable.COLUMN_CATALOG);
 		if( catalogId == null){
 			return;
 		}
 		if( catalogId.isEmpty()){
 			return;
 		}
 		Catalog catalog = recommandProduct.getCatalog();
 		if( catalog != null ){
 			//if the root object 'recommandProduct' already have the property, just set the id for it;
 			catalog.setId(catalogId);
 			
 			return;
 		}
 		recommandProduct.setCatalog(createEmptyCatalog(catalogId));
 	}
 	
	protected void setRemark(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(RecommandProductTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		recommandProduct.setRemark(remark);
	}
		
	protected void setLastUpdateTime(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(RecommandProductTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		recommandProduct.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		 		
 	protected void setProfile(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(RecommandProductTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = recommandProduct.getProfile();
 		if( profile != null ){
 			//if the root object 'recommandProduct' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		recommandProduct.setProfile(createEmptyProfile(profileId));
 	}
 	 		
 	protected void setPlatform(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(RecommandProductTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = recommandProduct.getPlatform();
 		if( platform != null ){
 			//if the root object 'recommandProduct' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		recommandProduct.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(RecommandProduct recommandProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RecommandProductTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		recommandProduct.setVersion(version);
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


