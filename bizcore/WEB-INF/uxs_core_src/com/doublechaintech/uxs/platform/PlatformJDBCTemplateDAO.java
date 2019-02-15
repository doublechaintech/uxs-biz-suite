
package com.doublechaintech.uxs.platform;

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
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.profile.Profile;

import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.banner.BannerDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class PlatformJDBCTemplateDAO extends UxsNamingServiceDAO implements PlatformDAO{


			
		
	
  	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO pProductDAO){
 	
 		if(pProductDAO == null){
 			throw new IllegalStateException("Do not try to set productDAO to null.");
 		}
	 	this.productDAO = pProductDAO;
 	}
 	public ProductDAO getProductDAO(){
 		if(this.productDAO == null){
 			throw new IllegalStateException("The productDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productDAO;
 	}	
 	
			
		
	
  	private  BannerDAO  bannerDAO;
 	public void setBannerDAO(BannerDAO pBannerDAO){
 	
 		if(pBannerDAO == null){
 			throw new IllegalStateException("Do not try to set bannerDAO to null.");
 		}
	 	this.bannerDAO = pBannerDAO;
 	}
 	public BannerDAO getBannerDAO(){
 		if(this.bannerDAO == null){
 			throw new IllegalStateException("The bannerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.bannerDAO;
 	}	
 	
			
		
	
  	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO pProfileDAO){
 	
 		if(pProfileDAO == null){
 			throw new IllegalStateException("Do not try to set profileDAO to null.");
 		}
	 	this.profileDAO = pProfileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
 		if(this.profileDAO == null){
 			throw new IllegalStateException("The profileDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.profileDAO;
 	}	
 	
			
		

	
	/*
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newPlatform.getProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveBannerListEnabled(options)){
 			for(Banner item: newPlatform.getBannerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProfileListEnabled(options)){
 			for(Profile item: newPlatform.getProfileList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractBannerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.BANNER_LIST);
 	}
 	protected boolean isAnalyzeBannerListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.BANNER_LIST+".analyze");
 	}
	
	protected boolean isSaveBannerListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.BANNER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProfileListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PROFILE_LIST);
 	}
 	protected boolean isAnalyzeProfileListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.PROFILE_LIST+".analyze");
 	}
	
	protected boolean isSaveProfileListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PROFILE_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(platform, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		analyzeProductList(platform, loadOptions);
 		}
 		
		
		if(isExtractBannerListEnabled(loadOptions)){
	 		extractBannerList(platform, loadOptions);
 		}	
 		if(isAnalyzeBannerListEnabled(loadOptions)){
	 		analyzeBannerList(platform, loadOptions);
 		}
 		
		
		if(isExtractProfileListEnabled(loadOptions)){
	 		extractProfileList(platform, loadOptions);
 		}	
 		if(isAnalyzeProfileListEnabled(loadOptions)){
	 		analyzeProfileList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByPlatform(platform.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			platform.setProductList(productList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Product> productList = platform.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByPlatform(productList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceBannerList(SmartList<Banner> bannerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractBannerList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Banner> bannerList = getBannerDAO().findBannerByPlatform(platform.getId(),options);
		if(bannerList != null){
			enhanceBannerList(bannerList,options);
			platform.setBannerList(bannerList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeBannerList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList != null){
			getBannerDAO().analyzeBannerByPlatform(bannerList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = getProfileDAO().findProfileByPlatform(platform.getId(),options);
		if(profileList != null){
			enhanceProfileList(profileList,options);
			platform.setProfileList(profileList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList != null){
			getProfileDAO().analyzeProfileByPlatform(profileList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = platform.getName();		
 		parameters[1] = platform.nextVersion();
 		parameters[2] = platform.getId();
 		parameters[3] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[2];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(platform, options);
	 		//removeProductList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveBannerListEnabled(options)){
	 		saveBannerList(platform, options);
	 		//removeBannerList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProfileListEnabled(options)){
	 		saveProfileList(platform, options);
	 		//removeProfileList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveProductList(Platform platform, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;	
	
	}


	public Platform planToRemoveBannerList(Platform platform, String bannerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Banner.PLATFORM_PROPERTY, platform.getId());
		key.put(Banner.ID_PROPERTY, bannerIds);
		
		SmartList<Banner> externalBannerList = getBannerDAO().
				findBannerWithKey(key, options);
		if(externalBannerList == null){
			return platform;
		}
		if(externalBannerList.isEmpty()){
			return platform;
		}
		
		for(Banner banner: externalBannerList){

			banner.clearFromAll();
		}
		
		
		SmartList<Banner> bannerList = platform.getBannerList();		
		bannerList.addAllToRemoveList(externalBannerList);
		return platform;	
	
	}


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Profile.PLATFORM_PROPERTY, platform.getId());
		key.put(Profile.ID_PROPERTY, profileIds);
		
		SmartList<Profile> externalProfileList = getProfileDAO().
				findProfileWithKey(key, options);
		if(externalProfileList == null){
			return platform;
		}
		if(externalProfileList.isEmpty()){
			return platform;
		}
		
		for(Profile profile: externalProfileList){

			profile.clearFromAll();
		}
		
		
		SmartList<Profile> profileList = platform.getProfileList();		
		profileList.addAllToRemoveList(externalProfileList);
		return platform;	
	
	}



		
	protected Platform saveProductList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = platform.getProductList();
		if(productList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Product> mergedUpdateProductList = new SmartList<Product>();
		
		
		mergedUpdateProductList.addAll(productList); 
		if(productList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProductList.addAll(productList.getToRemoveList());
			productList.removeAll(productList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProductDAO().saveProductList(mergedUpdateProductList,options);
		
		if(productList.getToRemoveList() != null){
			productList.removeAll(productList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeProductList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Product> productList = platform.getProductList();
		if(productList == null){
			return platform;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return platform;
		}
		if(toRemoveProductList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveBannerList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Banner> mergedUpdateBannerList = new SmartList<Banner>();
		
		
		mergedUpdateBannerList.addAll(bannerList); 
		if(bannerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateBannerList.addAll(bannerList.getToRemoveList());
			bannerList.removeAll(bannerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getBannerDAO().saveBannerList(mergedUpdateBannerList,options);
		
		if(bannerList.getToRemoveList() != null){
			bannerList.removeAll(bannerList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeBannerList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList == null){
			return platform;
		}	
	
		SmartList<Banner> toRemoveBannerList = bannerList.getToRemoveList();
		
		if(toRemoveBannerList == null){
			return platform;
		}
		if(toRemoveBannerList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getBannerDAO().removeBannerList(toRemoveBannerList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveProfileList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Profile> mergedUpdateProfileList = new SmartList<Profile>();
		
		
		mergedUpdateProfileList.addAll(profileList); 
		if(profileList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProfileList.addAll(profileList.getToRemoveList());
			profileList.removeAll(profileList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProfileDAO().saveProfileList(mergedUpdateProfileList,options);
		
		if(profileList.getToRemoveList() != null){
			profileList.removeAll(profileList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeProfileList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			return platform;
		}	
	
		SmartList<Profile> toRemoveProfileList = profileList.getToRemoveList();
		
		if(toRemoveProfileList == null){
			return platform;
		}
		if(toRemoveProfileList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProfileDAO().removeProfileList(toRemoveProfileList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentProductList(platform,options);
		presentBannerList(platform,options);
		presentProfileList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProductList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Product> productList = platform.getProductList();		
				SmartList<Product> newList= presentSubList(platform.getId(),
				productList,
				options,
				getProductDAO()::countProductByPlatform,
				getProductDAO()::findProductByPlatform
				);

		
		platform.setProductList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentBannerList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Banner> bannerList = platform.getBannerList();		
				SmartList<Banner> newList= presentSubList(platform.getId(),
				bannerList,
				options,
				getBannerDAO()::countBannerByPlatform,
				getBannerDAO()::findBannerByPlatform
				);

		
		platform.setBannerList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProfileList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Profile> profileList = platform.getProfileList();		
				SmartList<Profile> newList= presentSubList(platform.getId(),
				profileList,
				options,
				getProfileDAO()::countProfileByPlatform,
				getProfileDAO()::findProfileByPlatform
				);

		
		platform.setProfileList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForBanner(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForProfile(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
}


