
package com.doublechaintech.uxs.banner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.platform.Platform;

@JsonSerialize(using = BannerSerializer.class)
public class Banner extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String IMAGE_PATH_PROPERTY            = "imagePath"         ;
	public static final String LAST_UPDATE_PROPERTY           = "lastUpdate"        ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TARGET_LIST                              = "targetList"        ;

	public static final String INTERNAL_TYPE="Banner";
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
	protected		String              	mImagePath          ;
	protected		DateTime            	mLastUpdate         ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Target>   	mTargetList         ;
	
		
	public 	Banner(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Banner(String name, String imagePath, DateTime lastUpdate, Platform platform)
	{
		setName(name);
		setImagePath(imagePath);
		setLastUpdate(lastUpdate);
		setPlatform(platform);

		this.mTargetList = new SmartList<Target>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(IMAGE_PATH_PROPERTY.equals(property)){
			changeImagePathProperty(newValueExpr);
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
			
			
			
	protected void changeImagePathProperty(String newValueExpr){
		String oldValue = getImagePath();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateImagePath(newValue);
		this.onChangeProperty(IMAGE_PATH_PROPERTY, oldValue, newValue);
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
	public Banner updateId(String id){
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
	public Banner updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setImagePath(String imagePath){
		this.mImagePath = trimString(encodeUrl(imagePath));;
	}
	public String getImagePath(){
		return this.mImagePath;
	}
	public Banner updateImagePath(String imagePath){
		this.mImagePath = trimString(encodeUrl(imagePath));;
		this.changed = true;
		return this;
	}
	public void mergeImagePath(String imagePath){
		if(imagePath != null) { setImagePath(imagePath);}
	}
	
	
	public void setLastUpdate(DateTime lastUpdate){
		this.mLastUpdate = lastUpdate;;
	}
	public DateTime getLastUpdate(){
		return this.mLastUpdate;
	}
	public Banner updateLastUpdate(DateTime lastUpdate){
		this.mLastUpdate = lastUpdate;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdate(DateTime lastUpdate){
		setLastUpdate(lastUpdate);
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Banner updatePlatform(Platform platform){
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
	public Banner updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Target> getTargetList(){
		if(this.mTargetList == null){
			this.mTargetList = new SmartList<Target>();
			this.mTargetList.setListInternalName (TARGET_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTargetList;	
	}
	public  void setTargetList(SmartList<Target> targetList){
		for( Target target:targetList){
			target.setBanner(this);
		}

		this.mTargetList = targetList;
		this.mTargetList.setListInternalName (TARGET_LIST );
		
	}
	
	public  void addTarget(Target target){
		target.setBanner(this);
		getTargetList().add(target);
	}
	public  void addTargetList(SmartList<Target> targetList){
		for( Target target:targetList){
			target.setBanner(this);
		}
		getTargetList().addAll(targetList);
	}
	public  void mergeTargetList(SmartList<Target> targetList){
		if(targetList==null){
			return;
		}
		if(targetList.isEmpty()){
			return;
		}
		addTargetList( targetList );
		
	}
	public  Target removeTarget(Target targetIndex){
		
		int index = getTargetList().indexOf(targetIndex);
        if(index < 0){
        	String message = "Target("+targetIndex.getId()+") with version='"+targetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Target target = getTargetList().get(index);        
        // target.clearBanner(); //disconnect with Banner
        target.clearFromAll(); //disconnect with Banner
		
		boolean result = getTargetList().planToRemove(target);
        if(!result){
        	String message = "Target("+targetIndex.getId()+") with version='"+targetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return target;
        
	
	}
	//断舍离
	public  void breakWithTarget(Target target){
		
		if(target == null){
			return;
		}
		target.setBanner(null);
		//getTargetList().remove();
	
	}
	
	public  boolean hasTarget(Target target){
	
		return getTargetList().contains(target);
  
	}
	
	public void copyTargetFrom(Target target) {

		Target targetInList = findTheTarget(target);
		Target newTarget = new Target();
		targetInList.copyTo(newTarget);
		newTarget.setVersion(0);//will trigger copy
		getTargetList().add(newTarget);
		addItemToFlexiableObject(COPIED_CHILD, newTarget);
	}
	
	public  Target findTheTarget(Target target){
		
		int index =  getTargetList().indexOf(target);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Target("+target.getId()+") with version='"+target.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTargetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTargetList(){
		getTargetList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTargetList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTargetList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, IMAGE_PATH_PROPERTY, getImagePath());
		appendKeyValuePair(result, LAST_UPDATE_PROPERTY, getLastUpdate());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TARGET_LIST, getTargetList());
		if(!getTargetList().isEmpty()){
			appendKeyValuePair(result, "targetCount", getTargetList().getTotalCount());
			appendKeyValuePair(result, "targetCurrentPageNumber", getTargetList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Banner){
		
		
			Banner dest =(Banner)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setImagePath(getImagePath());
			dest.setLastUpdate(getLastUpdate());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setTargetList(getTargetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Banner){
		
			
			Banner dest =(Banner)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeImagePath(getImagePath());
			dest.mergeLastUpdate(getLastUpdate());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeTargetList(getTargetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Banner{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\timagePath='"+getImagePath()+"';");
		stringBuilder.append("\tlastUpdate='"+getLastUpdate()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

