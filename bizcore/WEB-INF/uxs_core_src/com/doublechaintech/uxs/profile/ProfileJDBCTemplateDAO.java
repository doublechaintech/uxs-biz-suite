
package com.doublechaintech.uxs.profile;

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
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.blog.Blog;

import com.doublechaintech.uxs.target.TargetDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.blog.BlogDAO;
import com.doublechaintech.uxs.review.ReviewDAO;
import com.doublechaintech.uxs.rating.RatingDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ProfileJDBCTemplateDAO extends UxsNamingServiceDAO implements ProfileDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  TargetDAO  targetDAO;
 	public void setTargetDAO(TargetDAO pTargetDAO){
 	
 		if(pTargetDAO == null){
 			throw new IllegalStateException("Do not try to set targetDAO to null.");
 		}
	 	this.targetDAO = pTargetDAO;
 	}
 	public TargetDAO getTargetDAO(){
 		if(this.targetDAO == null){
 			throw new IllegalStateException("The targetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.targetDAO;
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
	protected Profile load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProfile(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Profile load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProfile(ProfileTable.withId(id), options);
	}
	
	
	
	public Profile save(Profile profile,Map<String,Object> options){
		
		String methodName="save(Profile profile,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(profile, methodName, "profile");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProfile(profile,options);
	}
	public Profile clone(String profileId, Map<String,Object> options) throws Exception{
	
		return clone(ProfileTable.withId(profileId),options);
	}
	
	protected Profile clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String profileId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Profile newProfile = loadInternalProfile(accessKey, options);
		newProfile.setVersion(0);
		
		
 		
 		if(isSaveTargetListEnabled(options)){
 			for(Target item: newProfile.getTargetList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRatingListEnabled(options)){
 			for(Rating item: newProfile.getRatingList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveReviewListEnabled(options)){
 			for(Review item: newProfile.getReviewList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveBlogListEnabled(options)){
 			for(Blog item: newProfile.getBlogList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProfile(newProfile,options);
		
		return newProfile;
	}
	
	
	
	

	protected void throwIfHasException(String profileId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProfileVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProfileNotFoundException(
					"The " + this.getTableName() + "(" + profileId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String profileId, int version) throws Exception{
	
		String methodName="delete(String profileId, int version)";
		assertMethodArgumentNotNull(profileId, methodName, "profileId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{profileId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(profileId,version);
		}
		
	
	}
	
	
	
	
	

	public Profile disconnectFromAll(String profileId, int version) throws Exception{
	
		
		Profile profile = loadInternalProfile(ProfileTable.withId(profileId), emptyOptions());
		profile.clearFromAll();
		this.saveProfile(profile);
		return profile;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ProfileTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "profile";
	}
	@Override
	protected String getBeanName() {
		
		return "profile";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProfileTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProfileTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProfileTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractTargetListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.TARGET_LIST);
 	}
 	protected boolean isAnalyzeTargetListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.TARGET_LIST+".analyze");
 	}
	
	protected boolean isSaveTargetListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.TARGET_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRatingListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.RATING_LIST);
 	}
 	protected boolean isAnalyzeRatingListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.RATING_LIST+".analyze");
 	}
	
	protected boolean isSaveRatingListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.RATING_LIST);
		
 	}
 	
		
	
	protected boolean isExtractReviewListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.REVIEW_LIST);
 	}
 	protected boolean isAnalyzeReviewListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.REVIEW_LIST+".analyze");
 	}
	
	protected boolean isSaveReviewListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.REVIEW_LIST);
		
 	}
 	
		
	
	protected boolean isExtractBlogListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.BLOG_LIST);
 	}
 	protected boolean isAnalyzeBlogListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.BLOG_LIST+".analyze");
 	}
	
	protected boolean isSaveBlogListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.BLOG_LIST);
		
 	}
 	
		

	

	protected ProfileMapper getProfileMapper(){
		return new ProfileMapper();
	}

	
	
	protected Profile extractProfile(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Profile profile = loadSingleObject(accessKey, getProfileMapper());
			return profile;
		}catch(EmptyResultDataAccessException e){
			throw new ProfileNotFoundException("Profile("+accessKey+") is not found!");
		}

	}

	
	

	protected Profile loadInternalProfile(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Profile profile = extractProfile(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(profile, loadOptions);
 		}
 
		
		if(isExtractTargetListEnabled(loadOptions)){
	 		extractTargetList(profile, loadOptions);
 		}	
 		if(isAnalyzeTargetListEnabled(loadOptions)){
	 		analyzeTargetList(profile, loadOptions);
 		}
 		
		
		if(isExtractRatingListEnabled(loadOptions)){
	 		extractRatingList(profile, loadOptions);
 		}	
 		if(isAnalyzeRatingListEnabled(loadOptions)){
	 		analyzeRatingList(profile, loadOptions);
 		}
 		
		
		if(isExtractReviewListEnabled(loadOptions)){
	 		extractReviewList(profile, loadOptions);
 		}	
 		if(isAnalyzeReviewListEnabled(loadOptions)){
	 		analyzeReviewList(profile, loadOptions);
 		}
 		
		
		if(isExtractBlogListEnabled(loadOptions)){
	 		extractBlogList(profile, loadOptions);
 		}	
 		if(isAnalyzeBlogListEnabled(loadOptions)){
	 		analyzeBlogList(profile, loadOptions);
 		}
 		
		
		return profile;
		
	}

	 

 	protected Profile extractPlatform(Profile profile, Map<String,Object> options) throws Exception{

		if(profile.getPlatform() == null){
			return profile;
		}
		String platformId = profile.getPlatform().getId();
		if( platformId == null){
			return profile;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			profile.setPlatform(platform);
		}
		
 		
 		return profile;
 	}
 		
 
		
	protected void enhanceTargetList(SmartList<Target> targetList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractTargetList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<Target> targetList = getTargetDAO().findTargetByProfile(profile.getId(),options);
		if(targetList != null){
			enhanceTargetList(targetList,options);
			profile.setTargetList(targetList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeTargetList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<Target> targetList = profile.getTargetList();
		if(targetList != null){
			getTargetDAO().analyzeTargetByProfile(targetList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceRatingList(SmartList<Rating> ratingList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractRatingList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<Rating> ratingList = getRatingDAO().findRatingByUser(profile.getId(),options);
		if(ratingList != null){
			enhanceRatingList(ratingList,options);
			profile.setRatingList(ratingList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeRatingList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<Rating> ratingList = profile.getRatingList();
		if(ratingList != null){
			getRatingDAO().analyzeRatingByUser(ratingList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceReviewList(SmartList<Review> reviewList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractReviewList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<Review> reviewList = getReviewDAO().findReviewByUser(profile.getId(),options);
		if(reviewList != null){
			enhanceReviewList(reviewList,options);
			profile.setReviewList(reviewList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeReviewList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<Review> reviewList = profile.getReviewList();
		if(reviewList != null){
			getReviewDAO().analyzeReviewByUser(reviewList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceBlogList(SmartList<Blog> blogList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractBlogList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<Blog> blogList = getBlogDAO().findBlogByUser(profile.getId(),options);
		if(blogList != null){
			enhanceBlogList(blogList,options);
			profile.setBlogList(blogList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeBlogList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<Blog> blogList = profile.getBlogList();
		if(blogList != null){
			getBlogDAO().analyzeBlogByUser(blogList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
		
  	
 	public SmartList<Profile> findProfileByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Profile> resultList = queryWith(ProfileTable.COLUMN_PLATFORM, platformId, options, getProfileMapper());
		// analyzeProfileByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Profile> findProfileByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Profile> resultList =  queryWithRange(ProfileTable.COLUMN_PLATFORM, platformId, options, getProfileMapper(), start, count);
 		//analyzeProfileByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeProfileByPlatform(SmartList<Profile> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countProfileByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ProfileTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countProfileByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProfileTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Profile saveProfile(Profile  profile){
		
		if(!profile.isChanged()){
			return profile;
		}
		
		
		String SQL=this.getSaveProfileSQL(profile);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProfileParameters(profile);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		profile.incVersion();
		return profile;
	
	}
	public SmartList<Profile> saveProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProfileList(profileList);
		
		batchProfileCreate((List<Profile>)lists[CREATE_LIST_INDEX]);
		
		batchProfileUpdate((List<Profile>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Profile profile:profileList){
			if(profile.isChanged()){
				profile.incVersion();
			}
			
		
		}
		
		
		return profileList;
	}

	public SmartList<Profile> removeProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		
		
		super.removeList(profileList, options);
		
		return profileList;
		
		
	}
	
	protected List<Object[]> prepareProfileBatchCreateArgs(List<Profile> profileList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Profile profile:profileList ){
			Object [] parameters = prepareProfileCreateParameters(profile);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProfileBatchUpdateArgs(List<Profile> profileList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Profile profile:profileList ){
			if(!profile.isChanged()){
				continue;
			}
			Object [] parameters = prepareProfileUpdateParameters(profile);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProfileCreate(List<Profile> profileList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProfileBatchCreateArgs(profileList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProfileUpdate(List<Profile> profileList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProfileBatchUpdateArgs(profileList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProfileList(List<Profile> profileList){
		
		List<Profile> profileCreateList=new ArrayList<Profile>();
		List<Profile> profileUpdateList=new ArrayList<Profile>();
		
		for(Profile profile: profileList){
			if(isUpdateRequest(profile)){
				profileUpdateList.add( profile);
				continue;
			}
			profileCreateList.add(profile);
		}
		
		return new Object[]{profileCreateList,profileUpdateList};
	}
	
	protected boolean isUpdateRequest(Profile profile){
 		return profile.getVersion() > 0;
 	}
 	protected String getSaveProfileSQL(Profile profile){
 		if(isUpdateRequest(profile)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProfileParameters(Profile profile){
 		if(isUpdateRequest(profile) ){
 			return prepareProfileUpdateParameters(profile);
 		}
 		return prepareProfileCreateParameters(profile);
 	}
 	protected Object[] prepareProfileUpdateParameters(Profile profile){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = profile.getName(); 	
 		if(profile.getPlatform() != null){
 			parameters[1] = profile.getPlatform().getId();
 		}
 		
 		parameters[2] = profile.nextVersion();
 		parameters[3] = profile.getId();
 		parameters[4] = profile.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProfileCreateParameters(Profile profile){
		Object[] parameters = new Object[3];
		String newProfileId=getNextId();
		profile.setId(newProfileId);
		parameters[0] =  profile.getId();
 
 		parameters[1] = profile.getName(); 	
 		if(profile.getPlatform() != null){
 			parameters[2] = profile.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Profile saveInternalProfile(Profile profile, Map<String,Object> options){
		
		saveProfile(profile);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(profile, options);
 		}
 
		
		if(isSaveTargetListEnabled(options)){
	 		saveTargetList(profile, options);
	 		//removeTargetList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRatingListEnabled(options)){
	 		saveRatingList(profile, options);
	 		//removeRatingList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveReviewListEnabled(options)){
	 		saveReviewList(profile, options);
	 		//removeReviewList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveBlogListEnabled(options)){
	 		saveBlogList(profile, options);
	 		//removeBlogList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		return profile;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Profile savePlatform(Profile profile, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(profile.getPlatform() == null){
 			return profile;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(profile.getPlatform(),options);
 		return profile;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Profile planToRemoveTargetList(Profile profile, String targetIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.PROFILE_PROPERTY, profile.getId());
		key.put(Target.ID_PROPERTY, targetIds);
		
		SmartList<Target> externalTargetList = getTargetDAO().
				findTargetWithKey(key, options);
		if(externalTargetList == null){
			return profile;
		}
		if(externalTargetList.isEmpty()){
			return profile;
		}
		
		for(Target target: externalTargetList){

			target.clearFromAll();
		}
		
		
		SmartList<Target> targetList = profile.getTargetList();		
		targetList.addAllToRemoveList(externalTargetList);
		return profile;	
	
	}


	//disconnect Profile with banner in Target
	public Profile planToRemoveTargetListWithBanner(Profile profile, String bannerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.PROFILE_PROPERTY, profile.getId());
		key.put(Target.BANNER_PROPERTY, bannerId);
		
		SmartList<Target> externalTargetList = getTargetDAO().
				findTargetWithKey(key, options);
		if(externalTargetList == null){
			return profile;
		}
		if(externalTargetList.isEmpty()){
			return profile;
		}
		
		for(Target target: externalTargetList){
			target.clearBanner();
			target.clearProfile();
			
		}
		
		
		SmartList<Target> targetList = profile.getTargetList();		
		targetList.addAllToRemoveList(externalTargetList);
		return profile;
	}
	
	public int countTargetListWithBanner(String profileId, String bannerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.PROFILE_PROPERTY, profileId);
		key.put(Target.BANNER_PROPERTY, bannerId);
		
		int count = getTargetDAO().countTargetWithKey(key, options);
		return count;
	}
	
	public Profile planToRemoveRatingList(Profile profile, String ratingIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Rating.USER_PROPERTY, profile.getId());
		key.put(Rating.ID_PROPERTY, ratingIds);
		
		SmartList<Rating> externalRatingList = getRatingDAO().
				findRatingWithKey(key, options);
		if(externalRatingList == null){
			return profile;
		}
		if(externalRatingList.isEmpty()){
			return profile;
		}
		
		for(Rating rating: externalRatingList){

			rating.clearFromAll();
		}
		
		
		SmartList<Rating> ratingList = profile.getRatingList();		
		ratingList.addAllToRemoveList(externalRatingList);
		return profile;	
	
	}


	//disconnect Profile with product in Rating
	public Profile planToRemoveRatingListWithProduct(Profile profile, String productId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Rating.USER_PROPERTY, profile.getId());
		key.put(Rating.PRODUCT_PROPERTY, productId);
		
		SmartList<Rating> externalRatingList = getRatingDAO().
				findRatingWithKey(key, options);
		if(externalRatingList == null){
			return profile;
		}
		if(externalRatingList.isEmpty()){
			return profile;
		}
		
		for(Rating rating: externalRatingList){
			rating.clearProduct();
			rating.clearUser();
			
		}
		
		
		SmartList<Rating> ratingList = profile.getRatingList();		
		ratingList.addAllToRemoveList(externalRatingList);
		return profile;
	}
	
	public int countRatingListWithProduct(String profileId, String productId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Rating.USER_PROPERTY, profileId);
		key.put(Rating.PRODUCT_PROPERTY, productId);
		
		int count = getRatingDAO().countRatingWithKey(key, options);
		return count;
	}
	
	public Profile planToRemoveReviewList(Profile profile, String reviewIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Review.USER_PROPERTY, profile.getId());
		key.put(Review.ID_PROPERTY, reviewIds);
		
		SmartList<Review> externalReviewList = getReviewDAO().
				findReviewWithKey(key, options);
		if(externalReviewList == null){
			return profile;
		}
		if(externalReviewList.isEmpty()){
			return profile;
		}
		
		for(Review review: externalReviewList){

			review.clearFromAll();
		}
		
		
		SmartList<Review> reviewList = profile.getReviewList();		
		reviewList.addAllToRemoveList(externalReviewList);
		return profile;	
	
	}


	//disconnect Profile with product in Review
	public Profile planToRemoveReviewListWithProduct(Profile profile, String productId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Review.USER_PROPERTY, profile.getId());
		key.put(Review.PRODUCT_PROPERTY, productId);
		
		SmartList<Review> externalReviewList = getReviewDAO().
				findReviewWithKey(key, options);
		if(externalReviewList == null){
			return profile;
		}
		if(externalReviewList.isEmpty()){
			return profile;
		}
		
		for(Review review: externalReviewList){
			review.clearProduct();
			review.clearUser();
			
		}
		
		
		SmartList<Review> reviewList = profile.getReviewList();		
		reviewList.addAllToRemoveList(externalReviewList);
		return profile;
	}
	
	public int countReviewListWithProduct(String profileId, String productId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Review.USER_PROPERTY, profileId);
		key.put(Review.PRODUCT_PROPERTY, productId);
		
		int count = getReviewDAO().countReviewWithKey(key, options);
		return count;
	}
	
	public Profile planToRemoveBlogList(Profile profile, String blogIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Blog.USER_PROPERTY, profile.getId());
		key.put(Blog.ID_PROPERTY, blogIds);
		
		SmartList<Blog> externalBlogList = getBlogDAO().
				findBlogWithKey(key, options);
		if(externalBlogList == null){
			return profile;
		}
		if(externalBlogList.isEmpty()){
			return profile;
		}
		
		for(Blog blog: externalBlogList){

			blog.clearFromAll();
		}
		
		
		SmartList<Blog> blogList = profile.getBlogList();		
		blogList.addAllToRemoveList(externalBlogList);
		return profile;	
	
	}


	//disconnect Profile with product in Blog
	public Profile planToRemoveBlogListWithProduct(Profile profile, String productId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Blog.USER_PROPERTY, profile.getId());
		key.put(Blog.PRODUCT_PROPERTY, productId);
		
		SmartList<Blog> externalBlogList = getBlogDAO().
				findBlogWithKey(key, options);
		if(externalBlogList == null){
			return profile;
		}
		if(externalBlogList.isEmpty()){
			return profile;
		}
		
		for(Blog blog: externalBlogList){
			blog.clearProduct();
			blog.clearUser();
			
		}
		
		
		SmartList<Blog> blogList = profile.getBlogList();		
		blogList.addAllToRemoveList(externalBlogList);
		return profile;
	}
	
	public int countBlogListWithProduct(String profileId, String productId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Blog.USER_PROPERTY, profileId);
		key.put(Blog.PRODUCT_PROPERTY, productId);
		
		int count = getBlogDAO().countBlogWithKey(key, options);
		return count;
	}
	

		
	protected Profile saveTargetList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<Target> targetList = profile.getTargetList();
		if(targetList == null){
			//null list means nothing
			return profile;
		}
		SmartList<Target> mergedUpdateTargetList = new SmartList<Target>();
		
		
		mergedUpdateTargetList.addAll(targetList); 
		if(targetList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTargetList.addAll(targetList.getToRemoveList());
			targetList.removeAll(targetList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTargetDAO().saveTargetList(mergedUpdateTargetList,options);
		
		if(targetList.getToRemoveList() != null){
			targetList.removeAll(targetList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeTargetList(Profile profile, Map<String,Object> options){
	
	
		SmartList<Target> targetList = profile.getTargetList();
		if(targetList == null){
			return profile;
		}	
	
		SmartList<Target> toRemoveTargetList = targetList.getToRemoveList();
		
		if(toRemoveTargetList == null){
			return profile;
		}
		if(toRemoveTargetList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTargetDAO().removeTargetList(toRemoveTargetList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveRatingList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<Rating> ratingList = profile.getRatingList();
		if(ratingList == null){
			//null list means nothing
			return profile;
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
		
		
		return profile;
	
	}
	
	protected Profile removeRatingList(Profile profile, Map<String,Object> options){
	
	
		SmartList<Rating> ratingList = profile.getRatingList();
		if(ratingList == null){
			return profile;
		}	
	
		SmartList<Rating> toRemoveRatingList = ratingList.getToRemoveList();
		
		if(toRemoveRatingList == null){
			return profile;
		}
		if(toRemoveRatingList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRatingDAO().removeRatingList(toRemoveRatingList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveReviewList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<Review> reviewList = profile.getReviewList();
		if(reviewList == null){
			//null list means nothing
			return profile;
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
		
		
		return profile;
	
	}
	
	protected Profile removeReviewList(Profile profile, Map<String,Object> options){
	
	
		SmartList<Review> reviewList = profile.getReviewList();
		if(reviewList == null){
			return profile;
		}	
	
		SmartList<Review> toRemoveReviewList = reviewList.getToRemoveList();
		
		if(toRemoveReviewList == null){
			return profile;
		}
		if(toRemoveReviewList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getReviewDAO().removeReviewList(toRemoveReviewList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveBlogList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<Blog> blogList = profile.getBlogList();
		if(blogList == null){
			//null list means nothing
			return profile;
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
		
		
		return profile;
	
	}
	
	protected Profile removeBlogList(Profile profile, Map<String,Object> options){
	
	
		SmartList<Blog> blogList = profile.getBlogList();
		if(blogList == null){
			return profile;
		}	
	
		SmartList<Blog> toRemoveBlogList = blogList.getToRemoveList();
		
		if(toRemoveBlogList == null){
			return profile;
		}
		if(toRemoveBlogList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getBlogDAO().removeBlogList(toRemoveBlogList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		

	public Profile present(Profile profile,Map<String, Object> options){
	
		presentTargetList(profile,options);
		presentRatingList(profile,options);
		presentReviewList(profile,options);
		presentBlogList(profile,options);

		return profile;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentTargetList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<Target> targetList = profile.getTargetList();		
				SmartList<Target> newList= presentSubList(profile.getId(),
				targetList,
				options,
				getTargetDAO()::countTargetByProfile,
				getTargetDAO()::findTargetByProfile
				);

		
		profile.setTargetList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentRatingList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<Rating> ratingList = profile.getRatingList();		
				SmartList<Rating> newList= presentSubList(profile.getId(),
				ratingList,
				options,
				getRatingDAO()::countRatingByUser,
				getRatingDAO()::findRatingByUser
				);

		
		profile.setRatingList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentReviewList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<Review> reviewList = profile.getReviewList();		
				SmartList<Review> newList= presentSubList(profile.getId(),
				reviewList,
				options,
				getReviewDAO()::countReviewByUser,
				getReviewDAO()::findReviewByUser
				);

		
		profile.setReviewList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentBlogList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<Blog> blogList = profile.getBlogList();		
				SmartList<Blog> newList= presentSubList(profile.getId(),
				blogList,
				options,
				getBlogDAO()::countBlogByUser,
				getBlogDAO()::findBlogByUser
				);

		
		profile.setBlogList(newList);
		

		return profile;
	}			
		

	
    public SmartList<Profile> requestCandidateProfileForTarget(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForRating(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForReview(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForBlog(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		

	protected String getTableName(){
		return ProfileTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Profile> profileList) {		
		this.enhanceListInternal(profileList, this.getProfileMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Profile> profileList = ownerEntity.collectRefsWithType(Profile.INTERNAL_TYPE);
		this.enhanceList(profileList);
		
	}
	
	@Override
	public SmartList<Profile> findProfileWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getProfileMapper());

	}
	@Override
	public int countProfileWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countProfileWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Profile> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProfileMapper());
	}
}


