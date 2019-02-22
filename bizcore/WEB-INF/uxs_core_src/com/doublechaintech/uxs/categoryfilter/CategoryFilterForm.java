package com.doublechaintech.uxs.categoryfilter;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class CategoryFilterForm extends BaseForm {
	
	
	public CategoryFilterForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CategoryFilterForm categoryFilterIdField(String parameterName, String initValue){
		FormField field = idFromCategoryFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CategoryFilterForm categoryFilterIdField(String initValue){
		return categoryFilterIdField("categoryFilterId",initValue);
	}
	public CategoryFilterForm categoryFilterIdField(){
		return categoryFilterIdField("categoryFilterId","");
	}


	public CategoryFilterForm nameField(String parameterName, String initValue){
		FormField field = nameFromCategoryFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CategoryFilterForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public CategoryFilterForm nameField(){
		return nameField("name","");
	}


	public CategoryFilterForm internalIdField(String parameterName, String initValue){
		FormField field = internalIdFromCategoryFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CategoryFilterForm internalIdField(String initValue){
		return internalIdField("internalId",initValue);
	}
	public CategoryFilterForm internalIdField(){
		return internalIdField("internalId","");
	}


	public CategoryFilterForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromCategoryFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CategoryFilterForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public CategoryFilterForm profileIdField(){
		return profileIdField("profileId","");
	}

	
	


	public CategoryFilterForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CategoryFilterForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public CategoryFilterForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public CategoryFilterForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CategoryFilterForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public CategoryFilterForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public CategoryFilterForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CategoryFilterForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public CategoryFilterForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}

	


	

	
 	public CategoryFilterForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/categoryFilterId/");
		this.addFormAction(action);
		return this;
	}

 

	public CategoryFilterForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


