
package com.doublechaintech.uxs.rating;

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

@JsonSerialize(using = RatingSerializer.class)
public class Rating extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String USER_PROPERTY                  = "user"              ;
	public static final String PRODUCT_PROPERTY               = "product"           ;
	public static final String SCORE_PROPERTY                 = "score"             ;
	public static final String UPDATE_TIME_PROPERTY           = "updateTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Rating";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Profile             	mUser               ;
	protected		Product             	mProduct            ;
	protected		int                 	mScore              ;
	protected		DateTime            	mUpdateTime         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Rating(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUser( null );
		setProduct( null );

		this.changed = true;
	}
	
	public 	Rating(Profile user, Product product, int score, DateTime updateTime)
	{
		setUser(user);
		setProduct(product);
		setScore(score);
		setUpdateTime(updateTime);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(SCORE_PROPERTY.equals(property)){
			changeScoreProperty(newValueExpr);
		}
		if(UPDATE_TIME_PROPERTY.equals(property)){
			changeUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeScoreProperty(String newValueExpr){
		int oldValue = getScore();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateScore(newValue);
		this.onChangeProperty(SCORE_PROPERTY, oldValue, newValue);
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
	public Rating updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setUser(Profile user){
		this.mUser = user;;
	}
	public Profile getUser(){
		return this.mUser;
	}
	public Rating updateUser(Profile user){
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
	public Rating updateProduct(Product product){
		this.mProduct = product;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProduct(){
		setProduct ( null );
		this.changed = true;
	}
	
	public void setScore(int score){
		this.mScore = score;;
	}
	public int getScore(){
		return this.mScore;
	}
	public Rating updateScore(int score){
		this.mScore = score;;
		this.changed = true;
		return this;
	}
	
	
	public void setUpdateTime(DateTime updateTime){
		this.mUpdateTime = updateTime;;
	}
	public DateTime getUpdateTime(){
		return this.mUpdateTime;
	}
	public Rating updateUpdateTime(DateTime updateTime){
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
	public Rating updateVersion(int version){
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
		appendKeyValuePair(result, USER_PROPERTY, getUser());
		appendKeyValuePair(result, PRODUCT_PROPERTY, getProduct());
		appendKeyValuePair(result, SCORE_PROPERTY, getScore());
		appendKeyValuePair(result, UPDATE_TIME_PROPERTY, getUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Rating){
		
		
			Rating dest =(Rating)baseDest;
		
			dest.setId(getId());
			dest.setUser(getUser());
			dest.setProduct(getProduct());
			dest.setScore(getScore());
			dest.setUpdateTime(getUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Rating{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getUser() != null ){
 			stringBuilder.append("\tuser='Profile("+getUser().getId()+")';");
 		}
		if(getProduct() != null ){
 			stringBuilder.append("\tproduct='Product("+getProduct().getId()+")';");
 		}
		stringBuilder.append("\tscore='"+getScore()+"';");
		stringBuilder.append("\tupdateTime='"+getUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseScore(int incScore){
		updateScore(this.mScore +  incScore);
	}
	public void decreaseScore(int decScore){
		updateScore(this.mScore - decScore);
	}
	

}

