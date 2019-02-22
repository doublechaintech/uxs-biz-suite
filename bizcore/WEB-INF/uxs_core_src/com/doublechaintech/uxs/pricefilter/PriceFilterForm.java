package com.doublechaintech.uxs.pricefilter;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class PriceFilterForm extends BaseForm {
	
	
	public PriceFilterForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PriceFilterForm priceFilterIdField(String parameterName, String initValue){
		FormField field = idFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PriceFilterForm priceFilterIdField(String initValue){
		return priceFilterIdField("priceFilterId",initValue);
	}
	public PriceFilterForm priceFilterIdField(){
		return priceFilterIdField("priceFilterId","");
	}


	public PriceFilterForm nameField(String parameterName, String initValue){
		FormField field = nameFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PriceFilterForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PriceFilterForm nameField(){
		return nameField("name","");
	}


	public PriceFilterForm priceStartField(String parameterName, String initValue){
		FormField field = priceStartFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PriceFilterForm priceStartField(String initValue){
		return priceStartField("priceStart",initValue);
	}
	public PriceFilterForm priceStartField(){
		return priceStartField("priceStart","");
	}


	public PriceFilterForm priceEndField(String parameterName, String initValue){
		FormField field = priceEndFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PriceFilterForm priceEndField(String initValue){
		return priceEndField("priceEnd",initValue);
	}
	public PriceFilterForm priceEndField(){
		return priceEndField("priceEnd","");
	}


	public PriceFilterForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromPriceFilter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PriceFilterForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public PriceFilterForm profileIdField(){
		return profileIdField("profileId","");
	}

	
	


	public PriceFilterForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PriceFilterForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public PriceFilterForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public PriceFilterForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PriceFilterForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public PriceFilterForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public PriceFilterForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PriceFilterForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public PriceFilterForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}

	


	

	
 	public PriceFilterForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/priceFilterId/");
		this.addFormAction(action);
		return this;
	}

 

	public PriceFilterForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


