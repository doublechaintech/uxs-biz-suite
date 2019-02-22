package com.doublechaintech.uxs.brandfilter;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class BrandFilterForm extends BaseForm {
	
	
	public BrandFilterForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public BrandFilterForm brandFilterIdField(String parameterName, String initValue){
		FormField field = idFromBrandFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandFilterForm brandFilterIdField(String initValue){
		return brandFilterIdField("brandFilterId",initValue);
	}
	public BrandFilterForm brandFilterIdField(){
		return brandFilterIdField("brandFilterId","");
	}


	public BrandFilterForm nameField(String parameterName, String initValue){
		FormField field = nameFromBrandFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandFilterForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public BrandFilterForm nameField(){
		return nameField("name","");
	}


	public BrandFilterForm internalIdField(String parameterName, String initValue){
		FormField field = internalIdFromBrandFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandFilterForm internalIdField(String initValue){
		return internalIdField("internalId",initValue);
	}
	public BrandFilterForm internalIdField(){
		return internalIdField("internalId","");
	}


	public BrandFilterForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromBrandFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandFilterForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public BrandFilterForm profileIdField(){
		return profileIdField("profileId","");
	}

	
	


	public BrandFilterForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandFilterForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public BrandFilterForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public BrandFilterForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandFilterForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public BrandFilterForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public BrandFilterForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandFilterForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public BrandFilterForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}

	


	

	
 	public BrandFilterForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/brandFilterId/");
		this.addFormAction(action);
		return this;
	}

 

	public BrandFilterForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


