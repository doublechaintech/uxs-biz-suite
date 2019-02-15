
package com.doublechaintech.uxs.rating;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;


public interface RatingDAO{

	
	public Rating load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Rating> ratingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Rating present(Rating rating,Map<String,Object> options) throws Exception;
	public Rating clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Rating save(Rating rating,Map<String,Object> options);
	public SmartList<Rating> saveRatingList(SmartList<Rating> ratingList,Map<String,Object> options);
	public SmartList<Rating> removeRatingList(SmartList<Rating> ratingList,Map<String,Object> options);
	public SmartList<Rating> findRatingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRatingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRatingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String ratingId, int version) throws Exception;
	public Rating disconnectFromAll(String ratingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Rating> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Rating> findRatingByUser(String profileId, Map<String,Object> options);
 	public int countRatingByUser(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countRatingByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<Rating> findRatingByUser(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeRatingByUser(SmartList<Rating> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<Rating> findRatingByProduct(String productId, Map<String,Object> options);
 	public int countRatingByProduct(String productId, Map<String,Object> options);
 	public Map<String, Integer> countRatingByProductIds(String[] ids, Map<String,Object> options);
 	public SmartList<Rating> findRatingByProduct(String productId, int start, int count, Map<String,Object> options);
 	public void analyzeRatingByProduct(SmartList<Rating> resultList, String productId, Map<String,Object> options);

 
 }


