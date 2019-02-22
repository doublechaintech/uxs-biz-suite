package com.doublechaintech.uxs.newproduct;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class NewProductForm extends BaseForm {
	
	
	public NewProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public NewProductForm newProductIdField(String parameterName, String initValue){
		FormField field = idFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm newProductIdField(String initValue){
		return newProductIdField("newProductId",initValue);
	}
	public NewProductForm newProductIdField(){
		return newProductIdField("newProductId","");
	}


	public NewProductForm nameField(String parameterName, String initValue){
		FormField field = nameFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public NewProductForm nameField(){
		return nameField("name","");
	}


	public NewProductForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public NewProductForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public NewProductForm brandIdField(String parameterName, String initValue){
		FormField field = brandIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public NewProductForm brandIdField(){
		return brandIdField("brandId","");
	}


	public NewProductForm productCoverImageField(String parameterName, String initValue){
		FormField field = productCoverImageFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm productCoverImageField(String initValue){
		return productCoverImageField("productCoverImage",initValue);
	}
	public NewProductForm productCoverImageField(){
		return productCoverImageField("productCoverImage","");
	}


	public NewProductForm originField(String parameterName, String initValue){
		FormField field = originFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm originField(String initValue){
		return originField("origin",initValue);
	}
	public NewProductForm originField(){
		return originField("origin","");
	}


	public NewProductForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public NewProductForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public NewProductForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public NewProductForm profileIdField(){
		return profileIdField("profileId","");
	}


	public NewProductForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public NewProductForm remarkField(){
		return remarkField("remark","");
	}


	public NewProductForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public NewProductForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public NewProductForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NewProductForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public NewProductForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public NewProductForm levelNCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  idFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm levelNCategoryIdFieldOfLevelNCategory(String initValue){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId",initValue);
	}
	public NewProductForm levelNCategoryIdFieldOfLevelNCategory(){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId","");
	}


	public NewProductForm parentCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm parentCategoryIdFieldOfLevelNCategory(String initValue){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId",initValue);
	}
	public NewProductForm parentCategoryIdFieldOfLevelNCategory(){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId","");
	}


	public NewProductForm nameFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm nameFieldOfLevelNCategory(String initValue){
		return nameFieldOfLevelNCategory("name",initValue);
	}
	public NewProductForm nameFieldOfLevelNCategory(){
		return nameFieldOfLevelNCategory("name","");
	}


	public NewProductForm brandIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm brandIdFieldOfBrand(String initValue){
		return brandIdFieldOfBrand("brandId",initValue);
	}
	public NewProductForm brandIdFieldOfBrand(){
		return brandIdFieldOfBrand("brandId","");
	}


	public NewProductForm brandNameFieldOfBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm brandNameFieldOfBrand(String initValue){
		return brandNameFieldOfBrand("brandName",initValue);
	}
	public NewProductForm brandNameFieldOfBrand(){
		return brandNameFieldOfBrand("brandName","");
	}


	public NewProductForm logoFieldOfBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm logoFieldOfBrand(String initValue){
		return logoFieldOfBrand("logo",initValue);
	}
	public NewProductForm logoFieldOfBrand(){
		return logoFieldOfBrand("logo","");
	}


	public NewProductForm remarkFieldOfBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm remarkFieldOfBrand(String initValue){
		return remarkFieldOfBrand("remark",initValue);
	}
	public NewProductForm remarkFieldOfBrand(){
		return remarkFieldOfBrand("remark","");
	}


	public NewProductForm platformIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  platformIdFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm platformIdFieldOfBrand(String initValue){
		return platformIdFieldOfBrand("platformId",initValue);
	}
	public NewProductForm platformIdFieldOfBrand(){
		return platformIdFieldOfBrand("platformId","");
	}


	public NewProductForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public NewProductForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public NewProductForm nameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm nameFieldOfCatalog(String initValue){
		return nameFieldOfCatalog("name",initValue);
	}
	public NewProductForm nameFieldOfCatalog(){
		return nameFieldOfCatalog("name","");
	}


	public NewProductForm sellerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm sellerIdFieldOfCatalog(String initValue){
		return sellerIdFieldOfCatalog("sellerId",initValue);
	}
	public NewProductForm sellerIdFieldOfCatalog(){
		return sellerIdFieldOfCatalog("sellerId","");
	}


	public NewProductForm siteIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm siteIdFieldOfCatalog(String initValue){
		return siteIdFieldOfCatalog("siteId",initValue);
	}
	public NewProductForm siteIdFieldOfCatalog(){
		return siteIdFieldOfCatalog("siteId","");
	}


	public NewProductForm platformIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm platformIdFieldOfCatalog(String initValue){
		return platformIdFieldOfCatalog("platformId",initValue);
	}
	public NewProductForm platformIdFieldOfCatalog(){
		return platformIdFieldOfCatalog("platformId","");
	}


	public NewProductForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public NewProductForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public NewProductForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public NewProductForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public NewProductForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public NewProductForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public NewProductForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public NewProductForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public NewProductForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NewProductForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public NewProductForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	


	

	
 	public NewProductForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/newProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public NewProductForm transferToAnotherBrandAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBrand/newProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public NewProductForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/newProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public NewProductForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/newProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public NewProductForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/newProductId/");
		this.addFormAction(action);
		return this;
	}

 

	public NewProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


