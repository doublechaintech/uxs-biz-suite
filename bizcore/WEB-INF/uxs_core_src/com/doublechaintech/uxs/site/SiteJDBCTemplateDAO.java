
package com.doublechaintech.uxs.site;

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


import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.platform.Platform;

import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.catalog.CatalogDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class SiteJDBCTemplateDAO extends UxsNamingServiceDAO implements SiteDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  CatalogDAO  catalogDAO;
 	public void setCatalogDAO(CatalogDAO pCatalogDAO){
 	
 		if(pCatalogDAO == null){
 			throw new IllegalStateException("Do not try to set catalogDAO to null.");
 		}
	 	this.catalogDAO = pCatalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
 		if(this.catalogDAO == null){
 			throw new IllegalStateException("The catalogDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.catalogDAO;
 	}	
 	
			
		

	
	/*
	protected Site load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSite(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Site load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSite(SiteTable.withId(id), options);
	}
	
	
	
	public Site save(Site site,Map<String,Object> options){
		
		String methodName="save(Site site,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(site, methodName, "site");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSite(site,options);
	}
	public Site clone(String siteId, Map<String,Object> options) throws Exception{
	
		return clone(SiteTable.withId(siteId),options);
	}
	
	protected Site clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String siteId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Site newSite = loadInternalSite(accessKey, options);
		newSite.setVersion(0);
		
		
 		
 		if(isSaveCatalogListEnabled(options)){
 			for(Catalog item: newSite.getCatalogList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSite(newSite,options);
		
		return newSite;
	}
	
	
	
	

	protected void throwIfHasException(String siteId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SiteVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SiteNotFoundException(
					"The " + this.getTableName() + "(" + siteId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String siteId, int version) throws Exception{
	
		String methodName="delete(String siteId, int version)";
		assertMethodArgumentNotNull(siteId, methodName, "siteId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{siteId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(siteId,version);
		}
		
	
	}
	
	
	
	
	

	public Site disconnectFromAll(String siteId, int version) throws Exception{
	
		
		Site site = loadInternalSite(SiteTable.withId(siteId), emptyOptions());
		site.clearFromAll();
		this.saveSite(site);
		return site;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SiteTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "site";
	}
	@Override
	protected String getBeanName() {
		
		return "site";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SiteTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SiteTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SiteTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractCatalogListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SiteTokens.CATALOG_LIST);
 	}
 	protected boolean isAnalyzeCatalogListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,SiteTokens.CATALOG_LIST+".analyze");
 	}
	
	protected boolean isSaveCatalogListEnabled(Map<String,Object> options){
		return checkOptions(options, SiteTokens.CATALOG_LIST);
		
 	}
 	
		

	

	protected SiteMapper getSiteMapper(){
		return new SiteMapper();
	}

	
	
	protected Site extractSite(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Site site = loadSingleObject(accessKey, getSiteMapper());
			return site;
		}catch(EmptyResultDataAccessException e){
			throw new SiteNotFoundException("Site("+accessKey+") is not found!");
		}

	}

	
	

	protected Site loadInternalSite(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Site site = extractSite(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(site, loadOptions);
 		}
 
		
		if(isExtractCatalogListEnabled(loadOptions)){
	 		extractCatalogList(site, loadOptions);
 		}	
 		if(isAnalyzeCatalogListEnabled(loadOptions)){
	 		analyzeCatalogList(site, loadOptions);
 		}
 		
		
		return site;
		
	}

	 

 	protected Site extractPlatform(Site site, Map<String,Object> options) throws Exception{

		if(site.getPlatform() == null){
			return site;
		}
		String platformId = site.getPlatform().getId();
		if( platformId == null){
			return site;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			site.setPlatform(platform);
		}
		
 		
 		return site;
 	}
 		
 
		
	protected void enhanceCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Site extractCatalogList(Site site, Map<String,Object> options){
		
		
		if(site == null){
			return null;
		}
		if(site.getId() == null){
			return site;
		}

		
		
		SmartList<Catalog> catalogList = getCatalogDAO().findCatalogBySite(site.getId(),options);
		if(catalogList != null){
			enhanceCatalogList(catalogList,options);
			site.setCatalogList(catalogList);
		}
		
		return site;
	
	}	
	
	protected Site analyzeCatalogList(Site site, Map<String,Object> options){
		
		
		if(site == null){
			return null;
		}
		if(site.getId() == null){
			return site;
		}

		
		
		SmartList<Catalog> catalogList = site.getCatalogList();
		if(catalogList != null){
			getCatalogDAO().analyzeCatalogBySite(catalogList, site.getId(), options);
			
		}
		
		return site;
	
	}	
	
		
		
  	
 	public SmartList<Site> findSiteByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Site> resultList = queryWith(SiteTable.COLUMN_PLATFORM, platformId, options, getSiteMapper());
		// analyzeSiteByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Site> findSiteByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Site> resultList =  queryWithRange(SiteTable.COLUMN_PLATFORM, platformId, options, getSiteMapper(), start, count);
 		//analyzeSiteByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeSiteByPlatform(SmartList<Site> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Site.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//Site.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Site");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(Site.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Site.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countSiteByPlatform(String platformId,Map<String,Object> options){

 		return countWith(SiteTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countSiteByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SiteTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Site saveSite(Site  site){
		
		if(!site.isChanged()){
			return site;
		}
		
		
		String SQL=this.getSaveSiteSQL(site);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSiteParameters(site);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		site.incVersion();
		return site;
	
	}
	public SmartList<Site> saveSiteList(SmartList<Site> siteList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSiteList(siteList);
		
		batchSiteCreate((List<Site>)lists[CREATE_LIST_INDEX]);
		
		batchSiteUpdate((List<Site>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Site site:siteList){
			if(site.isChanged()){
				site.incVersion();
			}
			
		
		}
		
		
		return siteList;
	}

	public SmartList<Site> removeSiteList(SmartList<Site> siteList,Map<String,Object> options){
		
		
		super.removeList(siteList, options);
		
		return siteList;
		
		
	}
	
	protected List<Object[]> prepareSiteBatchCreateArgs(List<Site> siteList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Site site:siteList ){
			Object [] parameters = prepareSiteCreateParameters(site);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSiteBatchUpdateArgs(List<Site> siteList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Site site:siteList ){
			if(!site.isChanged()){
				continue;
			}
			Object [] parameters = prepareSiteUpdateParameters(site);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSiteCreate(List<Site> siteList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSiteBatchCreateArgs(siteList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSiteUpdate(List<Site> siteList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSiteBatchUpdateArgs(siteList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSiteList(List<Site> siteList){
		
		List<Site> siteCreateList=new ArrayList<Site>();
		List<Site> siteUpdateList=new ArrayList<Site>();
		
		for(Site site: siteList){
			if(isUpdateRequest(site)){
				siteUpdateList.add( site);
				continue;
			}
			siteCreateList.add(site);
		}
		
		return new Object[]{siteCreateList,siteUpdateList};
	}
	
	protected boolean isUpdateRequest(Site site){
 		return site.getVersion() > 0;
 	}
 	protected String getSaveSiteSQL(Site site){
 		if(isUpdateRequest(site)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSiteParameters(Site site){
 		if(isUpdateRequest(site) ){
 			return prepareSiteUpdateParameters(site);
 		}
 		return prepareSiteCreateParameters(site);
 	}
 	protected Object[] prepareSiteUpdateParameters(Site site){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = site.getName();
 		parameters[1] = site.getIntroduction(); 	
 		if(site.getPlatform() != null){
 			parameters[2] = site.getPlatform().getId();
 		}
 
 		parameters[3] = site.getLastUpdateTime();		
 		parameters[4] = site.nextVersion();
 		parameters[5] = site.getId();
 		parameters[6] = site.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSiteCreateParameters(Site site){
		Object[] parameters = new Object[5];
		String newSiteId=getNextId();
		site.setId(newSiteId);
		parameters[0] =  site.getId();
 
 		parameters[1] = site.getName();
 		parameters[2] = site.getIntroduction(); 	
 		if(site.getPlatform() != null){
 			parameters[3] = site.getPlatform().getId();
 		
 		}
 		
 		parameters[4] = site.getLastUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected Site saveInternalSite(Site site, Map<String,Object> options){
		
		saveSite(site);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(site, options);
 		}
 
		
		if(isSaveCatalogListEnabled(options)){
	 		saveCatalogList(site, options);
	 		//removeCatalogList(site, options);
	 		//Not delete the record
	 		
 		}		
		
		return site;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Site savePlatform(Site site, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(site.getPlatform() == null){
 			return site;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(site.getPlatform(),options);
 		return site;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Site planToRemoveCatalogList(Site site, String catalogIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.SITE_PROPERTY, site.getId());
		key.put(Catalog.ID_PROPERTY, catalogIds);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return site;
		}
		if(externalCatalogList.isEmpty()){
			return site;
		}
		
		for(Catalog catalog: externalCatalogList){

			catalog.clearFromAll();
		}
		
		
		SmartList<Catalog> catalogList = site.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return site;	
	
	}


	//disconnect Site with seller_id in Catalog
	public Site planToRemoveCatalogListWithSellerId(Site site, String sellerIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.SITE_PROPERTY, site.getId());
		key.put(Catalog.SELLER_ID_PROPERTY, sellerIdId);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return site;
		}
		if(externalCatalogList.isEmpty()){
			return site;
		}
		
		for(Catalog catalog: externalCatalogList){
			catalog.clearSellerId();
			catalog.clearSite();
			
		}
		
		
		SmartList<Catalog> catalogList = site.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return site;
	}
	
	public int countCatalogListWithSellerId(String siteId, String sellerIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.SITE_PROPERTY, siteId);
		key.put(Catalog.SELLER_ID_PROPERTY, sellerIdId);
		
		int count = getCatalogDAO().countCatalogWithKey(key, options);
		return count;
	}
	
	//disconnect Site with platform in Catalog
	public Site planToRemoveCatalogListWithPlatform(Site site, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.SITE_PROPERTY, site.getId());
		key.put(Catalog.PLATFORM_PROPERTY, platformId);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return site;
		}
		if(externalCatalogList.isEmpty()){
			return site;
		}
		
		for(Catalog catalog: externalCatalogList){
			catalog.clearPlatform();
			catalog.clearSite();
			
		}
		
		
		SmartList<Catalog> catalogList = site.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return site;
	}
	
	public int countCatalogListWithPlatform(String siteId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.SITE_PROPERTY, siteId);
		key.put(Catalog.PLATFORM_PROPERTY, platformId);
		
		int count = getCatalogDAO().countCatalogWithKey(key, options);
		return count;
	}
	

		
	protected Site saveCatalogList(Site site, Map<String,Object> options){
		
		
		
		
		SmartList<Catalog> catalogList = site.getCatalogList();
		if(catalogList == null){
			//null list means nothing
			return site;
		}
		SmartList<Catalog> mergedUpdateCatalogList = new SmartList<Catalog>();
		
		
		mergedUpdateCatalogList.addAll(catalogList); 
		if(catalogList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCatalogList.addAll(catalogList.getToRemoveList());
			catalogList.removeAll(catalogList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCatalogDAO().saveCatalogList(mergedUpdateCatalogList,options);
		
		if(catalogList.getToRemoveList() != null){
			catalogList.removeAll(catalogList.getToRemoveList());
		}
		
		
		return site;
	
	}
	
	protected Site removeCatalogList(Site site, Map<String,Object> options){
	
	
		SmartList<Catalog> catalogList = site.getCatalogList();
		if(catalogList == null){
			return site;
		}	
	
		SmartList<Catalog> toRemoveCatalogList = catalogList.getToRemoveList();
		
		if(toRemoveCatalogList == null){
			return site;
		}
		if(toRemoveCatalogList.isEmpty()){
			return site;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCatalogDAO().removeCatalogList(toRemoveCatalogList,options);
		
		return site;
	
	}
	
	

 	
 	
	
	
	
		

	public Site present(Site site,Map<String, Object> options){
	
		presentCatalogList(site,options);

		return site;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Site presentCatalogList(
			Site site,
			Map<String, Object> options) {

		SmartList<Catalog> catalogList = site.getCatalogList();		
				SmartList<Catalog> newList= presentSubList(site.getId(),
				catalogList,
				options,
				getCatalogDAO()::countCatalogBySite,
				getCatalogDAO()::findCatalogBySite
				);

		
		site.setCatalogList(newList);
		

		return site;
	}			
		

	
    public SmartList<Site> requestCandidateSiteForCatalog(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SiteTable.COLUMN_NAME, filterKey, pageNo, pageSize, getSiteMapper());
    }
		

	protected String getTableName(){
		return SiteTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Site> siteList) {		
		this.enhanceListInternal(siteList, this.getSiteMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Site> siteList = ownerEntity.collectRefsWithType(Site.INTERNAL_TYPE);
		this.enhanceList(siteList);
		
	}
	
	@Override
	public SmartList<Site> findSiteWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSiteMapper());

	}
	@Override
	public int countSiteWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSiteWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Site> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSiteMapper());
	}
}


