package com.doublechaintech.uxs.recommandproduct;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class RecommandProductForm extends BaseForm {
	
	
	public RecommandProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RecommandProductForm recommandProductIdField(String parameterName, String initValue){
		FormField field = idFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm recommandProductIdField(String initValue){
		return recommandProductIdField("recommandProductId",initValue);
	}
	public RecommandProductForm recommandProductIdField(){
		return recommandProductIdField("recommandProductId","");
	}


	public RecommandProductForm nameField(String parameterName, String initValue){
		FormField field = nameFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RecommandProductForm nameField(){
		return nameField("name","");
	}


	public RecommandProductForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public RecommandProductForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public RecommandProductForm brandIdField(String parameterName, String initValue){
		FormField field = brandIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public RecommandProductForm brandIdField(){
		return brandIdField("brandId","");
	}


	public RecommandProductForm productCoverImageField(String parameterName, String initValue){
		FormField field = productCoverImageFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm productCoverImageField(String initValue){
		return productCoverImageField("productCoverImage",initValue);
	}
	public RecommandProductForm productCoverImageField(){
		return productCoverImageField("productCoverImage","");
	}


	public RecommandProductForm originField(String parameterName, String initValue){
		FormField field = originFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm originField(String initValue){
		return originField("origin",initValue);
	}
	public RecommandProductForm originField(){
		return originField("origin","");
	}


	public RecommandProductForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public RecommandProductForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public RecommandProductForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public RecommandProductForm remarkField(){
		return remarkField("remark","");
	}


	public RecommandProductForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public RecommandProductForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public RecommandProductForm profileIdField(String parameterName, String initValue){
		FormField field = profileIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public RecommandProductForm profileIdField(){
		return profileIdField("profileId","");
	}


	public RecommandProductForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RecommandProductForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public RecommandProductForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public RecommandProductForm levelNCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  idFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm levelNCategoryIdFieldOfLevelNCategory(String initValue){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId",initValue);
	}
	public RecommandProductForm levelNCategoryIdFieldOfLevelNCategory(){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId","");
	}


	public RecommandProductForm parentCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm parentCategoryIdFieldOfLevelNCategory(String initValue){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId",initValue);
	}
	public RecommandProductForm parentCategoryIdFieldOfLevelNCategory(){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId","");
	}


	public RecommandProductForm nameFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm nameFieldOfLevelNCategory(String initValue){
		return nameFieldOfLevelNCategory("name",initValue);
	}
	public RecommandProductForm nameFieldOfLevelNCategory(){
		return nameFieldOfLevelNCategory("name","");
	}


	public RecommandProductForm brandIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm brandIdFieldOfBrand(String initValue){
		return brandIdFieldOfBrand("brandId",initValue);
	}
	public RecommandProductForm brandIdFieldOfBrand(){
		return brandIdFieldOfBrand("brandId","");
	}


	public RecommandProductForm brandNameFieldOfBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm brandNameFieldOfBrand(String initValue){
		return brandNameFieldOfBrand("brandName",initValue);
	}
	public RecommandProductForm brandNameFieldOfBrand(){
		return brandNameFieldOfBrand("brandName","");
	}


	public RecommandProductForm logoFieldOfBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm logoFieldOfBrand(String initValue){
		return logoFieldOfBrand("logo",initValue);
	}
	public RecommandProductForm logoFieldOfBrand(){
		return logoFieldOfBrand("logo","");
	}


	public RecommandProductForm remarkFieldOfBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm remarkFieldOfBrand(String initValue){
		return remarkFieldOfBrand("remark",initValue);
	}
	public RecommandProductForm remarkFieldOfBrand(){
		return remarkFieldOfBrand("remark","");
	}


	public RecommandProductForm platformIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  platformIdFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm platformIdFieldOfBrand(String initValue){
		return platformIdFieldOfBrand("platformId",initValue);
	}
	public RecommandProductForm platformIdFieldOfBrand(){
		return platformIdFieldOfBrand("platformId","");
	}


	public RecommandProductForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public RecommandProductForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public RecommandProductForm nameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm nameFieldOfCatalog(String initValue){
		return nameFieldOfCatalog("name",initValue);
	}
	public RecommandProductForm nameFieldOfCatalog(){
		return nameFieldOfCatalog("name","");
	}


	public RecommandProductForm sellerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm sellerIdFieldOfCatalog(String initValue){
		return sellerIdFieldOfCatalog("sellerId",initValue);
	}
	public RecommandProductForm sellerIdFieldOfCatalog(){
		return sellerIdFieldOfCatalog("sellerId","");
	}


	public RecommandProductForm siteIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm siteIdFieldOfCatalog(String initValue){
		return siteIdFieldOfCatalog("siteId",initValue);
	}
	public RecommandProductForm siteIdFieldOfCatalog(){
		return siteIdFieldOfCatalog("siteId","");
	}


	public RecommandProductForm platformIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm platformIdFieldOfCatalog(String initValue){
		return platformIdFieldOfCatalog("platformId",initValue);
	}
	public RecommandProductForm platformIdFieldOfCatalog(){
		return platformIdFieldOfCatalog("platformId","");
	}


	public RecommandProductForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public RecommandProductForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public RecommandProductForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public RecommandProductForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public RecommandProductForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public RecommandProductForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public RecommandProductForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public RecommandProductForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public RecommandProductForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RecommandProductForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public RecommandProductForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	


	

	
 	public RecommandProductForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/recommandProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RecommandProductForm transferToAnotherBrandAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBrand/recommandProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RecommandProductForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/recommandProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RecommandProductForm transferToAnotherProfileAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProfile/recommandProductId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RecommandProductForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/recommandProductId/");
		this.addFormAction(action);
		return this;
	}

 

	public RecommandProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


