
package com.doublechaintech.uxs.levelonecategory;

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

import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategory;

import com.doublechaintech.uxs.catalog.CandidateCatalog;

import com.doublechaintech.uxs.levelonecategory.LevelOneCategory;






public class LevelOneCategoryManagerImpl extends CustomUxsCheckerManager implements LevelOneCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelOneCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelOneCategoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelOneCategoryManagerException(message);

	}
	
	

 	protected LevelOneCategory saveLevelOneCategory(UxsUserContext userContext, LevelOneCategory levelOneCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelOneCategoryDAO().save(levelOneCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelOneCategory(userContext, levelOneCategory, tokens);
 	}
 	
 	protected LevelOneCategory saveLevelOneCategoryDetail(UxsUserContext userContext, LevelOneCategory levelOneCategory) throws Exception{	

 		
 		return saveLevelOneCategory(userContext, levelOneCategory, allTokens());
 	}
 	
 	public LevelOneCategory loadLevelOneCategory(UxsUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneCategory, tokens);
 	}
 	
 	
 	 public LevelOneCategory searchLevelOneCategory(UxsUserContext userContext, String levelOneCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelOneCategory, tokens);
 	}
 	
 	

 	protected LevelOneCategory present(UxsUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelOneCategory,tokens);
		
		
		LevelOneCategory  levelOneCategoryToPresent = userContext.getDAOGroup().getLevelOneCategoryDAO().present(levelOneCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelOneCategoryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelOneCategoryDAO().alias(entityListToNaming);
		
		return  levelOneCategoryToPresent;
		
		
	}
 
 	
 	
 	public LevelOneCategory loadLevelOneCategoryDetail(UxsUserContext userContext, String levelOneCategoryId) throws Exception{	
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, allTokens());
 		return present(userContext,levelOneCategory, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String levelOneCategoryId) throws Exception{	
 		LevelOneCategory levelOneCategory = loadLevelOneCategory( userContext, levelOneCategoryId, viewTokens());
 		return present(userContext,levelOneCategory, allTokens());
		
 	}
 	protected LevelOneCategory saveLevelOneCategory(UxsUserContext userContext, LevelOneCategory levelOneCategory, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelOneCategoryDAO().save(levelOneCategory, tokens);
 	}
 	protected LevelOneCategory loadLevelOneCategory(UxsUserContext userContext, String levelOneCategoryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelOneCategoryManagerException.class);

 
 		return userContext.getDAOGroup().getLevelOneCategoryDAO().load(levelOneCategoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelOneCategory, tokens);
		
		addAction(userContext, levelOneCategory, tokens,"@create","createLevelOneCategory","createLevelOneCategory/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"@update","updateLevelOneCategory","updateLevelOneCategory/"+levelOneCategory.getId()+"/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"@copy","cloneLevelOneCategory","cloneLevelOneCategory/"+levelOneCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelOneCategory, tokens,"level_one_category.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+levelOneCategory.getId()+"/","main","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.addLevelTwoCategory","addLevelTwoCategory","addLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.removeLevelTwoCategory","removeLevelTwoCategory","removeLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.updateLevelTwoCategory","updateLevelTwoCategory","updateLevelTwoCategory/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
		addAction(userContext, levelOneCategory, tokens,"level_one_category.copyLevelTwoCategoryFrom","copyLevelTwoCategoryFrom","copyLevelTwoCategoryFrom/"+levelOneCategory.getId()+"/","levelTwoCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, LevelOneCategory levelOneCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelOneCategory createLevelOneCategory(UxsUserContext userContext,String catalogId, String name) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelOneCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);


		LevelOneCategory levelOneCategory=createNewLevelOneCategory();	

			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		levelOneCategory.setCatalog(catalog);
		
		
		levelOneCategory.setName(name);

		levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelOneCategory);
		return levelOneCategory;

		
	}
	protected LevelOneCategory createNewLevelOneCategory() 
	{
		
		return new LevelOneCategory();		
	}
	
	protected void checkParamsForUpdatingLevelOneCategory(UxsUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkVersionOfLevelOneCategory( levelOneCategoryVersion);
		
		

		
		if(LevelOneCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelOneCategory(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
	
		
	}
	
	
	
	public LevelOneCategory clone(UxsUserContext userContext, String fromLevelOneCategoryId) throws Exception{
		
		return userContext.getDAOGroup().getLevelOneCategoryDAO().clone(fromLevelOneCategoryId, this.allTokens());
	}
	
	public LevelOneCategory internalSaveLevelOneCategory(UxsUserContext userContext, LevelOneCategory levelOneCategory) throws Exception 
	{
		return internalSaveLevelOneCategory(userContext, levelOneCategory, allTokens());

	}
	public LevelOneCategory internalSaveLevelOneCategory(UxsUserContext userContext, LevelOneCategory levelOneCategory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelOneCategory){ 
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			
			
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, options);
			return levelOneCategory;
			
		}

	}
	
	public LevelOneCategory updateLevelOneCategory(UxsUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		if(levelOneCategory.getVersion() != levelOneCategoryVersion){
			String message = "The target version("+levelOneCategory.getVersion()+") is not equals to version("+levelOneCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelOneCategory){ 
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			
			levelOneCategory.changeProperty(property, newValueExpr);
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			//return saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
		}

	}
	
	public LevelOneCategory updateLevelOneCategoryProperty(UxsUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelOneCategory(userContext, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		if(levelOneCategory.getVersion() != levelOneCategoryVersion){
			String message = "The target version("+levelOneCategory.getVersion()+") is not equals to version("+levelOneCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelOneCategory){ 
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelOneCategory.
			
			levelOneCategory.changeProperty(property, newValueExpr);
			
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			//return saveLevelOneCategory(userContext, levelOneCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelOneCategoryTokens tokens(){
		return LevelOneCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelOneCategoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelTwoCategoryListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelOneCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCatalog(UxsUserContext userContext, String levelOneCategoryId, String anotherCatalogId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
 		userContext.getChecker().checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
 		
 	}
 	public LevelOneCategory transferToAnotherCatalog(UxsUserContext userContext, String levelOneCategoryId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, levelOneCategoryId,anotherCatalogId);
 
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());	
		synchronized(levelOneCategory){
			//will be good when the levelOneCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			levelOneCategory.updateCatalog(catalog);		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, emptyOptions());
			
			return present(userContext,levelOneCategory, allTokens());
			
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
		SmartList<Catalog> candidateList = userContext.getDAOGroup().getCatalogDAO().requestCandidateCatalogForLevelOneCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String levelOneCategoryId, int levelOneCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelOneCategoryId, levelOneCategoryVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String levelOneCategoryId, int levelOneCategoryVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelOneCategoryDAO().delete(levelOneCategoryId, levelOneCategoryVersion);
	}
	
	public LevelOneCategory forgetByAll(UxsUserContext userContext, String levelOneCategoryId, int levelOneCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelOneCategoryId, levelOneCategoryVersion);		
	}
	protected LevelOneCategory forgetByAllInternal(UxsUserContext userContext,
			String levelOneCategoryId, int levelOneCategoryVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelOneCategoryDAO().disconnectFromAll(levelOneCategoryId, levelOneCategoryVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelOneCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelOneCategoryDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);

		
		userContext.getChecker().checkNameOfLevelTwoCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);

	
	}
	public  LevelOneCategory addLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelTwoCategory(userContext,levelOneCategoryId,name,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createLevelTwoCategory(userContext,name);
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.addLevelTwoCategory( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			
			userContext.getManagerGroup().getLevelTwoCategoryManager().onNewInstanceCreated(userContext, levelTwoCategory);
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelTwoCategoryProperties(UxsUserContext userContext, String levelOneCategoryId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkIdOfLevelTwoCategory(id);
		
		userContext.getChecker().checkNameOfLevelTwoCategory( name);

		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
		
	}
	public  LevelOneCategory updateLevelTwoCategoryProperties(UxsUserContext userContext, String levelOneCategoryId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLevelTwoCategoryProperties(userContext,levelOneCategoryId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelTwoCategoryListList()
				.searchLevelTwoCategoryListWith(LevelTwoCategory.ID_PROPERTY, "is", id).done();
		
		LevelOneCategory levelOneCategoryToUpdate = loadLevelOneCategory(userContext, levelOneCategoryId, options);
		
		if(levelOneCategoryToUpdate.getLevelTwoCategoryList().isEmpty()){
			throw new LevelOneCategoryManagerException("LevelTwoCategory is NOT FOUND with id: '"+id+"'");
		}
		
		LevelTwoCategory item = levelOneCategoryToUpdate.getLevelTwoCategoryList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingLevelTwoCategory(userContext,levelOneCategoryId,name, code, used,tokensExpr);
		LevelOneCategory levelOneCategory = saveLevelOneCategory(userContext, levelOneCategoryToUpdate, tokens().withLevelTwoCategoryList().done());
		synchronized(levelOneCategory){ 
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LevelTwoCategory createLevelTwoCategory(UxsUserContext userContext, String name) throws Exception{

		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		
		
		levelTwoCategory.setName(name);
	
		
		return levelTwoCategory;
	
		
	}
	
	protected LevelTwoCategory createIndexedLevelTwoCategory(String id, int version){

		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		levelTwoCategory.setId(id);
		levelTwoCategory.setVersion(version);
		return levelTwoCategory;			
		
	}
	
	protected void checkParamsForRemovingLevelTwoCategoryList(UxsUserContext userContext, String levelOneCategoryId, 
			String levelTwoCategoryIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		for(String levelTwoCategoryId: levelTwoCategoryIds){
			userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
		
	}
	public  LevelOneCategory removeLevelTwoCategoryList(UxsUserContext userContext, String levelOneCategoryId, 
			String levelTwoCategoryIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLevelTwoCategoryList(userContext, levelOneCategoryId,  levelTwoCategoryIds, tokensExpr);
			
			
			LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
			synchronized(levelOneCategory){ 
				//Will be good when the levelOneCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelOneCategoryDAO().planToRemoveLevelTwoCategoryList(levelOneCategory, levelTwoCategoryIds, allTokens());
				levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
				deleteRelationListInGraph(userContext, levelOneCategory.getLevelTwoCategoryList());
				return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelOneCategory( levelOneCategoryId);
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
	
	}
	public  LevelOneCategory removeLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelTwoCategory(userContext,levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelOneCategory.removeLevelTwoCategory( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			deleteRelationInGraph(userContext, levelTwoCategory);
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelOneCategory( levelOneCategoryId);
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
	
	}
	public  LevelOneCategory copyLevelTwoCategoryFrom(UxsUserContext userContext, String levelOneCategoryId, 
		String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelTwoCategory(userContext,levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion,tokensExpr);
		
		LevelTwoCategory levelTwoCategory = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, allTokens());
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			levelOneCategory.copyLevelTwoCategoryFrom( levelTwoCategory );		
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			
			userContext.getManagerGroup().getLevelTwoCategoryManager().onNewInstanceCreated(userContext, (LevelTwoCategory)levelOneCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelOneCategory(levelOneCategoryId);
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkVersionOfLevelTwoCategory(levelTwoCategoryVersion);
		

		if(LevelTwoCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelTwoCategory(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelOneCategoryManagerException.class);
	
	}
	
	public  LevelOneCategory updateLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelTwoCategory(userContext, levelOneCategoryId, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLevelTwoCategoryList().searchLevelTwoCategoryListWith(LevelTwoCategory.ID_PROPERTY, "eq", levelTwoCategoryId).done();
		
		
		
		LevelOneCategory levelOneCategory = loadLevelOneCategory(userContext, levelOneCategoryId, loadTokens);
		
		synchronized(levelOneCategory){ 
			//Will be good when the levelOneCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelOneCategory.removeLevelTwoCategory( levelTwoCategory );	
			//make changes to AcceleraterAccount.
			LevelTwoCategory levelTwoCategoryIndex = createIndexedLevelTwoCategory(levelTwoCategoryId, levelTwoCategoryVersion);
		
			LevelTwoCategory levelTwoCategory = levelOneCategory.findTheLevelTwoCategory(levelTwoCategoryIndex);
			if(levelTwoCategory == null){
				throw new LevelOneCategoryManagerException(levelTwoCategory+" is NOT FOUND" );
			}
			
			levelTwoCategory.changeProperty(property, newValueExpr);
			
			levelOneCategory = saveLevelOneCategory(userContext, levelOneCategory, tokens().withLevelTwoCategoryList().done());
			return present(userContext,levelOneCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UxsUserContext userContext, LevelOneCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


