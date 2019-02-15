
package com.doublechaintech.uxs.blog;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class BlogTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="blog";
	
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
	protected BlogTokens(){
		//ensure not initialized outside the class
	}
	
	public BlogTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static BlogTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected BlogTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static BlogTokens start(){
		return new BlogTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static BlogTokens allTokens(){
		
		return start()
			.withUser()
			.withProduct();
	
	}
	public static BlogTokens withoutListsTokens(){
		
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
	public BlogTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String PRODUCT = "product";
	public String getProduct(){
		return PRODUCT;
	}
	public BlogTokens withProduct(){		
		addSimpleOptions(PRODUCT);
		return this;
	}
	
	
	
	public  BlogTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

