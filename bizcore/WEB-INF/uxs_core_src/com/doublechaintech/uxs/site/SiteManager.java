
package com.doublechaintech.uxs.site;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface SiteManager{

		

	public Site createSite(UxsUserContext userContext, String name, String introduction, String platformId) throws Exception;	
	public Site updateSite(UxsUserContext userContext,String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Site loadSite(UxsUserContext userContext, String siteId, String [] tokensExpr) throws Exception;
	public Site internalSaveSite(UxsUserContext userContext, Site site) throws Exception;
	public Site internalSaveSite(UxsUserContext userContext, Site site,Map<String,Object>option) throws Exception;
	
	public Site transferToAnotherPlatform(UxsUserContext userContext, String siteId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String siteId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Site newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  CatalogManager getCatalogManager(UxsUserContext userContext, String siteId, String name, String sellerId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Site addCatalog(UxsUserContext userContext, String siteId, String name, String sellerId, String platformId , String [] tokensExpr)  throws Exception;
	public  Site removeCatalog(UxsUserContext userContext, String siteId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  Site updateCatalog(UxsUserContext userContext, String siteId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


