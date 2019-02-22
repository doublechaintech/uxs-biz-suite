
package com.doublechaintech.uxs.levelncategory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategoryDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;


public interface LevelNCategoryDAO{

	
	public LevelNCategory load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelNCategory> levelNCategoryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LevelNCategory present(LevelNCategory levelNCategory,Map<String,Object> options) throws Exception;
	public LevelNCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelNCategory save(LevelNCategory levelNCategory,Map<String,Object> options);
	public SmartList<LevelNCategory> saveLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options);
	public SmartList<LevelNCategory> removeLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options);
	public SmartList<LevelNCategory> findLevelNCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelNCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelNCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelNCategoryId, int version) throws Exception;
	public LevelNCategory disconnectFromAll(String levelNCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductDAO getProductDAO();
		
	public NewProductDAO getNewProductDAO();
		
	public EditorPickProductDAO getEditorPickProductDAO();
		
	public TopRatedProductDAO getTopRatedProductDAO();
		
	public RecommandProductDAO getRecommandProductDAO();
		
	
 	public SmartList<LevelNCategory> requestCandidateLevelNCategoryForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<LevelNCategory> requestCandidateLevelNCategoryForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<LevelNCategory> requestCandidateLevelNCategoryForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<LevelNCategory> requestCandidateLevelNCategoryForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<LevelNCategory> requestCandidateLevelNCategoryForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelNCategory planToRemoveProductList(LevelNCategory levelNCategory, String productIds[], Map<String,Object> options)throws Exception;


	//disconnect LevelNCategory with brand in Product
	public LevelNCategory planToRemoveProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception;
	public int countProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with catalog in Product
	public LevelNCategory planToRemoveProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception;
	public int countProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with platform in Product
	public LevelNCategory planToRemoveProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception;
	public int countProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception;
	
	public LevelNCategory planToRemoveNewProductList(LevelNCategory levelNCategory, String newProductIds[], Map<String,Object> options)throws Exception;


	//disconnect LevelNCategory with brand in NewProduct
	public LevelNCategory planToRemoveNewProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with catalog in NewProduct
	public LevelNCategory planToRemoveNewProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with profile in NewProduct
	public LevelNCategory planToRemoveNewProductListWithProfile(LevelNCategory levelNCategory, String profileId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithProfile(String levelNCategoryId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with platform in NewProduct
	public LevelNCategory planToRemoveNewProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception;
	public int countNewProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception;
	
	public LevelNCategory planToRemoveEditorPickProductList(LevelNCategory levelNCategory, String editorPickProductIds[], Map<String,Object> options)throws Exception;


	//disconnect LevelNCategory with brand in EditorPickProduct
	public LevelNCategory planToRemoveEditorPickProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with catalog in EditorPickProduct
	public LevelNCategory planToRemoveEditorPickProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with profile in EditorPickProduct
	public LevelNCategory planToRemoveEditorPickProductListWithProfile(LevelNCategory levelNCategory, String profileId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithProfile(String levelNCategoryId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with platform in EditorPickProduct
	public LevelNCategory planToRemoveEditorPickProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception;
	public int countEditorPickProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception;
	
	public LevelNCategory planToRemoveTopRatedProductList(LevelNCategory levelNCategory, String topRatedProductIds[], Map<String,Object> options)throws Exception;


	//disconnect LevelNCategory with brand in TopRatedProduct
	public LevelNCategory planToRemoveTopRatedProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with catalog in TopRatedProduct
	public LevelNCategory planToRemoveTopRatedProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with profile in TopRatedProduct
	public LevelNCategory planToRemoveTopRatedProductListWithProfile(LevelNCategory levelNCategory, String profileId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithProfile(String levelNCategoryId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with platform in TopRatedProduct
	public LevelNCategory planToRemoveTopRatedProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception;
	public int countTopRatedProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception;
	
	public LevelNCategory planToRemoveRecommandProductList(LevelNCategory levelNCategory, String recommandProductIds[], Map<String,Object> options)throws Exception;


	//disconnect LevelNCategory with brand in RecommandProduct
	public LevelNCategory planToRemoveRecommandProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with catalog in RecommandProduct
	public LevelNCategory planToRemoveRecommandProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with profile in RecommandProduct
	public LevelNCategory planToRemoveRecommandProductListWithProfile(LevelNCategory levelNCategory, String profileId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithProfile(String levelNCategoryId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with platform in RecommandProduct
	public LevelNCategory planToRemoveRecommandProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception;
	public int countRecommandProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<LevelNCategory> queryList(String sql, Object ... parmeters);
 
 	public SmartList<LevelNCategory> findLevelNCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public int countLevelNCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countLevelNCategoryByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelNCategory> findLevelNCategoryByParentCategory(String levelTwoCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelNCategoryByParentCategory(SmartList<LevelNCategory> resultList, String levelTwoCategoryId, Map<String,Object> options);

 
 }


