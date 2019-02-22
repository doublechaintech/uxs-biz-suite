
package com.doublechaintech.uxs.pricefilter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.profile.ProfileDAO;


public interface PriceFilterDAO{

	
	public PriceFilter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PriceFilter> priceFilterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PriceFilter present(PriceFilter priceFilter,Map<String,Object> options) throws Exception;
	public PriceFilter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PriceFilter save(PriceFilter priceFilter,Map<String,Object> options);
	public SmartList<PriceFilter> savePriceFilterList(SmartList<PriceFilter> priceFilterList,Map<String,Object> options);
	public SmartList<PriceFilter> removePriceFilterList(SmartList<PriceFilter> priceFilterList,Map<String,Object> options);
	public SmartList<PriceFilter> findPriceFilterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPriceFilterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPriceFilterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String priceFilterId, int version) throws Exception;
	public PriceFilter disconnectFromAll(String priceFilterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<PriceFilter> queryList(String sql, Object ... parmeters);
 
 	public SmartList<PriceFilter> findPriceFilterByProfile(String profileId, Map<String,Object> options);
 	public int countPriceFilterByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countPriceFilterByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<PriceFilter> findPriceFilterByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzePriceFilterByProfile(SmartList<PriceFilter> resultList, String profileId, Map<String,Object> options);

 
 }


