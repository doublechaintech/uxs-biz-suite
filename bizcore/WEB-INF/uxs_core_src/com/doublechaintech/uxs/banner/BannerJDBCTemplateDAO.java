
package com.doublechaintech.uxs.banner;

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


import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.platform.Platform;

import com.doublechaintech.uxs.target.TargetDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class BannerJDBCTemplateDAO extends UxsNamingServiceDAO implements BannerDAO{
 
 	
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
 	
			
		

	
	/*
	protected Banner load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalBanner(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Banner load(String id,Map<String,Object> options) throws Exception{
		return loadInternalBanner(BannerTable.withId(id), options);
	}
	
	
	
	public Banner save(Banner banner,Map<String,Object> options){
		
		String methodName="save(Banner banner,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(banner, methodName, "banner");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalBanner(banner,options);
	}
	public Banner clone(String bannerId, Map<String,Object> options) throws Exception{
	
		return clone(BannerTable.withId(bannerId),options);
	}
	
	protected Banner clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String bannerId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Banner newBanner = loadInternalBanner(accessKey, options);
		newBanner.setVersion(0);
		
		
 		
 		if(isSaveTargetListEnabled(options)){
 			for(Target item: newBanner.getTargetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalBanner(newBanner,options);
		
		return newBanner;
	}
	
	
	
	

	protected void throwIfHasException(String bannerId,int version,int count) throws Exception{
		if (count == 1) {
			throw new BannerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new BannerNotFoundException(
					"The " + this.getTableName() + "(" + bannerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String bannerId, int version) throws Exception{
	
		String methodName="delete(String bannerId, int version)";
		assertMethodArgumentNotNull(bannerId, methodName, "bannerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{bannerId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(bannerId,version);
		}
		
	
	}
	
	
	
	
	

	public Banner disconnectFromAll(String bannerId, int version) throws Exception{
	
		
		Banner banner = loadInternalBanner(BannerTable.withId(bannerId), emptyOptions());
		banner.clearFromAll();
		this.saveBanner(banner);
		return banner;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return BannerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "banner";
	}
	@Override
	protected String getBeanName() {
		
		return "banner";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return BannerTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, BannerTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, BannerTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractTargetListEnabled(Map<String,Object> options){		
 		return checkOptions(options,BannerTokens.TARGET_LIST);
 	}
 	protected boolean isAnalyzeTargetListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,BannerTokens.TARGET_LIST+".analyze");
 	}
	
	protected boolean isSaveTargetListEnabled(Map<String,Object> options){
		return checkOptions(options, BannerTokens.TARGET_LIST);
		
 	}
 	
		

	

	protected BannerMapper getBannerMapper(){
		return new BannerMapper();
	}

	
	
	protected Banner extractBanner(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Banner banner = loadSingleObject(accessKey, getBannerMapper());
			return banner;
		}catch(EmptyResultDataAccessException e){
			throw new BannerNotFoundException("Banner("+accessKey+") is not found!");
		}

	}

	
	

	protected Banner loadInternalBanner(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Banner banner = extractBanner(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(banner, loadOptions);
 		}
 
		
		if(isExtractTargetListEnabled(loadOptions)){
	 		extractTargetList(banner, loadOptions);
 		}	
 		if(isAnalyzeTargetListEnabled(loadOptions)){
	 		analyzeTargetList(banner, loadOptions);
 		}
 		
		
		return banner;
		
	}

	 

 	protected Banner extractPlatform(Banner banner, Map<String,Object> options) throws Exception{

		if(banner.getPlatform() == null){
			return banner;
		}
		String platformId = banner.getPlatform().getId();
		if( platformId == null){
			return banner;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			banner.setPlatform(platform);
		}
		
 		
 		return banner;
 	}
 		
 
		
	protected void enhanceTargetList(SmartList<Target> targetList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Banner extractTargetList(Banner banner, Map<String,Object> options){
		
		
		if(banner == null){
			return null;
		}
		if(banner.getId() == null){
			return banner;
		}

		
		
		SmartList<Target> targetList = getTargetDAO().findTargetByBanner(banner.getId(),options);
		if(targetList != null){
			enhanceTargetList(targetList,options);
			banner.setTargetList(targetList);
		}
		
		return banner;
	
	}	
	
	protected Banner analyzeTargetList(Banner banner, Map<String,Object> options){
		
		
		if(banner == null){
			return null;
		}
		if(banner.getId() == null){
			return banner;
		}

		
		
		SmartList<Target> targetList = banner.getTargetList();
		if(targetList != null){
			getTargetDAO().analyzeTargetByBanner(targetList, banner.getId(), options);
			
		}
		
		return banner;
	
	}	
	
		
		
  	
 	public SmartList<Banner> findBannerByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Banner> resultList = queryWith(BannerTable.COLUMN_PLATFORM, platformId, options, getBannerMapper());
		// analyzeBannerByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Banner> findBannerByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Banner> resultList =  queryWithRange(BannerTable.COLUMN_PLATFORM, platformId, options, getBannerMapper(), start, count);
 		//analyzeBannerByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeBannerByPlatform(SmartList<Banner> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Banner.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateStatsItem = new StatsItem();
		//Banner.LAST_UPDATE_PROPERTY
		lastUpdateStatsItem.setDisplayName("Banner");
		lastUpdateStatsItem.setInternalName(formatKeyForDateLine(Banner.LAST_UPDATE_PROPERTY));
		lastUpdateStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Banner.LAST_UPDATE_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countBannerByPlatform(String platformId,Map<String,Object> options){

 		return countWith(BannerTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countBannerByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(BannerTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Banner saveBanner(Banner  banner){
		
		if(!banner.isChanged()){
			return banner;
		}
		
		
		String SQL=this.getSaveBannerSQL(banner);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveBannerParameters(banner);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		banner.incVersion();
		return banner;
	
	}
	public SmartList<Banner> saveBannerList(SmartList<Banner> bannerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitBannerList(bannerList);
		
		batchBannerCreate((List<Banner>)lists[CREATE_LIST_INDEX]);
		
		batchBannerUpdate((List<Banner>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Banner banner:bannerList){
			if(banner.isChanged()){
				banner.incVersion();
			}
			
		
		}
		
		
		return bannerList;
	}

	public SmartList<Banner> removeBannerList(SmartList<Banner> bannerList,Map<String,Object> options){
		
		
		super.removeList(bannerList, options);
		
		return bannerList;
		
		
	}
	
	protected List<Object[]> prepareBannerBatchCreateArgs(List<Banner> bannerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Banner banner:bannerList ){
			Object [] parameters = prepareBannerCreateParameters(banner);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBannerBatchUpdateArgs(List<Banner> bannerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Banner banner:bannerList ){
			if(!banner.isChanged()){
				continue;
			}
			Object [] parameters = prepareBannerUpdateParameters(banner);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchBannerCreate(List<Banner> bannerList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBannerBatchCreateArgs(bannerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchBannerUpdate(List<Banner> bannerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBannerBatchUpdateArgs(bannerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitBannerList(List<Banner> bannerList){
		
		List<Banner> bannerCreateList=new ArrayList<Banner>();
		List<Banner> bannerUpdateList=new ArrayList<Banner>();
		
		for(Banner banner: bannerList){
			if(isUpdateRequest(banner)){
				bannerUpdateList.add( banner);
				continue;
			}
			bannerCreateList.add(banner);
		}
		
		return new Object[]{bannerCreateList,bannerUpdateList};
	}
	
	protected boolean isUpdateRequest(Banner banner){
 		return banner.getVersion() > 0;
 	}
 	protected String getSaveBannerSQL(Banner banner){
 		if(isUpdateRequest(banner)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveBannerParameters(Banner banner){
 		if(isUpdateRequest(banner) ){
 			return prepareBannerUpdateParameters(banner);
 		}
 		return prepareBannerCreateParameters(banner);
 	}
 	protected Object[] prepareBannerUpdateParameters(Banner banner){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = banner.getName();
 		parameters[1] = banner.getImagePath();
 		parameters[2] = banner.getLastUpdate(); 	
 		if(banner.getPlatform() != null){
 			parameters[3] = banner.getPlatform().getId();
 		}
 		
 		parameters[4] = banner.nextVersion();
 		parameters[5] = banner.getId();
 		parameters[6] = banner.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareBannerCreateParameters(Banner banner){
		Object[] parameters = new Object[5];
		String newBannerId=getNextId();
		banner.setId(newBannerId);
		parameters[0] =  banner.getId();
 
 		parameters[1] = banner.getName();
 		parameters[2] = banner.getImagePath();
 		parameters[3] = banner.getLastUpdate(); 	
 		if(banner.getPlatform() != null){
 			parameters[4] = banner.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Banner saveInternalBanner(Banner banner, Map<String,Object> options){
		
		saveBanner(banner);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(banner, options);
 		}
 
		
		if(isSaveTargetListEnabled(options)){
	 		saveTargetList(banner, options);
	 		//removeTargetList(banner, options);
	 		//Not delete the record
	 		
 		}		
		
		return banner;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Banner savePlatform(Banner banner, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(banner.getPlatform() == null){
 			return banner;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(banner.getPlatform(),options);
 		return banner;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Banner planToRemoveTargetList(Banner banner, String targetIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.BANNER_PROPERTY, banner.getId());
		key.put(Target.ID_PROPERTY, targetIds);
		
		SmartList<Target> externalTargetList = getTargetDAO().
				findTargetWithKey(key, options);
		if(externalTargetList == null){
			return banner;
		}
		if(externalTargetList.isEmpty()){
			return banner;
		}
		
		for(Target target: externalTargetList){

			target.clearFromAll();
		}
		
		
		SmartList<Target> targetList = banner.getTargetList();		
		targetList.addAllToRemoveList(externalTargetList);
		return banner;	
	
	}


	//disconnect Banner with profile in Target
	public Banner planToRemoveTargetListWithProfile(Banner banner, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.BANNER_PROPERTY, banner.getId());
		key.put(Target.PROFILE_PROPERTY, profileId);
		
		SmartList<Target> externalTargetList = getTargetDAO().
				findTargetWithKey(key, options);
		if(externalTargetList == null){
			return banner;
		}
		if(externalTargetList.isEmpty()){
			return banner;
		}
		
		for(Target target: externalTargetList){
			target.clearProfile();
			target.clearBanner();
			
		}
		
		
		SmartList<Target> targetList = banner.getTargetList();		
		targetList.addAllToRemoveList(externalTargetList);
		return banner;
	}
	
	public int countTargetListWithProfile(String bannerId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.BANNER_PROPERTY, bannerId);
		key.put(Target.PROFILE_PROPERTY, profileId);
		
		int count = getTargetDAO().countTargetWithKey(key, options);
		return count;
	}
	

		
	protected Banner saveTargetList(Banner banner, Map<String,Object> options){
		
		
		
		
		SmartList<Target> targetList = banner.getTargetList();
		if(targetList == null){
			//null list means nothing
			return banner;
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
		
		
		return banner;
	
	}
	
	protected Banner removeTargetList(Banner banner, Map<String,Object> options){
	
	
		SmartList<Target> targetList = banner.getTargetList();
		if(targetList == null){
			return banner;
		}	
	
		SmartList<Target> toRemoveTargetList = targetList.getToRemoveList();
		
		if(toRemoveTargetList == null){
			return banner;
		}
		if(toRemoveTargetList.isEmpty()){
			return banner;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTargetDAO().removeTargetList(toRemoveTargetList,options);
		
		return banner;
	
	}
	
	

 	
 	
	
	
	
		

	public Banner present(Banner banner,Map<String, Object> options){
	
		presentTargetList(banner,options);

		return banner;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Banner presentTargetList(
			Banner banner,
			Map<String, Object> options) {

		SmartList<Target> targetList = banner.getTargetList();		
				SmartList<Target> newList= presentSubList(banner.getId(),
				targetList,
				options,
				getTargetDAO()::countTargetByBanner,
				getTargetDAO()::findTargetByBanner
				);

		
		banner.setTargetList(newList);
		

		return banner;
	}			
		

	
    public SmartList<Banner> requestCandidateBannerForTarget(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(BannerTable.COLUMN_NAME, filterKey, pageNo, pageSize, getBannerMapper());
    }
		

	protected String getTableName(){
		return BannerTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Banner> bannerList) {		
		this.enhanceListInternal(bannerList, this.getBannerMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Banner> bannerList = ownerEntity.collectRefsWithType(Banner.INTERNAL_TYPE);
		this.enhanceList(bannerList);
		
	}
	
	@Override
	public SmartList<Banner> findBannerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getBannerMapper());

	}
	@Override
	public int countBannerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countBannerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Banner> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getBannerMapper());
	}
}


