package com.doublechaintech.uxs;
import java.text.MessageFormat;
import java.util.Date;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class UxsCheckerManager extends BaseManagerImpl {
	/*
	
	
	public static final String  ID_OF_PLATFORM ="platform.id";
	protected void checkIdOfPlatform(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PLATFORM ="platform.name";
	protected void checkNameOfPlatform(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PLATFORM ="platform.version";
	protected void checkVersionOfPlatform(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SITE ="site.id";
	protected void checkIdOfSite(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SITE ="site.name";
	protected void checkNameOfSite(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  INTRODUCTION_OF_SITE ="site.introduction";
	protected void checkIntroductionOfSite(UxsUserContext userContext, String introduction, List<Message> messageList)
	{
		
	 	checkStringLengthRange(introduction,10, 148,INTRODUCTION_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_SITE ="site.platform";
	protected void checkPlatformIdOfSite(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfSite(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SITE ="site.version";
	protected void checkVersionOfSite(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CATALOG ="catalog.id";
	protected void checkIdOfCatalog(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CATALOG ="catalog.name";
	protected void checkNameOfCatalog(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  SELLER_ID_OF_CATALOG ="catalog.seller_id";
	protected void checkSellerIdOfCatalog(UxsUserContext userContext, String sellerId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(sellerId,3, 32,SELLER_ID_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  SITE_OF_CATALOG ="catalog.site";
	protected void checkSiteIdOfCatalog(UxsUserContext userContext, String siteId, List<Message> messageList)
	{
		
	 	checkIdOfCatalog(userContext,siteId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_CATALOG ="catalog.platform";
	protected void checkPlatformIdOfCatalog(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfCatalog(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CATALOG ="catalog.version";
	protected void checkVersionOfCatalog(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	protected void checkIdOfLevelOneCategory(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	protected void checkCatalogIdOfLevelOneCategory(UxsUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfLevelOneCategory(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.name";
	protected void checkNameOfLevelOneCategory(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	protected void checkVersionOfLevelOneCategory(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	protected void checkIdOfLevelTwoCategory(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	protected void checkParentCategoryIdOfLevelTwoCategory(UxsUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfLevelTwoCategory(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.name";
	protected void checkNameOfLevelTwoCategory(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	protected void checkVersionOfLevelTwoCategory(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_N_CATEGORY ="level_n_category.id";
	protected void checkIdOfLevelNCategory(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_LEVEL_N_CATEGORY ="level_n_category.parent_category";
	protected void checkParentCategoryIdOfLevelNCategory(UxsUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfLevelNCategory(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_N_CATEGORY ="level_n_category.name";
	protected void checkNameOfLevelNCategory(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 44,NAME_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_N_CATEGORY ="level_n_category.version";
	protected void checkVersionOfLevelNCategory(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_BRAND ="brand.id";
	protected void checkIdOfBrand(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  BRAND_NAME_OF_BRAND ="brand.brand_name";
	protected void checkBrandNameOfBrand(UxsUserContext userContext, String brandName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(brandName,3, 40,BRAND_NAME_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  LOGO_OF_BRAND ="brand.logo";
	protected void checkLogoOfBrand(UxsUserContext userContext, String logo, List<Message> messageList)
	{
		
	 	checkImage(logo,0, 512,LOGO_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_BRAND ="brand.remark";
	protected void checkRemarkOfBrand(UxsUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_BRAND ="brand.platform";
	protected void checkPlatformIdOfBrand(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfBrand(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_BRAND ="brand.version";
	protected void checkVersionOfBrand(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PRODUCT ="product.id";
	protected void checkIdOfProduct(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PRODUCT ="product.name";
	protected void checkNameOfProduct(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	protected void checkParentCategoryIdOfProduct(UxsUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_PRODUCT ="product.brand";
	protected void checkBrandIdOfProduct(UxsUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_PRODUCT ="product.product_cover_image";
	protected void checkProductCoverImageOfProduct(UxsUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	protected void checkOriginOfProduct(UxsUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_PRODUCT ="product.catalog";
	protected void checkCatalogIdOfProduct(UxsUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_PRODUCT ="product.remark";
	protected void checkRemarkOfProduct(UxsUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_PRODUCT ="product.platform";
	protected void checkPlatformIdOfProduct(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PRODUCT ="product.version";
	protected void checkVersionOfProduct(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_BANNER ="banner.id";
	protected void checkIdOfBanner(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BANNER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_BANNER ="banner.name";
	protected void checkNameOfBanner(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,8, 116,NAME_OF_BANNER, messageList); 		
		
	}	 			
	
	public static final String  IMAGE_PATH_OF_BANNER ="banner.image_path";
	protected void checkImagePathOfBanner(UxsUserContext userContext, String imagePath, List<Message> messageList)
	{
		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_BANNER, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_BANNER ="banner.platform";
	protected void checkPlatformIdOfBanner(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfBanner(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_BANNER ="banner.version";
	protected void checkVersionOfBanner(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BANNER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PROFILE ="profile.id";
	protected void checkIdOfProfile(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PROFILE ="profile.name";
	protected void checkNameOfProfile(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_PROFILE ="profile.platform";
	protected void checkPlatformIdOfProfile(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfProfile(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PROFILE ="profile.version";
	protected void checkVersionOfProfile(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_ALERT ="user_alert.id";
	protected void checkIdOfUserAlert(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_ALERT, messageList); 		
		
	}	 			
	
	public static final String  MESSAGE_OF_USER_ALERT ="user_alert.message";
	protected void checkMessageOfUserAlert(UxsUserContext userContext, String message, List<Message> messageList)
	{
		
	 	checkStringLengthRange(message,26, 404,MESSAGE_OF_USER_ALERT, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_USER_ALERT ="user_alert.profile";
	protected void checkProfileIdOfUserAlert(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfUserAlert(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_ALERT ="user_alert.location";
	protected void checkLocationOfUserAlert(UxsUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,2, 16,LOCATION_OF_USER_ALERT, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_USER_ALERT ="user_alert.platform";
	protected void checkPlatformIdOfUserAlert(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfUserAlert(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_ALERT ="user_alert.version";
	protected void checkVersionOfUserAlert(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_ALERT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TARGET ="target.id";
	protected void checkIdOfTarget(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TARGET, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TARGET ="target.name";
	protected void checkNameOfTarget(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 56,NAME_OF_TARGET, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_TARGET ="target.profile";
	protected void checkProfileIdOfTarget(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfTarget(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  BANNER_OF_TARGET ="target.banner";
	protected void checkBannerIdOfTarget(UxsUserContext userContext, String bannerId, List<Message> messageList)
	{
		
	 	checkIdOfTarget(userContext,bannerId, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_TARGET ="target.location";
	protected void checkLocationOfTarget(UxsUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,2, 16,LOCATION_OF_TARGET, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TARGET ="target.version";
	protected void checkVersionOfTarget(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TARGET, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RATING ="rating.id";
	protected void checkIdOfRating(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RATING, messageList); 		
		
	}	 			
	
	public static final String  USER_OF_RATING ="rating.user";
	protected void checkUserIdOfRating(UxsUserContext userContext, String userId, List<Message> messageList)
	{
		
	 	checkIdOfRating(userContext,userId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_OF_RATING ="rating.product";
	protected void checkProductIdOfRating(UxsUserContext userContext, String productId, List<Message> messageList)
	{
		
	 	checkIdOfRating(userContext,productId, messageList); 		
		
	}	 			
	
	public static final String  SCORE_OF_RATING ="rating.score";
	protected void checkScoreOfRating(UxsUserContext userContext, int score, List<Message> messageList)
	{
		
	 	checkIntegerRange(score,0, 5,SCORE_OF_RATING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RATING ="rating.version";
	protected void checkVersionOfRating(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RATING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_REVIEW ="review.id";
	protected void checkIdOfReview(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_REVIEW, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_REVIEW ="review.title";
	protected void checkTitleOfReview(UxsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,4, 44,TITLE_OF_REVIEW, messageList); 		
		
	}	 			
	
	public static final String  CONTENT_OF_REVIEW ="review.content";
	protected void checkContentOfReview(UxsUserContext userContext, String content, List<Message> messageList)
	{
		
	 	checkLongtext(content,0, 1048576,CONTENT_OF_REVIEW, messageList); 		
		
	}	 			
	
	public static final String  USER_OF_REVIEW ="review.user";
	protected void checkUserIdOfReview(UxsUserContext userContext, String userId, List<Message> messageList)
	{
		
	 	checkIdOfReview(userContext,userId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_OF_REVIEW ="review.product";
	protected void checkProductIdOfReview(UxsUserContext userContext, String productId, List<Message> messageList)
	{
		
	 	checkIdOfReview(userContext,productId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_REVIEW ="review.version";
	protected void checkVersionOfReview(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_REVIEW, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_BLOG ="blog.id";
	protected void checkIdOfBlog(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BLOG, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_BLOG ="blog.title";
	protected void checkTitleOfBlog(UxsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,5, 64,TITLE_OF_BLOG, messageList); 		
		
	}	 			
	
	public static final String  CONTENT_OF_BLOG ="blog.content";
	protected void checkContentOfBlog(UxsUserContext userContext, String content, List<Message> messageList)
	{
		
	 	checkLongtext(content,0, 1048576,CONTENT_OF_BLOG, messageList); 		
		
	}	 			
	
	public static final String  USER_OF_BLOG ="blog.user";
	protected void checkUserIdOfBlog(UxsUserContext userContext, String userId, List<Message> messageList)
	{
		
	 	checkIdOfBlog(userContext,userId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_OF_BLOG ="blog.product";
	protected void checkProductIdOfBlog(UxsUserContext userContext, String productId, List<Message> messageList)
	{
		
	 	checkIdOfBlog(userContext,productId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_BLOG ="blog.version";
	protected void checkVersionOfBlog(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BLOG, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_BRAND_FILTER ="brand_filter.id";
	protected void checkIdOfBrandFilter(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BRAND_FILTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_BRAND_FILTER ="brand_filter.name";
	protected void checkNameOfBrandFilter(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_BRAND_FILTER, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_ID_OF_BRAND_FILTER ="brand_filter.internal_id";
	protected void checkInternalIdOfBrandFilter(UxsUserContext userContext, String internalId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalId,2, 28,INTERNAL_ID_OF_BRAND_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_BRAND_FILTER ="brand_filter.profile";
	protected void checkProfileIdOfBrandFilter(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfBrandFilter(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_BRAND_FILTER ="brand_filter.version";
	protected void checkVersionOfBrandFilter(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BRAND_FILTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PRICE_FILTER ="price_filter.id";
	protected void checkIdOfPriceFilter(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PRICE_FILTER ="price_filter.name";
	protected void checkNameOfPriceFilter(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PRICE_START_OF_PRICE_FILTER ="price_filter.price_start";
	protected void checkPriceStartOfPriceFilter(UxsUserContext userContext, BigDecimal priceStart, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(priceStart,0, 1.99,PRICE_START_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PRICE_END_OF_PRICE_FILTER ="price_filter.price_end";
	protected void checkPriceEndOfPriceFilter(UxsUserContext userContext, BigDecimal priceEnd, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(priceEnd,0, 1000000.99,PRICE_END_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_PRICE_FILTER ="price_filter.profile";
	protected void checkProfileIdOfPriceFilter(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfPriceFilter(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PRICE_FILTER ="price_filter.version";
	protected void checkVersionOfPriceFilter(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRICE_FILTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CATEGORY_FILTER ="category_filter.id";
	protected void checkIdOfCategoryFilter(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATEGORY_FILTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CATEGORY_FILTER ="category_filter.name";
	protected void checkNameOfCategoryFilter(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_CATEGORY_FILTER, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_ID_OF_CATEGORY_FILTER ="category_filter.internal_id";
	protected void checkInternalIdOfCategoryFilter(UxsUserContext userContext, String internalId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalId,3, 32,INTERNAL_ID_OF_CATEGORY_FILTER, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_CATEGORY_FILTER ="category_filter.profile";
	protected void checkProfileIdOfCategoryFilter(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfCategoryFilter(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CATEGORY_FILTER ="category_filter.version";
	protected void checkVersionOfCategoryFilter(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATEGORY_FILTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_NEW_PRODUCT ="new_product.id";
	protected void checkIdOfNewProduct(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_NEW_PRODUCT ="new_product.name";
	protected void checkNameOfNewProduct(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_NEW_PRODUCT ="new_product.parent_category";
	protected void checkParentCategoryIdOfNewProduct(UxsUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_NEW_PRODUCT ="new_product.brand";
	protected void checkBrandIdOfNewProduct(UxsUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_NEW_PRODUCT ="new_product.product_cover_image";
	protected void checkProductCoverImageOfNewProduct(UxsUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_NEW_PRODUCT ="new_product.origin";
	protected void checkOriginOfNewProduct(UxsUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_NEW_PRODUCT ="new_product.catalog";
	protected void checkCatalogIdOfNewProduct(UxsUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_NEW_PRODUCT ="new_product.profile";
	protected void checkProfileIdOfNewProduct(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_NEW_PRODUCT ="new_product.remark";
	protected void checkRemarkOfNewProduct(UxsUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_NEW_PRODUCT ="new_product.platform";
	protected void checkPlatformIdOfNewProduct(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfNewProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_NEW_PRODUCT ="new_product.version";
	protected void checkVersionOfNewProduct(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_NEW_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.id";
	protected void checkIdOfEditorPickProduct(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.name";
	protected void checkNameOfEditorPickProduct(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.parent_category";
	protected void checkParentCategoryIdOfEditorPickProduct(UxsUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.brand";
	protected void checkBrandIdOfEditorPickProduct(UxsUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.product_cover_image";
	protected void checkProductCoverImageOfEditorPickProduct(UxsUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.origin";
	protected void checkOriginOfEditorPickProduct(UxsUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.catalog";
	protected void checkCatalogIdOfEditorPickProduct(UxsUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.profile";
	protected void checkProfileIdOfEditorPickProduct(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.remark";
	protected void checkRemarkOfEditorPickProduct(UxsUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.platform";
	protected void checkPlatformIdOfEditorPickProduct(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfEditorPickProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.version";
	protected void checkVersionOfEditorPickProduct(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EDITOR_PICK_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TOP_RATED_PRODUCT ="top_rated_product.id";
	protected void checkIdOfTopRatedProduct(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TOP_RATED_PRODUCT ="top_rated_product.name";
	protected void checkNameOfTopRatedProduct(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_TOP_RATED_PRODUCT ="top_rated_product.parent_category";
	protected void checkParentCategoryIdOfTopRatedProduct(UxsUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_TOP_RATED_PRODUCT ="top_rated_product.brand";
	protected void checkBrandIdOfTopRatedProduct(UxsUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_TOP_RATED_PRODUCT ="top_rated_product.product_cover_image";
	protected void checkProductCoverImageOfTopRatedProduct(UxsUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_TOP_RATED_PRODUCT ="top_rated_product.origin";
	protected void checkOriginOfTopRatedProduct(UxsUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_TOP_RATED_PRODUCT ="top_rated_product.catalog";
	protected void checkCatalogIdOfTopRatedProduct(UxsUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_TOP_RATED_PRODUCT ="top_rated_product.remark";
	protected void checkRemarkOfTopRatedProduct(UxsUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_TOP_RATED_PRODUCT ="top_rated_product.profile";
	protected void checkProfileIdOfTopRatedProduct(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_TOP_RATED_PRODUCT ="top_rated_product.platform";
	protected void checkPlatformIdOfTopRatedProduct(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfTopRatedProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TOP_RATED_PRODUCT ="top_rated_product.version";
	protected void checkVersionOfTopRatedProduct(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TOP_RATED_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RECOMMAND_PRODUCT ="recommand_product.id";
	protected void checkIdOfRecommandProduct(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RECOMMAND_PRODUCT ="recommand_product.name";
	protected void checkNameOfRecommandProduct(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_RECOMMAND_PRODUCT ="recommand_product.parent_category";
	protected void checkParentCategoryIdOfRecommandProduct(UxsUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_RECOMMAND_PRODUCT ="recommand_product.brand";
	protected void checkBrandIdOfRecommandProduct(UxsUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_COVER_IMAGE_OF_RECOMMAND_PRODUCT ="recommand_product.product_cover_image";
	protected void checkProductCoverImageOfRecommandProduct(UxsUserContext userContext, String productCoverImage, List<Message> messageList)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_RECOMMAND_PRODUCT ="recommand_product.origin";
	protected void checkOriginOfRecommandProduct(UxsUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_RECOMMAND_PRODUCT ="recommand_product.catalog";
	protected void checkCatalogIdOfRecommandProduct(UxsUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_RECOMMAND_PRODUCT ="recommand_product.remark";
	protected void checkRemarkOfRecommandProduct(UxsUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PROFILE_OF_RECOMMAND_PRODUCT ="recommand_product.profile";
	protected void checkProfileIdOfRecommandProduct(UxsUserContext userContext, String profileId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,profileId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_RECOMMAND_PRODUCT ="recommand_product.platform";
	protected void checkPlatformIdOfRecommandProduct(UxsUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfRecommandProduct(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RECOMMAND_PRODUCT ="recommand_product.version";
	protected void checkVersionOfRecommandProduct(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RECOMMAND_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	protected void checkIdOfUserDomain(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	protected void checkNameOfUserDomain(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	protected void checkVersionOfUserDomain(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	protected void checkIdOfUserWhiteList(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	protected void checkUserIdentityOfUserWhiteList(UxsUserContext userContext, String userIdentity, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	protected void checkUserSpecialFunctionsOfUserWhiteList(UxsUserContext userContext, String userSpecialFunctions, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	protected void checkDomainIdOfUserWhiteList(UxsUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfUserWhiteList(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	protected void checkVersionOfUserWhiteList(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	protected void checkIdOfSecUser(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	protected void checkLoginOfSecUser(UxsUserContext userContext, String login, List<Message> messageList)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	protected void checkMobileOfSecUser(UxsUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	protected void checkEmailOfSecUser(UxsUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	protected void checkPwdOfSecUser(UxsUserContext userContext, String pwd, List<Message> messageList)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	protected void checkVerificationCodeOfSecUser(UxsUserContext userContext, int verificationCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	protected void checkVerificationCodeExpireOfSecUser(UxsUserContext userContext, DateTime verificationCodeExpire, List<Message> messageList)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	protected void checkLastLoginTimeOfSecUser(UxsUserContext userContext, DateTime lastLoginTime, List<Message> messageList)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	protected void checkDomainIdOfSecUser(UxsUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfSecUser(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	protected void checkVersionOfSecUser(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	protected void checkIdOfSecUserBlocking(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	protected void checkWhoOfSecUserBlocking(UxsUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	protected void checkCommentsOfSecUserBlocking(UxsUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	protected void checkVersionOfSecUserBlocking(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_APP ="user_app.id";
	protected void checkIdOfUserApp(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	protected void checkTitleOfUserApp(UxsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	protected void checkSecUserIdOfUserApp(UxsUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfUserApp(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	protected void checkAppIconOfUserApp(UxsUserContext userContext, String appIcon, List<Message> messageList)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	protected void checkFullAccessOfUserApp(UxsUserContext userContext, boolean fullAccess, List<Message> messageList)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	protected void checkPermissionOfUserApp(UxsUserContext userContext, String permission, List<Message> messageList)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	protected void checkObjectTypeOfUserApp(UxsUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	protected void checkObjectIdOfUserApp(UxsUserContext userContext, String objectId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	protected void checkLocationOfUserApp(UxsUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	protected void checkVersionOfUserApp(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	protected void checkIdOfListAccess(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	protected void checkNameOfListAccess(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	protected void checkInternalNameOfListAccess(UxsUserContext userContext, String internalName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	protected void checkReadPermissionOfListAccess(UxsUserContext userContext, boolean readPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	protected void checkCreatePermissionOfListAccess(UxsUserContext userContext, boolean createPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	protected void checkDeletePermissionOfListAccess(UxsUserContext userContext, boolean deletePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	protected void checkUpdatePermissionOfListAccess(UxsUserContext userContext, boolean updatePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	protected void checkExecutionPermissionOfListAccess(UxsUserContext userContext, boolean executionPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	protected void checkAppIdOfListAccess(UxsUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfListAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	protected void checkVersionOfListAccess(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	protected void checkIdOfObjectAccess(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	protected void checkNameOfObjectAccess(UxsUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	protected void checkObjectTypeOfObjectAccess(UxsUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	protected void checkList1OfObjectAccess(UxsUserContext userContext, String list1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	protected void checkList2OfObjectAccess(UxsUserContext userContext, String list2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	protected void checkList3OfObjectAccess(UxsUserContext userContext, String list3, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	protected void checkList4OfObjectAccess(UxsUserContext userContext, String list4, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	protected void checkList5OfObjectAccess(UxsUserContext userContext, String list5, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	protected void checkList6OfObjectAccess(UxsUserContext userContext, String list6, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	protected void checkList7OfObjectAccess(UxsUserContext userContext, String list7, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	protected void checkList8OfObjectAccess(UxsUserContext userContext, String list8, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	protected void checkList9OfObjectAccess(UxsUserContext userContext, String list9, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	protected void checkAppIdOfObjectAccess(UxsUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfObjectAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	protected void checkVersionOfObjectAccess(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	protected void checkIdOfLoginHistory(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	protected void checkFromIpOfLoginHistory(UxsUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	protected void checkDescriptionOfLoginHistory(UxsUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	protected void checkSecUserIdOfLoginHistory(UxsUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfLoginHistory(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	protected void checkVersionOfLoginHistory(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	protected void checkIdOfGenericForm(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	protected void checkTitleOfGenericForm(UxsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	protected void checkDescriptionOfGenericForm(UxsUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	protected void checkVersionOfGenericForm(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	protected void checkIdOfFormMessage(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	protected void checkTitleOfFormMessage(UxsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	protected void checkFormIdOfFormMessage(UxsUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	protected void checkLevelOfFormMessage(UxsUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	protected void checkVersionOfFormMessage(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	protected void checkIdOfFormFieldMessage(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	protected void checkTitleOfFormFieldMessage(UxsUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	protected void checkParameterNameOfFormFieldMessage(UxsUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	protected void checkFormIdOfFormFieldMessage(UxsUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormFieldMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	protected void checkLevelOfFormFieldMessage(UxsUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	protected void checkVersionOfFormFieldMessage(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	protected void checkIdOfFormField(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	protected void checkLabelOfFormField(UxsUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	protected void checkLocaleKeyOfFormField(UxsUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	protected void checkParameterNameOfFormField(UxsUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	protected void checkTypeOfFormField(UxsUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	protected void checkFormIdOfFormField(UxsUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormField(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	protected void checkPlaceholderOfFormField(UxsUserContext userContext, String placeholder, List<Message> messageList)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	protected void checkDefaultValueOfFormField(UxsUserContext userContext, String defaultValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	protected void checkDescriptionOfFormField(UxsUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	protected void checkFieldGroupOfFormField(UxsUserContext userContext, String fieldGroup, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	protected void checkMinimumValueOfFormField(UxsUserContext userContext, String minimumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	protected void checkMaximumValueOfFormField(UxsUserContext userContext, String maximumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	protected void checkRequiredOfFormField(UxsUserContext userContext, boolean required, List<Message> messageList)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	protected void checkDisabledOfFormField(UxsUserContext userContext, boolean disabled, List<Message> messageList)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	protected void checkCustomRenderingOfFormField(UxsUserContext userContext, boolean customRendering, List<Message> messageList)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	protected void checkCandidateValuesOfFormField(UxsUserContext userContext, String candidateValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	protected void checkSuggestValuesOfFormField(UxsUserContext userContext, String suggestValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	protected void checkVersionOfFormField(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	protected void checkIdOfFormAction(UxsUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	protected void checkLabelOfFormAction(UxsUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	protected void checkLocaleKeyOfFormAction(UxsUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	protected void checkActionKeyOfFormAction(UxsUserContext userContext, String actionKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	protected void checkLevelOfFormAction(UxsUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	protected void checkUrlOfFormAction(UxsUserContext userContext, String url, List<Message> messageList)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	protected void checkFormIdOfFormAction(UxsUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormAction(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	protected void checkVersionOfFormAction(UxsUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION, messageList); 		
		
	}	 			public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof UxsUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return accessOK();
		}
		UxsUserContext userContext = (UxsUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return accessOK();
		}
		return super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(UxsUserContext userContext, List<Message> messageList, Class<? extends UxsException> exceptionClazz) throws Exception{
		//translate messages;
		if(messageList.isEmpty()){
			return;
		}
		
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

	}
	*/

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, UxsException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}











