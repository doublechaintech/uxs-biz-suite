
package com.doublechaintech.uxs.leveltwocategory;

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

import com.doublechaintech.uxs.levelonecategory.LevelOneCategory;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;

import com.doublechaintech.uxs.levelonecategory.CandidateLevelOneCategory;

import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategory;






public class LevelTwoCategoryManagerImpl extends CustomUxsCheckerManager implements LevelTwoCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelTwoCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelTwoCategoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelTwoCategoryManagerException(message);

	}
	
	

 	protected LevelTwoCategory saveLevelTwoCategory(UxsUserContext userContext, LevelTwoCategory levelTwoCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelTwoCategoryDAO().save(levelTwoCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelTwoCategory(userContext, levelTwoCategory, tokens);
 	}
 	
 	protected LevelTwoCategory saveLevelTwoCategoryDetail(UxsUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception{	

 		
 		return saveLevelTwoCategory(userContext, levelTwoCategory, allTokens());
 	}
 	
 	public LevelTwoCategory loadLevelTwoCategory(UxsUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoCategory, tokens);
 	}
 	
 	
 	 public LevelTwoCategory searchLevelTwoCategory(UxsUserContext userContext, String levelTwoCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoCategory, tokens);
 	}
 	
 	

 	protected LevelTwoCategory present(UxsUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelTwoCategory,tokens);
		
		
		LevelTwoCategory  levelTwoCategoryToPresent = userContext.getDAOGroup().getLevelTwoCategoryDAO().present(levelTwoCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelTwoCategoryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelTwoCategoryDAO().alias(entityListToNaming);
		
		return  levelTwoCategoryToPresent;
		
		
	}
 
 	
 	
 	public LevelTwoCategory loadLevelTwoCategoryDetail(UxsUserContext userContext, String levelTwoCategoryId) throws Exception{	
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, allTokens());
 		return present(userContext,levelTwoCategory, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String levelTwoCategoryId) throws Exception{	
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, viewTokens());
 		return present(userContext,levelTwoCategory, allTokens());
		
 	}
 	protected LevelTwoCategory saveLevelTwoCategory(UxsUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelTwoCategoryDAO().save(levelTwoCategory, tokens);
 	}
 	protected LevelTwoCategory loadLevelTwoCategory(UxsUserContext userContext, String levelTwoCategoryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);

 
 		return userContext.getDAOGroup().getLevelTwoCategoryDAO().load(levelTwoCategoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelTwoCategory, tokens);
		
		addAction(userContext, levelTwoCategory, tokens,"@create","createLevelTwoCategory","createLevelTwoCategory/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"@update","updateLevelTwoCategory","updateLevelTwoCategory/"+levelTwoCategory.getId()+"/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"@copy","cloneLevelTwoCategory","cloneLevelTwoCategory/"+levelTwoCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+levelTwoCategory.getId()+"/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.addLevelNCategory","addLevelNCategory","addLevelNCategory/"+levelTwoCategory.getId()+"/","levelNCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.removeLevelNCategory","removeLevelNCategory","removeLevelNCategory/"+levelTwoCategory.getId()+"/","levelNCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.updateLevelNCategory","updateLevelNCategory","updateLevelNCategory/"+levelTwoCategory.getId()+"/","levelNCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.copyLevelNCategoryFrom","copyLevelNCategoryFrom","copyLevelNCategoryFrom/"+levelTwoCategory.getId()+"/","levelNCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelTwoCategory createLevelTwoCategory(UxsUserContext userContext,String parentCategoryId, String name) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelTwoCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);


		LevelTwoCategory levelTwoCategory=createNewLevelTwoCategory();	

			
		LevelOneCategory parentCategory = loadLevelOneCategory(userContext, parentCategoryId,emptyOptions());
		levelTwoCategory.setParentCategory(parentCategory);
		
		
		levelTwoCategory.setName(name);

		levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelTwoCategory);
		return levelTwoCategory;

		
	}
	protected LevelTwoCategory createNewLevelTwoCategory() 
	{
		
		return new LevelTwoCategory();		
	}
	
	protected void checkParamsForUpdatingLevelTwoCategory(UxsUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkVersionOfLevelTwoCategory( levelTwoCategoryVersion);
		
		

		
		if(LevelTwoCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelTwoCategory(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
	
		
	}
	
	
	
	public LevelTwoCategory clone(UxsUserContext userContext, String fromLevelTwoCategoryId) throws Exception{
		
		return userContext.getDAOGroup().getLevelTwoCategoryDAO().clone(fromLevelTwoCategoryId, this.allTokens());
	}
	
	public LevelTwoCategory internalSaveLevelTwoCategory(UxsUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception 
	{
		return internalSaveLevelTwoCategory(userContext, levelTwoCategory, allTokens());

	}
	public LevelTwoCategory internalSaveLevelTwoCategory(UxsUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelTwoCategory){ 
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, options);
			return levelTwoCategory;
			
		}

	}
	
	public LevelTwoCategory updateLevelTwoCategory(UxsUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		if(levelTwoCategory.getVersion() != levelTwoCategoryVersion){
			String message = "The target version("+levelTwoCategory.getVersion()+") is not equals to version("+levelTwoCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoCategory){ 
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			
			levelTwoCategory.changeProperty(property, newValueExpr);
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			//return saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
		}

	}
	
	public LevelTwoCategory updateLevelTwoCategoryProperty(UxsUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		if(levelTwoCategory.getVersion() != levelTwoCategoryVersion){
			String message = "The target version("+levelTwoCategory.getVersion()+") is not equals to version("+levelTwoCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoCategory){ 
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			
			levelTwoCategory.changeProperty(property, newValueExpr);
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			//return saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelTwoCategoryTokens tokens(){
		return LevelTwoCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelTwoCategoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelNCategoryListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelTwoCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(UxsUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
 		userContext.getChecker().checkIdOfLevelOneCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
 		
 	}
 	public LevelTwoCategory transferToAnotherParentCategory(UxsUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, levelTwoCategoryId,anotherParentCategoryId);
 
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());	
		synchronized(levelTwoCategory){
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelOneCategory parentCategory = loadLevelOneCategory(userContext, anotherParentCategoryId, emptyOptions());		
			levelTwoCategory.updateParentCategory(parentCategory);		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, emptyOptions());
			
			return present(userContext,levelTwoCategory, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelOneCategory requestCandidateParentCategory(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelOneCategory result = new CandidateLevelOneCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("catalog");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelOneCategory> candidateList = userContext.getDAOGroup().getLevelOneCategoryDAO().requestCandidateLevelOneCategoryForLevelTwoCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelOneCategory loadLevelOneCategory(UxsUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelOneCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelTwoCategoryId, levelTwoCategoryVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelTwoCategoryDAO().delete(levelTwoCategoryId, levelTwoCategoryVersion);
	}
	
	public LevelTwoCategory forgetByAll(UxsUserContext userContext, String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelTwoCategoryId, levelTwoCategoryVersion);		
	}
	protected LevelTwoCategory forgetByAllInternal(UxsUserContext userContext,
			String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelTwoCategoryDAO().disconnectFromAll(levelTwoCategoryId, levelTwoCategoryVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelTwoCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelTwoCategoryDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);

		
		userContext.getChecker().checkNameOfLevelNCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);

	
	}
	public  LevelTwoCategory addLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelNCategory(userContext,levelTwoCategoryId,name,tokensExpr);
		
		LevelNCategory levelNCategory = createLevelNCategory(userContext,name);
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.addLevelNCategory( levelNCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelNCategoryList().done());
			
			userContext.getManagerGroup().getLevelNCategoryManager().onNewInstanceCreated(userContext, levelNCategory);
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelNCategoryProperties(UxsUserContext userContext, String levelTwoCategoryId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkIdOfLevelNCategory(id);
		
		userContext.getChecker().checkNameOfLevelNCategory( name);

		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
		
	}
	public  LevelTwoCategory updateLevelNCategoryProperties(UxsUserContext userContext, String levelTwoCategoryId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLevelNCategoryProperties(userContext,levelTwoCategoryId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelNCategoryListList()
				.searchLevelNCategoryListWith(LevelNCategory.ID_PROPERTY, "is", id).done();
		
		LevelTwoCategory levelTwoCategoryToUpdate = loadLevelTwoCategory(userContext, levelTwoCategoryId, options);
		
		if(levelTwoCategoryToUpdate.getLevelNCategoryList().isEmpty()){
			throw new LevelTwoCategoryManagerException("LevelNCategory is NOT FOUND with id: '"+id+"'");
		}
		
		LevelNCategory item = levelTwoCategoryToUpdate.getLevelNCategoryList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingLevelNCategory(userContext,levelTwoCategoryId,name, code, used,tokensExpr);
		LevelTwoCategory levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategoryToUpdate, tokens().withLevelNCategoryList().done());
		synchronized(levelTwoCategory){ 
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LevelNCategory createLevelNCategory(UxsUserContext userContext, String name) throws Exception{

		LevelNCategory levelNCategory = new LevelNCategory();
		
		
		levelNCategory.setName(name);
	
		
		return levelNCategory;
	
		
	}
	
	protected LevelNCategory createIndexedLevelNCategory(String id, int version){

		LevelNCategory levelNCategory = new LevelNCategory();
		levelNCategory.setId(id);
		levelNCategory.setVersion(version);
		return levelNCategory;			
		
	}
	
	protected void checkParamsForRemovingLevelNCategoryList(UxsUserContext userContext, String levelTwoCategoryId, 
			String levelNCategoryIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		for(String levelNCategoryId: levelNCategoryIds){
			userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
		
	}
	public  LevelTwoCategory removeLevelNCategoryList(UxsUserContext userContext, String levelTwoCategoryId, 
			String levelNCategoryIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLevelNCategoryList(userContext, levelTwoCategoryId,  levelNCategoryIds, tokensExpr);
			
			
			LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
			synchronized(levelTwoCategory){ 
				//Will be good when the levelTwoCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelTwoCategoryDAO().planToRemoveLevelNCategoryList(levelTwoCategory, levelNCategoryIds, allTokens());
				levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelNCategoryList().done());
				deleteRelationListInGraph(userContext, levelTwoCategory.getLevelNCategoryList());
				return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, 
		String levelNCategoryId, int levelNCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelTwoCategory( levelTwoCategoryId);
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkVersionOfLevelNCategory(levelNCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
	
	}
	public  LevelTwoCategory removeLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, 
		String levelNCategoryId, int levelNCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelNCategory(userContext,levelTwoCategoryId, levelNCategoryId, levelNCategoryVersion,tokensExpr);
		
		LevelNCategory levelNCategory = createIndexedLevelNCategory(levelNCategoryId, levelNCategoryVersion);
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.removeLevelNCategory( levelNCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelNCategoryList().done());
			deleteRelationInGraph(userContext, levelNCategory);
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, 
		String levelNCategoryId, int levelNCategoryVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelTwoCategory( levelTwoCategoryId);
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkVersionOfLevelNCategory(levelNCategoryVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
	
	}
	public  LevelTwoCategory copyLevelNCategoryFrom(UxsUserContext userContext, String levelTwoCategoryId, 
		String levelNCategoryId, int levelNCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelNCategory(userContext,levelTwoCategoryId, levelNCategoryId, levelNCategoryVersion,tokensExpr);
		
		LevelNCategory levelNCategory = createIndexedLevelNCategory(levelNCategoryId, levelNCategoryVersion);
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			levelTwoCategory.copyLevelNCategoryFrom( levelNCategory );		
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelNCategoryList().done());
			
			userContext.getManagerGroup().getLevelNCategoryManager().onNewInstanceCreated(userContext, (LevelNCategory)levelTwoCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelTwoCategory(levelTwoCategoryId);
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkVersionOfLevelNCategory(levelNCategoryVersion);
		

		if(LevelNCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelNCategory(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);
	
	}
	
	public  LevelTwoCategory updateLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelNCategory(userContext, levelTwoCategoryId, levelNCategoryId, levelNCategoryVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLevelNCategoryList().searchLevelNCategoryListWith(LevelNCategory.ID_PROPERTY, "eq", levelNCategoryId).done();
		
		
		
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, loadTokens);
		
		synchronized(levelTwoCategory){ 
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelTwoCategory.removeLevelNCategory( levelNCategory );	
			//make changes to AcceleraterAccount.
			LevelNCategory levelNCategoryIndex = createIndexedLevelNCategory(levelNCategoryId, levelNCategoryVersion);
		
			LevelNCategory levelNCategory = levelTwoCategory.findTheLevelNCategory(levelNCategoryIndex);
			if(levelNCategory == null){
				throw new LevelTwoCategoryManagerException(levelNCategory+" is NOT FOUND" );
			}
			
			levelNCategory.changeProperty(property, newValueExpr);
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelNCategoryList().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UxsUserContext userContext, LevelTwoCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


