
package com.doublechaintech.uxs.banner;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface BannerManager{

		

	public Banner createBanner(UxsUserContext userContext, String name, String imagePath, String platformId) throws Exception;	
	public Banner updateBanner(UxsUserContext userContext,String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Banner loadBanner(UxsUserContext userContext, String bannerId, String [] tokensExpr) throws Exception;
	public Banner internalSaveBanner(UxsUserContext userContext, Banner banner) throws Exception;
	public Banner internalSaveBanner(UxsUserContext userContext, Banner banner,Map<String,Object>option) throws Exception;
	
	public Banner transferToAnotherPlatform(UxsUserContext userContext, String bannerId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String bannerId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Banner newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TargetManager getTargetManager(UxsUserContext userContext, String bannerId, String name, String profileId, String location ,String [] tokensExpr)  throws Exception;
	
	public  Banner addTarget(UxsUserContext userContext, String bannerId, String name, String profileId, String location , String [] tokensExpr)  throws Exception;
	public  Banner removeTarget(UxsUserContext userContext, String bannerId, String targetId, int targetVersion,String [] tokensExpr)  throws Exception;
	public  Banner updateTarget(UxsUserContext userContext, String bannerId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


