package com.doublechaintech.uxs.profile;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class ProfileForm extends BaseForm {
	
	
	public ProfileForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProfileForm profileIdField(String parameterName, String initValue){
		FormField field = idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public ProfileForm profileIdField(){
		return profileIdField("profileId","");
	}


	public ProfileForm nameField(String parameterName, String initValue){
		FormField field = nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProfileForm nameField(){
		return nameField("name","");
	}


	public ProfileForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ProfileForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ProfileForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ProfileForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ProfileForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ProfileForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	



	public ProfileForm targetIdFieldForTarget(String parameterName, String initValue){
		FormField field =  idFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm targetIdFieldForTarget(String initValue){
		return targetIdFieldForTarget("targetId",initValue);
	}
	public ProfileForm targetIdFieldForTarget(){
		return targetIdFieldForTarget("targetId","");
	}


	public ProfileForm nameFieldForTarget(String parameterName, String initValue){
		FormField field =  nameFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForTarget(String initValue){
		return nameFieldForTarget("name",initValue);
	}
	public ProfileForm nameFieldForTarget(){
		return nameFieldForTarget("name","");
	}


	public ProfileForm profileIdFieldForTarget(String parameterName, String initValue){
		FormField field =  profileIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForTarget(String initValue){
		return profileIdFieldForTarget("profileId",initValue);
	}
	public ProfileForm profileIdFieldForTarget(){
		return profileIdFieldForTarget("profileId","");
	}


	public ProfileForm bannerIdFieldForTarget(String parameterName, String initValue){
		FormField field =  bannerIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm bannerIdFieldForTarget(String initValue){
		return bannerIdFieldForTarget("bannerId",initValue);
	}
	public ProfileForm bannerIdFieldForTarget(){
		return bannerIdFieldForTarget("bannerId","");
	}


	public ProfileForm locationFieldForTarget(String parameterName, String initValue){
		FormField field =  locationFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm locationFieldForTarget(String initValue){
		return locationFieldForTarget("location",initValue);
	}
	public ProfileForm locationFieldForTarget(){
		return locationFieldForTarget("location","");
	}


	public ProfileForm lastUpdateFieldForTarget(String parameterName, String initValue){
		FormField field =  lastUpdateFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateFieldForTarget(String initValue){
		return lastUpdateFieldForTarget("lastUpdate",initValue);
	}
	public ProfileForm lastUpdateFieldForTarget(){
		return lastUpdateFieldForTarget("lastUpdate","");
	}


	public ProfileForm ratingIdFieldForRating(String parameterName, String initValue){
		FormField field =  idFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm ratingIdFieldForRating(String initValue){
		return ratingIdFieldForRating("ratingId",initValue);
	}
	public ProfileForm ratingIdFieldForRating(){
		return ratingIdFieldForRating("ratingId","");
	}


	public ProfileForm userIdFieldForRating(String parameterName, String initValue){
		FormField field =  userIdFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm userIdFieldForRating(String initValue){
		return userIdFieldForRating("userId",initValue);
	}
	public ProfileForm userIdFieldForRating(){
		return userIdFieldForRating("userId","");
	}


	public ProfileForm productIdFieldForRating(String parameterName, String initValue){
		FormField field =  productIdFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm productIdFieldForRating(String initValue){
		return productIdFieldForRating("productId",initValue);
	}
	public ProfileForm productIdFieldForRating(){
		return productIdFieldForRating("productId","");
	}


	public ProfileForm scoreFieldForRating(String parameterName, String initValue){
		FormField field =  scoreFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm scoreFieldForRating(String initValue){
		return scoreFieldForRating("score",initValue);
	}
	public ProfileForm scoreFieldForRating(){
		return scoreFieldForRating("score","");
	}


	public ProfileForm updateTimeFieldForRating(String parameterName, String initValue){
		FormField field =  updateTimeFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm updateTimeFieldForRating(String initValue){
		return updateTimeFieldForRating("updateTime",initValue);
	}
	public ProfileForm updateTimeFieldForRating(){
		return updateTimeFieldForRating("updateTime","");
	}


	public ProfileForm reviewIdFieldForReview(String parameterName, String initValue){
		FormField field =  idFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm reviewIdFieldForReview(String initValue){
		return reviewIdFieldForReview("reviewId",initValue);
	}
	public ProfileForm reviewIdFieldForReview(){
		return reviewIdFieldForReview("reviewId","");
	}


	public ProfileForm titleFieldForReview(String parameterName, String initValue){
		FormField field =  titleFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm titleFieldForReview(String initValue){
		return titleFieldForReview("title",initValue);
	}
	public ProfileForm titleFieldForReview(){
		return titleFieldForReview("title","");
	}


	public ProfileForm contentFieldForReview(String parameterName, String initValue){
		FormField field =  contentFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm contentFieldForReview(String initValue){
		return contentFieldForReview("content",initValue);
	}
	public ProfileForm contentFieldForReview(){
		return contentFieldForReview("content","");
	}


	public ProfileForm userIdFieldForReview(String parameterName, String initValue){
		FormField field =  userIdFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm userIdFieldForReview(String initValue){
		return userIdFieldForReview("userId",initValue);
	}
	public ProfileForm userIdFieldForReview(){
		return userIdFieldForReview("userId","");
	}


	public ProfileForm productIdFieldForReview(String parameterName, String initValue){
		FormField field =  productIdFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm productIdFieldForReview(String initValue){
		return productIdFieldForReview("productId",initValue);
	}
	public ProfileForm productIdFieldForReview(){
		return productIdFieldForReview("productId","");
	}


	public ProfileForm updateTimeFieldForReview(String parameterName, String initValue){
		FormField field =  updateTimeFromReview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm updateTimeFieldForReview(String initValue){
		return updateTimeFieldForReview("updateTime",initValue);
	}
	public ProfileForm updateTimeFieldForReview(){
		return updateTimeFieldForReview("updateTime","");
	}


	public ProfileForm blogIdFieldForBlog(String parameterName, String initValue){
		FormField field =  idFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm blogIdFieldForBlog(String initValue){
		return blogIdFieldForBlog("blogId",initValue);
	}
	public ProfileForm blogIdFieldForBlog(){
		return blogIdFieldForBlog("blogId","");
	}


	public ProfileForm titleFieldForBlog(String parameterName, String initValue){
		FormField field =  titleFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm titleFieldForBlog(String initValue){
		return titleFieldForBlog("title",initValue);
	}
	public ProfileForm titleFieldForBlog(){
		return titleFieldForBlog("title","");
	}


	public ProfileForm contentFieldForBlog(String parameterName, String initValue){
		FormField field =  contentFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm contentFieldForBlog(String initValue){
		return contentFieldForBlog("content",initValue);
	}
	public ProfileForm contentFieldForBlog(){
		return contentFieldForBlog("content","");
	}


	public ProfileForm userIdFieldForBlog(String parameterName, String initValue){
		FormField field =  userIdFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm userIdFieldForBlog(String initValue){
		return userIdFieldForBlog("userId",initValue);
	}
	public ProfileForm userIdFieldForBlog(){
		return userIdFieldForBlog("userId","");
	}


	public ProfileForm productIdFieldForBlog(String parameterName, String initValue){
		FormField field =  productIdFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm productIdFieldForBlog(String initValue){
		return productIdFieldForBlog("productId",initValue);
	}
	public ProfileForm productIdFieldForBlog(){
		return productIdFieldForBlog("productId","");
	}


	public ProfileForm updateTimeFieldForBlog(String parameterName, String initValue){
		FormField field =  updateTimeFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm updateTimeFieldForBlog(String initValue){
		return updateTimeFieldForBlog("updateTime",initValue);
	}
	public ProfileForm updateTimeFieldForBlog(){
		return updateTimeFieldForBlog("updateTime","");
	}

	

	
 	public ProfileForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/profileId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProfileForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


