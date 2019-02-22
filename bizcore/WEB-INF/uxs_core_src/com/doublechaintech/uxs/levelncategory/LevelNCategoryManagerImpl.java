
package com.doublechaintech.uxs.levelncategory;

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

import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;

import com.doublechaintech.uxs.leveltwocategory.CandidateLevelTwoCategory;

import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;






public class LevelNCategoryManagerImpl extends CustomUxsCheckerManager implements LevelNCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelNCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelNCategoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelNCategoryManagerException(message);

	}
	
	

 	protected LevelNCategory saveLevelNCategory(UxsUserContext userContext, LevelNCategory levelNCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelNCategoryDAO().save(levelNCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelNCategory(userContext, levelNCategory, tokens);
 	}
 	
 	protected LevelNCategory saveLevelNCategoryDetail(UxsUserContext userContext, LevelNCategory levelNCategory) throws Exception{	

 		
 		return saveLevelNCategory(userContext, levelNCategory, allTokens());
 	}
 	
 	public LevelNCategory loadLevelNCategory(UxsUserContext userContext, String levelNCategoryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelNCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelNCategory levelNCategory = loadLevelNCategory( userContext, levelNCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelNCategory, tokens);
 	}
 	
 	
 	 public LevelNCategory searchLevelNCategory(UxsUserContext userContext, String levelNCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelNCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelNCategory levelNCategory = loadLevelNCategory( userContext, levelNCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelNCategory, tokens);
 	}
 	
 	

 	protected LevelNCategory present(UxsUserContext userContext, LevelNCategory levelNCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelNCategory,tokens);
		
		
		LevelNCategory  levelNCategoryToPresent = userContext.getDAOGroup().getLevelNCategoryDAO().present(levelNCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelNCategoryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelNCategoryDAO().alias(entityListToNaming);
		
		return  levelNCategoryToPresent;
		
		
	}
 
 	
 	
 	public LevelNCategory loadLevelNCategoryDetail(UxsUserContext userContext, String levelNCategoryId) throws Exception{	
 		LevelNCategory levelNCategory = loadLevelNCategory( userContext, levelNCategoryId, allTokens());
 		return present(userContext,levelNCategory, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String levelNCategoryId) throws Exception{	
 		LevelNCategory levelNCategory = loadLevelNCategory( userContext, levelNCategoryId, viewTokens());
 		return present(userContext,levelNCategory, allTokens());
		
 	}
 	protected LevelNCategory saveLevelNCategory(UxsUserContext userContext, LevelNCategory levelNCategory, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelNCategoryDAO().save(levelNCategory, tokens);
 	}
 	protected LevelNCategory loadLevelNCategory(UxsUserContext userContext, String levelNCategoryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelNCategoryManagerException.class);

 
 		return userContext.getDAOGroup().getLevelNCategoryDAO().load(levelNCategoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, LevelNCategory levelNCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelNCategory, tokens);
		
		addAction(userContext, levelNCategory, tokens,"@create","createLevelNCategory","createLevelNCategory/","main","primary");
		addAction(userContext, levelNCategory, tokens,"@update","updateLevelNCategory","updateLevelNCategory/"+levelNCategory.getId()+"/","main","primary");
		addAction(userContext, levelNCategory, tokens,"@copy","cloneLevelNCategory","cloneLevelNCategory/"+levelNCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelNCategory, tokens,"level_n_category.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+levelNCategory.getId()+"/","main","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.addProduct","addProduct","addProduct/"+levelNCategory.getId()+"/","productList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.removeProduct","removeProduct","removeProduct/"+levelNCategory.getId()+"/","productList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.updateProduct","updateProduct","updateProduct/"+levelNCategory.getId()+"/","productList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.copyProductFrom","copyProductFrom","copyProductFrom/"+levelNCategory.getId()+"/","productList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.addNewProduct","addNewProduct","addNewProduct/"+levelNCategory.getId()+"/","newProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.removeNewProduct","removeNewProduct","removeNewProduct/"+levelNCategory.getId()+"/","newProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.updateNewProduct","updateNewProduct","updateNewProduct/"+levelNCategory.getId()+"/","newProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.copyNewProductFrom","copyNewProductFrom","copyNewProductFrom/"+levelNCategory.getId()+"/","newProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.addEditorPickProduct","addEditorPickProduct","addEditorPickProduct/"+levelNCategory.getId()+"/","editorPickProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.removeEditorPickProduct","removeEditorPickProduct","removeEditorPickProduct/"+levelNCategory.getId()+"/","editorPickProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.updateEditorPickProduct","updateEditorPickProduct","updateEditorPickProduct/"+levelNCategory.getId()+"/","editorPickProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.copyEditorPickProductFrom","copyEditorPickProductFrom","copyEditorPickProductFrom/"+levelNCategory.getId()+"/","editorPickProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.addTopRatedProduct","addTopRatedProduct","addTopRatedProduct/"+levelNCategory.getId()+"/","topRatedProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.removeTopRatedProduct","removeTopRatedProduct","removeTopRatedProduct/"+levelNCategory.getId()+"/","topRatedProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.updateTopRatedProduct","updateTopRatedProduct","updateTopRatedProduct/"+levelNCategory.getId()+"/","topRatedProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.copyTopRatedProductFrom","copyTopRatedProductFrom","copyTopRatedProductFrom/"+levelNCategory.getId()+"/","topRatedProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.addRecommandProduct","addRecommandProduct","addRecommandProduct/"+levelNCategory.getId()+"/","recommandProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.removeRecommandProduct","removeRecommandProduct","removeRecommandProduct/"+levelNCategory.getId()+"/","recommandProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.updateRecommandProduct","updateRecommandProduct","updateRecommandProduct/"+levelNCategory.getId()+"/","recommandProductList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.copyRecommandProductFrom","copyRecommandProductFrom","copyRecommandProductFrom/"+levelNCategory.getId()+"/","recommandProductList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, LevelNCategory levelNCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelNCategory createLevelNCategory(UxsUserContext userContext,String parentCategoryId, String name) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelNCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);


		LevelNCategory levelNCategory=createNewLevelNCategory();	

			
		LevelTwoCategory parentCategory = loadLevelTwoCategory(userContext, parentCategoryId,emptyOptions());
		levelNCategory.setParentCategory(parentCategory);
		
		
		levelNCategory.setName(name);

		levelNCategory = saveLevelNCategory(userContext, levelNCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelNCategory);
		return levelNCategory;

		
	}
	protected LevelNCategory createNewLevelNCategory() 
	{
		
		return new LevelNCategory();		
	}
	
	protected void checkParamsForUpdatingLevelNCategory(UxsUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkVersionOfLevelNCategory( levelNCategoryVersion);
		
		

		
		if(LevelNCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelNCategory(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
		
	}
	
	
	
	public LevelNCategory clone(UxsUserContext userContext, String fromLevelNCategoryId) throws Exception{
		
		return userContext.getDAOGroup().getLevelNCategoryDAO().clone(fromLevelNCategoryId, this.allTokens());
	}
	
	public LevelNCategory internalSaveLevelNCategory(UxsUserContext userContext, LevelNCategory levelNCategory) throws Exception 
	{
		return internalSaveLevelNCategory(userContext, levelNCategory, allTokens());

	}
	public LevelNCategory internalSaveLevelNCategory(UxsUserContext userContext, LevelNCategory levelNCategory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelNCategory(userContext, levelNCategoryId, levelNCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelNCategory){ 
			//will be good when the levelNCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelNCategory.
			
			
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, options);
			return levelNCategory;
			
		}

	}
	
	public LevelNCategory updateLevelNCategory(UxsUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelNCategory(userContext, levelNCategoryId, levelNCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		if(levelNCategory.getVersion() != levelNCategoryVersion){
			String message = "The target version("+levelNCategory.getVersion()+") is not equals to version("+levelNCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelNCategory){ 
			//will be good when the levelNCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelNCategory.
			
			levelNCategory.changeProperty(property, newValueExpr);
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			//return saveLevelNCategory(userContext, levelNCategory, tokens().done());
		}

	}
	
	public LevelNCategory updateLevelNCategoryProperty(UxsUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelNCategory(userContext, levelNCategoryId, levelNCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		if(levelNCategory.getVersion() != levelNCategoryVersion){
			String message = "The target version("+levelNCategory.getVersion()+") is not equals to version("+levelNCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelNCategory){ 
			//will be good when the levelNCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelNCategory.
			
			levelNCategory.changeProperty(property, newValueExpr);
			
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			//return saveLevelNCategory(userContext, levelNCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelNCategoryTokens tokens(){
		return LevelNCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelNCategoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProductListWith("id","desc")
		.sortNewProductListWith("id","desc")
		.sortEditorPickProductListWith("id","desc")
		.sortTopRatedProductListWith("id","desc")
		.sortRecommandProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelNCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(UxsUserContext userContext, String levelNCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
 		userContext.getChecker().checkIdOfLevelTwoCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
 		
 	}
 	public LevelNCategory transferToAnotherParentCategory(UxsUserContext userContext, String levelNCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, levelNCategoryId,anotherParentCategoryId);
 
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());	
		synchronized(levelNCategory){
			//will be good when the levelNCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelTwoCategory parentCategory = loadLevelTwoCategory(userContext, anotherParentCategoryId, emptyOptions());		
			levelNCategory.updateParentCategory(parentCategory);		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, emptyOptions());
			
			return present(userContext,levelNCategory, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelTwoCategory requestCandidateParentCategory(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelTwoCategory result = new CandidateLevelTwoCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("parentCategory");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelTwoCategory> candidateList = userContext.getDAOGroup().getLevelTwoCategoryDAO().requestCandidateLevelTwoCategoryForLevelNCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelTwoCategory loadLevelTwoCategory(UxsUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelTwoCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String levelNCategoryId, int levelNCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelNCategoryId, levelNCategoryVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String levelNCategoryId, int levelNCategoryVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelNCategoryDAO().delete(levelNCategoryId, levelNCategoryVersion);
	}
	
	public LevelNCategory forgetByAll(UxsUserContext userContext, String levelNCategoryId, int levelNCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelNCategoryId, levelNCategoryVersion);		
	}
	protected LevelNCategory forgetByAllInternal(UxsUserContext userContext,
			String levelNCategoryId, int levelNCategoryVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelNCategoryDAO().disconnectFromAll(levelNCategoryId, levelNCategoryVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelNCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelNCategoryDAO().deleteAll();
	}


	//disconnect LevelNCategory with brand in Product
	protected LevelNCategory breakWithProductByBrand(UxsUserContext userContext, String levelNCategoryId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveProductListWithBrand(levelNCategory, brandId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with catalog in Product
	protected LevelNCategory breakWithProductByCatalog(UxsUserContext userContext, String levelNCategoryId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveProductListWithCatalog(levelNCategory, catalogId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with platform in Product
	protected LevelNCategory breakWithProductByPlatform(UxsUserContext userContext, String levelNCategoryId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveProductListWithPlatform(levelNCategory, platformId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with brand in NewProduct
	protected LevelNCategory breakWithNewProductByBrand(UxsUserContext userContext, String levelNCategoryId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveNewProductListWithBrand(levelNCategory, brandId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with catalog in NewProduct
	protected LevelNCategory breakWithNewProductByCatalog(UxsUserContext userContext, String levelNCategoryId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveNewProductListWithCatalog(levelNCategory, catalogId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with profile in NewProduct
	protected LevelNCategory breakWithNewProductByProfile(UxsUserContext userContext, String levelNCategoryId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveNewProductListWithProfile(levelNCategory, profileId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with platform in NewProduct
	protected LevelNCategory breakWithNewProductByPlatform(UxsUserContext userContext, String levelNCategoryId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveNewProductListWithPlatform(levelNCategory, platformId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with brand in EditorPickProduct
	protected LevelNCategory breakWithEditorPickProductByBrand(UxsUserContext userContext, String levelNCategoryId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveEditorPickProductListWithBrand(levelNCategory, brandId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with catalog in EditorPickProduct
	protected LevelNCategory breakWithEditorPickProductByCatalog(UxsUserContext userContext, String levelNCategoryId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveEditorPickProductListWithCatalog(levelNCategory, catalogId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with profile in EditorPickProduct
	protected LevelNCategory breakWithEditorPickProductByProfile(UxsUserContext userContext, String levelNCategoryId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveEditorPickProductListWithProfile(levelNCategory, profileId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with platform in EditorPickProduct
	protected LevelNCategory breakWithEditorPickProductByPlatform(UxsUserContext userContext, String levelNCategoryId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveEditorPickProductListWithPlatform(levelNCategory, platformId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with brand in TopRatedProduct
	protected LevelNCategory breakWithTopRatedProductByBrand(UxsUserContext userContext, String levelNCategoryId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveTopRatedProductListWithBrand(levelNCategory, brandId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with catalog in TopRatedProduct
	protected LevelNCategory breakWithTopRatedProductByCatalog(UxsUserContext userContext, String levelNCategoryId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveTopRatedProductListWithCatalog(levelNCategory, catalogId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with profile in TopRatedProduct
	protected LevelNCategory breakWithTopRatedProductByProfile(UxsUserContext userContext, String levelNCategoryId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveTopRatedProductListWithProfile(levelNCategory, profileId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with platform in TopRatedProduct
	protected LevelNCategory breakWithTopRatedProductByPlatform(UxsUserContext userContext, String levelNCategoryId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveTopRatedProductListWithPlatform(levelNCategory, platformId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with brand in RecommandProduct
	protected LevelNCategory breakWithRecommandProductByBrand(UxsUserContext userContext, String levelNCategoryId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveRecommandProductListWithBrand(levelNCategory, brandId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with catalog in RecommandProduct
	protected LevelNCategory breakWithRecommandProductByCatalog(UxsUserContext userContext, String levelNCategoryId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveRecommandProductListWithCatalog(levelNCategory, catalogId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with profile in RecommandProduct
	protected LevelNCategory breakWithRecommandProductByProfile(UxsUserContext userContext, String levelNCategoryId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveRecommandProductListWithProfile(levelNCategory, profileId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with platform in RecommandProduct
	protected LevelNCategory breakWithRecommandProductByPlatform(UxsUserContext userContext, String levelNCategoryId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveRecommandProductListWithPlatform(levelNCategory, platformId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
				return levelNCategory;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkBrandIdOfProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);

	
	}
	public  LevelNCategory addProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,levelNCategoryId,name, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		Product product = createProduct(userContext,name, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.addProduct( product );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(UxsUserContext userContext, String levelNCategoryId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkProductCoverImageOfProduct( productCoverImage);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory updateProductProperties(UxsUserContext userContext, String levelNCategoryId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,levelNCategoryId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		LevelNCategory levelNCategoryToUpdate = loadLevelNCategory(userContext, levelNCategoryId, options);
		
		if(levelNCategoryToUpdate.getProductList().isEmpty()){
			throw new LevelNCategoryManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = levelNCategoryToUpdate.getProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingProduct(userContext,levelNCategoryId,name, code, used,tokensExpr);
		LevelNCategory levelNCategory = saveLevelNCategory(userContext, levelNCategoryToUpdate, tokens().withProductList().done());
		synchronized(levelNCategory){ 
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(UxsUserContext userContext, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
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
		Platform  platform = new Platform();
		platform.setId(platformId);		
		product.setPlatform(platform);
	
		
		return product;
	
		
	}
	
	protected Product createIndexedProduct(String id, int version){

		Product product = new Product();
		product.setId(id);
		product.setVersion(version);
		return product;			
		
	}
	
	protected void checkParamsForRemovingProductList(UxsUserContext userContext, String levelNCategoryId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory removeProductList(UxsUserContext userContext, String levelNCategoryId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, levelNCategoryId,  productIds, tokensExpr);
			
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
			synchronized(levelNCategory){ 
				//Will be good when the levelNCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveProductList(levelNCategory, productIds, allTokens());
				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, levelNCategory.getProductList());
				return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(UxsUserContext userContext, String levelNCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory removeProduct(UxsUserContext userContext, String levelNCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,levelNCategoryId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.removeProduct( product );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(UxsUserContext userContext, String levelNCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory copyProductFrom(UxsUserContext userContext, String levelNCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,levelNCategoryId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			product.updateLastUpdateTime(userContext.now());
			
			levelNCategory.copyProductFrom( product );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)levelNCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(UxsUserContext userContext, String levelNCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	
	public  LevelNCategory updateProduct(UxsUserContext userContext, String levelNCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, levelNCategoryId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, loadTokens);
		
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelNCategory.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = levelNCategory.findTheProduct(productIndex);
			if(product == null){
				throw new LevelNCategoryManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingNewProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);

		
		userContext.getChecker().checkNameOfNewProduct(name);
		
		userContext.getChecker().checkBrandIdOfNewProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfNewProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfNewProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfNewProduct(catalogId);
		
		userContext.getChecker().checkProfileIdOfNewProduct(profileId);
		
		userContext.getChecker().checkRemarkOfNewProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfNewProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);

	
	}
	public  LevelNCategory addNewProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNewProduct(userContext,levelNCategoryId,name, brandId, productCoverImage, origin, catalogId, profileId, remark, platformId,tokensExpr);
		
		NewProduct newProduct = createNewProduct(userContext,name, brandId, productCoverImage, origin, catalogId, profileId, remark, platformId);
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.addNewProduct( newProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, newProduct);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNewProductProperties(UxsUserContext userContext, String levelNCategoryId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkIdOfNewProduct(id);
		
		userContext.getChecker().checkNameOfNewProduct( name);
		userContext.getChecker().checkProductCoverImageOfNewProduct( productCoverImage);
		userContext.getChecker().checkOriginOfNewProduct( origin);
		userContext.getChecker().checkRemarkOfNewProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory updateNewProductProperties(UxsUserContext userContext, String levelNCategoryId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNewProductProperties(userContext,levelNCategoryId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNewProductListList()
				.searchNewProductListWith(NewProduct.ID_PROPERTY, "is", id).done();
		
		LevelNCategory levelNCategoryToUpdate = loadLevelNCategory(userContext, levelNCategoryId, options);
		
		if(levelNCategoryToUpdate.getNewProductList().isEmpty()){
			throw new LevelNCategoryManagerException("NewProduct is NOT FOUND with id: '"+id+"'");
		}
		
		NewProduct item = levelNCategoryToUpdate.getNewProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingNewProduct(userContext,levelNCategoryId,name, code, used,tokensExpr);
		LevelNCategory levelNCategory = saveLevelNCategory(userContext, levelNCategoryToUpdate, tokens().withNewProductList().done());
		synchronized(levelNCategory){ 
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected NewProduct createNewProduct(UxsUserContext userContext, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception{

		NewProduct newProduct = new NewProduct();
		
		
		newProduct.setName(name);		
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
		Platform  platform = new Platform();
		platform.setId(platformId);		
		newProduct.setPlatform(platform);
	
		
		return newProduct;
	
		
	}
	
	protected NewProduct createIndexedNewProduct(String id, int version){

		NewProduct newProduct = new NewProduct();
		newProduct.setId(id);
		newProduct.setVersion(version);
		return newProduct;			
		
	}
	
	protected void checkParamsForRemovingNewProductList(UxsUserContext userContext, String levelNCategoryId, 
			String newProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		for(String newProductId: newProductIds){
			userContext.getChecker().checkIdOfNewProduct(newProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory removeNewProductList(UxsUserContext userContext, String levelNCategoryId, 
			String newProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNewProductList(userContext, levelNCategoryId,  newProductIds, tokensExpr);
			
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
			synchronized(levelNCategory){ 
				//Will be good when the levelNCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveNewProductList(levelNCategory, newProductIds, allTokens());
				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
				deleteRelationListInGraph(userContext, levelNCategory.getNewProductList());
				return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNewProduct(UxsUserContext userContext, String levelNCategoryId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory removeNewProduct(UxsUserContext userContext, String levelNCategoryId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNewProduct(userContext,levelNCategoryId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.removeNewProduct( newProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
			deleteRelationInGraph(userContext, newProduct);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNewProduct(UxsUserContext userContext, String levelNCategoryId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory copyNewProductFrom(UxsUserContext userContext, String levelNCategoryId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNewProduct(userContext,levelNCategoryId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			newProduct.updateLastUpdateTime(userContext.now());
			
			levelNCategory.copyNewProductFrom( newProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, (NewProduct)levelNCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNewProduct(UxsUserContext userContext, String levelNCategoryId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	
	public  LevelNCategory updateNewProduct(UxsUserContext userContext, String levelNCategoryId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNewProduct(userContext, levelNCategoryId, newProductId, newProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNewProductList().searchNewProductListWith(NewProduct.ID_PROPERTY, "eq", newProductId).done();
		
		
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, loadTokens);
		
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelNCategory.removeNewProduct( newProduct );	
			//make changes to AcceleraterAccount.
			NewProduct newProductIndex = createIndexedNewProduct(newProductId, newProductVersion);
		
			NewProduct newProduct = levelNCategory.findTheNewProduct(newProductIndex);
			if(newProduct == null){
				throw new LevelNCategoryManagerException(newProduct+" is NOT FOUND" );
			}
			
			newProduct.changeProperty(property, newValueExpr);
			newProduct.updateLastUpdateTime(userContext.now());
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withNewProductList().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);

		
		userContext.getChecker().checkNameOfEditorPickProduct(name);
		
		userContext.getChecker().checkBrandIdOfEditorPickProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfEditorPickProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfEditorPickProduct(catalogId);
		
		userContext.getChecker().checkProfileIdOfEditorPickProduct(profileId);
		
		userContext.getChecker().checkRemarkOfEditorPickProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfEditorPickProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);

	
	}
	public  LevelNCategory addEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEditorPickProduct(userContext,levelNCategoryId,name, brandId, productCoverImage, origin, catalogId, profileId, remark, platformId,tokensExpr);
		
		EditorPickProduct editorPickProduct = createEditorPickProduct(userContext,name, brandId, productCoverImage, origin, catalogId, profileId, remark, platformId);
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.addEditorPickProduct( editorPickProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, editorPickProduct);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEditorPickProductProperties(UxsUserContext userContext, String levelNCategoryId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkIdOfEditorPickProduct(id);
		
		userContext.getChecker().checkNameOfEditorPickProduct( name);
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct( productCoverImage);
		userContext.getChecker().checkOriginOfEditorPickProduct( origin);
		userContext.getChecker().checkRemarkOfEditorPickProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory updateEditorPickProductProperties(UxsUserContext userContext, String levelNCategoryId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEditorPickProductProperties(userContext,levelNCategoryId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEditorPickProductListList()
				.searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "is", id).done();
		
		LevelNCategory levelNCategoryToUpdate = loadLevelNCategory(userContext, levelNCategoryId, options);
		
		if(levelNCategoryToUpdate.getEditorPickProductList().isEmpty()){
			throw new LevelNCategoryManagerException("EditorPickProduct is NOT FOUND with id: '"+id+"'");
		}
		
		EditorPickProduct item = levelNCategoryToUpdate.getEditorPickProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingEditorPickProduct(userContext,levelNCategoryId,name, code, used,tokensExpr);
		LevelNCategory levelNCategory = saveLevelNCategory(userContext, levelNCategoryToUpdate, tokens().withEditorPickProductList().done());
		synchronized(levelNCategory){ 
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EditorPickProduct createEditorPickProduct(UxsUserContext userContext, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception{

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		
		
		editorPickProduct.setName(name);		
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
		Platform  platform = new Platform();
		platform.setId(platformId);		
		editorPickProduct.setPlatform(platform);
	
		
		return editorPickProduct;
	
		
	}
	
	protected EditorPickProduct createIndexedEditorPickProduct(String id, int version){

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		editorPickProduct.setId(id);
		editorPickProduct.setVersion(version);
		return editorPickProduct;			
		
	}
	
	protected void checkParamsForRemovingEditorPickProductList(UxsUserContext userContext, String levelNCategoryId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		for(String editorPickProductId: editorPickProductIds){
			userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory removeEditorPickProductList(UxsUserContext userContext, String levelNCategoryId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEditorPickProductList(userContext, levelNCategoryId,  editorPickProductIds, tokensExpr);
			
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
			synchronized(levelNCategory){ 
				//Will be good when the levelNCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveEditorPickProductList(levelNCategory, editorPickProductIds, allTokens());
				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
				deleteRelationListInGraph(userContext, levelNCategory.getEditorPickProductList());
				return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory removeEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEditorPickProduct(userContext,levelNCategoryId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.removeEditorPickProduct( editorPickProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
			deleteRelationInGraph(userContext, editorPickProduct);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory copyEditorPickProductFrom(UxsUserContext userContext, String levelNCategoryId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEditorPickProduct(userContext,levelNCategoryId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			editorPickProduct.updateLastUpdateTime(userContext.now());
			
			levelNCategory.copyEditorPickProductFrom( editorPickProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, (EditorPickProduct)levelNCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	
	public  LevelNCategory updateEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEditorPickProduct(userContext, levelNCategoryId, editorPickProductId, editorPickProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEditorPickProductList().searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "eq", editorPickProductId).done();
		
		
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, loadTokens);
		
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelNCategory.removeEditorPickProduct( editorPickProduct );	
			//make changes to AcceleraterAccount.
			EditorPickProduct editorPickProductIndex = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		
			EditorPickProduct editorPickProduct = levelNCategory.findTheEditorPickProduct(editorPickProductIndex);
			if(editorPickProduct == null){
				throw new LevelNCategoryManagerException(editorPickProduct+" is NOT FOUND" );
			}
			
			editorPickProduct.changeProperty(property, newValueExpr);
			editorPickProduct.updateLastUpdateTime(userContext.now());
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withEditorPickProductList().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);

		
		userContext.getChecker().checkNameOfTopRatedProduct(name);
		
		userContext.getChecker().checkBrandIdOfTopRatedProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfTopRatedProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfTopRatedProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfTopRatedProduct(remark);
		
		userContext.getChecker().checkProfileIdOfTopRatedProduct(profileId);
		
		userContext.getChecker().checkPlatformIdOfTopRatedProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);

	
	}
	public  LevelNCategory addTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTopRatedProduct(userContext,levelNCategoryId,name, brandId, productCoverImage, origin, catalogId, remark, profileId, platformId,tokensExpr);
		
		TopRatedProduct topRatedProduct = createTopRatedProduct(userContext,name, brandId, productCoverImage, origin, catalogId, remark, profileId, platformId);
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.addTopRatedProduct( topRatedProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, topRatedProduct);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTopRatedProductProperties(UxsUserContext userContext, String levelNCategoryId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkIdOfTopRatedProduct(id);
		
		userContext.getChecker().checkNameOfTopRatedProduct( name);
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct( productCoverImage);
		userContext.getChecker().checkOriginOfTopRatedProduct( origin);
		userContext.getChecker().checkRemarkOfTopRatedProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory updateTopRatedProductProperties(UxsUserContext userContext, String levelNCategoryId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTopRatedProductProperties(userContext,levelNCategoryId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTopRatedProductListList()
				.searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "is", id).done();
		
		LevelNCategory levelNCategoryToUpdate = loadLevelNCategory(userContext, levelNCategoryId, options);
		
		if(levelNCategoryToUpdate.getTopRatedProductList().isEmpty()){
			throw new LevelNCategoryManagerException("TopRatedProduct is NOT FOUND with id: '"+id+"'");
		}
		
		TopRatedProduct item = levelNCategoryToUpdate.getTopRatedProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingTopRatedProduct(userContext,levelNCategoryId,name, code, used,tokensExpr);
		LevelNCategory levelNCategory = saveLevelNCategory(userContext, levelNCategoryToUpdate, tokens().withTopRatedProductList().done());
		synchronized(levelNCategory){ 
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TopRatedProduct createTopRatedProduct(UxsUserContext userContext, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception{

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		
		
		topRatedProduct.setName(name);		
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
		Platform  platform = new Platform();
		platform.setId(platformId);		
		topRatedProduct.setPlatform(platform);
	
		
		return topRatedProduct;
	
		
	}
	
	protected TopRatedProduct createIndexedTopRatedProduct(String id, int version){

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		topRatedProduct.setId(id);
		topRatedProduct.setVersion(version);
		return topRatedProduct;			
		
	}
	
	protected void checkParamsForRemovingTopRatedProductList(UxsUserContext userContext, String levelNCategoryId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		for(String topRatedProductId: topRatedProductIds){
			userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory removeTopRatedProductList(UxsUserContext userContext, String levelNCategoryId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTopRatedProductList(userContext, levelNCategoryId,  topRatedProductIds, tokensExpr);
			
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
			synchronized(levelNCategory){ 
				//Will be good when the levelNCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveTopRatedProductList(levelNCategory, topRatedProductIds, allTokens());
				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
				deleteRelationListInGraph(userContext, levelNCategory.getTopRatedProductList());
				return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory removeTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTopRatedProduct(userContext,levelNCategoryId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.removeTopRatedProduct( topRatedProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
			deleteRelationInGraph(userContext, topRatedProduct);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory copyTopRatedProductFrom(UxsUserContext userContext, String levelNCategoryId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTopRatedProduct(userContext,levelNCategoryId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			topRatedProduct.updateLastUpdateTime(userContext.now());
			
			levelNCategory.copyTopRatedProductFrom( topRatedProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, (TopRatedProduct)levelNCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	
	public  LevelNCategory updateTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTopRatedProduct(userContext, levelNCategoryId, topRatedProductId, topRatedProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTopRatedProductList().searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "eq", topRatedProductId).done();
		
		
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, loadTokens);
		
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelNCategory.removeTopRatedProduct( topRatedProduct );	
			//make changes to AcceleraterAccount.
			TopRatedProduct topRatedProductIndex = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		
			TopRatedProduct topRatedProduct = levelNCategory.findTheTopRatedProduct(topRatedProductIndex);
			if(topRatedProduct == null){
				throw new LevelNCategoryManagerException(topRatedProduct+" is NOT FOUND" );
			}
			
			topRatedProduct.changeProperty(property, newValueExpr);
			topRatedProduct.updateLastUpdateTime(userContext.now());
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withTopRatedProductList().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRecommandProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);

		
		userContext.getChecker().checkNameOfRecommandProduct(name);
		
		userContext.getChecker().checkBrandIdOfRecommandProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfRecommandProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfRecommandProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfRecommandProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfRecommandProduct(remark);
		
		userContext.getChecker().checkProfileIdOfRecommandProduct(profileId);
		
		userContext.getChecker().checkPlatformIdOfRecommandProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);

	
	}
	public  LevelNCategory addRecommandProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRecommandProduct(userContext,levelNCategoryId,name, brandId, productCoverImage, origin, catalogId, remark, profileId, platformId,tokensExpr);
		
		RecommandProduct recommandProduct = createRecommandProduct(userContext,name, brandId, productCoverImage, origin, catalogId, remark, profileId, platformId);
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.addRecommandProduct( recommandProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, recommandProduct);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRecommandProductProperties(UxsUserContext userContext, String levelNCategoryId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkIdOfRecommandProduct(id);
		
		userContext.getChecker().checkNameOfRecommandProduct( name);
		userContext.getChecker().checkProductCoverImageOfRecommandProduct( productCoverImage);
		userContext.getChecker().checkOriginOfRecommandProduct( origin);
		userContext.getChecker().checkRemarkOfRecommandProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory updateRecommandProductProperties(UxsUserContext userContext, String levelNCategoryId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRecommandProductProperties(userContext,levelNCategoryId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRecommandProductListList()
				.searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "is", id).done();
		
		LevelNCategory levelNCategoryToUpdate = loadLevelNCategory(userContext, levelNCategoryId, options);
		
		if(levelNCategoryToUpdate.getRecommandProductList().isEmpty()){
			throw new LevelNCategoryManagerException("RecommandProduct is NOT FOUND with id: '"+id+"'");
		}
		
		RecommandProduct item = levelNCategoryToUpdate.getRecommandProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingRecommandProduct(userContext,levelNCategoryId,name, code, used,tokensExpr);
		LevelNCategory levelNCategory = saveLevelNCategory(userContext, levelNCategoryToUpdate, tokens().withRecommandProductList().done());
		synchronized(levelNCategory){ 
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RecommandProduct createRecommandProduct(UxsUserContext userContext, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception{

		RecommandProduct recommandProduct = new RecommandProduct();
		
		
		recommandProduct.setName(name);		
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
		Platform  platform = new Platform();
		platform.setId(platformId);		
		recommandProduct.setPlatform(platform);
	
		
		return recommandProduct;
	
		
	}
	
	protected RecommandProduct createIndexedRecommandProduct(String id, int version){

		RecommandProduct recommandProduct = new RecommandProduct();
		recommandProduct.setId(id);
		recommandProduct.setVersion(version);
		return recommandProduct;			
		
	}
	
	protected void checkParamsForRemovingRecommandProductList(UxsUserContext userContext, String levelNCategoryId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		for(String recommandProductId: recommandProductIds){
			userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory removeRecommandProductList(UxsUserContext userContext, String levelNCategoryId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRecommandProductList(userContext, levelNCategoryId,  recommandProductIds, tokensExpr);
			
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
			synchronized(levelNCategory){ 
				//Will be good when the levelNCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveRecommandProductList(levelNCategory, recommandProductIds, allTokens());
				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
				deleteRelationListInGraph(userContext, levelNCategory.getRecommandProductList());
				return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRecommandProduct(UxsUserContext userContext, String levelNCategoryId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory removeRecommandProduct(UxsUserContext userContext, String levelNCategoryId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRecommandProduct(userContext,levelNCategoryId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.removeRecommandProduct( recommandProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
			deleteRelationInGraph(userContext, recommandProduct);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRecommandProduct(UxsUserContext userContext, String levelNCategoryId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory copyRecommandProductFrom(UxsUserContext userContext, String levelNCategoryId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRecommandProduct(userContext,levelNCategoryId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			recommandProduct.updateLastUpdateTime(userContext.now());
			
			levelNCategory.copyRecommandProductFrom( recommandProduct );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, (RecommandProduct)levelNCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRecommandProduct(UxsUserContext userContext, String levelNCategoryId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	
	public  LevelNCategory updateRecommandProduct(UxsUserContext userContext, String levelNCategoryId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRecommandProduct(userContext, levelNCategoryId, recommandProductId, recommandProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRecommandProductList().searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "eq", recommandProductId).done();
		
		
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, loadTokens);
		
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelNCategory.removeRecommandProduct( recommandProduct );	
			//make changes to AcceleraterAccount.
			RecommandProduct recommandProductIndex = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		
			RecommandProduct recommandProduct = levelNCategory.findTheRecommandProduct(recommandProductIndex);
			if(recommandProduct == null){
				throw new LevelNCategoryManagerException(recommandProduct+" is NOT FOUND" );
			}
			
			recommandProduct.changeProperty(property, newValueExpr);
			recommandProduct.updateLastUpdateTime(userContext.now());
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withRecommandProductList().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UxsUserContext userContext, LevelNCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


