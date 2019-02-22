
package com.doublechaintech.uxs.site;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class SiteTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="site";
	
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
	protected SiteTokens(){
		//ensure not initialized outside the class
	}
	
	public SiteTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SiteTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SiteTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SiteTokens start(){
		return new SiteTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SiteTokens allTokens(){
		
		return start()
			.withPlatform()
			.withCatalogList();
	
	}
	public static SiteTokens withoutListsTokens(){
		
		return start()
			.withPlatform();
	
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

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public SiteTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String CATALOG_LIST = "catalogList";
	public String getCatalogList(){
		return CATALOG_LIST;
	}
	public SiteTokens withCatalogList(){		
		addSimpleOptions(CATALOG_LIST);
		return this;
	}
	public SiteTokens analyzeCatalogList(){		
		addSimpleOptions(CATALOG_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCatalogListEnabled(){		
		
		return checkOptions(this.options(), CATALOG_LIST+".anaylze");
	}
	public SiteTokens extractMoreFromCatalogList(String idsSeperatedWithComma){		
		addSimpleOptions(CATALOG_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int catalogListSortCounter = 0;
	public SiteTokens sortCatalogListWith(String field, String descOrAsc){		
		addSortMoreOptions(CATALOG_LIST,catalogListSortCounter++, field, descOrAsc);
		return this;
	}
	private int catalogListSearchCounter = 0;
	public SiteTokens searchCatalogListWith(String field, String verb, String value){		
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}
	
	public SiteTokens searchAllTextOfCatalogList(String verb, String value){	
		String field = "id|name|sellerId";
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public SiteTokens rowsPerPageOfCatalogList(int rowsPerPage){		
		addSimpleOptions(CATALOG_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public SiteTokens currentPageNumberOfCatalogList(int currentPageNumber){		
		addSimpleOptions(CATALOG_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public SiteTokens retainColumnsOfCatalogList(String[] columns){		
		addSimpleOptions(CATALOG_LIST+"RetainColumns",columns);
		return this;
	}
	public SiteTokens excludeColumnsOfCatalogList(String[] columns){		
		addSimpleOptions(CATALOG_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  SiteTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfCatalogList(verb, value);	
		return this;
	}
}

