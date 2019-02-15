
package com.doublechaintech.uxs.rating;

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

public class RatingJDBCTemplateDAO extends UxsNamingServiceDAO implements RatingDAO{
 
 	
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
	protected Rating load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRating(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Rating load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRating(RatingTable.withId(id), options);
	}
	
	
	
	public Rating save(Rating rating,Map<String,Object> options){
		
		String methodName="save(Rating rating,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(rating, methodName, "rating");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRating(rating,options);
	}
	public Rating clone(String ratingId, Map<String,Object> options) throws Exception{
	
		return clone(RatingTable.withId(ratingId),options);
	}
	
	protected Rating clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String ratingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Rating newRating = loadInternalRating(accessKey, options);
		newRating.setVersion(0);
		
		

		
		saveInternalRating(newRating,options);
		
		return newRating;
	}
	
	
	
	

	protected void throwIfHasException(String ratingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RatingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RatingNotFoundException(
					"The " + this.getTableName() + "(" + ratingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String ratingId, int version) throws Exception{
	
		String methodName="delete(String ratingId, int version)";
		assertMethodArgumentNotNull(ratingId, methodName, "ratingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{ratingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(ratingId,version);
		}
		
	
	}
	
	
	
	
	

	public Rating disconnectFromAll(String ratingId, int version) throws Exception{
	
		
		Rating rating = loadInternalRating(RatingTable.withId(ratingId), emptyOptions());
		rating.clearFromAll();
		this.saveRating(rating);
		return rating;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RatingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "rating";
	}
	@Override
	protected String getBeanName() {
		
		return "rating";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RatingTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RatingTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RatingTokens.USER);
 	}
 	

 	
  

 	protected boolean isExtractProductEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RatingTokens.PRODUCT);
 	}

 	protected boolean isSaveProductEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RatingTokens.PRODUCT);
 	}
 	

 	
 
		

	

	protected RatingMapper getRatingMapper(){
		return new RatingMapper();
	}

	
	
	protected Rating extractRating(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Rating rating = loadSingleObject(accessKey, getRatingMapper());
			return rating;
		}catch(EmptyResultDataAccessException e){
			throw new RatingNotFoundException("Rating("+accessKey+") is not found!");
		}

	}

	
	

	protected Rating loadInternalRating(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Rating rating = extractRating(accessKey, loadOptions);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(rating, loadOptions);
 		}
  	
 		if(isExtractProductEnabled(loadOptions)){
	 		extractProduct(rating, loadOptions);
 		}
 
		
		return rating;
		
	}

	 

 	protected Rating extractUser(Rating rating, Map<String,Object> options) throws Exception{

		if(rating.getUser() == null){
			return rating;
		}
		String userId = rating.getUser().getId();
		if( userId == null){
			return rating;
		}
		Profile user = getProfileDAO().load(userId,options);
		if(user != null){
			rating.setUser(user);
		}
		
 		
 		return rating;
 	}
 		
  

 	protected Rating extractProduct(Rating rating, Map<String,Object> options) throws Exception{

		if(rating.getProduct() == null){
			return rating;
		}
		String productId = rating.getProduct().getId();
		if( productId == null){
			return rating;
		}
		Product product = getProductDAO().load(productId,options);
		if(product != null){
			rating.setProduct(product);
		}
		
 		
 		return rating;
 	}
 		
 
		
		
  	
 	public SmartList<Rating> findRatingByUser(String profileId,Map<String,Object> options){
 	
  		SmartList<Rating> resultList = queryWith(RatingTable.COLUMN_USER, profileId, options, getRatingMapper());
		// analyzeRatingByUser(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Rating> findRatingByUser(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Rating> resultList =  queryWithRange(RatingTable.COLUMN_USER, profileId, options, getRatingMapper(), start, count);
 		//analyzeRatingByUser(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeRatingByUser(SmartList<Rating> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Rating.USER_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Rating.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Rating");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Rating.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Rating.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRatingByUser(String profileId,Map<String,Object> options){

 		return countWith(RatingTable.COLUMN_USER, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countRatingByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RatingTable.COLUMN_USER, ids, options);
	}
 	
  	
 	public SmartList<Rating> findRatingByProduct(String productId,Map<String,Object> options){
 	
  		SmartList<Rating> resultList = queryWith(RatingTable.COLUMN_PRODUCT, productId, options, getRatingMapper());
		// analyzeRatingByProduct(resultList, productId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Rating> findRatingByProduct(String productId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Rating> resultList =  queryWithRange(RatingTable.COLUMN_PRODUCT, productId, options, getRatingMapper(), start, count);
 		//analyzeRatingByProduct(resultList, productId, options);
 		return resultList;
 		
 	}
 	public void analyzeRatingByProduct(SmartList<Rating> resultList, String productId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Rating.PRODUCT_PROPERTY, productId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Rating.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Rating");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Rating.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Rating.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRatingByProduct(String productId,Map<String,Object> options){

 		return countWith(RatingTable.COLUMN_PRODUCT, productId, options);
 	}
 	@Override
	public Map<String, Integer> countRatingByProductIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RatingTable.COLUMN_PRODUCT, ids, options);
	}
 	
 	
		
		
		

	

	protected Rating saveRating(Rating  rating){
		
		if(!rating.isChanged()){
			return rating;
		}
		
		
		String SQL=this.getSaveRatingSQL(rating);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRatingParameters(rating);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		rating.incVersion();
		return rating;
	
	}
	public SmartList<Rating> saveRatingList(SmartList<Rating> ratingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRatingList(ratingList);
		
		batchRatingCreate((List<Rating>)lists[CREATE_LIST_INDEX]);
		
		batchRatingUpdate((List<Rating>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Rating rating:ratingList){
			if(rating.isChanged()){
				rating.incVersion();
			}
			
		
		}
		
		
		return ratingList;
	}

	public SmartList<Rating> removeRatingList(SmartList<Rating> ratingList,Map<String,Object> options){
		
		
		super.removeList(ratingList, options);
		
		return ratingList;
		
		
	}
	
	protected List<Object[]> prepareRatingBatchCreateArgs(List<Rating> ratingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Rating rating:ratingList ){
			Object [] parameters = prepareRatingCreateParameters(rating);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRatingBatchUpdateArgs(List<Rating> ratingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Rating rating:ratingList ){
			if(!rating.isChanged()){
				continue;
			}
			Object [] parameters = prepareRatingUpdateParameters(rating);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRatingCreate(List<Rating> ratingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRatingBatchCreateArgs(ratingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRatingUpdate(List<Rating> ratingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRatingBatchUpdateArgs(ratingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRatingList(List<Rating> ratingList){
		
		List<Rating> ratingCreateList=new ArrayList<Rating>();
		List<Rating> ratingUpdateList=new ArrayList<Rating>();
		
		for(Rating rating: ratingList){
			if(isUpdateRequest(rating)){
				ratingUpdateList.add( rating);
				continue;
			}
			ratingCreateList.add(rating);
		}
		
		return new Object[]{ratingCreateList,ratingUpdateList};
	}
	
	protected boolean isUpdateRequest(Rating rating){
 		return rating.getVersion() > 0;
 	}
 	protected String getSaveRatingSQL(Rating rating){
 		if(isUpdateRequest(rating)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRatingParameters(Rating rating){
 		if(isUpdateRequest(rating) ){
 			return prepareRatingUpdateParameters(rating);
 		}
 		return prepareRatingCreateParameters(rating);
 	}
 	protected Object[] prepareRatingUpdateParameters(Rating rating){
 		Object[] parameters = new Object[7];
  	
 		if(rating.getUser() != null){
 			parameters[0] = rating.getUser().getId();
 		}
  	
 		if(rating.getProduct() != null){
 			parameters[1] = rating.getProduct().getId();
 		}
 
 		parameters[2] = rating.getScore();
 		parameters[3] = rating.getUpdateTime();		
 		parameters[4] = rating.nextVersion();
 		parameters[5] = rating.getId();
 		parameters[6] = rating.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRatingCreateParameters(Rating rating){
		Object[] parameters = new Object[5];
		String newRatingId=getNextId();
		rating.setId(newRatingId);
		parameters[0] =  rating.getId();
  	
 		if(rating.getUser() != null){
 			parameters[1] = rating.getUser().getId();
 		
 		}
 		 	
 		if(rating.getProduct() != null){
 			parameters[2] = rating.getProduct().getId();
 		
 		}
 		
 		parameters[3] = rating.getScore();
 		parameters[4] = rating.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected Rating saveInternalRating(Rating rating, Map<String,Object> options){
		
		saveRating(rating);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(rating, options);
 		}
  	
 		if(isSaveProductEnabled(options)){
	 		saveProduct(rating, options);
 		}
 
		
		return rating;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Rating saveUser(Rating rating, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(rating.getUser() == null){
 			return rating;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(rating.getUser(),options);
 		return rating;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Rating saveProduct(Rating rating, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(rating.getProduct() == null){
 			return rating;//do nothing when it is null
 		}
 		
 		getProductDAO().save(rating.getProduct(),options);
 		return rating;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Rating present(Rating rating,Map<String, Object> options){
	

		return rating;
	
	}
		

	

	protected String getTableName(){
		return RatingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Rating> ratingList) {		
		this.enhanceListInternal(ratingList, this.getRatingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Rating> ratingList = ownerEntity.collectRefsWithType(Rating.INTERNAL_TYPE);
		this.enhanceList(ratingList);
		
	}
	
	@Override
	public SmartList<Rating> findRatingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRatingMapper());

	}
	@Override
	public int countRatingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRatingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Rating> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRatingMapper());
	}
}


