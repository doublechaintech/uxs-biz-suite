package com.doublechaintech.uxs.editorpickproduct;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class EditorPickProductForm extends BaseForm {
	
	
	public EditorPickProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EditorPickProductForm editorPickProductIdField(String parameterName, String initValue){
		FormField field = idFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm editorPickProductIdField(String initValue){
		return editorPickProductIdField("editorPickProductId",initValue);
	}
	public EditorPickProductForm editorPickProductIdField(){
		return editorPickProductIdField("editorPickProductId","");
	}


	public EditorPickProductForm nameField(String parameterName, String initValue){
		FormField field = nameFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public EditorPickProductForm nameField(){
		return nameField("name","");
	}


	public EditorPickProductForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public EditorPickProductForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public EditorPickProductForm brandIdField(String parameterName, String initValue){
		FormField field = brandIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public EditorPickProductForm brandIdField(){
		return brandIdField("brandId","");
	}


	public EditorPickProductForm productCoverImageField(String parameterName, String initValue){
		FormField field = productCoverImageFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm productCoverImageField(String initValue){
		return productCoverImageField("productCoverImage",initValue);
	}
	public EditorPickProductForm productCoverImageField(){
		return productCoverImageField("productCoverImage","");
	}


	public EditorPickProductForm originField(String parameterName, String initValue){
		FormField field = originFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm originField(String initValue){
		return originField("origin",initValue);
	}
	public EditorPickProductForm originField(){
		return originField("origin","");
	}


	public EditorPickProductForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public EditorPickProductForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public EditorPickProductForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public EditorPickProductForm profileIdField(){
		return profileIdField("profileId","");
	}


	public EditorPickProductForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public EditorPickProductForm remarkField(){
		return remarkField("remark","");
	}


	public EditorPickProductForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public EditorPickProductForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public EditorPickProductForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EditorPickProductForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public EditorPickProductForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public EditorPickProductForm levelNCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  idFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm levelNCategoryIdFieldOfLevelNCategory(String initValue){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId",initValue);
	}
	public EditorPickProductForm levelNCategoryIdFieldOfLevelNCategory(){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId","");
	}


	public EditorPickProductForm parentCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm parentCategoryIdFieldOfLevelNCategory(String initValue){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId",initValue);
	}
	public EditorPickProductForm parentCategoryIdFieldOfLevelNCategory(){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId","");
	}


	public EditorPickProductForm nameFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm nameFieldOfLevelNCategory(String initValue){
		return nameFieldOfLevelNCategory("name",initValue);
	}
	public EditorPickProductForm nameFieldOfLevelNCategory(){
		return nameFieldOfLevelNCategory("name","");
	}


	public EditorPickProductForm brandIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm brandIdFieldOfBrand(String initValue){
		return brandIdFieldOfBrand("brandId",initValue);
	}
	public EditorPickProductForm brandIdFieldOfBrand(){
		return brandIdFieldOfBrand("brandId","");
	}


	public EditorPickProductForm brandNameFieldOfBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm brandNameFieldOfBrand(String initValue){
		return brandNameFieldOfBrand("brandName",initValue);
	}
	public EditorPickProductForm brandNameFieldOfBrand(){
		return brandNameFieldOfBrand("brandName","");
	}


	public EditorPickProductForm logoFieldOfBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm logoFieldOfBrand(String initValue){
		return logoFieldOfBrand("logo",initValue);
	}
	public EditorPickProductForm logoFieldOfBrand(){
		return logoFieldOfBrand("logo","");
	}


	public EditorPickProductForm remarkFieldOfBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm remarkFieldOfBrand(String initValue){
		return remarkFieldOfBrand("remark",initValue);
	}
	public EditorPickProductForm remarkFieldOfBrand(){
		return remarkFieldOfBrand("remark","");
	}


	public EditorPickProductForm platformIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  platformIdFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm platformIdFieldOfBrand(String initValue){
		return platformIdFieldOfBrand("platformId",initValue);
	}
	public EditorPickProductForm platformIdFieldOfBrand(){
		return platformIdFieldOfBrand("platformId","");
	}


	public EditorPickProductForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public EditorPickProductForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public EditorPickProductForm nameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm nameFieldOfCatalog(String initValue){
		return nameFieldOfCatalog("name",initValue);
	}
	public EditorPickProductForm nameFieldOfCatalog(){
		return nameFieldOfCatalog("name","");
	}


	public EditorPickProductForm sellerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm sellerIdFieldOfCatalog(String initValue){
		return sellerIdFieldOfCatalog("sellerId",initValue);
	}
	public EditorPickProductForm sellerIdFieldOfCatalog(){
		return sellerIdFieldOfCatalog("sellerId","");
	}


	public EditorPickProductForm siteIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm siteIdFieldOfCatalog(String initValue){
		return siteIdFieldOfCatalog("siteId",initValue);
	}
	public EditorPickProductForm siteIdFieldOfCatalog(){
		return siteIdFieldOfCatalog("siteId","");
	}


	public EditorPickProductForm platformIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm platformIdFieldOfCatalog(String initValue){
		return platformIdFieldOfCatalog("platformId",initValue);
	}
	public EditorPickProductForm platformIdFieldOfCatalog(){
		return platformIdFieldOfCatalog("platformId","");
	}


	public EditorPickProductForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public EditorPickProductForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public EditorPickProductForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public EditorPickProductForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public EditorPickProductForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public EditorPickProductForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public EditorPickProductForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public EditorPickProductForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public EditorPickProductForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EditorPickProductForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public EditorPickProductForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	


	

	
 	public EditorPickProductForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/editorPickProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EditorPickProductForm transferToAnotherBrandAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBrand/editorPickProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EditorPickProductForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/editorPickProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EditorPickProductForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/editorPickProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EditorPickProductForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/editorPickProductId/");
		this.addFormAction(action);
		return this;
	}

 

	public EditorPickProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


