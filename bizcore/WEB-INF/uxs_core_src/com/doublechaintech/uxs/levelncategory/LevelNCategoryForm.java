package com.doublechaintech.uxs.levelncategory;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class LevelNCategoryForm extends BaseForm {
	
	
	public LevelNCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelNCategoryForm levelNCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm levelNCategoryIdField(String initValue){
		return levelNCategoryIdField("levelNCategoryId",initValue);
	}
	public LevelNCategoryForm levelNCategoryIdField(){
		return levelNCategoryIdField("levelNCategoryId","");
	}


	public LevelNCategoryForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public LevelNCategoryForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelNCategoryForm nameField(){
		return nameField("name","");
	}

	
	


	public LevelNCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  idFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelNCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(String initValue){
		return levelTwoCategoryIdFieldOfLevelTwoCategory("levelTwoCategoryId",initValue);
	}
	public LevelNCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(){
		return levelTwoCategoryIdFieldOfLevelTwoCategory("levelTwoCategoryId","");
	}


	public LevelNCategoryForm parentCategoryIdFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdFieldOfLevelTwoCategory(String initValue){
		return parentCategoryIdFieldOfLevelTwoCategory("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdFieldOfLevelTwoCategory(){
		return parentCategoryIdFieldOfLevelTwoCategory("parentCategoryId","");
	}


	public LevelNCategoryForm nameFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelNCategoryForm nameFieldOfLevelTwoCategory(String initValue){
		return nameFieldOfLevelTwoCategory("name",initValue);
	}
	public LevelNCategoryForm nameFieldOfLevelTwoCategory(){
		return nameFieldOfLevelTwoCategory("name","");
	}

	



	public LevelNCategoryForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public LevelNCategoryForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public LevelNCategoryForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public LevelNCategoryForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public LevelNCategoryForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public LevelNCategoryForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public LevelNCategoryForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public LevelNCategoryForm productCoverImageFieldForProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm productCoverImageFieldForProduct(String initValue){
		return productCoverImageFieldForProduct("productCoverImage",initValue);
	}
	public LevelNCategoryForm productCoverImageFieldForProduct(){
		return productCoverImageFieldForProduct("productCoverImage","");
	}


	public LevelNCategoryForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public LevelNCategoryForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public LevelNCategoryForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public LevelNCategoryForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public LevelNCategoryForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public LevelNCategoryForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public LevelNCategoryForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public LevelNCategoryForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}


	public LevelNCategoryForm platformIdFieldForProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm platformIdFieldForProduct(String initValue){
		return platformIdFieldForProduct("platformId",initValue);
	}
	public LevelNCategoryForm platformIdFieldForProduct(){
		return platformIdFieldForProduct("platformId","");
	}


	public LevelNCategoryForm newProductIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  idFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm newProductIdFieldForNewProduct(String initValue){
		return newProductIdFieldForNewProduct("newProductId",initValue);
	}
	public LevelNCategoryForm newProductIdFieldForNewProduct(){
		return newProductIdFieldForNewProduct("newProductId","");
	}


	public LevelNCategoryForm nameFieldForNewProduct(String parameterName, String initValue){
		FormField field =  nameFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm nameFieldForNewProduct(String initValue){
		return nameFieldForNewProduct("name",initValue);
	}
	public LevelNCategoryForm nameFieldForNewProduct(){
		return nameFieldForNewProduct("name","");
	}


	public LevelNCategoryForm parentCategoryIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdFieldForNewProduct(String initValue){
		return parentCategoryIdFieldForNewProduct("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdFieldForNewProduct(){
		return parentCategoryIdFieldForNewProduct("parentCategoryId","");
	}


	public LevelNCategoryForm brandIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  brandIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm brandIdFieldForNewProduct(String initValue){
		return brandIdFieldForNewProduct("brandId",initValue);
	}
	public LevelNCategoryForm brandIdFieldForNewProduct(){
		return brandIdFieldForNewProduct("brandId","");
	}


	public LevelNCategoryForm productCoverImageFieldForNewProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm productCoverImageFieldForNewProduct(String initValue){
		return productCoverImageFieldForNewProduct("productCoverImage",initValue);
	}
	public LevelNCategoryForm productCoverImageFieldForNewProduct(){
		return productCoverImageFieldForNewProduct("productCoverImage","");
	}


	public LevelNCategoryForm originFieldForNewProduct(String parameterName, String initValue){
		FormField field =  originFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm originFieldForNewProduct(String initValue){
		return originFieldForNewProduct("origin",initValue);
	}
	public LevelNCategoryForm originFieldForNewProduct(){
		return originFieldForNewProduct("origin","");
	}


	public LevelNCategoryForm catalogIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm catalogIdFieldForNewProduct(String initValue){
		return catalogIdFieldForNewProduct("catalogId",initValue);
	}
	public LevelNCategoryForm catalogIdFieldForNewProduct(){
		return catalogIdFieldForNewProduct("catalogId","");
	}


	public LevelNCategoryForm profileIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  profileIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm profileIdFieldForNewProduct(String initValue){
		return profileIdFieldForNewProduct("profileId",initValue);
	}
	public LevelNCategoryForm profileIdFieldForNewProduct(){
		return profileIdFieldForNewProduct("profileId","");
	}


	public LevelNCategoryForm remarkFieldForNewProduct(String parameterName, String initValue){
		FormField field =  remarkFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm remarkFieldForNewProduct(String initValue){
		return remarkFieldForNewProduct("remark",initValue);
	}
	public LevelNCategoryForm remarkFieldForNewProduct(){
		return remarkFieldForNewProduct("remark","");
	}


	public LevelNCategoryForm lastUpdateTimeFieldForNewProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm lastUpdateTimeFieldForNewProduct(String initValue){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime",initValue);
	}
	public LevelNCategoryForm lastUpdateTimeFieldForNewProduct(){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime","");
	}


	public LevelNCategoryForm platformIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  platformIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm platformIdFieldForNewProduct(String initValue){
		return platformIdFieldForNewProduct("platformId",initValue);
	}
	public LevelNCategoryForm platformIdFieldForNewProduct(){
		return platformIdFieldForNewProduct("platformId","");
	}


	public LevelNCategoryForm editorPickProductIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  idFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm editorPickProductIdFieldForEditorPickProduct(String initValue){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId",initValue);
	}
	public LevelNCategoryForm editorPickProductIdFieldForEditorPickProduct(){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId","");
	}


	public LevelNCategoryForm nameFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  nameFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm nameFieldForEditorPickProduct(String initValue){
		return nameFieldForEditorPickProduct("name",initValue);
	}
	public LevelNCategoryForm nameFieldForEditorPickProduct(){
		return nameFieldForEditorPickProduct("name","");
	}


	public LevelNCategoryForm parentCategoryIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdFieldForEditorPickProduct(String initValue){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdFieldForEditorPickProduct(){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId","");
	}


	public LevelNCategoryForm brandIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  brandIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm brandIdFieldForEditorPickProduct(String initValue){
		return brandIdFieldForEditorPickProduct("brandId",initValue);
	}
	public LevelNCategoryForm brandIdFieldForEditorPickProduct(){
		return brandIdFieldForEditorPickProduct("brandId","");
	}


	public LevelNCategoryForm productCoverImageFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm productCoverImageFieldForEditorPickProduct(String initValue){
		return productCoverImageFieldForEditorPickProduct("productCoverImage",initValue);
	}
	public LevelNCategoryForm productCoverImageFieldForEditorPickProduct(){
		return productCoverImageFieldForEditorPickProduct("productCoverImage","");
	}


	public LevelNCategoryForm originFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  originFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm originFieldForEditorPickProduct(String initValue){
		return originFieldForEditorPickProduct("origin",initValue);
	}
	public LevelNCategoryForm originFieldForEditorPickProduct(){
		return originFieldForEditorPickProduct("origin","");
	}


	public LevelNCategoryForm catalogIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm catalogIdFieldForEditorPickProduct(String initValue){
		return catalogIdFieldForEditorPickProduct("catalogId",initValue);
	}
	public LevelNCategoryForm catalogIdFieldForEditorPickProduct(){
		return catalogIdFieldForEditorPickProduct("catalogId","");
	}


	public LevelNCategoryForm profileIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  profileIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm profileIdFieldForEditorPickProduct(String initValue){
		return profileIdFieldForEditorPickProduct("profileId",initValue);
	}
	public LevelNCategoryForm profileIdFieldForEditorPickProduct(){
		return profileIdFieldForEditorPickProduct("profileId","");
	}


	public LevelNCategoryForm remarkFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  remarkFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm remarkFieldForEditorPickProduct(String initValue){
		return remarkFieldForEditorPickProduct("remark",initValue);
	}
	public LevelNCategoryForm remarkFieldForEditorPickProduct(){
		return remarkFieldForEditorPickProduct("remark","");
	}


	public LevelNCategoryForm lastUpdateTimeFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm lastUpdateTimeFieldForEditorPickProduct(String initValue){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime",initValue);
	}
	public LevelNCategoryForm lastUpdateTimeFieldForEditorPickProduct(){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime","");
	}


	public LevelNCategoryForm platformIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  platformIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm platformIdFieldForEditorPickProduct(String initValue){
		return platformIdFieldForEditorPickProduct("platformId",initValue);
	}
	public LevelNCategoryForm platformIdFieldForEditorPickProduct(){
		return platformIdFieldForEditorPickProduct("platformId","");
	}


	public LevelNCategoryForm topRatedProductIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  idFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm topRatedProductIdFieldForTopRatedProduct(String initValue){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId",initValue);
	}
	public LevelNCategoryForm topRatedProductIdFieldForTopRatedProduct(){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId","");
	}


	public LevelNCategoryForm nameFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  nameFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm nameFieldForTopRatedProduct(String initValue){
		return nameFieldForTopRatedProduct("name",initValue);
	}
	public LevelNCategoryForm nameFieldForTopRatedProduct(){
		return nameFieldForTopRatedProduct("name","");
	}


	public LevelNCategoryForm parentCategoryIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdFieldForTopRatedProduct(String initValue){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdFieldForTopRatedProduct(){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId","");
	}


	public LevelNCategoryForm brandIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  brandIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm brandIdFieldForTopRatedProduct(String initValue){
		return brandIdFieldForTopRatedProduct("brandId",initValue);
	}
	public LevelNCategoryForm brandIdFieldForTopRatedProduct(){
		return brandIdFieldForTopRatedProduct("brandId","");
	}


	public LevelNCategoryForm productCoverImageFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm productCoverImageFieldForTopRatedProduct(String initValue){
		return productCoverImageFieldForTopRatedProduct("productCoverImage",initValue);
	}
	public LevelNCategoryForm productCoverImageFieldForTopRatedProduct(){
		return productCoverImageFieldForTopRatedProduct("productCoverImage","");
	}


	public LevelNCategoryForm originFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  originFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm originFieldForTopRatedProduct(String initValue){
		return originFieldForTopRatedProduct("origin",initValue);
	}
	public LevelNCategoryForm originFieldForTopRatedProduct(){
		return originFieldForTopRatedProduct("origin","");
	}


	public LevelNCategoryForm catalogIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm catalogIdFieldForTopRatedProduct(String initValue){
		return catalogIdFieldForTopRatedProduct("catalogId",initValue);
	}
	public LevelNCategoryForm catalogIdFieldForTopRatedProduct(){
		return catalogIdFieldForTopRatedProduct("catalogId","");
	}


	public LevelNCategoryForm remarkFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  remarkFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm remarkFieldForTopRatedProduct(String initValue){
		return remarkFieldForTopRatedProduct("remark",initValue);
	}
	public LevelNCategoryForm remarkFieldForTopRatedProduct(){
		return remarkFieldForTopRatedProduct("remark","");
	}


	public LevelNCategoryForm lastUpdateTimeFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm lastUpdateTimeFieldForTopRatedProduct(String initValue){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime",initValue);
	}
	public LevelNCategoryForm lastUpdateTimeFieldForTopRatedProduct(){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime","");
	}


	public LevelNCategoryForm profileIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  profileIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm profileIdFieldForTopRatedProduct(String initValue){
		return profileIdFieldForTopRatedProduct("profileId",initValue);
	}
	public LevelNCategoryForm profileIdFieldForTopRatedProduct(){
		return profileIdFieldForTopRatedProduct("profileId","");
	}


	public LevelNCategoryForm platformIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  platformIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm platformIdFieldForTopRatedProduct(String initValue){
		return platformIdFieldForTopRatedProduct("platformId",initValue);
	}
	public LevelNCategoryForm platformIdFieldForTopRatedProduct(){
		return platformIdFieldForTopRatedProduct("platformId","");
	}


	public LevelNCategoryForm recommandProductIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  idFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm recommandProductIdFieldForRecommandProduct(String initValue){
		return recommandProductIdFieldForRecommandProduct("recommandProductId",initValue);
	}
	public LevelNCategoryForm recommandProductIdFieldForRecommandProduct(){
		return recommandProductIdFieldForRecommandProduct("recommandProductId","");
	}


	public LevelNCategoryForm nameFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  nameFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm nameFieldForRecommandProduct(String initValue){
		return nameFieldForRecommandProduct("name",initValue);
	}
	public LevelNCategoryForm nameFieldForRecommandProduct(){
		return nameFieldForRecommandProduct("name","");
	}


	public LevelNCategoryForm parentCategoryIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdFieldForRecommandProduct(String initValue){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdFieldForRecommandProduct(){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId","");
	}


	public LevelNCategoryForm brandIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  brandIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm brandIdFieldForRecommandProduct(String initValue){
		return brandIdFieldForRecommandProduct("brandId",initValue);
	}
	public LevelNCategoryForm brandIdFieldForRecommandProduct(){
		return brandIdFieldForRecommandProduct("brandId","");
	}


	public LevelNCategoryForm productCoverImageFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm productCoverImageFieldForRecommandProduct(String initValue){
		return productCoverImageFieldForRecommandProduct("productCoverImage",initValue);
	}
	public LevelNCategoryForm productCoverImageFieldForRecommandProduct(){
		return productCoverImageFieldForRecommandProduct("productCoverImage","");
	}


	public LevelNCategoryForm originFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  originFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm originFieldForRecommandProduct(String initValue){
		return originFieldForRecommandProduct("origin",initValue);
	}
	public LevelNCategoryForm originFieldForRecommandProduct(){
		return originFieldForRecommandProduct("origin","");
	}


	public LevelNCategoryForm catalogIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm catalogIdFieldForRecommandProduct(String initValue){
		return catalogIdFieldForRecommandProduct("catalogId",initValue);
	}
	public LevelNCategoryForm catalogIdFieldForRecommandProduct(){
		return catalogIdFieldForRecommandProduct("catalogId","");
	}


	public LevelNCategoryForm remarkFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  remarkFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm remarkFieldForRecommandProduct(String initValue){
		return remarkFieldForRecommandProduct("remark",initValue);
	}
	public LevelNCategoryForm remarkFieldForRecommandProduct(){
		return remarkFieldForRecommandProduct("remark","");
	}


	public LevelNCategoryForm lastUpdateTimeFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm lastUpdateTimeFieldForRecommandProduct(String initValue){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime",initValue);
	}
	public LevelNCategoryForm lastUpdateTimeFieldForRecommandProduct(){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime","");
	}


	public LevelNCategoryForm profileIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  profileIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm profileIdFieldForRecommandProduct(String initValue){
		return profileIdFieldForRecommandProduct("profileId",initValue);
	}
	public LevelNCategoryForm profileIdFieldForRecommandProduct(){
		return profileIdFieldForRecommandProduct("profileId","");
	}


	public LevelNCategoryForm platformIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  platformIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm platformIdFieldForRecommandProduct(String initValue){
		return platformIdFieldForRecommandProduct("platformId",initValue);
	}
	public LevelNCategoryForm platformIdFieldForRecommandProduct(){
		return platformIdFieldForRecommandProduct("platformId","");
	}

	

	
 	public LevelNCategoryForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/levelNCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelNCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


