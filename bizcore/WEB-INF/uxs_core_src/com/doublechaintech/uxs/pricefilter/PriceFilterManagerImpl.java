
package com.doublechaintech.uxs.pricefilter;

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







public class PriceFilterManagerImpl extends CustomUxsCheckerManager implements PriceFilterManager {
	
	private static final String SERVICE_TYPE = "PriceFilter";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PriceFilterManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PriceFilterManagerException(message);

	}
	
	

 	protected PriceFilter savePriceFilter(UxsUserContext userContext, PriceFilter priceFilter, String [] tokensExpr) throws Exception{	
 		//return getPriceFilterDAO().save(priceFilter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePriceFilter(userContext, priceFilter, tokens);
 	}
 	
 	protected PriceFilter savePriceFilterDetail(UxsUserContext userContext, PriceFilter priceFilter) throws Exception{	

 		
 		return savePriceFilter(userContext, priceFilter, allTokens());
 	}
 	
 	public PriceFilter loadPriceFilter(UxsUserContext userContext, String priceFilterId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( PriceFilterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PriceFilter priceFilter = loadPriceFilter( userContext, priceFilterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,priceFilter, tokens);
 	}
 	
 	
 	 public PriceFilter searchPriceFilter(UxsUserContext userContext, String priceFilterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( PriceFilterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PriceFilter priceFilter = loadPriceFilter( userContext, priceFilterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,priceFilter, tokens);
 	}
 	
 	

 	protected PriceFilter present(UxsUserContext userContext, PriceFilter priceFilter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,priceFilter,tokens);
		
		
		PriceFilter  priceFilterToPresent = userContext.getDAOGroup().getPriceFilterDAO().present(priceFilter, tokens);
		
		List<BaseEntity> entityListToNaming = priceFilterToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPriceFilterDAO().alias(entityListToNaming);
		
		return  priceFilterToPresent;
		
		
	}
 
 	
 	
 	public PriceFilter loadPriceFilterDetail(UxsUserContext userContext, String priceFilterId) throws Exception{	
 		PriceFilter priceFilter = loadPriceFilter( userContext, priceFilterId, allTokens());
 		return present(userContext,priceFilter, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String priceFilterId) throws Exception{	
 		PriceFilter priceFilter = loadPriceFilter( userContext, priceFilterId, viewTokens());
 		return present(userContext,priceFilter, allTokens());
		
 	}
 	protected PriceFilter savePriceFilter(UxsUserContext userContext, PriceFilter priceFilter, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPriceFilterDAO().save(priceFilter, tokens);
 	}
 	protected PriceFilter loadPriceFilter(UxsUserContext userContext, String priceFilterId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().throwExceptionIfHasErrors( PriceFilterManagerException.class);

 
 		return userContext.getDAOGroup().getPriceFilterDAO().load(priceFilterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, PriceFilter priceFilter, Map<String, Object> tokens){
		super.addActions(userContext, priceFilter, tokens);
		
		addAction(userContext, priceFilter, tokens,"@create","createPriceFilter","createPriceFilter/","main","primary");
		addAction(userContext, priceFilter, tokens,"@update","updatePriceFilter","updatePriceFilter/"+priceFilter.getId()+"/","main","primary");
		addAction(userContext, priceFilter, tokens,"@copy","clonePriceFilter","clonePriceFilter/"+priceFilter.getId()+"/","main","primary");
		
		addAction(userContext, priceFilter, tokens,"price_filter.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+priceFilter.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, PriceFilter priceFilter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PriceFilter createPriceFilter(UxsUserContext userContext,String name, BigDecimal priceStart, BigDecimal priceEnd, String profileId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPriceFilter(name);
		userContext.getChecker().checkPriceStartOfPriceFilter(priceStart);
		userContext.getChecker().checkPriceEndOfPriceFilter(priceEnd);
	
		userContext.getChecker().throwExceptionIfHasErrors(PriceFilterManagerException.class);


		PriceFilter priceFilter=createNewPriceFilter();	

		priceFilter.setName(name);
		priceFilter.setPriceStart(priceStart);
		priceFilter.setPriceEnd(priceEnd);
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		priceFilter.setProfile(profile);
		
		

		priceFilter = savePriceFilter(userContext, priceFilter, emptyOptions());
		
		onNewInstanceCreated(userContext, priceFilter);
		return priceFilter;

		
	}
	protected PriceFilter createNewPriceFilter() 
	{
		
		return new PriceFilter();		
	}
	
	protected void checkParamsForUpdatingPriceFilter(UxsUserContext userContext,String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().checkVersionOfPriceFilter( priceFilterVersion);
		

		if(PriceFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPriceFilter(parseString(newValueExpr));
		}
		if(PriceFilter.PRICE_START_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceStartOfPriceFilter(parseBigDecimal(newValueExpr));
		}
		if(PriceFilter.PRICE_END_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceEndOfPriceFilter(parseBigDecimal(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(PriceFilterManagerException.class);
	
		
	}
	
	
	
	public PriceFilter clone(UxsUserContext userContext, String fromPriceFilterId) throws Exception{
		
		return userContext.getDAOGroup().getPriceFilterDAO().clone(fromPriceFilterId, this.allTokens());
	}
	
	public PriceFilter internalSavePriceFilter(UxsUserContext userContext, PriceFilter priceFilter) throws Exception 
	{
		return internalSavePriceFilter(userContext, priceFilter, allTokens());

	}
	public PriceFilter internalSavePriceFilter(UxsUserContext userContext, PriceFilter priceFilter, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPriceFilter(userContext, priceFilterId, priceFilterVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(priceFilter){ 
			//will be good when the priceFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PriceFilter.
			
			
			priceFilter = savePriceFilter(userContext, priceFilter, options);
			return priceFilter;
			
		}

	}
	
	public PriceFilter updatePriceFilter(UxsUserContext userContext,String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPriceFilter(userContext, priceFilterId, priceFilterVersion, property, newValueExpr, tokensExpr);
		
		
		
		PriceFilter priceFilter = loadPriceFilter(userContext, priceFilterId, allTokens());
		if(priceFilter.getVersion() != priceFilterVersion){
			String message = "The target version("+priceFilter.getVersion()+") is not equals to version("+priceFilterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(priceFilter){ 
			//will be good when the priceFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PriceFilter.
			
			priceFilter.changeProperty(property, newValueExpr);
			priceFilter = savePriceFilter(userContext, priceFilter, tokens().done());
			return present(userContext,priceFilter, mergedAllTokens(tokensExpr));
			//return savePriceFilter(userContext, priceFilter, tokens().done());
		}

	}
	
	public PriceFilter updatePriceFilterProperty(UxsUserContext userContext,String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPriceFilter(userContext, priceFilterId, priceFilterVersion, property, newValueExpr, tokensExpr);
		
		PriceFilter priceFilter = loadPriceFilter(userContext, priceFilterId, allTokens());
		if(priceFilter.getVersion() != priceFilterVersion){
			String message = "The target version("+priceFilter.getVersion()+") is not equals to version("+priceFilterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(priceFilter){ 
			//will be good when the priceFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PriceFilter.
			
			priceFilter.changeProperty(property, newValueExpr);
			
			priceFilter = savePriceFilter(userContext, priceFilter, tokens().done());
			return present(userContext,priceFilter, mergedAllTokens(tokensExpr));
			//return savePriceFilter(userContext, priceFilter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PriceFilterTokens tokens(){
		return PriceFilterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PriceFilterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PriceFilterTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProfile(UxsUserContext userContext, String priceFilterId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(PriceFilterManagerException.class);
 		
 	}
 	public PriceFilter transferToAnotherProfile(UxsUserContext userContext, String priceFilterId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, priceFilterId,anotherProfileId);
 
		PriceFilter priceFilter = loadPriceFilter(userContext, priceFilterId, allTokens());	
		synchronized(priceFilter){
			//will be good when the priceFilter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			priceFilter.updateProfile(profile);		
			priceFilter = savePriceFilter(userContext, priceFilter, emptyOptions());
			
			return present(userContext,priceFilter, allTokens());
			
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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForPriceFilter(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(UxsUserContext userContext, String priceFilterId, int priceFilterVersion) throws Exception {
		//deleteInternal(userContext, priceFilterId, priceFilterVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String priceFilterId, int priceFilterVersion) throws Exception{
			
		userContext.getDAOGroup().getPriceFilterDAO().delete(priceFilterId, priceFilterVersion);
	}
	
	public PriceFilter forgetByAll(UxsUserContext userContext, String priceFilterId, int priceFilterVersion) throws Exception {
		return forgetByAllInternal(userContext, priceFilterId, priceFilterVersion);		
	}
	protected PriceFilter forgetByAllInternal(UxsUserContext userContext,
			String priceFilterId, int priceFilterVersion) throws Exception{
			
		return userContext.getDAOGroup().getPriceFilterDAO().disconnectFromAll(priceFilterId, priceFilterVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PriceFilterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPriceFilterDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, PriceFilter newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


