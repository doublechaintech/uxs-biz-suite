
package com.doublechaintech.uxs.target;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.banner.BannerDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;


public interface TargetDAO{

	
	public Target load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Target> targetList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Target present(Target target,Map<String,Object> options) throws Exception;
	public Target clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Target save(Target target,Map<String,Object> options);
	public SmartList<Target> saveTargetList(SmartList<Target> targetList,Map<String,Object> options);
	public SmartList<Target> removeTargetList(SmartList<Target> targetList,Map<String,Object> options);
	public SmartList<Target> findTargetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTargetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTargetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String targetId, int version) throws Exception;
	public Target disconnectFromAll(String targetId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Target> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Target> findTargetByProfile(String profileId, Map<String,Object> options);
 	public int countTargetByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countTargetByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<Target> findTargetByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeTargetByProfile(SmartList<Target> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<Target> findTargetByBanner(String bannerId, Map<String,Object> options);
 	public int countTargetByBanner(String bannerId, Map<String,Object> options);
 	public Map<String, Integer> countTargetByBannerIds(String[] ids, Map<String,Object> options);
 	public SmartList<Target> findTargetByBanner(String bannerId, int start, int count, Map<String,Object> options);
 	public void analyzeTargetByBanner(SmartList<Target> resultList, String bannerId, Map<String,Object> options);

 
 }


