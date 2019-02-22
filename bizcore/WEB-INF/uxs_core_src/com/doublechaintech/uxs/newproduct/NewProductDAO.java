
package com.doublechaintech.uxs.newproduct;
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


public interface NewProductDAO{

	
	public NewProduct load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<NewProduct> newProductList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public NewProduct present(NewProduct newProduct,Map<String,Object> options) throws Exception;
	public NewProduct clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public NewProduct save(NewProduct newProduct,Map<String,Object> options);
	public SmartList<NewProduct> saveNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options);
	public SmartList<NewProduct> removeNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options);
	public SmartList<NewProduct> findNewProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countNewProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countNewProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String newProductId, int version) throws Exception;
	public NewProduct disconnectFromAll(String newProductId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<NewProduct> queryList(String sql, Object ... parmeters);
 
 	public SmartList<NewProduct> findNewProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public int countNewProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countNewProductByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<NewProduct> findNewProductByParentCategory(String levelNCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeNewProductByParentCategory(SmartList<NewProduct> resultList, String levelNCategoryId, Map<String,Object> options);

 
  
 	public SmartList<NewProduct> findNewProductByBrand(String brandId, Map<String,Object> options);
 	public int countNewProductByBrand(String brandId, Map<String,Object> options);
 	public Map<String, Integer> countNewProductByBrandIds(String[] ids, Map<String,Object> options);
 	public SmartList<NewProduct> findNewProductByBrand(String brandId, int start, int count, Map<String,Object> options);
 	public void analyzeNewProductByBrand(SmartList<NewProduct> resultList, String brandId, Map<String,Object> options);

 
  
 	public SmartList<NewProduct> findNewProductByCatalog(String catalogId, Map<String,Object> options);
 	public int countNewProductByCatalog(String catalogId, Map<String,Object> options);
 	public Map<String, Integer> countNewProductByCatalogIds(String[] ids, Map<String,Object> options);
 	public SmartList<NewProduct> findNewProductByCatalog(String catalogId, int start, int count, Map<String,Object> options);
 	public void analyzeNewProductByCatalog(SmartList<NewProduct> resultList, String catalogId, Map<String,Object> options);

 
  
 	public SmartList<NewProduct> findNewProductByProfile(String profileId, Map<String,Object> options);
 	public int countNewProductByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countNewProductByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<NewProduct> findNewProductByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeNewProductByProfile(SmartList<NewProduct> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<NewProduct> findNewProductByPlatform(String platformId, Map<String,Object> options);
 	public int countNewProductByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countNewProductByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<NewProduct> findNewProductByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeNewProductByPlatform(SmartList<NewProduct> resultList, String platformId, Map<String,Object> options);

 
 }


