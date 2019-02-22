
package com.doublechaintech.uxs.newproduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;

@JsonSerialize(using = NewProductSerializer.class)
public class NewProduct extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String BRAND_PROPERTY                 = "brand"             ;
	public static final String PRODUCT_COVER_IMAGE_PROPERTY   = "productCoverImage" ;
	public static final String ORIGIN_PROPERTY                = "origin"            ;
	public static final String CATALOG_PROPERTY               = "catalog"           ;
	public static final String PROFILE_PROPERTY               = "profile"           ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="NewProduct";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		LevelNCategory      	mParentCategory     ;
	protected		Brand               	mBrand              ;
	protected		String              	mProductCoverImage  ;
	protected		String              	mOrigin             ;
	protected		Catalog             	mCatalog            ;
	protected		Profile             	mProfile            ;
	protected		String              	mRemark             ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	NewProduct(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setParentCategory( null );
		setBrand( null );
		setCatalog( null );
		setProfile( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	NewProduct(String name, LevelNCategory parentCategory, Brand brand, String productCoverImage, String origin, Catalog catalog, Profile profile, String remark, DateTime lastUpdateTime, Platform platform)
	{
		setName(name);
		setParentCategory(parentCategory);
		setBrand(brand);
		setProductCoverImage(productCoverImage);
		setOrigin(origin);
		setCatalog(catalog);
		setProfile(profile);
		setRemark(remark);
		setLastUpdateTime(lastUpdateTime);
		setPlatform(platform);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			changeProductCoverImageProperty(newValueExpr);
		}
		if(ORIGIN_PROPERTY.equals(property)){
			changeOriginProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeProductCoverImageProperty(String newValueExpr){
		String oldValue = getProductCoverImage();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateProductCoverImage(newValue);
		this.onChangeProperty(PRODUCT_COVER_IMAGE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOriginProperty(String newValueExpr){
		String oldValue = getOrigin();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOrigin(newValue);
		this.onChangeProperty(ORIGIN_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeRemarkProperty(String newValueExpr){
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemark(newValue);
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public NewProduct updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public NewProduct updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setParentCategory(LevelNCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelNCategory getParentCategory(){
		return this.mParentCategory;
	}
	public NewProduct updateParentCategory(LevelNCategory parentCategory){
		this.mParentCategory = parentCategory;;
		this.changed = true;
		return this;
	}
	public void mergeParentCategory(LevelNCategory parentCategory){
		if(parentCategory != null) { setParentCategory(parentCategory);}
	}
	
	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
	}
	
	public void setBrand(Brand brand){
		this.mBrand = brand;;
	}
	public Brand getBrand(){
		return this.mBrand;
	}
	public NewProduct updateBrand(Brand brand){
		this.mBrand = brand;;
		this.changed = true;
		return this;
	}
	public void mergeBrand(Brand brand){
		if(brand != null) { setBrand(brand);}
	}
	
	
	public void clearBrand(){
		setBrand ( null );
		this.changed = true;
	}
	
	public void setProductCoverImage(String productCoverImage){
		this.mProductCoverImage = trimString(encodeUrl(productCoverImage));;
	}
	public String getProductCoverImage(){
		return this.mProductCoverImage;
	}
	public NewProduct updateProductCoverImage(String productCoverImage){
		this.mProductCoverImage = trimString(encodeUrl(productCoverImage));;
		this.changed = true;
		return this;
	}
	public void mergeProductCoverImage(String productCoverImage){
		if(productCoverImage != null) { setProductCoverImage(productCoverImage);}
	}
	
	
	public void setOrigin(String origin){
		this.mOrigin = trimString(origin);;
	}
	public String getOrigin(){
		return this.mOrigin;
	}
	public NewProduct updateOrigin(String origin){
		this.mOrigin = trimString(origin);;
		this.changed = true;
		return this;
	}
	public void mergeOrigin(String origin){
		if(origin != null) { setOrigin(origin);}
	}
	
	
	public void setCatalog(Catalog catalog){
		this.mCatalog = catalog;;
	}
	public Catalog getCatalog(){
		return this.mCatalog;
	}
	public NewProduct updateCatalog(Catalog catalog){
		this.mCatalog = catalog;;
		this.changed = true;
		return this;
	}
	public void mergeCatalog(Catalog catalog){
		if(catalog != null) { setCatalog(catalog);}
	}
	
	
	public void clearCatalog(){
		setCatalog ( null );
		this.changed = true;
	}
	
	public void setProfile(Profile profile){
		this.mProfile = profile;;
	}
	public Profile getProfile(){
		return this.mProfile;
	}
	public NewProduct updateProfile(Profile profile){
		this.mProfile = profile;;
		this.changed = true;
		return this;
	}
	public void mergeProfile(Profile profile){
		if(profile != null) { setProfile(profile);}
	}
	
	
	public void clearProfile(){
		setProfile ( null );
		this.changed = true;
	}
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public NewProduct updateRemark(String remark){
		this.mRemark = trimString(remark);;
		this.changed = true;
		return this;
	}
	public void mergeRemark(String remark){
		if(remark != null) { setRemark(remark);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public NewProduct updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public NewProduct updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public NewProduct updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getParentCategory(), internalType);
		addToEntityList(this, entityList, getBrand(), internalType);
		addToEntityList(this, entityList, getCatalog(), internalType);
		addToEntityList(this, entityList, getProfile(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PARENT_CATEGORY_PROPERTY, getParentCategory());
		appendKeyValuePair(result, BRAND_PROPERTY, getBrand());
		appendKeyValuePair(result, PRODUCT_COVER_IMAGE_PROPERTY, getProductCoverImage());
		appendKeyValuePair(result, ORIGIN_PROPERTY, getOrigin());
		appendKeyValuePair(result, CATALOG_PROPERTY, getCatalog());
		appendKeyValuePair(result, PROFILE_PROPERTY, getProfile());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof NewProduct){
		
		
			NewProduct dest =(NewProduct)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setParentCategory(getParentCategory());
			dest.setBrand(getBrand());
			dest.setProductCoverImage(getProductCoverImage());
			dest.setOrigin(getOrigin());
			dest.setCatalog(getCatalog());
			dest.setProfile(getProfile());
			dest.setRemark(getRemark());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof NewProduct){
		
			
			NewProduct dest =(NewProduct)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeParentCategory(getParentCategory());
			dest.mergeBrand(getBrand());
			dest.mergeProductCoverImage(getProductCoverImage());
			dest.mergeOrigin(getOrigin());
			dest.mergeCatalog(getCatalog());
			dest.mergeProfile(getProfile());
			dest.mergeRemark(getRemark());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("NewProduct{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparentCategory='LevelNCategory("+getParentCategory().getId()+")';");
 		}
		if(getBrand() != null ){
 			stringBuilder.append("\tbrand='Brand("+getBrand().getId()+")';");
 		}
		stringBuilder.append("\tproductCoverImage='"+getProductCoverImage()+"';");
		stringBuilder.append("\torigin='"+getOrigin()+"';");
		if(getCatalog() != null ){
 			stringBuilder.append("\tcatalog='Catalog("+getCatalog().getId()+")';");
 		}
		if(getProfile() != null ){
 			stringBuilder.append("\tprofile='Profile("+getProfile().getId()+")';");
 		}
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

