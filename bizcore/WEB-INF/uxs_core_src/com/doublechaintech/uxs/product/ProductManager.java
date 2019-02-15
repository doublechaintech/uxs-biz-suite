
package com.doublechaintech.uxs.product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface ProductManager{

		

	public Product createProduct(UxsUserContext userContext, String name, String platformId, BigDecimal avarageScore) throws Exception;	
	public Product updateProduct(UxsUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Product loadProduct(UxsUserContext userContext, String productId, String [] tokensExpr) throws Exception;
	public Product internalSaveProduct(UxsUserContext userContext, Product product) throws Exception;
	public Product internalSaveProduct(UxsUserContext userContext, Product product,Map<String,Object>option) throws Exception;
	
	public Product transferToAnotherPlatform(UxsUserContext userContext, String productId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String productId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Product newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RatingManager getRatingManager(UxsUserContext userContext, String productId, String userId, int score ,String [] tokensExpr)  throws Exception;
	
	public  Product addRating(UxsUserContext userContext, String productId, String userId, int score , String [] tokensExpr)  throws Exception;
	public  Product removeRating(UxsUserContext userContext, String productId, String ratingId, int ratingVersion,String [] tokensExpr)  throws Exception;
	public  Product updateRating(UxsUserContext userContext, String productId, String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ReviewManager getReviewManager(UxsUserContext userContext, String productId, String title, String content, String userId ,String [] tokensExpr)  throws Exception;
	
	public  Product addReview(UxsUserContext userContext, String productId, String title, String content, String userId , String [] tokensExpr)  throws Exception;
	public  Product removeReview(UxsUserContext userContext, String productId, String reviewId, int reviewVersion,String [] tokensExpr)  throws Exception;
	public  Product updateReview(UxsUserContext userContext, String productId, String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  BlogManager getBlogManager(UxsUserContext userContext, String productId, String title, String content, String userId ,String [] tokensExpr)  throws Exception;
	
	public  Product addBlog(UxsUserContext userContext, String productId, String title, String content, String userId , String [] tokensExpr)  throws Exception;
	public  Product removeBlog(UxsUserContext userContext, String productId, String blogId, int blogVersion,String [] tokensExpr)  throws Exception;
	public  Product updateBlog(UxsUserContext userContext, String productId, String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


