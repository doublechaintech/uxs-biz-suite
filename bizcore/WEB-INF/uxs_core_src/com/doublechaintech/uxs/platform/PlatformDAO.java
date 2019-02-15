
package com.doublechaintech.uxs.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.banner.BannerDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductDAO getProductDAO();
		
	public BannerDAO getBannerDAO();
		
	public ProfileDAO getProfileDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForBanner(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForProfile(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveProductList(Platform platform, String productIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveBannerList(Platform platform, String bannerIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


