package com.doublechaintech.uxs.topratedproduct;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class TopRatedProductForm extends BaseForm {
	
	
	public TopRatedProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TopRatedProductForm topRatedProductIdField(String parameterName, String initValue){
		FormField field = idFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm topRatedProductIdField(String initValue){
		return topRatedProductIdField("topRatedProductId",initValue);
	}
	public TopRatedProductForm topRatedProductIdField(){
		return topRatedProductIdField("topRatedProductId","");
	}


	public TopRatedProductForm nameField(String parameterName, String initValue){
		FormField field = nameFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TopRatedProductForm nameField(){
		return nameField("name","");
	}


	public TopRatedProductForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public TopRatedProductForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public TopRatedProductForm brandIdField(String parameterName, String initValue){
		FormField field = brandIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public TopRatedProductForm brandIdField(){
		return brandIdField("brandId","");
	}


	public TopRatedProductForm productCoverImageField(String parameterName, String initValue){
		FormField field = productCoverImageFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm productCoverImageField(String initValue){
		return productCoverImageField("productCoverImage",initValue);
	}
	public TopRatedProductForm productCoverImageField(){
		return productCoverImageField("productCoverImage","");
	}


	public TopRatedProductForm originField(String parameterName, String initValue){
		FormField field = originFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm originField(String initValue){
		return originField("origin",initValue);
	}
	public TopRatedProductForm originField(){
		return originField("origin","");
	}


	public TopRatedProductForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public TopRatedProductForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public TopRatedProductForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public TopRatedProductForm remarkField(){
		return remarkField("remark","");
	}


	public TopRatedProductForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public TopRatedProductForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public TopRatedProductForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public TopRatedProductForm profileIdField(){
		return profileIdField("profileId","");
	}


	public TopRatedProductForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TopRatedProductForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public TopRatedProductForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public TopRatedProductForm levelNCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  idFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm levelNCategoryIdFieldOfLevelNCategory(String initValue){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId",initValue);
	}
	public TopRatedProductForm levelNCategoryIdFieldOfLevelNCategory(){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId","");
	}


	public TopRatedProductForm parentCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm parentCategoryIdFieldOfLevelNCategory(String initValue){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId",initValue);
	}
	public TopRatedProductForm parentCategoryIdFieldOfLevelNCategory(){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId","");
	}


	public TopRatedProductForm nameFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm nameFieldOfLevelNCategory(String initValue){
		return nameFieldOfLevelNCategory("name",initValue);
	}
	public TopRatedProductForm nameFieldOfLevelNCategory(){
		return nameFieldOfLevelNCategory("name","");
	}


	public TopRatedProductForm brandIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm brandIdFieldOfBrand(String initValue){
		return brandIdFieldOfBrand("brandId",initValue);
	}
	public TopRatedProductForm brandIdFieldOfBrand(){
		return brandIdFieldOfBrand("brandId","");
	}


	public TopRatedProductForm brandNameFieldOfBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm brandNameFieldOfBrand(String initValue){
		return brandNameFieldOfBrand("brandName",initValue);
	}
	public TopRatedProductForm brandNameFieldOfBrand(){
		return brandNameFieldOfBrand("brandName","");
	}


	public TopRatedProductForm logoFieldOfBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm logoFieldOfBrand(String initValue){
		return logoFieldOfBrand("logo",initValue);
	}
	public TopRatedProductForm logoFieldOfBrand(){
		return logoFieldOfBrand("logo","");
	}


	public TopRatedProductForm remarkFieldOfBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm remarkFieldOfBrand(String initValue){
		return remarkFieldOfBrand("remark",initValue);
	}
	public TopRatedProductForm remarkFieldOfBrand(){
		return remarkFieldOfBrand("remark","");
	}


	public TopRatedProductForm platformIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  platformIdFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm platformIdFieldOfBrand(String initValue){
		return platformIdFieldOfBrand("platformId",initValue);
	}
	public TopRatedProductForm platformIdFieldOfBrand(){
		return platformIdFieldOfBrand("platformId","");
	}


	public TopRatedProductForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public TopRatedProductForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public TopRatedProductForm nameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm nameFieldOfCatalog(String initValue){
		return nameFieldOfCatalog("name",initValue);
	}
	public TopRatedProductForm nameFieldOfCatalog(){
		return nameFieldOfCatalog("name","");
	}


	public TopRatedProductForm sellerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm sellerIdFieldOfCatalog(String initValue){
		return sellerIdFieldOfCatalog("sellerId",initValue);
	}
	public TopRatedProductForm sellerIdFieldOfCatalog(){
		return sellerIdFieldOfCatalog("sellerId","");
	}


	public TopRatedProductForm siteIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm siteIdFieldOfCatalog(String initValue){
		return siteIdFieldOfCatalog("siteId",initValue);
	}
	public TopRatedProductForm siteIdFieldOfCatalog(){
		return siteIdFieldOfCatalog("siteId","");
	}


	public TopRatedProductForm platformIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm platformIdFieldOfCatalog(String initValue){
		return platformIdFieldOfCatalog("platformId",initValue);
	}
	public TopRatedProductForm platformIdFieldOfCatalog(){
		return platformIdFieldOfCatalog("platformId","");
	}


	public TopRatedProductForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public TopRatedProductForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public TopRatedProductForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public TopRatedProductForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public TopRatedProductForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public TopRatedProductForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public TopRatedProductForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public TopRatedProductForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public TopRatedProductForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TopRatedProductForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public TopRatedProductForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	


	

	
 	public TopRatedProductForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/topRatedProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TopRatedProductForm transferToAnotherBrandAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBrand/topRatedProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TopRatedProductForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/topRatedProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TopRatedProductForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/topRatedProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TopRatedProductForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/topRatedProductId/");
		this.addFormAction(action);
		return this;
	}

 

	public TopRatedProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


