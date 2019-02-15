
package com.doublechaintech.uxs.rating;

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







public class RatingManagerImpl extends CustomUxsCheckerManager implements RatingManager {
	
	private static final String SERVICE_TYPE = "Rating";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RatingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RatingManagerException(message);

	}
	
	

 	protected Rating saveRating(UxsUserContext userContext, Rating rating, String [] tokensExpr) throws Exception{	
 		//return getRatingDAO().save(rating, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRating(userContext, rating, tokens);
 	}
 	
 	protected Rating saveRatingDetail(UxsUserContext userContext, Rating rating) throws Exception{	

 		
 		return saveRating(userContext, rating, allTokens());
 	}
 	
 	public Rating loadRating(UxsUserContext userContext, String ratingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().throwExceptionIfHasErrors( RatingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Rating rating = loadRating( userContext, ratingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,rating, tokens);
 	}
 	
 	
 	 public Rating searchRating(UxsUserContext userContext, String ratingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().throwExceptionIfHasErrors( RatingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Rating rating = loadRating( userContext, ratingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,rating, tokens);
 	}
 	
 	

 	protected Rating present(UxsUserContext userContext, Rating rating, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,rating,tokens);
		
		
		Rating  ratingToPresent = userContext.getDAOGroup().getRatingDAO().present(rating, tokens);
		
		List<BaseEntity> entityListToNaming = ratingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRatingDAO().alias(entityListToNaming);
		
		return  ratingToPresent;
		
		
	}
 
 	
 	
 	public Rating loadRatingDetail(UxsUserContext userContext, String ratingId) throws Exception{	
 		Rating rating = loadRating( userContext, ratingId, allTokens());
 		return present(userContext,rating, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String ratingId) throws Exception{	
 		Rating rating = loadRating( userContext, ratingId, viewTokens());
 		return present(userContext,rating, allTokens());
		
 	}
 	protected Rating saveRating(UxsUserContext userContext, Rating rating, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRatingDAO().save(rating, tokens);
 	}
 	protected Rating loadRating(UxsUserContext userContext, String ratingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().throwExceptionIfHasErrors( RatingManagerException.class);

 
 		return userContext.getDAOGroup().getRatingDAO().load(ratingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Rating rating, Map<String, Object> tokens){
		super.addActions(userContext, rating, tokens);
		
		addAction(userContext, rating, tokens,"@create","createRating","createRating/","main","primary");
		addAction(userContext, rating, tokens,"@update","updateRating","updateRating/"+rating.getId()+"/","main","primary");
		addAction(userContext, rating, tokens,"@copy","cloneRating","cloneRating/"+rating.getId()+"/","main","primary");
		
		addAction(userContext, rating, tokens,"rating.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+rating.getId()+"/","main","primary");
		addAction(userContext, rating, tokens,"rating.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+rating.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Rating rating, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Rating createRating(UxsUserContext userContext,String userId, String productId, int score) throws Exception
	{
		
		

		

		userContext.getChecker().checkScoreOfRating(score);
	
		userContext.getChecker().throwExceptionIfHasErrors(RatingManagerException.class);


		Rating rating=createNewRating();	

			
		Profile user = loadProfile(userContext, userId,emptyOptions());
		rating.setUser(user);
		
		
			
		Product product = loadProduct(userContext, productId,emptyOptions());
		rating.setProduct(product);
		
		
		rating.setScore(score);
		rating.setUpdateTime(userContext.now());

		rating = saveRating(userContext, rating, emptyOptions());
		
		onNewInstanceCreated(userContext, rating);
		return rating;

		
	}
	protected Rating createNewRating() 
	{
		
		return new Rating();		
	}
	
	protected void checkParamsForUpdatingRating(UxsUserContext userContext,String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRating(ratingId);
		userContext.getChecker().checkVersionOfRating( ratingVersion);
		
		

				

		
		if(Rating.SCORE_PROPERTY.equals(property)){
			userContext.getChecker().checkScoreOfRating(parseInt(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RatingManagerException.class);
	
		
	}
	
	
	
	public Rating clone(UxsUserContext userContext, String fromRatingId) throws Exception{
		
		return userContext.getDAOGroup().getRatingDAO().clone(fromRatingId, this.allTokens());
	}
	
	public Rating internalSaveRating(UxsUserContext userContext, Rating rating) throws Exception 
	{
		return internalSaveRating(userContext, rating, allTokens());

	}
	public Rating internalSaveRating(UxsUserContext userContext, Rating rating, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRating(userContext, ratingId, ratingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(rating){ 
			//will be good when the rating loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Rating.
			
			
			rating = saveRating(userContext, rating, options);
			return rating;
			
		}

	}
	
	public Rating updateRating(UxsUserContext userContext,String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRating(userContext, ratingId, ratingVersion, property, newValueExpr, tokensExpr);
		
		
		
		Rating rating = loadRating(userContext, ratingId, allTokens());
		if(rating.getVersion() != ratingVersion){
			String message = "The target version("+rating.getVersion()+") is not equals to version("+ratingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(rating){ 
			//will be good when the rating loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Rating.
			rating.updateUpdateTime(userContext.now());
			rating.changeProperty(property, newValueExpr);
			rating = saveRating(userContext, rating, tokens().done());
			return present(userContext,rating, mergedAllTokens(tokensExpr));
			//return saveRating(userContext, rating, tokens().done());
		}

	}
	
	public Rating updateRatingProperty(UxsUserContext userContext,String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRating(userContext, ratingId, ratingVersion, property, newValueExpr, tokensExpr);
		
		Rating rating = loadRating(userContext, ratingId, allTokens());
		if(rating.getVersion() != ratingVersion){
			String message = "The target version("+rating.getVersion()+") is not equals to version("+ratingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(rating){ 
			//will be good when the rating loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Rating.
			
			rating.changeProperty(property, newValueExpr);
			rating.updateUpdateTime(userContext.now());
			rating = saveRating(userContext, rating, tokens().done());
			return present(userContext,rating, mergedAllTokens(tokensExpr));
			//return saveRating(userContext, rating, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RatingTokens tokens(){
		return RatingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RatingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RatingTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUser(UxsUserContext userContext, String ratingId, String anotherUserId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRating(ratingId);
 		userContext.getChecker().checkIdOfProfile(anotherUserId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RatingManagerException.class);
 		
 	}
 	public Rating transferToAnotherUser(UxsUserContext userContext, String ratingId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, ratingId,anotherUserId);
 
		Rating rating = loadRating(userContext, ratingId, allTokens());	
		synchronized(rating){
			//will be good when the rating loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile user = loadProfile(userContext, anotherUserId, emptyOptions());		
			rating.updateUser(user);		
			rating = saveRating(userContext, rating, emptyOptions());
			
			return present(userContext,rating, allTokens());
			
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
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForRating(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProduct(UxsUserContext userContext, String ratingId, String anotherProductId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRating(ratingId);
 		userContext.getChecker().checkIdOfProduct(anotherProductId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RatingManagerException.class);
 		
 	}
 	public Rating transferToAnotherProduct(UxsUserContext userContext, String ratingId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, ratingId,anotherProductId);
 
		Rating rating = loadRating(userContext, ratingId, allTokens());	
		synchronized(rating){
			//will be good when the rating loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(userContext, anotherProductId, emptyOptions());		
			rating.updateProduct(product);		
			rating = saveRating(userContext, rating, emptyOptions());
			
			return present(userContext,rating, allTokens());
			
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
		SmartList<Product> candidateList = userContext.getDAOGroup().getProductDAO().requestCandidateProductForRating(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(UxsUserContext userContext, String ratingId, int ratingVersion) throws Exception {
		//deleteInternal(userContext, ratingId, ratingVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String ratingId, int ratingVersion) throws Exception{
			
		userContext.getDAOGroup().getRatingDAO().delete(ratingId, ratingVersion);
	}
	
	public Rating forgetByAll(UxsUserContext userContext, String ratingId, int ratingVersion) throws Exception {
		return forgetByAllInternal(userContext, ratingId, ratingVersion);		
	}
	protected Rating forgetByAllInternal(UxsUserContext userContext,
			String ratingId, int ratingVersion) throws Exception{
			
		return userContext.getDAOGroup().getRatingDAO().disconnectFromAll(ratingId, ratingVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RatingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRatingDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, Rating newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


