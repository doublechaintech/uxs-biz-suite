package com.doublechaintech.uxs.banner;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class BannerForm extends BaseForm {
	
	
	public BannerForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public BannerForm bannerIdField(String parameterName, String initValue){
		FormField field = idFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm bannerIdField(String initValue){
		return bannerIdField("bannerId",initValue);
	}
	public BannerForm bannerIdField(){
		return bannerIdField("bannerId","");
	}


	public BannerForm nameField(String parameterName, String initValue){
		FormField field = nameFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public BannerForm nameField(){
		return nameField("name","");
	}


	public BannerForm imagePathField(String parameterName, String initValue){
		FormField field = imagePathFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm imagePathField(String initValue){
		return imagePathField("imagePath",initValue);
	}
	public BannerForm imagePathField(){
		return imagePathField("imagePath","");
	}


	public BannerForm lastUpdateField(String parameterName, String initValue){
		FormField field = lastUpdateFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm lastUpdateField(String initValue){
		return lastUpdateField("lastUpdate",initValue);
	}
	public BannerForm lastUpdateField(){
		return lastUpdateField("lastUpdate","");
	}


	public BannerForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public BannerForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public BannerForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BannerForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public BannerForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public BannerForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BannerForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public BannerForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	



	public BannerForm targetIdFieldForTarget(String parameterName, String initValue){
		FormField field =  idFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm targetIdFieldForTarget(String initValue){
		return targetIdFieldForTarget("targetId",initValue);
	}
	public BannerForm targetIdFieldForTarget(){
		return targetIdFieldForTarget("targetId","");
	}


	public BannerForm nameFieldForTarget(String parameterName, String initValue){
		FormField field =  nameFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm nameFieldForTarget(String initValue){
		return nameFieldForTarget("name",initValue);
	}
	public BannerForm nameFieldForTarget(){
		return nameFieldForTarget("name","");
	}


	public BannerForm profileIdFieldForTarget(String parameterName, String initValue){
		FormField field =  profileIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm profileIdFieldForTarget(String initValue){
		return profileIdFieldForTarget("profileId",initValue);
	}
	public BannerForm profileIdFieldForTarget(){
		return profileIdFieldForTarget("profileId","");
	}


	public BannerForm bannerIdFieldForTarget(String parameterName, String initValue){
		FormField field =  bannerIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm bannerIdFieldForTarget(String initValue){
		return bannerIdFieldForTarget("bannerId",initValue);
	}
	public BannerForm bannerIdFieldForTarget(){
		return bannerIdFieldForTarget("bannerId","");
	}


	public BannerForm locationFieldForTarget(String parameterName, String initValue){
		FormField field =  locationFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm locationFieldForTarget(String initValue){
		return locationFieldForTarget("location",initValue);
	}
	public BannerForm locationFieldForTarget(){
		return locationFieldForTarget("location","");
	}


	public BannerForm lastUpdateFieldForTarget(String parameterName, String initValue){
		FormField field =  lastUpdateFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BannerForm lastUpdateFieldForTarget(String initValue){
		return lastUpdateFieldForTarget("lastUpdate",initValue);
	}
	public BannerForm lastUpdateFieldForTarget(){
		return lastUpdateFieldForTarget("lastUpdate","");
	}

	

	
 	public BannerForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/bannerId/");
		this.addFormAction(action);
		return this;
	}

 

	public BannerForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


