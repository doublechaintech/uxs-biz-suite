package com.doublechaintech.uxs.leveltwocategory;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class LevelTwoCategoryForm extends BaseForm {
	
	
	public LevelTwoCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelTwoCategoryForm levelTwoCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm levelTwoCategoryIdField(String initValue){
		return levelTwoCategoryIdField("levelTwoCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelTwoCategoryIdField(){
		return levelTwoCategoryIdField("levelTwoCategoryId","");
	}


	public LevelTwoCategoryForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public LevelTwoCategoryForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public LevelTwoCategoryForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelTwoCategoryForm nameField(){
		return nameField("name","");
	}

	
	


	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  idFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(String initValue){
		return levelOneCategoryIdFieldOfLevelOneCategory("levelOneCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(){
		return levelOneCategoryIdFieldOfLevelOneCategory("levelOneCategoryId","");
	}


	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  catalogIdFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(String initValue){
		return catalogIdFieldOfLevelOneCategory("catalogId",initValue);
	}
	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(){
		return catalogIdFieldOfLevelOneCategory("catalogId","");
	}


	public LevelTwoCategoryForm nameFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm nameFieldOfLevelOneCategory(String initValue){
		return nameFieldOfLevelOneCategory("name",initValue);
	}
	public LevelTwoCategoryForm nameFieldOfLevelOneCategory(){
		return nameFieldOfLevelOneCategory("name","");
	}

	



	public LevelTwoCategoryForm levelNCategoryIdFieldForLevelNCategory(String parameterName, String initValue){
		FormField field =  idFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm levelNCategoryIdFieldForLevelNCategory(String initValue){
		return levelNCategoryIdFieldForLevelNCategory("levelNCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelNCategoryIdFieldForLevelNCategory(){
		return levelNCategoryIdFieldForLevelNCategory("levelNCategoryId","");
	}


	public LevelTwoCategoryForm parentCategoryIdFieldForLevelNCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm parentCategoryIdFieldForLevelNCategory(String initValue){
		return parentCategoryIdFieldForLevelNCategory("parentCategoryId",initValue);
	}
	public LevelTwoCategoryForm parentCategoryIdFieldForLevelNCategory(){
		return parentCategoryIdFieldForLevelNCategory("parentCategoryId","");
	}


	public LevelTwoCategoryForm nameFieldForLevelNCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm nameFieldForLevelNCategory(String initValue){
		return nameFieldForLevelNCategory("name",initValue);
	}
	public LevelTwoCategoryForm nameFieldForLevelNCategory(){
		return nameFieldForLevelNCategory("name","");
	}

	

	
 	public LevelTwoCategoryForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/levelTwoCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelTwoCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


