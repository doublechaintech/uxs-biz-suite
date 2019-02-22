
package com.doublechaintech.uxs.editorpickproduct;

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







public class EditorPickProductManagerImpl extends CustomUxsCheckerManager implements EditorPickProductManager {
	
	private static final String SERVICE_TYPE = "EditorPickProduct";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EditorPickProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EditorPickProductManagerException(message);

	}
	
	

 	protected EditorPickProduct saveEditorPickProduct(UxsUserContext userContext, EditorPickProduct editorPickProduct, String [] tokensExpr) throws Exception{	
 		//return getEditorPickProductDAO().save(editorPickProduct, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEditorPickProduct(userContext, editorPickProduct, tokens);
 	}
 	
 	protected EditorPickProduct saveEditorPickProductDetail(UxsUserContext userContext, EditorPickProduct editorPickProduct) throws Exception{	

 		
 		return saveEditorPickProduct(userContext, editorPickProduct, allTokens());
 	}
 	
 	public EditorPickProduct loadEditorPickProduct(UxsUserContext userContext, String editorPickProductId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().throwExceptionIfHasErrors( EditorPickProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EditorPickProduct editorPickProduct = loadEditorPickProduct( userContext, editorPickProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,editorPickProduct, tokens);
 	}
 	
 	
 	 public EditorPickProduct searchEditorPickProduct(UxsUserContext userContext, String editorPickProductId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().throwExceptionIfHasErrors( EditorPickProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EditorPickProduct editorPickProduct = loadEditorPickProduct( userContext, editorPickProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,editorPickProduct, tokens);
 	}
 	
 	

 	protected EditorPickProduct present(UxsUserContext userContext, EditorPickProduct editorPickProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,editorPickProduct,tokens);
		
		
		EditorPickProduct  editorPickProductToPresent = userContext.getDAOGroup().getEditorPickProductDAO().present(editorPickProduct, tokens);
		
		List<BaseEntity> entityListToNaming = editorPickProductToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEditorPickProductDAO().alias(entityListToNaming);
		
		return  editorPickProductToPresent;
		
		
	}
 
 	
 	
 	public EditorPickProduct loadEditorPickProductDetail(UxsUserContext userContext, String editorPickProductId) throws Exception{	
 		EditorPickProduct editorPickProduct = loadEditorPickProduct( userContext, editorPickProductId, allTokens());
 		return present(userContext,editorPickProduct, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String editorPickProductId) throws Exception{	
 		EditorPickProduct editorPickProduct = loadEditorPickProduct( userContext, editorPickProductId, viewTokens());
 		return present(userContext,editorPickProduct, allTokens());
		
 	}
 	protected EditorPickProduct saveEditorPickProduct(UxsUserContext userContext, EditorPickProduct editorPickProduct, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEditorPickProductDAO().save(editorPickProduct, tokens);
 	}
 	protected EditorPickProduct loadEditorPickProduct(UxsUserContext userContext, String editorPickProductId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().throwExceptionIfHasErrors( EditorPickProductManagerException.class);

 
 		return userContext.getDAOGroup().getEditorPickProductDAO().load(editorPickProductId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, EditorPickProduct editorPickProduct, Map<String, Object> tokens){
		super.addActions(userContext, editorPickProduct, tokens);
		
		addAction(userContext, editorPickProduct, tokens,"@create","createEditorPickProduct","createEditorPickProduct/","main","primary");
		addAction(userContext, editorPickProduct, tokens,"@update","updateEditorPickProduct","updateEditorPickProduct/"+editorPickProduct.getId()+"/","main","primary");
		addAction(userContext, editorPickProduct, tokens,"@copy","cloneEditorPickProduct","cloneEditorPickProduct/"+editorPickProduct.getId()+"/","main","primary");
		
		addAction(userContext, editorPickProduct, tokens,"editor_pick_product.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+editorPickProduct.getId()+"/","main","primary");
		addAction(userContext, editorPickProduct, tokens,"editor_pick_product.transfer_to_brand","transferToAnotherBrand","transferToAnotherBrand/"+editorPickProduct.getId()+"/","main","primary");
		addAction(userContext, editorPickProduct, tokens,"editor_pick_product.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+editorPickProduct.getId()+"/","main","primary");
		addAction(userContext, editorPickProduct, tokens,"editor_pick_product.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+editorPickProduct.getId()+"/","main","primary");
		addAction(userContext, editorPickProduct, tokens,"editor_pick_product.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+editorPickProduct.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, EditorPickProduct editorPickProduct, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EditorPickProduct createEditorPickProduct(UxsUserContext userContext,String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfEditorPickProduct(name);
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct(productCoverImage);
		userContext.getChecker().checkOriginOfEditorPickProduct(origin);
		userContext.getChecker().checkRemarkOfEditorPickProduct(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(EditorPickProductManagerException.class);


		EditorPickProduct editorPickProduct=createNewEditorPickProduct();	

		editorPickProduct.setName(name);
			
		LevelNCategory parentCategory = loadLevelNCategory(userContext, parentCategoryId,emptyOptions());
		editorPickProduct.setParentCategory(parentCategory);
		
		
			
		Brand brand = loadBrand(userContext, brandId,emptyOptions());
		editorPickProduct.setBrand(brand);
		
		
		editorPickProduct.setProductCoverImage(productCoverImage);
		editorPickProduct.setOrigin(origin);
			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		editorPickProduct.setCatalog(catalog);
		
		
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		editorPickProduct.setProfile(profile);
		
		
		editorPickProduct.setRemark(remark);
		editorPickProduct.setLastUpdateTime(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		editorPickProduct.setPlatform(platform);
		
		

		editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, emptyOptions());
		
		onNewInstanceCreated(userContext, editorPickProduct);
		return editorPickProduct;

		
	}
	protected EditorPickProduct createNewEditorPickProduct() 
	{
		
		return new EditorPickProduct();		
	}
	
	protected void checkParamsForUpdatingEditorPickProduct(UxsUserContext userContext,String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct( editorPickProductVersion);
		

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

		
	
		userContext.getChecker().throwExceptionIfHasErrors(EditorPickProductManagerException.class);
	
		
	}
	
	
	
	public EditorPickProduct clone(UxsUserContext userContext, String fromEditorPickProductId) throws Exception{
		
		return userContext.getDAOGroup().getEditorPickProductDAO().clone(fromEditorPickProductId, this.allTokens());
	}
	
	public EditorPickProduct internalSaveEditorPickProduct(UxsUserContext userContext, EditorPickProduct editorPickProduct) throws Exception 
	{
		return internalSaveEditorPickProduct(userContext, editorPickProduct, allTokens());

	}
	public EditorPickProduct internalSaveEditorPickProduct(UxsUserContext userContext, EditorPickProduct editorPickProduct, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEditorPickProduct(userContext, editorPickProductId, editorPickProductVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(editorPickProduct){ 
			//will be good when the editorPickProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EditorPickProduct.
			
			
			editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, options);
			return editorPickProduct;
			
		}

	}
	
	public EditorPickProduct updateEditorPickProduct(UxsUserContext userContext,String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEditorPickProduct(userContext, editorPickProductId, editorPickProductVersion, property, newValueExpr, tokensExpr);
		
		
		
		EditorPickProduct editorPickProduct = loadEditorPickProduct(userContext, editorPickProductId, allTokens());
		if(editorPickProduct.getVersion() != editorPickProductVersion){
			String message = "The target version("+editorPickProduct.getVersion()+") is not equals to version("+editorPickProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(editorPickProduct){ 
			//will be good when the editorPickProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EditorPickProduct.
			editorPickProduct.updateLastUpdateTime(userContext.now());
			editorPickProduct.changeProperty(property, newValueExpr);
			editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, tokens().done());
			return present(userContext,editorPickProduct, mergedAllTokens(tokensExpr));
			//return saveEditorPickProduct(userContext, editorPickProduct, tokens().done());
		}

	}
	
	public EditorPickProduct updateEditorPickProductProperty(UxsUserContext userContext,String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEditorPickProduct(userContext, editorPickProductId, editorPickProductVersion, property, newValueExpr, tokensExpr);
		
		EditorPickProduct editorPickProduct = loadEditorPickProduct(userContext, editorPickProductId, allTokens());
		if(editorPickProduct.getVersion() != editorPickProductVersion){
			String message = "The target version("+editorPickProduct.getVersion()+") is not equals to version("+editorPickProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(editorPickProduct){ 
			//will be good when the editorPickProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EditorPickProduct.
			
			editorPickProduct.changeProperty(property, newValueExpr);
			editorPickProduct.updateLastUpdateTime(userContext.now());
			editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, tokens().done());
			return present(userContext,editorPickProduct, mergedAllTokens(tokensExpr));
			//return saveEditorPickProduct(userContext, editorPickProduct, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EditorPickProductTokens tokens(){
		return EditorPickProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EditorPickProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EditorPickProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(UxsUserContext userContext, String editorPickProductId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
 		userContext.getChecker().checkIdOfLevelNCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EditorPickProductManagerException.class);
 		
 	}
 	public EditorPickProduct transferToAnotherParentCategory(UxsUserContext userContext, String editorPickProductId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, editorPickProductId,anotherParentCategoryId);
 
		EditorPickProduct editorPickProduct = loadEditorPickProduct(userContext, editorPickProductId, allTokens());	
		synchronized(editorPickProduct){
			//will be good when the editorPickProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelNCategory parentCategory = loadLevelNCategory(userContext, anotherParentCategoryId, emptyOptions());		
			editorPickProduct.updateParentCategory(parentCategory);		
			editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, emptyOptions());
			
			return present(userContext,editorPickProduct, allTokens());
			
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
		SmartList<LevelNCategory> candidateList = userContext.getDAOGroup().getLevelNCategoryDAO().requestCandidateLevelNCategoryForEditorPickProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBrand(UxsUserContext userContext, String editorPickProductId, String anotherBrandId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
 		userContext.getChecker().checkIdOfBrand(anotherBrandId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EditorPickProductManagerException.class);
 		
 	}
 	public EditorPickProduct transferToAnotherBrand(UxsUserContext userContext, String editorPickProductId, String anotherBrandId) throws Exception
 	{
 		checkParamsForTransferingAnotherBrand(userContext, editorPickProductId,anotherBrandId);
 
		EditorPickProduct editorPickProduct = loadEditorPickProduct(userContext, editorPickProductId, allTokens());	
		synchronized(editorPickProduct){
			//will be good when the editorPickProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Brand brand = loadBrand(userContext, anotherBrandId, emptyOptions());		
			editorPickProduct.updateBrand(brand);		
			editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, emptyOptions());
			
			return present(userContext,editorPickProduct, allTokens());
			
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
		SmartList<Brand> candidateList = userContext.getDAOGroup().getBrandDAO().requestCandidateBrandForEditorPickProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCatalog(UxsUserContext userContext, String editorPickProductId, String anotherCatalogId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
 		userContext.getChecker().checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EditorPickProductManagerException.class);
 		
 	}
 	public EditorPickProduct transferToAnotherCatalog(UxsUserContext userContext, String editorPickProductId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, editorPickProductId,anotherCatalogId);
 
		EditorPickProduct editorPickProduct = loadEditorPickProduct(userContext, editorPickProductId, allTokens());	
		synchronized(editorPickProduct){
			//will be good when the editorPickProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			editorPickProduct.updateCatalog(catalog);		
			editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, emptyOptions());
			
			return present(userContext,editorPickProduct, allTokens());
			
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
		SmartList<Catalog> candidateList = userContext.getDAOGroup().getCatalogDAO().requestCandidateCatalogForEditorPickProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProfile(UxsUserContext userContext, String editorPickProductId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EditorPickProductManagerException.class);
 		
 	}
 	public EditorPickProduct transferToAnotherProfile(UxsUserContext userContext, String editorPickProductId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, editorPickProductId,anotherProfileId);
 
		EditorPickProduct editorPickProduct = loadEditorPickProduct(userContext, editorPickProductId, allTokens());	
		synchronized(editorPickProduct){
			//will be good when the editorPickProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			editorPickProduct.updateProfile(profile);		
			editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, emptyOptions());
			
			return present(userContext,editorPickProduct, allTokens());
			
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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForEditorPickProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(UxsUserContext userContext, String editorPickProductId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EditorPickProductManagerException.class);
 		
 	}
 	public EditorPickProduct transferToAnotherPlatform(UxsUserContext userContext, String editorPickProductId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, editorPickProductId,anotherPlatformId);
 
		EditorPickProduct editorPickProduct = loadEditorPickProduct(userContext, editorPickProductId, allTokens());	
		synchronized(editorPickProduct){
			//will be good when the editorPickProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			editorPickProduct.updatePlatform(platform);		
			editorPickProduct = saveEditorPickProduct(userContext, editorPickProduct, emptyOptions());
			
			return present(userContext,editorPickProduct, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForEditorPickProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(UxsUserContext userContext, String editorPickProductId, int editorPickProductVersion) throws Exception {
		//deleteInternal(userContext, editorPickProductId, editorPickProductVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String editorPickProductId, int editorPickProductVersion) throws Exception{
			
		userContext.getDAOGroup().getEditorPickProductDAO().delete(editorPickProductId, editorPickProductVersion);
	}
	
	public EditorPickProduct forgetByAll(UxsUserContext userContext, String editorPickProductId, int editorPickProductVersion) throws Exception {
		return forgetByAllInternal(userContext, editorPickProductId, editorPickProductVersion);		
	}
	protected EditorPickProduct forgetByAllInternal(UxsUserContext userContext,
			String editorPickProductId, int editorPickProductVersion) throws Exception{
			
		return userContext.getDAOGroup().getEditorPickProductDAO().disconnectFromAll(editorPickProductId, editorPickProductVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EditorPickProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEditorPickProductDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, EditorPickProduct newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


