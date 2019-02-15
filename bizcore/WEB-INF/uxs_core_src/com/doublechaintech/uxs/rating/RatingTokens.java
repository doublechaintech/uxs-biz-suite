
package com.doublechaintech.uxs.rating;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class RatingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="rating";
	
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
	protected RatingTokens(){
		//ensure not initialized outside the class
	}
	
	public RatingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RatingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RatingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RatingTokens start(){
		return new RatingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RatingTokens allTokens(){
		
		return start()
			.withUser()
			.withProduct();
	
	}
	public static RatingTokens withoutListsTokens(){
		
		return start()
			.withUser()
			.withProduct();
	
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

	protected static final String USER = "user";
	public String getUser(){
		return USER;
	}
	public RatingTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String PRODUCT = "product";
	public String getProduct(){
		return PRODUCT;
	}
	public RatingTokens withProduct(){		
		addSimpleOptions(PRODUCT);
		return this;
	}
	
	
	
	public  RatingTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

