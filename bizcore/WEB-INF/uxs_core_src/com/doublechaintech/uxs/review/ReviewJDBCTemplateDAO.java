
package com.doublechaintech.uxs.review;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.uxs.UxsNamingServiceDAO;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.AccessKey;
import com.doublechaintech.uxs.DateKey;
import com.doublechaintech.uxs.StatsInfo;
import com.doublechaintech.uxs.StatsItem;

import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;


import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.profile.Profile;

import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ReviewJDBCTemplateDAO extends UxsNamingServiceDAO implements ReviewDAO{
 
 	
 	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO productDAO){
	 	this.productDAO = productDAO;
 	}
 	public ProductDAO getProductDAO(){
	 	return this.productDAO;
 	}
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}


			
		

	
	/*
	protected Review load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalReview(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Review load(String id,Map<String,Object> options) throws Exception{
		return loadInternalReview(ReviewTable.withId(id), options);
	}
	
	
	
	public Review save(Review review,Map<String,Object> options){
		
		String methodName="save(Review review,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(review, methodName, "review");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalReview(review,options);
	}
	public Review clone(String reviewId, Map<String,Object> options) throws Exception{
	
		return clone(ReviewTable.withId(reviewId),options);
	}
	
	protected Review clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String reviewId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Review newReview = loadInternalReview(accessKey, options);
		newReview.setVersion(0);
		
		

		
		saveInternalReview(newReview,options);
		
		return newReview;
	}
	
	
	
	

	protected void throwIfHasException(String reviewId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ReviewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ReviewNotFoundException(
					"The " + this.getTableName() + "(" + reviewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String reviewId, int version) throws Exception{
	
		String methodName="delete(String reviewId, int version)";
		assertMethodArgumentNotNull(reviewId, methodName, "reviewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{reviewId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(reviewId,version);
		}
		
	
	}
	
	
	
	
	

	public Review disconnectFromAll(String reviewId, int version) throws Exception{
	
		
		Review review = loadInternalReview(ReviewTable.withId(reviewId), emptyOptions());
		review.clearFromAll();
		this.saveReview(review);
		return review;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ReviewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "review";
	}
	@Override
	protected String getBeanName() {
		
		return "review";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ReviewTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ReviewTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ReviewTokens.USER);
 	}
 	

 	
  

 	protected boolean isExtractProductEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ReviewTokens.PRODUCT);
 	}

 	protected boolean isSaveProductEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ReviewTokens.PRODUCT);
 	}
 	

 	
 
		

	

	protected ReviewMapper getReviewMapper(){
		return new ReviewMapper();
	}

	
	
	protected Review extractReview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Review review = loadSingleObject(accessKey, getReviewMapper());
			return review;
		}catch(EmptyResultDataAccessException e){
			throw new ReviewNotFoundException("Review("+accessKey+") is not found!");
		}

	}

	
	

	protected Review loadInternalReview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Review review = extractReview(accessKey, loadOptions);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(review, loadOptions);
 		}
  	
 		if(isExtractProductEnabled(loadOptions)){
	 		extractProduct(review, loadOptions);
 		}
 
		
		return review;
		
	}

	 

 	protected Review extractUser(Review review, Map<String,Object> options) throws Exception{

		if(review.getUser() == null){
			return review;
		}
		String userId = review.getUser().getId();
		if( userId == null){
			return review;
		}
		Profile user = getProfileDAO().load(userId,options);
		if(user != null){
			review.setUser(user);
		}
		
 		
 		return review;
 	}
 		
  

 	protected Review extractProduct(Review review, Map<String,Object> options) throws Exception{

		if(review.getProduct() == null){
			return review;
		}
		String productId = review.getProduct().getId();
		if( productId == null){
			return review;
		}
		Product product = getProductDAO().load(productId,options);
		if(product != null){
			review.setProduct(product);
		}
		
 		
 		return review;
 	}
 		
 
		
		
  	
 	public SmartList<Review> findReviewByUser(String profileId,Map<String,Object> options){
 	
  		SmartList<Review> resultList = queryWith(ReviewTable.COLUMN_USER, profileId, options, getReviewMapper());
		// analyzeReviewByUser(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Review> findReviewByUser(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Review> resultList =  queryWithRange(ReviewTable.COLUMN_USER, profileId, options, getReviewMapper(), start, count);
 		//analyzeReviewByUser(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeReviewByUser(SmartList<Review> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Review.USER_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Review.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Review");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Review.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Review.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countReviewByUser(String profileId,Map<String,Object> options){

 		return countWith(ReviewTable.COLUMN_USER, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countReviewByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ReviewTable.COLUMN_USER, ids, options);
	}
 	
  	
 	public SmartList<Review> findReviewByProduct(String productId,Map<String,Object> options){
 	
  		SmartList<Review> resultList = queryWith(ReviewTable.COLUMN_PRODUCT, productId, options, getReviewMapper());
		// analyzeReviewByProduct(resultList, productId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Review> findReviewByProduct(String productId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Review> resultList =  queryWithRange(ReviewTable.COLUMN_PRODUCT, productId, options, getReviewMapper(), start, count);
 		//analyzeReviewByProduct(resultList, productId, options);
 		return resultList;
 		
 	}
 	public void analyzeReviewByProduct(SmartList<Review> resultList, String productId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Review.PRODUCT_PROPERTY, productId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Review.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Review");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Review.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Review.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countReviewByProduct(String productId,Map<String,Object> options){

 		return countWith(ReviewTable.COLUMN_PRODUCT, productId, options);
 	}
 	@Override
	public Map<String, Integer> countReviewByProductIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ReviewTable.COLUMN_PRODUCT, ids, options);
	}
 	
 	
		
		
		

	

	protected Review saveReview(Review  review){
		
		if(!review.isChanged()){
			return review;
		}
		
		
		String SQL=this.getSaveReviewSQL(review);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveReviewParameters(review);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		review.incVersion();
		return review;
	
	}
	public SmartList<Review> saveReviewList(SmartList<Review> reviewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitReviewList(reviewList);
		
		batchReviewCreate((List<Review>)lists[CREATE_LIST_INDEX]);
		
		batchReviewUpdate((List<Review>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Review review:reviewList){
			if(review.isChanged()){
				review.incVersion();
			}
			
		
		}
		
		
		return reviewList;
	}

	public SmartList<Review> removeReviewList(SmartList<Review> reviewList,Map<String,Object> options){
		
		
		super.removeList(reviewList, options);
		
		return reviewList;
		
		
	}
	
	protected List<Object[]> prepareReviewBatchCreateArgs(List<Review> reviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Review review:reviewList ){
			Object [] parameters = prepareReviewCreateParameters(review);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareReviewBatchUpdateArgs(List<Review> reviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Review review:reviewList ){
			if(!review.isChanged()){
				continue;
			}
			Object [] parameters = prepareReviewUpdateParameters(review);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchReviewCreate(List<Review> reviewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareReviewBatchCreateArgs(reviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchReviewUpdate(List<Review> reviewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareReviewBatchUpdateArgs(reviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitReviewList(List<Review> reviewList){
		
		List<Review> reviewCreateList=new ArrayList<Review>();
		List<Review> reviewUpdateList=new ArrayList<Review>();
		
		for(Review review: reviewList){
			if(isUpdateRequest(review)){
				reviewUpdateList.add( review);
				continue;
			}
			reviewCreateList.add(review);
		}
		
		return new Object[]{reviewCreateList,reviewUpdateList};
	}
	
	protected boolean isUpdateRequest(Review review){
 		return review.getVersion() > 0;
 	}
 	protected String getSaveReviewSQL(Review review){
 		if(isUpdateRequest(review)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveReviewParameters(Review review){
 		if(isUpdateRequest(review) ){
 			return prepareReviewUpdateParameters(review);
 		}
 		return prepareReviewCreateParameters(review);
 	}
 	protected Object[] prepareReviewUpdateParameters(Review review){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = review.getTitle();
 		parameters[1] = review.getContent(); 	
 		if(review.getUser() != null){
 			parameters[2] = review.getUser().getId();
 		}
  	
 		if(review.getProduct() != null){
 			parameters[3] = review.getProduct().getId();
 		}
 
 		parameters[4] = review.getUpdateTime();		
 		parameters[5] = review.nextVersion();
 		parameters[6] = review.getId();
 		parameters[7] = review.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareReviewCreateParameters(Review review){
		Object[] parameters = new Object[6];
		String newReviewId=getNextId();
		review.setId(newReviewId);
		parameters[0] =  review.getId();
 
 		parameters[1] = review.getTitle();
 		parameters[2] = review.getContent(); 	
 		if(review.getUser() != null){
 			parameters[3] = review.getUser().getId();
 		
 		}
 		 	
 		if(review.getProduct() != null){
 			parameters[4] = review.getProduct().getId();
 		
 		}
 		
 		parameters[5] = review.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected Review saveInternalReview(Review review, Map<String,Object> options){
		
		saveReview(review);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(review, options);
 		}
  	
 		if(isSaveProductEnabled(options)){
	 		saveProduct(review, options);
 		}
 
		
		return review;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Review saveUser(Review review, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(review.getUser() == null){
 			return review;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(review.getUser(),options);
 		return review;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Review saveProduct(Review review, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(review.getProduct() == null){
 			return review;//do nothing when it is null
 		}
 		
 		getProductDAO().save(review.getProduct(),options);
 		return review;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Review present(Review review,Map<String, Object> options){
	

		return review;
	
	}
		

	

	protected String getTableName(){
		return ReviewTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Review> reviewList) {		
		this.enhanceListInternal(reviewList, this.getReviewMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Review> reviewList = ownerEntity.collectRefsWithType(Review.INTERNAL_TYPE);
		this.enhanceList(reviewList);
		
	}
	
	@Override
	public SmartList<Review> findReviewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getReviewMapper());

	}
	@Override
	public int countReviewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countReviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Review> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getReviewMapper());
	}
}


