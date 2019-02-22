
package com.doublechaintech.uxs.useralert;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;


public interface UserAlertDAO{

	
	public UserAlert load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserAlert> userAlertList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserAlert present(UserAlert userAlert,Map<String,Object> options) throws Exception;
	public UserAlert clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserAlert save(UserAlert userAlert,Map<String,Object> options);
	public SmartList<UserAlert> saveUserAlertList(SmartList<UserAlert> userAlertList,Map<String,Object> options);
	public SmartList<UserAlert> removeUserAlertList(SmartList<UserAlert> userAlertList,Map<String,Object> options);
	public SmartList<UserAlert> findUserAlertWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserAlertWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserAlertWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userAlertId, int version) throws Exception;
	public UserAlert disconnectFromAll(String userAlertId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<UserAlert> queryList(String sql, Object ... parmeters);
 
 	public SmartList<UserAlert> findUserAlertByProfile(String profileId, Map<String,Object> options);
 	public int countUserAlertByProfile(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countUserAlertByProfileIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserAlert> findUserAlertByProfile(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeUserAlertByProfile(SmartList<UserAlert> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<UserAlert> findUserAlertByPlatform(String platformId, Map<String,Object> options);
 	public int countUserAlertByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countUserAlertByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserAlert> findUserAlertByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeUserAlertByPlatform(SmartList<UserAlert> resultList, String platformId, Map<String,Object> options);

 
 }


