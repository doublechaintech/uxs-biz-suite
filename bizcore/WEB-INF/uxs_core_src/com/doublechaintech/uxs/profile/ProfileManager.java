
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
	

	//public  UserAlertManager getUserAlertManager(UxsUserContext userContext, String profileId, String message, String location, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addUserAlert(UxsUserContext userContext, String profileId, String message, String location, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeUserAlert(UxsUserContext userContext, String profileId, String userAlertId, int userAlertVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateUserAlert(UxsUserContext userContext, String profileId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

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

	//public  BrandFilterManager getBrandFilterManager(UxsUserContext userContext, String profileId, String name, String internalId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addBrandFilter(UxsUserContext userContext, String profileId, String name, String internalId , String [] tokensExpr)  throws Exception;
	public  Profile removeBrandFilter(UxsUserContext userContext, String profileId, String brandFilterId, int brandFilterVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateBrandFilter(UxsUserContext userContext, String profileId, String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PriceFilterManager getPriceFilterManager(UxsUserContext userContext, String profileId, String name, BigDecimal priceStart, BigDecimal priceEnd ,String [] tokensExpr)  throws Exception;
	
	public  Profile addPriceFilter(UxsUserContext userContext, String profileId, String name, BigDecimal priceStart, BigDecimal priceEnd , String [] tokensExpr)  throws Exception;
	public  Profile removePriceFilter(UxsUserContext userContext, String profileId, String priceFilterId, int priceFilterVersion,String [] tokensExpr)  throws Exception;
	public  Profile updatePriceFilter(UxsUserContext userContext, String profileId, String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CategoryFilterManager getCategoryFilterManager(UxsUserContext userContext, String profileId, String name, String internalId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addCategoryFilter(UxsUserContext userContext, String profileId, String name, String internalId , String [] tokensExpr)  throws Exception;
	public  Profile removeCategoryFilter(UxsUserContext userContext, String profileId, String categoryFilterId, int categoryFilterVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateCategoryFilter(UxsUserContext userContext, String profileId, String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addNewProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeNewProduct(UxsUserContext userContext, String profileId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateNewProduct(UxsUserContext userContext, String profileId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addEditorPickProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeEditorPickProduct(UxsUserContext userContext, String profileId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateEditorPickProduct(UxsUserContext userContext, String profileId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addTopRatedProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeTopRatedProduct(UxsUserContext userContext, String profileId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateTopRatedProduct(UxsUserContext userContext, String profileId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Profile addRecommandProduct(UxsUserContext userContext, String profileId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Profile removeRecommandProduct(UxsUserContext userContext, String profileId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateRecommandProduct(UxsUserContext userContext, String profileId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


