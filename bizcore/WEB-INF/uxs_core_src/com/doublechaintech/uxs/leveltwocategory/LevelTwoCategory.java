
package com.doublechaintech.uxs.leveltwocategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.levelonecategory.LevelOneCategory;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;

@JsonSerialize(using = LevelTwoCategorySerializer.class)
public class LevelTwoCategory extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_N_CATEGORY_LIST                    = "levelNCategoryList";

	public static final String INTERNAL_TYPE="LevelTwoCategory";
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
	protected		LevelOneCategory    	mParentCategory     ;
	protected		String              	mName               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelNCategory>	mLevelNCategoryList ;
	
		
	public 	LevelTwoCategory(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setParentCategory( null );

		this.changed = true;
	}
	
	public 	LevelTwoCategory(LevelOneCategory parentCategory, String name)
	{
		setParentCategory(parentCategory);
		setName(name);

		this.mLevelNCategoryList = new SmartList<LevelNCategory>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public LevelTwoCategory updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setParentCategory(LevelOneCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelOneCategory getParentCategory(){
		return this.mParentCategory;
	}
	public LevelTwoCategory updateParentCategory(LevelOneCategory parentCategory){
		this.mParentCategory = parentCategory;;
		this.changed = true;
		return this;
	}
	
	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public LevelTwoCategory updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LevelTwoCategory updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<LevelNCategory> getLevelNCategoryList(){
		if(this.mLevelNCategoryList == null){
			this.mLevelNCategoryList = new SmartList<LevelNCategory>();
			this.mLevelNCategoryList.setListInternalName (LEVEL_N_CATEGORY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelNCategoryList;	
	}
	public  void setLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList){
		for( LevelNCategory levelNCategory:levelNCategoryList){
			levelNCategory.setParentCategory(this);
		}

		this.mLevelNCategoryList = levelNCategoryList;
		this.mLevelNCategoryList.setListInternalName (LEVEL_N_CATEGORY_LIST );
		
	}
	
	public  void addLevelNCategory(LevelNCategory levelNCategory){
		levelNCategory.setParentCategory(this);
		getLevelNCategoryList().add(levelNCategory);
	}
	public  void addLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList){
		for( LevelNCategory levelNCategory:levelNCategoryList){
			levelNCategory.setParentCategory(this);
		}
		getLevelNCategoryList().addAll(levelNCategoryList);
	}
	
	public  LevelNCategory removeLevelNCategory(LevelNCategory levelNCategoryIndex){
		
		int index = getLevelNCategoryList().indexOf(levelNCategoryIndex);
        if(index < 0){
        	String message = "LevelNCategory("+levelNCategoryIndex.getId()+") with version='"+levelNCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelNCategory levelNCategory = getLevelNCategoryList().get(index);        
        // levelNCategory.clearParentCategory(); //disconnect with ParentCategory
        levelNCategory.clearFromAll(); //disconnect with ParentCategory
		
		boolean result = getLevelNCategoryList().planToRemove(levelNCategory);
        if(!result){
        	String message = "LevelNCategory("+levelNCategoryIndex.getId()+") with version='"+levelNCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelNCategory;
        
	
	}
	//断舍离
	public  void breakWithLevelNCategory(LevelNCategory levelNCategory){
		
		if(levelNCategory == null){
			return;
		}
		levelNCategory.setParentCategory(null);
		//getLevelNCategoryList().remove();
	
	}
	
	public  boolean hasLevelNCategory(LevelNCategory levelNCategory){
	
		return getLevelNCategoryList().contains(levelNCategory);
  
	}
	
	public void copyLevelNCategoryFrom(LevelNCategory levelNCategory) {

		LevelNCategory levelNCategoryInList = findTheLevelNCategory(levelNCategory);
		LevelNCategory newLevelNCategory = new LevelNCategory();
		levelNCategoryInList.copyTo(newLevelNCategory);
		newLevelNCategory.setVersion(0);//will trigger copy
		getLevelNCategoryList().add(newLevelNCategory);
		addItemToFlexiableObject(COPIED_CHILD, newLevelNCategory);
	}
	
	public  LevelNCategory findTheLevelNCategory(LevelNCategory levelNCategory){
		
		int index =  getLevelNCategoryList().indexOf(levelNCategory);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelNCategory("+levelNCategory.getId()+") with version='"+levelNCategory.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelNCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelNCategoryList(){
		getLevelNCategoryList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getParentCategory(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLevelNCategoryList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLevelNCategoryList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, PARENT_CATEGORY_PROPERTY, getParentCategory());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEVEL_N_CATEGORY_LIST, getLevelNCategoryList());
		if(!getLevelNCategoryList().isEmpty()){
			appendKeyValuePair(result, "levelNCategoryCount", getLevelNCategoryList().getTotalCount());
			appendKeyValuePair(result, "levelNCategoryCurrentPageNumber", getLevelNCategoryList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelTwoCategory){
		
		
			LevelTwoCategory dest =(LevelTwoCategory)baseDest;
		
			dest.setId(getId());
			dest.setParentCategory(getParentCategory());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setLevelNCategoryList(getLevelNCategoryList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LevelTwoCategory{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparentCategory='LevelOneCategory("+getParentCategory().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

