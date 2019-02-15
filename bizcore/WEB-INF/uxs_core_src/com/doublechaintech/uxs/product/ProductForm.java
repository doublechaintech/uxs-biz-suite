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


	public ProductForm avarageScoreField(String parameterName, String initValue){
		FormField field = avarageScoreFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm avarageScoreField(String initValue){
		return avarageScoreField("avarageScore",initValue);
	}
	public ProductForm avarageScoreField(){
		return avarageScoreField("avarageScore","");
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


