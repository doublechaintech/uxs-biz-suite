
package com.doublechaintech.uxs.recommandproduct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.brand.BrandDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.catalog.CatalogDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;
import com.doublechaintech.uxs.levelncategory.LevelNCategoryDAO;


public interface RecommandProductDAO{

	
	public RecommandProduct load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RecommandProduct> recommandProductList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RecommandProduct present(RecommandProduct recommandProduct,Map<String,Object> options) throws Exception;
	public RecommandProduct clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RecommandProduct save(RecommandProduct recommandProduct,Map<String,Object> options);
	public SmartList<RecommandProduct> saveRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options);
	public SmartList<RecommandProduct> removeRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options);
	public SmartList<RecommandProduct> findRecommandProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRecommandProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRecommandProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String recommandProductId, int version) throws Exception;
	public RecommandProduct disconnectFromAll(String recommandProductId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<RecommandProduct> queryList(String sql, Object ... parmeters);
 
 	public SmartList<RecommandProduct> findRecommandProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public int countRecommandProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countRecommandProductByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<RecommandProduct> findRecommandProductByParentCategory(String levelNCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeRecommandProductByParentCategory(SmartList<RecommandProduct> resultList, String levelNCategoryId, Map<String,Object> options);

 
  
 	public SmartList<RecommandProduct> findRecommandProductByBrand(String brandId, Map<String,Object> options);
 	public int countRecommandProductByBrand(String brandId, Map<String,Object> options);
 	public Map<String, Integer> countRecommandProductByBrandIds(String[] ids, Map<String,Object> options);
 	public SmartList<RecommandProduct> findRecommandProductByBrand(String brandId, int start, int count, Map<String,Object> options);
 	public void analyzeRecommandProductByBrand(SmartList<RecommandProduct> resultList, String brandId, Map<String,Object> options);

 
  
 	public SmartList<RecommandProduct> findRecommandProductByCatalog(String catalogId, Map<String,Object> options);
 	public int countRecommandProductByCatalog(String catalogId, Map<String,Object> options);
 	public Map<String, Integer> countRecommandProductByCatalogIds(String[] ids, Map<String,Object> options);
 	public SmartList<RecommandProduct> findRecommandProductByCatalog(String catalogId, int start, int count, Map<String,Object> options);
 	public void analyzeRecommandProductByCatalog(SmartList<RecommandProduct> resultList, String catalogId, Map<String,Object> options);

 
  
 	public SmartList<RecommandProduct> findRecommandProductByProfile(String profileId, Map<String,Object> options);
 	public int countRecommandProductByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countRecommandProductByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<RecommandProduct> findRecommandProductByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeRecommandProductByProfile(SmartList<RecommandProduct> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<RecommandProduct> findRecommandProductByPlatform(String platformId, Map<String,Object> options);
 	public int countRecommandProductByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countRecommandProductByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<RecommandProduct> findRecommandProductByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeRecommandProductByPlatform(SmartList<RecommandProduct> resultList, String platformId, Map<String,Object> options);

 
 }


