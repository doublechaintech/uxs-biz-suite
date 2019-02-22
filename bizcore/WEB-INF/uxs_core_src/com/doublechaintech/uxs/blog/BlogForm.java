package com.doublechaintech.uxs.blog;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class BlogForm extends BaseForm {
	
	
	public BlogForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public BlogForm blogIdField(String parameterName, String initValue){
		FormField field = idFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BlogForm blogIdField(String initValue){
		return blogIdField("blogId",initValue);
	}
	public BlogForm blogIdField(){
		return blogIdField("blogId","");
	}


	public BlogForm titleField(String parameterName, String initValue){
		FormField field = titleFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BlogForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public BlogForm titleField(){
		return titleField("title","");
	}


	public BlogForm contentField(String parameterName, String initValue){
		FormField field = contentFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BlogForm contentField(String initValue){
		return contentField("content",initValue);
	}
	public BlogForm contentField(){
		return contentField("content","");
	}


	public BlogForm userIdField(String parameterName, String initValue){
		FormField field = userIdFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BlogForm userIdField(String initValue){
		return userIdField("userId",initValue);
	}
	public BlogForm userIdField(){
		return userIdField("userId","");
	}


	public BlogForm productIdField(String parameterName, String initValue){
		FormField field = productIdFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BlogForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public BlogForm productIdField(){
		return productIdField("productId","");
	}


	public BlogForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromBlog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BlogForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public BlogForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public BlogForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public BlogForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public BlogForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public BlogForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public BlogForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public BlogForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public BlogForm productIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm productIdFieldOfProduct(String initValue){
		return productIdFieldOfProduct("productId",initValue);
	}
	public BlogForm productIdFieldOfProduct(){
		return productIdFieldOfProduct("productId","");
	}


	public BlogForm nameFieldOfProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm nameFieldOfProduct(String initValue){
		return nameFieldOfProduct("name",initValue);
	}
	public BlogForm nameFieldOfProduct(){
		return nameFieldOfProduct("name","");
	}


	public BlogForm parentCategoryIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm parentCategoryIdFieldOfProduct(String initValue){
		return parentCategoryIdFieldOfProduct("parentCategoryId",initValue);
	}
	public BlogForm parentCategoryIdFieldOfProduct(){
		return parentCategoryIdFieldOfProduct("parentCategoryId","");
	}


	public BlogForm brandIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm brandIdFieldOfProduct(String initValue){
		return brandIdFieldOfProduct("brandId",initValue);
	}
	public BlogForm brandIdFieldOfProduct(){
		return brandIdFieldOfProduct("brandId","");
	}


	public BlogForm productCoverImageFieldOfProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm productCoverImageFieldOfProduct(String initValue){
		return productCoverImageFieldOfProduct("productCoverImage",initValue);
	}
	public BlogForm productCoverImageFieldOfProduct(){
		return productCoverImageFieldOfProduct("productCoverImage","");
	}


	public BlogForm originFieldOfProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm originFieldOfProduct(String initValue){
		return originFieldOfProduct("origin",initValue);
	}
	public BlogForm originFieldOfProduct(){
		return originFieldOfProduct("origin","");
	}


	public BlogForm catalogIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm catalogIdFieldOfProduct(String initValue){
		return catalogIdFieldOfProduct("catalogId",initValue);
	}
	public BlogForm catalogIdFieldOfProduct(){
		return catalogIdFieldOfProduct("catalogId","");
	}


	public BlogForm remarkFieldOfProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm remarkFieldOfProduct(String initValue){
		return remarkFieldOfProduct("remark",initValue);
	}
	public BlogForm remarkFieldOfProduct(){
		return remarkFieldOfProduct("remark","");
	}


	public BlogForm lastUpdateTimeFieldOfProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm lastUpdateTimeFieldOfProduct(String initValue){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime",initValue);
	}
	public BlogForm lastUpdateTimeFieldOfProduct(){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime","");
	}


	public BlogForm platformIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BlogForm platformIdFieldOfProduct(String initValue){
		return platformIdFieldOfProduct("platformId",initValue);
	}
	public BlogForm platformIdFieldOfProduct(){
		return platformIdFieldOfProduct("platformId","");
	}

	


	

	
 	public BlogForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/blogId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public BlogForm transferToAnotherProductAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProduct/blogId/");
		this.addFormAction(action);
		return this;
	}

 

	public BlogForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


