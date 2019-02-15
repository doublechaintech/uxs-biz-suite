
package com.doublechaintech.uxs.review;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.profile.Profile;

@JsonSerialize(using = ReviewSerializer.class)
public class Review extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String CONTENT_PROPERTY               = "content"           ;
	public static final String USER_PROPERTY                  = "user"              ;
	public static final String PRODUCT_PROPERTY               = "product"           ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Review";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		String              	mContent            ;
	protected		Profile             	mUser               ;
	protected		Product             	mProduct            ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Review(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUser( null );
		setProduct( null );

		this.changed = true;
	}
	
	public 	Review(String title, String content, Profile user, Product product, DateTime updateTime)
	{
		setTitle(title);
		setContent(content);
		setUser(user);
		setProduct(product);
		setUpdateTime(updateTime);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(CONTENT_PROPERTY.equals(property)){
			changeContentProperty(newValueExpr);
		}
		if(UPDATE_TIME_PROPERTY.equals(property)){
			changeUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeContentProperty(String newValueExpr){
		String oldValue = getContent();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContent(newValue);
		this.onChangeProperty(CONTENT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeUpdateTimeProperty(String newValueExpr){
		DateTime oldValue = getUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUpdateTime(newValue);
		this.onChangeProperty(UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Review updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public Review updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	
	
	public void setContent(String content){
		this.mContent = content;;
	}
	public String getContent(){
		return this.mContent;
	}
	public Review updateContent(String content){
		this.mContent = content;;
		this.changed = true;
		return this;
	}
	
	
	public void setUser(Profile user){
		this.mUser = user;;
	}
	public Profile getUser(){
		return this.mUser;
	}
	public Review updateUser(Profile user){
		this.mUser = user;;
		this.changed = true;
		return this;
	}
	
	
	public void clearUser(){
		setUser ( null );
		this.changed = true;
	}
	
	public void setProduct(Product product){
		this.mProduct = product;;
	}
	public Product getProduct(){
		return this.mProduct;
	}
	public Review updateProduct(Product product){
		this.mProduct = product;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProduct(){
		setProduct ( null );
		this.changed = true;
	}
	
	public void setUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
	}
	public DateTime getUpdateTime(){
		return this.mUpdateTime;
	}
	public Review updateUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Review updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getUser(), internalType);
		addToEntityList(this, entityList, getProduct(), internalType);

		
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
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, CONTENT_PROPERTY, getContent());
		appendKeyValuePair(result, USER_PROPERTY, getUser());
		appendKeyValuePair(result, PRODUCT_PROPERTY, getProduct());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Review){
		
		
			Review dest =(Review)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setContent(getContent());
			dest.setUser(getUser());
			dest.setProduct(getProduct());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Review{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tcontent='"+getContent()+"';");
		if(getUser() != null ){
 			stringBuilder.append("\tuser='Profile("+getUser().getId()+")';");
 		}
		if(getProduct() != null ){
 			stringBuilder.append("\tproduct='Product("+getProduct().getId()+")';");
 		}
		stringBuilder.append("\tupdateTime='"+getUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

