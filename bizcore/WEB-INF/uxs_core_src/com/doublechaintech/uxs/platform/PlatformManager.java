
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
	

	//public  SiteManager getSiteManager(UxsUserContext userContext, String platformId, String name, String introduction ,String [] tokensExpr)  throws Exception;
	
	public  Platform addSite(UxsUserContext userContext, String platformId, String name, String introduction , String [] tokensExpr)  throws Exception;
	public  Platform removeSite(UxsUserContext userContext, String platformId, String siteId, int siteVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateSite(UxsUserContext userContext, String platformId, String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CatalogManager getCatalogManager(UxsUserContext userContext, String platformId, String name, String sellerId, String siteId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addCatalog(UxsUserContext userContext, String platformId, String name, String sellerId, String siteId , String [] tokensExpr)  throws Exception;
	public  Platform removeCatalog(UxsUserContext userContext, String platformId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateCatalog(UxsUserContext userContext, String platformId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  BrandManager getBrandManager(UxsUserContext userContext, String platformId, String brandName, String logo, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Platform addBrand(UxsUserContext userContext, String platformId, String brandName, String logo, String remark , String [] tokensExpr)  throws Exception;
	public  Platform removeBrand(UxsUserContext userContext, String platformId, String brandId, int brandVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateBrand(UxsUserContext userContext, String platformId, String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProductManager getProductManager(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark , String [] tokensExpr)  throws Exception;
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

	//public  UserAlertManager getUserAlertManager(UxsUserContext userContext, String platformId, String message, String profileId, String location ,String [] tokensExpr)  throws Exception;
	
	public  Platform addUserAlert(UxsUserContext userContext, String platformId, String message, String profileId, String location , String [] tokensExpr)  throws Exception;
	public  Platform removeUserAlert(UxsUserContext userContext, String platformId, String userAlertId, int userAlertVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateUserAlert(UxsUserContext userContext, String platformId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Platform addNewProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark , String [] tokensExpr)  throws Exception;
	public  Platform removeNewProduct(UxsUserContext userContext, String platformId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateNewProduct(UxsUserContext userContext, String platformId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark ,String [] tokensExpr)  throws Exception;
	
	public  Platform addEditorPickProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark , String [] tokensExpr)  throws Exception;
	public  Platform removeEditorPickProduct(UxsUserContext userContext, String platformId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateEditorPickProduct(UxsUserContext userContext, String platformId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTopRatedProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId , String [] tokensExpr)  throws Exception;
	public  Platform removeTopRatedProduct(UxsUserContext userContext, String platformId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTopRatedProduct(UxsUserContext userContext, String platformId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addRecommandProduct(UxsUserContext userContext, String platformId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId , String [] tokensExpr)  throws Exception;
	public  Platform removeRecommandProduct(UxsUserContext userContext, String platformId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateRecommandProduct(UxsUserContext userContext, String platformId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


