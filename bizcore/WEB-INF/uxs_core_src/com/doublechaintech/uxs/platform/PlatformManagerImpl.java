
package com.doublechaintech.uxs.platform;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;


import com.doublechaintech.uxs.Message;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;

import com.doublechaintech.uxs.UxsUserContext;
//import com.doublechaintech.uxs.BaseManagerImpl;
import com.doublechaintech.uxs.UxsCheckerManager;
import com.doublechaintech.uxs.CustomUxsCheckerManager;

import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.useralert.UserAlert;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;


import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;






public class PlatformManagerImpl extends CustomUxsCheckerManager implements PlatformManager {
	
	private static final String SERVICE_TYPE = "Platform";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}
	
	

 	protected Platform savePlatform(UxsUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(UxsUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(UxsUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(UxsUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(UxsUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = userContext.getDAOGroup().getPlatformDAO().present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPlatformDAO().alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(UxsUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(UxsUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPlatformDAO().save(platform, tokens);
 	}
 	protected Platform loadPlatform(UxsUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return userContext.getDAOGroup().getPlatformDAO().load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addSite","addSite","addSite/"+platform.getId()+"/","siteList","primary");
		addAction(userContext, platform, tokens,"platform.removeSite","removeSite","removeSite/"+platform.getId()+"/","siteList","primary");
		addAction(userContext, platform, tokens,"platform.updateSite","updateSite","updateSite/"+platform.getId()+"/","siteList","primary");
		addAction(userContext, platform, tokens,"platform.copySiteFrom","copySiteFrom","copySiteFrom/"+platform.getId()+"/","siteList","primary");
		addAction(userContext, platform, tokens,"platform.addCatalog","addCatalog","addCatalog/"+platform.getId()+"/","catalogList","primary");
		addAction(userContext, platform, tokens,"platform.removeCatalog","removeCatalog","removeCatalog/"+platform.getId()+"/","catalogList","primary");
		addAction(userContext, platform, tokens,"platform.updateCatalog","updateCatalog","updateCatalog/"+platform.getId()+"/","catalogList","primary");
		addAction(userContext, platform, tokens,"platform.copyCatalogFrom","copyCatalogFrom","copyCatalogFrom/"+platform.getId()+"/","catalogList","primary");
		addAction(userContext, platform, tokens,"platform.addBrand","addBrand","addBrand/"+platform.getId()+"/","brandList","primary");
		addAction(userContext, platform, tokens,"platform.removeBrand","removeBrand","removeBrand/"+platform.getId()+"/","brandList","primary");
		addAction(userContext, platform, tokens,"platform.updateBrand","updateBrand","updateBrand/"+platform.getId()+"/","brandList","primary");
		addAction(userContext, platform, tokens,"platform.copyBrandFrom","copyBrandFrom","copyBrandFrom/"+platform.getId()+"/","brandList","primary");
		addAction(userContext, platform, tokens,"platform.addProduct","addProduct","addProduct/"+platform.getId()+"/","productList","primary");
		addAction(userContext, platform, tokens,"platform.removeProduct","removeProduct","removeProduct/"+platform.getId()+"/","productList","primary");
		addAction(userContext, platform, tokens,"platform.updateProduct","updateProduct","updateProduct/"+platform.getId()+"/","productList","primary");
		addAction(userContext, platform, tokens,"platform.copyProductFrom","copyProductFrom","copyProductFrom/"+platform.getId()+"/","productList","primary");
		addAction(userContext, platform, tokens,"platform.addBanner","addBanner","addBanner/"+platform.getId()+"/","bannerList","primary");
		addAction(userContext, platform, tokens,"platform.removeBanner","removeBanner","removeBanner/"+platform.getId()+"/","bannerList","primary");
		addAction(userContext, platform, tokens,"platform.updateBanner","updateBanner","updateBanner/"+platform.getId()+"/","bannerList","primary");
		addAction(userContext, platform, tokens,"platform.copyBannerFrom","copyBannerFrom","copyBannerFrom/"+platform.getId()+"/","bannerList","primary");
		addAction(userContext, platform, tokens,"platform.addProfile","addProfile","addProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.removeProfile","removeProfile","removeProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.updateProfile","updateProfile","updateProfile/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.copyProfileFrom","copyProfileFrom","copyProfileFrom/"+platform.getId()+"/","profileList","primary");
		addAction(userContext, platform, tokens,"platform.addUserAlert","addUserAlert","addUserAlert/"+platform.getId()+"/","userAlertList","primary");
		addAction(userContext, platform, tokens,"platform.removeUserAlert","removeUserAlert","removeUserAlert/"+platform.getId()+"/","userAlertList","primary");
		addAction(userContext, platform, tokens,"platform.updateUserAlert","updateUserAlert","updateUserAlert/"+platform.getId()+"/","userAlertList","primary");
		addAction(userContext, platform, tokens,"platform.copyUserAlertFrom","copyUserAlertFrom","copyUserAlertFrom/"+platform.getId()+"/","userAlertList","primary");
		addAction(userContext, platform, tokens,"platform.addNewProduct","addNewProduct","addNewProduct/"+platform.getId()+"/","newProductList","primary");
		addAction(userContext, platform, tokens,"platform.removeNewProduct","removeNewProduct","removeNewProduct/"+platform.getId()+"/","newProductList","primary");
		addAction(userContext, platform, tokens,"platform.updateNewProduct","updateNewProduct","updateNewProduct/"+platform.getId()+"/","newProductList","primary");
		addAction(userContext, platform, tokens,"platform.copyNewProductFrom","copyNewProductFrom","copyNewProductFrom/"+platform.getId()+"/","newProductList","primary");
		addAction(userContext, platform, tokens,"platform.addEditorPickProduct","addEditorPickProduct","addEditorPickProduct/"+platform.getId()+"/","editorPickProductList","primary");
		addAction(userContext, platform, tokens,"platform.removeEditorPickProduct","removeEditorPickProduct","removeEditorPickProduct/"+platform.getId()+"/","editorPickProductList","primary");
		addAction(userContext, platform, tokens,"platform.updateEditorPickProduct","updateEditorPickProduct","updateEditorPickProduct/"+platform.getId()+"/","editorPickProductList","primary");
		addAction(userContext, platform, tokens,"platform.copyEditorPickProductFrom","copyEditorPickProductFrom","copyEditorPickProductFrom/"+platform.getId()+"/","editorPickProductList","primary");
		addAction(userContext, platform, tokens,"platform.addTopRatedProduct","addTopRatedProduct","addTopRatedProduct/"+platform.getId()+"/","topRatedProductList","primary");
		addAction(userContext, platform, tokens,"platform.removeTopRatedProduct","removeTopRatedProduct","removeTopRatedProduct/"+platform.getId()+"/","topRatedProductList","primary");
		addAction(userContext, platform, tokens,"platform.updateTopRatedProduct","updateTopRatedProduct","updateTopRatedProduct/"+platform.getId()+"/","topRatedProductList","primary");
		addAction(userContext, platform, tokens,"platform.copyTopRatedProductFrom","copyTopRatedProductFrom","copyTopRatedProductFrom/"+platform.getId()+"/","topRatedProductList","primary");
		addAction(userContext, platform, tokens,"platform.addRecommandProduct","addRecommandProduct","addRecommandProduct/"+platform.getId()+"/","recommandProductList","primary");
		addAction(userContext, platform, tokens,"platform.removeRecommandProduct","removeRecommandProduct","removeRecommandProduct/"+platform.getId()+"/","recommandProductList","primary");
		addAction(userContext, platform, tokens,"platform.updateRecommandProduct","updateRecommandProduct","updateRecommandProduct/"+platform.getId()+"/","recommandProductList","primary");
		addAction(userContext, platform, tokens,"platform.copyRecommandProductFrom","copyRecommandProductFrom","copyRecommandProductFrom/"+platform.getId()+"/","recommandProductList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Platform createPlatform(UxsUserContext userContext,String name) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPlatform(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;

		
	}
	protected Platform createNewPlatform() 
	{
		
		return new Platform();		
	}
	
	protected void checkParamsForUpdatingPlatform(UxsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPlatform(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
		
	}
	
	
	
	public Platform clone(UxsUserContext userContext, String fromPlatformId) throws Exception{
		
		return userContext.getDAOGroup().getPlatformDAO().clone(fromPlatformId, this.allTokens());
	}
	
	public Platform internalSavePlatform(UxsUserContext userContext, Platform platform) throws Exception 
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(UxsUserContext userContext, Platform platform, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			
			platform = savePlatform(userContext, platform, options);
			return platform;
			
		}

	}
	
	public Platform updatePlatform(UxsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	
	public Platform updatePlatformProperty(UxsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSiteListWith("id","desc")
		.sortCatalogListWith("id","desc")
		.sortBrandListWith("id","desc")
		.sortProductListWith("id","desc")
		.sortBannerListWith("id","desc")
		.sortProfileListWith("id","desc")
		.sortUserAlertListWith("id","desc")
		.sortNewProductListWith("id","desc")
		.sortEditorPickProductListWith("id","desc")
		.sortTopRatedProductListWith("id","desc")
		.sortRecommandProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		userContext.getDAOGroup().getPlatformDAO().delete(platformId, platformVersion);
	}
	
	public Platform forgetByAll(UxsUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);		
	}
	protected Platform forgetByAllInternal(UxsUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		return userContext.getDAOGroup().getPlatformDAO().disconnectFromAll(platformId, platformVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPlatformDAO().deleteAll();
	}


	//disconnect Platform with seller_id in Catalog
	protected Platform breakWithCatalogBySellerId(UxsUserContext userContext, String platformId, String sellerIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveCatalogListWithSellerId(platform, sellerIdId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
				return platform;
			}
	}
	//disconnect Platform with site in Catalog
	protected Platform breakWithCatalogBySite(UxsUserContext userContext, String platformId, String siteId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveCatalogListWithSite(platform, siteId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
				return platform;
			}
	}
	//disconnect Platform with parent_category in Product
	protected Platform breakWithProductByParentCategory(UxsUserContext userContext, String platformId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProductListWithParentCategory(platform, parentCategoryId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withProductList().done());
				return platform;
			}
	}
	//disconnect Platform with brand in Product
	protected Platform breakWithProductByBrand(UxsUserContext userContext, String platformId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProductListWithBrand(platform, brandId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withProductList().done());
				return platform;
			}
	}
	//disconnect Platform with catalog in Product
	protected Platform breakWithProductByCatalog(UxsUserContext userContext, String platformId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProductListWithCatalog(platform, catalogId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withProductList().done());
				return platform;
			}
	}
	//disconnect Platform with profile in UserAlert
	protected Platform breakWithUserAlertByProfile(UxsUserContext userContext, String platformId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveUserAlertListWithProfile(platform, profileId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withUserAlertList().done());
				return platform;
			}
	}
	//disconnect Platform with parent_category in NewProduct
	protected Platform breakWithNewProductByParentCategory(UxsUserContext userContext, String platformId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveNewProductListWithParentCategory(platform, parentCategoryId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
				return platform;
			}
	}
	//disconnect Platform with brand in NewProduct
	protected Platform breakWithNewProductByBrand(UxsUserContext userContext, String platformId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveNewProductListWithBrand(platform, brandId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
				return platform;
			}
	}
	//disconnect Platform with catalog in NewProduct
	protected Platform breakWithNewProductByCatalog(UxsUserContext userContext, String platformId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveNewProductListWithCatalog(platform, catalogId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
				return platform;
			}
	}
	//disconnect Platform with profile in NewProduct
	protected Platform breakWithNewProductByProfile(UxsUserContext userContext, String platformId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveNewProductListWithProfile(platform, profileId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
				return platform;
			}
	}
	//disconnect Platform with parent_category in EditorPickProduct
	protected Platform breakWithEditorPickProductByParentCategory(UxsUserContext userContext, String platformId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveEditorPickProductListWithParentCategory(platform, parentCategoryId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
				return platform;
			}
	}
	//disconnect Platform with brand in EditorPickProduct
	protected Platform breakWithEditorPickProductByBrand(UxsUserContext userContext, String platformId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveEditorPickProductListWithBrand(platform, brandId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
				return platform;
			}
	}
	//disconnect Platform with catalog in EditorPickProduct
	protected Platform breakWithEditorPickProductByCatalog(UxsUserContext userContext, String platformId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveEditorPickProductListWithCatalog(platform, catalogId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
				return platform;
			}
	}
	//disconnect Platform with profile in EditorPickProduct
	protected Platform breakWithEditorPickProductByProfile(UxsUserContext userContext, String platformId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveEditorPickProductListWithProfile(platform, profileId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
				return platform;
			}
	}
	//disconnect Platform with parent_category in TopRatedProduct
	protected Platform breakWithTopRatedProductByParentCategory(UxsUserContext userContext, String platformId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTopRatedProductListWithParentCategory(platform, parentCategoryId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
				return platform;
			}
	}
	//disconnect Platform with brand in TopRatedProduct
	protected Platform breakWithTopRatedProductByBrand(UxsUserContext userContext, String platformId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTopRatedProductListWithBrand(platform, brandId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
				return platform;
			}
	}
	//disconnect Platform with catalog in TopRatedProduct
	protected Platform breakWithTopRatedProductByCatalog(UxsUserContext userContext, String platformId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTopRatedProductListWithCatalog(platform, catalogId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
				return platform;
			}
	}
	//disconnect Platform with profile in TopRatedProduct
	protected Platform breakWithTopRatedProductByProfile(UxsUserContext userContext, String platformId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTopRatedProductListWithProfile(platform, profileId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
				return platform;
			}
	}
	//disconnect Platform with parent_category in RecommandProduct
	protected Platform breakWithRecommandProductByParentCategory(UxsUserContext userContext, String platformId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveRecommandProductListWithParentCategory(platform, parentCategoryId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
				return platform;
			}
	}
	//disconnect Platform with brand in RecommandProduct
	protected Platform breakWithRecommandProductByBrand(UxsUserContext userContext, String platformId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveRecommandProductListWithBrand(platform, brandId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
				return platform;
			}
	}
	//disconnect Platform with catalog in RecommandProduct
	protected Platform breakWithRecommandProductByCatalog(UxsUserContext userContext, String platformId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveRecommandProductListWithCatalog(platform, catalogId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
				return platform;
			}
	}
	//disconnect Platform with profile in RecommandProduct
	protected Platform breakWithRecommandProductByProfile(UxsUserContext userContext, String platformId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPlatformDAO().planToRemoveRecommandProductListWithProfile(platform, profileId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
				return platform;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingSite(UxsUserContext userContext, String platformId, String name, String introduction,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfSite(name);
		
		userContext.getChecker().checkIntroductionOfSite(introduction);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addSite(UxsUserContext userContext, String platformId, String name, String introduction, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSite(userContext,platformId,name, introduction,tokensExpr);
		
		Site site = createSite(userContext,name, introduction);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addSite( site );		
			platform = savePlatform(userContext, platform, tokens().withSiteList().done());
			
			userContext.getManagerGroup().getSiteManager().onNewInstanceCreated(userContext, site);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSiteProperties(UxsUserContext userContext, String platformId,String id,String name,String introduction,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfSite(id);
		
		userContext.getChecker().checkNameOfSite( name);
		userContext.getChecker().checkIntroductionOfSite( introduction);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateSiteProperties(UxsUserContext userContext, String platformId, String id,String name,String introduction, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSiteProperties(userContext,platformId,id,name,introduction,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSiteListList()
				.searchSiteListWith(Site.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getSiteList().isEmpty()){
			throw new PlatformManagerException("Site is NOT FOUND with id: '"+id+"'");
		}
		
		Site item = platformToUpdate.getSiteList().first();
		
		item.updateName( name );
		item.updateIntroduction( introduction );

		
		//checkParamsForAddingSite(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withSiteList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Site createSite(UxsUserContext userContext, String name, String introduction) throws Exception{

		Site site = new Site();
		
		
		site.setName(name);		
		site.setIntroduction(introduction);		
		site.setLastUpdateTime(userContext.now());
	
		
		return site;
	
		
	}
	
	protected Site createIndexedSite(String id, int version){

		Site site = new Site();
		site.setId(id);
		site.setVersion(version);
		return site;			
		
	}
	
	protected void checkParamsForRemovingSiteList(UxsUserContext userContext, String platformId, 
			String siteIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String siteId: siteIds){
			userContext.getChecker().checkIdOfSite(siteId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeSiteList(UxsUserContext userContext, String platformId, 
			String siteIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSiteList(userContext, platformId,  siteIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveSiteList(platform, siteIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withSiteList().done());
				deleteRelationListInGraph(userContext, platform.getSiteList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSite(UxsUserContext userContext, String platformId, 
		String siteId, int siteVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkVersionOfSite(siteVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeSite(UxsUserContext userContext, String platformId, 
		String siteId, int siteVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSite(userContext,platformId, siteId, siteVersion,tokensExpr);
		
		Site site = createIndexedSite(siteId, siteVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeSite( site );		
			platform = savePlatform(userContext, platform, tokens().withSiteList().done());
			deleteRelationInGraph(userContext, site);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSite(UxsUserContext userContext, String platformId, 
		String siteId, int siteVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkVersionOfSite(siteVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copySiteFrom(UxsUserContext userContext, String platformId, 
		String siteId, int siteVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSite(userContext,platformId, siteId, siteVersion,tokensExpr);
		
		Site site = createIndexedSite(siteId, siteVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			site.updateLastUpdateTime(userContext.now());
			
			platform.copySiteFrom( site );		
			platform = savePlatform(userContext, platform, tokens().withSiteList().done());
			
			userContext.getManagerGroup().getSiteManager().onNewInstanceCreated(userContext, (Site)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSite(UxsUserContext userContext, String platformId, String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkVersionOfSite(siteVersion);
		

		if(Site.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSite(parseString(newValueExpr));
		}
		
		if(Site.INTRODUCTION_PROPERTY.equals(property)){
			userContext.getChecker().checkIntroductionOfSite(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateSite(UxsUserContext userContext, String platformId, String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSite(userContext, platformId, siteId, siteVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSiteList().searchSiteListWith(Site.ID_PROPERTY, "eq", siteId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeSite( site );	
			//make changes to AcceleraterAccount.
			Site siteIndex = createIndexedSite(siteId, siteVersion);
		
			Site site = platform.findTheSite(siteIndex);
			if(site == null){
				throw new PlatformManagerException(site+" is NOT FOUND" );
			}
			
			site.changeProperty(property, newValueExpr);
			site.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withSiteList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingCatalog(UxsUserContext userContext, String platformId, String name, String sellerId, String siteId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfCatalog(name);
		
		userContext.getChecker().checkSellerIdOfCatalog(sellerId);
		
		userContext.getChecker().checkSiteIdOfCatalog(siteId);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addCatalog(UxsUserContext userContext, String platformId, String name, String sellerId, String siteId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCatalog(userContext,platformId,name, sellerId, siteId,tokensExpr);
		
		Catalog catalog = createCatalog(userContext,name, sellerId, siteId);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addCatalog( catalog );		
			platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, catalog);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCatalogProperties(UxsUserContext userContext, String platformId,String id,String name,String sellerId,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfCatalog(id);
		
		userContext.getChecker().checkNameOfCatalog( name);
		userContext.getChecker().checkSellerIdOfCatalog( sellerId);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateCatalogProperties(UxsUserContext userContext, String platformId, String id,String name,String sellerId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingCatalogProperties(userContext,platformId,id,name,sellerId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCatalogListList()
				.searchCatalogListWith(Catalog.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getCatalogList().isEmpty()){
			throw new PlatformManagerException("Catalog is NOT FOUND with id: '"+id+"'");
		}
		
		Catalog item = platformToUpdate.getCatalogList().first();
		
		item.updateName( name );
		item.updateSellerId( sellerId );

		
		//checkParamsForAddingCatalog(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withCatalogList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Catalog createCatalog(UxsUserContext userContext, String name, String sellerId, String siteId) throws Exception{

		Catalog catalog = new Catalog();
		
		
		catalog.setName(name);		
		catalog.setSellerId(sellerId);		
		Site  site = new Site();
		site.setId(siteId);		
		catalog.setSite(site);
	
		
		return catalog;
	
		
	}
	
	protected Catalog createIndexedCatalog(String id, int version){

		Catalog catalog = new Catalog();
		catalog.setId(id);
		catalog.setVersion(version);
		return catalog;			
		
	}
	
	protected void checkParamsForRemovingCatalogList(UxsUserContext userContext, String platformId, 
			String catalogIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String catalogId: catalogIds){
			userContext.getChecker().checkIdOfCatalog(catalogId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeCatalogList(UxsUserContext userContext, String platformId, 
			String catalogIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingCatalogList(userContext, platformId,  catalogIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveCatalogList(platform, catalogIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
				deleteRelationListInGraph(userContext, platform.getCatalogList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingCatalog(UxsUserContext userContext, String platformId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeCatalog(UxsUserContext userContext, String platformId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCatalog(userContext,platformId, catalogId, catalogVersion,tokensExpr);
		
		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeCatalog( catalog );		
			platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
			deleteRelationInGraph(userContext, catalog);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingCatalog(UxsUserContext userContext, String platformId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyCatalogFrom(UxsUserContext userContext, String platformId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCatalog(userContext,platformId, catalogId, catalogVersion,tokensExpr);
		
		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyCatalogFrom( catalog );		
			platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, (Catalog)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingCatalog(UxsUserContext userContext, String platformId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		

		if(Catalog.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCatalog(parseString(newValueExpr));
		}
		
		if(Catalog.SELLER_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSellerIdOfCatalog(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateCatalog(UxsUserContext userContext, String platformId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCatalog(userContext, platformId, catalogId, catalogVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withCatalogList().searchCatalogListWith(Catalog.ID_PROPERTY, "eq", catalogId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeCatalog( catalog );	
			//make changes to AcceleraterAccount.
			Catalog catalogIndex = createIndexedCatalog(catalogId, catalogVersion);
		
			Catalog catalog = platform.findTheCatalog(catalogIndex);
			if(catalog == null){
				throw new PlatformManagerException(catalog+" is NOT FOUND" );
			}
			
			catalog.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withCatalogList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingBrand(UxsUserContext userContext, String platformId, String brandName, String logo, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkBrandNameOfBrand(brandName);
		
		userContext.getChecker().checkLogoOfBrand(logo);
		
		userContext.getChecker().checkRemarkOfBrand(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addBrand(UxsUserContext userContext, String platformId, String brandName, String logo, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingBrand(userContext,platformId,brandName, logo, remark,tokensExpr);
		
		Brand brand = createBrand(userContext,brandName, logo, remark);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addBrand( brand );		
			platform = savePlatform(userContext, platform, tokens().withBrandList().done());
			
			userContext.getManagerGroup().getBrandManager().onNewInstanceCreated(userContext, brand);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingBrandProperties(UxsUserContext userContext, String platformId,String id,String brandName,String logo,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfBrand(id);
		
		userContext.getChecker().checkBrandNameOfBrand( brandName);
		userContext.getChecker().checkLogoOfBrand( logo);
		userContext.getChecker().checkRemarkOfBrand( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateBrandProperties(UxsUserContext userContext, String platformId, String id,String brandName,String logo,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingBrandProperties(userContext,platformId,id,brandName,logo,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withBrandListList()
				.searchBrandListWith(Brand.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getBrandList().isEmpty()){
			throw new PlatformManagerException("Brand is NOT FOUND with id: '"+id+"'");
		}
		
		Brand item = platformToUpdate.getBrandList().first();
		
		item.updateBrandName( brandName );
		item.updateLogo( logo );
		item.updateRemark( remark );

		
		//checkParamsForAddingBrand(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withBrandList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Brand createBrand(UxsUserContext userContext, String brandName, String logo, String remark) throws Exception{

		Brand brand = new Brand();
		
		
		brand.setBrandName(brandName);		
		brand.setLogo(logo);		
		brand.setRemark(remark);
	
		
		return brand;
	
		
	}
	
	protected Brand createIndexedBrand(String id, int version){

		Brand brand = new Brand();
		brand.setId(id);
		brand.setVersion(version);
		return brand;			
		
	}
	
	protected void checkParamsForRemovingBrandList(UxsUserContext userContext, String platformId, 
			String brandIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String brandId: brandIds){
			userContext.getChecker().checkIdOfBrand(brandId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeBrandList(UxsUserContext userContext, String platformId, 
			String brandIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingBrandList(userContext, platformId,  brandIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveBrandList(platform, brandIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withBrandList().done());
				deleteRelationListInGraph(userContext, platform.getBrandList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingBrand(UxsUserContext userContext, String platformId, 
		String brandId, int brandVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand(brandVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeBrand(UxsUserContext userContext, String platformId, 
		String brandId, int brandVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingBrand(userContext,platformId, brandId, brandVersion,tokensExpr);
		
		Brand brand = createIndexedBrand(brandId, brandVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeBrand( brand );		
			platform = savePlatform(userContext, platform, tokens().withBrandList().done());
			deleteRelationInGraph(userContext, brand);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingBrand(UxsUserContext userContext, String platformId, 
		String brandId, int brandVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand(brandVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyBrandFrom(UxsUserContext userContext, String platformId, 
		String brandId, int brandVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingBrand(userContext,platformId, brandId, brandVersion,tokensExpr);
		
		Brand brand = createIndexedBrand(brandId, brandVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyBrandFrom( brand );		
			platform = savePlatform(userContext, platform, tokens().withBrandList().done());
			
			userContext.getManagerGroup().getBrandManager().onNewInstanceCreated(userContext, (Brand)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingBrand(UxsUserContext userContext, String platformId, String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand(brandVersion);
		

		if(Brand.BRAND_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkBrandNameOfBrand(parseString(newValueExpr));
		}
		
		if(Brand.LOGO_PROPERTY.equals(property)){
			userContext.getChecker().checkLogoOfBrand(parseString(newValueExpr));
		}
		
		if(Brand.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfBrand(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateBrand(UxsUserContext userContext, String platformId, String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingBrand(userContext, platformId, brandId, brandVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withBrandList().searchBrandListWith(Brand.ID_PROPERTY, "eq", brandId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeBrand( brand );	
			//make changes to AcceleraterAccount.
			Brand brandIndex = createIndexedBrand(brandId, brandVersion);
		
			Brand brand = platform.findTheBrand(brandIndex);
			if(brand == null){
				throw new PlatformManagerException(brand+" is NOT FOUND" );
			}
			
			brand.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withBrandList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,platformId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark,tokensExpr);
		
		Product product = createProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addProduct( product );		
			platform = savePlatform(userContext, platform, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(UxsUserContext userContext, String platformId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkProductCoverImageOfProduct( productCoverImage);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateProductProperties(UxsUserContext userContext, String platformId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,platformId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getProductList().isEmpty()){
			throw new PlatformManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = platformToUpdate.getProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingProduct(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withProductList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		product.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		product.setBrand(brand);		
		product.setProductCoverImage(productCoverImage);		
		product.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		product.setCatalog(catalog);		
		product.setRemark(remark);		
		product.setLastUpdateTime(userContext.now());
	
		
		return product;
	
		
	}
	
	protected Product createIndexedProduct(String id, int version){

		Product product = new Product();
		product.setId(id);
		product.setVersion(version);
		return product;			
		
	}
	
	protected void checkParamsForRemovingProductList(UxsUserContext userContext, String platformId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeProductList(UxsUserContext userContext, String platformId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, platformId,  productIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProductList(platform, productIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, platform.getProductList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(UxsUserContext userContext, String platformId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeProduct(UxsUserContext userContext, String platformId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,platformId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeProduct( product );		
			platform = savePlatform(userContext, platform, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(UxsUserContext userContext, String platformId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyProductFrom(UxsUserContext userContext, String platformId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,platformId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			product.updateLastUpdateTime(userContext.now());
			
			platform.copyProductFrom( product );		
			platform = savePlatform(userContext, platform, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(UxsUserContext userContext, String platformId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		

		if(Product.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProduct(parseString(newValueExpr));
		}
		
		if(Product.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfProduct(parseString(newValueExpr));
		}
		
		if(Product.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfProduct(parseString(newValueExpr));
		}
		
		if(Product.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateProduct(UxsUserContext userContext, String platformId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, platformId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = platform.findTheProduct(productIndex);
			if(product == null){
				throw new PlatformManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withProductList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingBanner(UxsUserContext userContext, String platformId, String name, String imagePath,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfBanner(name);
		
		userContext.getChecker().checkImagePathOfBanner(imagePath);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addBanner(UxsUserContext userContext, String platformId, String name, String imagePath, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingBanner(userContext,platformId,name, imagePath,tokensExpr);
		
		Banner banner = createBanner(userContext,name, imagePath);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addBanner( banner );		
			platform = savePlatform(userContext, platform, tokens().withBannerList().done());
			
			userContext.getManagerGroup().getBannerManager().onNewInstanceCreated(userContext, banner);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingBannerProperties(UxsUserContext userContext, String platformId,String id,String name,String imagePath,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfBanner(id);
		
		userContext.getChecker().checkNameOfBanner( name);
		userContext.getChecker().checkImagePathOfBanner( imagePath);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateBannerProperties(UxsUserContext userContext, String platformId, String id,String name,String imagePath, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingBannerProperties(userContext,platformId,id,name,imagePath,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withBannerListList()
				.searchBannerListWith(Banner.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getBannerList().isEmpty()){
			throw new PlatformManagerException("Banner is NOT FOUND with id: '"+id+"'");
		}
		
		Banner item = platformToUpdate.getBannerList().first();
		
		item.updateName( name );
		item.updateImagePath( imagePath );

		
		//checkParamsForAddingBanner(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withBannerList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Banner createBanner(UxsUserContext userContext, String name, String imagePath) throws Exception{

		Banner banner = new Banner();
		
		
		banner.setName(name);		
		banner.setImagePath(imagePath);		
		banner.setLastUpdate(userContext.now());
	
		
		return banner;
	
		
	}
	
	protected Banner createIndexedBanner(String id, int version){

		Banner banner = new Banner();
		banner.setId(id);
		banner.setVersion(version);
		return banner;			
		
	}
	
	protected void checkParamsForRemovingBannerList(UxsUserContext userContext, String platformId, 
			String bannerIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String bannerId: bannerIds){
			userContext.getChecker().checkIdOfBanner(bannerId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeBannerList(UxsUserContext userContext, String platformId, 
			String bannerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingBannerList(userContext, platformId,  bannerIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveBannerList(platform, bannerIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withBannerList().done());
				deleteRelationListInGraph(userContext, platform.getBannerList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingBanner(UxsUserContext userContext, String platformId, 
		String bannerId, int bannerVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().checkVersionOfBanner(bannerVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeBanner(UxsUserContext userContext, String platformId, 
		String bannerId, int bannerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingBanner(userContext,platformId, bannerId, bannerVersion,tokensExpr);
		
		Banner banner = createIndexedBanner(bannerId, bannerVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeBanner( banner );		
			platform = savePlatform(userContext, platform, tokens().withBannerList().done());
			deleteRelationInGraph(userContext, banner);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingBanner(UxsUserContext userContext, String platformId, 
		String bannerId, int bannerVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().checkVersionOfBanner(bannerVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyBannerFrom(UxsUserContext userContext, String platformId, 
		String bannerId, int bannerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingBanner(userContext,platformId, bannerId, bannerVersion,tokensExpr);
		
		Banner banner = createIndexedBanner(bannerId, bannerVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			banner.updateLastUpdate(userContext.now());
			
			platform.copyBannerFrom( banner );		
			platform = savePlatform(userContext, platform, tokens().withBannerList().done());
			
			userContext.getManagerGroup().getBannerManager().onNewInstanceCreated(userContext, (Banner)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingBanner(UxsUserContext userContext, String platformId, String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().checkVersionOfBanner(bannerVersion);
		

		if(Banner.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfBanner(parseString(newValueExpr));
		}
		
		if(Banner.IMAGE_PATH_PROPERTY.equals(property)){
			userContext.getChecker().checkImagePathOfBanner(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateBanner(UxsUserContext userContext, String platformId, String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingBanner(userContext, platformId, bannerId, bannerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withBannerList().searchBannerListWith(Banner.ID_PROPERTY, "eq", bannerId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeBanner( banner );	
			//make changes to AcceleraterAccount.
			Banner bannerIndex = createIndexedBanner(bannerId, bannerVersion);
		
			Banner banner = platform.findTheBanner(bannerIndex);
			if(banner == null){
				throw new PlatformManagerException(banner+" is NOT FOUND" );
			}
			
			banner.changeProperty(property, newValueExpr);
			banner.updateLastUpdate(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withBannerList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingProfile(UxsUserContext userContext, String platformId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfProfile(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addProfile(UxsUserContext userContext, String platformId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProfile(userContext,platformId,name,tokensExpr);
		
		Profile profile = createProfile(userContext,name);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addProfile( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			
			userContext.getManagerGroup().getProfileManager().onNewInstanceCreated(userContext, profile);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProfileProperties(UxsUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProfile(id);
		
		userContext.getChecker().checkNameOfProfile( name);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateProfileProperties(UxsUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProfileProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProfileListList()
				.searchProfileListWith(Profile.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getProfileList().isEmpty()){
			throw new PlatformManagerException("Profile is NOT FOUND with id: '"+id+"'");
		}
		
		Profile item = platformToUpdate.getProfileList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingProfile(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withProfileList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Profile createProfile(UxsUserContext userContext, String name) throws Exception{

		Profile profile = new Profile();
		
		
		profile.setName(name);
	
		
		return profile;
	
		
	}
	
	protected Profile createIndexedProfile(String id, int version){

		Profile profile = new Profile();
		profile.setId(id);
		profile.setVersion(version);
		return profile;			
		
	}
	
	protected void checkParamsForRemovingProfileList(UxsUserContext userContext, String platformId, 
			String profileIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String profileId: profileIds){
			userContext.getChecker().checkIdOfProfile(profileId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeProfileList(UxsUserContext userContext, String platformId, 
			String profileIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProfileList(userContext, platformId,  profileIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveProfileList(platform, profileIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withProfileList().done());
				deleteRelationListInGraph(userContext, platform.getProfileList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProfile(UxsUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeProfile(UxsUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProfile(userContext,platformId, profileId, profileVersion,tokensExpr);
		
		Profile profile = createIndexedProfile(profileId, profileVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeProfile( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			deleteRelationInGraph(userContext, profile);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProfile(UxsUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyProfileFrom(UxsUserContext userContext, String platformId, 
		String profileId, int profileVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProfile(userContext,platformId, profileId, profileVersion,tokensExpr);
		
		Profile profile = createIndexedProfile(profileId, profileVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyProfileFrom( profile );		
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			
			userContext.getManagerGroup().getProfileManager().onNewInstanceCreated(userContext, (Profile)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProfile(UxsUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile(profileVersion);
		

		if(Profile.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProfile(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateProfile(UxsUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProfile(userContext, platformId, profileId, profileVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProfileList().searchProfileListWith(Profile.ID_PROPERTY, "eq", profileId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeProfile( profile );	
			//make changes to AcceleraterAccount.
			Profile profileIndex = createIndexedProfile(profileId, profileVersion);
		
			Profile profile = platform.findTheProfile(profileIndex);
			if(profile == null){
				throw new PlatformManagerException(profile+" is NOT FOUND" );
			}
			
			profile.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withProfileList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingUserAlert(UxsUserContext userContext, String platformId, String message, String profileId, String location,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkMessageOfUserAlert(message);
		
		userContext.getChecker().checkProfileIdOfUserAlert(profileId);
		
		userContext.getChecker().checkLocationOfUserAlert(location);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addUserAlert(UxsUserContext userContext, String platformId, String message, String profileId, String location, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserAlert(userContext,platformId,message, profileId, location,tokensExpr);
		
		UserAlert userAlert = createUserAlert(userContext,message, profileId, location);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addUserAlert( userAlert );		
			platform = savePlatform(userContext, platform, tokens().withUserAlertList().done());
			
			userContext.getManagerGroup().getUserAlertManager().onNewInstanceCreated(userContext, userAlert);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAlertProperties(UxsUserContext userContext, String platformId,String id,String message,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfUserAlert(id);
		
		userContext.getChecker().checkMessageOfUserAlert( message);
		userContext.getChecker().checkLocationOfUserAlert( location);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateUserAlertProperties(UxsUserContext userContext, String platformId, String id,String message,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingUserAlertProperties(userContext,platformId,id,message,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAlertListList()
				.searchUserAlertListWith(UserAlert.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getUserAlertList().isEmpty()){
			throw new PlatformManagerException("UserAlert is NOT FOUND with id: '"+id+"'");
		}
		
		UserAlert item = platformToUpdate.getUserAlertList().first();
		
		item.updateMessage( message );
		item.updateLocation( location );

		
		//checkParamsForAddingUserAlert(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withUserAlertList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected UserAlert createUserAlert(UxsUserContext userContext, String message, String profileId, String location) throws Exception{

		UserAlert userAlert = new UserAlert();
		
		
		userAlert.setMessage(message);		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		userAlert.setProfile(profile);		
		userAlert.setLocation(location);		
		userAlert.setLastUpdate(userContext.now());
	
		
		return userAlert;
	
		
	}
	
	protected UserAlert createIndexedUserAlert(String id, int version){

		UserAlert userAlert = new UserAlert();
		userAlert.setId(id);
		userAlert.setVersion(version);
		return userAlert;			
		
	}
	
	protected void checkParamsForRemovingUserAlertList(UxsUserContext userContext, String platformId, 
			String userAlertIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String userAlertId: userAlertIds){
			userContext.getChecker().checkIdOfUserAlert(userAlertId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeUserAlertList(UxsUserContext userContext, String platformId, 
			String userAlertIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingUserAlertList(userContext, platformId,  userAlertIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveUserAlertList(platform, userAlertIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withUserAlertList().done());
				deleteRelationListInGraph(userContext, platform.getUserAlertList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingUserAlert(UxsUserContext userContext, String platformId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeUserAlert(UxsUserContext userContext, String platformId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserAlert(userContext,platformId, userAlertId, userAlertVersion,tokensExpr);
		
		UserAlert userAlert = createIndexedUserAlert(userAlertId, userAlertVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeUserAlert( userAlert );		
			platform = savePlatform(userContext, platform, tokens().withUserAlertList().done());
			deleteRelationInGraph(userContext, userAlert);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingUserAlert(UxsUserContext userContext, String platformId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyUserAlertFrom(UxsUserContext userContext, String platformId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserAlert(userContext,platformId, userAlertId, userAlertVersion,tokensExpr);
		
		UserAlert userAlert = createIndexedUserAlert(userAlertId, userAlertVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			userAlert.updateLastUpdate(userContext.now());
			
			platform.copyUserAlertFrom( userAlert );		
			platform = savePlatform(userContext, platform, tokens().withUserAlertList().done());
			
			userContext.getManagerGroup().getUserAlertManager().onNewInstanceCreated(userContext, (UserAlert)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingUserAlert(UxsUserContext userContext, String platformId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		

		if(UserAlert.MESSAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkMessageOfUserAlert(parseString(newValueExpr));
		}
		
		if(UserAlert.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfUserAlert(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateUserAlert(UxsUserContext userContext, String platformId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserAlert(userContext, platformId, userAlertId, userAlertVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withUserAlertList().searchUserAlertListWith(UserAlert.ID_PROPERTY, "eq", userAlertId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeUserAlert( userAlert );	
			//make changes to AcceleraterAccount.
			UserAlert userAlertIndex = createIndexedUserAlert(userAlertId, userAlertVersion);
		
			UserAlert userAlert = platform.findTheUserAlert(userAlertIndex);
			if(userAlert == null){
				throw new PlatformManagerException(userAlert+" is NOT FOUND" );
			}
			
			userAlert.changeProperty(property, newValueExpr);
			userAlert.updateLastUpdate(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withUserAlertList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingNewProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfNewProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfNewProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfNewProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfNewProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfNewProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfNewProduct(catalogId);
		
		userContext.getChecker().checkProfileIdOfNewProduct(profileId);
		
		userContext.getChecker().checkRemarkOfNewProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addNewProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNewProduct(userContext,platformId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, profileId, remark,tokensExpr);
		
		NewProduct newProduct = createNewProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, profileId, remark);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addNewProduct( newProduct );		
			platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, newProduct);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNewProductProperties(UxsUserContext userContext, String platformId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfNewProduct(id);
		
		userContext.getChecker().checkNameOfNewProduct( name);
		userContext.getChecker().checkProductCoverImageOfNewProduct( productCoverImage);
		userContext.getChecker().checkOriginOfNewProduct( origin);
		userContext.getChecker().checkRemarkOfNewProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateNewProductProperties(UxsUserContext userContext, String platformId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNewProductProperties(userContext,platformId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNewProductListList()
				.searchNewProductListWith(NewProduct.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getNewProductList().isEmpty()){
			throw new PlatformManagerException("NewProduct is NOT FOUND with id: '"+id+"'");
		}
		
		NewProduct item = platformToUpdate.getNewProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingNewProduct(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withNewProductList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected NewProduct createNewProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark) throws Exception{

		NewProduct newProduct = new NewProduct();
		
		
		newProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		newProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		newProduct.setBrand(brand);		
		newProduct.setProductCoverImage(productCoverImage);		
		newProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		newProduct.setCatalog(catalog);		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		newProduct.setProfile(profile);		
		newProduct.setRemark(remark);		
		newProduct.setLastUpdateTime(userContext.now());
	
		
		return newProduct;
	
		
	}
	
	protected NewProduct createIndexedNewProduct(String id, int version){

		NewProduct newProduct = new NewProduct();
		newProduct.setId(id);
		newProduct.setVersion(version);
		return newProduct;			
		
	}
	
	protected void checkParamsForRemovingNewProductList(UxsUserContext userContext, String platformId, 
			String newProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String newProductId: newProductIds){
			userContext.getChecker().checkIdOfNewProduct(newProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeNewProductList(UxsUserContext userContext, String platformId, 
			String newProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNewProductList(userContext, platformId,  newProductIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveNewProductList(platform, newProductIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
				deleteRelationListInGraph(userContext, platform.getNewProductList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNewProduct(UxsUserContext userContext, String platformId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeNewProduct(UxsUserContext userContext, String platformId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNewProduct(userContext,platformId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeNewProduct( newProduct );		
			platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
			deleteRelationInGraph(userContext, newProduct);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNewProduct(UxsUserContext userContext, String platformId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyNewProductFrom(UxsUserContext userContext, String platformId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNewProduct(userContext,platformId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			newProduct.updateLastUpdateTime(userContext.now());
			
			platform.copyNewProductFrom( newProduct );		
			platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, (NewProduct)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNewProduct(UxsUserContext userContext, String platformId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		

		if(NewProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfNewProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateNewProduct(UxsUserContext userContext, String platformId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNewProduct(userContext, platformId, newProductId, newProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNewProductList().searchNewProductListWith(NewProduct.ID_PROPERTY, "eq", newProductId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeNewProduct( newProduct );	
			//make changes to AcceleraterAccount.
			NewProduct newProductIndex = createIndexedNewProduct(newProductId, newProductVersion);
		
			NewProduct newProduct = platform.findTheNewProduct(newProductIndex);
			if(newProduct == null){
				throw new PlatformManagerException(newProduct+" is NOT FOUND" );
			}
			
			newProduct.changeProperty(property, newValueExpr);
			newProduct.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withNewProductList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEditorPickProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfEditorPickProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfEditorPickProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfEditorPickProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfEditorPickProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfEditorPickProduct(catalogId);
		
		userContext.getChecker().checkProfileIdOfEditorPickProduct(profileId);
		
		userContext.getChecker().checkRemarkOfEditorPickProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addEditorPickProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEditorPickProduct(userContext,platformId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, profileId, remark,tokensExpr);
		
		EditorPickProduct editorPickProduct = createEditorPickProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, profileId, remark);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addEditorPickProduct( editorPickProduct );		
			platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, editorPickProduct);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEditorPickProductProperties(UxsUserContext userContext, String platformId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfEditorPickProduct(id);
		
		userContext.getChecker().checkNameOfEditorPickProduct( name);
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct( productCoverImage);
		userContext.getChecker().checkOriginOfEditorPickProduct( origin);
		userContext.getChecker().checkRemarkOfEditorPickProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateEditorPickProductProperties(UxsUserContext userContext, String platformId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEditorPickProductProperties(userContext,platformId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEditorPickProductListList()
				.searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getEditorPickProductList().isEmpty()){
			throw new PlatformManagerException("EditorPickProduct is NOT FOUND with id: '"+id+"'");
		}
		
		EditorPickProduct item = platformToUpdate.getEditorPickProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingEditorPickProduct(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withEditorPickProductList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EditorPickProduct createEditorPickProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark) throws Exception{

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		
		
		editorPickProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		editorPickProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		editorPickProduct.setBrand(brand);		
		editorPickProduct.setProductCoverImage(productCoverImage);		
		editorPickProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		editorPickProduct.setCatalog(catalog);		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		editorPickProduct.setProfile(profile);		
		editorPickProduct.setRemark(remark);		
		editorPickProduct.setLastUpdateTime(userContext.now());
	
		
		return editorPickProduct;
	
		
	}
	
	protected EditorPickProduct createIndexedEditorPickProduct(String id, int version){

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		editorPickProduct.setId(id);
		editorPickProduct.setVersion(version);
		return editorPickProduct;			
		
	}
	
	protected void checkParamsForRemovingEditorPickProductList(UxsUserContext userContext, String platformId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String editorPickProductId: editorPickProductIds){
			userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeEditorPickProductList(UxsUserContext userContext, String platformId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEditorPickProductList(userContext, platformId,  editorPickProductIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveEditorPickProductList(platform, editorPickProductIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
				deleteRelationListInGraph(userContext, platform.getEditorPickProductList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEditorPickProduct(UxsUserContext userContext, String platformId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeEditorPickProduct(UxsUserContext userContext, String platformId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEditorPickProduct(userContext,platformId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeEditorPickProduct( editorPickProduct );		
			platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
			deleteRelationInGraph(userContext, editorPickProduct);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEditorPickProduct(UxsUserContext userContext, String platformId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyEditorPickProductFrom(UxsUserContext userContext, String platformId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEditorPickProduct(userContext,platformId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			editorPickProduct.updateLastUpdateTime(userContext.now());
			
			platform.copyEditorPickProductFrom( editorPickProduct );		
			platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, (EditorPickProduct)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEditorPickProduct(UxsUserContext userContext, String platformId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		

		if(EditorPickProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEditorPickProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateEditorPickProduct(UxsUserContext userContext, String platformId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEditorPickProduct(userContext, platformId, editorPickProductId, editorPickProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEditorPickProductList().searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "eq", editorPickProductId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeEditorPickProduct( editorPickProduct );	
			//make changes to AcceleraterAccount.
			EditorPickProduct editorPickProductIndex = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		
			EditorPickProduct editorPickProduct = platform.findTheEditorPickProduct(editorPickProductIndex);
			if(editorPickProduct == null){
				throw new PlatformManagerException(editorPickProduct+" is NOT FOUND" );
			}
			
			editorPickProduct.changeProperty(property, newValueExpr);
			editorPickProduct.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withEditorPickProductList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTopRatedProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfTopRatedProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfTopRatedProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfTopRatedProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfTopRatedProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfTopRatedProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfTopRatedProduct(remark);
		
		userContext.getChecker().checkProfileIdOfTopRatedProduct(profileId);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addTopRatedProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTopRatedProduct(userContext,platformId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, profileId,tokensExpr);
		
		TopRatedProduct topRatedProduct = createTopRatedProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, profileId);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addTopRatedProduct( topRatedProduct );		
			platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, topRatedProduct);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTopRatedProductProperties(UxsUserContext userContext, String platformId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTopRatedProduct(id);
		
		userContext.getChecker().checkNameOfTopRatedProduct( name);
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct( productCoverImage);
		userContext.getChecker().checkOriginOfTopRatedProduct( origin);
		userContext.getChecker().checkRemarkOfTopRatedProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateTopRatedProductProperties(UxsUserContext userContext, String platformId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTopRatedProductProperties(userContext,platformId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTopRatedProductListList()
				.searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getTopRatedProductList().isEmpty()){
			throw new PlatformManagerException("TopRatedProduct is NOT FOUND with id: '"+id+"'");
		}
		
		TopRatedProduct item = platformToUpdate.getTopRatedProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingTopRatedProduct(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withTopRatedProductList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TopRatedProduct createTopRatedProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId) throws Exception{

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		
		
		topRatedProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		topRatedProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		topRatedProduct.setBrand(brand);		
		topRatedProduct.setProductCoverImage(productCoverImage);		
		topRatedProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		topRatedProduct.setCatalog(catalog);		
		topRatedProduct.setRemark(remark);		
		topRatedProduct.setLastUpdateTime(userContext.now());		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		topRatedProduct.setProfile(profile);
	
		
		return topRatedProduct;
	
		
	}
	
	protected TopRatedProduct createIndexedTopRatedProduct(String id, int version){

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		topRatedProduct.setId(id);
		topRatedProduct.setVersion(version);
		return topRatedProduct;			
		
	}
	
	protected void checkParamsForRemovingTopRatedProductList(UxsUserContext userContext, String platformId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String topRatedProductId: topRatedProductIds){
			userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeTopRatedProductList(UxsUserContext userContext, String platformId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTopRatedProductList(userContext, platformId,  topRatedProductIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTopRatedProductList(platform, topRatedProductIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
				deleteRelationListInGraph(userContext, platform.getTopRatedProductList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTopRatedProduct(UxsUserContext userContext, String platformId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeTopRatedProduct(UxsUserContext userContext, String platformId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTopRatedProduct(userContext,platformId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeTopRatedProduct( topRatedProduct );		
			platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
			deleteRelationInGraph(userContext, topRatedProduct);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTopRatedProduct(UxsUserContext userContext, String platformId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyTopRatedProductFrom(UxsUserContext userContext, String platformId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTopRatedProduct(userContext,platformId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			topRatedProduct.updateLastUpdateTime(userContext.now());
			
			platform.copyTopRatedProductFrom( topRatedProduct );		
			platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, (TopRatedProduct)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTopRatedProduct(UxsUserContext userContext, String platformId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		

		if(TopRatedProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTopRatedProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateTopRatedProduct(UxsUserContext userContext, String platformId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTopRatedProduct(userContext, platformId, topRatedProductId, topRatedProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTopRatedProductList().searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "eq", topRatedProductId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeTopRatedProduct( topRatedProduct );	
			//make changes to AcceleraterAccount.
			TopRatedProduct topRatedProductIndex = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		
			TopRatedProduct topRatedProduct = platform.findTheTopRatedProduct(topRatedProductIndex);
			if(topRatedProduct == null){
				throw new PlatformManagerException(topRatedProduct+" is NOT FOUND" );
			}
			
			topRatedProduct.changeProperty(property, newValueExpr);
			topRatedProduct.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withTopRatedProductList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRecommandProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfRecommandProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfRecommandProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfRecommandProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfRecommandProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfRecommandProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfRecommandProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfRecommandProduct(remark);
		
		userContext.getChecker().checkProfileIdOfRecommandProduct(profileId);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addRecommandProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRecommandProduct(userContext,platformId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, profileId,tokensExpr);
		
		RecommandProduct recommandProduct = createRecommandProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, profileId);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addRecommandProduct( recommandProduct );		
			platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, recommandProduct);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRecommandProductProperties(UxsUserContext userContext, String platformId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfRecommandProduct(id);
		
		userContext.getChecker().checkNameOfRecommandProduct( name);
		userContext.getChecker().checkProductCoverImageOfRecommandProduct( productCoverImage);
		userContext.getChecker().checkOriginOfRecommandProduct( origin);
		userContext.getChecker().checkRemarkOfRecommandProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateRecommandProductProperties(UxsUserContext userContext, String platformId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRecommandProductProperties(userContext,platformId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRecommandProductListList()
				.searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getRecommandProductList().isEmpty()){
			throw new PlatformManagerException("RecommandProduct is NOT FOUND with id: '"+id+"'");
		}
		
		RecommandProduct item = platformToUpdate.getRecommandProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingRecommandProduct(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withRecommandProductList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RecommandProduct createRecommandProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId) throws Exception{

		RecommandProduct recommandProduct = new RecommandProduct();
		
		
		recommandProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		recommandProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		recommandProduct.setBrand(brand);		
		recommandProduct.setProductCoverImage(productCoverImage);		
		recommandProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		recommandProduct.setCatalog(catalog);		
		recommandProduct.setRemark(remark);		
		recommandProduct.setLastUpdateTime(userContext.now());		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		recommandProduct.setProfile(profile);
	
		
		return recommandProduct;
	
		
	}
	
	protected RecommandProduct createIndexedRecommandProduct(String id, int version){

		RecommandProduct recommandProduct = new RecommandProduct();
		recommandProduct.setId(id);
		recommandProduct.setVersion(version);
		return recommandProduct;			
		
	}
	
	protected void checkParamsForRemovingRecommandProductList(UxsUserContext userContext, String platformId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String recommandProductId: recommandProductIds){
			userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeRecommandProductList(UxsUserContext userContext, String platformId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRecommandProductList(userContext, platformId,  recommandProductIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveRecommandProductList(platform, recommandProductIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
				deleteRelationListInGraph(userContext, platform.getRecommandProductList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRecommandProduct(UxsUserContext userContext, String platformId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeRecommandProduct(UxsUserContext userContext, String platformId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRecommandProduct(userContext,platformId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeRecommandProduct( recommandProduct );		
			platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
			deleteRelationInGraph(userContext, recommandProduct);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRecommandProduct(UxsUserContext userContext, String platformId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyRecommandProductFrom(UxsUserContext userContext, String platformId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRecommandProduct(userContext,platformId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			recommandProduct.updateLastUpdateTime(userContext.now());
			
			platform.copyRecommandProductFrom( recommandProduct );		
			platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, (RecommandProduct)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRecommandProduct(UxsUserContext userContext, String platformId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		

		if(RecommandProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfRecommandProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateRecommandProduct(UxsUserContext userContext, String platformId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRecommandProduct(userContext, platformId, recommandProductId, recommandProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRecommandProductList().searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "eq", recommandProductId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeRecommandProduct( recommandProduct );	
			//make changes to AcceleraterAccount.
			RecommandProduct recommandProductIndex = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		
			RecommandProduct recommandProduct = platform.findTheRecommandProduct(recommandProductIndex);
			if(recommandProduct == null){
				throw new PlatformManagerException(recommandProduct+" is NOT FOUND" );
			}
			
			recommandProduct.changeProperty(property, newValueExpr);
			recommandProduct.updateLastUpdateTime(userContext.now());
			platform = savePlatform(userContext, platform, tokens().withRecommandProductList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UxsUserContext userContext, Platform newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


