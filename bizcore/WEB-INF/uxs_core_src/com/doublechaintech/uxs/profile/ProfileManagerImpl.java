
package com.doublechaintech.uxs.profile;

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

import com.doublechaintech.uxs.rating.Rating;
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.blog.Blog;

import com.doublechaintech.uxs.platform.CandidatePlatform;

import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.profile.Profile;






public class ProfileManagerImpl extends CustomUxsCheckerManager implements ProfileManager {
	
	private static final String SERVICE_TYPE = "Profile";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProfileManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProfileManagerException(message);

	}
	
	

 	protected Profile saveProfile(UxsUserContext userContext, Profile profile, String [] tokensExpr) throws Exception{	
 		//return getProfileDAO().save(profile, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfile(userContext, profile, tokens);
 	}
 	
 	protected Profile saveProfileDetail(UxsUserContext userContext, Profile profile) throws Exception{	

 		
 		return saveProfile(userContext, profile, allTokens());
 	}
 	
 	public Profile loadProfile(UxsUserContext userContext, String profileId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	
 	 public Profile searchProfile(UxsUserContext userContext, String profileId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	

 	protected Profile present(UxsUserContext userContext, Profile profile, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,profile,tokens);
		
		
		Profile  profileToPresent = userContext.getDAOGroup().getProfileDAO().present(profile, tokens);
		
		List<BaseEntity> entityListToNaming = profileToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProfileDAO().alias(entityListToNaming);
		
		return  profileToPresent;
		
		
	}
 
 	
 	
 	public Profile loadProfileDetail(UxsUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, allTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, viewTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	protected Profile saveProfile(UxsUserContext userContext, Profile profile, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProfileDAO().save(profile, tokens);
 	}
 	protected Profile loadProfile(UxsUserContext userContext, String profileId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 
 		return userContext.getDAOGroup().getProfileDAO().load(profileId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Profile profile, Map<String, Object> tokens){
		super.addActions(userContext, profile, tokens);
		
		addAction(userContext, profile, tokens,"@create","createProfile","createProfile/","main","primary");
		addAction(userContext, profile, tokens,"@update","updateProfile","updateProfile/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"@copy","cloneProfile","cloneProfile/"+profile.getId()+"/","main","primary");
		
		addAction(userContext, profile, tokens,"profile.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"profile.addTarget","addTarget","addTarget/"+profile.getId()+"/","targetList","primary");
		addAction(userContext, profile, tokens,"profile.removeTarget","removeTarget","removeTarget/"+profile.getId()+"/","targetList","primary");
		addAction(userContext, profile, tokens,"profile.updateTarget","updateTarget","updateTarget/"+profile.getId()+"/","targetList","primary");
		addAction(userContext, profile, tokens,"profile.copyTargetFrom","copyTargetFrom","copyTargetFrom/"+profile.getId()+"/","targetList","primary");
		addAction(userContext, profile, tokens,"profile.addRating","addRating","addRating/"+profile.getId()+"/","ratingList","primary");
		addAction(userContext, profile, tokens,"profile.removeRating","removeRating","removeRating/"+profile.getId()+"/","ratingList","primary");
		addAction(userContext, profile, tokens,"profile.updateRating","updateRating","updateRating/"+profile.getId()+"/","ratingList","primary");
		addAction(userContext, profile, tokens,"profile.copyRatingFrom","copyRatingFrom","copyRatingFrom/"+profile.getId()+"/","ratingList","primary");
		addAction(userContext, profile, tokens,"profile.addReview","addReview","addReview/"+profile.getId()+"/","reviewList","primary");
		addAction(userContext, profile, tokens,"profile.removeReview","removeReview","removeReview/"+profile.getId()+"/","reviewList","primary");
		addAction(userContext, profile, tokens,"profile.updateReview","updateReview","updateReview/"+profile.getId()+"/","reviewList","primary");
		addAction(userContext, profile, tokens,"profile.copyReviewFrom","copyReviewFrom","copyReviewFrom/"+profile.getId()+"/","reviewList","primary");
		addAction(userContext, profile, tokens,"profile.addBlog","addBlog","addBlog/"+profile.getId()+"/","blogList","primary");
		addAction(userContext, profile, tokens,"profile.removeBlog","removeBlog","removeBlog/"+profile.getId()+"/","blogList","primary");
		addAction(userContext, profile, tokens,"profile.updateBlog","updateBlog","updateBlog/"+profile.getId()+"/","blogList","primary");
		addAction(userContext, profile, tokens,"profile.copyBlogFrom","copyBlogFrom","copyBlogFrom/"+profile.getId()+"/","blogList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Profile profile, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Profile createProfile(UxsUserContext userContext,String name, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProfile(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);


		Profile profile=createNewProfile();	

		profile.setName(name);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		profile.setPlatform(platform);
		
		

		profile = saveProfile(userContext, profile, emptyOptions());
		
		onNewInstanceCreated(userContext, profile);
		return profile;

		
	}
	protected Profile createNewProfile() 
	{
		
		return new Profile();		
	}
	
	protected void checkParamsForUpdatingProfile(UxsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile( profileVersion);
		

		if(Profile.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProfile(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
		
	}
	
	
	
	public Profile clone(UxsUserContext userContext, String fromProfileId) throws Exception{
		
		return userContext.getDAOGroup().getProfileDAO().clone(fromProfileId, this.allTokens());
	}
	
	public Profile internalSaveProfile(UxsUserContext userContext, Profile profile) throws Exception 
	{
		return internalSaveProfile(userContext, profile, allTokens());

	}
	public Profile internalSaveProfile(UxsUserContext userContext, Profile profile, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			
			profile = saveProfile(userContext, profile, options);
			return profile;
			
		}

	}
	
	public Profile updateProfile(UxsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	
	public Profile updateProfileProperty(UxsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProfileTokens tokens(){
		return ProfileTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfileTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTargetListWith("id","desc")
		.sortRatingListWith("id","desc")
		.sortReviewListWith("id","desc")
		.sortBlogListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfileTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(UxsUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProfile(profileId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
 		
 	}
 	public Profile transferToAnotherPlatform(UxsUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, profileId,anotherPlatformId);
 
		Profile profile = loadProfile(userContext, profileId, allTokens());	
		synchronized(profile){
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			profile.updatePlatform(platform);		
			profile = saveProfile(userContext, profile, emptyOptions());
			
			return present(userContext,profile, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForProfile(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(UxsUserContext userContext, String profileId, int profileVersion) throws Exception {
		//deleteInternal(userContext, profileId, profileVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		userContext.getDAOGroup().getProfileDAO().delete(profileId, profileVersion);
	}
	
	public Profile forgetByAll(UxsUserContext userContext, String profileId, int profileVersion) throws Exception {
		return forgetByAllInternal(userContext, profileId, profileVersion);		
	}
	protected Profile forgetByAllInternal(UxsUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		return userContext.getDAOGroup().getProfileDAO().disconnectFromAll(profileId, profileVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfileManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProfileDAO().deleteAll();
	}


	//disconnect Profile with banner in Target
	protected Profile breakWithTargetByBanner(UxsUserContext userContext, String profileId, String bannerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTargetListWithBanner(profile, bannerId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTargetList().done());
				return profile;
			}
	}
	//disconnect Profile with product in Rating
	protected Profile breakWithRatingByProduct(UxsUserContext userContext, String profileId, String productId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRatingListWithProduct(profile, productId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRatingList().done());
				return profile;
			}
	}
	//disconnect Profile with product in Review
	protected Profile breakWithReviewByProduct(UxsUserContext userContext, String profileId, String productId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveReviewListWithProduct(profile, productId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withReviewList().done());
				return profile;
			}
	}
	//disconnect Profile with product in Blog
	protected Profile breakWithBlogByProduct(UxsUserContext userContext, String profileId, String productId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveBlogListWithProduct(profile, productId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withBlogList().done());
				return profile;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTarget(UxsUserContext userContext, String profileId, String name, String bannerId, String location,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfTarget(name);
		
		userContext.getChecker().checkBannerIdOfTarget(bannerId);
		
		userContext.getChecker().checkLocationOfTarget(location);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addTarget(UxsUserContext userContext, String profileId, String name, String bannerId, String location, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTarget(userContext,profileId,name, bannerId, location,tokensExpr);
		
		Target target = createTarget(userContext,name, bannerId, location);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addTarget( target );		
			profile = saveProfile(userContext, profile, tokens().withTargetList().done());
			
			userContext.getManagerGroup().getTargetManager().onNewInstanceCreated(userContext, target);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTargetProperties(UxsUserContext userContext, String profileId,String id,String name,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfTarget(id);
		
		userContext.getChecker().checkNameOfTarget( name);
		userContext.getChecker().checkLocationOfTarget( location);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateTargetProperties(UxsUserContext userContext, String profileId, String id,String name,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTargetProperties(userContext,profileId,id,name,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTargetListList()
				.searchTargetListWith(Target.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getTargetList().isEmpty()){
			throw new ProfileManagerException("Target is NOT FOUND with id: '"+id+"'");
		}
		
		Target item = profileToUpdate.getTargetList().first();
		
		item.updateName( name );
		item.updateLocation( location );

		
		//checkParamsForAddingTarget(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withTargetList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Target createTarget(UxsUserContext userContext, String name, String bannerId, String location) throws Exception{

		Target target = new Target();
		
		
		target.setName(name);		
		Banner  banner = new Banner();
		banner.setId(bannerId);		
		target.setBanner(banner);		
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
	
	protected void checkParamsForRemovingTargetList(UxsUserContext userContext, String profileId, 
			String targetIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String targetId: targetIds){
			userContext.getChecker().checkIdOfTarget(targetId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeTargetList(UxsUserContext userContext, String profileId, 
			String targetIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTargetList(userContext, profileId,  targetIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveTargetList(profile, targetIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withTargetList().done());
				deleteRelationListInGraph(userContext, profile.getTargetList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTarget(UxsUserContext userContext, String profileId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeTarget(UxsUserContext userContext, String profileId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTarget(userContext,profileId, targetId, targetVersion,tokensExpr);
		
		Target target = createIndexedTarget(targetId, targetVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeTarget( target );		
			profile = saveProfile(userContext, profile, tokens().withTargetList().done());
			deleteRelationInGraph(userContext, target);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTarget(UxsUserContext userContext, String profileId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyTargetFrom(UxsUserContext userContext, String profileId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTarget(userContext,profileId, targetId, targetVersion,tokensExpr);
		
		Target target = createIndexedTarget(targetId, targetVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			target.updateLastUpdate(userContext.now());
			
			profile.copyTargetFrom( target );		
			profile = saveProfile(userContext, profile, tokens().withTargetList().done());
			
			userContext.getManagerGroup().getTargetManager().onNewInstanceCreated(userContext, (Target)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTarget(UxsUserContext userContext, String profileId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		

		if(Target.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTarget(parseString(newValueExpr));
		}
		
		if(Target.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfTarget(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateTarget(UxsUserContext userContext, String profileId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTarget(userContext, profileId, targetId, targetVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTargetList().searchTargetListWith(Target.ID_PROPERTY, "eq", targetId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeTarget( target );	
			//make changes to AcceleraterAccount.
			Target targetIndex = createIndexedTarget(targetId, targetVersion);
		
			Target target = profile.findTheTarget(targetIndex);
			if(target == null){
				throw new ProfileManagerException(target+" is NOT FOUND" );
			}
			
			target.changeProperty(property, newValueExpr);
			target.updateLastUpdate(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withTargetList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRating(UxsUserContext userContext, String profileId, String productId, int score,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkProductIdOfRating(productId);
		
		userContext.getChecker().checkScoreOfRating(score);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addRating(UxsUserContext userContext, String profileId, String productId, int score, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRating(userContext,profileId,productId, score,tokensExpr);
		
		Rating rating = createRating(userContext,productId, score);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addRating( rating );		
			profile = saveProfile(userContext, profile, tokens().withRatingList().done());
			
			userContext.getManagerGroup().getRatingManager().onNewInstanceCreated(userContext, rating);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRatingProperties(UxsUserContext userContext, String profileId,String id,int score,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfRating(id);
		
		userContext.getChecker().checkScoreOfRating( score);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateRatingProperties(UxsUserContext userContext, String profileId, String id,int score, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRatingProperties(userContext,profileId,id,score,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRatingListList()
				.searchRatingListWith(Rating.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getRatingList().isEmpty()){
			throw new ProfileManagerException("Rating is NOT FOUND with id: '"+id+"'");
		}
		
		Rating item = profileToUpdate.getRatingList().first();
		
		item.updateScore( score );

		
		//checkParamsForAddingRating(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withRatingList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Rating createRating(UxsUserContext userContext, String productId, int score) throws Exception{

		Rating rating = new Rating();
		
		
		Product  product = new Product();
		product.setId(productId);		
		rating.setProduct(product);		
		rating.setScore(score);		
		rating.setUpdateTime(userContext.now());
	
		
		return rating;
	
		
	}
	
	protected Rating createIndexedRating(String id, int version){

		Rating rating = new Rating();
		rating.setId(id);
		rating.setVersion(version);
		return rating;			
		
	}
	
	protected void checkParamsForRemovingRatingList(UxsUserContext userContext, String profileId, 
			String ratingIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String ratingId: ratingIds){
			userContext.getChecker().checkIdOfRating(ratingId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeRatingList(UxsUserContext userContext, String profileId, 
			String ratingIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRatingList(userContext, profileId,  ratingIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveRatingList(profile, ratingIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withRatingList().done());
				deleteRelationListInGraph(userContext, profile.getRatingList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRating(UxsUserContext userContext, String profileId, 
		String ratingId, int ratingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().checkVersionOfRating(ratingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeRating(UxsUserContext userContext, String profileId, 
		String ratingId, int ratingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRating(userContext,profileId, ratingId, ratingVersion,tokensExpr);
		
		Rating rating = createIndexedRating(ratingId, ratingVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeRating( rating );		
			profile = saveProfile(userContext, profile, tokens().withRatingList().done());
			deleteRelationInGraph(userContext, rating);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRating(UxsUserContext userContext, String profileId, 
		String ratingId, int ratingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().checkVersionOfRating(ratingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyRatingFrom(UxsUserContext userContext, String profileId, 
		String ratingId, int ratingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRating(userContext,profileId, ratingId, ratingVersion,tokensExpr);
		
		Rating rating = createIndexedRating(ratingId, ratingVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			rating.updateUpdateTime(userContext.now());
			
			profile.copyRatingFrom( rating );		
			profile = saveProfile(userContext, profile, tokens().withRatingList().done());
			
			userContext.getManagerGroup().getRatingManager().onNewInstanceCreated(userContext, (Rating)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRating(UxsUserContext userContext, String profileId, String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().checkVersionOfRating(ratingVersion);
		

		if(Rating.SCORE_PROPERTY.equals(property)){
			userContext.getChecker().checkScoreOfRating(parseInt(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateRating(UxsUserContext userContext, String profileId, String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRating(userContext, profileId, ratingId, ratingVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRatingList().searchRatingListWith(Rating.ID_PROPERTY, "eq", ratingId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeRating( rating );	
			//make changes to AcceleraterAccount.
			Rating ratingIndex = createIndexedRating(ratingId, ratingVersion);
		
			Rating rating = profile.findTheRating(ratingIndex);
			if(rating == null){
				throw new ProfileManagerException(rating+" is NOT FOUND" );
			}
			
			rating.changeProperty(property, newValueExpr);
			rating.updateUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withRatingList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingReview(UxsUserContext userContext, String profileId, String title, String content, String productId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkTitleOfReview(title);
		
		userContext.getChecker().checkContentOfReview(content);
		
		userContext.getChecker().checkProductIdOfReview(productId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addReview(UxsUserContext userContext, String profileId, String title, String content, String productId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingReview(userContext,profileId,title, content, productId,tokensExpr);
		
		Review review = createReview(userContext,title, content, productId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addReview( review );		
			profile = saveProfile(userContext, profile, tokens().withReviewList().done());
			
			userContext.getManagerGroup().getReviewManager().onNewInstanceCreated(userContext, review);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingReviewProperties(UxsUserContext userContext, String profileId,String id,String title,String content,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfReview(id);
		
		userContext.getChecker().checkTitleOfReview( title);
		userContext.getChecker().checkContentOfReview( content);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateReviewProperties(UxsUserContext userContext, String profileId, String id,String title,String content, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingReviewProperties(userContext,profileId,id,title,content,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withReviewListList()
				.searchReviewListWith(Review.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getReviewList().isEmpty()){
			throw new ProfileManagerException("Review is NOT FOUND with id: '"+id+"'");
		}
		
		Review item = profileToUpdate.getReviewList().first();
		
		item.updateTitle( title );
		item.updateContent( content );

		
		//checkParamsForAddingReview(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withReviewList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Review createReview(UxsUserContext userContext, String title, String content, String productId) throws Exception{

		Review review = new Review();
		
		
		review.setTitle(title);		
		review.setContent(content);		
		Product  product = new Product();
		product.setId(productId);		
		review.setProduct(product);		
		review.setUpdateTime(userContext.now());
	
		
		return review;
	
		
	}
	
	protected Review createIndexedReview(String id, int version){

		Review review = new Review();
		review.setId(id);
		review.setVersion(version);
		return review;			
		
	}
	
	protected void checkParamsForRemovingReviewList(UxsUserContext userContext, String profileId, 
			String reviewIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String reviewId: reviewIds){
			userContext.getChecker().checkIdOfReview(reviewId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeReviewList(UxsUserContext userContext, String profileId, 
			String reviewIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingReviewList(userContext, profileId,  reviewIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveReviewList(profile, reviewIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withReviewList().done());
				deleteRelationListInGraph(userContext, profile.getReviewList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingReview(UxsUserContext userContext, String profileId, 
		String reviewId, int reviewVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().checkVersionOfReview(reviewVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeReview(UxsUserContext userContext, String profileId, 
		String reviewId, int reviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingReview(userContext,profileId, reviewId, reviewVersion,tokensExpr);
		
		Review review = createIndexedReview(reviewId, reviewVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeReview( review );		
			profile = saveProfile(userContext, profile, tokens().withReviewList().done());
			deleteRelationInGraph(userContext, review);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingReview(UxsUserContext userContext, String profileId, 
		String reviewId, int reviewVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().checkVersionOfReview(reviewVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyReviewFrom(UxsUserContext userContext, String profileId, 
		String reviewId, int reviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingReview(userContext,profileId, reviewId, reviewVersion,tokensExpr);
		
		Review review = createIndexedReview(reviewId, reviewVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			review.updateUpdateTime(userContext.now());
			
			profile.copyReviewFrom( review );		
			profile = saveProfile(userContext, profile, tokens().withReviewList().done());
			
			userContext.getManagerGroup().getReviewManager().onNewInstanceCreated(userContext, (Review)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingReview(UxsUserContext userContext, String profileId, String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().checkVersionOfReview(reviewVersion);
		

		if(Review.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfReview(parseString(newValueExpr));
		}
		
		if(Review.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfReview(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateReview(UxsUserContext userContext, String profileId, String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingReview(userContext, profileId, reviewId, reviewVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withReviewList().searchReviewListWith(Review.ID_PROPERTY, "eq", reviewId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeReview( review );	
			//make changes to AcceleraterAccount.
			Review reviewIndex = createIndexedReview(reviewId, reviewVersion);
		
			Review review = profile.findTheReview(reviewIndex);
			if(review == null){
				throw new ProfileManagerException(review+" is NOT FOUND" );
			}
			
			review.changeProperty(property, newValueExpr);
			review.updateUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withReviewList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingBlog(UxsUserContext userContext, String profileId, String title, String content, String productId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkTitleOfBlog(title);
		
		userContext.getChecker().checkContentOfBlog(content);
		
		userContext.getChecker().checkProductIdOfBlog(productId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addBlog(UxsUserContext userContext, String profileId, String title, String content, String productId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingBlog(userContext,profileId,title, content, productId,tokensExpr);
		
		Blog blog = createBlog(userContext,title, content, productId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addBlog( blog );		
			profile = saveProfile(userContext, profile, tokens().withBlogList().done());
			
			userContext.getManagerGroup().getBlogManager().onNewInstanceCreated(userContext, blog);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingBlogProperties(UxsUserContext userContext, String profileId,String id,String title,String content,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfBlog(id);
		
		userContext.getChecker().checkTitleOfBlog( title);
		userContext.getChecker().checkContentOfBlog( content);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateBlogProperties(UxsUserContext userContext, String profileId, String id,String title,String content, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingBlogProperties(userContext,profileId,id,title,content,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withBlogListList()
				.searchBlogListWith(Blog.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getBlogList().isEmpty()){
			throw new ProfileManagerException("Blog is NOT FOUND with id: '"+id+"'");
		}
		
		Blog item = profileToUpdate.getBlogList().first();
		
		item.updateTitle( title );
		item.updateContent( content );

		
		//checkParamsForAddingBlog(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withBlogList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Blog createBlog(UxsUserContext userContext, String title, String content, String productId) throws Exception{

		Blog blog = new Blog();
		
		
		blog.setTitle(title);		
		blog.setContent(content);		
		Product  product = new Product();
		product.setId(productId);		
		blog.setProduct(product);		
		blog.setUpdateTime(userContext.now());
	
		
		return blog;
	
		
	}
	
	protected Blog createIndexedBlog(String id, int version){

		Blog blog = new Blog();
		blog.setId(id);
		blog.setVersion(version);
		return blog;			
		
	}
	
	protected void checkParamsForRemovingBlogList(UxsUserContext userContext, String profileId, 
			String blogIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String blogId: blogIds){
			userContext.getChecker().checkIdOfBlog(blogId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeBlogList(UxsUserContext userContext, String profileId, 
			String blogIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingBlogList(userContext, profileId,  blogIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveBlogList(profile, blogIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withBlogList().done());
				deleteRelationListInGraph(userContext, profile.getBlogList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingBlog(UxsUserContext userContext, String profileId, 
		String blogId, int blogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().checkVersionOfBlog(blogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeBlog(UxsUserContext userContext, String profileId, 
		String blogId, int blogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingBlog(userContext,profileId, blogId, blogVersion,tokensExpr);
		
		Blog blog = createIndexedBlog(blogId, blogVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeBlog( blog );		
			profile = saveProfile(userContext, profile, tokens().withBlogList().done());
			deleteRelationInGraph(userContext, blog);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingBlog(UxsUserContext userContext, String profileId, 
		String blogId, int blogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().checkVersionOfBlog(blogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyBlogFrom(UxsUserContext userContext, String profileId, 
		String blogId, int blogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingBlog(userContext,profileId, blogId, blogVersion,tokensExpr);
		
		Blog blog = createIndexedBlog(blogId, blogVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			blog.updateUpdateTime(userContext.now());
			
			profile.copyBlogFrom( blog );		
			profile = saveProfile(userContext, profile, tokens().withBlogList().done());
			
			userContext.getManagerGroup().getBlogManager().onNewInstanceCreated(userContext, (Blog)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingBlog(UxsUserContext userContext, String profileId, String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().checkVersionOfBlog(blogVersion);
		

		if(Blog.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfBlog(parseString(newValueExpr));
		}
		
		if(Blog.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfBlog(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateBlog(UxsUserContext userContext, String profileId, String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingBlog(userContext, profileId, blogId, blogVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withBlogList().searchBlogListWith(Blog.ID_PROPERTY, "eq", blogId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeBlog( blog );	
			//make changes to AcceleraterAccount.
			Blog blogIndex = createIndexedBlog(blogId, blogVersion);
		
			Blog blog = profile.findTheBlog(blogIndex);
			if(blog == null){
				throw new ProfileManagerException(blog+" is NOT FOUND" );
			}
			
			blog.changeProperty(property, newValueExpr);
			blog.updateUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withBlogList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UxsUserContext userContext, Profile newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


