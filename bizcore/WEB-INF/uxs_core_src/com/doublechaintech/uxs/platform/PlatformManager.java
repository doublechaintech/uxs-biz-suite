
package com.doublechaintech.uxs.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(UxsUserContext userContext, String name) throws Exception;	
	public Platform updatePlatform(UxsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(UxsUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(UxsUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(UxsUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(UxsUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductManager getProductManager(UxsUserContext userContext, String platformId, String name, BigDecimal avarageScore ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProduct(UxsUserContext userContext, String platformId, String name, BigDecimal avarageScore , String [] tokensExpr)  throws Exception;
	public  Platform removeProduct(UxsUserContext userContext, String platformId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProduct(UxsUserContext userContext, String platformId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  BannerManager getBannerManager(UxsUserContext userContext, String platformId, String name, String imagePath ,String [] tokensExpr)  throws Exception;
	
	public  Platform addBanner(UxsUserContext userContext, String platformId, String name, String imagePath , String [] tokensExpr)  throws Exception;
	public  Platform removeBanner(UxsUserContext userContext, String platformId, String bannerId, int bannerVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateBanner(UxsUserContext userContext, String platformId, String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProfileManager getProfileManager(UxsUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProfile(UxsUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeProfile(UxsUserContext userContext, String platformId, String profileId, int profileVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProfile(UxsUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


