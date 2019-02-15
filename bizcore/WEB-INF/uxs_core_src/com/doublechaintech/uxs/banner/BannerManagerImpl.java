
package com.doublechaintech.uxs.banner;

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

import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.platform.Platform;

import com.doublechaintech.uxs.platform.CandidatePlatform;

import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.profile.Profile;






public class BannerManagerImpl extends CustomUxsCheckerManager implements BannerManager {
	
	private static final String SERVICE_TYPE = "Banner";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws BannerManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new BannerManagerException(message);

	}
	
	

 	protected Banner saveBanner(UxsUserContext userContext, Banner banner, String [] tokensExpr) throws Exception{	
 		//return getBannerDAO().save(banner, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveBanner(userContext, banner, tokens);
 	}
 	
 	protected Banner saveBannerDetail(UxsUserContext userContext, Banner banner) throws Exception{	

 		
 		return saveBanner(userContext, banner, allTokens());
 	}
 	
 	public Banner loadBanner(UxsUserContext userContext, String bannerId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().throwExceptionIfHasErrors( BannerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Banner banner = loadBanner( userContext, bannerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,banner, tokens);
 	}
 	
 	
 	 public Banner searchBanner(UxsUserContext userContext, String bannerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().throwExceptionIfHasErrors( BannerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Banner banner = loadBanner( userContext, bannerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,banner, tokens);
 	}
 	
 	

 	protected Banner present(UxsUserContext userContext, Banner banner, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,banner,tokens);
		
		
		Banner  bannerToPresent = userContext.getDAOGroup().getBannerDAO().present(banner, tokens);
		
		List<BaseEntity> entityListToNaming = bannerToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getBannerDAO().alias(entityListToNaming);
		
		return  bannerToPresent;
		
		
	}
 
 	
 	
 	public Banner loadBannerDetail(UxsUserContext userContext, String bannerId) throws Exception{	
 		Banner banner = loadBanner( userContext, bannerId, allTokens());
 		return present(userContext,banner, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String bannerId) throws Exception{	
 		Banner banner = loadBanner( userContext, bannerId, viewTokens());
 		return present(userContext,banner, allTokens());
		
 	}
 	protected Banner saveBanner(UxsUserContext userContext, Banner banner, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getBannerDAO().save(banner, tokens);
 	}
 	protected Banner loadBanner(UxsUserContext userContext, String bannerId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().throwExceptionIfHasErrors( BannerManagerException.class);

 
 		return userContext.getDAOGroup().getBannerDAO().load(bannerId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Banner banner, Map<String, Object> tokens){
		super.addActions(userContext, banner, tokens);
		
		addAction(userContext, banner, tokens,"@create","createBanner","createBanner/","main","primary");
		addAction(userContext, banner, tokens,"@update","updateBanner","updateBanner/"+banner.getId()+"/","main","primary");
		addAction(userContext, banner, tokens,"@copy","cloneBanner","cloneBanner/"+banner.getId()+"/","main","primary");
		
		addAction(userContext, banner, tokens,"banner.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+banner.getId()+"/","main","primary");
		addAction(userContext, banner, tokens,"banner.addTarget","addTarget","addTarget/"+banner.getId()+"/","targetList","primary");
		addAction(userContext, banner, tokens,"banner.removeTarget","removeTarget","removeTarget/"+banner.getId()+"/","targetList","primary");
		addAction(userContext, banner, tokens,"banner.updateTarget","updateTarget","updateTarget/"+banner.getId()+"/","targetList","primary");
		addAction(userContext, banner, tokens,"banner.copyTargetFrom","copyTargetFrom","copyTargetFrom/"+banner.getId()+"/","targetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Banner banner, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Banner createBanner(UxsUserContext userContext,String name, String imagePath, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfBanner(name);
		userContext.getChecker().checkImagePathOfBanner(imagePath);
	
		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);


		Banner banner=createNewBanner();	

		banner.setName(name);
		banner.setImagePath(imagePath);
		banner.setLastUpdate(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		banner.setPlatform(platform);
		
		

		banner = saveBanner(userContext, banner, emptyOptions());
		
		onNewInstanceCreated(userContext, banner);
		return banner;

		
	}
	protected Banner createNewBanner() 
	{
		
		return new Banner();		
	}
	
	protected void checkParamsForUpdatingBanner(UxsUserContext userContext,String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().checkVersionOfBanner( bannerVersion);
		

		if(Banner.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfBanner(parseString(newValueExpr));
		}
		if(Banner.IMAGE_PATH_PROPERTY.equals(property)){
			userContext.getChecker().checkImagePathOfBanner(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);
	
		
	}
	
	
	
	public Banner clone(UxsUserContext userContext, String fromBannerId) throws Exception{
		
		return userContext.getDAOGroup().getBannerDAO().clone(fromBannerId, this.allTokens());
	}
	
	public Banner internalSaveBanner(UxsUserContext userContext, Banner banner) throws Exception 
	{
		return internalSaveBanner(userContext, banner, allTokens());

	}
	public Banner internalSaveBanner(UxsUserContext userContext, Banner banner, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingBanner(userContext, bannerId, bannerVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(banner){ 
			//will be good when the banner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Banner.
			
			
			banner = saveBanner(userContext, banner, options);
			return banner;
			
		}

	}
	
	public Banner updateBanner(UxsUserContext userContext,String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBanner(userContext, bannerId, bannerVersion, property, newValueExpr, tokensExpr);
		
		
		
		Banner banner = loadBanner(userContext, bannerId, allTokens());
		if(banner.getVersion() != bannerVersion){
			String message = "The target version("+banner.getVersion()+") is not equals to version("+bannerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(banner){ 
			//will be good when the banner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Banner.
			banner.updateLastUpdate(userContext.now());
			banner.changeProperty(property, newValueExpr);
			banner = saveBanner(userContext, banner, tokens().done());
			return present(userContext,banner, mergedAllTokens(tokensExpr));
			//return saveBanner(userContext, banner, tokens().done());
		}

	}
	
	public Banner updateBannerProperty(UxsUserContext userContext,String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBanner(userContext, bannerId, bannerVersion, property, newValueExpr, tokensExpr);
		
		Banner banner = loadBanner(userContext, bannerId, allTokens());
		if(banner.getVersion() != bannerVersion){
			String message = "The target version("+banner.getVersion()+") is not equals to version("+bannerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(banner){ 
			//will be good when the banner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Banner.
			
			banner.changeProperty(property, newValueExpr);
			banner.updateLastUpdate(userContext.now());
			banner = saveBanner(userContext, banner, tokens().done());
			return present(userContext,banner, mergedAllTokens(tokensExpr));
			//return saveBanner(userContext, banner, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected BannerTokens tokens(){
		return BannerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return BannerTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTargetListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return BannerTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(UxsUserContext userContext, String bannerId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfBanner(bannerId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);
 		
 	}
 	public Banner transferToAnotherPlatform(UxsUserContext userContext, String bannerId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, bannerId,anotherPlatformId);
 
		Banner banner = loadBanner(userContext, bannerId, allTokens());	
		synchronized(banner){
			//will be good when the banner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			banner.updatePlatform(platform);		
			banner = saveBanner(userContext, banner, emptyOptions());
			
			return present(userContext,banner, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForBanner(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(UxsUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String bannerId, int bannerVersion) throws Exception {
		//deleteInternal(userContext, bannerId, bannerVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String bannerId, int bannerVersion) throws Exception{
			
		userContext.getDAOGroup().getBannerDAO().delete(bannerId, bannerVersion);
	}
	
	public Banner forgetByAll(UxsUserContext userContext, String bannerId, int bannerVersion) throws Exception {
		return forgetByAllInternal(userContext, bannerId, bannerVersion);		
	}
	protected Banner forgetByAllInternal(UxsUserContext userContext,
			String bannerId, int bannerVersion) throws Exception{
			
		return userContext.getDAOGroup().getBannerDAO().disconnectFromAll(bannerId, bannerVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new BannerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getBannerDAO().deleteAll();
	}


	//disconnect Banner with profile in Target
	protected Banner breakWithTargetByProfile(UxsUserContext userContext, String bannerId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Banner banner = loadBanner(userContext, bannerId, allTokens());

			synchronized(banner){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBannerDAO().planToRemoveTargetListWithProfile(banner, profileId, this.emptyOptions());

				banner = saveBanner(userContext, banner, tokens().withTargetList().done());
				return banner;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTarget(UxsUserContext userContext, String bannerId, String name, String profileId, String location,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBanner(bannerId);

		
		userContext.getChecker().checkNameOfTarget(name);
		
		userContext.getChecker().checkProfileIdOfTarget(profileId);
		
		userContext.getChecker().checkLocationOfTarget(location);
	
		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);

	
	}
	public  Banner addTarget(UxsUserContext userContext, String bannerId, String name, String profileId, String location, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTarget(userContext,bannerId,name, profileId, location,tokensExpr);
		
		Target target = createTarget(userContext,name, profileId, location);
		
		Banner banner = loadBanner(userContext, bannerId, allTokens());
		synchronized(banner){ 
			//Will be good when the banner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			banner.addTarget( target );		
			banner = saveBanner(userContext, banner, tokens().withTargetList().done());
			
			userContext.getManagerGroup().getTargetManager().onNewInstanceCreated(userContext, target);
			return present(userContext,banner, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTargetProperties(UxsUserContext userContext, String bannerId,String id,String name,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().checkIdOfTarget(id);
		
		userContext.getChecker().checkNameOfTarget( name);
		userContext.getChecker().checkLocationOfTarget( location);

		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);
		
	}
	public  Banner updateTargetProperties(UxsUserContext userContext, String bannerId, String id,String name,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTargetProperties(userContext,bannerId,id,name,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTargetListList()
				.searchTargetListWith(Target.ID_PROPERTY, "is", id).done();
		
		Banner bannerToUpdate = loadBanner(userContext, bannerId, options);
		
		if(bannerToUpdate.getTargetList().isEmpty()){
			throw new BannerManagerException("Target is NOT FOUND with id: '"+id+"'");
		}
		
		Target item = bannerToUpdate.getTargetList().first();
		
		item.updateName( name );
		item.updateLocation( location );

		
		//checkParamsForAddingTarget(userContext,bannerId,name, code, used,tokensExpr);
		Banner banner = saveBanner(userContext, bannerToUpdate, tokens().withTargetList().done());
		synchronized(banner){ 
			return present(userContext,banner, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Target createTarget(UxsUserContext userContext, String name, String profileId, String location) throws Exception{

		Target target = new Target();
		
		
		target.setName(name);		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		target.setProfile(profile);		
		target.setLocation(location);		
		target.setLastUpdate(userContext.now());
	
		
		return target;
	
		
	}
	
	protected Target createIndexedTarget(String id, int version){

		Target target = new Target();
		target.setId(id);
		target.setVersion(version);
		return target;			
		
	}
	
	protected void checkParamsForRemovingTargetList(UxsUserContext userContext, String bannerId, 
			String targetIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBanner(bannerId);
		for(String targetId: targetIds){
			userContext.getChecker().checkIdOfTarget(targetId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);
		
	}
	public  Banner removeTargetList(UxsUserContext userContext, String bannerId, 
			String targetIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTargetList(userContext, bannerId,  targetIds, tokensExpr);
			
			
			Banner banner = loadBanner(userContext, bannerId, allTokens());
			synchronized(banner){ 
				//Will be good when the banner loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBannerDAO().planToRemoveTargetList(banner, targetIds, allTokens());
				banner = saveBanner(userContext, banner, tokens().withTargetList().done());
				deleteRelationListInGraph(userContext, banner.getTargetList());
				return present(userContext,banner, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTarget(UxsUserContext userContext, String bannerId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBanner( bannerId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);
	
	}
	public  Banner removeTarget(UxsUserContext userContext, String bannerId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTarget(userContext,bannerId, targetId, targetVersion,tokensExpr);
		
		Target target = createIndexedTarget(targetId, targetVersion);
		Banner banner = loadBanner(userContext, bannerId, allTokens());
		synchronized(banner){ 
			//Will be good when the banner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			banner.removeTarget( target );		
			banner = saveBanner(userContext, banner, tokens().withTargetList().done());
			deleteRelationInGraph(userContext, target);
			return present(userContext,banner, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTarget(UxsUserContext userContext, String bannerId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBanner( bannerId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);
	
	}
	public  Banner copyTargetFrom(UxsUserContext userContext, String bannerId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTarget(userContext,bannerId, targetId, targetVersion,tokensExpr);
		
		Target target = createIndexedTarget(targetId, targetVersion);
		Banner banner = loadBanner(userContext, bannerId, allTokens());
		synchronized(banner){ 
			//Will be good when the banner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			target.updateLastUpdate(userContext.now());
			
			banner.copyTargetFrom( target );		
			banner = saveBanner(userContext, banner, tokens().withTargetList().done());
			
			userContext.getManagerGroup().getTargetManager().onNewInstanceCreated(userContext, (Target)banner.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,banner, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTarget(UxsUserContext userContext, String bannerId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBanner(bannerId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		

		if(Target.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTarget(parseString(newValueExpr));
		}
		
		if(Target.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfTarget(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BannerManagerException.class);
	
	}
	
	public  Banner updateTarget(UxsUserContext userContext, String bannerId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTarget(userContext, bannerId, targetId, targetVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTargetList().searchTargetListWith(Target.ID_PROPERTY, "eq", targetId).done();
		
		
		
		Banner banner = loadBanner(userContext, bannerId, loadTokens);
		
		synchronized(banner){ 
			//Will be good when the banner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//banner.removeTarget( target );	
			//make changes to AcceleraterAccount.
			Target targetIndex = createIndexedTarget(targetId, targetVersion);
		
			Target target = banner.findTheTarget(targetIndex);
			if(target == null){
				throw new BannerManagerException(target+" is NOT FOUND" );
			}
			
			target.changeProperty(property, newValueExpr);
			target.updateLastUpdate(userContext.now());
			banner = saveBanner(userContext, banner, tokens().withTargetList().done());
			return present(userContext,banner, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UxsUserContext userContext, Banner newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


