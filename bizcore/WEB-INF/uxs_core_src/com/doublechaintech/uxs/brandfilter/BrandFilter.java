
package com.doublechaintech.uxs.brandfilter;

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

@JsonSerialize(using = BrandFilterSerializer.class)
public class BrandFilter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String INTERNAL_ID_PROPERTY           = "internalId"        ;
	public static final String PROFILE_PROPERTY               = "profile"           ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="BrandFilter";
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
	protected		String              	mInternalId         ;
	protected		Profile             	mProfile            ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	BrandFilter(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProfile( null );

		this.changed = true;
	}
	
	public 	BrandFilter(String name, String internalId, Profile profile)
	{
		setName(name);
		setInternalId(internalId);
		setProfile(profile);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(INTERNAL_ID_PROPERTY.equals(property)){
			changeInternalIdProperty(newValueExpr);
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
			
			
			
	protected void changeInternalIdProperty(String newValueExpr){
		String oldValue = getInternalId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateInternalId(newValue);
		this.onChangeProperty(INTERNAL_ID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public BrandFilter updateId(String id){
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
	public BrandFilter updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setInternalId(String internalId){
		this.mInternalId = trimString(internalId);;
	}
	public String getInternalId(){
		return this.mInternalId;
	}
	public BrandFilter updateInternalId(String internalId){
		this.mInternalId = trimString(internalId);;
		this.changed = true;
		return this;
	}
	public void mergeInternalId(String internalId){
		if(internalId != null) { setInternalId(internalId);}
	}
	
	
	public void clearInternalId(){
		setInternalId ( null );
		this.changed = true;
	}
	
	public void setProfile(Profile profile){
		this.mProfile = profile;;
	}
	public Profile getProfile(){
		return this.mProfile;
	}
	public BrandFilter updateProfile(Profile profile){
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
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public BrandFilter updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
		appendKeyValuePair(result, INTERNAL_ID_PROPERTY, getInternalId());
		appendKeyValuePair(result, PROFILE_PROPERTY, getProfile());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof BrandFilter){
		
		
			BrandFilter dest =(BrandFilter)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setInternalId(getInternalId());
			dest.setProfile(getProfile());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof BrandFilter){
		
			
			BrandFilter dest =(BrandFilter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeInternalId(getInternalId());
			dest.mergeProfile(getProfile());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("BrandFilter{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tinternalId='"+getInternalId()+"';");
		if(getProfile() != null ){
 			stringBuilder.append("\tprofile='Profile("+getProfile().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

