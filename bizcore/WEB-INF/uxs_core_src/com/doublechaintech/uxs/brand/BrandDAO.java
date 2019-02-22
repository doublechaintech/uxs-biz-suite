
package com.doublechaintech.uxs.brand;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;


public interface BrandDAO{

	
	public Brand load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Brand> brandList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Brand present(Brand brand,Map<String,Object> options) throws Exception;
	public Brand clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Brand save(Brand brand,Map<String,Object> options);
	public SmartList<Brand> saveBrandList(SmartList<Brand> brandList,Map<String,Object> options);
	public SmartList<Brand> removeBrandList(SmartList<Brand> brandList,Map<String,Object> options);
	public SmartList<Brand> findBrandWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countBrandWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countBrandWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String brandId, int version) throws Exception;
	public Brand disconnectFromAll(String brandId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductDAO getProductDAO();
		
	public NewProductDAO getNewProductDAO();
		
	public EditorPickProductDAO getEditorPickProductDAO();
		
	public TopRatedProductDAO getTopRatedProductDAO();
		
	public RecommandProductDAO getRecommandProductDAO();
		
	
 	public SmartList<Brand> requestCandidateBrandForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Brand> requestCandidateBrandForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Brand> requestCandidateBrandForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Brand> requestCandidateBrandForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Brand> requestCandidateBrandForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Brand planToRemoveProductList(Brand brand, String productIds[], Map<String,Object> options)throws Exception;


	//disconnect Brand with parent_category in Product
	public Brand planToRemoveProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with catalog in Product
	public Brand planToRemoveProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception;
	public int countProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with platform in Product
	public Brand planToRemoveProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception;
	public int countProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception;
	
	public Brand planToRemoveNewProductList(Brand brand, String newProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Brand with parent_category in NewProduct
	public Brand planToRemoveNewProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with catalog in NewProduct
	public Brand planToRemoveNewProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with profile in NewProduct
	public Brand planToRemoveNewProductListWithProfile(Brand brand, String profileId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithProfile(String brandId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with platform in NewProduct
	public Brand planToRemoveNewProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception;
	
	public Brand planToRemoveEditorPickProductList(Brand brand, String editorPickProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Brand with parent_category in EditorPickProduct
	public Brand planToRemoveEditorPickProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with catalog in EditorPickProduct
	public Brand planToRemoveEditorPickProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with profile in EditorPickProduct
	public Brand planToRemoveEditorPickProductListWithProfile(Brand brand, String profileId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithProfile(String brandId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with platform in EditorPickProduct
	public Brand planToRemoveEditorPickProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception;
	
	public Brand planToRemoveTopRatedProductList(Brand brand, String topRatedProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Brand with parent_category in TopRatedProduct
	public Brand planToRemoveTopRatedProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with catalog in TopRatedProduct
	public Brand planToRemoveTopRatedProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with profile in TopRatedProduct
	public Brand planToRemoveTopRatedProductListWithProfile(Brand brand, String profileId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithProfile(String brandId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with platform in TopRatedProduct
	public Brand planToRemoveTopRatedProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception;
	
	public Brand planToRemoveRecommandProductList(Brand brand, String recommandProductIds[], Map<String,Object> options)throws Exception;


	//disconnect Brand with parent_category in RecommandProduct
	public Brand planToRemoveRecommandProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with catalog in RecommandProduct
	public Brand planToRemoveRecommandProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with profile in RecommandProduct
	public Brand planToRemoveRecommandProductListWithProfile(Brand brand, String profileId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithProfile(String brandId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with platform in RecommandProduct
	public Brand planToRemoveRecommandProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Brand> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Brand> findBrandByPlatform(String platformId, Map<String,Object> options);
 	public int countBrandByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countBrandByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Brand> findBrandByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeBrandByPlatform(SmartList<Brand> resultList, String platformId, Map<String,Object> options);

 
 }


