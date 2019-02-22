package com.doublechaintech.uxs.brand;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class BrandForm extends BaseForm {
	
	
	public BrandForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public BrandForm brandIdField(String parameterName, String initValue){
		FormField field = idFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public BrandForm brandIdField(){
		return brandIdField("brandId","");
	}


	public BrandForm brandNameField(String parameterName, String initValue){
		FormField field = brandNameFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandNameField(String initValue){
		return brandNameField("brandName",initValue);
	}
	public BrandForm brandNameField(){
		return brandNameField("brandName","");
	}


	public BrandForm logoField(String parameterName, String initValue){
		FormField field = logoFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm logoField(String initValue){
		return logoField("logo",initValue);
	}
	public BrandForm logoField(){
		return logoField("logo","");
	}


	public BrandForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public BrandForm remarkField(){
		return remarkField("remark","");
	}


	public BrandForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public BrandForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public BrandForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public BrandForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public BrandForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public BrandForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public BrandForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}

	



	public BrandForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public BrandForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public BrandForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public BrandForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public BrandForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public BrandForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public BrandForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public BrandForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public BrandForm productCoverImageFieldForProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productCoverImageFieldForProduct(String initValue){
		return productCoverImageFieldForProduct("productCoverImage",initValue);
	}
	public BrandForm productCoverImageFieldForProduct(){
		return productCoverImageFieldForProduct("productCoverImage","");
	}


	public BrandForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public BrandForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public BrandForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public BrandForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public BrandForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public BrandForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public BrandForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public BrandForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}


	public BrandForm platformIdFieldForProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm platformIdFieldForProduct(String initValue){
		return platformIdFieldForProduct("platformId",initValue);
	}
	public BrandForm platformIdFieldForProduct(){
		return platformIdFieldForProduct("platformId","");
	}


	public BrandForm newProductIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  idFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm newProductIdFieldForNewProduct(String initValue){
		return newProductIdFieldForNewProduct("newProductId",initValue);
	}
	public BrandForm newProductIdFieldForNewProduct(){
		return newProductIdFieldForNewProduct("newProductId","");
	}


	public BrandForm nameFieldForNewProduct(String parameterName, String initValue){
		FormField field =  nameFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm nameFieldForNewProduct(String initValue){
		return nameFieldForNewProduct("name",initValue);
	}
	public BrandForm nameFieldForNewProduct(){
		return nameFieldForNewProduct("name","");
	}


	public BrandForm parentCategoryIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm parentCategoryIdFieldForNewProduct(String initValue){
		return parentCategoryIdFieldForNewProduct("parentCategoryId",initValue);
	}
	public BrandForm parentCategoryIdFieldForNewProduct(){
		return parentCategoryIdFieldForNewProduct("parentCategoryId","");
	}


	public BrandForm brandIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  brandIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdFieldForNewProduct(String initValue){
		return brandIdFieldForNewProduct("brandId",initValue);
	}
	public BrandForm brandIdFieldForNewProduct(){
		return brandIdFieldForNewProduct("brandId","");
	}


	public BrandForm productCoverImageFieldForNewProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productCoverImageFieldForNewProduct(String initValue){
		return productCoverImageFieldForNewProduct("productCoverImage",initValue);
	}
	public BrandForm productCoverImageFieldForNewProduct(){
		return productCoverImageFieldForNewProduct("productCoverImage","");
	}


	public BrandForm originFieldForNewProduct(String parameterName, String initValue){
		FormField field =  originFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm originFieldForNewProduct(String initValue){
		return originFieldForNewProduct("origin",initValue);
	}
	public BrandForm originFieldForNewProduct(){
		return originFieldForNewProduct("origin","");
	}


	public BrandForm catalogIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm catalogIdFieldForNewProduct(String initValue){
		return catalogIdFieldForNewProduct("catalogId",initValue);
	}
	public BrandForm catalogIdFieldForNewProduct(){
		return catalogIdFieldForNewProduct("catalogId","");
	}


	public BrandForm profileIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  profileIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm profileIdFieldForNewProduct(String initValue){
		return profileIdFieldForNewProduct("profileId",initValue);
	}
	public BrandForm profileIdFieldForNewProduct(){
		return profileIdFieldForNewProduct("profileId","");
	}


	public BrandForm remarkFieldForNewProduct(String parameterName, String initValue){
		FormField field =  remarkFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkFieldForNewProduct(String initValue){
		return remarkFieldForNewProduct("remark",initValue);
	}
	public BrandForm remarkFieldForNewProduct(){
		return remarkFieldForNewProduct("remark","");
	}


	public BrandForm lastUpdateTimeFieldForNewProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm lastUpdateTimeFieldForNewProduct(String initValue){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime",initValue);
	}
	public BrandForm lastUpdateTimeFieldForNewProduct(){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime","");
	}


	public BrandForm platformIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  platformIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm platformIdFieldForNewProduct(String initValue){
		return platformIdFieldForNewProduct("platformId",initValue);
	}
	public BrandForm platformIdFieldForNewProduct(){
		return platformIdFieldForNewProduct("platformId","");
	}


	public BrandForm editorPickProductIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  idFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm editorPickProductIdFieldForEditorPickProduct(String initValue){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId",initValue);
	}
	public BrandForm editorPickProductIdFieldForEditorPickProduct(){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId","");
	}


	public BrandForm nameFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  nameFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm nameFieldForEditorPickProduct(String initValue){
		return nameFieldForEditorPickProduct("name",initValue);
	}
	public BrandForm nameFieldForEditorPickProduct(){
		return nameFieldForEditorPickProduct("name","");
	}


	public BrandForm parentCategoryIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm parentCategoryIdFieldForEditorPickProduct(String initValue){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId",initValue);
	}
	public BrandForm parentCategoryIdFieldForEditorPickProduct(){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId","");
	}


	public BrandForm brandIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  brandIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdFieldForEditorPickProduct(String initValue){
		return brandIdFieldForEditorPickProduct("brandId",initValue);
	}
	public BrandForm brandIdFieldForEditorPickProduct(){
		return brandIdFieldForEditorPickProduct("brandId","");
	}


	public BrandForm productCoverImageFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productCoverImageFieldForEditorPickProduct(String initValue){
		return productCoverImageFieldForEditorPickProduct("productCoverImage",initValue);
	}
	public BrandForm productCoverImageFieldForEditorPickProduct(){
		return productCoverImageFieldForEditorPickProduct("productCoverImage","");
	}


	public BrandForm originFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  originFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm originFieldForEditorPickProduct(String initValue){
		return originFieldForEditorPickProduct("origin",initValue);
	}
	public BrandForm originFieldForEditorPickProduct(){
		return originFieldForEditorPickProduct("origin","");
	}


	public BrandForm catalogIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm catalogIdFieldForEditorPickProduct(String initValue){
		return catalogIdFieldForEditorPickProduct("catalogId",initValue);
	}
	public BrandForm catalogIdFieldForEditorPickProduct(){
		return catalogIdFieldForEditorPickProduct("catalogId","");
	}


	public BrandForm profileIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  profileIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm profileIdFieldForEditorPickProduct(String initValue){
		return profileIdFieldForEditorPickProduct("profileId",initValue);
	}
	public BrandForm profileIdFieldForEditorPickProduct(){
		return profileIdFieldForEditorPickProduct("profileId","");
	}


	public BrandForm remarkFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  remarkFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkFieldForEditorPickProduct(String initValue){
		return remarkFieldForEditorPickProduct("remark",initValue);
	}
	public BrandForm remarkFieldForEditorPickProduct(){
		return remarkFieldForEditorPickProduct("remark","");
	}


	public BrandForm lastUpdateTimeFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm lastUpdateTimeFieldForEditorPickProduct(String initValue){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime",initValue);
	}
	public BrandForm lastUpdateTimeFieldForEditorPickProduct(){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime","");
	}


	public BrandForm platformIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  platformIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm platformIdFieldForEditorPickProduct(String initValue){
		return platformIdFieldForEditorPickProduct("platformId",initValue);
	}
	public BrandForm platformIdFieldForEditorPickProduct(){
		return platformIdFieldForEditorPickProduct("platformId","");
	}


	public BrandForm topRatedProductIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  idFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm topRatedProductIdFieldForTopRatedProduct(String initValue){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId",initValue);
	}
	public BrandForm topRatedProductIdFieldForTopRatedProduct(){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId","");
	}


	public BrandForm nameFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  nameFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm nameFieldForTopRatedProduct(String initValue){
		return nameFieldForTopRatedProduct("name",initValue);
	}
	public BrandForm nameFieldForTopRatedProduct(){
		return nameFieldForTopRatedProduct("name","");
	}


	public BrandForm parentCategoryIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm parentCategoryIdFieldForTopRatedProduct(String initValue){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId",initValue);
	}
	public BrandForm parentCategoryIdFieldForTopRatedProduct(){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId","");
	}


	public BrandForm brandIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  brandIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdFieldForTopRatedProduct(String initValue){
		return brandIdFieldForTopRatedProduct("brandId",initValue);
	}
	public BrandForm brandIdFieldForTopRatedProduct(){
		return brandIdFieldForTopRatedProduct("brandId","");
	}


	public BrandForm productCoverImageFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productCoverImageFieldForTopRatedProduct(String initValue){
		return productCoverImageFieldForTopRatedProduct("productCoverImage",initValue);
	}
	public BrandForm productCoverImageFieldForTopRatedProduct(){
		return productCoverImageFieldForTopRatedProduct("productCoverImage","");
	}


	public BrandForm originFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  originFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm originFieldForTopRatedProduct(String initValue){
		return originFieldForTopRatedProduct("origin",initValue);
	}
	public BrandForm originFieldForTopRatedProduct(){
		return originFieldForTopRatedProduct("origin","");
	}


	public BrandForm catalogIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm catalogIdFieldForTopRatedProduct(String initValue){
		return catalogIdFieldForTopRatedProduct("catalogId",initValue);
	}
	public BrandForm catalogIdFieldForTopRatedProduct(){
		return catalogIdFieldForTopRatedProduct("catalogId","");
	}


	public BrandForm remarkFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  remarkFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkFieldForTopRatedProduct(String initValue){
		return remarkFieldForTopRatedProduct("remark",initValue);
	}
	public BrandForm remarkFieldForTopRatedProduct(){
		return remarkFieldForTopRatedProduct("remark","");
	}


	public BrandForm lastUpdateTimeFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm lastUpdateTimeFieldForTopRatedProduct(String initValue){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime",initValue);
	}
	public BrandForm lastUpdateTimeFieldForTopRatedProduct(){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime","");
	}


	public BrandForm profileIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  profileIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm profileIdFieldForTopRatedProduct(String initValue){
		return profileIdFieldForTopRatedProduct("profileId",initValue);
	}
	public BrandForm profileIdFieldForTopRatedProduct(){
		return profileIdFieldForTopRatedProduct("profileId","");
	}


	public BrandForm platformIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  platformIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm platformIdFieldForTopRatedProduct(String initValue){
		return platformIdFieldForTopRatedProduct("platformId",initValue);
	}
	public BrandForm platformIdFieldForTopRatedProduct(){
		return platformIdFieldForTopRatedProduct("platformId","");
	}


	public BrandForm recommandProductIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  idFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm recommandProductIdFieldForRecommandProduct(String initValue){
		return recommandProductIdFieldForRecommandProduct("recommandProductId",initValue);
	}
	public BrandForm recommandProductIdFieldForRecommandProduct(){
		return recommandProductIdFieldForRecommandProduct("recommandProductId","");
	}


	public BrandForm nameFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  nameFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm nameFieldForRecommandProduct(String initValue){
		return nameFieldForRecommandProduct("name",initValue);
	}
	public BrandForm nameFieldForRecommandProduct(){
		return nameFieldForRecommandProduct("name","");
	}


	public BrandForm parentCategoryIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm parentCategoryIdFieldForRecommandProduct(String initValue){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId",initValue);
	}
	public BrandForm parentCategoryIdFieldForRecommandProduct(){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId","");
	}


	public BrandForm brandIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  brandIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdFieldForRecommandProduct(String initValue){
		return brandIdFieldForRecommandProduct("brandId",initValue);
	}
	public BrandForm brandIdFieldForRecommandProduct(){
		return brandIdFieldForRecommandProduct("brandId","");
	}


	public BrandForm productCoverImageFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productCoverImageFieldForRecommandProduct(String initValue){
		return productCoverImageFieldForRecommandProduct("productCoverImage",initValue);
	}
	public BrandForm productCoverImageFieldForRecommandProduct(){
		return productCoverImageFieldForRecommandProduct("productCoverImage","");
	}


	public BrandForm originFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  originFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm originFieldForRecommandProduct(String initValue){
		return originFieldForRecommandProduct("origin",initValue);
	}
	public BrandForm originFieldForRecommandProduct(){
		return originFieldForRecommandProduct("origin","");
	}


	public BrandForm catalogIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm catalogIdFieldForRecommandProduct(String initValue){
		return catalogIdFieldForRecommandProduct("catalogId",initValue);
	}
	public BrandForm catalogIdFieldForRecommandProduct(){
		return catalogIdFieldForRecommandProduct("catalogId","");
	}


	public BrandForm remarkFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  remarkFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkFieldForRecommandProduct(String initValue){
		return remarkFieldForRecommandProduct("remark",initValue);
	}
	public BrandForm remarkFieldForRecommandProduct(){
		return remarkFieldForRecommandProduct("remark","");
	}


	public BrandForm lastUpdateTimeFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm lastUpdateTimeFieldForRecommandProduct(String initValue){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime",initValue);
	}
	public BrandForm lastUpdateTimeFieldForRecommandProduct(){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime","");
	}


	public BrandForm profileIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  profileIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm profileIdFieldForRecommandProduct(String initValue){
		return profileIdFieldForRecommandProduct("profileId",initValue);
	}
	public BrandForm profileIdFieldForRecommandProduct(){
		return profileIdFieldForRecommandProduct("profileId","");
	}


	public BrandForm platformIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  platformIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm platformIdFieldForRecommandProduct(String initValue){
		return platformIdFieldForRecommandProduct("platformId",initValue);
	}
	public BrandForm platformIdFieldForRecommandProduct(){
		return platformIdFieldForRecommandProduct("platformId","");
	}

	

	
 	public BrandForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/brandId/");
		this.addFormAction(action);
		return this;
	}

 

	public BrandForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


