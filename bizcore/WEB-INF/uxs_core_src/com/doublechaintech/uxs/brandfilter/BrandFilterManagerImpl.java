
package com.doublechaintech.uxs.brandfilter;

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

import com.doublechaintech.uxs.profile.Profile;

import com.doublechaintech.uxs.profile.CandidateProfile;







public class BrandFilterManagerImpl extends CustomUxsCheckerManager implements BrandFilterManager {
	
	private static final String SERVICE_TYPE = "BrandFilter";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws BrandFilterManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new BrandFilterManagerException(message);

	}
	
	

 	protected BrandFilter saveBrandFilter(UxsUserContext userContext, BrandFilter brandFilter, String [] tokensExpr) throws Exception{	
 		//return getBrandFilterDAO().save(brandFilter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveBrandFilter(userContext, brandFilter, tokens);
 	}
 	
 	protected BrandFilter saveBrandFilterDetail(UxsUserContext userContext, BrandFilter brandFilter) throws Exception{	

 		
 		return saveBrandFilter(userContext, brandFilter, allTokens());
 	}
 	
 	public BrandFilter loadBrandFilter(UxsUserContext userContext, String brandFilterId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandFilterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		BrandFilter brandFilter = loadBrandFilter( userContext, brandFilterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brandFilter, tokens);
 	}
 	
 	
 	 public BrandFilter searchBrandFilter(UxsUserContext userContext, String brandFilterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandFilterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		BrandFilter brandFilter = loadBrandFilter( userContext, brandFilterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brandFilter, tokens);
 	}
 	
 	

 	protected BrandFilter present(UxsUserContext userContext, BrandFilter brandFilter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,brandFilter,tokens);
		
		
		BrandFilter  brandFilterToPresent = userContext.getDAOGroup().getBrandFilterDAO().present(brandFilter, tokens);
		
		List<BaseEntity> entityListToNaming = brandFilterToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getBrandFilterDAO().alias(entityListToNaming);
		
		return  brandFilterToPresent;
		
		
	}
 
 	
 	
 	public BrandFilter loadBrandFilterDetail(UxsUserContext userContext, String brandFilterId) throws Exception{	
 		BrandFilter brandFilter = loadBrandFilter( userContext, brandFilterId, allTokens());
 		return present(userContext,brandFilter, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String brandFilterId) throws Exception{	
 		BrandFilter brandFilter = loadBrandFilter( userContext, brandFilterId, viewTokens());
 		return present(userContext,brandFilter, allTokens());
		
 	}
 	protected BrandFilter saveBrandFilter(UxsUserContext userContext, BrandFilter brandFilter, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getBrandFilterDAO().save(brandFilter, tokens);
 	}
 	protected BrandFilter loadBrandFilter(UxsUserContext userContext, String brandFilterId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandFilterManagerException.class);

 
 		return userContext.getDAOGroup().getBrandFilterDAO().load(brandFilterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, BrandFilter brandFilter, Map<String, Object> tokens){
		super.addActions(userContext, brandFilter, tokens);
		
		addAction(userContext, brandFilter, tokens,"@create","createBrandFilter","createBrandFilter/","main","primary");
		addAction(userContext, brandFilter, tokens,"@update","updateBrandFilter","updateBrandFilter/"+brandFilter.getId()+"/","main","primary");
		addAction(userContext, brandFilter, tokens,"@copy","cloneBrandFilter","cloneBrandFilter/"+brandFilter.getId()+"/","main","primary");
		
		addAction(userContext, brandFilter, tokens,"brand_filter.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+brandFilter.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, BrandFilter brandFilter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public BrandFilter createBrandFilter(UxsUserContext userContext,String name, String internalId, String profileId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfBrandFilter(name);
		userContext.getChecker().checkInternalIdOfBrandFilter(internalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandFilterManagerException.class);


		BrandFilter brandFilter=createNewBrandFilter();	

		brandFilter.setName(name);
		brandFilter.setInternalId(internalId);
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		brandFilter.setProfile(profile);
		
		

		brandFilter = saveBrandFilter(userContext, brandFilter, emptyOptions());
		
		onNewInstanceCreated(userContext, brandFilter);
		return brandFilter;

		
	}
	protected BrandFilter createNewBrandFilter() 
	{
		
		return new BrandFilter();		
	}
	
	protected void checkParamsForUpdatingBrandFilter(UxsUserContext userContext,String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().checkVersionOfBrandFilter( brandFilterVersion);
		

		if(BrandFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfBrandFilter(parseString(newValueExpr));
		}
		if(BrandFilter.INTERNAL_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalIdOfBrandFilter(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandFilterManagerException.class);
	
		
	}
	
	
	
	public BrandFilter clone(UxsUserContext userContext, String fromBrandFilterId) throws Exception{
		
		return userContext.getDAOGroup().getBrandFilterDAO().clone(fromBrandFilterId, this.allTokens());
	}
	
	public BrandFilter internalSaveBrandFilter(UxsUserContext userContext, BrandFilter brandFilter) throws Exception 
	{
		return internalSaveBrandFilter(userContext, brandFilter, allTokens());

	}
	public BrandFilter internalSaveBrandFilter(UxsUserContext userContext, BrandFilter brandFilter, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingBrandFilter(userContext, brandFilterId, brandFilterVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(brandFilter){ 
			//will be good when the brandFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to BrandFilter.
			
			
			brandFilter = saveBrandFilter(userContext, brandFilter, options);
			return brandFilter;
			
		}

	}
	
	public BrandFilter updateBrandFilter(UxsUserContext userContext,String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrandFilter(userContext, brandFilterId, brandFilterVersion, property, newValueExpr, tokensExpr);
		
		
		
		BrandFilter brandFilter = loadBrandFilter(userContext, brandFilterId, allTokens());
		if(brandFilter.getVersion() != brandFilterVersion){
			String message = "The target version("+brandFilter.getVersion()+") is not equals to version("+brandFilterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brandFilter){ 
			//will be good when the brandFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to BrandFilter.
			
			brandFilter.changeProperty(property, newValueExpr);
			brandFilter = saveBrandFilter(userContext, brandFilter, tokens().done());
			return present(userContext,brandFilter, mergedAllTokens(tokensExpr));
			//return saveBrandFilter(userContext, brandFilter, tokens().done());
		}

	}
	
	public BrandFilter updateBrandFilterProperty(UxsUserContext userContext,String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrandFilter(userContext, brandFilterId, brandFilterVersion, property, newValueExpr, tokensExpr);
		
		BrandFilter brandFilter = loadBrandFilter(userContext, brandFilterId, allTokens());
		if(brandFilter.getVersion() != brandFilterVersion){
			String message = "The target version("+brandFilter.getVersion()+") is not equals to version("+brandFilterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brandFilter){ 
			//will be good when the brandFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to BrandFilter.
			
			brandFilter.changeProperty(property, newValueExpr);
			
			brandFilter = saveBrandFilter(userContext, brandFilter, tokens().done());
			return present(userContext,brandFilter, mergedAllTokens(tokensExpr));
			//return saveBrandFilter(userContext, brandFilter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected BrandFilterTokens tokens(){
		return BrandFilterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return BrandFilterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return BrandFilterTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProfile(UxsUserContext userContext, String brandFilterId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(BrandFilterManagerException.class);
 		
 	}
 	public BrandFilter transferToAnotherProfile(UxsUserContext userContext, String brandFilterId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, brandFilterId,anotherProfileId);
 
		BrandFilter brandFilter = loadBrandFilter(userContext, brandFilterId, allTokens());	
		synchronized(brandFilter){
			//will be good when the brandFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			brandFilter.updateProfile(profile);		
			brandFilter = saveBrandFilter(userContext, brandFilter, emptyOptions());
			
			return present(userContext,brandFilter, allTokens());
			
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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForBrandFilter(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Profile loadProfile(UxsUserContext userContext, String newProfileId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newProfileId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String brandFilterId, int brandFilterVersion) throws Exception {
		//deleteInternal(userContext, brandFilterId, brandFilterVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String brandFilterId, int brandFilterVersion) throws Exception{
			
		userContext.getDAOGroup().getBrandFilterDAO().delete(brandFilterId, brandFilterVersion);
	}
	
	public BrandFilter forgetByAll(UxsUserContext userContext, String brandFilterId, int brandFilterVersion) throws Exception {
		return forgetByAllInternal(userContext, brandFilterId, brandFilterVersion);		
	}
	protected BrandFilter forgetByAllInternal(UxsUserContext userContext,
			String brandFilterId, int brandFilterVersion) throws Exception{
			
		return userContext.getDAOGroup().getBrandFilterDAO().disconnectFromAll(brandFilterId, brandFilterVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new BrandFilterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getBrandFilterDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, BrandFilter newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


