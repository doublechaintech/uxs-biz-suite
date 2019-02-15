
package com.doublechaintech.uxs.review;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class ReviewTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="review";
	
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
	protected ReviewTokens(){
		//ensure not initialized outside the class
	}
	
	public ReviewTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ReviewTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ReviewTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ReviewTokens start(){
		return new ReviewTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ReviewTokens allTokens(){
		
		return start()
			.withUser()
			.withProduct();
	
	}
	public static ReviewTokens withoutListsTokens(){
		
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
	public ReviewTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String PRODUCT = "product";
	public String getProduct(){
		return PRODUCT;
	}
	public ReviewTokens withProduct(){		
		addSimpleOptions(PRODUCT);
		return this;
	}
	
	
	
	public  ReviewTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

