
package com.doublechaintech.uxs.banner;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.target.TargetDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;


public interface BannerDAO{

	
	public Banner load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Banner> bannerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Banner present(Banner banner,Map<String,Object> options) throws Exception;
	public Banner clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Banner save(Banner banner,Map<String,Object> options);
	public SmartList<Banner> saveBannerList(SmartList<Banner> bannerList,Map<String,Object> options);
	public SmartList<Banner> removeBannerList(SmartList<Banner> bannerList,Map<String,Object> options);
	public SmartList<Banner> findBannerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countBannerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countBannerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String bannerId, int version) throws Exception;
	public Banner disconnectFromAll(String bannerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TargetDAO getTargetDAO();
		
	
 	public SmartList<Banner> requestCandidateBannerForTarget(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Banner planToRemoveTargetList(Banner banner, String targetIds[], Map<String,Object> options)throws Exception;


	//disconnect Banner with profile in Target
	public Banner planToRemoveTargetListWithProfile(Banner banner, String profileId, Map<String,Object> options)throws Exception;
	public int countTargetListWithProfile(String bannerId, String profileId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Banner> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Banner> findBannerByPlatform(String platformId, Map<String,Object> options);
 	public int countBannerByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countBannerByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Banner> findBannerByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeBannerByPlatform(SmartList<Banner> resultList, String platformId, Map<String,Object> options);

 
 }


