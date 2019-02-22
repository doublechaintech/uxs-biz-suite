
package com.doublechaintech.uxs.topratedproduct;

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
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;

import com.doublechaintech.uxs.brand.CandidateBrand;
import com.doublechaintech.uxs.catalog.CandidateCatalog;
import com.doublechaintech.uxs.levelncategory.CandidateLevelNCategory;
import com.doublechaintech.uxs.profile.CandidateProfile;
import com.doublechaintech.uxs.platform.CandidatePlatform;







public class TopRatedProductManagerImpl extends CustomUxsCheckerManager implements TopRatedProductManager {
	
	private static final String SERVICE_TYPE = "TopRatedProduct";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TopRatedProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TopRatedProductManagerException(message);

	}
	
	

 	protected TopRatedProduct saveTopRatedProduct(UxsUserContext userContext, TopRatedProduct topRatedProduct, String [] tokensExpr) throws Exception{	
 		//return getTopRatedProductDAO().save(topRatedProduct, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTopRatedProduct(userContext, topRatedProduct, tokens);
 	}
 	
 	protected TopRatedProduct saveTopRatedProductDetail(UxsUserContext userContext, TopRatedProduct topRatedProduct) throws Exception{	

 		
 		return saveTopRatedProduct(userContext, topRatedProduct, allTokens());
 	}
 	
 	public TopRatedProduct loadTopRatedProduct(UxsUserContext userContext, String topRatedProductId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().throwExceptionIfHasErrors( TopRatedProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TopRatedProduct topRatedProduct = loadTopRatedProduct( userContext, topRatedProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,topRatedProduct, tokens);
 	}
 	
 	
 	 public TopRatedProduct searchTopRatedProduct(UxsUserContext userContext, String topRatedProductId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().throwExceptionIfHasErrors( TopRatedProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TopRatedProduct topRatedProduct = loadTopRatedProduct( userContext, topRatedProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,topRatedProduct, tokens);
 	}
 	
 	

 	protected TopRatedProduct present(UxsUserContext userContext, TopRatedProduct topRatedProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,topRatedProduct,tokens);
		
		
		TopRatedProduct  topRatedProductToPresent = userContext.getDAOGroup().getTopRatedProductDAO().present(topRatedProduct, tokens);
		
		List<BaseEntity> entityListToNaming = topRatedProductToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTopRatedProductDAO().alias(entityListToNaming);
		
		return  topRatedProductToPresent;
		
		
	}
 
 	
 	
 	public TopRatedProduct loadTopRatedProductDetail(UxsUserContext userContext, String topRatedProductId) throws Exception{	
 		TopRatedProduct topRatedProduct = loadTopRatedProduct( userContext, topRatedProductId, allTokens());
 		return present(userContext,topRatedProduct, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String topRatedProductId) throws Exception{	
 		TopRatedProduct topRatedProduct = loadTopRatedProduct( userContext, topRatedProductId, viewTokens());
 		return present(userContext,topRatedProduct, allTokens());
		
 	}
 	protected TopRatedProduct saveTopRatedProduct(UxsUserContext userContext, TopRatedProduct topRatedProduct, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTopRatedProductDAO().save(topRatedProduct, tokens);
 	}
 	protected TopRatedProduct loadTopRatedProduct(UxsUserContext userContext, String topRatedProductId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().throwExceptionIfHasErrors( TopRatedProductManagerException.class);

 
 		return userContext.getDAOGroup().getTopRatedProductDAO().load(topRatedProductId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, TopRatedProduct topRatedProduct, Map<String, Object> tokens){
		super.addActions(userContext, topRatedProduct, tokens);
		
		addAction(userContext, topRatedProduct, tokens,"@create","createTopRatedProduct","createTopRatedProduct/","main","primary");
		addAction(userContext, topRatedProduct, tokens,"@update","updateTopRatedProduct","updateTopRatedProduct/"+topRatedProduct.getId()+"/","main","primary");
		addAction(userContext, topRatedProduct, tokens,"@copy","cloneTopRatedProduct","cloneTopRatedProduct/"+topRatedProduct.getId()+"/","main","primary");
		
		addAction(userContext, topRatedProduct, tokens,"top_rated_product.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+topRatedProduct.getId()+"/","main","primary");
		addAction(userContext, topRatedProduct, tokens,"top_rated_product.transfer_to_brand","transferToAnotherBrand","transferToAnotherBrand/"+topRatedProduct.getId()+"/","main","primary");
		addAction(userContext, topRatedProduct, tokens,"top_rated_product.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+topRatedProduct.getId()+"/","main","primary");
		addAction(userContext, topRatedProduct, tokens,"top_rated_product.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+topRatedProduct.getId()+"/","main","primary");
		addAction(userContext, topRatedProduct, tokens,"top_rated_product.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+topRatedProduct.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, TopRatedProduct topRatedProduct, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TopRatedProduct createTopRatedProduct(UxsUserContext userContext,String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTopRatedProduct(name);
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct(productCoverImage);
		userContext.getChecker().checkOriginOfTopRatedProduct(origin);
		userContext.getChecker().checkRemarkOfTopRatedProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(TopRatedProductManagerException.class);


		TopRatedProduct topRatedProduct=createNewTopRatedProduct();	

		topRatedProduct.setName(name);
			
		LevelNCategory parentCategory = loadLevelNCategory(userContext, parentCategoryId,emptyOptions());
		topRatedProduct.setParentCategory(parentCategory);
		
		
			
		Brand brand = loadBrand(userContext, brandId,emptyOptions());
		topRatedProduct.setBrand(brand);
		
		
		topRatedProduct.setProductCoverImage(productCoverImage);
		topRatedProduct.setOrigin(origin);
			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		topRatedProduct.setCatalog(catalog);
		
		
		topRatedProduct.setRemark(remark);
		topRatedProduct.setLastUpdateTime(userContext.now());
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		topRatedProduct.setProfile(profile);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		topRatedProduct.setPlatform(platform);
		
		

		topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, emptyOptions());
		
		onNewInstanceCreated(userContext, topRatedProduct);
		return topRatedProduct;

		
	}
	protected TopRatedProduct createNewTopRatedProduct() 
	{
		
		return new TopRatedProduct();		
	}
	
	protected void checkParamsForUpdatingTopRatedProduct(UxsUserContext userContext,String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct( topRatedProductVersion);
		

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

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TopRatedProductManagerException.class);
	
		
	}
	
	
	
	public TopRatedProduct clone(UxsUserContext userContext, String fromTopRatedProductId) throws Exception{
		
		return userContext.getDAOGroup().getTopRatedProductDAO().clone(fromTopRatedProductId, this.allTokens());
	}
	
	public TopRatedProduct internalSaveTopRatedProduct(UxsUserContext userContext, TopRatedProduct topRatedProduct) throws Exception 
	{
		return internalSaveTopRatedProduct(userContext, topRatedProduct, allTokens());

	}
	public TopRatedProduct internalSaveTopRatedProduct(UxsUserContext userContext, TopRatedProduct topRatedProduct, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTopRatedProduct(userContext, topRatedProductId, topRatedProductVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(topRatedProduct){ 
			//will be good when the topRatedProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TopRatedProduct.
			
			
			topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, options);
			return topRatedProduct;
			
		}

	}
	
	public TopRatedProduct updateTopRatedProduct(UxsUserContext userContext,String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTopRatedProduct(userContext, topRatedProductId, topRatedProductVersion, property, newValueExpr, tokensExpr);
		
		
		
		TopRatedProduct topRatedProduct = loadTopRatedProduct(userContext, topRatedProductId, allTokens());
		if(topRatedProduct.getVersion() != topRatedProductVersion){
			String message = "The target version("+topRatedProduct.getVersion()+") is not equals to version("+topRatedProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(topRatedProduct){ 
			//will be good when the topRatedProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TopRatedProduct.
			topRatedProduct.updateLastUpdateTime(userContext.now());
			topRatedProduct.changeProperty(property, newValueExpr);
			topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, tokens().done());
			return present(userContext,topRatedProduct, mergedAllTokens(tokensExpr));
			//return saveTopRatedProduct(userContext, topRatedProduct, tokens().done());
		}

	}
	
	public TopRatedProduct updateTopRatedProductProperty(UxsUserContext userContext,String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTopRatedProduct(userContext, topRatedProductId, topRatedProductVersion, property, newValueExpr, tokensExpr);
		
		TopRatedProduct topRatedProduct = loadTopRatedProduct(userContext, topRatedProductId, allTokens());
		if(topRatedProduct.getVersion() != topRatedProductVersion){
			String message = "The target version("+topRatedProduct.getVersion()+") is not equals to version("+topRatedProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(topRatedProduct){ 
			//will be good when the topRatedProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TopRatedProduct.
			
			topRatedProduct.changeProperty(property, newValueExpr);
			topRatedProduct.updateLastUpdateTime(userContext.now());
			topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, tokens().done());
			return present(userContext,topRatedProduct, mergedAllTokens(tokensExpr));
			//return saveTopRatedProduct(userContext, topRatedProduct, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TopRatedProductTokens tokens(){
		return TopRatedProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TopRatedProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TopRatedProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(UxsUserContext userContext, String topRatedProductId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
 		userContext.getChecker().checkIdOfLevelNCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TopRatedProductManagerException.class);
 		
 	}
 	public TopRatedProduct transferToAnotherParentCategory(UxsUserContext userContext, String topRatedProductId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, topRatedProductId,anotherParentCategoryId);
 
		TopRatedProduct topRatedProduct = loadTopRatedProduct(userContext, topRatedProductId, allTokens());	
		synchronized(topRatedProduct){
			//will be good when the topRatedProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelNCategory parentCategory = loadLevelNCategory(userContext, anotherParentCategoryId, emptyOptions());		
			topRatedProduct.updateParentCategory(parentCategory);		
			topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, emptyOptions());
			
			return present(userContext,topRatedProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelNCategory requestCandidateParentCategory(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelNCategory result = new CandidateLevelNCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("parentCategory");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelNCategory> candidateList = userContext.getDAOGroup().getLevelNCategoryDAO().requestCandidateLevelNCategoryForTopRatedProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBrand(UxsUserContext userContext, String topRatedProductId, String anotherBrandId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
 		userContext.getChecker().checkIdOfBrand(anotherBrandId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TopRatedProductManagerException.class);
 		
 	}
 	public TopRatedProduct transferToAnotherBrand(UxsUserContext userContext, String topRatedProductId, String anotherBrandId) throws Exception
 	{
 		checkParamsForTransferingAnotherBrand(userContext, topRatedProductId,anotherBrandId);
 
		TopRatedProduct topRatedProduct = loadTopRatedProduct(userContext, topRatedProductId, allTokens());	
		synchronized(topRatedProduct){
			//will be good when the topRatedProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Brand brand = loadBrand(userContext, anotherBrandId, emptyOptions());		
			topRatedProduct.updateBrand(brand);		
			topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, emptyOptions());
			
			return present(userContext,topRatedProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateBrand requestCandidateBrand(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateBrand result = new CandidateBrand();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("brandName");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Brand> candidateList = userContext.getDAOGroup().getBrandDAO().requestCandidateBrandForTopRatedProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCatalog(UxsUserContext userContext, String topRatedProductId, String anotherCatalogId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
 		userContext.getChecker().checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TopRatedProductManagerException.class);
 		
 	}
 	public TopRatedProduct transferToAnotherCatalog(UxsUserContext userContext, String topRatedProductId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, topRatedProductId,anotherCatalogId);
 
		TopRatedProduct topRatedProduct = loadTopRatedProduct(userContext, topRatedProductId, allTokens());	
		synchronized(topRatedProduct){
			//will be good when the topRatedProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			topRatedProduct.updateCatalog(catalog);		
			topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, emptyOptions());
			
			return present(userContext,topRatedProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateCatalog requestCandidateCatalog(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCatalog result = new CandidateCatalog();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Catalog> candidateList = userContext.getDAOGroup().getCatalogDAO().requestCandidateCatalogForTopRatedProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProfile(UxsUserContext userContext, String topRatedProductId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TopRatedProductManagerException.class);
 		
 	}
 	public TopRatedProduct transferToAnotherProfile(UxsUserContext userContext, String topRatedProductId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, topRatedProductId,anotherProfileId);
 
		TopRatedProduct topRatedProduct = loadTopRatedProduct(userContext, topRatedProductId, allTokens());	
		synchronized(topRatedProduct){
			//will be good when the topRatedProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			topRatedProduct.updateProfile(profile);		
			topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, emptyOptions());
			
			return present(userContext,topRatedProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidateProfile(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfile result = new CandidateProfile();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForTopRatedProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(UxsUserContext userContext, String topRatedProductId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TopRatedProductManagerException.class);
 		
 	}
 	public TopRatedProduct transferToAnotherPlatform(UxsUserContext userContext, String topRatedProductId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, topRatedProductId,anotherPlatformId);
 
		TopRatedProduct topRatedProduct = loadTopRatedProduct(userContext, topRatedProductId, allTokens());	
		synchronized(topRatedProduct){
			//will be good when the topRatedProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			topRatedProduct.updatePlatform(platform);		
			topRatedProduct = saveTopRatedProduct(userContext, topRatedProduct, emptyOptions());
			
			return present(userContext,topRatedProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForTopRatedProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Catalog loadCatalog(UxsUserContext userContext, String newCatalogId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getCatalogDAO().load(newCatalogId, options);
 	}
 	
 	
 	
	
	 	
 	protected LevelNCategory loadLevelNCategory(UxsUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelNCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	 	
 	protected Profile loadProfile(UxsUserContext userContext, String newProfileId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newProfileId, options);
 	}
 	
 	
 	
	
	 	
 	protected Brand loadBrand(UxsUserContext userContext, String newBrandId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getBrandDAO().load(newBrandId, options);
 	}
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(UxsUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String topRatedProductId, int topRatedProductVersion) throws Exception {
		//deleteInternal(userContext, topRatedProductId, topRatedProductVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String topRatedProductId, int topRatedProductVersion) throws Exception{
			
		userContext.getDAOGroup().getTopRatedProductDAO().delete(topRatedProductId, topRatedProductVersion);
	}
	
	public TopRatedProduct forgetByAll(UxsUserContext userContext, String topRatedProductId, int topRatedProductVersion) throws Exception {
		return forgetByAllInternal(userContext, topRatedProductId, topRatedProductVersion);		
	}
	protected TopRatedProduct forgetByAllInternal(UxsUserContext userContext,
			String topRatedProductId, int topRatedProductVersion) throws Exception{
			
		return userContext.getDAOGroup().getTopRatedProductDAO().disconnectFromAll(topRatedProductId, topRatedProductVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TopRatedProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTopRatedProductDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, TopRatedProduct newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


