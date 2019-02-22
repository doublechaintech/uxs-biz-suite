
package com.doublechaintech.uxs.brandfilter;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class BrandFilterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="brandFilter";
	
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
	protected BrandFilterTokens(){
		//ensure not initialized outside the class
	}
	
	public BrandFilterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static BrandFilterTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected BrandFilterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static BrandFilterTokens start(){
		return new BrandFilterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static BrandFilterTokens allTokens(){
		
		return start()
			.withProfile();
	
	}
	public static BrandFilterTokens withoutListsTokens(){
		
		return start()
			.withProfile();
	
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

	protected static final String PROFILE = "profile";
	public String getProfile(){
		return PROFILE;
	}
	public BrandFilterTokens withProfile(){		
		addSimpleOptions(PROFILE);
		return this;
	}
	
	
	
	public  BrandFilterTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

