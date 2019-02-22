package com.doublechaintech.uxs.catalog;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class CatalogForm extends BaseForm {
	
	
	public CatalogForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CatalogForm catalogIdField(String parameterName, String initValue){
		FormField field = idFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public CatalogForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public CatalogForm nameField(String parameterName, String initValue){
		FormField field = nameFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public CatalogForm nameField(){
		return nameField("name","");
	}


	public CatalogForm sellerIdField(String parameterName, String initValue){
		FormField field = sellerIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm sellerIdField(String initValue){
		return sellerIdField("sellerId",initValue);
	}
	public CatalogForm sellerIdField(){
		return sellerIdField("sellerId","");
	}


	public CatalogForm siteIdField(String parameterName, String initValue){
		FormField field = siteIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm siteIdField(String initValue){
		return siteIdField("siteId",initValue);
	}
	public CatalogForm siteIdField(){
		return siteIdField("siteId","");
	}


	public CatalogForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public CatalogForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public CatalogForm siteIdFieldOfSite(String parameterName, String initValue){
		FormField field =  idFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm siteIdFieldOfSite(String initValue){
		return siteIdFieldOfSite("siteId",initValue);
	}
	public CatalogForm siteIdFieldOfSite(){
		return siteIdFieldOfSite("siteId","");
	}


	public CatalogForm nameFieldOfSite(String parameterName, String initValue){
		FormField field =  nameFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm nameFieldOfSite(String initValue){
		return nameFieldOfSite("name",initValue);
	}
	public CatalogForm nameFieldOfSite(){
		return nameFieldOfSite("name","");
	}


	public CatalogForm introductionFieldOfSite(String parameterName, String initValue){
		FormField field =  introductionFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm introductionFieldOfSite(String initValue){
		return introductionFieldOfSite("introduction",initValue);
	}
	public CatalogForm introductionFieldOfSite(){
		return introductionFieldOfSite("introduction","");
	}


	public CatalogForm platformIdFieldOfSite(String parameterName, String initValue){
		FormField field =  platformIdFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm platformIdFieldOfSite(String initValue){
		return platformIdFieldOfSite("platformId",initValue);
	}
	public CatalogForm platformIdFieldOfSite(){
		return platformIdFieldOfSite("platformId","");
	}


	public CatalogForm lastUpdateTimeFieldOfSite(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSite(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm lastUpdateTimeFieldOfSite(String initValue){
		return lastUpdateTimeFieldOfSite("lastUpdateTime",initValue);
	}
	public CatalogForm lastUpdateTimeFieldOfSite(){
		return lastUpdateTimeFieldOfSite("lastUpdateTime","");
	}


	public CatalogForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public CatalogForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public CatalogForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public CatalogForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	



	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  idFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(String initValue){
		return levelOneCategoryIdFieldForLevelOneCategory("levelOneCategoryId",initValue);
	}
	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(){
		return levelOneCategoryIdFieldForLevelOneCategory("levelOneCategoryId","");
	}


	public CatalogForm catalogIdFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  catalogIdFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForLevelOneCategory(String initValue){
		return catalogIdFieldForLevelOneCategory("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForLevelOneCategory(){
		return catalogIdFieldForLevelOneCategory("catalogId","");
	}


	public CatalogForm nameFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForLevelOneCategory(String initValue){
		return nameFieldForLevelOneCategory("name",initValue);
	}
	public CatalogForm nameFieldForLevelOneCategory(){
		return nameFieldForLevelOneCategory("name","");
	}


	public CatalogForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public CatalogForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public CatalogForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public CatalogForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public CatalogForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public CatalogForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public CatalogForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public CatalogForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public CatalogForm productCoverImageFieldForProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm productCoverImageFieldForProduct(String initValue){
		return productCoverImageFieldForProduct("productCoverImage",initValue);
	}
	public CatalogForm productCoverImageFieldForProduct(){
		return productCoverImageFieldForProduct("productCoverImage","");
	}


	public CatalogForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public CatalogForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public CatalogForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public CatalogForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public CatalogForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public CatalogForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public CatalogForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}


	public CatalogForm platformIdFieldForProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm platformIdFieldForProduct(String initValue){
		return platformIdFieldForProduct("platformId",initValue);
	}
	public CatalogForm platformIdFieldForProduct(){
		return platformIdFieldForProduct("platformId","");
	}


	public CatalogForm newProductIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  idFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm newProductIdFieldForNewProduct(String initValue){
		return newProductIdFieldForNewProduct("newProductId",initValue);
	}
	public CatalogForm newProductIdFieldForNewProduct(){
		return newProductIdFieldForNewProduct("newProductId","");
	}


	public CatalogForm nameFieldForNewProduct(String parameterName, String initValue){
		FormField field =  nameFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForNewProduct(String initValue){
		return nameFieldForNewProduct("name",initValue);
	}
	public CatalogForm nameFieldForNewProduct(){
		return nameFieldForNewProduct("name","");
	}


	public CatalogForm parentCategoryIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm parentCategoryIdFieldForNewProduct(String initValue){
		return parentCategoryIdFieldForNewProduct("parentCategoryId",initValue);
	}
	public CatalogForm parentCategoryIdFieldForNewProduct(){
		return parentCategoryIdFieldForNewProduct("parentCategoryId","");
	}


	public CatalogForm brandIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  brandIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm brandIdFieldForNewProduct(String initValue){
		return brandIdFieldForNewProduct("brandId",initValue);
	}
	public CatalogForm brandIdFieldForNewProduct(){
		return brandIdFieldForNewProduct("brandId","");
	}


	public CatalogForm productCoverImageFieldForNewProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm productCoverImageFieldForNewProduct(String initValue){
		return productCoverImageFieldForNewProduct("productCoverImage",initValue);
	}
	public CatalogForm productCoverImageFieldForNewProduct(){
		return productCoverImageFieldForNewProduct("productCoverImage","");
	}


	public CatalogForm originFieldForNewProduct(String parameterName, String initValue){
		FormField field =  originFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm originFieldForNewProduct(String initValue){
		return originFieldForNewProduct("origin",initValue);
	}
	public CatalogForm originFieldForNewProduct(){
		return originFieldForNewProduct("origin","");
	}


	public CatalogForm catalogIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForNewProduct(String initValue){
		return catalogIdFieldForNewProduct("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForNewProduct(){
		return catalogIdFieldForNewProduct("catalogId","");
	}


	public CatalogForm profileIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  profileIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm profileIdFieldForNewProduct(String initValue){
		return profileIdFieldForNewProduct("profileId",initValue);
	}
	public CatalogForm profileIdFieldForNewProduct(){
		return profileIdFieldForNewProduct("profileId","");
	}


	public CatalogForm remarkFieldForNewProduct(String parameterName, String initValue){
		FormField field =  remarkFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm remarkFieldForNewProduct(String initValue){
		return remarkFieldForNewProduct("remark",initValue);
	}
	public CatalogForm remarkFieldForNewProduct(){
		return remarkFieldForNewProduct("remark","");
	}


	public CatalogForm lastUpdateTimeFieldForNewProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm lastUpdateTimeFieldForNewProduct(String initValue){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime",initValue);
	}
	public CatalogForm lastUpdateTimeFieldForNewProduct(){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime","");
	}


	public CatalogForm platformIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  platformIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm platformIdFieldForNewProduct(String initValue){
		return platformIdFieldForNewProduct("platformId",initValue);
	}
	public CatalogForm platformIdFieldForNewProduct(){
		return platformIdFieldForNewProduct("platformId","");
	}


	public CatalogForm editorPickProductIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  idFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm editorPickProductIdFieldForEditorPickProduct(String initValue){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId",initValue);
	}
	public CatalogForm editorPickProductIdFieldForEditorPickProduct(){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId","");
	}


	public CatalogForm nameFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  nameFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForEditorPickProduct(String initValue){
		return nameFieldForEditorPickProduct("name",initValue);
	}
	public CatalogForm nameFieldForEditorPickProduct(){
		return nameFieldForEditorPickProduct("name","");
	}


	public CatalogForm parentCategoryIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm parentCategoryIdFieldForEditorPickProduct(String initValue){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId",initValue);
	}
	public CatalogForm parentCategoryIdFieldForEditorPickProduct(){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId","");
	}


	public CatalogForm brandIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  brandIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm brandIdFieldForEditorPickProduct(String initValue){
		return brandIdFieldForEditorPickProduct("brandId",initValue);
	}
	public CatalogForm brandIdFieldForEditorPickProduct(){
		return brandIdFieldForEditorPickProduct("brandId","");
	}


	public CatalogForm productCoverImageFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm productCoverImageFieldForEditorPickProduct(String initValue){
		return productCoverImageFieldForEditorPickProduct("productCoverImage",initValue);
	}
	public CatalogForm productCoverImageFieldForEditorPickProduct(){
		return productCoverImageFieldForEditorPickProduct("productCoverImage","");
	}


	public CatalogForm originFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  originFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm originFieldForEditorPickProduct(String initValue){
		return originFieldForEditorPickProduct("origin",initValue);
	}
	public CatalogForm originFieldForEditorPickProduct(){
		return originFieldForEditorPickProduct("origin","");
	}


	public CatalogForm catalogIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForEditorPickProduct(String initValue){
		return catalogIdFieldForEditorPickProduct("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForEditorPickProduct(){
		return catalogIdFieldForEditorPickProduct("catalogId","");
	}


	public CatalogForm profileIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  profileIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm profileIdFieldForEditorPickProduct(String initValue){
		return profileIdFieldForEditorPickProduct("profileId",initValue);
	}
	public CatalogForm profileIdFieldForEditorPickProduct(){
		return profileIdFieldForEditorPickProduct("profileId","");
	}


	public CatalogForm remarkFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  remarkFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm remarkFieldForEditorPickProduct(String initValue){
		return remarkFieldForEditorPickProduct("remark",initValue);
	}
	public CatalogForm remarkFieldForEditorPickProduct(){
		return remarkFieldForEditorPickProduct("remark","");
	}


	public CatalogForm lastUpdateTimeFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm lastUpdateTimeFieldForEditorPickProduct(String initValue){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime",initValue);
	}
	public CatalogForm lastUpdateTimeFieldForEditorPickProduct(){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime","");
	}


	public CatalogForm platformIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  platformIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm platformIdFieldForEditorPickProduct(String initValue){
		return platformIdFieldForEditorPickProduct("platformId",initValue);
	}
	public CatalogForm platformIdFieldForEditorPickProduct(){
		return platformIdFieldForEditorPickProduct("platformId","");
	}


	public CatalogForm topRatedProductIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  idFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm topRatedProductIdFieldForTopRatedProduct(String initValue){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId",initValue);
	}
	public CatalogForm topRatedProductIdFieldForTopRatedProduct(){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId","");
	}


	public CatalogForm nameFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  nameFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForTopRatedProduct(String initValue){
		return nameFieldForTopRatedProduct("name",initValue);
	}
	public CatalogForm nameFieldForTopRatedProduct(){
		return nameFieldForTopRatedProduct("name","");
	}


	public CatalogForm parentCategoryIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm parentCategoryIdFieldForTopRatedProduct(String initValue){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId",initValue);
	}
	public CatalogForm parentCategoryIdFieldForTopRatedProduct(){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId","");
	}


	public CatalogForm brandIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  brandIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm brandIdFieldForTopRatedProduct(String initValue){
		return brandIdFieldForTopRatedProduct("brandId",initValue);
	}
	public CatalogForm brandIdFieldForTopRatedProduct(){
		return brandIdFieldForTopRatedProduct("brandId","");
	}


	public CatalogForm productCoverImageFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm productCoverImageFieldForTopRatedProduct(String initValue){
		return productCoverImageFieldForTopRatedProduct("productCoverImage",initValue);
	}
	public CatalogForm productCoverImageFieldForTopRatedProduct(){
		return productCoverImageFieldForTopRatedProduct("productCoverImage","");
	}


	public CatalogForm originFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  originFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm originFieldForTopRatedProduct(String initValue){
		return originFieldForTopRatedProduct("origin",initValue);
	}
	public CatalogForm originFieldForTopRatedProduct(){
		return originFieldForTopRatedProduct("origin","");
	}


	public CatalogForm catalogIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForTopRatedProduct(String initValue){
		return catalogIdFieldForTopRatedProduct("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForTopRatedProduct(){
		return catalogIdFieldForTopRatedProduct("catalogId","");
	}


	public CatalogForm remarkFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  remarkFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm remarkFieldForTopRatedProduct(String initValue){
		return remarkFieldForTopRatedProduct("remark",initValue);
	}
	public CatalogForm remarkFieldForTopRatedProduct(){
		return remarkFieldForTopRatedProduct("remark","");
	}


	public CatalogForm lastUpdateTimeFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm lastUpdateTimeFieldForTopRatedProduct(String initValue){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime",initValue);
	}
	public CatalogForm lastUpdateTimeFieldForTopRatedProduct(){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime","");
	}


	public CatalogForm profileIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  profileIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm profileIdFieldForTopRatedProduct(String initValue){
		return profileIdFieldForTopRatedProduct("profileId",initValue);
	}
	public CatalogForm profileIdFieldForTopRatedProduct(){
		return profileIdFieldForTopRatedProduct("profileId","");
	}


	public CatalogForm platformIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  platformIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm platformIdFieldForTopRatedProduct(String initValue){
		return platformIdFieldForTopRatedProduct("platformId",initValue);
	}
	public CatalogForm platformIdFieldForTopRatedProduct(){
		return platformIdFieldForTopRatedProduct("platformId","");
	}


	public CatalogForm recommandProductIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  idFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm recommandProductIdFieldForRecommandProduct(String initValue){
		return recommandProductIdFieldForRecommandProduct("recommandProductId",initValue);
	}
	public CatalogForm recommandProductIdFieldForRecommandProduct(){
		return recommandProductIdFieldForRecommandProduct("recommandProductId","");
	}


	public CatalogForm nameFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  nameFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForRecommandProduct(String initValue){
		return nameFieldForRecommandProduct("name",initValue);
	}
	public CatalogForm nameFieldForRecommandProduct(){
		return nameFieldForRecommandProduct("name","");
	}


	public CatalogForm parentCategoryIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm parentCategoryIdFieldForRecommandProduct(String initValue){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId",initValue);
	}
	public CatalogForm parentCategoryIdFieldForRecommandProduct(){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId","");
	}


	public CatalogForm brandIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  brandIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm brandIdFieldForRecommandProduct(String initValue){
		return brandIdFieldForRecommandProduct("brandId",initValue);
	}
	public CatalogForm brandIdFieldForRecommandProduct(){
		return brandIdFieldForRecommandProduct("brandId","");
	}


	public CatalogForm productCoverImageFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm productCoverImageFieldForRecommandProduct(String initValue){
		return productCoverImageFieldForRecommandProduct("productCoverImage",initValue);
	}
	public CatalogForm productCoverImageFieldForRecommandProduct(){
		return productCoverImageFieldForRecommandProduct("productCoverImage","");
	}


	public CatalogForm originFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  originFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm originFieldForRecommandProduct(String initValue){
		return originFieldForRecommandProduct("origin",initValue);
	}
	public CatalogForm originFieldForRecommandProduct(){
		return originFieldForRecommandProduct("origin","");
	}


	public CatalogForm catalogIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForRecommandProduct(String initValue){
		return catalogIdFieldForRecommandProduct("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForRecommandProduct(){
		return catalogIdFieldForRecommandProduct("catalogId","");
	}


	public CatalogForm remarkFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  remarkFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm remarkFieldForRecommandProduct(String initValue){
		return remarkFieldForRecommandProduct("remark",initValue);
	}
	public CatalogForm remarkFieldForRecommandProduct(){
		return remarkFieldForRecommandProduct("remark","");
	}


	public CatalogForm lastUpdateTimeFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm lastUpdateTimeFieldForRecommandProduct(String initValue){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime",initValue);
	}
	public CatalogForm lastUpdateTimeFieldForRecommandProduct(){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime","");
	}


	public CatalogForm profileIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  profileIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm profileIdFieldForRecommandProduct(String initValue){
		return profileIdFieldForRecommandProduct("profileId",initValue);
	}
	public CatalogForm profileIdFieldForRecommandProduct(){
		return profileIdFieldForRecommandProduct("profileId","");
	}


	public CatalogForm platformIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  platformIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm platformIdFieldForRecommandProduct(String initValue){
		return platformIdFieldForRecommandProduct("platformId",initValue);
	}
	public CatalogForm platformIdFieldForRecommandProduct(){
		return platformIdFieldForRecommandProduct("platformId","");
	}

	

	
 	public CatalogForm transferToAnotherSiteAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSite/catalogId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public CatalogForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/catalogId/");
		this.addFormAction(action);
		return this;
	}

 

	public CatalogForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


