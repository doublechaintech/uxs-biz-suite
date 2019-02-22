
package com.doublechaintech.uxs.brandfilter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.profile.ProfileDAO;


public interface BrandFilterDAO{

	
	public BrandFilter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<BrandFilter> brandFilterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public BrandFilter present(BrandFilter brandFilter,Map<String,Object> options) throws Exception;
	public BrandFilter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public BrandFilter save(BrandFilter brandFilter,Map<String,Object> options);
	public SmartList<BrandFilter> saveBrandFilterList(SmartList<BrandFilter> brandFilterList,Map<String,Object> options);
	public SmartList<BrandFilter> removeBrandFilterList(SmartList<BrandFilter> brandFilterList,Map<String,Object> options);
	public SmartList<BrandFilter> findBrandFilterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countBrandFilterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countBrandFilterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String brandFilterId, int version) throws Exception;
	public BrandFilter disconnectFromAll(String brandFilterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<BrandFilter> queryList(String sql, Object ... parmeters);
 
 	public SmartList<BrandFilter> findBrandFilterByProfile(String profileId, Map<String,Object> options);
 	public int countBrandFilterByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countBrandFilterByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<BrandFilter> findBrandFilterByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeBrandFilterByProfile(SmartList<BrandFilter> resultList, String profileId, Map<String,Object> options);

 
 }


