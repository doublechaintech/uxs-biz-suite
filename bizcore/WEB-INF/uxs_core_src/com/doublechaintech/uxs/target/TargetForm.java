package com.doublechaintech.uxs.target;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class TargetForm extends BaseForm {
	
	
	public TargetForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TargetForm targetIdField(String parameterName, String initValue){
		FormField field = idFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetForm targetIdField(String initValue){
		return targetIdField("targetId",initValue);
	}
	public TargetForm targetIdField(){
		return targetIdField("targetId","");
	}


	public TargetForm nameField(String parameterName, String initValue){
		FormField field = nameFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TargetForm nameField(){
		return nameField("name","");
	}


	public TargetForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public TargetForm profileIdField(){
		return profileIdField("profileId","");
	}


	public TargetForm bannerIdField(String parameterName, String initValue){
		FormField field = bannerIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetForm bannerIdField(String initValue){
		return bannerIdField("bannerId",initValue);
	}
	public TargetForm bannerIdField(){
		return bannerIdField("bannerId","");
	}


	public TargetForm locationField(String parameterName, String initValue){
		FormField field = locationFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public TargetForm locationField(){
		return locationField("location","");
	}


	public TargetForm lastUpdateField(String parameterName, String initValue){
		FormField field = lastUpdateFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetForm lastUpdateField(String initValue){
		return lastUpdateField("lastUpdate",initValue);
	}
	public TargetForm lastUpdateField(){
		return lastUpdateField("lastUpdate","");
	}

	
	


	public TargetForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public TargetForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public TargetForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public TargetForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public TargetForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public TargetForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public TargetForm bannerIdFieldOfBanner(String parameterName, String initValue){
		FormField field =  idFromBanner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetForm bannerIdFieldOfBanner(String initValue){
		return bannerIdFieldOfBanner("bannerId",initValue);
	}
	public TargetForm bannerIdFieldOfBanner(){
		return bannerIdFieldOfBanner("bannerId","");
	}


	public TargetForm nameFieldOfBanner(String parameterName, String initValue){
		FormField field =  nameFromBanner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetForm nameFieldOfBanner(String initValue){
		return nameFieldOfBanner("name",initValue);
	}
	public TargetForm nameFieldOfBanner(){
		return nameFieldOfBanner("name","");
	}


	public TargetForm imagePathFieldOfBanner(String parameterName, String initValue){
		FormField field =  imagePathFromBanner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetForm imagePathFieldOfBanner(String initValue){
		return imagePathFieldOfBanner("imagePath",initValue);
	}
	public TargetForm imagePathFieldOfBanner(){
		return imagePathFieldOfBanner("imagePath","");
	}


	public TargetForm lastUpdateFieldOfBanner(String parameterName, String initValue){
		FormField field =  lastUpdateFromBanner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetForm lastUpdateFieldOfBanner(String initValue){
		return lastUpdateFieldOfBanner("lastUpdate",initValue);
	}
	public TargetForm lastUpdateFieldOfBanner(){
		return lastUpdateFieldOfBanner("lastUpdate","");
	}


	public TargetForm platformIdFieldOfBanner(String parameterName, String initValue){
		FormField field =  platformIdFromBanner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetForm platformIdFieldOfBanner(String initValue){
		return platformIdFieldOfBanner("platformId",initValue);
	}
	public TargetForm platformIdFieldOfBanner(){
		return platformIdFieldOfBanner("platformId","");
	}

	


	

	
 	public TargetForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/targetId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TargetForm transferToAnotherBannerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBanner/targetId/");
		this.addFormAction(action);
		return this;
	}

 

	public TargetForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


