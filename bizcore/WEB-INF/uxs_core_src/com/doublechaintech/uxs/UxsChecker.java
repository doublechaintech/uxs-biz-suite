package com.doublechaintech.uxs;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class UxsChecker extends BaseChecker{
	
	
	protected UxsUserContext userContext;
	public UxsUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(UxsUserContext userContext) {
		this.userContext = userContext;
	}
	
	public UxsChecker() {
		this.messageList = new ArrayList<Message>();
	}

	

	public static final String  ID_OF_PLATFORM ="platform.id";
	public UxsChecker checkIdOfPlatform(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PLATFORM ="platform.name";
	public UxsChecker checkNameOfPlatform(String name)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PLATFORM ="platform.version";
	public UxsChecker checkVersionOfPlatform(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SITE ="site.id";
	public UxsChecker checkIdOfSite(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SITE ="site.name";
	public UxsChecker checkNameOfSite(String name)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  INTRODUCTION_OF_SITE ="site.introduction";
	public UxsChecker checkIntroductionOfSite(String introduction)
	{
		
	 	checkStringLengthRange(introduction,10, 148,INTRODUCTION_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_SITE ="site.platform";
	public UxsChecker checkPlatformIdOfSite(String platformId)
	{
		
	 	checkIdOfSite(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SITE ="site.version";
	public UxsChecker checkVersionOfSite(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CATALOG ="catalog.id";
	public UxsChecker checkIdOfCatalog(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_CATALOG ="catalog.name";
	public UxsChecker checkNameOfCatalog(String name)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  SELLER_ID_OF_CATALOG ="catalog.seller_id";
	public UxsChecker checkSellerIdOfCatalog(String sellerId)
	{
		
	 	checkStringLengthRange(sellerId,3, 32,SELLER_ID_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  SITE_OF_CATALOG ="catalog.site";
	public UxsChecker checkSiteIdOfCatalog(String siteId)
	{
		
	 	checkIdOfCatalog(siteId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_CATALOG ="catalog.platform";
	public UxsChecker checkPlatformIdOfCatalog(String platformId)
	{
		
	 	checkIdOfCatalog(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CATALOG ="catalog.version";
	public UxsChecker checkVersionOfCatalog(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	public UxsChecker checkIdOfLevelOneCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	public UxsChecker checkCatalogIdOfLevelOneCategory(String catalogId)
	{
		
	 	checkIdOfLevelOneCategory(catalogId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.name";
	public UxsChecker checkNameOfLevelOneCategory(String name)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	public UxsChecker checkVersionOfLevelOneCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	public UxsChecker checkIdOfLevelTwoCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	public UxsChecker checkParentCategoryIdOfLevelTwoCategory(String parentCategoryId)
	{
		
	 	checkIdOfLevelTwoCategory(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.name";
	public UxsChecker checkNameOfLevelTwoCategory(String name)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	public UxsChecker checkVersionOfLevelTwoCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_N_CATEGORY ="level_n_category.id";
	public UxsChecker checkIdOfLevelNCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_N_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_LEVEL_N_CATEGORY ="level_n_category.parent_category";
	public UxsChecker checkParentCategoryIdOfLevelNCategory(String parentCategoryId)
	{
		
	 	checkIdOfLevelNCategory(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_N_CATEGORY ="level_n_category.name";
	public UxsChecker checkNameOfLevelNCategory(String name)
	{
		
	 	checkStringLengthRange(name,3, 44,NAME_OF_LEVEL_N_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_N_CATEGORY ="level_n_category.version";
	public UxsChecker checkVersionOfLevelNCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_N_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_BRAND ="brand.id";
	public UxsChecker checkIdOfBrand(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  BRAND_NAME_OF_BRAND ="brand.brand_name";
	public UxsChecker checkBrandNameOfBrand(String brandName)
	{
		
	 	checkStringLengthRange(brandName,3, 40,BRAND_NAME_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  LOGO_OF_BRAND ="brand.logo";
	public UxsChecker checkLogoOfBrand(String logo)
	{
		
	 	checkImage(logo,0, 512,LOGO_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_BRAND ="brand.remark";
	public UxsChecker checkRemarkOfBrand(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_BRAND ="brand.platform";
	public UxsChecker checkPlatformIdOfBrand(String platformId)
	{
		
	 	checkIdOfBrand(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_BRAND ="brand.version";
	public UxsChecker checkVersionOfBrand(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PRODUCT ="product.id";
	public UxsChecker checkIdOfProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PRODUCT ="product.name";
	public UxsChecker checkNameOfProduct(String name)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	public UxsChecker checkParentCategoryIdOfProduct(String parentCategoryId)
	{
		
	 	checkIdOfProduct(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  BRAND_OF_PRODUCT ="product.brand";
	public UxsChecker checkBrandIdOfProduct(String brandId)
	{
		
	 	checkIdOfProduct(brandId ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_COVER_IMAGE_OF_PRODUCT ="product.product_cover_image";
	public UxsChecker checkProductCoverImageOfProduct(String productCoverImage)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	public UxsChecker checkOriginOfProduct(String origin)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_PRODUCT ="product.catalog";
	public UxsChecker checkCatalogIdOfProduct(String catalogId)
	{
		
	 	checkIdOfProduct(catalogId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_PRODUCT ="product.remark";
	public UxsChecker checkRemarkOfProduct(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_PRODUCT ="product.platform";
	public UxsChecker checkPlatformIdOfProduct(String platformId)
	{
		
	 	checkIdOfProduct(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PRODUCT ="product.version";
	public UxsChecker checkVersionOfProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_BANNER ="banner.id";
	public UxsChecker checkIdOfBanner(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BANNER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_BANNER ="banner.name";
	public UxsChecker checkNameOfBanner(String name)
	{
		
	 	checkStringLengthRange(name,8, 116,NAME_OF_BANNER ); 		
		
		return this;
	}	 			

	public static final String  IMAGE_PATH_OF_BANNER ="banner.image_path";
	public UxsChecker checkImagePathOfBanner(String imagePath)
	{
		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_BANNER ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_BANNER ="banner.platform";
	public UxsChecker checkPlatformIdOfBanner(String platformId)
	{
		
	 	checkIdOfBanner(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_BANNER ="banner.version";
	public UxsChecker checkVersionOfBanner(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BANNER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PROFILE ="profile.id";
	public UxsChecker checkIdOfProfile(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PROFILE ="profile.name";
	public UxsChecker checkNameOfProfile(String name)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_PROFILE ="profile.platform";
	public UxsChecker checkPlatformIdOfProfile(String platformId)
	{
		
	 	checkIdOfProfile(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PROFILE ="profile.version";
	public UxsChecker checkVersionOfProfile(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_ALERT ="user_alert.id";
	public UxsChecker checkIdOfUserAlert(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_ALERT ); 		
		
		return this;
	}	 			

	public static final String  MESSAGE_OF_USER_ALERT ="user_alert.message";
	public UxsChecker checkMessageOfUserAlert(String message)
	{
		
	 	checkStringLengthRange(message,26, 404,MESSAGE_OF_USER_ALERT ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_USER_ALERT ="user_alert.profile";
	public UxsChecker checkProfileIdOfUserAlert(String profileId)
	{
		
	 	checkIdOfUserAlert(profileId ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_USER_ALERT ="user_alert.location";
	public UxsChecker checkLocationOfUserAlert(String location)
	{
		
	 	checkStringLengthRange(location,2, 16,LOCATION_OF_USER_ALERT ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_USER_ALERT ="user_alert.platform";
	public UxsChecker checkPlatformIdOfUserAlert(String platformId)
	{
		
	 	checkIdOfUserAlert(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_ALERT ="user_alert.version";
	public UxsChecker checkVersionOfUserAlert(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_ALERT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TARGET ="target.id";
	public UxsChecker checkIdOfTarget(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TARGET ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TARGET ="target.name";
	public UxsChecker checkNameOfTarget(String name)
	{
		
	 	checkStringLengthRange(name,4, 56,NAME_OF_TARGET ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_TARGET ="target.profile";
	public UxsChecker checkProfileIdOfTarget(String profileId)
	{
		
	 	checkIdOfTarget(profileId ); 		
		
		return this;
	}	 			

	public static final String  BANNER_OF_TARGET ="target.banner";
	public UxsChecker checkBannerIdOfTarget(String bannerId)
	{
		
	 	checkIdOfTarget(bannerId ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_TARGET ="target.location";
	public UxsChecker checkLocationOfTarget(String location)
	{
		
	 	checkStringLengthRange(location,2, 16,LOCATION_OF_TARGET ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TARGET ="target.version";
	public UxsChecker checkVersionOfTarget(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TARGET ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RATING ="rating.id";
	public UxsChecker checkIdOfRating(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RATING ); 		
		
		return this;
	}	 			

	public static final String  USER_OF_RATING ="rating.user";
	public UxsChecker checkUserIdOfRating(String userId)
	{
		
	 	checkIdOfRating(userId ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_OF_RATING ="rating.product";
	public UxsChecker checkProductIdOfRating(String productId)
	{
		
	 	checkIdOfRating(productId ); 		
		
		return this;
	}	 			

	public static final String  SCORE_OF_RATING ="rating.score";
	public UxsChecker checkScoreOfRating(int score)
	{
		
	 	checkIntegerRange(score,0, 5,SCORE_OF_RATING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RATING ="rating.version";
	public UxsChecker checkVersionOfRating(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RATING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_REVIEW ="review.id";
	public UxsChecker checkIdOfReview(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_REVIEW ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_REVIEW ="review.title";
	public UxsChecker checkTitleOfReview(String title)
	{
		
	 	checkStringLengthRange(title,4, 44,TITLE_OF_REVIEW ); 		
		
		return this;
	}	 			

	public static final String  CONTENT_OF_REVIEW ="review.content";
	public UxsChecker checkContentOfReview(String content)
	{
		
	 	checkLongtext(content,0, 1048576,CONTENT_OF_REVIEW ); 		
		
		return this;
	}	 			

	public static final String  USER_OF_REVIEW ="review.user";
	public UxsChecker checkUserIdOfReview(String userId)
	{
		
	 	checkIdOfReview(userId ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_OF_REVIEW ="review.product";
	public UxsChecker checkProductIdOfReview(String productId)
	{
		
	 	checkIdOfReview(productId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_REVIEW ="review.version";
	public UxsChecker checkVersionOfReview(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_REVIEW ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_BLOG ="blog.id";
	public UxsChecker checkIdOfBlog(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BLOG ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_BLOG ="blog.title";
	public UxsChecker checkTitleOfBlog(String title)
	{
		
	 	checkStringLengthRange(title,5, 64,TITLE_OF_BLOG ); 		
		
		return this;
	}	 			

	public static final String  CONTENT_OF_BLOG ="blog.content";
	public UxsChecker checkContentOfBlog(String content)
	{
		
	 	checkLongtext(content,0, 1048576,CONTENT_OF_BLOG ); 		
		
		return this;
	}	 			

	public static final String  USER_OF_BLOG ="blog.user";
	public UxsChecker checkUserIdOfBlog(String userId)
	{
		
	 	checkIdOfBlog(userId ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_OF_BLOG ="blog.product";
	public UxsChecker checkProductIdOfBlog(String productId)
	{
		
	 	checkIdOfBlog(productId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_BLOG ="blog.version";
	public UxsChecker checkVersionOfBlog(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BLOG ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_BRAND_FILTER ="brand_filter.id";
	public UxsChecker checkIdOfBrandFilter(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BRAND_FILTER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_BRAND_FILTER ="brand_filter.name";
	public UxsChecker checkNameOfBrandFilter(String name)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_BRAND_FILTER ); 		
		
		return this;
	}	 			

	public static final String  INTERNAL_ID_OF_BRAND_FILTER ="brand_filter.internal_id";
	public UxsChecker checkInternalIdOfBrandFilter(String internalId)
	{
		
	 	checkStringLengthRange(internalId,2, 28,INTERNAL_ID_OF_BRAND_FILTER ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_BRAND_FILTER ="brand_filter.profile";
	public UxsChecker checkProfileIdOfBrandFilter(String profileId)
	{
		
	 	checkIdOfBrandFilter(profileId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_BRAND_FILTER ="brand_filter.version";
	public UxsChecker checkVersionOfBrandFilter(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BRAND_FILTER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PRICE_FILTER ="price_filter.id";
	public UxsChecker checkIdOfPriceFilter(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRICE_FILTER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PRICE_FILTER ="price_filter.name";
	public UxsChecker checkNameOfPriceFilter(String name)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PRICE_FILTER ); 		
		
		return this;
	}	 			

	public static final String  PRICE_START_OF_PRICE_FILTER ="price_filter.price_start";
	public UxsChecker checkPriceStartOfPriceFilter(BigDecimal priceStart)
	{
		
	 	checkBigDecimalRange(priceStart,0, 1.99,PRICE_START_OF_PRICE_FILTER ); 		
		
		return this;
	}	 			

	public static final String  PRICE_END_OF_PRICE_FILTER ="price_filter.price_end";
	public UxsChecker checkPriceEndOfPriceFilter(BigDecimal priceEnd)
	{
		
	 	checkBigDecimalRange(priceEnd,0, 1000000.99,PRICE_END_OF_PRICE_FILTER ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_PRICE_FILTER ="price_filter.profile";
	public UxsChecker checkProfileIdOfPriceFilter(String profileId)
	{
		
	 	checkIdOfPriceFilter(profileId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PRICE_FILTER ="price_filter.version";
	public UxsChecker checkVersionOfPriceFilter(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRICE_FILTER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CATEGORY_FILTER ="category_filter.id";
	public UxsChecker checkIdOfCategoryFilter(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATEGORY_FILTER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_CATEGORY_FILTER ="category_filter.name";
	public UxsChecker checkNameOfCategoryFilter(String name)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_CATEGORY_FILTER ); 		
		
		return this;
	}	 			

	public static final String  INTERNAL_ID_OF_CATEGORY_FILTER ="category_filter.internal_id";
	public UxsChecker checkInternalIdOfCategoryFilter(String internalId)
	{
		
	 	checkStringLengthRange(internalId,3, 32,INTERNAL_ID_OF_CATEGORY_FILTER ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_CATEGORY_FILTER ="category_filter.profile";
	public UxsChecker checkProfileIdOfCategoryFilter(String profileId)
	{
		
	 	checkIdOfCategoryFilter(profileId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CATEGORY_FILTER ="category_filter.version";
	public UxsChecker checkVersionOfCategoryFilter(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATEGORY_FILTER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_NEW_PRODUCT ="new_product.id";
	public UxsChecker checkIdOfNewProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_NEW_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_NEW_PRODUCT ="new_product.name";
	public UxsChecker checkNameOfNewProduct(String name)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_NEW_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_NEW_PRODUCT ="new_product.parent_category";
	public UxsChecker checkParentCategoryIdOfNewProduct(String parentCategoryId)
	{
		
	 	checkIdOfNewProduct(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  BRAND_OF_NEW_PRODUCT ="new_product.brand";
	public UxsChecker checkBrandIdOfNewProduct(String brandId)
	{
		
	 	checkIdOfNewProduct(brandId ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_COVER_IMAGE_OF_NEW_PRODUCT ="new_product.product_cover_image";
	public UxsChecker checkProductCoverImageOfNewProduct(String productCoverImage)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_NEW_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ORIGIN_OF_NEW_PRODUCT ="new_product.origin";
	public UxsChecker checkOriginOfNewProduct(String origin)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_NEW_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_NEW_PRODUCT ="new_product.catalog";
	public UxsChecker checkCatalogIdOfNewProduct(String catalogId)
	{
		
	 	checkIdOfNewProduct(catalogId ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_NEW_PRODUCT ="new_product.profile";
	public UxsChecker checkProfileIdOfNewProduct(String profileId)
	{
		
	 	checkIdOfNewProduct(profileId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_NEW_PRODUCT ="new_product.remark";
	public UxsChecker checkRemarkOfNewProduct(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_NEW_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_NEW_PRODUCT ="new_product.platform";
	public UxsChecker checkPlatformIdOfNewProduct(String platformId)
	{
		
	 	checkIdOfNewProduct(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_NEW_PRODUCT ="new_product.version";
	public UxsChecker checkVersionOfNewProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_NEW_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.id";
	public UxsChecker checkIdOfEditorPickProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EDITOR_PICK_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.name";
	public UxsChecker checkNameOfEditorPickProduct(String name)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_EDITOR_PICK_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.parent_category";
	public UxsChecker checkParentCategoryIdOfEditorPickProduct(String parentCategoryId)
	{
		
	 	checkIdOfEditorPickProduct(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  BRAND_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.brand";
	public UxsChecker checkBrandIdOfEditorPickProduct(String brandId)
	{
		
	 	checkIdOfEditorPickProduct(brandId ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_COVER_IMAGE_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.product_cover_image";
	public UxsChecker checkProductCoverImageOfEditorPickProduct(String productCoverImage)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_EDITOR_PICK_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ORIGIN_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.origin";
	public UxsChecker checkOriginOfEditorPickProduct(String origin)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_EDITOR_PICK_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.catalog";
	public UxsChecker checkCatalogIdOfEditorPickProduct(String catalogId)
	{
		
	 	checkIdOfEditorPickProduct(catalogId ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.profile";
	public UxsChecker checkProfileIdOfEditorPickProduct(String profileId)
	{
		
	 	checkIdOfEditorPickProduct(profileId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.remark";
	public UxsChecker checkRemarkOfEditorPickProduct(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_EDITOR_PICK_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.platform";
	public UxsChecker checkPlatformIdOfEditorPickProduct(String platformId)
	{
		
	 	checkIdOfEditorPickProduct(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EDITOR_PICK_PRODUCT ="editor_pick_product.version";
	public UxsChecker checkVersionOfEditorPickProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EDITOR_PICK_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TOP_RATED_PRODUCT ="top_rated_product.id";
	public UxsChecker checkIdOfTopRatedProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TOP_RATED_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TOP_RATED_PRODUCT ="top_rated_product.name";
	public UxsChecker checkNameOfTopRatedProduct(String name)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_TOP_RATED_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_TOP_RATED_PRODUCT ="top_rated_product.parent_category";
	public UxsChecker checkParentCategoryIdOfTopRatedProduct(String parentCategoryId)
	{
		
	 	checkIdOfTopRatedProduct(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  BRAND_OF_TOP_RATED_PRODUCT ="top_rated_product.brand";
	public UxsChecker checkBrandIdOfTopRatedProduct(String brandId)
	{
		
	 	checkIdOfTopRatedProduct(brandId ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_COVER_IMAGE_OF_TOP_RATED_PRODUCT ="top_rated_product.product_cover_image";
	public UxsChecker checkProductCoverImageOfTopRatedProduct(String productCoverImage)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_TOP_RATED_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ORIGIN_OF_TOP_RATED_PRODUCT ="top_rated_product.origin";
	public UxsChecker checkOriginOfTopRatedProduct(String origin)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_TOP_RATED_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_TOP_RATED_PRODUCT ="top_rated_product.catalog";
	public UxsChecker checkCatalogIdOfTopRatedProduct(String catalogId)
	{
		
	 	checkIdOfTopRatedProduct(catalogId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_TOP_RATED_PRODUCT ="top_rated_product.remark";
	public UxsChecker checkRemarkOfTopRatedProduct(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_TOP_RATED_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_TOP_RATED_PRODUCT ="top_rated_product.profile";
	public UxsChecker checkProfileIdOfTopRatedProduct(String profileId)
	{
		
	 	checkIdOfTopRatedProduct(profileId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_TOP_RATED_PRODUCT ="top_rated_product.platform";
	public UxsChecker checkPlatformIdOfTopRatedProduct(String platformId)
	{
		
	 	checkIdOfTopRatedProduct(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TOP_RATED_PRODUCT ="top_rated_product.version";
	public UxsChecker checkVersionOfTopRatedProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TOP_RATED_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RECOMMAND_PRODUCT ="recommand_product.id";
	public UxsChecker checkIdOfRecommandProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RECOMMAND_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RECOMMAND_PRODUCT ="recommand_product.name";
	public UxsChecker checkNameOfRecommandProduct(String name)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_RECOMMAND_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_RECOMMAND_PRODUCT ="recommand_product.parent_category";
	public UxsChecker checkParentCategoryIdOfRecommandProduct(String parentCategoryId)
	{
		
	 	checkIdOfRecommandProduct(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  BRAND_OF_RECOMMAND_PRODUCT ="recommand_product.brand";
	public UxsChecker checkBrandIdOfRecommandProduct(String brandId)
	{
		
	 	checkIdOfRecommandProduct(brandId ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_COVER_IMAGE_OF_RECOMMAND_PRODUCT ="recommand_product.product_cover_image";
	public UxsChecker checkProductCoverImageOfRecommandProduct(String productCoverImage)
	{
		
	 	checkImage(productCoverImage,0, 512,PRODUCT_COVER_IMAGE_OF_RECOMMAND_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ORIGIN_OF_RECOMMAND_PRODUCT ="recommand_product.origin";
	public UxsChecker checkOriginOfRecommandProduct(String origin)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_RECOMMAND_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_RECOMMAND_PRODUCT ="recommand_product.catalog";
	public UxsChecker checkCatalogIdOfRecommandProduct(String catalogId)
	{
		
	 	checkIdOfRecommandProduct(catalogId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_RECOMMAND_PRODUCT ="recommand_product.remark";
	public UxsChecker checkRemarkOfRecommandProduct(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_RECOMMAND_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PROFILE_OF_RECOMMAND_PRODUCT ="recommand_product.profile";
	public UxsChecker checkProfileIdOfRecommandProduct(String profileId)
	{
		
	 	checkIdOfRecommandProduct(profileId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_RECOMMAND_PRODUCT ="recommand_product.platform";
	public UxsChecker checkPlatformIdOfRecommandProduct(String platformId)
	{
		
	 	checkIdOfRecommandProduct(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RECOMMAND_PRODUCT ="recommand_product.version";
	public UxsChecker checkVersionOfRecommandProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RECOMMAND_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public UxsChecker checkIdOfUserDomain(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public UxsChecker checkNameOfUserDomain(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public UxsChecker checkVersionOfUserDomain(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public UxsChecker checkIdOfUserWhiteList(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public UxsChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public UxsChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public UxsChecker checkDomainIdOfUserWhiteList(String domainId)
	{
		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public UxsChecker checkVersionOfUserWhiteList(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public UxsChecker checkIdOfSecUser(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public UxsChecker checkLoginOfSecUser(String login)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public UxsChecker checkMobileOfSecUser(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public UxsChecker checkEmailOfSecUser(String email)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public UxsChecker checkPwdOfSecUser(String pwd)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public UxsChecker checkVerificationCodeOfSecUser(int verificationCode)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public UxsChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public UxsChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public UxsChecker checkDomainIdOfSecUser(String domainId)
	{
		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public UxsChecker checkVersionOfSecUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	public UxsChecker checkIdOfSecUserBlocking(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	public UxsChecker checkWhoOfSecUserBlocking(String who)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	public UxsChecker checkCommentsOfSecUserBlocking(String comments)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	public UxsChecker checkVersionOfSecUserBlocking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_APP ="user_app.id";
	public UxsChecker checkIdOfUserApp(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public UxsChecker checkTitleOfUserApp(String title)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public UxsChecker checkSecUserIdOfUserApp(String secUserId)
	{
		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	 			

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public UxsChecker checkAppIconOfUserApp(String appIcon)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public UxsChecker checkFullAccessOfUserApp(boolean fullAccess)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public UxsChecker checkPermissionOfUserApp(String permission)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public UxsChecker checkObjectTypeOfUserApp(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public UxsChecker checkObjectIdOfUserApp(String objectId)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public UxsChecker checkLocationOfUserApp(String location)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public UxsChecker checkVersionOfUserApp(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public UxsChecker checkIdOfListAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public UxsChecker checkNameOfListAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public UxsChecker checkInternalNameOfListAccess(String internalName)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public UxsChecker checkReadPermissionOfListAccess(boolean readPermission)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public UxsChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public UxsChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public UxsChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public UxsChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public UxsChecker checkAppIdOfListAccess(String appId)
	{
		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public UxsChecker checkVersionOfListAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public UxsChecker checkIdOfObjectAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public UxsChecker checkNameOfObjectAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public UxsChecker checkObjectTypeOfObjectAccess(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public UxsChecker checkList1OfObjectAccess(String list1)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public UxsChecker checkList2OfObjectAccess(String list2)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public UxsChecker checkList3OfObjectAccess(String list3)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public UxsChecker checkList4OfObjectAccess(String list4)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public UxsChecker checkList5OfObjectAccess(String list5)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public UxsChecker checkList6OfObjectAccess(String list6)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public UxsChecker checkList7OfObjectAccess(String list7)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public UxsChecker checkList8OfObjectAccess(String list8)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public UxsChecker checkList9OfObjectAccess(String list9)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public UxsChecker checkAppIdOfObjectAccess(String appId)
	{
		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public UxsChecker checkVersionOfObjectAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public UxsChecker checkIdOfLoginHistory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public UxsChecker checkFromIpOfLoginHistory(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public UxsChecker checkDescriptionOfLoginHistory(String description)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public UxsChecker checkSecUserIdOfLoginHistory(String secUserId)
	{
		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public UxsChecker checkVersionOfLoginHistory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public UxsChecker checkIdOfGenericForm(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public UxsChecker checkTitleOfGenericForm(String title)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public UxsChecker checkDescriptionOfGenericForm(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public UxsChecker checkVersionOfGenericForm(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public UxsChecker checkIdOfFormMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public UxsChecker checkTitleOfFormMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public UxsChecker checkFormIdOfFormMessage(String formId)
	{
		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public UxsChecker checkLevelOfFormMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public UxsChecker checkVersionOfFormMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public UxsChecker checkIdOfFormFieldMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public UxsChecker checkTitleOfFormFieldMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public UxsChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public UxsChecker checkFormIdOfFormFieldMessage(String formId)
	{
		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public UxsChecker checkLevelOfFormFieldMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public UxsChecker checkVersionOfFormFieldMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public UxsChecker checkIdOfFormField(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public UxsChecker checkLabelOfFormField(String label)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public UxsChecker checkLocaleKeyOfFormField(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public UxsChecker checkParameterNameOfFormField(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public UxsChecker checkTypeOfFormField(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public UxsChecker checkFormIdOfFormField(String formId)
	{
		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	 			

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public UxsChecker checkPlaceholderOfFormField(String placeholder)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public UxsChecker checkDefaultValueOfFormField(String defaultValue)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public UxsChecker checkDescriptionOfFormField(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public UxsChecker checkFieldGroupOfFormField(String fieldGroup)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public UxsChecker checkMinimumValueOfFormField(String minimumValue)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public UxsChecker checkMaximumValueOfFormField(String maximumValue)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public UxsChecker checkRequiredOfFormField(boolean required)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public UxsChecker checkDisabledOfFormField(boolean disabled)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public UxsChecker checkCustomRenderingOfFormField(boolean customRendering)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public UxsChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public UxsChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public UxsChecker checkVersionOfFormField(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public UxsChecker checkIdOfFormAction(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public UxsChecker checkLabelOfFormAction(String label)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public UxsChecker checkLocaleKeyOfFormAction(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public UxsChecker checkActionKeyOfFormAction(String actionKey)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public UxsChecker checkLevelOfFormAction(String level)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public UxsChecker checkUrlOfFormAction(String url)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public UxsChecker checkFormIdOfFormAction(String formId)
	{
		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public UxsChecker checkVersionOfFormAction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	 			
	public void throwExceptionIfHasErrors(Class<? extends Exception> exceptionClazz) throws Exception {
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

    
}












