
package com.doublechaintech.uxs.useralert;

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
import com.doublechaintech.uxs.platform.Platform;

import com.doublechaintech.uxs.profile.CandidateProfile;
import com.doublechaintech.uxs.platform.CandidatePlatform;







public class UserAlertManagerImpl extends CustomUxsCheckerManager implements UserAlertManager {
	
	private static final String SERVICE_TYPE = "UserAlert";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws UserAlertManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new UserAlertManagerException(message);

	}
	
	

 	protected UserAlert saveUserAlert(UxsUserContext userContext, UserAlert userAlert, String [] tokensExpr) throws Exception{	
 		//return getUserAlertDAO().save(userAlert, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserAlert(userContext, userAlert, tokens);
 	}
 	
 	protected UserAlert saveUserAlertDetail(UxsUserContext userContext, UserAlert userAlert) throws Exception{	

 		
 		return saveUserAlert(userContext, userAlert, allTokens());
 	}
 	
 	public UserAlert loadUserAlert(UxsUserContext userContext, String userAlertId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().throwExceptionIfHasErrors( UserAlertManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserAlert userAlert = loadUserAlert( userContext, userAlertId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userAlert, tokens);
 	}
 	
 	
 	 public UserAlert searchUserAlert(UxsUserContext userContext, String userAlertId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().throwExceptionIfHasErrors( UserAlertManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		UserAlert userAlert = loadUserAlert( userContext, userAlertId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userAlert, tokens);
 	}
 	
 	

 	protected UserAlert present(UxsUserContext userContext, UserAlert userAlert, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userAlert,tokens);
		
		
		UserAlert  userAlertToPresent = userContext.getDAOGroup().getUserAlertDAO().present(userAlert, tokens);
		
		List<BaseEntity> entityListToNaming = userAlertToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getUserAlertDAO().alias(entityListToNaming);
		
		return  userAlertToPresent;
		
		
	}
 
 	
 	
 	public UserAlert loadUserAlertDetail(UxsUserContext userContext, String userAlertId) throws Exception{	
 		UserAlert userAlert = loadUserAlert( userContext, userAlertId, allTokens());
 		return present(userContext,userAlert, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String userAlertId) throws Exception{	
 		UserAlert userAlert = loadUserAlert( userContext, userAlertId, viewTokens());
 		return present(userContext,userAlert, allTokens());
		
 	}
 	protected UserAlert saveUserAlert(UxsUserContext userContext, UserAlert userAlert, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getUserAlertDAO().save(userAlert, tokens);
 	}
 	protected UserAlert loadUserAlert(UxsUserContext userContext, String userAlertId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().throwExceptionIfHasErrors( UserAlertManagerException.class);

 
 		return userContext.getDAOGroup().getUserAlertDAO().load(userAlertId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, UserAlert userAlert, Map<String, Object> tokens){
		super.addActions(userContext, userAlert, tokens);
		
		addAction(userContext, userAlert, tokens,"@create","createUserAlert","createUserAlert/","main","primary");
		addAction(userContext, userAlert, tokens,"@update","updateUserAlert","updateUserAlert/"+userAlert.getId()+"/","main","primary");
		addAction(userContext, userAlert, tokens,"@copy","cloneUserAlert","cloneUserAlert/"+userAlert.getId()+"/","main","primary");
		
		addAction(userContext, userAlert, tokens,"user_alert.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+userAlert.getId()+"/","main","primary");
		addAction(userContext, userAlert, tokens,"user_alert.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+userAlert.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, UserAlert userAlert, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public UserAlert createUserAlert(UxsUserContext userContext,String message, String profileId, String location, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkMessageOfUserAlert(message);
		userContext.getChecker().checkLocationOfUserAlert(location);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserAlertManagerException.class);


		UserAlert userAlert=createNewUserAlert();	

		userAlert.setMessage(message);
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		userAlert.setProfile(profile);
		
		
		userAlert.setLocation(location);
		userAlert.setLastUpdate(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		userAlert.setPlatform(platform);
		
		

		userAlert = saveUserAlert(userContext, userAlert, emptyOptions());
		
		onNewInstanceCreated(userContext, userAlert);
		return userAlert;

		
	}
	protected UserAlert createNewUserAlert() 
	{
		
		return new UserAlert();		
	}
	
	protected void checkParamsForUpdatingUserAlert(UxsUserContext userContext,String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert( userAlertVersion);
		

		if(UserAlert.MESSAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkMessageOfUserAlert(parseString(newValueExpr));
		}		

		
		if(UserAlert.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfUserAlert(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserAlertManagerException.class);
	
		
	}
	
	
	
	public UserAlert clone(UxsUserContext userContext, String fromUserAlertId) throws Exception{
		
		return userContext.getDAOGroup().getUserAlertDAO().clone(fromUserAlertId, this.allTokens());
	}
	
	public UserAlert internalSaveUserAlert(UxsUserContext userContext, UserAlert userAlert) throws Exception 
	{
		return internalSaveUserAlert(userContext, userAlert, allTokens());

	}
	public UserAlert internalSaveUserAlert(UxsUserContext userContext, UserAlert userAlert, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingUserAlert(userContext, userAlertId, userAlertVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(userAlert){ 
			//will be good when the userAlert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAlert.
			
			
			userAlert = saveUserAlert(userContext, userAlert, options);
			return userAlert;
			
		}

	}
	
	public UserAlert updateUserAlert(UxsUserContext userContext,String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserAlert(userContext, userAlertId, userAlertVersion, property, newValueExpr, tokensExpr);
		
		
		
		UserAlert userAlert = loadUserAlert(userContext, userAlertId, allTokens());
		if(userAlert.getVersion() != userAlertVersion){
			String message = "The target version("+userAlert.getVersion()+") is not equals to version("+userAlertVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userAlert){ 
			//will be good when the userAlert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAlert.
			userAlert.updateLastUpdate(userContext.now());
			userAlert.changeProperty(property, newValueExpr);
			userAlert = saveUserAlert(userContext, userAlert, tokens().done());
			return present(userContext,userAlert, mergedAllTokens(tokensExpr));
			//return saveUserAlert(userContext, userAlert, tokens().done());
		}

	}
	
	public UserAlert updateUserAlertProperty(UxsUserContext userContext,String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserAlert(userContext, userAlertId, userAlertVersion, property, newValueExpr, tokensExpr);
		
		UserAlert userAlert = loadUserAlert(userContext, userAlertId, allTokens());
		if(userAlert.getVersion() != userAlertVersion){
			String message = "The target version("+userAlert.getVersion()+") is not equals to version("+userAlertVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userAlert){ 
			//will be good when the userAlert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAlert.
			
			userAlert.changeProperty(property, newValueExpr);
			userAlert.updateLastUpdate(userContext.now());
			userAlert = saveUserAlert(userContext, userAlert, tokens().done());
			return present(userContext,userAlert, mergedAllTokens(tokensExpr));
			//return saveUserAlert(userContext, userAlert, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected UserAlertTokens tokens(){
		return UserAlertTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserAlertTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserAlertTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProfile(UxsUserContext userContext, String userAlertId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfUserAlert(userAlertId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(UserAlertManagerException.class);
 		
 	}
 	public UserAlert transferToAnotherProfile(UxsUserContext userContext, String userAlertId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, userAlertId,anotherProfileId);
 
		UserAlert userAlert = loadUserAlert(userContext, userAlertId, allTokens());	
		synchronized(userAlert){
			//will be good when the userAlert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			userAlert.updateProfile(profile);		
			userAlert = saveUserAlert(userContext, userAlert, emptyOptions());
			
			return present(userContext,userAlert, allTokens());
			
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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForUserAlert(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(UxsUserContext userContext, String userAlertId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfUserAlert(userAlertId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(UserAlertManagerException.class);
 		
 	}
 	public UserAlert transferToAnotherPlatform(UxsUserContext userContext, String userAlertId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, userAlertId,anotherPlatformId);
 
		UserAlert userAlert = loadUserAlert(userContext, userAlertId, allTokens());	
		synchronized(userAlert){
			//will be good when the userAlert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			userAlert.updatePlatform(platform);		
			userAlert = saveUserAlert(userContext, userAlert, emptyOptions());
			
			return present(userContext,userAlert, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForUserAlert(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(UxsUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String userAlertId, int userAlertVersion) throws Exception {
		//deleteInternal(userContext, userAlertId, userAlertVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String userAlertId, int userAlertVersion) throws Exception{
			
		userContext.getDAOGroup().getUserAlertDAO().delete(userAlertId, userAlertVersion);
	}
	
	public UserAlert forgetByAll(UxsUserContext userContext, String userAlertId, int userAlertVersion) throws Exception {
		return forgetByAllInternal(userContext, userAlertId, userAlertVersion);		
	}
	protected UserAlert forgetByAllInternal(UxsUserContext userContext,
			String userAlertId, int userAlertVersion) throws Exception{
			
		return userContext.getDAOGroup().getUserAlertDAO().disconnectFromAll(userAlertId, userAlertVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserAlertManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getUserAlertDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, UserAlert newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


