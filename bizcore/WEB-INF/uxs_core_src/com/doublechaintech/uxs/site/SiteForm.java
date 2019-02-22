package com.doublechaintech.uxs.site;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class SiteForm extends BaseForm {
	
	
	public SiteForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SiteForm siteIdField(String parameterName, String initValue){
		FormField field = idFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm siteIdField(String initValue){
		return siteIdField("siteId",initValue);
	}
	public SiteForm siteIdField(){
		return siteIdField("siteId","");
	}


	public SiteForm nameField(String parameterName, String initValue){
		FormField field = nameFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public SiteForm nameField(){
		return nameField("name","");
	}


	public SiteForm introductionField(String parameterName, String initValue){
		FormField field = introductionFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm introductionField(String initValue){
		return introductionField("introduction",initValue);
	}
	public SiteForm introductionField(){
		return introductionField("introduction","");
	}


	public SiteForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public SiteForm platformIdField(){
		return platformIdField("platformId","");
	}


	public SiteForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public SiteForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public SiteForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SiteForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public SiteForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public SiteForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SiteForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public SiteForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	



	public SiteForm catalogIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm catalogIdFieldForCatalog(String initValue){
		return catalogIdFieldForCatalog("catalogId",initValue);
	}
	public SiteForm catalogIdFieldForCatalog(){
		return catalogIdFieldForCatalog("catalogId","");
	}


	public SiteForm nameFieldForCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm nameFieldForCatalog(String initValue){
		return nameFieldForCatalog("name",initValue);
	}
	public SiteForm nameFieldForCatalog(){
		return nameFieldForCatalog("name","");
	}


	public SiteForm sellerIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm sellerIdFieldForCatalog(String initValue){
		return sellerIdFieldForCatalog("sellerId",initValue);
	}
	public SiteForm sellerIdFieldForCatalog(){
		return sellerIdFieldForCatalog("sellerId","");
	}


	public SiteForm siteIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm siteIdFieldForCatalog(String initValue){
		return siteIdFieldForCatalog("siteId",initValue);
	}
	public SiteForm siteIdFieldForCatalog(){
		return siteIdFieldForCatalog("siteId","");
	}


	public SiteForm platformIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SiteForm platformIdFieldForCatalog(String initValue){
		return platformIdFieldForCatalog("platformId",initValue);
	}
	public SiteForm platformIdFieldForCatalog(){
		return platformIdFieldForCatalog("platformId","");
	}

	

	
 	public SiteForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/siteId/");
		this.addFormAction(action);
		return this;
	}

 

	public SiteForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


