
package com.doublechaintech.uxs.product;

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


import com.doublechaintech.uxs.rating.Rating;
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.blog.Blog;

import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.blog.BlogDAO;
import com.doublechaintech.uxs.review.ReviewDAO;
import com.doublechaintech.uxs.rating.RatingDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ProductJDBCTemplateDAO extends UxsNamingServiceDAO implements ProductDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  RatingDAO  ratingDAO;
 	public void setRatingDAO(RatingDAO pRatingDAO){
 	
 		if(pRatingDAO == null){
 			throw new IllegalStateException("Do not try to set ratingDAO to null.");
 		}
	 	this.ratingDAO = pRatingDAO;
 	}
 	public RatingDAO getRatingDAO(){
 		if(this.ratingDAO == null){
 			throw new IllegalStateException("The ratingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.ratingDAO;
 	}	
 	
			
		
	
  	private  ReviewDAO  reviewDAO;
 	public void setReviewDAO(ReviewDAO pReviewDAO){
 	
 		if(pReviewDAO == null){
 			throw new IllegalStateException("Do not try to set reviewDAO to null.");
 		}
	 	this.reviewDAO = pReviewDAO;
 	}
 	public ReviewDAO getReviewDAO(){
 		if(this.reviewDAO == null){
 			throw new IllegalStateException("The reviewDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.reviewDAO;
 	}	
 	
			
		
	
  	private  BlogDAO  blogDAO;
 	public void setBlogDAO(BlogDAO pBlogDAO){
 	
 		if(pBlogDAO == null){
 			throw new IllegalStateException("Do not try to set blogDAO to null.");
 		}
	 	this.blogDAO = pBlogDAO;
 	}
 	public BlogDAO getBlogDAO(){
 		if(this.blogDAO == null){
 			throw new IllegalStateException("The blogDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.blogDAO;
 	}	
 	
			
		

	
	/*
	protected Product load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProduct(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Product load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProduct(ProductTable.withId(id), options);
	}
	
	
	
	public Product save(Product product,Map<String,Object> options){
		
		String methodName="save(Product product,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(product, methodName, "product");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProduct(product,options);
	}
	public Product clone(String productId, Map<String,Object> options) throws Exception{
	
		return clone(ProductTable.withId(productId),options);
	}
	
	protected Product clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String productId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Product newProduct = loadInternalProduct(accessKey, options);
		newProduct.setVersion(0);
		
		
 		
 		if(isSaveRatingListEnabled(options)){
 			for(Rating item: newProduct.getRatingList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveReviewListEnabled(options)){
 			for(Review item: newProduct.getReviewList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveBlogListEnabled(options)){
 			for(Blog item: newProduct.getBlogList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProduct(newProduct,options);
		
		return newProduct;
	}
	
	
	
	

	protected void throwIfHasException(String productId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProductNotFoundException(
					"The " + this.getTableName() + "(" + productId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String productId, int version) throws Exception{
	
		String methodName="delete(String productId, int version)";
		assertMethodArgumentNotNull(productId, methodName, "productId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{productId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(productId,version);
		}
		
	
	}
	
	
	
	
	

	public Product disconnectFromAll(String productId, int version) throws Exception{
	
		
		Product product = loadInternalProduct(ProductTable.withId(productId), emptyOptions());
		product.clearFromAll();
		this.saveProduct(product);
		return product;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "product";
	}
	@Override
	protected String getBeanName() {
		
		return "product";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProductTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProductTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProductTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractRatingListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProductTokens.RATING_LIST);
 	}
 	protected boolean isAnalyzeRatingListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProductTokens.RATING_LIST+".analyze");
 	}
	
	protected boolean isSaveRatingListEnabled(Map<String,Object> options){
		return checkOptions(options, ProductTokens.RATING_LIST);
		
 	}
 	
		
	
	protected boolean isExtractReviewListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProductTokens.REVIEW_LIST);
 	}
 	protected boolean isAnalyzeReviewListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProductTokens.REVIEW_LIST+".analyze");
 	}
	
	protected boolean isSaveReviewListEnabled(Map<String,Object> options){
		return checkOptions(options, ProductTokens.REVIEW_LIST);
		
 	}
 	
		
	
	protected boolean isExtractBlogListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProductTokens.BLOG_LIST);
 	}
 	protected boolean isAnalyzeBlogListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProductTokens.BLOG_LIST+".analyze");
 	}
	
	protected boolean isSaveBlogListEnabled(Map<String,Object> options){
		return checkOptions(options, ProductTokens.BLOG_LIST);
		
 	}
 	
		

	

	protected ProductMapper getProductMapper(){
		return new ProductMapper();
	}

	
	
	protected Product extractProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Product product = loadSingleObject(accessKey, getProductMapper());
			return product;
		}catch(EmptyResultDataAccessException e){
			throw new ProductNotFoundException("Product("+accessKey+") is not found!");
		}

	}

	
	

	protected Product loadInternalProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Product product = extractProduct(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(product, loadOptions);
 		}
 
		
		if(isExtractRatingListEnabled(loadOptions)){
	 		extractRatingList(product, loadOptions);
 		}	
 		if(isAnalyzeRatingListEnabled(loadOptions)){
	 		analyzeRatingList(product, loadOptions);
 		}
 		
		
		if(isExtractReviewListEnabled(loadOptions)){
	 		extractReviewList(product, loadOptions);
 		}	
 		if(isAnalyzeReviewListEnabled(loadOptions)){
	 		analyzeReviewList(product, loadOptions);
 		}
 		
		
		if(isExtractBlogListEnabled(loadOptions)){
	 		extractBlogList(product, loadOptions);
 		}	
 		if(isAnalyzeBlogListEnabled(loadOptions)){
	 		analyzeBlogList(product, loadOptions);
 		}
 		
		
		return product;
		
	}

	 

 	protected Product extractPlatform(Product product, Map<String,Object> options) throws Exception{

		if(product.getPlatform() == null){
			return product;
		}
		String platformId = product.getPlatform().getId();
		if( platformId == null){
			return product;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			product.setPlatform(platform);
		}
		
 		
 		return product;
 	}
 		
 
		
	protected void enhanceRatingList(SmartList<Rating> ratingList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Product extractRatingList(Product product, Map<String,Object> options){
		
		
		if(product == null){
			return null;
		}
		if(product.getId() == null){
			return product;
		}

		
		
		SmartList<Rating> ratingList = getRatingDAO().findRatingByProduct(product.getId(),options);
		if(ratingList != null){
			enhanceRatingList(ratingList,options);
			product.setRatingList(ratingList);
		}
		
		return product;
	
	}	
	
	protected Product analyzeRatingList(Product product, Map<String,Object> options){
		
		
		if(product == null){
			return null;
		}
		if(product.getId() == null){
			return product;
		}

		
		
		SmartList<Rating> ratingList = product.getRatingList();
		if(ratingList != null){
			getRatingDAO().analyzeRatingByProduct(ratingList, product.getId(), options);
			
		}
		
		return product;
	
	}	
	
		
	protected void enhanceReviewList(SmartList<Review> reviewList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Product extractReviewList(Product product, Map<String,Object> options){
		
		
		if(product == null){
			return null;
		}
		if(product.getId() == null){
			return product;
		}

		
		
		SmartList<Review> reviewList = getReviewDAO().findReviewByProduct(product.getId(),options);
		if(reviewList != null){
			enhanceReviewList(reviewList,options);
			product.setReviewList(reviewList);
		}
		
		return product;
	
	}	
	
	protected Product analyzeReviewList(Product product, Map<String,Object> options){
		
		
		if(product == null){
			return null;
		}
		if(product.getId() == null){
			return product;
		}

		
		
		SmartList<Review> reviewList = product.getReviewList();
		if(reviewList != null){
			getReviewDAO().analyzeReviewByProduct(reviewList, product.getId(), options);
			
		}
		
		return product;
	
	}	
	
		
	protected void enhanceBlogList(SmartList<Blog> blogList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Product extractBlogList(Product product, Map<String,Object> options){
		
		
		if(product == null){
			return null;
		}
		if(product.getId() == null){
			return product;
		}

		
		
		SmartList<Blog> blogList = getBlogDAO().findBlogByProduct(product.getId(),options);
		if(blogList != null){
			enhanceBlogList(blogList,options);
			product.setBlogList(blogList);
		}
		
		return product;
	
	}	
	
	protected Product analyzeBlogList(Product product, Map<String,Object> options){
		
		
		if(product == null){
			return null;
		}
		if(product.getId() == null){
			return product;
		}

		
		
		SmartList<Blog> blogList = product.getBlogList();
		if(blogList != null){
			getBlogDAO().analyzeBlogByProduct(blogList, product.getId(), options);
			
		}
		
		return product;
	
	}	
	
		
		
  	
 	public SmartList<Product> findProductByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Product> resultList = queryWith(ProductTable.COLUMN_PLATFORM, platformId, options, getProductMapper());
		// analyzeProductByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Product> findProductByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Product> resultList =  queryWithRange(ProductTable.COLUMN_PLATFORM, platformId, options, getProductMapper(), start, count);
 		//analyzeProductByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeProductByPlatform(SmartList<Product> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countProductByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ProductTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countProductByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProductTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Product saveProduct(Product  product){
		
		if(!product.isChanged()){
			return product;
		}
		
		
		String SQL=this.getSaveProductSQL(product);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProductParameters(product);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		product.incVersion();
		return product;
	
	}
	public SmartList<Product> saveProductList(SmartList<Product> productList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProductList(productList);
		
		batchProductCreate((List<Product>)lists[CREATE_LIST_INDEX]);
		
		batchProductUpdate((List<Product>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Product product:productList){
			if(product.isChanged()){
				product.incVersion();
			}
			
		
		}
		
		
		return productList;
	}

	public SmartList<Product> removeProductList(SmartList<Product> productList,Map<String,Object> options){
		
		
		super.removeList(productList, options);
		
		return productList;
		
		
	}
	
	protected List<Object[]> prepareProductBatchCreateArgs(List<Product> productList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Product product:productList ){
			Object [] parameters = prepareProductCreateParameters(product);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProductBatchUpdateArgs(List<Product> productList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Product product:productList ){
			if(!product.isChanged()){
				continue;
			}
			Object [] parameters = prepareProductUpdateParameters(product);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProductCreate(List<Product> productList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProductBatchCreateArgs(productList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProductUpdate(List<Product> productList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProductBatchUpdateArgs(productList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProductList(List<Product> productList){
		
		List<Product> productCreateList=new ArrayList<Product>();
		List<Product> productUpdateList=new ArrayList<Product>();
		
		for(Product product: productList){
			if(isUpdateRequest(product)){
				productUpdateList.add( product);
				continue;
			}
			productCreateList.add(product);
		}
		
		return new Object[]{productCreateList,productUpdateList};
	}
	
	protected boolean isUpdateRequest(Product product){
 		return product.getVersion() > 0;
 	}
 	protected String getSaveProductSQL(Product product){
 		if(isUpdateRequest(product)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProductParameters(Product product){
 		if(isUpdateRequest(product) ){
 			return prepareProductUpdateParameters(product);
 		}
 		return prepareProductCreateParameters(product);
 	}
 	protected Object[] prepareProductUpdateParameters(Product product){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = product.getName(); 	
 		if(product.getPlatform() != null){
 			parameters[1] = product.getPlatform().getId();
 		}
 
 		parameters[2] = product.getAvarageScore();		
 		parameters[3] = product.nextVersion();
 		parameters[4] = product.getId();
 		parameters[5] = product.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProductCreateParameters(Product product){
		Object[] parameters = new Object[4];
		String newProductId=getNextId();
		product.setId(newProductId);
		parameters[0] =  product.getId();
 
 		parameters[1] = product.getName(); 	
 		if(product.getPlatform() != null){
 			parameters[2] = product.getPlatform().getId();
 		
 		}
 		
 		parameters[3] = product.getAvarageScore();		
 				
 		return parameters;
 	}
 	
	protected Product saveInternalProduct(Product product, Map<String,Object> options){
		
		saveProduct(product);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(product, options);
 		}
 
		
		if(isSaveRatingListEnabled(options)){
	 		saveRatingList(product, options);
	 		//removeRatingList(product, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveReviewListEnabled(options)){
	 		saveReviewList(product, options);
	 		//removeReviewList(product, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveBlogListEnabled(options)){
	 		saveBlogList(product, options);
	 		//removeBlogList(product, options);
	 		//Not delete the record
	 		
 		}		
		
		return product;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Product savePlatform(Product product, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(product.getPlatform() == null){
 			return product;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(product.getPlatform(),options);
 		return product;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Product planToRemoveRatingList(Product product, String ratingIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Rating.PRODUCT_PROPERTY, product.getId());
		key.put(Rating.ID_PROPERTY, ratingIds);
		
		SmartList<Rating> externalRatingList = getRatingDAO().
				findRatingWithKey(key, options);
		if(externalRatingList == null){
			return product;
		}
		if(externalRatingList.isEmpty()){
			return product;
		}
		
		for(Rating rating: externalRatingList){

			rating.clearFromAll();
		}
		
		
		SmartList<Rating> ratingList = product.getRatingList();		
		ratingList.addAllToRemoveList(externalRatingList);
		return product;	
	
	}


	//disconnect Product with user in Rating
	public Product planToRemoveRatingListWithUser(Product product, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Rating.PRODUCT_PROPERTY, product.getId());
		key.put(Rating.USER_PROPERTY, userId);
		
		SmartList<Rating> externalRatingList = getRatingDAO().
				findRatingWithKey(key, options);
		if(externalRatingList == null){
			return product;
		}
		if(externalRatingList.isEmpty()){
			return product;
		}
		
		for(Rating rating: externalRatingList){
			rating.clearUser();
			rating.clearProduct();
			
		}
		
		
		SmartList<Rating> ratingList = product.getRatingList();		
		ratingList.addAllToRemoveList(externalRatingList);
		return product;
	}
	
	public int countRatingListWithUser(String productId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Rating.PRODUCT_PROPERTY, productId);
		key.put(Rating.USER_PROPERTY, userId);
		
		int count = getRatingDAO().countRatingWithKey(key, options);
		return count;
	}
	
	public Product planToRemoveReviewList(Product product, String reviewIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Review.PRODUCT_PROPERTY, product.getId());
		key.put(Review.ID_PROPERTY, reviewIds);
		
		SmartList<Review> externalReviewList = getReviewDAO().
				findReviewWithKey(key, options);
		if(externalReviewList == null){
			return product;
		}
		if(externalReviewList.isEmpty()){
			return product;
		}
		
		for(Review review: externalReviewList){

			review.clearFromAll();
		}
		
		
		SmartList<Review> reviewList = product.getReviewList();		
		reviewList.addAllToRemoveList(externalReviewList);
		return product;	
	
	}


	//disconnect Product with user in Review
	public Product planToRemoveReviewListWithUser(Product product, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Review.PRODUCT_PROPERTY, product.getId());
		key.put(Review.USER_PROPERTY, userId);
		
		SmartList<Review> externalReviewList = getReviewDAO().
				findReviewWithKey(key, options);
		if(externalReviewList == null){
			return product;
		}
		if(externalReviewList.isEmpty()){
			return product;
		}
		
		for(Review review: externalReviewList){
			review.clearUser();
			review.clearProduct();
			
		}
		
		
		SmartList<Review> reviewList = product.getReviewList();		
		reviewList.addAllToRemoveList(externalReviewList);
		return product;
	}
	
	public int countReviewListWithUser(String productId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Review.PRODUCT_PROPERTY, productId);
		key.put(Review.USER_PROPERTY, userId);
		
		int count = getReviewDAO().countReviewWithKey(key, options);
		return count;
	}
	
	public Product planToRemoveBlogList(Product product, String blogIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Blog.PRODUCT_PROPERTY, product.getId());
		key.put(Blog.ID_PROPERTY, blogIds);
		
		SmartList<Blog> externalBlogList = getBlogDAO().
				findBlogWithKey(key, options);
		if(externalBlogList == null){
			return product;
		}
		if(externalBlogList.isEmpty()){
			return product;
		}
		
		for(Blog blog: externalBlogList){

			blog.clearFromAll();
		}
		
		
		SmartList<Blog> blogList = product.getBlogList();		
		blogList.addAllToRemoveList(externalBlogList);
		return product;	
	
	}


	//disconnect Product with user in Blog
	public Product planToRemoveBlogListWithUser(Product product, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Blog.PRODUCT_PROPERTY, product.getId());
		key.put(Blog.USER_PROPERTY, userId);
		
		SmartList<Blog> externalBlogList = getBlogDAO().
				findBlogWithKey(key, options);
		if(externalBlogList == null){
			return product;
		}
		if(externalBlogList.isEmpty()){
			return product;
		}
		
		for(Blog blog: externalBlogList){
			blog.clearUser();
			blog.clearProduct();
			
		}
		
		
		SmartList<Blog> blogList = product.getBlogList();		
		blogList.addAllToRemoveList(externalBlogList);
		return product;
	}
	
	public int countBlogListWithUser(String productId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Blog.PRODUCT_PROPERTY, productId);
		key.put(Blog.USER_PROPERTY, userId);
		
		int count = getBlogDAO().countBlogWithKey(key, options);
		return count;
	}
	

		
	protected Product saveRatingList(Product product, Map<String,Object> options){
		
		
		
		
		SmartList<Rating> ratingList = product.getRatingList();
		if(ratingList == null){
			//null list means nothing
			return product;
		}
		SmartList<Rating> mergedUpdateRatingList = new SmartList<Rating>();
		
		
		mergedUpdateRatingList.addAll(ratingList); 
		if(ratingList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRatingList.addAll(ratingList.getToRemoveList());
			ratingList.removeAll(ratingList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRatingDAO().saveRatingList(mergedUpdateRatingList,options);
		
		if(ratingList.getToRemoveList() != null){
			ratingList.removeAll(ratingList.getToRemoveList());
		}
		
		
		return product;
	
	}
	
	protected Product removeRatingList(Product product, Map<String,Object> options){
	
	
		SmartList<Rating> ratingList = product.getRatingList();
		if(ratingList == null){
			return product;
		}	
	
		SmartList<Rating> toRemoveRatingList = ratingList.getToRemoveList();
		
		if(toRemoveRatingList == null){
			return product;
		}
		if(toRemoveRatingList.isEmpty()){
			return product;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRatingDAO().removeRatingList(toRemoveRatingList,options);
		
		return product;
	
	}
	
	

 	
 	
	
	
	
		
	protected Product saveReviewList(Product product, Map<String,Object> options){
		
		
		
		
		SmartList<Review> reviewList = product.getReviewList();
		if(reviewList == null){
			//null list means nothing
			return product;
		}
		SmartList<Review> mergedUpdateReviewList = new SmartList<Review>();
		
		
		mergedUpdateReviewList.addAll(reviewList); 
		if(reviewList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateReviewList.addAll(reviewList.getToRemoveList());
			reviewList.removeAll(reviewList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getReviewDAO().saveReviewList(mergedUpdateReviewList,options);
		
		if(reviewList.getToRemoveList() != null){
			reviewList.removeAll(reviewList.getToRemoveList());
		}
		
		
		return product;
	
	}
	
	protected Product removeReviewList(Product product, Map<String,Object> options){
	
	
		SmartList<Review> reviewList = product.getReviewList();
		if(reviewList == null){
			return product;
		}	
	
		SmartList<Review> toRemoveReviewList = reviewList.getToRemoveList();
		
		if(toRemoveReviewList == null){
			return product;
		}
		if(toRemoveReviewList.isEmpty()){
			return product;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getReviewDAO().removeReviewList(toRemoveReviewList,options);
		
		return product;
	
	}
	
	

 	
 	
	
	
	
		
	protected Product saveBlogList(Product product, Map<String,Object> options){
		
		
		
		
		SmartList<Blog> blogList = product.getBlogList();
		if(blogList == null){
			//null list means nothing
			return product;
		}
		SmartList<Blog> mergedUpdateBlogList = new SmartList<Blog>();
		
		
		mergedUpdateBlogList.addAll(blogList); 
		if(blogList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateBlogList.addAll(blogList.getToRemoveList());
			blogList.removeAll(blogList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getBlogDAO().saveBlogList(mergedUpdateBlogList,options);
		
		if(blogList.getToRemoveList() != null){
			blogList.removeAll(blogList.getToRemoveList());
		}
		
		
		return product;
	
	}
	
	protected Product removeBlogList(Product product, Map<String,Object> options){
	
	
		SmartList<Blog> blogList = product.getBlogList();
		if(blogList == null){
			return product;
		}	
	
		SmartList<Blog> toRemoveBlogList = blogList.getToRemoveList();
		
		if(toRemoveBlogList == null){
			return product;
		}
		if(toRemoveBlogList.isEmpty()){
			return product;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getBlogDAO().removeBlogList(toRemoveBlogList,options);
		
		return product;
	
	}
	
	

 	
 	
	
	
	
		

	public Product present(Product product,Map<String, Object> options){
	
		presentRatingList(product,options);
		presentReviewList(product,options);
		presentBlogList(product,options);

		return product;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Product presentRatingList(
			Product product,
			Map<String, Object> options) {

		SmartList<Rating> ratingList = product.getRatingList();		
				SmartList<Rating> newList= presentSubList(product.getId(),
				ratingList,
				options,
				getRatingDAO()::countRatingByProduct,
				getRatingDAO()::findRatingByProduct
				);

		
		product.setRatingList(newList);
		

		return product;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Product presentReviewList(
			Product product,
			Map<String, Object> options) {

		SmartList<Review> reviewList = product.getReviewList();		
				SmartList<Review> newList= presentSubList(product.getId(),
				reviewList,
				options,
				getReviewDAO()::countReviewByProduct,
				getReviewDAO()::findReviewByProduct
				);

		
		product.setReviewList(newList);
		

		return product;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Product presentBlogList(
			Product product,
			Map<String, Object> options) {

		SmartList<Blog> blogList = product.getBlogList();		
				SmartList<Blog> newList= presentSubList(product.getId(),
				blogList,
				options,
				getBlogDAO()::countBlogByProduct,
				getBlogDAO()::findBlogByProduct
				);

		
		product.setBlogList(newList);
		

		return product;
	}			
		

	
    public SmartList<Product> requestCandidateProductForRating(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProductTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProductMapper());
    }
		
    public SmartList<Product> requestCandidateProductForReview(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProductTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProductMapper());
    }
		
    public SmartList<Product> requestCandidateProductForBlog(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProductTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProductMapper());
    }
		

	protected String getTableName(){
		return ProductTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Product> productList) {		
		this.enhanceListInternal(productList, this.getProductMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Product> productList = ownerEntity.collectRefsWithType(Product.INTERNAL_TYPE);
		this.enhanceList(productList);
		
	}
	
	@Override
	public SmartList<Product> findProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getProductMapper());

	}
	@Override
	public int countProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Product> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProductMapper());
	}
}


