
package com.doublechaintech.uxs.site;

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

import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.platform.Platform;

import com.doublechaintech.uxs.platform.CandidatePlatform;

import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.platform.Platform;






public class SiteManagerImpl extends CustomUxsCheckerManager implements SiteManager {
	
	private static final String SERVICE_TYPE = "Site";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SiteManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SiteManagerException(message);

	}
	
	

 	protected Site saveSite(UxsUserContext userContext, Site site, String [] tokensExpr) throws Exception{	
 		//return getSiteDAO().save(site, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSite(userContext, site, tokens);
 	}
 	
 	protected Site saveSiteDetail(UxsUserContext userContext, Site site) throws Exception{	

 		
 		return saveSite(userContext, site, allTokens());
 	}
 	
 	public Site loadSite(UxsUserContext userContext, String siteId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().throwExceptionIfHasErrors( SiteManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Site site = loadSite( userContext, siteId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,site, tokens);
 	}
 	
 	
 	 public Site searchSite(UxsUserContext userContext, String siteId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().throwExceptionIfHasErrors( SiteManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Site site = loadSite( userContext, siteId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,site, tokens);
 	}
 	
 	

 	protected Site present(UxsUserContext userContext, Site site, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,site,tokens);
		
		
		Site  siteToPresent = userContext.getDAOGroup().getSiteDAO().present(site, tokens);
		
		List<BaseEntity> entityListToNaming = siteToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSiteDAO().alias(entityListToNaming);
		
		return  siteToPresent;
		
		
	}
 
 	
 	
 	public Site loadSiteDetail(UxsUserContext userContext, String siteId) throws Exception{	
 		Site site = loadSite( userContext, siteId, allTokens());
 		return present(userContext,site, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String siteId) throws Exception{	
 		Site site = loadSite( userContext, siteId, viewTokens());
 		return present(userContext,site, allTokens());
		
 	}
 	protected Site saveSite(UxsUserContext userContext, Site site, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSiteDAO().save(site, tokens);
 	}
 	protected Site loadSite(UxsUserContext userContext, String siteId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().throwExceptionIfHasErrors( SiteManagerException.class);

 
 		return userContext.getDAOGroup().getSiteDAO().load(siteId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Site site, Map<String, Object> tokens){
		super.addActions(userContext, site, tokens);
		
		addAction(userContext, site, tokens,"@create","createSite","createSite/","main","primary");
		addAction(userContext, site, tokens,"@update","updateSite","updateSite/"+site.getId()+"/","main","primary");
		addAction(userContext, site, tokens,"@copy","cloneSite","cloneSite/"+site.getId()+"/","main","primary");
		
		addAction(userContext, site, tokens,"site.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+site.getId()+"/","main","primary");
		addAction(userContext, site, tokens,"site.addCatalog","addCatalog","addCatalog/"+site.getId()+"/","catalogList","primary");
		addAction(userContext, site, tokens,"site.removeCatalog","removeCatalog","removeCatalog/"+site.getId()+"/","catalogList","primary");
		addAction(userContext, site, tokens,"site.updateCatalog","updateCatalog","updateCatalog/"+site.getId()+"/","catalogList","primary");
		addAction(userContext, site, tokens,"site.copyCatalogFrom","copyCatalogFrom","copyCatalogFrom/"+site.getId()+"/","catalogList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Site site, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Site createSite(UxsUserContext userContext,String name, String introduction, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfSite(name);
		userContext.getChecker().checkIntroductionOfSite(introduction);
	
		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);


		Site site=createNewSite();	

		site.setName(name);
		site.setIntroduction(introduction);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		site.setPlatform(platform);
		
		
		site.setLastUpdateTime(userContext.now());

		site = saveSite(userContext, site, emptyOptions());
		
		onNewInstanceCreated(userContext, site);
		return site;

		
	}
	protected Site createNewSite() 
	{
		
		return new Site();		
	}
	
	protected void checkParamsForUpdatingSite(UxsUserContext userContext,String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkVersionOfSite( siteVersion);
		

		if(Site.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSite(parseString(newValueExpr));
		}
		if(Site.INTRODUCTION_PROPERTY.equals(property)){
			userContext.getChecker().checkIntroductionOfSite(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);
	
		
	}
	
	
	
	public Site clone(UxsUserContext userContext, String fromSiteId) throws Exception{
		
		return userContext.getDAOGroup().getSiteDAO().clone(fromSiteId, this.allTokens());
	}
	
	public Site internalSaveSite(UxsUserContext userContext, Site site) throws Exception 
	{
		return internalSaveSite(userContext, site, allTokens());

	}
	public Site internalSaveSite(UxsUserContext userContext, Site site, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSite(userContext, siteId, siteVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(site){ 
			//will be good when the site loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Site.
			
			
			site = saveSite(userContext, site, options);
			return site;
			
		}

	}
	
	public Site updateSite(UxsUserContext userContext,String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSite(userContext, siteId, siteVersion, property, newValueExpr, tokensExpr);
		
		
		
		Site site = loadSite(userContext, siteId, allTokens());
		if(site.getVersion() != siteVersion){
			String message = "The target version("+site.getVersion()+") is not equals to version("+siteVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(site){ 
			//will be good when the site loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Site.
			site.updateLastUpdateTime(userContext.now());
			site.changeProperty(property, newValueExpr);
			site = saveSite(userContext, site, tokens().done());
			return present(userContext,site, mergedAllTokens(tokensExpr));
			//return saveSite(userContext, site, tokens().done());
		}

	}
	
	public Site updateSiteProperty(UxsUserContext userContext,String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSite(userContext, siteId, siteVersion, property, newValueExpr, tokensExpr);
		
		Site site = loadSite(userContext, siteId, allTokens());
		if(site.getVersion() != siteVersion){
			String message = "The target version("+site.getVersion()+") is not equals to version("+siteVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(site){ 
			//will be good when the site loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Site.
			
			site.changeProperty(property, newValueExpr);
			site.updateLastUpdateTime(userContext.now());
			site = saveSite(userContext, site, tokens().done());
			return present(userContext,site, mergedAllTokens(tokensExpr));
			//return saveSite(userContext, site, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SiteTokens tokens(){
		return SiteTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SiteTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCatalogListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SiteTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(UxsUserContext userContext, String siteId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSite(siteId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);
 		
 	}
 	public Site transferToAnotherPlatform(UxsUserContext userContext, String siteId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, siteId,anotherPlatformId);
 
		Site site = loadSite(userContext, siteId, allTokens());	
		synchronized(site){
			//will be good when the site loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			site.updatePlatform(platform);		
			site = saveSite(userContext, site, emptyOptions());
			
			return present(userContext,site, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForSite(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(UxsUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String siteId, int siteVersion) throws Exception {
		//deleteInternal(userContext, siteId, siteVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String siteId, int siteVersion) throws Exception{
			
		userContext.getDAOGroup().getSiteDAO().delete(siteId, siteVersion);
	}
	
	public Site forgetByAll(UxsUserContext userContext, String siteId, int siteVersion) throws Exception {
		return forgetByAllInternal(userContext, siteId, siteVersion);		
	}
	protected Site forgetByAllInternal(UxsUserContext userContext,
			String siteId, int siteVersion) throws Exception{
			
		return userContext.getDAOGroup().getSiteDAO().disconnectFromAll(siteId, siteVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SiteManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSiteDAO().deleteAll();
	}


	//disconnect Site with seller_id in Catalog
	protected Site breakWithCatalogBySellerId(UxsUserContext userContext, String siteId, String sellerIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Site site = loadSite(userContext, siteId, allTokens());

			synchronized(site){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSiteDAO().planToRemoveCatalogListWithSellerId(site, sellerIdId, this.emptyOptions());

				site = saveSite(userContext, site, tokens().withCatalogList().done());
				return site;
			}
	}
	//disconnect Site with platform in Catalog
	protected Site breakWithCatalogByPlatform(UxsUserContext userContext, String siteId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Site site = loadSite(userContext, siteId, allTokens());

			synchronized(site){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSiteDAO().planToRemoveCatalogListWithPlatform(site, platformId, this.emptyOptions());

				site = saveSite(userContext, site, tokens().withCatalogList().done());
				return site;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingCatalog(UxsUserContext userContext, String siteId, String name, String sellerId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSite(siteId);

		
		userContext.getChecker().checkNameOfCatalog(name);
		
		userContext.getChecker().checkSellerIdOfCatalog(sellerId);
		
		userContext.getChecker().checkPlatformIdOfCatalog(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);

	
	}
	public  Site addCatalog(UxsUserContext userContext, String siteId, String name, String sellerId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCatalog(userContext,siteId,name, sellerId, platformId,tokensExpr);
		
		Catalog catalog = createCatalog(userContext,name, sellerId, platformId);
		
		Site site = loadSite(userContext, siteId, allTokens());
		synchronized(site){ 
			//Will be good when the site loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			site.addCatalog( catalog );		
			site = saveSite(userContext, site, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, catalog);
			return present(userContext,site, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCatalogProperties(UxsUserContext userContext, String siteId,String id,String name,String sellerId,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkIdOfCatalog(id);
		
		userContext.getChecker().checkNameOfCatalog( name);
		userContext.getChecker().checkSellerIdOfCatalog( sellerId);

		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);
		
	}
	public  Site updateCatalogProperties(UxsUserContext userContext, String siteId, String id,String name,String sellerId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingCatalogProperties(userContext,siteId,id,name,sellerId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCatalogListList()
				.searchCatalogListWith(Catalog.ID_PROPERTY, "is", id).done();
		
		Site siteToUpdate = loadSite(userContext, siteId, options);
		
		if(siteToUpdate.getCatalogList().isEmpty()){
			throw new SiteManagerException("Catalog is NOT FOUND with id: '"+id+"'");
		}
		
		Catalog item = siteToUpdate.getCatalogList().first();
		
		item.updateName( name );
		item.updateSellerId( sellerId );

		
		//checkParamsForAddingCatalog(userContext,siteId,name, code, used,tokensExpr);
		Site site = saveSite(userContext, siteToUpdate, tokens().withCatalogList().done());
		synchronized(site){ 
			return present(userContext,site, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Catalog createCatalog(UxsUserContext userContext, String name, String sellerId, String platformId) throws Exception{

		Catalog catalog = new Catalog();
		
		
		catalog.setName(name);		
		catalog.setSellerId(sellerId);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		catalog.setPlatform(platform);
	
		
		return catalog;
	
		
	}
	
	protected Catalog createIndexedCatalog(String id, int version){

		Catalog catalog = new Catalog();
		catalog.setId(id);
		catalog.setVersion(version);
		return catalog;			
		
	}
	
	protected void checkParamsForRemovingCatalogList(UxsUserContext userContext, String siteId, 
			String catalogIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSite(siteId);
		for(String catalogId: catalogIds){
			userContext.getChecker().checkIdOfCatalog(catalogId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);
		
	}
	public  Site removeCatalogList(UxsUserContext userContext, String siteId, 
			String catalogIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingCatalogList(userContext, siteId,  catalogIds, tokensExpr);
			
			
			Site site = loadSite(userContext, siteId, allTokens());
			synchronized(site){ 
				//Will be good when the site loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSiteDAO().planToRemoveCatalogList(site, catalogIds, allTokens());
				site = saveSite(userContext, site, tokens().withCatalogList().done());
				deleteRelationListInGraph(userContext, site.getCatalogList());
				return present(userContext,site, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingCatalog(UxsUserContext userContext, String siteId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSite( siteId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);
	
	}
	public  Site removeCatalog(UxsUserContext userContext, String siteId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCatalog(userContext,siteId, catalogId, catalogVersion,tokensExpr);
		
		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		Site site = loadSite(userContext, siteId, allTokens());
		synchronized(site){ 
			//Will be good when the site loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			site.removeCatalog( catalog );		
			site = saveSite(userContext, site, tokens().withCatalogList().done());
			deleteRelationInGraph(userContext, catalog);
			return present(userContext,site, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingCatalog(UxsUserContext userContext, String siteId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSite( siteId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);
	
	}
	public  Site copyCatalogFrom(UxsUserContext userContext, String siteId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCatalog(userContext,siteId, catalogId, catalogVersion,tokensExpr);
		
		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		Site site = loadSite(userContext, siteId, allTokens());
		synchronized(site){ 
			//Will be good when the site loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			site.copyCatalogFrom( catalog );		
			site = saveSite(userContext, site, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, (Catalog)site.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,site, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingCatalog(UxsUserContext userContext, String siteId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSite(siteId);
		userContext.getChecker().checkIdOfCatalog(catalogId);
		userContext.getChecker().checkVersionOfCatalog(catalogVersion);
		

		if(Catalog.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCatalog(parseString(newValueExpr));
		}
		
		if(Catalog.SELLER_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSellerIdOfCatalog(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SiteManagerException.class);
	
	}
	
	public  Site updateCatalog(UxsUserContext userContext, String siteId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCatalog(userContext, siteId, catalogId, catalogVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withCatalogList().searchCatalogListWith(Catalog.ID_PROPERTY, "eq", catalogId).done();
		
		
		
		Site site = loadSite(userContext, siteId, loadTokens);
		
		synchronized(site){ 
			//Will be good when the site loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//site.removeCatalog( catalog );	
			//make changes to AcceleraterAccount.
			Catalog catalogIndex = createIndexedCatalog(catalogId, catalogVersion);
		
			Catalog catalog = site.findTheCatalog(catalogIndex);
			if(catalog == null){
				throw new SiteManagerException(catalog+" is NOT FOUND" );
			}
			
			catalog.changeProperty(property, newValueExpr);
			
			site = saveSite(userContext, site, tokens().withCatalogList().done());
			return present(userContext,site, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UxsUserContext userContext, Site newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


