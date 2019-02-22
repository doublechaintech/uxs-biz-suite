package com.doublechaintech.uxs.product;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class ProductForm extends BaseForm {
	
	
	public ProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProductForm productIdField(String parameterName, String initValue){
		FormField field = idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public ProductForm productIdField(){
		return productIdField("productId","");
	}


	public ProductForm nameField(String parameterName, String initValue){
		FormField field = nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProductForm nameField(){
		return nameField("name","");
	}


	public ProductForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public ProductForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public ProductForm brandIdField(String parameterName, String initValue){
		FormField field = brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public ProductForm brandIdField(){
		return brandIdField("brandId","");
	}


	public ProductForm productCoverImageField(String parameterName, String initValue){
		FormField field = productCoverImageFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productCoverImageField(String initValue){
		return productCoverImageField("productCoverImage",initValue);
	}
	public ProductForm productCoverImageField(){
		return productCoverImageField("productCoverImage","");
	}


	public ProductForm originField(String parameterName, String initValue){
		FormField field = originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm originField(String initValue){
		return originField("origin",initValue);
	}
	public ProductForm originField(){
		return originField("origin","");
	}


	public ProductForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public ProductForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public ProductForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public ProductForm remarkField(){
		return remarkField("remark","");
	}


	public ProductForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public ProductForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public ProductForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ProductForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ProductForm levelNCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  idFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm levelNCategoryIdFieldOfLevelNCategory(String initValue){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId",initValue);
	}
	public ProductForm levelNCategoryIdFieldOfLevelNCategory(){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId","");
	}


	public ProductForm parentCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm parentCategoryIdFieldOfLevelNCategory(String initValue){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId",initValue);
	}
	public ProductForm parentCategoryIdFieldOfLevelNCategory(){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId","");
	}


	public ProductForm nameFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm nameFieldOfLevelNCategory(String initValue){
		return nameFieldOfLevelNCategory("name",initValue);
	}
	public ProductForm nameFieldOfLevelNCategory(){
		return nameFieldOfLevelNCategory("name","");
	}


	public ProductForm brandIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm brandIdFieldOfBrand(String initValue){
		return brandIdFieldOfBrand("brandId",initValue);
	}
	public ProductForm brandIdFieldOfBrand(){
		return brandIdFieldOfBrand("brandId","");
	}


	public ProductForm brandNameFieldOfBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm brandNameFieldOfBrand(String initValue){
		return brandNameFieldOfBrand("brandName",initValue);
	}
	public ProductForm brandNameFieldOfBrand(){
		return brandNameFieldOfBrand("brandName","");
	}


	public ProductForm logoFieldOfBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm logoFieldOfBrand(String initValue){
		return logoFieldOfBrand("logo",initValue);
	}
	public ProductForm logoFieldOfBrand(){
		return logoFieldOfBrand("logo","");
	}


	public ProductForm remarkFieldOfBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm remarkFieldOfBrand(String initValue){
		return remarkFieldOfBrand("remark",initValue);
	}
	public ProductForm remarkFieldOfBrand(){
		return remarkFieldOfBrand("remark","");
	}


	public ProductForm platformIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  platformIdFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm platformIdFieldOfBrand(String initValue){
		return platformIdFieldOfBrand("platformId",initValue);
	}
	public ProductForm platformIdFieldOfBrand(){
		return platformIdFieldOfBrand("platformId","");
	}


	public ProductForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public ProductForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public ProductForm nameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm nameFieldOfCatalog(String initValue){
		return nameFieldOfCatalog("name",initValue);
	}
	public ProductForm nameFieldOfCatalog(){
		return nameFieldOfCatalog("name","");
	}


	public ProductForm sellerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm sellerIdFieldOfCatalog(String initValue){
		return sellerIdFieldOfCatalog("sellerId",initValue);
	}
	public ProductForm sellerIdFieldOfCatalog(){
		return sellerIdFieldOfCatalog("sellerId","");
	}


	public ProductForm siteIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm siteIdFieldOfCatalog(String initValue){
		return siteIdFieldOfCatalog("siteId",initValue);
	}
	public ProductForm siteIdFieldOfCatalog(){
		return siteIdFieldOfCatalog("siteId","");
	}


	public ProductForm platformIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm platformIdFieldOfCatalog(String initValue){
		return platformIdFieldOfCatalog("platformId",initValue);
	}
	public ProductForm platformIdFieldOfCatalog(){
		return platformIdFieldOfCatalog("platformId","");
	}


	public ProductForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ProductForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ProductForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ProductForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	



	public ProductForm ratingIdFieldForRating(String parameterName, String initValue){
		FormField field =  idFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm ratingIdFieldForRating(String initValue){
		return ratingIdFieldForRating("ratingId",initValue);
	}
	public ProductForm ratingIdFieldForRating(){
		return ratingIdFieldForRating("ratingId","");
	}


	public ProductForm userIdFieldForRating(String parameterName, String initValue){
		FormField field =  userIdFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm userIdFieldForRating(String initValue){
		return userIdFieldForRating("userId",initValue);
	}
	public ProductForm userIdFieldForRating(){
		return userIdFieldForRating("userId","");
	}


	public ProductForm productIdFieldForRating(String parameterName, String initValue){
		FormField field =  productIdFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdFieldForRating(String initValue){
		return productIdFieldForRating("productId",initValue);
	}
	public ProductForm productIdFieldForRating(){
		return productIdFieldForRating("productId","");
	}


	public ProductForm scoreFieldForRating(String parameterName, String initValue){
		FormField field =  scoreFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm scoreFieldForRating(String initValue){
		return scoreFieldForRating("score",initValue);
	}
	public ProductForm scoreFieldForRating(){
		return scoreFieldForRating("score","");
	}


	public ProductForm updateTimeFieldForRating(String parameterName, String initValue){
		FormField field =  updateTimeFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm updateTimeFieldForRating(String initValue){
		return updateTimeFieldForRating("updateTime",initValue);
	}
	public ProductForm updateTimeFieldForRating(){
		return updateTimeFieldForRating("updateTime","");
	}


	public ProductForm reviewIdFieldForReview(String parameterName, String initValue){
		FormField field =  idFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm reviewIdFieldForReview(String initValue){
		return reviewIdFieldForReview("reviewId",initValue);
	}
	public ProductForm reviewIdFieldForReview(){
		return reviewIdFieldForReview("reviewId","");
	}


	public ProductForm titleFieldForReview(String parameterName, String initValue){
		FormField field =  titleFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm titleFieldForReview(String initValue){
		return titleFieldForReview("title",initValue);
	}
	public ProductForm titleFieldForReview(){
		return titleFieldForReview("title","");
	}


	public ProductForm contentFieldForReview(String parameterName, String initValue){
		FormField field =  contentFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm contentFieldForReview(String initValue){
		return contentFieldForReview("content",initValue);
	}
	public ProductForm contentFieldForReview(){
		return contentFieldForReview("content","");
	}


	public ProductForm userIdFieldForReview(String parameterName, String initValue){
		FormField field =  userIdFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm userIdFieldForReview(String initValue){
		return userIdFieldForReview("userId",initValue);
	}
	public ProductForm userIdFieldForReview(){
		return userIdFieldForReview("userId","");
	}


	public ProductForm productIdFieldForReview(String parameterName, String initValue){
		FormField field =  productIdFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdFieldForReview(String initValue){
		return productIdFieldForReview("productId",initValue);
	}
	public ProductForm productIdFieldForReview(){
		return productIdFieldForReview("productId","");
	}


	public ProductForm updateTimeFieldForReview(String parameterName, String initValue){
		FormField field =  updateTimeFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm updateTimeFieldForReview(String initValue){
		return updateTimeFieldForReview("updateTime",initValue);
	}
	public ProductForm updateTimeFieldForReview(){
		return updateTimeFieldForReview("updateTime","");
	}


	public ProductForm blogIdFieldForBlog(String parameterName, String initValue){
		FormField field =  idFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm blogIdFieldForBlog(String initValue){
		return blogIdFieldForBlog("blogId",initValue);
	}
	public ProductForm blogIdFieldForBlog(){
		return blogIdFieldForBlog("blogId","");
	}


	public ProductForm titleFieldForBlog(String parameterName, String initValue){
		FormField field =  titleFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm titleFieldForBlog(String initValue){
		return titleFieldForBlog("title",initValue);
	}
	public ProductForm titleFieldForBlog(){
		return titleFieldForBlog("title","");
	}


	public ProductForm contentFieldForBlog(String parameterName, String initValue){
		FormField field =  contentFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm contentFieldForBlog(String initValue){
		return contentFieldForBlog("content",initValue);
	}
	public ProductForm contentFieldForBlog(){
		return contentFieldForBlog("content","");
	}


	public ProductForm userIdFieldForBlog(String parameterName, String initValue){
		FormField field =  userIdFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm userIdFieldForBlog(String initValue){
		return userIdFieldForBlog("userId",initValue);
	}
	public ProductForm userIdFieldForBlog(){
		return userIdFieldForBlog("userId","");
	}


	public ProductForm productIdFieldForBlog(String parameterName, String initValue){
		FormField field =  productIdFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdFieldForBlog(String initValue){
		return productIdFieldForBlog("productId",initValue);
	}
	public ProductForm productIdFieldForBlog(){
		return productIdFieldForBlog("productId","");
	}


	public ProductForm updateTimeFieldForBlog(String parameterName, String initValue){
		FormField field =  updateTimeFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm updateTimeFieldForBlog(String initValue){
		return updateTimeFieldForBlog("updateTime",initValue);
	}
	public ProductForm updateTimeFieldForBlog(){
		return updateTimeFieldForBlog("updateTime","");
	}

	

	
 	public ProductForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/productId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ProductForm transferToAnotherBrandAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBrand/productId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ProductForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/productId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ProductForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/productId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


