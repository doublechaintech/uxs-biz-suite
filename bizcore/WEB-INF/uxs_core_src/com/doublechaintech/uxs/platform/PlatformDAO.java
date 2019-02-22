
package com.doublechaintech.uxs.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.brand.BrandDAO;
import com.doublechaintech.uxs.site.SiteDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.banner.BannerDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.catalog.CatalogDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;
import com.doublechaintech.uxs.useralert.UserAlertDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SiteDAO getSiteDAO();
		
	public CatalogDAO getCatalogDAO();
		
	public BrandDAO getBrandDAO();
		
	public ProductDAO getProductDAO();
		
	public BannerDAO getBannerDAO();
		
	public ProfileDAO getProfileDAO();
		
	public UserAlertDAO getUserAlertDAO();
		
	public NewProductDAO getNewProductDAO();
		
	public EditorPickProductDAO getEditorPickProductDAO();
		
	public TopRatedProductDAO getTopRatedProductDAO();
		
	public RecommandProductDAO getRecommandProductDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForSite(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForCatalog(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForBrand(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForBanner(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForProfile(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForUserAlert(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveSiteList(Platform platform, String siteIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveCatalogList(Platform platform, String catalogIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with seller_id in Catalog
	public Platform planToRemoveCatalogListWithSellerId(Platform platform, String sellerIdId, Map<String,Object> options)throws Exception;
	public int countCatalogListWithSellerId(String platformId, String sellerIdId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with site in Catalog
	public Platform planToRemoveCatalogListWithSite(Platform platform, String siteId, Map<String,Object> options)throws Exception;
	public int countCatalogListWithSite(String platformId, String siteId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveBrandList(Platform platform, String brandIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveProductList(Platform platform, String productIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with parent_category in Product
	public Platform planToRemoveProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with brand in Product
	public Platform planToRemoveProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception;
	public int countProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with catalog in Product
	public Platform planToRemoveProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception;
	public int countProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveBannerList(Platform platform, String bannerIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveUserAlertList(Platform platform, String userAlertIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with profile in UserAlert
	public Platform planToRemoveUserAlertListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception;
	public int countUserAlertListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveNewProductList(Platform platform, String newProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with parent_category in NewProduct
	public Platform planToRemoveNewProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with brand in NewProduct
	public Platform planToRemoveNewProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with catalog in NewProduct
	public Platform planToRemoveNewProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with profile in NewProduct
	public Platform planToRemoveNewProductListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveEditorPickProductList(Platform platform, String editorPickProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with parent_category in EditorPickProduct
	public Platform planToRemoveEditorPickProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with brand in EditorPickProduct
	public Platform planToRemoveEditorPickProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with catalog in EditorPickProduct
	public Platform planToRemoveEditorPickProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with profile in EditorPickProduct
	public Platform planToRemoveEditorPickProductListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveTopRatedProductList(Platform platform, String topRatedProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with parent_category in TopRatedProduct
	public Platform planToRemoveTopRatedProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with brand in TopRatedProduct
	public Platform planToRemoveTopRatedProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with catalog in TopRatedProduct
	public Platform planToRemoveTopRatedProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with profile in TopRatedProduct
	public Platform planToRemoveTopRatedProductListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveRecommandProductList(Platform platform, String recommandProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with parent_category in RecommandProduct
	public Platform planToRemoveRecommandProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with brand in RecommandProduct
	public Platform planToRemoveRecommandProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with catalog in RecommandProduct
	public Platform planToRemoveRecommandProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with profile in RecommandProduct
	public Platform planToRemoveRecommandProductListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


