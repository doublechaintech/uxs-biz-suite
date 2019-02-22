
package com.doublechaintech.uxs.categoryfilter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.profile.ProfileDAO;


public interface CategoryFilterDAO{

	
	public CategoryFilter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CategoryFilter> categoryFilterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CategoryFilter present(CategoryFilter categoryFilter,Map<String,Object> options) throws Exception;
	public CategoryFilter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CategoryFilter save(CategoryFilter categoryFilter,Map<String,Object> options);
	public SmartList<CategoryFilter> saveCategoryFilterList(SmartList<CategoryFilter> categoryFilterList,Map<String,Object> options);
	public SmartList<CategoryFilter> removeCategoryFilterList(SmartList<CategoryFilter> categoryFilterList,Map<String,Object> options);
	public SmartList<CategoryFilter> findCategoryFilterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCategoryFilterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCategoryFilterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String categoryFilterId, int version) throws Exception;
	public CategoryFilter disconnectFromAll(String categoryFilterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<CategoryFilter> queryList(String sql, Object ... parmeters);
 
 	public SmartList<CategoryFilter> findCategoryFilterByProfile(String profileId, Map<String,Object> options);
 	public int countCategoryFilterByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countCategoryFilterByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<CategoryFilter> findCategoryFilterByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeCategoryFilterByProfile(SmartList<CategoryFilter> resultList, String profileId, Map<String,Object> options);

 
 }


