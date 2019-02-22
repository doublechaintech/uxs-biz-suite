
package com.doublechaintech.uxs.recommandproduct;

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







public class RecommandProductManagerImpl extends CustomUxsCheckerManager implements RecommandProductManager {
	
	private static final String SERVICE_TYPE = "RecommandProduct";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RecommandProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RecommandProductManagerException(message);

	}
	
	

 	protected RecommandProduct saveRecommandProduct(UxsUserContext userContext, RecommandProduct recommandProduct, String [] tokensExpr) throws Exception{	
 		//return getRecommandProductDAO().save(recommandProduct, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRecommandProduct(userContext, recommandProduct, tokens);
 	}
 	
 	protected RecommandProduct saveRecommandProductDetail(UxsUserContext userContext, RecommandProduct recommandProduct) throws Exception{	

 		
 		return saveRecommandProduct(userContext, recommandProduct, allTokens());
 	}
 	
 	public RecommandProduct loadRecommandProduct(UxsUserContext userContext, String recommandProductId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().throwExceptionIfHasErrors( RecommandProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RecommandProduct recommandProduct = loadRecommandProduct( userContext, recommandProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,recommandProduct, tokens);
 	}
 	
 	
 	 public RecommandProduct searchRecommandProduct(UxsUserContext userContext, String recommandProductId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().throwExceptionIfHasErrors( RecommandProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RecommandProduct recommandProduct = loadRecommandProduct( userContext, recommandProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,recommandProduct, tokens);
 	}
 	
 	

 	protected RecommandProduct present(UxsUserContext userContext, RecommandProduct recommandProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,recommandProduct,tokens);
		
		
		RecommandProduct  recommandProductToPresent = userContext.getDAOGroup().getRecommandProductDAO().present(recommandProduct, tokens);
		
		List<BaseEntity> entityListToNaming = recommandProductToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRecommandProductDAO().alias(entityListToNaming);
		
		return  recommandProductToPresent;
		
		
	}
 
 	
 	
 	public RecommandProduct loadRecommandProductDetail(UxsUserContext userContext, String recommandProductId) throws Exception{	
 		RecommandProduct recommandProduct = loadRecommandProduct( userContext, recommandProductId, allTokens());
 		return present(userContext,recommandProduct, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String recommandProductId) throws Exception{	
 		RecommandProduct recommandProduct = loadRecommandProduct( userContext, recommandProductId, viewTokens());
 		return present(userContext,recommandProduct, allTokens());
		
 	}
 	protected RecommandProduct saveRecommandProduct(UxsUserContext userContext, RecommandProduct recommandProduct, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRecommandProductDAO().save(recommandProduct, tokens);
 	}
 	protected RecommandProduct loadRecommandProduct(UxsUserContext userContext, String recommandProductId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().throwExceptionIfHasErrors( RecommandProductManagerException.class);

 
 		return userContext.getDAOGroup().getRecommandProductDAO().load(recommandProductId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, RecommandProduct recommandProduct, Map<String, Object> tokens){
		super.addActions(userContext, recommandProduct, tokens);
		
		addAction(userContext, recommandProduct, tokens,"@create","createRecommandProduct","createRecommandProduct/","main","primary");
		addAction(userContext, recommandProduct, tokens,"@update","updateRecommandProduct","updateRecommandProduct/"+recommandProduct.getId()+"/","main","primary");
		addAction(userContext, recommandProduct, tokens,"@copy","cloneRecommandProduct","cloneRecommandProduct/"+recommandProduct.getId()+"/","main","primary");
		
		addAction(userContext, recommandProduct, tokens,"recommand_product.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+recommandProduct.getId()+"/","main","primary");
		addAction(userContext, recommandProduct, tokens,"recommand_product.transfer_to_brand","transferToAnotherBrand","transferToAnotherBrand/"+recommandProduct.getId()+"/","main","primary");
		addAction(userContext, recommandProduct, tokens,"recommand_product.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+recommandProduct.getId()+"/","main","primary");
		addAction(userContext, recommandProduct, tokens,"recommand_product.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+recommandProduct.getId()+"/","main","primary");
		addAction(userContext, recommandProduct, tokens,"recommand_product.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+recommandProduct.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, RecommandProduct recommandProduct, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RecommandProduct createRecommandProduct(UxsUserContext userContext,String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfRecommandProduct(name);
		userContext.getChecker().checkProductCoverImageOfRecommandProduct(productCoverImage);
		userContext.getChecker().checkOriginOfRecommandProduct(origin);
		userContext.getChecker().checkRemarkOfRecommandProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(RecommandProductManagerException.class);


		RecommandProduct recommandProduct=createNewRecommandProduct();	

		recommandProduct.setName(name);
			
		LevelNCategory parentCategory = loadLevelNCategory(userContext, parentCategoryId,emptyOptions());
		recommandProduct.setParentCategory(parentCategory);
		
		
			
		Brand brand = loadBrand(userContext, brandId,emptyOptions());
		recommandProduct.setBrand(brand);
		
		
		recommandProduct.setProductCoverImage(productCoverImage);
		recommandProduct.setOrigin(origin);
			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		recommandProduct.setCatalog(catalog);
		
		
		recommandProduct.setRemark(remark);
		recommandProduct.setLastUpdateTime(userContext.now());
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		recommandProduct.setProfile(profile);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		recommandProduct.setPlatform(platform);
		
		

		recommandProduct = saveRecommandProduct(userContext, recommandProduct, emptyOptions());
		
		onNewInstanceCreated(userContext, recommandProduct);
		return recommandProduct;

		
	}
	protected RecommandProduct createNewRecommandProduct() 
	{
		
		return new RecommandProduct();		
	}
	
	protected void checkParamsForUpdatingRecommandProduct(UxsUserContext userContext,String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct( recommandProductVersion);
		

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

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(RecommandProductManagerException.class);
	
		
	}
	
	
	
	public RecommandProduct clone(UxsUserContext userContext, String fromRecommandProductId) throws Exception{
		
		return userContext.getDAOGroup().getRecommandProductDAO().clone(fromRecommandProductId, this.allTokens());
	}
	
	public RecommandProduct internalSaveRecommandProduct(UxsUserContext userContext, RecommandProduct recommandProduct) throws Exception 
	{
		return internalSaveRecommandProduct(userContext, recommandProduct, allTokens());

	}
	public RecommandProduct internalSaveRecommandProduct(UxsUserContext userContext, RecommandProduct recommandProduct, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRecommandProduct(userContext, recommandProductId, recommandProductVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(recommandProduct){ 
			//will be good when the recommandProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RecommandProduct.
			
			
			recommandProduct = saveRecommandProduct(userContext, recommandProduct, options);
			return recommandProduct;
			
		}

	}
	
	public RecommandProduct updateRecommandProduct(UxsUserContext userContext,String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRecommandProduct(userContext, recommandProductId, recommandProductVersion, property, newValueExpr, tokensExpr);
		
		
		
		RecommandProduct recommandProduct = loadRecommandProduct(userContext, recommandProductId, allTokens());
		if(recommandProduct.getVersion() != recommandProductVersion){
			String message = "The target version("+recommandProduct.getVersion()+") is not equals to version("+recommandProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(recommandProduct){ 
			//will be good when the recommandProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RecommandProduct.
			recommandProduct.updateLastUpdateTime(userContext.now());
			recommandProduct.changeProperty(property, newValueExpr);
			recommandProduct = saveRecommandProduct(userContext, recommandProduct, tokens().done());
			return present(userContext,recommandProduct, mergedAllTokens(tokensExpr));
			//return saveRecommandProduct(userContext, recommandProduct, tokens().done());
		}

	}
	
	public RecommandProduct updateRecommandProductProperty(UxsUserContext userContext,String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRecommandProduct(userContext, recommandProductId, recommandProductVersion, property, newValueExpr, tokensExpr);
		
		RecommandProduct recommandProduct = loadRecommandProduct(userContext, recommandProductId, allTokens());
		if(recommandProduct.getVersion() != recommandProductVersion){
			String message = "The target version("+recommandProduct.getVersion()+") is not equals to version("+recommandProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(recommandProduct){ 
			//will be good when the recommandProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RecommandProduct.
			
			recommandProduct.changeProperty(property, newValueExpr);
			recommandProduct.updateLastUpdateTime(userContext.now());
			recommandProduct = saveRecommandProduct(userContext, recommandProduct, tokens().done());
			return present(userContext,recommandProduct, mergedAllTokens(tokensExpr));
			//return saveRecommandProduct(userContext, recommandProduct, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RecommandProductTokens tokens(){
		return RecommandProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RecommandProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RecommandProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(UxsUserContext userContext, String recommandProductId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
 		userContext.getChecker().checkIdOfLevelNCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RecommandProductManagerException.class);
 		
 	}
 	public RecommandProduct transferToAnotherParentCategory(UxsUserContext userContext, String recommandProductId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, recommandProductId,anotherParentCategoryId);
 
		RecommandProduct recommandProduct = loadRecommandProduct(userContext, recommandProductId, allTokens());	
		synchronized(recommandProduct){
			//will be good when the recommandProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelNCategory parentCategory = loadLevelNCategory(userContext, anotherParentCategoryId, emptyOptions());		
			recommandProduct.updateParentCategory(parentCategory);		
			recommandProduct = saveRecommandProduct(userContext, recommandProduct, emptyOptions());
			
			return present(userContext,recommandProduct, allTokens());
			
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
		SmartList<LevelNCategory> candidateList = userContext.getDAOGroup().getLevelNCategoryDAO().requestCandidateLevelNCategoryForRecommandProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBrand(UxsUserContext userContext, String recommandProductId, String anotherBrandId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
 		userContext.getChecker().checkIdOfBrand(anotherBrandId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RecommandProductManagerException.class);
 		
 	}
 	public RecommandProduct transferToAnotherBrand(UxsUserContext userContext, String recommandProductId, String anotherBrandId) throws Exception
 	{
 		checkParamsForTransferingAnotherBrand(userContext, recommandProductId,anotherBrandId);
 
		RecommandProduct recommandProduct = loadRecommandProduct(userContext, recommandProductId, allTokens());	
		synchronized(recommandProduct){
			//will be good when the recommandProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Brand brand = loadBrand(userContext, anotherBrandId, emptyOptions());		
			recommandProduct.updateBrand(brand);		
			recommandProduct = saveRecommandProduct(userContext, recommandProduct, emptyOptions());
			
			return present(userContext,recommandProduct, allTokens());
			
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
		SmartList<Brand> candidateList = userContext.getDAOGroup().getBrandDAO().requestCandidateBrandForRecommandProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCatalog(UxsUserContext userContext, String recommandProductId, String anotherCatalogId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
 		userContext.getChecker().checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RecommandProductManagerException.class);
 		
 	}
 	public RecommandProduct transferToAnotherCatalog(UxsUserContext userContext, String recommandProductId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, recommandProductId,anotherCatalogId);
 
		RecommandProduct recommandProduct = loadRecommandProduct(userContext, recommandProductId, allTokens());	
		synchronized(recommandProduct){
			//will be good when the recommandProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			recommandProduct.updateCatalog(catalog);		
			recommandProduct = saveRecommandProduct(userContext, recommandProduct, emptyOptions());
			
			return present(userContext,recommandProduct, allTokens());
			
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
		SmartList<Catalog> candidateList = userContext.getDAOGroup().getCatalogDAO().requestCandidateCatalogForRecommandProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProfile(UxsUserContext userContext, String recommandProductId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RecommandProductManagerException.class);
 		
 	}
 	public RecommandProduct transferToAnotherProfile(UxsUserContext userContext, String recommandProductId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, recommandProductId,anotherProfileId);
 
		RecommandProduct recommandProduct = loadRecommandProduct(userContext, recommandProductId, allTokens());	
		synchronized(recommandProduct){
			//will be good when the recommandProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			recommandProduct.updateProfile(profile);		
			recommandProduct = saveRecommandProduct(userContext, recommandProduct, emptyOptions());
			
			return present(userContext,recommandProduct, allTokens());
			
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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForRecommandProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(UxsUserContext userContext, String recommandProductId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RecommandProductManagerException.class);
 		
 	}
 	public RecommandProduct transferToAnotherPlatform(UxsUserContext userContext, String recommandProductId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, recommandProductId,anotherPlatformId);
 
		RecommandProduct recommandProduct = loadRecommandProduct(userContext, recommandProductId, allTokens());	
		synchronized(recommandProduct){
			//will be good when the recommandProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			recommandProduct.updatePlatform(platform);		
			recommandProduct = saveRecommandProduct(userContext, recommandProduct, emptyOptions());
			
			return present(userContext,recommandProduct, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForRecommandProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(UxsUserContext userContext, String recommandProductId, int recommandProductVersion) throws Exception {
		//deleteInternal(userContext, recommandProductId, recommandProductVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String recommandProductId, int recommandProductVersion) throws Exception{
			
		userContext.getDAOGroup().getRecommandProductDAO().delete(recommandProductId, recommandProductVersion);
	}
	
	public RecommandProduct forgetByAll(UxsUserContext userContext, String recommandProductId, int recommandProductVersion) throws Exception {
		return forgetByAllInternal(userContext, recommandProductId, recommandProductVersion);		
	}
	protected RecommandProduct forgetByAllInternal(UxsUserContext userContext,
			String recommandProductId, int recommandProductVersion) throws Exception{
			
		return userContext.getDAOGroup().getRecommandProductDAO().disconnectFromAll(recommandProductId, recommandProductVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RecommandProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRecommandProductDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, RecommandProduct newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


