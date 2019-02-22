
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
import com.doublechaintech.uxs.pricefilter.PriceFilter;
import com.doublechaintech.uxs.useralert.UserAlert;
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.brandfilter.BrandFilter;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;
import com.doublechaintech.uxs.blog.Blog;
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.categoryfilter.CategoryFilter;

import com.doublechaintech.uxs.platform.CandidatePlatform;

import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;






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
		addAction(userContext, profile, tokens,"profile.addUserAlert","addUserAlert","addUserAlert/"+profile.getId()+"/","userAlertList","primary");
		addAction(userContext, profile, tokens,"profile.removeUserAlert","removeUserAlert","removeUserAlert/"+profile.getId()+"/","userAlertList","primary");
		addAction(userContext, profile, tokens,"profile.updateUserAlert","updateUserAlert","updateUserAlert/"+profile.getId()+"/","userAlertList","primary");
		addAction(userContext, profile, tokens,"profile.copyUserAlertFrom","copyUserAlertFrom","copyUserAlertFrom/"+profile.getId()+"/","userAlertList","primary");
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
		addAction(userContext, profile, tokens,"profile.addBrandFilter","addBrandFilter","addBrandFilter/"+profile.getId()+"/","brandFilterList","primary");
		addAction(userContext, profile, tokens,"profile.removeBrandFilter","removeBrandFilter","removeBrandFilter/"+profile.getId()+"/","brandFilterList","primary");
		addAction(userContext, profile, tokens,"profile.updateBrandFilter","updateBrandFilter","updateBrandFilter/"+profile.getId()+"/","brandFilterList","primary");
		addAction(userContext, profile, tokens,"profile.copyBrandFilterFrom","copyBrandFilterFrom","copyBrandFilterFrom/"+profile.getId()+"/","brandFilterList","primary");
		addAction(userContext, profile, tokens,"profile.addPriceFilter","addPriceFilter","addPriceFilter/"+profile.getId()+"/","priceFilterList","primary");
		addAction(userContext, profile, tokens,"profile.removePriceFilter","removePriceFilter","removePriceFilter/"+profile.getId()+"/","priceFilterList","primary");
		addAction(userContext, profile, tokens,"profile.updatePriceFilter","updatePriceFilter","updatePriceFilter/"+profile.getId()+"/","priceFilterList","primary");
		addAction(userContext, profile, tokens,"profile.copyPriceFilterFrom","copyPriceFilterFrom","copyPriceFilterFrom/"+profile.getId()+"/","priceFilterList","primary");
		addAction(userContext, profile, tokens,"profile.addCategoryFilter","addCategoryFilter","addCategoryFilter/"+profile.getId()+"/","categoryFilterList","primary");
		addAction(userContext, profile, tokens,"profile.removeCategoryFilter","removeCategoryFilter","removeCategoryFilter/"+profile.getId()+"/","categoryFilterList","primary");
		addAction(userContext, profile, tokens,"profile.updateCategoryFilter","updateCategoryFilter","updateCategoryFilter/"+profile.getId()+"/","categoryFilterList","primary");
		addAction(userContext, profile, tokens,"profile.copyCategoryFilterFrom","copyCategoryFilterFrom","copyCategoryFilterFrom/"+profile.getId()+"/","categoryFilterList","primary");
		addAction(userContext, profile, tokens,"profile.addNewProduct","addNewProduct","addNewProduct/"+profile.getId()+"/","newProductList","primary");
		addAction(userContext, profile, tokens,"profile.removeNewProduct","removeNewProduct","removeNewProduct/"+profile.getId()+"/","newProductList","primary");
		addAction(userContext, profile, tokens,"profile.updateNewProduct","updateNewProduct","updateNewProduct/"+profile.getId()+"/","newProductList","primary");
		addAction(userContext, profile, tokens,"profile.copyNewProductFrom","copyNewProductFrom","copyNewProductFrom/"+profile.getId()+"/","newProductList","primary");
		addAction(userContext, profile, tokens,"profile.addEditorPickProduct","addEditorPickProduct","addEditorPickProduct/"+profile.getId()+"/","editorPickProductList","primary");
		addAction(userContext, profile, tokens,"profile.removeEditorPickProduct","removeEditorPickProduct","removeEditorPickProduct/"+profile.getId()+"/","editorPickProductList","primary");
		addAction(userContext, profile, tokens,"profile.updateEditorPickProduct","updateEditorPickProduct","updateEditorPickProduct/"+profile.getId()+"/","editorPickProductList","primary");
		addAction(userContext, profile, tokens,"profile.copyEditorPickProductFrom","copyEditorPickProductFrom","copyEditorPickProductFrom/"+profile.getId()+"/","editorPickProductList","primary");
		addAction(userContext, profile, tokens,"profile.addTopRatedProduct","addTopRatedProduct","addTopRatedProduct/"+profile.getId()+"/","topRatedProductList","primary");
		addAction(userContext, profile, tokens,"profile.removeTopRatedProduct","removeTopRatedProduct","removeTopRatedProduct/"+profile.getId()+"/","topRatedProductList","primary");
		addAction(userContext, profile, tokens,"profile.updateTopRatedProduct","updateTopRatedProduct","updateTopRatedProduct/"+profile.getId()+"/","topRatedProductList","primary");
		addAction(userContext, profile, tokens,"profile.copyTopRatedProductFrom","copyTopRatedProductFrom","copyTopRatedProductFrom/"+profile.getId()+"/","topRatedProductList","primary");
		addAction(userContext, profile, tokens,"profile.addRecommandProduct","addRecommandProduct","addRecommandProduct/"+profile.getId()+"/","recommandProductList","primary");
		addAction(userContext, profile, tokens,"profile.removeRecommandProduct","removeRecommandProduct","removeRecommandProduct/"+profile.getId()+"/","recommandProductList","primary");
		addAction(userContext, profile, tokens,"profile.updateRecommandProduct","updateRecommandProduct","updateRecommandProduct/"+profile.getId()+"/","recommandProductList","primary");
		addAction(userContext, profile, tokens,"profile.copyRecommandProductFrom","copyRecommandProductFrom","copyRecommandProductFrom/"+profile.getId()+"/","recommandProductList","primary");
	
		
		
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
		.sortUserAlertListWith("id","desc")
		.sortTargetListWith("id","desc")
		.sortRatingListWith("id","desc")
		.sortReviewListWith("id","desc")
		.sortBlogListWith("id","desc")
		.sortBrandFilterListWith("id","desc")
		.sortPriceFilterListWith("id","desc")
		.sortCategoryFilterListWith("id","desc")
		.sortNewProductListWith("id","desc")
		.sortEditorPickProductListWith("id","desc")
		.sortTopRatedProductListWith("id","desc")
		.sortRecommandProductListWith("id","desc")
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


	//disconnect Profile with platform in UserAlert
	protected Profile breakWithUserAlertByPlatform(UxsUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveUserAlertListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
				return profile;
			}
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
	//disconnect Profile with internal_id in BrandFilter
	protected Profile breakWithBrandFilterByInternalId(UxsUserContext userContext, String profileId, String internalIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveBrandFilterListWithInternalId(profile, internalIdId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
				return profile;
			}
	}
	//disconnect Profile with internal_id in CategoryFilter
	protected Profile breakWithCategoryFilterByInternalId(UxsUserContext userContext, String profileId, String internalIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveCategoryFilterListWithInternalId(profile, internalIdId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
				return profile;
			}
	}
	//disconnect Profile with parent_category in NewProduct
	protected Profile breakWithNewProductByParentCategory(UxsUserContext userContext, String profileId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductListWithParentCategory(profile, parentCategoryId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				return profile;
			}
	}
	//disconnect Profile with brand in NewProduct
	protected Profile breakWithNewProductByBrand(UxsUserContext userContext, String profileId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductListWithBrand(profile, brandId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				return profile;
			}
	}
	//disconnect Profile with catalog in NewProduct
	protected Profile breakWithNewProductByCatalog(UxsUserContext userContext, String profileId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductListWithCatalog(profile, catalogId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in NewProduct
	protected Profile breakWithNewProductByPlatform(UxsUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				return profile;
			}
	}
	//disconnect Profile with parent_category in EditorPickProduct
	protected Profile breakWithEditorPickProductByParentCategory(UxsUserContext userContext, String profileId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductListWithParentCategory(profile, parentCategoryId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				return profile;
			}
	}
	//disconnect Profile with brand in EditorPickProduct
	protected Profile breakWithEditorPickProductByBrand(UxsUserContext userContext, String profileId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductListWithBrand(profile, brandId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				return profile;
			}
	}
	//disconnect Profile with catalog in EditorPickProduct
	protected Profile breakWithEditorPickProductByCatalog(UxsUserContext userContext, String profileId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductListWithCatalog(profile, catalogId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in EditorPickProduct
	protected Profile breakWithEditorPickProductByPlatform(UxsUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				return profile;
			}
	}
	//disconnect Profile with parent_category in TopRatedProduct
	protected Profile breakWithTopRatedProductByParentCategory(UxsUserContext userContext, String profileId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductListWithParentCategory(profile, parentCategoryId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				return profile;
			}
	}
	//disconnect Profile with brand in TopRatedProduct
	protected Profile breakWithTopRatedProductByBrand(UxsUserContext userContext, String profileId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductListWithBrand(profile, brandId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				return profile;
			}
	}
	//disconnect Profile with catalog in TopRatedProduct
	protected Profile breakWithTopRatedProductByCatalog(UxsUserContext userContext, String profileId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductListWithCatalog(profile, catalogId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in TopRatedProduct
	protected Profile breakWithTopRatedProductByPlatform(UxsUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				return profile;
			}
	}
	//disconnect Profile with parent_category in RecommandProduct
	protected Profile breakWithRecommandProductByParentCategory(UxsUserContext userContext, String profileId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductListWithParentCategory(profile, parentCategoryId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				return profile;
			}
	}
	//disconnect Profile with brand in RecommandProduct
	protected Profile breakWithRecommandProductByBrand(UxsUserContext userContext, String profileId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductListWithBrand(profile, brandId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				return profile;
			}
	}
	//disconnect Profile with catalog in RecommandProduct
	protected Profile breakWithRecommandProductByCatalog(UxsUserContext userContext, String profileId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductListWithCatalog(profile, catalogId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in RecommandProduct
	protected Profile breakWithRecommandProductByPlatform(UxsUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				return profile;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingUserAlert(UxsUserContext userContext, String profileId, String message, String location, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkMessageOfUserAlert(message);
		
		userContext.getChecker().checkLocationOfUserAlert(location);
		
		userContext.getChecker().checkPlatformIdOfUserAlert(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addUserAlert(UxsUserContext userContext, String profileId, String message, String location, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserAlert(userContext,profileId,message, location, platformId,tokensExpr);
		
		UserAlert userAlert = createUserAlert(userContext,message, location, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addUserAlert( userAlert );		
			profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
			
			userContext.getManagerGroup().getUserAlertManager().onNewInstanceCreated(userContext, userAlert);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAlertProperties(UxsUserContext userContext, String profileId,String id,String message,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfUserAlert(id);
		
		userContext.getChecker().checkMessageOfUserAlert( message);
		userContext.getChecker().checkLocationOfUserAlert( location);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateUserAlertProperties(UxsUserContext userContext, String profileId, String id,String message,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingUserAlertProperties(userContext,profileId,id,message,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAlertListList()
				.searchUserAlertListWith(UserAlert.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getUserAlertList().isEmpty()){
			throw new ProfileManagerException("UserAlert is NOT FOUND with id: '"+id+"'");
		}
		
		UserAlert item = profileToUpdate.getUserAlertList().first();
		
		item.updateMessage( message );
		item.updateLocation( location );

		
		//checkParamsForAddingUserAlert(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withUserAlertList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected UserAlert createUserAlert(UxsUserContext userContext, String message, String location, String platformId) throws Exception{

		UserAlert userAlert = new UserAlert();
		
		
		userAlert.setMessage(message);		
		userAlert.setLocation(location);		
		userAlert.setLastUpdate(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		userAlert.setPlatform(platform);
	
		
		return userAlert;
	
		
	}
	
	protected UserAlert createIndexedUserAlert(String id, int version){

		UserAlert userAlert = new UserAlert();
		userAlert.setId(id);
		userAlert.setVersion(version);
		return userAlert;			
		
	}
	
	protected void checkParamsForRemovingUserAlertList(UxsUserContext userContext, String profileId, 
			String userAlertIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String userAlertId: userAlertIds){
			userContext.getChecker().checkIdOfUserAlert(userAlertId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeUserAlertList(UxsUserContext userContext, String profileId, 
			String userAlertIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingUserAlertList(userContext, profileId,  userAlertIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveUserAlertList(profile, userAlertIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
				deleteRelationListInGraph(userContext, profile.getUserAlertList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingUserAlert(UxsUserContext userContext, String profileId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeUserAlert(UxsUserContext userContext, String profileId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserAlert(userContext,profileId, userAlertId, userAlertVersion,tokensExpr);
		
		UserAlert userAlert = createIndexedUserAlert(userAlertId, userAlertVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeUserAlert( userAlert );		
			profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
			deleteRelationInGraph(userContext, userAlert);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingUserAlert(UxsUserContext userContext, String profileId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyUserAlertFrom(UxsUserContext userContext, String profileId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserAlert(userContext,profileId, userAlertId, userAlertVersion,tokensExpr);
		
		UserAlert userAlert = createIndexedUserAlert(userAlertId, userAlertVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			userAlert.updateLastUpdate(userContext.now());
			
			profile.copyUserAlertFrom( userAlert );		
			profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
			
			userContext.getManagerGroup().getUserAlertManager().onNewInstanceCreated(userContext, (UserAlert)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingUserAlert(UxsUserContext userContext, String profileId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		

		if(UserAlert.MESSAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkMessageOfUserAlert(parseString(newValueExpr));
		}
		
		if(UserAlert.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfUserAlert(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateUserAlert(UxsUserContext userContext, String profileId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserAlert(userContext, profileId, userAlertId, userAlertVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withUserAlertList().searchUserAlertListWith(UserAlert.ID_PROPERTY, "eq", userAlertId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeUserAlert( userAlert );	
			//make changes to AcceleraterAccount.
			UserAlert userAlertIndex = createIndexedUserAlert(userAlertId, userAlertVersion);
		
			UserAlert userAlert = profile.findTheUserAlert(userAlertIndex);
			if(userAlert == null){
				throw new ProfileManagerException(userAlert+" is NOT FOUND" );
			}
			
			userAlert.changeProperty(property, newValueExpr);
			userAlert.updateLastUpdate(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



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
	



	protected void checkParamsForAddingBrandFilter(UxsUserContext userContext, String profileId, String name, String internalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfBrandFilter(name);
		
		userContext.getChecker().checkInternalIdOfBrandFilter(internalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addBrandFilter(UxsUserContext userContext, String profileId, String name, String internalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingBrandFilter(userContext,profileId,name, internalId,tokensExpr);
		
		BrandFilter brandFilter = createBrandFilter(userContext,name, internalId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addBrandFilter( brandFilter );		
			profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
			
			userContext.getManagerGroup().getBrandFilterManager().onNewInstanceCreated(userContext, brandFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingBrandFilterProperties(UxsUserContext userContext, String profileId,String id,String name,String internalId,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfBrandFilter(id);
		
		userContext.getChecker().checkNameOfBrandFilter( name);
		userContext.getChecker().checkInternalIdOfBrandFilter( internalId);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateBrandFilterProperties(UxsUserContext userContext, String profileId, String id,String name,String internalId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingBrandFilterProperties(userContext,profileId,id,name,internalId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withBrandFilterListList()
				.searchBrandFilterListWith(BrandFilter.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getBrandFilterList().isEmpty()){
			throw new ProfileManagerException("BrandFilter is NOT FOUND with id: '"+id+"'");
		}
		
		BrandFilter item = profileToUpdate.getBrandFilterList().first();
		
		item.updateName( name );
		item.updateInternalId( internalId );

		
		//checkParamsForAddingBrandFilter(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withBrandFilterList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected BrandFilter createBrandFilter(UxsUserContext userContext, String name, String internalId) throws Exception{

		BrandFilter brandFilter = new BrandFilter();
		
		
		brandFilter.setName(name);		
		brandFilter.setInternalId(internalId);
	
		
		return brandFilter;
	
		
	}
	
	protected BrandFilter createIndexedBrandFilter(String id, int version){

		BrandFilter brandFilter = new BrandFilter();
		brandFilter.setId(id);
		brandFilter.setVersion(version);
		return brandFilter;			
		
	}
	
	protected void checkParamsForRemovingBrandFilterList(UxsUserContext userContext, String profileId, 
			String brandFilterIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String brandFilterId: brandFilterIds){
			userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeBrandFilterList(UxsUserContext userContext, String profileId, 
			String brandFilterIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingBrandFilterList(userContext, profileId,  brandFilterIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveBrandFilterList(profile, brandFilterIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
				deleteRelationListInGraph(userContext, profile.getBrandFilterList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingBrandFilter(UxsUserContext userContext, String profileId, 
		String brandFilterId, int brandFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().checkVersionOfBrandFilter(brandFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeBrandFilter(UxsUserContext userContext, String profileId, 
		String brandFilterId, int brandFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingBrandFilter(userContext,profileId, brandFilterId, brandFilterVersion,tokensExpr);
		
		BrandFilter brandFilter = createIndexedBrandFilter(brandFilterId, brandFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeBrandFilter( brandFilter );		
			profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
			deleteRelationInGraph(userContext, brandFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingBrandFilter(UxsUserContext userContext, String profileId, 
		String brandFilterId, int brandFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().checkVersionOfBrandFilter(brandFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyBrandFilterFrom(UxsUserContext userContext, String profileId, 
		String brandFilterId, int brandFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingBrandFilter(userContext,profileId, brandFilterId, brandFilterVersion,tokensExpr);
		
		BrandFilter brandFilter = createIndexedBrandFilter(brandFilterId, brandFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			profile.copyBrandFilterFrom( brandFilter );		
			profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
			
			userContext.getManagerGroup().getBrandFilterManager().onNewInstanceCreated(userContext, (BrandFilter)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingBrandFilter(UxsUserContext userContext, String profileId, String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfBrandFilter(brandFilterId);
		userContext.getChecker().checkVersionOfBrandFilter(brandFilterVersion);
		

		if(BrandFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfBrandFilter(parseString(newValueExpr));
		}
		
		if(BrandFilter.INTERNAL_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalIdOfBrandFilter(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateBrandFilter(UxsUserContext userContext, String profileId, String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingBrandFilter(userContext, profileId, brandFilterId, brandFilterVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withBrandFilterList().searchBrandFilterListWith(BrandFilter.ID_PROPERTY, "eq", brandFilterId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeBrandFilter( brandFilter );	
			//make changes to AcceleraterAccount.
			BrandFilter brandFilterIndex = createIndexedBrandFilter(brandFilterId, brandFilterVersion);
		
			BrandFilter brandFilter = profile.findTheBrandFilter(brandFilterIndex);
			if(brandFilter == null){
				throw new ProfileManagerException(brandFilter+" is NOT FOUND" );
			}
			
			brandFilter.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().withBrandFilterList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingPriceFilter(UxsUserContext userContext, String profileId, String name, BigDecimal priceStart, BigDecimal priceEnd,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfPriceFilter(name);
		
		userContext.getChecker().checkPriceStartOfPriceFilter(priceStart);
		
		userContext.getChecker().checkPriceEndOfPriceFilter(priceEnd);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addPriceFilter(UxsUserContext userContext, String profileId, String name, BigDecimal priceStart, BigDecimal priceEnd, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPriceFilter(userContext,profileId,name, priceStart, priceEnd,tokensExpr);
		
		PriceFilter priceFilter = createPriceFilter(userContext,name, priceStart, priceEnd);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addPriceFilter( priceFilter );		
			profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
			
			userContext.getManagerGroup().getPriceFilterManager().onNewInstanceCreated(userContext, priceFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPriceFilterProperties(UxsUserContext userContext, String profileId,String id,String name,BigDecimal priceStart,BigDecimal priceEnd,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfPriceFilter(id);
		
		userContext.getChecker().checkNameOfPriceFilter( name);
		userContext.getChecker().checkPriceStartOfPriceFilter( priceStart);
		userContext.getChecker().checkPriceEndOfPriceFilter( priceEnd);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updatePriceFilterProperties(UxsUserContext userContext, String profileId, String id,String name,BigDecimal priceStart,BigDecimal priceEnd, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingPriceFilterProperties(userContext,profileId,id,name,priceStart,priceEnd,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPriceFilterListList()
				.searchPriceFilterListWith(PriceFilter.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getPriceFilterList().isEmpty()){
			throw new ProfileManagerException("PriceFilter is NOT FOUND with id: '"+id+"'");
		}
		
		PriceFilter item = profileToUpdate.getPriceFilterList().first();
		
		item.updateName( name );
		item.updatePriceStart( priceStart );
		item.updatePriceEnd( priceEnd );

		
		//checkParamsForAddingPriceFilter(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withPriceFilterList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected PriceFilter createPriceFilter(UxsUserContext userContext, String name, BigDecimal priceStart, BigDecimal priceEnd) throws Exception{

		PriceFilter priceFilter = new PriceFilter();
		
		
		priceFilter.setName(name);		
		priceFilter.setPriceStart(priceStart);		
		priceFilter.setPriceEnd(priceEnd);
	
		
		return priceFilter;
	
		
	}
	
	protected PriceFilter createIndexedPriceFilter(String id, int version){

		PriceFilter priceFilter = new PriceFilter();
		priceFilter.setId(id);
		priceFilter.setVersion(version);
		return priceFilter;			
		
	}
	
	protected void checkParamsForRemovingPriceFilterList(UxsUserContext userContext, String profileId, 
			String priceFilterIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String priceFilterId: priceFilterIds){
			userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removePriceFilterList(UxsUserContext userContext, String profileId, 
			String priceFilterIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingPriceFilterList(userContext, profileId,  priceFilterIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemovePriceFilterList(profile, priceFilterIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
				deleteRelationListInGraph(userContext, profile.getPriceFilterList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingPriceFilter(UxsUserContext userContext, String profileId, 
		String priceFilterId, int priceFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().checkVersionOfPriceFilter(priceFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removePriceFilter(UxsUserContext userContext, String profileId, 
		String priceFilterId, int priceFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPriceFilter(userContext,profileId, priceFilterId, priceFilterVersion,tokensExpr);
		
		PriceFilter priceFilter = createIndexedPriceFilter(priceFilterId, priceFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removePriceFilter( priceFilter );		
			profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
			deleteRelationInGraph(userContext, priceFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingPriceFilter(UxsUserContext userContext, String profileId, 
		String priceFilterId, int priceFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().checkVersionOfPriceFilter(priceFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyPriceFilterFrom(UxsUserContext userContext, String profileId, 
		String priceFilterId, int priceFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPriceFilter(userContext,profileId, priceFilterId, priceFilterVersion,tokensExpr);
		
		PriceFilter priceFilter = createIndexedPriceFilter(priceFilterId, priceFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			profile.copyPriceFilterFrom( priceFilter );		
			profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
			
			userContext.getManagerGroup().getPriceFilterManager().onNewInstanceCreated(userContext, (PriceFilter)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingPriceFilter(UxsUserContext userContext, String profileId, String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfPriceFilter(priceFilterId);
		userContext.getChecker().checkVersionOfPriceFilter(priceFilterVersion);
		

		if(PriceFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPriceFilter(parseString(newValueExpr));
		}
		
		if(PriceFilter.PRICE_START_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceStartOfPriceFilter(parseBigDecimal(newValueExpr));
		}
		
		if(PriceFilter.PRICE_END_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceEndOfPriceFilter(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updatePriceFilter(UxsUserContext userContext, String profileId, String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPriceFilter(userContext, profileId, priceFilterId, priceFilterVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withPriceFilterList().searchPriceFilterListWith(PriceFilter.ID_PROPERTY, "eq", priceFilterId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removePriceFilter( priceFilter );	
			//make changes to AcceleraterAccount.
			PriceFilter priceFilterIndex = createIndexedPriceFilter(priceFilterId, priceFilterVersion);
		
			PriceFilter priceFilter = profile.findThePriceFilter(priceFilterIndex);
			if(priceFilter == null){
				throw new ProfileManagerException(priceFilter+" is NOT FOUND" );
			}
			
			priceFilter.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().withPriceFilterList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingCategoryFilter(UxsUserContext userContext, String profileId, String name, String internalId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfCategoryFilter(name);
		
		userContext.getChecker().checkInternalIdOfCategoryFilter(internalId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addCategoryFilter(UxsUserContext userContext, String profileId, String name, String internalId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCategoryFilter(userContext,profileId,name, internalId,tokensExpr);
		
		CategoryFilter categoryFilter = createCategoryFilter(userContext,name, internalId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addCategoryFilter( categoryFilter );		
			profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
			
			userContext.getManagerGroup().getCategoryFilterManager().onNewInstanceCreated(userContext, categoryFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCategoryFilterProperties(UxsUserContext userContext, String profileId,String id,String name,String internalId,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfCategoryFilter(id);
		
		userContext.getChecker().checkNameOfCategoryFilter( name);
		userContext.getChecker().checkInternalIdOfCategoryFilter( internalId);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateCategoryFilterProperties(UxsUserContext userContext, String profileId, String id,String name,String internalId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingCategoryFilterProperties(userContext,profileId,id,name,internalId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCategoryFilterListList()
				.searchCategoryFilterListWith(CategoryFilter.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getCategoryFilterList().isEmpty()){
			throw new ProfileManagerException("CategoryFilter is NOT FOUND with id: '"+id+"'");
		}
		
		CategoryFilter item = profileToUpdate.getCategoryFilterList().first();
		
		item.updateName( name );
		item.updateInternalId( internalId );

		
		//checkParamsForAddingCategoryFilter(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withCategoryFilterList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected CategoryFilter createCategoryFilter(UxsUserContext userContext, String name, String internalId) throws Exception{

		CategoryFilter categoryFilter = new CategoryFilter();
		
		
		categoryFilter.setName(name);		
		categoryFilter.setInternalId(internalId);
	
		
		return categoryFilter;
	
		
	}
	
	protected CategoryFilter createIndexedCategoryFilter(String id, int version){

		CategoryFilter categoryFilter = new CategoryFilter();
		categoryFilter.setId(id);
		categoryFilter.setVersion(version);
		return categoryFilter;			
		
	}
	
	protected void checkParamsForRemovingCategoryFilterList(UxsUserContext userContext, String profileId, 
			String categoryFilterIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String categoryFilterId: categoryFilterIds){
			userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeCategoryFilterList(UxsUserContext userContext, String profileId, 
			String categoryFilterIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingCategoryFilterList(userContext, profileId,  categoryFilterIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveCategoryFilterList(profile, categoryFilterIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
				deleteRelationListInGraph(userContext, profile.getCategoryFilterList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingCategoryFilter(UxsUserContext userContext, String profileId, 
		String categoryFilterId, int categoryFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().checkVersionOfCategoryFilter(categoryFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeCategoryFilter(UxsUserContext userContext, String profileId, 
		String categoryFilterId, int categoryFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCategoryFilter(userContext,profileId, categoryFilterId, categoryFilterVersion,tokensExpr);
		
		CategoryFilter categoryFilter = createIndexedCategoryFilter(categoryFilterId, categoryFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeCategoryFilter( categoryFilter );		
			profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
			deleteRelationInGraph(userContext, categoryFilter);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingCategoryFilter(UxsUserContext userContext, String profileId, 
		String categoryFilterId, int categoryFilterVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().checkVersionOfCategoryFilter(categoryFilterVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyCategoryFilterFrom(UxsUserContext userContext, String profileId, 
		String categoryFilterId, int categoryFilterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCategoryFilter(userContext,profileId, categoryFilterId, categoryFilterVersion,tokensExpr);
		
		CategoryFilter categoryFilter = createIndexedCategoryFilter(categoryFilterId, categoryFilterVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			profile.copyCategoryFilterFrom( categoryFilter );		
			profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
			
			userContext.getManagerGroup().getCategoryFilterManager().onNewInstanceCreated(userContext, (CategoryFilter)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingCategoryFilter(UxsUserContext userContext, String profileId, String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfCategoryFilter(categoryFilterId);
		userContext.getChecker().checkVersionOfCategoryFilter(categoryFilterVersion);
		

		if(CategoryFilter.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCategoryFilter(parseString(newValueExpr));
		}
		
		if(CategoryFilter.INTERNAL_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkInternalIdOfCategoryFilter(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateCategoryFilter(UxsUserContext userContext, String profileId, String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCategoryFilter(userContext, profileId, categoryFilterId, categoryFilterVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withCategoryFilterList().searchCategoryFilterListWith(CategoryFilter.ID_PROPERTY, "eq", categoryFilterId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeCategoryFilter( categoryFilter );	
			//make changes to AcceleraterAccount.
			CategoryFilter categoryFilterIndex = createIndexedCategoryFilter(categoryFilterId, categoryFilterVersion);
		
			CategoryFilter categoryFilter = profile.findTheCategoryFilter(categoryFilterIndex);
			if(categoryFilter == null){
				throw new ProfileManagerException(categoryFilter+" is NOT FOUND" );
			}
			
			categoryFilter.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().withCategoryFilterList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingNewProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfNewProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfNewProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfNewProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfNewProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfNewProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfNewProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfNewProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfNewProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addNewProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNewProduct(userContext,profileId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		NewProduct newProduct = createNewProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addNewProduct( newProduct );		
			profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, newProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNewProductProperties(UxsUserContext userContext, String profileId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfNewProduct(id);
		
		userContext.getChecker().checkNameOfNewProduct( name);
		userContext.getChecker().checkProductCoverImageOfNewProduct( productCoverImage);
		userContext.getChecker().checkOriginOfNewProduct( origin);
		userContext.getChecker().checkRemarkOfNewProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateNewProductProperties(UxsUserContext userContext, String profileId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNewProductProperties(userContext,profileId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNewProductListList()
				.searchNewProductListWith(NewProduct.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getNewProductList().isEmpty()){
			throw new ProfileManagerException("NewProduct is NOT FOUND with id: '"+id+"'");
		}
		
		NewProduct item = profileToUpdate.getNewProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingNewProduct(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withNewProductList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected NewProduct createNewProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

		NewProduct newProduct = new NewProduct();
		
		
		newProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		newProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		newProduct.setBrand(brand);		
		newProduct.setProductCoverImage(productCoverImage);		
		newProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		newProduct.setCatalog(catalog);		
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
	
	protected void checkParamsForRemovingNewProductList(UxsUserContext userContext, String profileId, 
			String newProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String newProductId: newProductIds){
			userContext.getChecker().checkIdOfNewProduct(newProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeNewProductList(UxsUserContext userContext, String profileId, 
			String newProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNewProductList(userContext, profileId,  newProductIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveNewProductList(profile, newProductIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
				deleteRelationListInGraph(userContext, profile.getNewProductList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNewProduct(UxsUserContext userContext, String profileId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeNewProduct(UxsUserContext userContext, String profileId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNewProduct(userContext,profileId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeNewProduct( newProduct );		
			profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
			deleteRelationInGraph(userContext, newProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNewProduct(UxsUserContext userContext, String profileId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyNewProductFrom(UxsUserContext userContext, String profileId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNewProduct(userContext,profileId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			newProduct.updateLastUpdateTime(userContext.now());
			
			profile.copyNewProductFrom( newProduct );		
			profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, (NewProduct)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNewProduct(UxsUserContext userContext, String profileId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateNewProduct(UxsUserContext userContext, String profileId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNewProduct(userContext, profileId, newProductId, newProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNewProductList().searchNewProductListWith(NewProduct.ID_PROPERTY, "eq", newProductId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeNewProduct( newProduct );	
			//make changes to AcceleraterAccount.
			NewProduct newProductIndex = createIndexedNewProduct(newProductId, newProductVersion);
		
			NewProduct newProduct = profile.findTheNewProduct(newProductIndex);
			if(newProduct == null){
				throw new ProfileManagerException(newProduct+" is NOT FOUND" );
			}
			
			newProduct.changeProperty(property, newValueExpr);
			newProduct.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withNewProductList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEditorPickProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfEditorPickProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfEditorPickProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfEditorPickProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfEditorPickProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfEditorPickProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfEditorPickProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfEditorPickProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addEditorPickProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEditorPickProduct(userContext,profileId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		EditorPickProduct editorPickProduct = createEditorPickProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addEditorPickProduct( editorPickProduct );		
			profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, editorPickProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEditorPickProductProperties(UxsUserContext userContext, String profileId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfEditorPickProduct(id);
		
		userContext.getChecker().checkNameOfEditorPickProduct( name);
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct( productCoverImage);
		userContext.getChecker().checkOriginOfEditorPickProduct( origin);
		userContext.getChecker().checkRemarkOfEditorPickProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateEditorPickProductProperties(UxsUserContext userContext, String profileId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEditorPickProductProperties(userContext,profileId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEditorPickProductListList()
				.searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getEditorPickProductList().isEmpty()){
			throw new ProfileManagerException("EditorPickProduct is NOT FOUND with id: '"+id+"'");
		}
		
		EditorPickProduct item = profileToUpdate.getEditorPickProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingEditorPickProduct(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withEditorPickProductList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EditorPickProduct createEditorPickProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		
		
		editorPickProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		editorPickProduct.setParentCategory(parentCategory);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		editorPickProduct.setBrand(brand);		
		editorPickProduct.setProductCoverImage(productCoverImage);		
		editorPickProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		editorPickProduct.setCatalog(catalog);		
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
	
	protected void checkParamsForRemovingEditorPickProductList(UxsUserContext userContext, String profileId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String editorPickProductId: editorPickProductIds){
			userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeEditorPickProductList(UxsUserContext userContext, String profileId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEditorPickProductList(userContext, profileId,  editorPickProductIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveEditorPickProductList(profile, editorPickProductIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
				deleteRelationListInGraph(userContext, profile.getEditorPickProductList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEditorPickProduct(UxsUserContext userContext, String profileId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeEditorPickProduct(UxsUserContext userContext, String profileId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEditorPickProduct(userContext,profileId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeEditorPickProduct( editorPickProduct );		
			profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
			deleteRelationInGraph(userContext, editorPickProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEditorPickProduct(UxsUserContext userContext, String profileId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyEditorPickProductFrom(UxsUserContext userContext, String profileId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEditorPickProduct(userContext,profileId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			editorPickProduct.updateLastUpdateTime(userContext.now());
			
			profile.copyEditorPickProductFrom( editorPickProduct );		
			profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, (EditorPickProduct)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEditorPickProduct(UxsUserContext userContext, String profileId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateEditorPickProduct(UxsUserContext userContext, String profileId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEditorPickProduct(userContext, profileId, editorPickProductId, editorPickProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEditorPickProductList().searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "eq", editorPickProductId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeEditorPickProduct( editorPickProduct );	
			//make changes to AcceleraterAccount.
			EditorPickProduct editorPickProductIndex = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		
			EditorPickProduct editorPickProduct = profile.findTheEditorPickProduct(editorPickProductIndex);
			if(editorPickProduct == null){
				throw new ProfileManagerException(editorPickProduct+" is NOT FOUND" );
			}
			
			editorPickProduct.changeProperty(property, newValueExpr);
			editorPickProduct.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withEditorPickProductList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTopRatedProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfTopRatedProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfTopRatedProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfTopRatedProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfTopRatedProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfTopRatedProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfTopRatedProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfTopRatedProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addTopRatedProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTopRatedProduct(userContext,profileId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		TopRatedProduct topRatedProduct = createTopRatedProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addTopRatedProduct( topRatedProduct );		
			profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, topRatedProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTopRatedProductProperties(UxsUserContext userContext, String profileId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfTopRatedProduct(id);
		
		userContext.getChecker().checkNameOfTopRatedProduct( name);
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct( productCoverImage);
		userContext.getChecker().checkOriginOfTopRatedProduct( origin);
		userContext.getChecker().checkRemarkOfTopRatedProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateTopRatedProductProperties(UxsUserContext userContext, String profileId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTopRatedProductProperties(userContext,profileId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTopRatedProductListList()
				.searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getTopRatedProductList().isEmpty()){
			throw new ProfileManagerException("TopRatedProduct is NOT FOUND with id: '"+id+"'");
		}
		
		TopRatedProduct item = profileToUpdate.getTopRatedProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingTopRatedProduct(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withTopRatedProductList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TopRatedProduct createTopRatedProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		
		
		topRatedProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		topRatedProduct.setParentCategory(parentCategory);		
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
	
	protected void checkParamsForRemovingTopRatedProductList(UxsUserContext userContext, String profileId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String topRatedProductId: topRatedProductIds){
			userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeTopRatedProductList(UxsUserContext userContext, String profileId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTopRatedProductList(userContext, profileId,  topRatedProductIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveTopRatedProductList(profile, topRatedProductIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
				deleteRelationListInGraph(userContext, profile.getTopRatedProductList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTopRatedProduct(UxsUserContext userContext, String profileId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeTopRatedProduct(UxsUserContext userContext, String profileId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTopRatedProduct(userContext,profileId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeTopRatedProduct( topRatedProduct );		
			profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
			deleteRelationInGraph(userContext, topRatedProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTopRatedProduct(UxsUserContext userContext, String profileId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyTopRatedProductFrom(UxsUserContext userContext, String profileId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTopRatedProduct(userContext,profileId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			topRatedProduct.updateLastUpdateTime(userContext.now());
			
			profile.copyTopRatedProductFrom( topRatedProduct );		
			profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, (TopRatedProduct)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTopRatedProduct(UxsUserContext userContext, String profileId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateTopRatedProduct(UxsUserContext userContext, String profileId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTopRatedProduct(userContext, profileId, topRatedProductId, topRatedProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTopRatedProductList().searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "eq", topRatedProductId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeTopRatedProduct( topRatedProduct );	
			//make changes to AcceleraterAccount.
			TopRatedProduct topRatedProductIndex = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		
			TopRatedProduct topRatedProduct = profile.findTheTopRatedProduct(topRatedProductIndex);
			if(topRatedProduct == null){
				throw new ProfileManagerException(topRatedProduct+" is NOT FOUND" );
			}
			
			topRatedProduct.changeProperty(property, newValueExpr);
			topRatedProduct.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withTopRatedProductList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRecommandProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfRecommandProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfRecommandProduct(parentCategoryId);
		
		userContext.getChecker().checkBrandIdOfRecommandProduct(brandId);
		
		userContext.getChecker().checkProductCoverImageOfRecommandProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfRecommandProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfRecommandProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfRecommandProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfRecommandProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addRecommandProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRecommandProduct(userContext,profileId,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		RecommandProduct recommandProduct = createRecommandProduct(userContext,name, parentCategoryId, brandId, productCoverImage, origin, catalogId, remark, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addRecommandProduct( recommandProduct );		
			profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, recommandProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRecommandProductProperties(UxsUserContext userContext, String profileId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfRecommandProduct(id);
		
		userContext.getChecker().checkNameOfRecommandProduct( name);
		userContext.getChecker().checkProductCoverImageOfRecommandProduct( productCoverImage);
		userContext.getChecker().checkOriginOfRecommandProduct( origin);
		userContext.getChecker().checkRemarkOfRecommandProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateRecommandProductProperties(UxsUserContext userContext, String profileId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRecommandProductProperties(userContext,profileId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRecommandProductListList()
				.searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getRecommandProductList().isEmpty()){
			throw new ProfileManagerException("RecommandProduct is NOT FOUND with id: '"+id+"'");
		}
		
		RecommandProduct item = profileToUpdate.getRecommandProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingRecommandProduct(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withRecommandProductList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RecommandProduct createRecommandProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

		RecommandProduct recommandProduct = new RecommandProduct();
		
		
		recommandProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		recommandProduct.setParentCategory(parentCategory);		
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
	
	protected void checkParamsForRemovingRecommandProductList(UxsUserContext userContext, String profileId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String recommandProductId: recommandProductIds){
			userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeRecommandProductList(UxsUserContext userContext, String profileId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRecommandProductList(userContext, profileId,  recommandProductIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveRecommandProductList(profile, recommandProductIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
				deleteRelationListInGraph(userContext, profile.getRecommandProductList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRecommandProduct(UxsUserContext userContext, String profileId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeRecommandProduct(UxsUserContext userContext, String profileId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRecommandProduct(userContext,profileId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeRecommandProduct( recommandProduct );		
			profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
			deleteRelationInGraph(userContext, recommandProduct);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRecommandProduct(UxsUserContext userContext, String profileId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyRecommandProductFrom(UxsUserContext userContext, String profileId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRecommandProduct(userContext,profileId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			recommandProduct.updateLastUpdateTime(userContext.now());
			
			profile.copyRecommandProductFrom( recommandProduct );		
			profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, (RecommandProduct)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRecommandProduct(UxsUserContext userContext, String profileId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateRecommandProduct(UxsUserContext userContext, String profileId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRecommandProduct(userContext, profileId, recommandProductId, recommandProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRecommandProductList().searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "eq", recommandProductId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeRecommandProduct( recommandProduct );	
			//make changes to AcceleraterAccount.
			RecommandProduct recommandProductIndex = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		
			RecommandProduct recommandProduct = profile.findTheRecommandProduct(recommandProductIndex);
			if(recommandProduct == null){
				throw new ProfileManagerException(recommandProduct+" is NOT FOUND" );
			}
			
			recommandProduct.changeProperty(property, newValueExpr);
			recommandProduct.updateLastUpdateTime(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withRecommandProductList().done());
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


