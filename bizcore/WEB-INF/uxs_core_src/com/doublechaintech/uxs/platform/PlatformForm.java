package com.doublechaintech.uxs.platform;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}

	
	

	



	public PlatformForm siteIdFieldForSite(String parameterName, String initValue){
		FormField field =  idFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm siteIdFieldForSite(String initValue){
		return siteIdFieldForSite("siteId",initValue);
	}
	public PlatformForm siteIdFieldForSite(){
		return siteIdFieldForSite("siteId","");
	}


	public PlatformForm nameFieldForSite(String parameterName, String initValue){
		FormField field =  nameFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForSite(String initValue){
		return nameFieldForSite("name",initValue);
	}
	public PlatformForm nameFieldForSite(){
		return nameFieldForSite("name","");
	}


	public PlatformForm introductionFieldForSite(String parameterName, String initValue){
		FormField field =  introductionFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionFieldForSite(String initValue){
		return introductionFieldForSite("introduction",initValue);
	}
	public PlatformForm introductionFieldForSite(){
		return introductionFieldForSite("introduction","");
	}


	public PlatformForm platformIdFieldForSite(String parameterName, String initValue){
		FormField field =  platformIdFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForSite(String initValue){
		return platformIdFieldForSite("platformId",initValue);
	}
	public PlatformForm platformIdFieldForSite(){
		return platformIdFieldForSite("platformId","");
	}


	public PlatformForm lastUpdateTimeFieldForSite(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForSite(String initValue){
		return lastUpdateTimeFieldForSite("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForSite(){
		return lastUpdateTimeFieldForSite("lastUpdateTime","");
	}


	public PlatformForm catalogIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm catalogIdFieldForCatalog(String initValue){
		return catalogIdFieldForCatalog("catalogId",initValue);
	}
	public PlatformForm catalogIdFieldForCatalog(){
		return catalogIdFieldForCatalog("catalogId","");
	}


	public PlatformForm nameFieldForCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForCatalog(String initValue){
		return nameFieldForCatalog("name",initValue);
	}
	public PlatformForm nameFieldForCatalog(){
		return nameFieldForCatalog("name","");
	}


	public PlatformForm sellerIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm sellerIdFieldForCatalog(String initValue){
		return sellerIdFieldForCatalog("sellerId",initValue);
	}
	public PlatformForm sellerIdFieldForCatalog(){
		return sellerIdFieldForCatalog("sellerId","");
	}


	public PlatformForm siteIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm siteIdFieldForCatalog(String initValue){
		return siteIdFieldForCatalog("siteId",initValue);
	}
	public PlatformForm siteIdFieldForCatalog(){
		return siteIdFieldForCatalog("siteId","");
	}


	public PlatformForm platformIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  platformIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForCatalog(String initValue){
		return platformIdFieldForCatalog("platformId",initValue);
	}
	public PlatformForm platformIdFieldForCatalog(){
		return platformIdFieldForCatalog("platformId","");
	}


	public PlatformForm brandIdFieldForBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandIdFieldForBrand(String initValue){
		return brandIdFieldForBrand("brandId",initValue);
	}
	public PlatformForm brandIdFieldForBrand(){
		return brandIdFieldForBrand("brandId","");
	}


	public PlatformForm brandNameFieldForBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandNameFieldForBrand(String initValue){
		return brandNameFieldForBrand("brandName",initValue);
	}
	public PlatformForm brandNameFieldForBrand(){
		return brandNameFieldForBrand("brandName","");
	}


	public PlatformForm logoFieldForBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm logoFieldForBrand(String initValue){
		return logoFieldForBrand("logo",initValue);
	}
	public PlatformForm logoFieldForBrand(){
		return logoFieldForBrand("logo","");
	}


	public PlatformForm remarkFieldForBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForBrand(String initValue){
		return remarkFieldForBrand("remark",initValue);
	}
	public PlatformForm remarkFieldForBrand(){
		return remarkFieldForBrand("remark","");
	}


	public PlatformForm platformIdFieldForBrand(String parameterName, String initValue){
		FormField field =  platformIdFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForBrand(String initValue){
		return platformIdFieldForBrand("platformId",initValue);
	}
	public PlatformForm platformIdFieldForBrand(){
		return platformIdFieldForBrand("platformId","");
	}


	public PlatformForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public PlatformForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public PlatformForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public PlatformForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public PlatformForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public PlatformForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public PlatformForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public PlatformForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public PlatformForm productCoverImageFieldForProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm productCoverImageFieldForProduct(String initValue){
		return productCoverImageFieldForProduct("productCoverImage",initValue);
	}
	public PlatformForm productCoverImageFieldForProduct(){
		return productCoverImageFieldForProduct("productCoverImage","");
	}


	public PlatformForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public PlatformForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public PlatformForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public PlatformForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public PlatformForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public PlatformForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public PlatformForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}


	public PlatformForm platformIdFieldForProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProduct(String initValue){
		return platformIdFieldForProduct("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProduct(){
		return platformIdFieldForProduct("platformId","");
	}


	public PlatformForm bannerIdFieldForBanner(String parameterName, String initValue){
		FormField field =  idFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm bannerIdFieldForBanner(String initValue){
		return bannerIdFieldForBanner("bannerId",initValue);
	}
	public PlatformForm bannerIdFieldForBanner(){
		return bannerIdFieldForBanner("bannerId","");
	}


	public PlatformForm nameFieldForBanner(String parameterName, String initValue){
		FormField field =  nameFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForBanner(String initValue){
		return nameFieldForBanner("name",initValue);
	}
	public PlatformForm nameFieldForBanner(){
		return nameFieldForBanner("name","");
	}


	public PlatformForm imagePathFieldForBanner(String parameterName, String initValue){
		FormField field =  imagePathFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm imagePathFieldForBanner(String initValue){
		return imagePathFieldForBanner("imagePath",initValue);
	}
	public PlatformForm imagePathFieldForBanner(){
		return imagePathFieldForBanner("imagePath","");
	}


	public PlatformForm lastUpdateFieldForBanner(String parameterName, String initValue){
		FormField field =  lastUpdateFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateFieldForBanner(String initValue){
		return lastUpdateFieldForBanner("lastUpdate",initValue);
	}
	public PlatformForm lastUpdateFieldForBanner(){
		return lastUpdateFieldForBanner("lastUpdate","");
	}


	public PlatformForm platformIdFieldForBanner(String parameterName, String initValue){
		FormField field =  platformIdFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForBanner(String initValue){
		return platformIdFieldForBanner("platformId",initValue);
	}
	public PlatformForm platformIdFieldForBanner(){
		return platformIdFieldForBanner("platformId","");
	}


	public PlatformForm profileIdFieldForProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForProfile(String initValue){
		return profileIdFieldForProfile("profileId",initValue);
	}
	public PlatformForm profileIdFieldForProfile(){
		return profileIdFieldForProfile("profileId","");
	}


	public PlatformForm nameFieldForProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProfile(String initValue){
		return nameFieldForProfile("name",initValue);
	}
	public PlatformForm nameFieldForProfile(){
		return nameFieldForProfile("name","");
	}


	public PlatformForm platformIdFieldForProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProfile(String initValue){
		return platformIdFieldForProfile("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProfile(){
		return platformIdFieldForProfile("platformId","");
	}


	public PlatformForm userAlertIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  idFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm userAlertIdFieldForUserAlert(String initValue){
		return userAlertIdFieldForUserAlert("userAlertId",initValue);
	}
	public PlatformForm userAlertIdFieldForUserAlert(){
		return userAlertIdFieldForUserAlert("userAlertId","");
	}


	public PlatformForm messageFieldForUserAlert(String parameterName, String initValue){
		FormField field =  messageFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm messageFieldForUserAlert(String initValue){
		return messageFieldForUserAlert("message",initValue);
	}
	public PlatformForm messageFieldForUserAlert(){
		return messageFieldForUserAlert("message","");
	}


	public PlatformForm profileIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  profileIdFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForUserAlert(String initValue){
		return profileIdFieldForUserAlert("profileId",initValue);
	}
	public PlatformForm profileIdFieldForUserAlert(){
		return profileIdFieldForUserAlert("profileId","");
	}


	public PlatformForm locationFieldForUserAlert(String parameterName, String initValue){
		FormField field =  locationFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm locationFieldForUserAlert(String initValue){
		return locationFieldForUserAlert("location",initValue);
	}
	public PlatformForm locationFieldForUserAlert(){
		return locationFieldForUserAlert("location","");
	}


	public PlatformForm lastUpdateFieldForUserAlert(String parameterName, String initValue){
		FormField field =  lastUpdateFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateFieldForUserAlert(String initValue){
		return lastUpdateFieldForUserAlert("lastUpdate",initValue);
	}
	public PlatformForm lastUpdateFieldForUserAlert(){
		return lastUpdateFieldForUserAlert("lastUpdate","");
	}


	public PlatformForm platformIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  platformIdFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForUserAlert(String initValue){
		return platformIdFieldForUserAlert("platformId",initValue);
	}
	public PlatformForm platformIdFieldForUserAlert(){
		return platformIdFieldForUserAlert("platformId","");
	}


	public PlatformForm newProductIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  idFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm newProductIdFieldForNewProduct(String initValue){
		return newProductIdFieldForNewProduct("newProductId",initValue);
	}
	public PlatformForm newProductIdFieldForNewProduct(){
		return newProductIdFieldForNewProduct("newProductId","");
	}


	public PlatformForm nameFieldForNewProduct(String parameterName, String initValue){
		FormField field =  nameFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForNewProduct(String initValue){
		return nameFieldForNewProduct("name",initValue);
	}
	public PlatformForm nameFieldForNewProduct(){
		return nameFieldForNewProduct("name","");
	}


	public PlatformForm parentCategoryIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm parentCategoryIdFieldForNewProduct(String initValue){
		return parentCategoryIdFieldForNewProduct("parentCategoryId",initValue);
	}
	public PlatformForm parentCategoryIdFieldForNewProduct(){
		return parentCategoryIdFieldForNewProduct("parentCategoryId","");
	}


	public PlatformForm brandIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  brandIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandIdFieldForNewProduct(String initValue){
		return brandIdFieldForNewProduct("brandId",initValue);
	}
	public PlatformForm brandIdFieldForNewProduct(){
		return brandIdFieldForNewProduct("brandId","");
	}


	public PlatformForm productCoverImageFieldForNewProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm productCoverImageFieldForNewProduct(String initValue){
		return productCoverImageFieldForNewProduct("productCoverImage",initValue);
	}
	public PlatformForm productCoverImageFieldForNewProduct(){
		return productCoverImageFieldForNewProduct("productCoverImage","");
	}


	public PlatformForm originFieldForNewProduct(String parameterName, String initValue){
		FormField field =  originFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm originFieldForNewProduct(String initValue){
		return originFieldForNewProduct("origin",initValue);
	}
	public PlatformForm originFieldForNewProduct(){
		return originFieldForNewProduct("origin","");
	}


	public PlatformForm catalogIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm catalogIdFieldForNewProduct(String initValue){
		return catalogIdFieldForNewProduct("catalogId",initValue);
	}
	public PlatformForm catalogIdFieldForNewProduct(){
		return catalogIdFieldForNewProduct("catalogId","");
	}


	public PlatformForm profileIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  profileIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForNewProduct(String initValue){
		return profileIdFieldForNewProduct("profileId",initValue);
	}
	public PlatformForm profileIdFieldForNewProduct(){
		return profileIdFieldForNewProduct("profileId","");
	}


	public PlatformForm remarkFieldForNewProduct(String parameterName, String initValue){
		FormField field =  remarkFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForNewProduct(String initValue){
		return remarkFieldForNewProduct("remark",initValue);
	}
	public PlatformForm remarkFieldForNewProduct(){
		return remarkFieldForNewProduct("remark","");
	}


	public PlatformForm lastUpdateTimeFieldForNewProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForNewProduct(String initValue){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForNewProduct(){
		return lastUpdateTimeFieldForNewProduct("lastUpdateTime","");
	}


	public PlatformForm platformIdFieldForNewProduct(String parameterName, String initValue){
		FormField field =  platformIdFromNewProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForNewProduct(String initValue){
		return platformIdFieldForNewProduct("platformId",initValue);
	}
	public PlatformForm platformIdFieldForNewProduct(){
		return platformIdFieldForNewProduct("platformId","");
	}


	public PlatformForm editorPickProductIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  idFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm editorPickProductIdFieldForEditorPickProduct(String initValue){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId",initValue);
	}
	public PlatformForm editorPickProductIdFieldForEditorPickProduct(){
		return editorPickProductIdFieldForEditorPickProduct("editorPickProductId","");
	}


	public PlatformForm nameFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  nameFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForEditorPickProduct(String initValue){
		return nameFieldForEditorPickProduct("name",initValue);
	}
	public PlatformForm nameFieldForEditorPickProduct(){
		return nameFieldForEditorPickProduct("name","");
	}


	public PlatformForm parentCategoryIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm parentCategoryIdFieldForEditorPickProduct(String initValue){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId",initValue);
	}
	public PlatformForm parentCategoryIdFieldForEditorPickProduct(){
		return parentCategoryIdFieldForEditorPickProduct("parentCategoryId","");
	}


	public PlatformForm brandIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  brandIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandIdFieldForEditorPickProduct(String initValue){
		return brandIdFieldForEditorPickProduct("brandId",initValue);
	}
	public PlatformForm brandIdFieldForEditorPickProduct(){
		return brandIdFieldForEditorPickProduct("brandId","");
	}


	public PlatformForm productCoverImageFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm productCoverImageFieldForEditorPickProduct(String initValue){
		return productCoverImageFieldForEditorPickProduct("productCoverImage",initValue);
	}
	public PlatformForm productCoverImageFieldForEditorPickProduct(){
		return productCoverImageFieldForEditorPickProduct("productCoverImage","");
	}


	public PlatformForm originFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  originFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm originFieldForEditorPickProduct(String initValue){
		return originFieldForEditorPickProduct("origin",initValue);
	}
	public PlatformForm originFieldForEditorPickProduct(){
		return originFieldForEditorPickProduct("origin","");
	}


	public PlatformForm catalogIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm catalogIdFieldForEditorPickProduct(String initValue){
		return catalogIdFieldForEditorPickProduct("catalogId",initValue);
	}
	public PlatformForm catalogIdFieldForEditorPickProduct(){
		return catalogIdFieldForEditorPickProduct("catalogId","");
	}


	public PlatformForm profileIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  profileIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForEditorPickProduct(String initValue){
		return profileIdFieldForEditorPickProduct("profileId",initValue);
	}
	public PlatformForm profileIdFieldForEditorPickProduct(){
		return profileIdFieldForEditorPickProduct("profileId","");
	}


	public PlatformForm remarkFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  remarkFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForEditorPickProduct(String initValue){
		return remarkFieldForEditorPickProduct("remark",initValue);
	}
	public PlatformForm remarkFieldForEditorPickProduct(){
		return remarkFieldForEditorPickProduct("remark","");
	}


	public PlatformForm lastUpdateTimeFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForEditorPickProduct(String initValue){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForEditorPickProduct(){
		return lastUpdateTimeFieldForEditorPickProduct("lastUpdateTime","");
	}


	public PlatformForm platformIdFieldForEditorPickProduct(String parameterName, String initValue){
		FormField field =  platformIdFromEditorPickProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForEditorPickProduct(String initValue){
		return platformIdFieldForEditorPickProduct("platformId",initValue);
	}
	public PlatformForm platformIdFieldForEditorPickProduct(){
		return platformIdFieldForEditorPickProduct("platformId","");
	}


	public PlatformForm topRatedProductIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  idFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm topRatedProductIdFieldForTopRatedProduct(String initValue){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId",initValue);
	}
	public PlatformForm topRatedProductIdFieldForTopRatedProduct(){
		return topRatedProductIdFieldForTopRatedProduct("topRatedProductId","");
	}


	public PlatformForm nameFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  nameFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForTopRatedProduct(String initValue){
		return nameFieldForTopRatedProduct("name",initValue);
	}
	public PlatformForm nameFieldForTopRatedProduct(){
		return nameFieldForTopRatedProduct("name","");
	}


	public PlatformForm parentCategoryIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm parentCategoryIdFieldForTopRatedProduct(String initValue){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId",initValue);
	}
	public PlatformForm parentCategoryIdFieldForTopRatedProduct(){
		return parentCategoryIdFieldForTopRatedProduct("parentCategoryId","");
	}


	public PlatformForm brandIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  brandIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandIdFieldForTopRatedProduct(String initValue){
		return brandIdFieldForTopRatedProduct("brandId",initValue);
	}
	public PlatformForm brandIdFieldForTopRatedProduct(){
		return brandIdFieldForTopRatedProduct("brandId","");
	}


	public PlatformForm productCoverImageFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm productCoverImageFieldForTopRatedProduct(String initValue){
		return productCoverImageFieldForTopRatedProduct("productCoverImage",initValue);
	}
	public PlatformForm productCoverImageFieldForTopRatedProduct(){
		return productCoverImageFieldForTopRatedProduct("productCoverImage","");
	}


	public PlatformForm originFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  originFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm originFieldForTopRatedProduct(String initValue){
		return originFieldForTopRatedProduct("origin",initValue);
	}
	public PlatformForm originFieldForTopRatedProduct(){
		return originFieldForTopRatedProduct("origin","");
	}


	public PlatformForm catalogIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm catalogIdFieldForTopRatedProduct(String initValue){
		return catalogIdFieldForTopRatedProduct("catalogId",initValue);
	}
	public PlatformForm catalogIdFieldForTopRatedProduct(){
		return catalogIdFieldForTopRatedProduct("catalogId","");
	}


	public PlatformForm remarkFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  remarkFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForTopRatedProduct(String initValue){
		return remarkFieldForTopRatedProduct("remark",initValue);
	}
	public PlatformForm remarkFieldForTopRatedProduct(){
		return remarkFieldForTopRatedProduct("remark","");
	}


	public PlatformForm lastUpdateTimeFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForTopRatedProduct(String initValue){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForTopRatedProduct(){
		return lastUpdateTimeFieldForTopRatedProduct("lastUpdateTime","");
	}


	public PlatformForm profileIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  profileIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForTopRatedProduct(String initValue){
		return profileIdFieldForTopRatedProduct("profileId",initValue);
	}
	public PlatformForm profileIdFieldForTopRatedProduct(){
		return profileIdFieldForTopRatedProduct("profileId","");
	}


	public PlatformForm platformIdFieldForTopRatedProduct(String parameterName, String initValue){
		FormField field =  platformIdFromTopRatedProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForTopRatedProduct(String initValue){
		return platformIdFieldForTopRatedProduct("platformId",initValue);
	}
	public PlatformForm platformIdFieldForTopRatedProduct(){
		return platformIdFieldForTopRatedProduct("platformId","");
	}


	public PlatformForm recommandProductIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  idFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm recommandProductIdFieldForRecommandProduct(String initValue){
		return recommandProductIdFieldForRecommandProduct("recommandProductId",initValue);
	}
	public PlatformForm recommandProductIdFieldForRecommandProduct(){
		return recommandProductIdFieldForRecommandProduct("recommandProductId","");
	}


	public PlatformForm nameFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  nameFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForRecommandProduct(String initValue){
		return nameFieldForRecommandProduct("name",initValue);
	}
	public PlatformForm nameFieldForRecommandProduct(){
		return nameFieldForRecommandProduct("name","");
	}


	public PlatformForm parentCategoryIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm parentCategoryIdFieldForRecommandProduct(String initValue){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId",initValue);
	}
	public PlatformForm parentCategoryIdFieldForRecommandProduct(){
		return parentCategoryIdFieldForRecommandProduct("parentCategoryId","");
	}


	public PlatformForm brandIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  brandIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm brandIdFieldForRecommandProduct(String initValue){
		return brandIdFieldForRecommandProduct("brandId",initValue);
	}
	public PlatformForm brandIdFieldForRecommandProduct(){
		return brandIdFieldForRecommandProduct("brandId","");
	}


	public PlatformForm productCoverImageFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm productCoverImageFieldForRecommandProduct(String initValue){
		return productCoverImageFieldForRecommandProduct("productCoverImage",initValue);
	}
	public PlatformForm productCoverImageFieldForRecommandProduct(){
		return productCoverImageFieldForRecommandProduct("productCoverImage","");
	}


	public PlatformForm originFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  originFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm originFieldForRecommandProduct(String initValue){
		return originFieldForRecommandProduct("origin",initValue);
	}
	public PlatformForm originFieldForRecommandProduct(){
		return originFieldForRecommandProduct("origin","");
	}


	public PlatformForm catalogIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm catalogIdFieldForRecommandProduct(String initValue){
		return catalogIdFieldForRecommandProduct("catalogId",initValue);
	}
	public PlatformForm catalogIdFieldForRecommandProduct(){
		return catalogIdFieldForRecommandProduct("catalogId","");
	}


	public PlatformForm remarkFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  remarkFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remarkFieldForRecommandProduct(String initValue){
		return remarkFieldForRecommandProduct("remark",initValue);
	}
	public PlatformForm remarkFieldForRecommandProduct(){
		return remarkFieldForRecommandProduct("remark","");
	}


	public PlatformForm lastUpdateTimeFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForRecommandProduct(String initValue){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForRecommandProduct(){
		return lastUpdateTimeFieldForRecommandProduct("lastUpdateTime","");
	}


	public PlatformForm profileIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  profileIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForRecommandProduct(String initValue){
		return profileIdFieldForRecommandProduct("profileId",initValue);
	}
	public PlatformForm profileIdFieldForRecommandProduct(){
		return profileIdFieldForRecommandProduct("profileId","");
	}


	public PlatformForm platformIdFieldForRecommandProduct(String parameterName, String initValue){
		FormField field =  platformIdFromRecommandProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForRecommandProduct(String initValue){
		return platformIdFieldForRecommandProduct("platformId",initValue);
	}
	public PlatformForm platformIdFieldForRecommandProduct(){
		return platformIdFieldForRecommandProduct("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


