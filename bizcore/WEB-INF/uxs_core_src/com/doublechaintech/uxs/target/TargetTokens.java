
package com.doublechaintech.uxs.target;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class TargetTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="target";
	
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
	protected TargetTokens(){
		//ensure not initialized outside the class
	}
	
	public TargetTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TargetTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TargetTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TargetTokens start(){
		return new TargetTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TargetTokens allTokens(){
		
		return start()
			.withProfile()
			.withBanner();
	
	}
	public static TargetTokens withoutListsTokens(){
		
		return start()
			.withProfile()
			.withBanner();
	
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
	public TargetTokens withProfile(){		
		addSimpleOptions(PROFILE);
		return this;
	}
	
	
	protected static final String BANNER = "banner";
	public String getBanner(){
		return BANNER;
	}
	public TargetTokens withBanner(){		
		addSimpleOptions(BANNER);
		return this;
	}
	
	
	
	public  TargetTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

