
package com.doublechaintech.uxs.pricefilter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.profile.Profile;

@JsonSerialize(using = PriceFilterSerializer.class)
public class PriceFilter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PRICE_START_PROPERTY           = "priceStart"        ;
	public static final String PRICE_END_PROPERTY             = "priceEnd"          ;
	public static final String PROFILE_PROPERTY               = "profile"           ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="PriceFilter";
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
	protected		BigDecimal          	mPriceStart         ;
	protected		BigDecimal          	mPriceEnd           ;
	protected		Profile             	mProfile            ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	PriceFilter(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProfile( null );

		this.changed = true;
	}
	
	public 	PriceFilter(String name, BigDecimal priceStart, BigDecimal priceEnd, Profile profile)
	{
		setName(name);
		setPriceStart(priceStart);
		setPriceEnd(priceEnd);
		setProfile(profile);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(PRICE_START_PROPERTY.equals(property)){
			changePriceStartProperty(newValueExpr);
		}
		if(PRICE_END_PROPERTY.equals(property)){
			changePriceEndProperty(newValueExpr);
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
			
			
			
	protected void changePriceStartProperty(String newValueExpr){
		BigDecimal oldValue = getPriceStart();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePriceStart(newValue);
		this.onChangeProperty(PRICE_START_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePriceEndProperty(String newValueExpr){
		BigDecimal oldValue = getPriceEnd();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePriceEnd(newValue);
		this.onChangeProperty(PRICE_END_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public PriceFilter updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public PriceFilter updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setPriceStart(BigDecimal priceStart){
		this.mPriceStart = priceStart;;
	}
	public BigDecimal getPriceStart(){
		return this.mPriceStart;
	}
	public PriceFilter updatePriceStart(BigDecimal priceStart){
		this.mPriceStart = priceStart;;
		this.changed = true;
		return this;
	}
	
	
	public void setPriceEnd(BigDecimal priceEnd){
		this.mPriceEnd = priceEnd;;
	}
	public BigDecimal getPriceEnd(){
		return this.mPriceEnd;
	}
	public PriceFilter updatePriceEnd(BigDecimal priceEnd){
		this.mPriceEnd = priceEnd;;
		this.changed = true;
		return this;
	}
	
	
	public void setProfile(Profile profile){
		this.mProfile = profile;;
	}
	public Profile getProfile(){
		return this.mProfile;
	}
	public PriceFilter updateProfile(Profile profile){
		this.mProfile = profile;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProfile(){
		setProfile ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public PriceFilter updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProfile(), internalType);

		
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
		appendKeyValuePair(result, PRICE_START_PROPERTY, getPriceStart());
		appendKeyValuePair(result, PRICE_END_PROPERTY, getPriceEnd());
		appendKeyValuePair(result, PROFILE_PROPERTY, getProfile());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PriceFilter){
		
		
			PriceFilter dest =(PriceFilter)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPriceStart(getPriceStart());
			dest.setPriceEnd(getPriceEnd());
			dest.setProfile(getProfile());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PriceFilter{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tpriceStart='"+getPriceStart()+"';");
		stringBuilder.append("\tpriceEnd='"+getPriceEnd()+"';");
		if(getProfile() != null ){
 			stringBuilder.append("\tprofile='Profile("+getProfile().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

