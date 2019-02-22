package com.doublechaintech.uxs.useralert;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class UserAlertForm extends BaseForm {
	
	
	public UserAlertForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public UserAlertForm userAlertIdField(String parameterName, String initValue){
		FormField field = idFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAlertForm userAlertIdField(String initValue){
		return userAlertIdField("userAlertId",initValue);
	}
	public UserAlertForm userAlertIdField(){
		return userAlertIdField("userAlertId","");
	}


	public UserAlertForm messageField(String parameterName, String initValue){
		FormField field = messageFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAlertForm messageField(String initValue){
		return messageField("message",initValue);
	}
	public UserAlertForm messageField(){
		return messageField("message","");
	}


	public UserAlertForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAlertForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public UserAlertForm profileIdField(){
		return profileIdField("profileId","");
	}


	public UserAlertForm locationField(String parameterName, String initValue){
		FormField field = locationFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAlertForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public UserAlertForm locationField(){
		return locationField("location","");
	}


	public UserAlertForm lastUpdateField(String parameterName, String initValue){
		FormField field = lastUpdateFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAlertForm lastUpdateField(String initValue){
		return lastUpdateField("lastUpdate",initValue);
	}
	public UserAlertForm lastUpdateField(){
		return lastUpdateField("lastUpdate","");
	}


	public UserAlertForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAlertForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public UserAlertForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public UserAlertForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAlertForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public UserAlertForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public UserAlertForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAlertForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public UserAlertForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public UserAlertForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAlertForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public UserAlertForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public UserAlertForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAlertForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public UserAlertForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public UserAlertForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAlertForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public UserAlertForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	


	

	
 	public UserAlertForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/userAlertId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public UserAlertForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/userAlertId/");
		this.addFormAction(action);
		return this;
	}

 

	public UserAlertForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


