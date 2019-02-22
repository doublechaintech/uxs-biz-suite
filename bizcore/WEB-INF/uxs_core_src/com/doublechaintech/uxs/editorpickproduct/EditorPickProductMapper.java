
package com.doublechaintech.uxs.editorpickproduct;
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

public class EditorPickProductMapper extends BaseRowMapper<EditorPickProduct>{
	
	protected EditorPickProduct internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		EditorPickProduct editorPickProduct = getEditorPickProduct();		
		 		
 		setId(editorPickProduct, rs, rowNumber); 		
 		setName(editorPickProduct, rs, rowNumber); 		
 		setParentCategory(editorPickProduct, rs, rowNumber); 		
 		setBrand(editorPickProduct, rs, rowNumber); 		
 		setProductCoverImage(editorPickProduct, rs, rowNumber); 		
 		setOrigin(editorPickProduct, rs, rowNumber); 		
 		setCatalog(editorPickProduct, rs, rowNumber); 		
 		setProfile(editorPickProduct, rs, rowNumber); 		
 		setRemark(editorPickProduct, rs, rowNumber); 		
 		setLastUpdateTime(editorPickProduct, rs, rowNumber); 		
 		setPlatform(editorPickProduct, rs, rowNumber); 		
 		setVersion(editorPickProduct, rs, rowNumber);

		return editorPickProduct;
	}
	
	protected EditorPickProduct getEditorPickProduct(){
		return new EditorPickProduct();
	}		
		
	protected void setId(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(EditorPickProductTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		editorPickProduct.setId(id);
	}
		
	protected void setName(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(EditorPickProductTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		editorPickProduct.setName(name);
	}
		 		
 	protected void setParentCategory(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String levelNCategoryId = rs.getString(EditorPickProductTable.COLUMN_PARENT_CATEGORY);
 		if( levelNCategoryId == null){
 			return;
 		}
 		if( levelNCategoryId.isEmpty()){
 			return;
 		}
 		LevelNCategory levelNCategory = editorPickProduct.getParentCategory();
 		if( levelNCategory != null ){
 			//if the root object 'editorPickProduct' already have the property, just set the id for it;
 			levelNCategory.setId(levelNCategoryId);
 			
 			return;
 		}
 		editorPickProduct.setParentCategory(createEmptyParentCategory(levelNCategoryId));
 	}
 	 		
 	protected void setBrand(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String brandId = rs.getString(EditorPickProductTable.COLUMN_BRAND);
 		if( brandId == null){
 			return;
 		}
 		if( brandId.isEmpty()){
 			return;
 		}
 		Brand brand = editorPickProduct.getBrand();
 		if( brand != null ){
 			//if the root object 'editorPickProduct' already have the property, just set the id for it;
 			brand.setId(brandId);
 			
 			return;
 		}
 		editorPickProduct.setBrand(createEmptyBrand(brandId));
 	}
 	
	protected void setProductCoverImage(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String productCoverImage = rs.getString(EditorPickProductTable.COLUMN_PRODUCT_COVER_IMAGE);
		if(productCoverImage == null){
			//do nothing when nothing found in database
			return;
		}
		
		editorPickProduct.setProductCoverImage(productCoverImage);
	}
		
	protected void setOrigin(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String origin = rs.getString(EditorPickProductTable.COLUMN_ORIGIN);
		if(origin == null){
			//do nothing when nothing found in database
			return;
		}
		
		editorPickProduct.setOrigin(origin);
	}
		 		
 	protected void setCatalog(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String catalogId = rs.getString(EditorPickProductTable.COLUMN_CATALOG);
 		if( catalogId == null){
 			return;
 		}
 		if( catalogId.isEmpty()){
 			return;
 		}
 		Catalog catalog = editorPickProduct.getCatalog();
 		if( catalog != null ){
 			//if the root object 'editorPickProduct' already have the property, just set the id for it;
 			catalog.setId(catalogId);
 			
 			return;
 		}
 		editorPickProduct.setCatalog(createEmptyCatalog(catalogId));
 	}
 	 		
 	protected void setProfile(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String profileId = rs.getString(EditorPickProductTable.COLUMN_PROFILE);
 		if( profileId == null){
 			return;
 		}
 		if( profileId.isEmpty()){
 			return;
 		}
 		Profile profile = editorPickProduct.getProfile();
 		if( profile != null ){
 			//if the root object 'editorPickProduct' already have the property, just set the id for it;
 			profile.setId(profileId);
 			
 			return;
 		}
 		editorPickProduct.setProfile(createEmptyProfile(profileId));
 	}
 	
	protected void setRemark(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(EditorPickProductTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		editorPickProduct.setRemark(remark);
	}
		
	protected void setLastUpdateTime(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(EditorPickProductTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		editorPickProduct.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		 		
 	protected void setPlatform(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(EditorPickProductTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = editorPickProduct.getPlatform();
 		if( platform != null ){
 			//if the root object 'editorPickProduct' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		editorPickProduct.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(EditorPickProduct editorPickProduct, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(EditorPickProductTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		editorPickProduct.setVersion(version);
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


