
package com.doublechaintech.uxs.review;

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

import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.profile.Profile;

import com.doublechaintech.uxs.product.CandidateProduct;
import com.doublechaintech.uxs.profile.CandidateProfile;







public class ReviewManagerImpl extends CustomUxsCheckerManager implements ReviewManager {
	
	private static final String SERVICE_TYPE = "Review";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ReviewManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ReviewManagerException(message);

	}
	
	

 	protected Review saveReview(UxsUserContext userContext, Review review, String [] tokensExpr) throws Exception{	
 		//return getReviewDAO().save(review, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveReview(userContext, review, tokens);
 	}
 	
 	protected Review saveReviewDetail(UxsUserContext userContext, Review review) throws Exception{	

 		
 		return saveReview(userContext, review, allTokens());
 	}
 	
 	public Review loadReview(UxsUserContext userContext, String reviewId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().throwExceptionIfHasErrors( ReviewManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Review review = loadReview( userContext, reviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,review, tokens);
 	}
 	
 	
 	 public Review searchReview(UxsUserContext userContext, String reviewId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().throwExceptionIfHasErrors( ReviewManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Review review = loadReview( userContext, reviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,review, tokens);
 	}
 	
 	

 	protected Review present(UxsUserContext userContext, Review review, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,review,tokens);
		
		
		Review  reviewToPresent = userContext.getDAOGroup().getReviewDAO().present(review, tokens);
		
		List<BaseEntity> entityListToNaming = reviewToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getReviewDAO().alias(entityListToNaming);
		
		return  reviewToPresent;
		
		
	}
 
 	
 	
 	public Review loadReviewDetail(UxsUserContext userContext, String reviewId) throws Exception{	
 		Review review = loadReview( userContext, reviewId, allTokens());
 		return present(userContext,review, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String reviewId) throws Exception{	
 		Review review = loadReview( userContext, reviewId, viewTokens());
 		return present(userContext,review, allTokens());
		
 	}
 	protected Review saveReview(UxsUserContext userContext, Review review, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getReviewDAO().save(review, tokens);
 	}
 	protected Review loadReview(UxsUserContext userContext, String reviewId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().throwExceptionIfHasErrors( ReviewManagerException.class);

 
 		return userContext.getDAOGroup().getReviewDAO().load(reviewId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Review review, Map<String, Object> tokens){
		super.addActions(userContext, review, tokens);
		
		addAction(userContext, review, tokens,"@create","createReview","createReview/","main","primary");
		addAction(userContext, review, tokens,"@update","updateReview","updateReview/"+review.getId()+"/","main","primary");
		addAction(userContext, review, tokens,"@copy","cloneReview","cloneReview/"+review.getId()+"/","main","primary");
		
		addAction(userContext, review, tokens,"review.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+review.getId()+"/","main","primary");
		addAction(userContext, review, tokens,"review.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+review.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Review review, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Review createReview(UxsUserContext userContext,String title, String content, String userId, String productId) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfReview(title);
		userContext.getChecker().checkContentOfReview(content);
	
		userContext.getChecker().throwExceptionIfHasErrors(ReviewManagerException.class);


		Review review=createNewReview();	

		review.setTitle(title);
		review.setContent(content);
			
		Profile user = loadProfile(userContext, userId,emptyOptions());
		review.setUser(user);
		
		
			
		Product product = loadProduct(userContext, productId,emptyOptions());
		review.setProduct(product);
		
		
		review.setUpdateTime(userContext.now());

		review = saveReview(userContext, review, emptyOptions());
		
		onNewInstanceCreated(userContext, review);
		return review;

		
	}
	protected Review createNewReview() 
	{
		
		return new Review();		
	}
	
	protected void checkParamsForUpdatingReview(UxsUserContext userContext,String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfReview(reviewId);
		userContext.getChecker().checkVersionOfReview( reviewVersion);
		

		if(Review.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfReview(parseString(newValueExpr));
		}
		if(Review.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfReview(parseString(newValueExpr));
		}		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ReviewManagerException.class);
	
		
	}
	
	
	
	public Review clone(UxsUserContext userContext, String fromReviewId) throws Exception{
		
		return userContext.getDAOGroup().getReviewDAO().clone(fromReviewId, this.allTokens());
	}
	
	public Review internalSaveReview(UxsUserContext userContext, Review review) throws Exception 
	{
		return internalSaveReview(userContext, review, allTokens());

	}
	public Review internalSaveReview(UxsUserContext userContext, Review review, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingReview(userContext, reviewId, reviewVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(review){ 
			//will be good when the review loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Review.
			
			
			review = saveReview(userContext, review, options);
			return review;
			
		}

	}
	
	public Review updateReview(UxsUserContext userContext,String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingReview(userContext, reviewId, reviewVersion, property, newValueExpr, tokensExpr);
		
		
		
		Review review = loadReview(userContext, reviewId, allTokens());
		if(review.getVersion() != reviewVersion){
			String message = "The target version("+review.getVersion()+") is not equals to version("+reviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(review){ 
			//will be good when the review loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Review.
			review.updateUpdateTime(userContext.now());
			review.changeProperty(property, newValueExpr);
			review = saveReview(userContext, review, tokens().done());
			return present(userContext,review, mergedAllTokens(tokensExpr));
			//return saveReview(userContext, review, tokens().done());
		}

	}
	
	public Review updateReviewProperty(UxsUserContext userContext,String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingReview(userContext, reviewId, reviewVersion, property, newValueExpr, tokensExpr);
		
		Review review = loadReview(userContext, reviewId, allTokens());
		if(review.getVersion() != reviewVersion){
			String message = "The target version("+review.getVersion()+") is not equals to version("+reviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(review){ 
			//will be good when the review loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Review.
			
			review.changeProperty(property, newValueExpr);
			review.updateUpdateTime(userContext.now());
			review = saveReview(userContext, review, tokens().done());
			return present(userContext,review, mergedAllTokens(tokensExpr));
			//return saveReview(userContext, review, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ReviewTokens tokens(){
		return ReviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ReviewTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ReviewTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUser(UxsUserContext userContext, String reviewId, String anotherUserId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfReview(reviewId);
 		userContext.getChecker().checkIdOfProfile(anotherUserId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ReviewManagerException.class);
 		
 	}
 	public Review transferToAnotherUser(UxsUserContext userContext, String reviewId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, reviewId,anotherUserId);
 
		Review review = loadReview(userContext, reviewId, allTokens());	
		synchronized(review){
			//will be good when the review loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile user = loadProfile(userContext, anotherUserId, emptyOptions());		
			review.updateUser(user);		
			review = saveReview(userContext, review, emptyOptions());
			
			return present(userContext,review, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidateUser(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForReview(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProduct(UxsUserContext userContext, String reviewId, String anotherProductId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfReview(reviewId);
 		userContext.getChecker().checkIdOfProduct(anotherProductId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ReviewManagerException.class);
 		
 	}
 	public Review transferToAnotherProduct(UxsUserContext userContext, String reviewId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, reviewId,anotherProductId);
 
		Review review = loadReview(userContext, reviewId, allTokens());	
		synchronized(review){
			//will be good when the review loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(userContext, anotherProductId, emptyOptions());		
			review.updateProduct(product);		
			review = saveReview(userContext, review, emptyOptions());
			
			return present(userContext,review, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProduct requestCandidateProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProduct result = new CandidateProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Product> candidateList = userContext.getDAOGroup().getProductDAO().requestCandidateProductForReview(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Product loadProduct(UxsUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProductDAO().load(newProductId, options);
 	}
 	
 	
 	
	
	 	
 	protected Profile loadProfile(UxsUserContext userContext, String newUserId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newUserId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String reviewId, int reviewVersion) throws Exception {
		//deleteInternal(userContext, reviewId, reviewVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String reviewId, int reviewVersion) throws Exception{
			
		userContext.getDAOGroup().getReviewDAO().delete(reviewId, reviewVersion);
	}
	
	public Review forgetByAll(UxsUserContext userContext, String reviewId, int reviewVersion) throws Exception {
		return forgetByAllInternal(userContext, reviewId, reviewVersion);		
	}
	protected Review forgetByAllInternal(UxsUserContext userContext,
			String reviewId, int reviewVersion) throws Exception{
			
		return userContext.getDAOGroup().getReviewDAO().disconnectFromAll(reviewId, reviewVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ReviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getReviewDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, Review newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


