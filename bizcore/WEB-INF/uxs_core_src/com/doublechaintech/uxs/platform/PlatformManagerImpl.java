
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

import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.banner.Banner;
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
		.sortProductListWith("id","desc")
		.sortBannerListWith("id","desc")
		.sortProfileListWith("id","desc")
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


	
	
	
	
	

	protected void checkParamsForAddingProduct(UxsUserContext userContext, String platformId, String name, BigDecimal avarageScore,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkAvarageScoreOfProduct(avarageScore);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addProduct(UxsUserContext userContext, String platformId, String name, BigDecimal avarageScore, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,platformId,name, avarageScore,tokensExpr);
		
		Product product = createProduct(userContext,name, avarageScore);
		
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
	protected void checkParamsForUpdatingProductProperties(UxsUserContext userContext, String platformId,String id,String name,BigDecimal avarageScore,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkAvarageScoreOfProduct( avarageScore);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateProductProperties(UxsUserContext userContext, String platformId, String id,String name,BigDecimal avarageScore, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,platformId,id,name,avarageScore,tokensExpr);

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
		item.updateAvarageScore( avarageScore );

		
		//checkParamsForAddingProduct(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withProductList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(UxsUserContext userContext, String name, BigDecimal avarageScore) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		product.setAvarageScore(avarageScore);
	
		
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
		
		if(Product.AVARAGE_SCORE_PROPERTY.equals(property)){
			userContext.getChecker().checkAvarageScoreOfProduct(parseBigDecimal(newValueExpr));
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
	



	public void onNewInstanceCreated(UxsUserContext userContext, Platform newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


