
package com.doublechaintech.uxs.newproduct;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class NewProductTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="newProduct";
	
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
	protected NewProductTokens(){
		//ensure not initialized outside the class
	}
	
	public NewProductTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static NewProductTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected NewProductTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static NewProductTokens start(){
		return new NewProductTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static NewProductTokens allTokens(){
		
		return start()
			.withParentCategory()
			.withBrand()
			.withCatalog()
			.withProfile()
			.withPlatform();
	
	}
	public static NewProductTokens withoutListsTokens(){
		
		return start()
			.withParentCategory()
			.withBrand()
			.withCatalog()
			.withProfile()
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

	protected static final String PARENTCATEGORY = "parentCategory";
	public String getParentCategory(){
		return PARENTCATEGORY;
	}
	public NewProductTokens withParentCategory(){		
		addSimpleOptions(PARENTCATEGORY);
		return this;
	}
	
	
	protected static final String BRAND = "brand";
	public String getBrand(){
		return BRAND;
	}
	public NewProductTokens withBrand(){		
		addSimpleOptions(BRAND);
		return this;
	}
	
	
	protected static final String CATALOG = "catalog";
	public String getCatalog(){
		return CATALOG;
	}
	public NewProductTokens withCatalog(){		
		addSimpleOptions(CATALOG);
		return this;
	}
	
	
	protected static final String PROFILE = "profile";
	public String getProfile(){
		return PROFILE;
	}
	public NewProductTokens withProfile(){		
		addSimpleOptions(PROFILE);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public NewProductTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	
	public  NewProductTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

