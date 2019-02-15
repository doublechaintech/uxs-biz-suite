
package com.doublechaintech.uxs.profile;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface ProfileManager{

		

	public Profile createProfile(UxsUserContext userContext, String name, String platformId) throws Exception;	
	public Profile updateProfile(UxsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Profile loadProfile(UxsUserContext userContext, String profileId, String [] tokensExpr) throws Exception;
	public Profile internalSaveProfile(UxsUserContext userContext, Profile profile) throws Exception;
	public Profile internalSaveProfile(UxsUserContext userContext, Profile profile,Map<String,Object>option) throws Exception;
	
	public Profile transferToAnotherPlatform(UxsUserContext userContext, String profileId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String profileId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Profile newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TargetManager getTargetManager(UxsUserContext userContext, String profileId, String name, String bannerId, String location ,String [] tokensExpr)  throws Exception;
	
	public  Profile addTarget(UxsUserContext userContext, String profileId, String name, String bannerId, String location , String [] tokensExpr)  throws Exception;
	public  Profile removeTarget(UxsUserContext userContext, String profileId, String targetId, int targetVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateTarget(UxsUserContext userContext, String profileId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RatingManager getRatingManager(UxsUserContext userContext, String profileId, String productId, int score ,String [] tokensExpr)  throws Exception;
	
	public  Profile addRating(UxsUserContext userContext, String profileId, String productId, int score , String [] tokensExpr)  throws Exception;
	public  Profile removeRating(UxsUserContext userContext, String profileId, String ratingId, int ratingVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateRating(UxsUserContext userContext, String profileId, String ratingId, int ratingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ReviewManager getReviewManager(UxsUserContext userContext, String profileId, String title, String content, String productId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addReview(UxsUserContext userContext, String profileId, String title, String content, String productId , String [] tokensExpr)  throws Exception;
	public  Profile removeReview(UxsUserContext userContext, String profileId, String reviewId, int reviewVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateReview(UxsUserContext userContext, String profileId, String reviewId, int reviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  BlogManager getBlogManager(UxsUserContext userContext, String profileId, String title, String content, String productId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addBlog(UxsUserContext userContext, String profileId, String title, String content, String productId , String [] tokensExpr)  throws Exception;
	public  Profile removeBlog(UxsUserContext userContext, String profileId, String blogId, int blogVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateBlog(UxsUserContext userContext, String profileId, String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


