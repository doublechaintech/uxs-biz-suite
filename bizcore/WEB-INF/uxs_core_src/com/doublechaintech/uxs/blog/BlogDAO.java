
package com.doublechaintech.uxs.blog;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;


public interface BlogDAO{

	
	public Blog load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Blog> blogList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Blog present(Blog blog,Map<String,Object> options) throws Exception;
	public Blog clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Blog save(Blog blog,Map<String,Object> options);
	public SmartList<Blog> saveBlogList(SmartList<Blog> blogList,Map<String,Object> options);
	public SmartList<Blog> removeBlogList(SmartList<Blog> blogList,Map<String,Object> options);
	public SmartList<Blog> findBlogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countBlogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countBlogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String blogId, int version) throws Exception;
	public Blog disconnectFromAll(String blogId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Blog> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Blog> findBlogByUser(String profileId, Map<String,Object> options);
 	public int countBlogByUser(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countBlogByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<Blog> findBlogByUser(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeBlogByUser(SmartList<Blog> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<Blog> findBlogByProduct(String productId, Map<String,Object> options);
 	public int countBlogByProduct(String productId, Map<String,Object> options);
 	public Map<String, Integer> countBlogByProductIds(String[] ids, Map<String,Object> options);
 	public SmartList<Blog> findBlogByProduct(String productId, int start, int count, Map<String,Object> options);
 	public void analyzeBlogByProduct(SmartList<Blog> resultList, String productId, Map<String,Object> options);

 
 }


