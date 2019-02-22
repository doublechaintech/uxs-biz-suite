
package com.doublechaintech.uxs.target;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.profile.Profile;

@JsonSerialize(using = TargetSerializer.class)
public class Target extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PROFILE_PROPERTY               = "profile"           ;
	public static final String BANNER_PROPERTY                = "banner"            ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String LAST_UPDATE_PROPERTY           = "lastUpdate"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Target";
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
	protected		Profile             	mProfile            ;
	protected		Banner              	mBanner             ;
	protected		String              	mLocation           ;
	protected		DateTime            	mLastUpdate         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Target(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProfile( null );
		setBanner( null );

		this.changed = true;
	}
	
	public 	Target(String name, Profile profile, Banner banner, String location, DateTime lastUpdate)
	{
		setName(name);
		setProfile(profile);
		setBanner(banner);
		setLocation(location);
		setLastUpdate(lastUpdate);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}
		if(LAST_UPDATE_PROPERTY.equals(property)){
			changeLastUpdateProperty(newValueExpr);
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
			
			
			
	protected void changeLocationProperty(String newValueExpr){
		String oldValue = getLocation();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLocation(newValue);
		this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateProperty(String newValueExpr){
		DateTime oldValue = getLastUpdate();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdate(newValue);
		this.onChangeProperty(LAST_UPDATE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Target updateId(String id){
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
	public Target updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setProfile(Profile profile){
		this.mProfile = profile;;
	}
	public Profile getProfile(){
		return this.mProfile;
	}
	public Target updateProfile(Profile profile){
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
	
	public void setBanner(Banner banner){
		this.mBanner = banner;;
	}
	public Banner getBanner(){
		return this.mBanner;
	}
	public Target updateBanner(Banner banner){
		this.mBanner = banner;;
		this.changed = true;
		return this;
	}
	public void mergeBanner(Banner banner){
		if(banner != null) { setBanner(banner);}
	}
	
	
	public void clearBanner(){
		setBanner ( null );
		this.changed = true;
	}
	
	public void setLocation(String location){
		this.mLocation = trimString(location);;
	}
	public String getLocation(){
		return this.mLocation;
	}
	public Target updateLocation(String location){
		this.mLocation = trimString(location);;
		this.changed = true;
		return this;
	}
	public void mergeLocation(String location){
		if(location != null) { setLocation(location);}
	}
	
	
	public void setLastUpdate(DateTime lastUpdate){
		this.mLastUpdate = lastUpdate;;
	}
	public DateTime getLastUpdate(){
		return this.mLastUpdate;
	}
	public Target updateLastUpdate(DateTime lastUpdate){
		this.mLastUpdate = lastUpdate;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdate(DateTime lastUpdate){
		setLastUpdate(lastUpdate);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Target updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProfile(), internalType);
		addToEntityList(this, entityList, getBanner(), internalType);

		
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
		appendKeyValuePair(result, PROFILE_PROPERTY, getProfile());
		appendKeyValuePair(result, BANNER_PROPERTY, getBanner());
		appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
		appendKeyValuePair(result, LAST_UPDATE_PROPERTY, getLastUpdate());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Target){
		
		
			Target dest =(Target)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setProfile(getProfile());
			dest.setBanner(getBanner());
			dest.setLocation(getLocation());
			dest.setLastUpdate(getLastUpdate());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Target){
		
			
			Target dest =(Target)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeProfile(getProfile());
			dest.mergeBanner(getBanner());
			dest.mergeLocation(getLocation());
			dest.mergeLastUpdate(getLastUpdate());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Target{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getProfile() != null ){
 			stringBuilder.append("\tprofile='Profile("+getProfile().getId()+")';");
 		}
		if(getBanner() != null ){
 			stringBuilder.append("\tbanner='Banner("+getBanner().getId()+")';");
 		}
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tlastUpdate='"+getLastUpdate()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

