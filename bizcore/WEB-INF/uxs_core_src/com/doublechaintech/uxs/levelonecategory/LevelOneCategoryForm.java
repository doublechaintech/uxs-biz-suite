package com.doublechaintech.uxs.levelonecategory;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class LevelOneCategoryForm extends BaseForm {
	
	
	public LevelOneCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelOneCategoryForm levelOneCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm levelOneCategoryIdField(String initValue){
		return levelOneCategoryIdField("levelOneCategoryId",initValue);
	}
	public LevelOneCategoryForm levelOneCategoryIdField(){
		return levelOneCategoryIdField("levelOneCategoryId","");
	}


	public LevelOneCategoryForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public LevelOneCategoryForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public LevelOneCategoryForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelOneCategoryForm nameField(){
		return nameField("name","");
	}

	
	


	public LevelOneCategoryForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public LevelOneCategoryForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public LevelOneCategoryForm nameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm nameFieldOfCatalog(String initValue){
		return nameFieldOfCatalog("name",initValue);
	}
	public LevelOneCategoryForm nameFieldOfCatalog(){
		return nameFieldOfCatalog("name","");
	}


	public LevelOneCategoryForm sellerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm sellerIdFieldOfCatalog(String initValue){
		return sellerIdFieldOfCatalog("sellerId",initValue);
	}
	public LevelOneCategoryForm sellerIdFieldOfCatalog(){
		return sellerIdFieldOfCatalog("sellerId","");
	}


	public LevelOneCategoryForm siteIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm siteIdFieldOfCatalog(String initValue){
		return siteIdFieldOfCatalog("siteId",initValue);
	}
	public LevelOneCategoryForm siteIdFieldOfCatalog(){
		return siteIdFieldOfCatalog("siteId","");
	}


	public LevelOneCategoryForm platformIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm platformIdFieldOfCatalog(String initValue){
		return platformIdFieldOfCatalog("platformId",initValue);
	}
	public LevelOneCategoryForm platformIdFieldOfCatalog(){
		return platformIdFieldOfCatalog("platformId","");
	}

	



	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  idFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(String initValue){
		return levelTwoCategoryIdFieldForLevelTwoCategory("levelTwoCategoryId",initValue);
	}
	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(){
		return levelTwoCategoryIdFieldForLevelTwoCategory("levelTwoCategoryId","");
	}


	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(String initValue){
		return parentCategoryIdFieldForLevelTwoCategory("parentCategoryId",initValue);
	}
	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(){
		return parentCategoryIdFieldForLevelTwoCategory("parentCategoryId","");
	}


	public LevelOneCategoryForm nameFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm nameFieldForLevelTwoCategory(String initValue){
		return nameFieldForLevelTwoCategory("name",initValue);
	}
	public LevelOneCategoryForm nameFieldForLevelTwoCategory(){
		return nameFieldForLevelTwoCategory("name","");
	}

	

	
 	public LevelOneCategoryForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/levelOneCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelOneCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


