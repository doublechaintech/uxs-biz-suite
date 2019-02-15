package com.doublechaintech.uxs.platform;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}

	
	

	



	public PlatformForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public PlatformForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public PlatformForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public PlatformForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public PlatformForm platformIdFieldForProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProduct(String initValue){
		return platformIdFieldForProduct("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProduct(){
		return platformIdFieldForProduct("platformId","");
	}


	public PlatformForm avarageScoreFieldForProduct(String parameterName, String initValue){
		FormField field =  avarageScoreFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm avarageScoreFieldForProduct(String initValue){
		return avarageScoreFieldForProduct("avarageScore",initValue);
	}
	public PlatformForm avarageScoreFieldForProduct(){
		return avarageScoreFieldForProduct("avarageScore","");
	}


	public PlatformForm bannerIdFieldForBanner(String parameterName, String initValue){
		FormField field =  idFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm bannerIdFieldForBanner(String initValue){
		return bannerIdFieldForBanner("bannerId",initValue);
	}
	public PlatformForm bannerIdFieldForBanner(){
		return bannerIdFieldForBanner("bannerId","");
	}


	public PlatformForm nameFieldForBanner(String parameterName, String initValue){
		FormField field =  nameFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForBanner(String initValue){
		return nameFieldForBanner("name",initValue);
	}
	public PlatformForm nameFieldForBanner(){
		return nameFieldForBanner("name","");
	}


	public PlatformForm imagePathFieldForBanner(String parameterName, String initValue){
		FormField field =  imagePathFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm imagePathFieldForBanner(String initValue){
		return imagePathFieldForBanner("imagePath",initValue);
	}
	public PlatformForm imagePathFieldForBanner(){
		return imagePathFieldForBanner("imagePath","");
	}


	public PlatformForm lastUpdateFieldForBanner(String parameterName, String initValue){
		FormField field =  lastUpdateFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateFieldForBanner(String initValue){
		return lastUpdateFieldForBanner("lastUpdate",initValue);
	}
	public PlatformForm lastUpdateFieldForBanner(){
		return lastUpdateFieldForBanner("lastUpdate","");
	}


	public PlatformForm platformIdFieldForBanner(String parameterName, String initValue){
		FormField field =  platformIdFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForBanner(String initValue){
		return platformIdFieldForBanner("platformId",initValue);
	}
	public PlatformForm platformIdFieldForBanner(){
		return platformIdFieldForBanner("platformId","");
	}


	public PlatformForm profileIdFieldForProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForProfile(String initValue){
		return profileIdFieldForProfile("profileId",initValue);
	}
	public PlatformForm profileIdFieldForProfile(){
		return profileIdFieldForProfile("profileId","");
	}


	public PlatformForm nameFieldForProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProfile(String initValue){
		return nameFieldForProfile("name",initValue);
	}
	public PlatformForm nameFieldForProfile(){
		return nameFieldForProfile("name","");
	}


	public PlatformForm platformIdFieldForProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProfile(String initValue){
		return platformIdFieldForProfile("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProfile(){
		return platformIdFieldForProfile("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


