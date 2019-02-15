
package com.doublechaintech.uxs.rating;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface RatingManager{

		

	public Rating createRating(UxsUserContext userContext, String userId, String productId, int score) throws Exception;	
	public Rating updateRating(UxsUserContext userContext,String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Rating loadRating(UxsUserContext userContext, String ratingId, String [] tokensExpr) throws Exception;
	public Rating internalSaveRating(UxsUserContext userContext, Rating rating) throws Exception;
	public Rating internalSaveRating(UxsUserContext userContext, Rating rating,Map<String,Object>option) throws Exception;
	
	public Rating transferToAnotherUser(UxsUserContext userContext, String ratingId, String anotherUserId)  throws Exception;
 	public Rating transferToAnotherProduct(UxsUserContext userContext, String ratingId, String anotherProductId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String ratingId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Rating newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


