
package com.doublechaintech.uxs.editorpickproduct;
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


public interface EditorPickProductDAO{

	
	public EditorPickProduct load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EditorPickProduct> editorPickProductList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EditorPickProduct present(EditorPickProduct editorPickProduct,Map<String,Object> options) throws Exception;
	public EditorPickProduct clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EditorPickProduct save(EditorPickProduct editorPickProduct,Map<String,Object> options);
	public SmartList<EditorPickProduct> saveEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options);
	public SmartList<EditorPickProduct> removeEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options);
	public SmartList<EditorPickProduct> findEditorPickProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEditorPickProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEditorPickProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String editorPickProductId, int version) throws Exception;
	public EditorPickProduct disconnectFromAll(String editorPickProductId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EditorPickProduct> queryList(String sql, Object ... parmeters);
 
 	public SmartList<EditorPickProduct> findEditorPickProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public int countEditorPickProductByParentCategory(String levelNCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countEditorPickProductByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<EditorPickProduct> findEditorPickProductByParentCategory(String levelNCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeEditorPickProductByParentCategory(SmartList<EditorPickProduct> resultList, String levelNCategoryId, Map<String,Object> options);

 
  
 	public SmartList<EditorPickProduct> findEditorPickProductByBrand(String brandId, Map<String,Object> options);
 	public int countEditorPickProductByBrand(String brandId, Map<String,Object> options);
 	public Map<String, Integer> countEditorPickProductByBrandIds(String[] ids, Map<String,Object> options);
 	public SmartList<EditorPickProduct> findEditorPickProductByBrand(String brandId, int start, int count, Map<String,Object> options);
 	public void analyzeEditorPickProductByBrand(SmartList<EditorPickProduct> resultList, String brandId, Map<String,Object> options);

 
  
 	public SmartList<EditorPickProduct> findEditorPickProductByCatalog(String catalogId, Map<String,Object> options);
 	public int countEditorPickProductByCatalog(String catalogId, Map<String,Object> options);
 	public Map<String, Integer> countEditorPickProductByCatalogIds(String[] ids, Map<String,Object> options);
 	public SmartList<EditorPickProduct> findEditorPickProductByCatalog(String catalogId, int start, int count, Map<String,Object> options);
 	public void analyzeEditorPickProductByCatalog(SmartList<EditorPickProduct> resultList, String catalogId, Map<String,Object> options);

 
  
 	public SmartList<EditorPickProduct> findEditorPickProductByProfile(String profileId, Map<String,Object> options);
 	public int countEditorPickProductByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countEditorPickProductByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<EditorPickProduct> findEditorPickProductByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeEditorPickProductByProfile(SmartList<EditorPickProduct> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<EditorPickProduct> findEditorPickProductByPlatform(String platformId, Map<String,Object> options);
 	public int countEditorPickProductByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countEditorPickProductByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<EditorPickProduct> findEditorPickProductByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeEditorPickProductByPlatform(SmartList<EditorPickProduct> resultList, String platformId, Map<String,Object> options);

 
 }


