
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

import com.doublechaintech.uxs.target.TargetDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.pricefilter.PriceFilterDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.blog.BlogDAO;
import com.doublechaintech.uxs.review.ReviewDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.categoryfilter.CategoryFilterDAO;
import com.doublechaintech.uxs.useralert.UserAlertDAO;
import com.doublechaintech.uxs.rating.RatingDAO;
import com.doublechaintech.uxs.brandfilter.BrandFilterDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ProfileJDBCTemplateDAO extends UxsNamingServiceDAO implements ProfileDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  UserAlertDAO  userAlertDAO;
 	public void setUserAlertDAO(UserAlertDAO pUserAlertDAO){
 	
 		if(pUserAlertDAO == null){
 			throw new IllegalStateException("Do not try to set userAlertDAO to null.");
 		}
	 	this.userAlertDAO = pUserAlertDAO;
 	}
 	public UserAlertDAO getUserAlertDAO(){
 		if(this.userAlertDAO == null){
 			throw new IllegalStateException("The userAlertDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAlertDAO;
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
 	
			
		
	
  	private  BrandFilterDAO  brandFilterDAO;
 	public void setBrandFilterDAO(BrandFilterDAO pBrandFilterDAO){
 	
 		if(pBrandFilterDAO == null){
 			throw new IllegalStateException("Do not try to set brandFilterDAO to null.");
 		}
	 	this.brandFilterDAO = pBrandFilterDAO;
 	}
 	public BrandFilterDAO getBrandFilterDAO(){
 		if(this.brandFilterDAO == null){
 			throw new IllegalStateException("The brandFilterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.brandFilterDAO;
 	}	
 	
			
		
	
  	private  PriceFilterDAO  priceFilterDAO;
 	public void setPriceFilterDAO(PriceFilterDAO pPriceFilterDAO){
 	
 		if(pPriceFilterDAO == null){
 			throw new IllegalStateException("Do not try to set priceFilterDAO to null.");
 		}
	 	this.priceFilterDAO = pPriceFilterDAO;
 	}
 	public PriceFilterDAO getPriceFilterDAO(){
 		if(this.priceFilterDAO == null){
 			throw new IllegalStateException("The priceFilterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.priceFilterDAO;
 	}	
 	
			
		
	
  	private  CategoryFilterDAO  categoryFilterDAO;
 	public void setCategoryFilterDAO(CategoryFilterDAO pCategoryFilterDAO){
 	
 		if(pCategoryFilterDAO == null){
 			throw new IllegalStateException("Do not try to set categoryFilterDAO to null.");
 		}
	 	this.categoryFilterDAO = pCategoryFilterDAO;
 	}
 	public CategoryFilterDAO getCategoryFilterDAO(){
 		if(this.categoryFilterDAO == null){
 			throw new IllegalStateException("The categoryFilterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.categoryFilterDAO;
 	}	
 	
			
		
	
  	private  NewProductDAO  newProductDAO;
 	public void setNewProductDAO(NewProductDAO pNewProductDAO){
 	
 		if(pNewProductDAO == null){
 			throw new IllegalStateException("Do not try to set newProductDAO to null.");
 		}
	 	this.newProductDAO = pNewProductDAO;
 	}
 	public NewProductDAO getNewProductDAO(){
 		if(this.newProductDAO == null){
 			throw new IllegalStateException("The newProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.newProductDAO;
 	}	
 	
			
		
	
  	private  EditorPickProductDAO  editorPickProductDAO;
 	public void setEditorPickProductDAO(EditorPickProductDAO pEditorPickProductDAO){
 	
 		if(pEditorPickProductDAO == null){
 			throw new IllegalStateException("Do not try to set editorPickProductDAO to null.");
 		}
	 	this.editorPickProductDAO = pEditorPickProductDAO;
 	}
 	public EditorPickProductDAO getEditorPickProductDAO(){
 		if(this.editorPickProductDAO == null){
 			throw new IllegalStateException("The editorPickProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.editorPickProductDAO;
 	}	
 	
			
		
	
  	private  TopRatedProductDAO  topRatedProductDAO;
 	public void setTopRatedProductDAO(TopRatedProductDAO pTopRatedProductDAO){
 	
 		if(pTopRatedProductDAO == null){
 			throw new IllegalStateException("Do not try to set topRatedProductDAO to null.");
 		}
	 	this.topRatedProductDAO = pTopRatedProductDAO;
 	}
 	public TopRatedProductDAO getTopRatedProductDAO(){
 		if(this.topRatedProductDAO == null){
 			throw new IllegalStateException("The topRatedProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.topRatedProductDAO;
 	}	
 	
			
		
	
  	private  RecommandProductDAO  recommandProductDAO;
 	public void setRecommandProductDAO(RecommandProductDAO pRecommandProductDAO){
 	
 		if(pRecommandProductDAO == null){
 			throw new IllegalStateException("Do not try to set recommandProductDAO to null.");
 		}
	 	this.recommandProductDAO = pRecommandProductDAO;
 	}
 	public RecommandProductDAO getRecommandProductDAO(){
 		if(this.recommandProductDAO == null){
 			throw new IllegalStateException("The recommandProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.recommandProductDAO;
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
		
		
 		
 		if(isSaveUserAlertListEnabled(options)){
 			for(UserAlert item: newProfile.getUserAlertList()){
 				item.setVersion(0);
 			}
 		}
		
 		
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
		
 		
 		if(isSaveBrandFilterListEnabled(options)){
 			for(BrandFilter item: newProfile.getBrandFilterList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePriceFilterListEnabled(options)){
 			for(PriceFilter item: newProfile.getPriceFilterList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCategoryFilterListEnabled(options)){
 			for(CategoryFilter item: newProfile.getCategoryFilterList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveNewProductListEnabled(options)){
 			for(NewProduct item: newProfile.getNewProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEditorPickProductListEnabled(options)){
 			for(EditorPickProduct item: newProfile.getEditorPickProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTopRatedProductListEnabled(options)){
 			for(TopRatedProduct item: newProfile.getTopRatedProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRecommandProductListEnabled(options)){
 			for(RecommandProduct item: newProfile.getRecommandProductList()){
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
 	

 	
 
		
	
	protected boolean isExtractUserAlertListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.USER_ALERT_LIST);
 	}
 	protected boolean isAnalyzeUserAlertListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.USER_ALERT_LIST+".analyze");
 	}
	
	protected boolean isSaveUserAlertListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.USER_ALERT_LIST);
		
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
 	
		
	
	protected boolean isExtractBrandFilterListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.BRAND_FILTER_LIST);
 	}
 	protected boolean isAnalyzeBrandFilterListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.BRAND_FILTER_LIST+".analyze");
 	}
	
	protected boolean isSaveBrandFilterListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.BRAND_FILTER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractPriceFilterListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.PRICE_FILTER_LIST);
 	}
 	protected boolean isAnalyzePriceFilterListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.PRICE_FILTER_LIST+".analyze");
 	}
	
	protected boolean isSavePriceFilterListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.PRICE_FILTER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractCategoryFilterListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.CATEGORY_FILTER_LIST);
 	}
 	protected boolean isAnalyzeCategoryFilterListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.CATEGORY_FILTER_LIST+".analyze");
 	}
	
	protected boolean isSaveCategoryFilterListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.CATEGORY_FILTER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractNewProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.NEW_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeNewProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.NEW_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveNewProductListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.NEW_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractEditorPickProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.EDITOR_PICK_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeEditorPickProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.EDITOR_PICK_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveEditorPickProductListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.EDITOR_PICK_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTopRatedProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.TOP_RATED_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeTopRatedProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.TOP_RATED_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveTopRatedProductListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.TOP_RATED_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRecommandProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfileTokens.RECOMMAND_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeRecommandProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfileTokens.RECOMMAND_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveRecommandProductListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfileTokens.RECOMMAND_PRODUCT_LIST);
		
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
 
		
		if(isExtractUserAlertListEnabled(loadOptions)){
	 		extractUserAlertList(profile, loadOptions);
 		}	
 		if(isAnalyzeUserAlertListEnabled(loadOptions)){
	 		analyzeUserAlertList(profile, loadOptions);
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
 		
		
		if(isExtractBrandFilterListEnabled(loadOptions)){
	 		extractBrandFilterList(profile, loadOptions);
 		}	
 		if(isAnalyzeBrandFilterListEnabled(loadOptions)){
	 		analyzeBrandFilterList(profile, loadOptions);
 		}
 		
		
		if(isExtractPriceFilterListEnabled(loadOptions)){
	 		extractPriceFilterList(profile, loadOptions);
 		}	
 		if(isAnalyzePriceFilterListEnabled(loadOptions)){
	 		analyzePriceFilterList(profile, loadOptions);
 		}
 		
		
		if(isExtractCategoryFilterListEnabled(loadOptions)){
	 		extractCategoryFilterList(profile, loadOptions);
 		}	
 		if(isAnalyzeCategoryFilterListEnabled(loadOptions)){
	 		analyzeCategoryFilterList(profile, loadOptions);
 		}
 		
		
		if(isExtractNewProductListEnabled(loadOptions)){
	 		extractNewProductList(profile, loadOptions);
 		}	
 		if(isAnalyzeNewProductListEnabled(loadOptions)){
	 		analyzeNewProductList(profile, loadOptions);
 		}
 		
		
		if(isExtractEditorPickProductListEnabled(loadOptions)){
	 		extractEditorPickProductList(profile, loadOptions);
 		}	
 		if(isAnalyzeEditorPickProductListEnabled(loadOptions)){
	 		analyzeEditorPickProductList(profile, loadOptions);
 		}
 		
		
		if(isExtractTopRatedProductListEnabled(loadOptions)){
	 		extractTopRatedProductList(profile, loadOptions);
 		}	
 		if(isAnalyzeTopRatedProductListEnabled(loadOptions)){
	 		analyzeTopRatedProductList(profile, loadOptions);
 		}
 		
		
		if(isExtractRecommandProductListEnabled(loadOptions)){
	 		extractRecommandProductList(profile, loadOptions);
 		}	
 		if(isAnalyzeRecommandProductListEnabled(loadOptions)){
	 		analyzeRecommandProductList(profile, loadOptions);
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
 		
 
		
	protected void enhanceUserAlertList(SmartList<UserAlert> userAlertList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractUserAlertList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<UserAlert> userAlertList = getUserAlertDAO().findUserAlertByProfile(profile.getId(),options);
		if(userAlertList != null){
			enhanceUserAlertList(userAlertList,options);
			profile.setUserAlertList(userAlertList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeUserAlertList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<UserAlert> userAlertList = profile.getUserAlertList();
		if(userAlertList != null){
			getUserAlertDAO().analyzeUserAlertByProfile(userAlertList, profile.getId(), options);
			
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
	
		
	protected void enhanceBrandFilterList(SmartList<BrandFilter> brandFilterList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractBrandFilterList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<BrandFilter> brandFilterList = getBrandFilterDAO().findBrandFilterByProfile(profile.getId(),options);
		if(brandFilterList != null){
			enhanceBrandFilterList(brandFilterList,options);
			profile.setBrandFilterList(brandFilterList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeBrandFilterList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<BrandFilter> brandFilterList = profile.getBrandFilterList();
		if(brandFilterList != null){
			getBrandFilterDAO().analyzeBrandFilterByProfile(brandFilterList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhancePriceFilterList(SmartList<PriceFilter> priceFilterList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractPriceFilterList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<PriceFilter> priceFilterList = getPriceFilterDAO().findPriceFilterByProfile(profile.getId(),options);
		if(priceFilterList != null){
			enhancePriceFilterList(priceFilterList,options);
			profile.setPriceFilterList(priceFilterList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzePriceFilterList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<PriceFilter> priceFilterList = profile.getPriceFilterList();
		if(priceFilterList != null){
			getPriceFilterDAO().analyzePriceFilterByProfile(priceFilterList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceCategoryFilterList(SmartList<CategoryFilter> categoryFilterList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractCategoryFilterList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<CategoryFilter> categoryFilterList = getCategoryFilterDAO().findCategoryFilterByProfile(profile.getId(),options);
		if(categoryFilterList != null){
			enhanceCategoryFilterList(categoryFilterList,options);
			profile.setCategoryFilterList(categoryFilterList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeCategoryFilterList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<CategoryFilter> categoryFilterList = profile.getCategoryFilterList();
		if(categoryFilterList != null){
			getCategoryFilterDAO().analyzeCategoryFilterByProfile(categoryFilterList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractNewProductList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<NewProduct> newProductList = getNewProductDAO().findNewProductByProfile(profile.getId(),options);
		if(newProductList != null){
			enhanceNewProductList(newProductList,options);
			profile.setNewProductList(newProductList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeNewProductList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<NewProduct> newProductList = profile.getNewProductList();
		if(newProductList != null){
			getNewProductDAO().analyzeNewProductByProfile(newProductList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractEditorPickProductList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = getEditorPickProductDAO().findEditorPickProductByProfile(profile.getId(),options);
		if(editorPickProductList != null){
			enhanceEditorPickProductList(editorPickProductList,options);
			profile.setEditorPickProductList(editorPickProductList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeEditorPickProductList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();
		if(editorPickProductList != null){
			getEditorPickProductDAO().analyzeEditorPickProductByProfile(editorPickProductList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractTopRatedProductList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = getTopRatedProductDAO().findTopRatedProductByProfile(profile.getId(),options);
		if(topRatedProductList != null){
			enhanceTopRatedProductList(topRatedProductList,options);
			profile.setTopRatedProductList(topRatedProductList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeTopRatedProductList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();
		if(topRatedProductList != null){
			getTopRatedProductDAO().analyzeTopRatedProductByProfile(topRatedProductList, profile.getId(), options);
			
		}
		
		return profile;
	
	}	
	
		
	protected void enhanceRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Profile extractRecommandProductList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = getRecommandProductDAO().findRecommandProductByProfile(profile.getId(),options);
		if(recommandProductList != null){
			enhanceRecommandProductList(recommandProductList,options);
			profile.setRecommandProductList(recommandProductList);
		}
		
		return profile;
	
	}	
	
	protected Profile analyzeRecommandProductList(Profile profile, Map<String,Object> options){
		
		
		if(profile == null){
			return null;
		}
		if(profile.getId() == null){
			return profile;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();
		if(recommandProductList != null){
			getRecommandProductDAO().analyzeRecommandProductByProfile(recommandProductList, profile.getId(), options);
			
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
 
		
		if(isSaveUserAlertListEnabled(options)){
	 		saveUserAlertList(profile, options);
	 		//removeUserAlertList(profile, options);
	 		//Not delete the record
	 		
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
		
		if(isSaveBrandFilterListEnabled(options)){
	 		saveBrandFilterList(profile, options);
	 		//removeBrandFilterList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSavePriceFilterListEnabled(options)){
	 		savePriceFilterList(profile, options);
	 		//removePriceFilterList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveCategoryFilterListEnabled(options)){
	 		saveCategoryFilterList(profile, options);
	 		//removeCategoryFilterList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveNewProductListEnabled(options)){
	 		saveNewProductList(profile, options);
	 		//removeNewProductList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveEditorPickProductListEnabled(options)){
	 		saveEditorPickProductList(profile, options);
	 		//removeEditorPickProductList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTopRatedProductListEnabled(options)){
	 		saveTopRatedProductList(profile, options);
	 		//removeTopRatedProductList(profile, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRecommandProductListEnabled(options)){
	 		saveRecommandProductList(profile, options);
	 		//removeRecommandProductList(profile, options);
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
 	
 	
 	
 	 
	
 

	
	public Profile planToRemoveUserAlertList(Profile profile, String userAlertIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PROFILE_PROPERTY, profile.getId());
		key.put(UserAlert.ID_PROPERTY, userAlertIds);
		
		SmartList<UserAlert> externalUserAlertList = getUserAlertDAO().
				findUserAlertWithKey(key, options);
		if(externalUserAlertList == null){
			return profile;
		}
		if(externalUserAlertList.isEmpty()){
			return profile;
		}
		
		for(UserAlert userAlert: externalUserAlertList){

			userAlert.clearFromAll();
		}
		
		
		SmartList<UserAlert> userAlertList = profile.getUserAlertList();		
		userAlertList.addAllToRemoveList(externalUserAlertList);
		return profile;	
	
	}


	//disconnect Profile with platform in UserAlert
	public Profile planToRemoveUserAlertListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PROFILE_PROPERTY, profile.getId());
		key.put(UserAlert.PLATFORM_PROPERTY, platformId);
		
		SmartList<UserAlert> externalUserAlertList = getUserAlertDAO().
				findUserAlertWithKey(key, options);
		if(externalUserAlertList == null){
			return profile;
		}
		if(externalUserAlertList.isEmpty()){
			return profile;
		}
		
		for(UserAlert userAlert: externalUserAlertList){
			userAlert.clearPlatform();
			userAlert.clearProfile();
			
		}
		
		
		SmartList<UserAlert> userAlertList = profile.getUserAlertList();		
		userAlertList.addAllToRemoveList(externalUserAlertList);
		return profile;
	}
	
	public int countUserAlertListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PROFILE_PROPERTY, profileId);
		key.put(UserAlert.PLATFORM_PROPERTY, platformId);
		
		int count = getUserAlertDAO().countUserAlertWithKey(key, options);
		return count;
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
	
	public Profile planToRemoveBrandFilterList(Profile profile, String brandFilterIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(BrandFilter.PROFILE_PROPERTY, profile.getId());
		key.put(BrandFilter.ID_PROPERTY, brandFilterIds);
		
		SmartList<BrandFilter> externalBrandFilterList = getBrandFilterDAO().
				findBrandFilterWithKey(key, options);
		if(externalBrandFilterList == null){
			return profile;
		}
		if(externalBrandFilterList.isEmpty()){
			return profile;
		}
		
		for(BrandFilter brandFilter: externalBrandFilterList){

			brandFilter.clearFromAll();
		}
		
		
		SmartList<BrandFilter> brandFilterList = profile.getBrandFilterList();		
		brandFilterList.addAllToRemoveList(externalBrandFilterList);
		return profile;	
	
	}


	//disconnect Profile with internal_id in BrandFilter
	public Profile planToRemoveBrandFilterListWithInternalId(Profile profile, String internalIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(BrandFilter.PROFILE_PROPERTY, profile.getId());
		key.put(BrandFilter.INTERNAL_ID_PROPERTY, internalIdId);
		
		SmartList<BrandFilter> externalBrandFilterList = getBrandFilterDAO().
				findBrandFilterWithKey(key, options);
		if(externalBrandFilterList == null){
			return profile;
		}
		if(externalBrandFilterList.isEmpty()){
			return profile;
		}
		
		for(BrandFilter brandFilter: externalBrandFilterList){
			brandFilter.clearInternalId();
			brandFilter.clearProfile();
			
		}
		
		
		SmartList<BrandFilter> brandFilterList = profile.getBrandFilterList();		
		brandFilterList.addAllToRemoveList(externalBrandFilterList);
		return profile;
	}
	
	public int countBrandFilterListWithInternalId(String profileId, String internalIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(BrandFilter.PROFILE_PROPERTY, profileId);
		key.put(BrandFilter.INTERNAL_ID_PROPERTY, internalIdId);
		
		int count = getBrandFilterDAO().countBrandFilterWithKey(key, options);
		return count;
	}
	
	public Profile planToRemovePriceFilterList(Profile profile, String priceFilterIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PriceFilter.PROFILE_PROPERTY, profile.getId());
		key.put(PriceFilter.ID_PROPERTY, priceFilterIds);
		
		SmartList<PriceFilter> externalPriceFilterList = getPriceFilterDAO().
				findPriceFilterWithKey(key, options);
		if(externalPriceFilterList == null){
			return profile;
		}
		if(externalPriceFilterList.isEmpty()){
			return profile;
		}
		
		for(PriceFilter priceFilter: externalPriceFilterList){

			priceFilter.clearFromAll();
		}
		
		
		SmartList<PriceFilter> priceFilterList = profile.getPriceFilterList();		
		priceFilterList.addAllToRemoveList(externalPriceFilterList);
		return profile;	
	
	}


	public Profile planToRemoveCategoryFilterList(Profile profile, String categoryFilterIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CategoryFilter.PROFILE_PROPERTY, profile.getId());
		key.put(CategoryFilter.ID_PROPERTY, categoryFilterIds);
		
		SmartList<CategoryFilter> externalCategoryFilterList = getCategoryFilterDAO().
				findCategoryFilterWithKey(key, options);
		if(externalCategoryFilterList == null){
			return profile;
		}
		if(externalCategoryFilterList.isEmpty()){
			return profile;
		}
		
		for(CategoryFilter categoryFilter: externalCategoryFilterList){

			categoryFilter.clearFromAll();
		}
		
		
		SmartList<CategoryFilter> categoryFilterList = profile.getCategoryFilterList();		
		categoryFilterList.addAllToRemoveList(externalCategoryFilterList);
		return profile;	
	
	}


	//disconnect Profile with internal_id in CategoryFilter
	public Profile planToRemoveCategoryFilterListWithInternalId(Profile profile, String internalIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CategoryFilter.PROFILE_PROPERTY, profile.getId());
		key.put(CategoryFilter.INTERNAL_ID_PROPERTY, internalIdId);
		
		SmartList<CategoryFilter> externalCategoryFilterList = getCategoryFilterDAO().
				findCategoryFilterWithKey(key, options);
		if(externalCategoryFilterList == null){
			return profile;
		}
		if(externalCategoryFilterList.isEmpty()){
			return profile;
		}
		
		for(CategoryFilter categoryFilter: externalCategoryFilterList){
			categoryFilter.clearInternalId();
			categoryFilter.clearProfile();
			
		}
		
		
		SmartList<CategoryFilter> categoryFilterList = profile.getCategoryFilterList();		
		categoryFilterList.addAllToRemoveList(externalCategoryFilterList);
		return profile;
	}
	
	public int countCategoryFilterListWithInternalId(String profileId, String internalIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CategoryFilter.PROFILE_PROPERTY, profileId);
		key.put(CategoryFilter.INTERNAL_ID_PROPERTY, internalIdId);
		
		int count = getCategoryFilterDAO().countCategoryFilterWithKey(key, options);
		return count;
	}
	
	public Profile planToRemoveNewProductList(Profile profile, String newProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profile.getId());
		key.put(NewProduct.ID_PROPERTY, newProductIds);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return profile;
		}
		if(externalNewProductList.isEmpty()){
			return profile;
		}
		
		for(NewProduct newProduct: externalNewProductList){

			newProduct.clearFromAll();
		}
		
		
		SmartList<NewProduct> newProductList = profile.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return profile;	
	
	}


	//disconnect Profile with parent_category in NewProduct
	public Profile planToRemoveNewProductListWithParentCategory(Profile profile, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profile.getId());
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return profile;
		}
		if(externalNewProductList.isEmpty()){
			return profile;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearParentCategory();
			newProduct.clearProfile();
			
		}
		
		
		SmartList<NewProduct> newProductList = profile.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return profile;
	}
	
	public int countNewProductListWithParentCategory(String profileId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with brand in NewProduct
	public Profile planToRemoveNewProductListWithBrand(Profile profile, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profile.getId());
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return profile;
		}
		if(externalNewProductList.isEmpty()){
			return profile;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearBrand();
			newProduct.clearProfile();
			
		}
		
		
		SmartList<NewProduct> newProductList = profile.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return profile;
	}
	
	public int countNewProductListWithBrand(String profileId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with catalog in NewProduct
	public Profile planToRemoveNewProductListWithCatalog(Profile profile, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profile.getId());
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return profile;
		}
		if(externalNewProductList.isEmpty()){
			return profile;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearCatalog();
			newProduct.clearProfile();
			
		}
		
		
		SmartList<NewProduct> newProductList = profile.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return profile;
	}
	
	public int countNewProductListWithCatalog(String profileId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with platform in NewProduct
	public Profile planToRemoveNewProductListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profile.getId());
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return profile;
		}
		if(externalNewProductList.isEmpty()){
			return profile;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearPlatform();
			newProduct.clearProfile();
			
		}
		
		
		SmartList<NewProduct> newProductList = profile.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return profile;
	}
	
	public int countNewProductListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	public Profile planToRemoveEditorPickProductList(Profile profile, String editorPickProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profile.getId());
		key.put(EditorPickProduct.ID_PROPERTY, editorPickProductIds);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return profile;
		}
		if(externalEditorPickProductList.isEmpty()){
			return profile;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){

			editorPickProduct.clearFromAll();
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return profile;	
	
	}


	//disconnect Profile with parent_category in EditorPickProduct
	public Profile planToRemoveEditorPickProductListWithParentCategory(Profile profile, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profile.getId());
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return profile;
		}
		if(externalEditorPickProductList.isEmpty()){
			return profile;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearParentCategory();
			editorPickProduct.clearProfile();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return profile;
	}
	
	public int countEditorPickProductListWithParentCategory(String profileId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with brand in EditorPickProduct
	public Profile planToRemoveEditorPickProductListWithBrand(Profile profile, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profile.getId());
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return profile;
		}
		if(externalEditorPickProductList.isEmpty()){
			return profile;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearBrand();
			editorPickProduct.clearProfile();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return profile;
	}
	
	public int countEditorPickProductListWithBrand(String profileId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with catalog in EditorPickProduct
	public Profile planToRemoveEditorPickProductListWithCatalog(Profile profile, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profile.getId());
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return profile;
		}
		if(externalEditorPickProductList.isEmpty()){
			return profile;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearCatalog();
			editorPickProduct.clearProfile();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return profile;
	}
	
	public int countEditorPickProductListWithCatalog(String profileId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with platform in EditorPickProduct
	public Profile planToRemoveEditorPickProductListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profile.getId());
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return profile;
		}
		if(externalEditorPickProductList.isEmpty()){
			return profile;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearPlatform();
			editorPickProduct.clearProfile();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return profile;
	}
	
	public int countEditorPickProductListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	public Profile planToRemoveTopRatedProductList(Profile profile, String topRatedProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profile.getId());
		key.put(TopRatedProduct.ID_PROPERTY, topRatedProductIds);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return profile;
		}
		if(externalTopRatedProductList.isEmpty()){
			return profile;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){

			topRatedProduct.clearFromAll();
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return profile;	
	
	}


	//disconnect Profile with parent_category in TopRatedProduct
	public Profile planToRemoveTopRatedProductListWithParentCategory(Profile profile, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profile.getId());
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return profile;
		}
		if(externalTopRatedProductList.isEmpty()){
			return profile;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearParentCategory();
			topRatedProduct.clearProfile();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return profile;
	}
	
	public int countTopRatedProductListWithParentCategory(String profileId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with brand in TopRatedProduct
	public Profile planToRemoveTopRatedProductListWithBrand(Profile profile, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profile.getId());
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return profile;
		}
		if(externalTopRatedProductList.isEmpty()){
			return profile;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearBrand();
			topRatedProduct.clearProfile();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return profile;
	}
	
	public int countTopRatedProductListWithBrand(String profileId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with catalog in TopRatedProduct
	public Profile planToRemoveTopRatedProductListWithCatalog(Profile profile, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profile.getId());
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return profile;
		}
		if(externalTopRatedProductList.isEmpty()){
			return profile;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearCatalog();
			topRatedProduct.clearProfile();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return profile;
	}
	
	public int countTopRatedProductListWithCatalog(String profileId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with platform in TopRatedProduct
	public Profile planToRemoveTopRatedProductListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profile.getId());
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return profile;
		}
		if(externalTopRatedProductList.isEmpty()){
			return profile;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearPlatform();
			topRatedProduct.clearProfile();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return profile;
	}
	
	public int countTopRatedProductListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	public Profile planToRemoveRecommandProductList(Profile profile, String recommandProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profile.getId());
		key.put(RecommandProduct.ID_PROPERTY, recommandProductIds);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return profile;
		}
		if(externalRecommandProductList.isEmpty()){
			return profile;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){

			recommandProduct.clearFromAll();
		}
		
		
		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return profile;	
	
	}


	//disconnect Profile with parent_category in RecommandProduct
	public Profile planToRemoveRecommandProductListWithParentCategory(Profile profile, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profile.getId());
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return profile;
		}
		if(externalRecommandProductList.isEmpty()){
			return profile;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearParentCategory();
			recommandProduct.clearProfile();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return profile;
	}
	
	public int countRecommandProductListWithParentCategory(String profileId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with brand in RecommandProduct
	public Profile planToRemoveRecommandProductListWithBrand(Profile profile, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profile.getId());
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return profile;
		}
		if(externalRecommandProductList.isEmpty()){
			return profile;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearBrand();
			recommandProduct.clearProfile();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return profile;
	}
	
	public int countRecommandProductListWithBrand(String profileId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with catalog in RecommandProduct
	public Profile planToRemoveRecommandProductListWithCatalog(Profile profile, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profile.getId());
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return profile;
		}
		if(externalRecommandProductList.isEmpty()){
			return profile;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearCatalog();
			recommandProduct.clearProfile();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return profile;
	}
	
	public int countRecommandProductListWithCatalog(String profileId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Profile with platform in RecommandProduct
	public Profile planToRemoveRecommandProductListWithPlatform(Profile profile, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profile.getId());
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return profile;
		}
		if(externalRecommandProductList.isEmpty()){
			return profile;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearPlatform();
			recommandProduct.clearProfile();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return profile;
	}
	
	public int countRecommandProductListWithPlatform(String profileId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	

		
	protected Profile saveUserAlertList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<UserAlert> userAlertList = profile.getUserAlertList();
		if(userAlertList == null){
			//null list means nothing
			return profile;
		}
		SmartList<UserAlert> mergedUpdateUserAlertList = new SmartList<UserAlert>();
		
		
		mergedUpdateUserAlertList.addAll(userAlertList); 
		if(userAlertList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserAlertList.addAll(userAlertList.getToRemoveList());
			userAlertList.removeAll(userAlertList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserAlertDAO().saveUserAlertList(mergedUpdateUserAlertList,options);
		
		if(userAlertList.getToRemoveList() != null){
			userAlertList.removeAll(userAlertList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeUserAlertList(Profile profile, Map<String,Object> options){
	
	
		SmartList<UserAlert> userAlertList = profile.getUserAlertList();
		if(userAlertList == null){
			return profile;
		}	
	
		SmartList<UserAlert> toRemoveUserAlertList = userAlertList.getToRemoveList();
		
		if(toRemoveUserAlertList == null){
			return profile;
		}
		if(toRemoveUserAlertList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserAlertDAO().removeUserAlertList(toRemoveUserAlertList,options);
		
		return profile;
	
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
	
	

 	
 	
	
	
	
		
	protected Profile saveBrandFilterList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<BrandFilter> brandFilterList = profile.getBrandFilterList();
		if(brandFilterList == null){
			//null list means nothing
			return profile;
		}
		SmartList<BrandFilter> mergedUpdateBrandFilterList = new SmartList<BrandFilter>();
		
		
		mergedUpdateBrandFilterList.addAll(brandFilterList); 
		if(brandFilterList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateBrandFilterList.addAll(brandFilterList.getToRemoveList());
			brandFilterList.removeAll(brandFilterList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getBrandFilterDAO().saveBrandFilterList(mergedUpdateBrandFilterList,options);
		
		if(brandFilterList.getToRemoveList() != null){
			brandFilterList.removeAll(brandFilterList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeBrandFilterList(Profile profile, Map<String,Object> options){
	
	
		SmartList<BrandFilter> brandFilterList = profile.getBrandFilterList();
		if(brandFilterList == null){
			return profile;
		}	
	
		SmartList<BrandFilter> toRemoveBrandFilterList = brandFilterList.getToRemoveList();
		
		if(toRemoveBrandFilterList == null){
			return profile;
		}
		if(toRemoveBrandFilterList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getBrandFilterDAO().removeBrandFilterList(toRemoveBrandFilterList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile savePriceFilterList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<PriceFilter> priceFilterList = profile.getPriceFilterList();
		if(priceFilterList == null){
			//null list means nothing
			return profile;
		}
		SmartList<PriceFilter> mergedUpdatePriceFilterList = new SmartList<PriceFilter>();
		
		
		mergedUpdatePriceFilterList.addAll(priceFilterList); 
		if(priceFilterList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePriceFilterList.addAll(priceFilterList.getToRemoveList());
			priceFilterList.removeAll(priceFilterList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getPriceFilterDAO().savePriceFilterList(mergedUpdatePriceFilterList,options);
		
		if(priceFilterList.getToRemoveList() != null){
			priceFilterList.removeAll(priceFilterList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removePriceFilterList(Profile profile, Map<String,Object> options){
	
	
		SmartList<PriceFilter> priceFilterList = profile.getPriceFilterList();
		if(priceFilterList == null){
			return profile;
		}	
	
		SmartList<PriceFilter> toRemovePriceFilterList = priceFilterList.getToRemoveList();
		
		if(toRemovePriceFilterList == null){
			return profile;
		}
		if(toRemovePriceFilterList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPriceFilterDAO().removePriceFilterList(toRemovePriceFilterList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveCategoryFilterList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<CategoryFilter> categoryFilterList = profile.getCategoryFilterList();
		if(categoryFilterList == null){
			//null list means nothing
			return profile;
		}
		SmartList<CategoryFilter> mergedUpdateCategoryFilterList = new SmartList<CategoryFilter>();
		
		
		mergedUpdateCategoryFilterList.addAll(categoryFilterList); 
		if(categoryFilterList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCategoryFilterList.addAll(categoryFilterList.getToRemoveList());
			categoryFilterList.removeAll(categoryFilterList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCategoryFilterDAO().saveCategoryFilterList(mergedUpdateCategoryFilterList,options);
		
		if(categoryFilterList.getToRemoveList() != null){
			categoryFilterList.removeAll(categoryFilterList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeCategoryFilterList(Profile profile, Map<String,Object> options){
	
	
		SmartList<CategoryFilter> categoryFilterList = profile.getCategoryFilterList();
		if(categoryFilterList == null){
			return profile;
		}	
	
		SmartList<CategoryFilter> toRemoveCategoryFilterList = categoryFilterList.getToRemoveList();
		
		if(toRemoveCategoryFilterList == null){
			return profile;
		}
		if(toRemoveCategoryFilterList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCategoryFilterDAO().removeCategoryFilterList(toRemoveCategoryFilterList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveNewProductList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<NewProduct> newProductList = profile.getNewProductList();
		if(newProductList == null){
			//null list means nothing
			return profile;
		}
		SmartList<NewProduct> mergedUpdateNewProductList = new SmartList<NewProduct>();
		
		
		mergedUpdateNewProductList.addAll(newProductList); 
		if(newProductList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateNewProductList.addAll(newProductList.getToRemoveList());
			newProductList.removeAll(newProductList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getNewProductDAO().saveNewProductList(mergedUpdateNewProductList,options);
		
		if(newProductList.getToRemoveList() != null){
			newProductList.removeAll(newProductList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeNewProductList(Profile profile, Map<String,Object> options){
	
	
		SmartList<NewProduct> newProductList = profile.getNewProductList();
		if(newProductList == null){
			return profile;
		}	
	
		SmartList<NewProduct> toRemoveNewProductList = newProductList.getToRemoveList();
		
		if(toRemoveNewProductList == null){
			return profile;
		}
		if(toRemoveNewProductList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNewProductDAO().removeNewProductList(toRemoveNewProductList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveEditorPickProductList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();
		if(editorPickProductList == null){
			//null list means nothing
			return profile;
		}
		SmartList<EditorPickProduct> mergedUpdateEditorPickProductList = new SmartList<EditorPickProduct>();
		
		
		mergedUpdateEditorPickProductList.addAll(editorPickProductList); 
		if(editorPickProductList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEditorPickProductList.addAll(editorPickProductList.getToRemoveList());
			editorPickProductList.removeAll(editorPickProductList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getEditorPickProductDAO().saveEditorPickProductList(mergedUpdateEditorPickProductList,options);
		
		if(editorPickProductList.getToRemoveList() != null){
			editorPickProductList.removeAll(editorPickProductList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeEditorPickProductList(Profile profile, Map<String,Object> options){
	
	
		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();
		if(editorPickProductList == null){
			return profile;
		}	
	
		SmartList<EditorPickProduct> toRemoveEditorPickProductList = editorPickProductList.getToRemoveList();
		
		if(toRemoveEditorPickProductList == null){
			return profile;
		}
		if(toRemoveEditorPickProductList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEditorPickProductDAO().removeEditorPickProductList(toRemoveEditorPickProductList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveTopRatedProductList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();
		if(topRatedProductList == null){
			//null list means nothing
			return profile;
		}
		SmartList<TopRatedProduct> mergedUpdateTopRatedProductList = new SmartList<TopRatedProduct>();
		
		
		mergedUpdateTopRatedProductList.addAll(topRatedProductList); 
		if(topRatedProductList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTopRatedProductList.addAll(topRatedProductList.getToRemoveList());
			topRatedProductList.removeAll(topRatedProductList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTopRatedProductDAO().saveTopRatedProductList(mergedUpdateTopRatedProductList,options);
		
		if(topRatedProductList.getToRemoveList() != null){
			topRatedProductList.removeAll(topRatedProductList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeTopRatedProductList(Profile profile, Map<String,Object> options){
	
	
		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();
		if(topRatedProductList == null){
			return profile;
		}	
	
		SmartList<TopRatedProduct> toRemoveTopRatedProductList = topRatedProductList.getToRemoveList();
		
		if(toRemoveTopRatedProductList == null){
			return profile;
		}
		if(toRemoveTopRatedProductList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTopRatedProductDAO().removeTopRatedProductList(toRemoveTopRatedProductList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		
	protected Profile saveRecommandProductList(Profile profile, Map<String,Object> options){
		
		
		
		
		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();
		if(recommandProductList == null){
			//null list means nothing
			return profile;
		}
		SmartList<RecommandProduct> mergedUpdateRecommandProductList = new SmartList<RecommandProduct>();
		
		
		mergedUpdateRecommandProductList.addAll(recommandProductList); 
		if(recommandProductList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRecommandProductList.addAll(recommandProductList.getToRemoveList());
			recommandProductList.removeAll(recommandProductList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRecommandProductDAO().saveRecommandProductList(mergedUpdateRecommandProductList,options);
		
		if(recommandProductList.getToRemoveList() != null){
			recommandProductList.removeAll(recommandProductList.getToRemoveList());
		}
		
		
		return profile;
	
	}
	
	protected Profile removeRecommandProductList(Profile profile, Map<String,Object> options){
	
	
		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();
		if(recommandProductList == null){
			return profile;
		}	
	
		SmartList<RecommandProduct> toRemoveRecommandProductList = recommandProductList.getToRemoveList();
		
		if(toRemoveRecommandProductList == null){
			return profile;
		}
		if(toRemoveRecommandProductList.isEmpty()){
			return profile;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRecommandProductDAO().removeRecommandProductList(toRemoveRecommandProductList,options);
		
		return profile;
	
	}
	
	

 	
 	
	
	
	
		

	public Profile present(Profile profile,Map<String, Object> options){
	
		presentUserAlertList(profile,options);
		presentTargetList(profile,options);
		presentRatingList(profile,options);
		presentReviewList(profile,options);
		presentBlogList(profile,options);
		presentBrandFilterList(profile,options);
		presentPriceFilterList(profile,options);
		presentCategoryFilterList(profile,options);
		presentNewProductList(profile,options);
		presentEditorPickProductList(profile,options);
		presentTopRatedProductList(profile,options);
		presentRecommandProductList(profile,options);

		return profile;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentUserAlertList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<UserAlert> userAlertList = profile.getUserAlertList();		
				SmartList<UserAlert> newList= presentSubList(profile.getId(),
				userAlertList,
				options,
				getUserAlertDAO()::countUserAlertByProfile,
				getUserAlertDAO()::findUserAlertByProfile
				);

		
		profile.setUserAlertList(newList);
		

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
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentBrandFilterList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<BrandFilter> brandFilterList = profile.getBrandFilterList();		
				SmartList<BrandFilter> newList= presentSubList(profile.getId(),
				brandFilterList,
				options,
				getBrandFilterDAO()::countBrandFilterByProfile,
				getBrandFilterDAO()::findBrandFilterByProfile
				);

		
		profile.setBrandFilterList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentPriceFilterList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<PriceFilter> priceFilterList = profile.getPriceFilterList();		
				SmartList<PriceFilter> newList= presentSubList(profile.getId(),
				priceFilterList,
				options,
				getPriceFilterDAO()::countPriceFilterByProfile,
				getPriceFilterDAO()::findPriceFilterByProfile
				);

		
		profile.setPriceFilterList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentCategoryFilterList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<CategoryFilter> categoryFilterList = profile.getCategoryFilterList();		
				SmartList<CategoryFilter> newList= presentSubList(profile.getId(),
				categoryFilterList,
				options,
				getCategoryFilterDAO()::countCategoryFilterByProfile,
				getCategoryFilterDAO()::findCategoryFilterByProfile
				);

		
		profile.setCategoryFilterList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentNewProductList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<NewProduct> newProductList = profile.getNewProductList();		
				SmartList<NewProduct> newList= presentSubList(profile.getId(),
				newProductList,
				options,
				getNewProductDAO()::countNewProductByProfile,
				getNewProductDAO()::findNewProductByProfile
				);

		
		profile.setNewProductList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentEditorPickProductList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<EditorPickProduct> editorPickProductList = profile.getEditorPickProductList();		
				SmartList<EditorPickProduct> newList= presentSubList(profile.getId(),
				editorPickProductList,
				options,
				getEditorPickProductDAO()::countEditorPickProductByProfile,
				getEditorPickProductDAO()::findEditorPickProductByProfile
				);

		
		profile.setEditorPickProductList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentTopRatedProductList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<TopRatedProduct> topRatedProductList = profile.getTopRatedProductList();		
				SmartList<TopRatedProduct> newList= presentSubList(profile.getId(),
				topRatedProductList,
				options,
				getTopRatedProductDAO()::countTopRatedProductByProfile,
				getTopRatedProductDAO()::findTopRatedProductByProfile
				);

		
		profile.setTopRatedProductList(newList);
		

		return profile;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Profile presentRecommandProductList(
			Profile profile,
			Map<String, Object> options) {

		SmartList<RecommandProduct> recommandProductList = profile.getRecommandProductList();		
				SmartList<RecommandProduct> newList= presentSubList(profile.getId(),
				recommandProductList,
				options,
				getRecommandProductDAO()::countRecommandProductByProfile,
				getRecommandProductDAO()::findRecommandProductByProfile
				);

		
		profile.setRecommandProductList(newList);
		

		return profile;
	}			
		

	
    public SmartList<Profile> requestCandidateProfileForUserAlert(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
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
		
    public SmartList<Profile> requestCandidateProfileForBrandFilter(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForPriceFilter(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForCategoryFilter(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfileTable.COLUMN_NAME, filterKey, pageNo, pageSize, getProfileMapper());
    }
		
    public SmartList<Profile> requestCandidateProfileForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
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


