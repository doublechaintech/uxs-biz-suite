
package com.doublechaintech.uxs.leveltwocategory;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class LevelTwoCategoryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="levelTwoCategory";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected LevelTwoCategoryTokens(){
		//ensure not initialized outside the class
	}
	
	public LevelTwoCategoryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LevelTwoCategoryTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LevelTwoCategoryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LevelTwoCategoryTokens start(){
		return new LevelTwoCategoryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LevelTwoCategoryTokens allTokens(){
		
		return start()
			.withParentCategory()
			.withLevelNCategoryList();
	
	}
	public static LevelTwoCategoryTokens withoutListsTokens(){
		
		return start()
			.withParentCategory();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String PARENTCATEGORY = "parentCategory";
	public String getParentCategory(){
		return PARENTCATEGORY;
	}
	public LevelTwoCategoryTokens withParentCategory(){		
		addSimpleOptions(PARENTCATEGORY);
		return this;
	}
	
	
	protected static final String LEVEL_N_CATEGORY_LIST = "levelNCategoryList";
	public String getLevelNCategoryList(){
		return LEVEL_N_CATEGORY_LIST;
	}
	public LevelTwoCategoryTokens withLevelNCategoryList(){		
		addSimpleOptions(LEVEL_N_CATEGORY_LIST);
		return this;
	}
	public LevelTwoCategoryTokens analyzeLevelNCategoryList(){		
		addSimpleOptions(LEVEL_N_CATEGORY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLevelNCategoryListEnabled(){		
		
		return checkOptions(this.options(), LEVEL_N_CATEGORY_LIST+".anaylze");
	}
	public LevelTwoCategoryTokens extractMoreFromLevelNCategoryList(String idsSeperatedWithComma){		
		addSimpleOptions(LEVEL_N_CATEGORY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int levelNCategoryListSortCounter = 0;
	public LevelTwoCategoryTokens sortLevelNCategoryListWith(String field, String descOrAsc){		
		addSortMoreOptions(LEVEL_N_CATEGORY_LIST,levelNCategoryListSortCounter++, field, descOrAsc);
		return this;
	}
	private int levelNCategoryListSearchCounter = 0;
	public LevelTwoCategoryTokens searchLevelNCategoryListWith(String field, String verb, String value){		
		addSearchMoreOptions(LEVEL_N_CATEGORY_LIST,levelNCategoryListSearchCounter++, field, verb, value);
		return this;
	}
	
	public LevelTwoCategoryTokens searchAllTextOfLevelNCategoryList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(LEVEL_N_CATEGORY_LIST,levelNCategoryListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LevelTwoCategoryTokens rowsPerPageOfLevelNCategoryList(int rowsPerPage){		
		addSimpleOptions(LEVEL_N_CATEGORY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LevelTwoCategoryTokens currentPageNumberOfLevelNCategoryList(int currentPageNumber){		
		addSimpleOptions(LEVEL_N_CATEGORY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LevelTwoCategoryTokens retainColumnsOfLevelNCategoryList(String[] columns){		
		addSimpleOptions(LEVEL_N_CATEGORY_LIST+"RetainColumns",columns);
		return this;
	}
	public LevelTwoCategoryTokens excludeColumnsOfLevelNCategoryList(String[] columns){		
		addSimpleOptions(LEVEL_N_CATEGORY_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  LevelTwoCategoryTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfLevelNCategoryList(verb, value);	
		return this;
	}
}

