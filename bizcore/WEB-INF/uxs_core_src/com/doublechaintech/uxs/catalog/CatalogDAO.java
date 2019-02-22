
package com.doublechaintech.uxs.catalog;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.site.SiteDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;


public interface CatalogDAO{

	
	public Catalog load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Catalog> catalogList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Catalog present(Catalog catalog,Map<String,Object> options) throws Exception;
	public Catalog clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Catalog save(Catalog catalog,Map<String,Object> options);
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> findCatalogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCatalogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCatalogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String catalogId, int version) throws Exception;
	public Catalog disconnectFromAll(String catalogId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LevelOneCategoryDAO getLevelOneCategoryDAO();
		
	public ProductDAO getProductDAO();
		
	public NewProductDAO getNewProductDAO();
		
	public EditorPickProductDAO getEditorPickProductDAO();
		
	public TopRatedProductDAO getTopRatedProductDAO();
		
	public RecommandProductDAO getRecommandProductDAO();
		
	
 	public SmartList<Catalog> requestCandidateCatalogForLevelOneCategory(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Catalog> requestCandidateCatalogForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Catalog> requestCandidateCatalogForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Catalog> requestCandidateCatalogForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Catalog> requestCandidateCatalogForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Catalog> requestCandidateCatalogForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Catalog planToRemoveLevelOneCategoryList(Catalog catalog, String levelOneCategoryIds[], Map<String,Object> options)throws Exception;


	public Catalog planToRemoveProductList(Catalog catalog, String productIds[], Map<String,Object> options)throws Exception;


	//disconnect Catalog with parent_category in Product
	public Catalog planToRemoveProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with brand in Product
	public Catalog planToRemoveProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception;
	public int countProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with platform in Product
	public Catalog planToRemoveProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception;
	public int countProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception;
	
	public Catalog planToRemoveNewProductList(Catalog catalog, String newProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Catalog with parent_category in NewProduct
	public Catalog planToRemoveNewProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with brand in NewProduct
	public Catalog planToRemoveNewProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with profile in NewProduct
	public Catalog planToRemoveNewProductListWithProfile(Catalog catalog, String profileId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithProfile(String catalogId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with platform in NewProduct
	public Catalog planToRemoveNewProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception;
	
	public Catalog planToRemoveEditorPickProductList(Catalog catalog, String editorPickProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Catalog with parent_category in EditorPickProduct
	public Catalog planToRemoveEditorPickProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with brand in EditorPickProduct
	public Catalog planToRemoveEditorPickProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with profile in EditorPickProduct
	public Catalog planToRemoveEditorPickProductListWithProfile(Catalog catalog, String profileId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithProfile(String catalogId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with platform in EditorPickProduct
	public Catalog planToRemoveEditorPickProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception;
	
	public Catalog planToRemoveTopRatedProductList(Catalog catalog, String topRatedProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Catalog with parent_category in TopRatedProduct
	public Catalog planToRemoveTopRatedProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with brand in TopRatedProduct
	public Catalog planToRemoveTopRatedProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with profile in TopRatedProduct
	public Catalog planToRemoveTopRatedProductListWithProfile(Catalog catalog, String profileId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithProfile(String catalogId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with platform in TopRatedProduct
	public Catalog planToRemoveTopRatedProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception;
	
	public Catalog planToRemoveRecommandProductList(Catalog catalog, String recommandProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Catalog with parent_category in RecommandProduct
	public Catalog planToRemoveRecommandProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with brand in RecommandProduct
	public Catalog planToRemoveRecommandProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with profile in RecommandProduct
	public Catalog planToRemoveRecommandProductListWithProfile(Catalog catalog, String profileId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithProfile(String catalogId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with platform in RecommandProduct
	public Catalog planToRemoveRecommandProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Catalog> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Catalog> findCatalogBySite(String siteId, Map<String,Object> options);
 	public int countCatalogBySite(String siteId, Map<String,Object> options);
 	public Map<String, Integer> countCatalogBySiteIds(String[] ids, Map<String,Object> options);
 	public SmartList<Catalog> findCatalogBySite(String siteId, int start, int count, Map<String,Object> options);
 	public void analyzeCatalogBySite(SmartList<Catalog> resultList, String siteId, Map<String,Object> options);

 
  
 	public SmartList<Catalog> findCatalogByPlatform(String platformId, Map<String,Object> options);
 	public int countCatalogByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countCatalogByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Catalog> findCatalogByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeCatalogByPlatform(SmartList<Catalog> resultList, String platformId, Map<String,Object> options);

 
 }


