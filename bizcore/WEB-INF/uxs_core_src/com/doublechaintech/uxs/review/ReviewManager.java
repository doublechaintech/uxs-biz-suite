
package com.doublechaintech.uxs.review;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface ReviewManager{

		

	public Review createReview(UxsUserContext userContext, String title, String content, String userId, String productId) throws Exception;	
	public Review updateReview(UxsUserContext userContext,String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Review loadReview(UxsUserContext userContext, String reviewId, String [] tokensExpr) throws Exception;
	public Review internalSaveReview(UxsUserContext userContext, Review review) throws Exception;
	public Review internalSaveReview(UxsUserContext userContext, Review review,Map<String,Object>option) throws Exception;
	
	public Review transferToAnotherUser(UxsUserContext userContext, String reviewId, String anotherUserId)  throws Exception;
 	public Review transferToAnotherProduct(UxsUserContext userContext, String reviewId, String anotherProductId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String reviewId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Review newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


