package com.doublechaintech.uxs.review;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class ReviewForm extends BaseForm {
	
	
	public ReviewForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ReviewForm reviewIdField(String parameterName, String initValue){
		FormField field = idFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReviewForm reviewIdField(String initValue){
		return reviewIdField("reviewId",initValue);
	}
	public ReviewForm reviewIdField(){
		return reviewIdField("reviewId","");
	}


	public ReviewForm titleField(String parameterName, String initValue){
		FormField field = titleFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReviewForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public ReviewForm titleField(){
		return titleField("title","");
	}


	public ReviewForm contentField(String parameterName, String initValue){
		FormField field = contentFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReviewForm contentField(String initValue){
		return contentField("content",initValue);
	}
	public ReviewForm contentField(){
		return contentField("content","");
	}


	public ReviewForm userIdField(String parameterName, String initValue){
		FormField field = userIdFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReviewForm userIdField(String initValue){
		return userIdField("userId",initValue);
	}
	public ReviewForm userIdField(){
		return userIdField("userId","");
	}


	public ReviewForm productIdField(String parameterName, String initValue){
		FormField field = productIdFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReviewForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public ReviewForm productIdField(){
		return productIdField("productId","");
	}


	public ReviewForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReviewForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public ReviewForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public ReviewForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public ReviewForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public ReviewForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public ReviewForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public ReviewForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public ReviewForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public ReviewForm productIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm productIdFieldOfProduct(String initValue){
		return productIdFieldOfProduct("productId",initValue);
	}
	public ReviewForm productIdFieldOfProduct(){
		return productIdFieldOfProduct("productId","");
	}


	public ReviewForm nameFieldOfProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm nameFieldOfProduct(String initValue){
		return nameFieldOfProduct("name",initValue);
	}
	public ReviewForm nameFieldOfProduct(){
		return nameFieldOfProduct("name","");
	}


	public ReviewForm parentCategoryIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm parentCategoryIdFieldOfProduct(String initValue){
		return parentCategoryIdFieldOfProduct("parentCategoryId",initValue);
	}
	public ReviewForm parentCategoryIdFieldOfProduct(){
		return parentCategoryIdFieldOfProduct("parentCategoryId","");
	}


	public ReviewForm brandIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm brandIdFieldOfProduct(String initValue){
		return brandIdFieldOfProduct("brandId",initValue);
	}
	public ReviewForm brandIdFieldOfProduct(){
		return brandIdFieldOfProduct("brandId","");
	}


	public ReviewForm productCoverImageFieldOfProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm productCoverImageFieldOfProduct(String initValue){
		return productCoverImageFieldOfProduct("productCoverImage",initValue);
	}
	public ReviewForm productCoverImageFieldOfProduct(){
		return productCoverImageFieldOfProduct("productCoverImage","");
	}


	public ReviewForm originFieldOfProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm originFieldOfProduct(String initValue){
		return originFieldOfProduct("origin",initValue);
	}
	public ReviewForm originFieldOfProduct(){
		return originFieldOfProduct("origin","");
	}


	public ReviewForm catalogIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm catalogIdFieldOfProduct(String initValue){
		return catalogIdFieldOfProduct("catalogId",initValue);
	}
	public ReviewForm catalogIdFieldOfProduct(){
		return catalogIdFieldOfProduct("catalogId","");
	}


	public ReviewForm remarkFieldOfProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm remarkFieldOfProduct(String initValue){
		return remarkFieldOfProduct("remark",initValue);
	}
	public ReviewForm remarkFieldOfProduct(){
		return remarkFieldOfProduct("remark","");
	}


	public ReviewForm lastUpdateTimeFieldOfProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm lastUpdateTimeFieldOfProduct(String initValue){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime",initValue);
	}
	public ReviewForm lastUpdateTimeFieldOfProduct(){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime","");
	}


	public ReviewForm platformIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReviewForm platformIdFieldOfProduct(String initValue){
		return platformIdFieldOfProduct("platformId",initValue);
	}
	public ReviewForm platformIdFieldOfProduct(){
		return platformIdFieldOfProduct("platformId","");
	}

	


	

	
 	public ReviewForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/reviewId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ReviewForm transferToAnotherProductAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProduct/reviewId/");
		this.addFormAction(action);
		return this;
	}

 

	public ReviewForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


