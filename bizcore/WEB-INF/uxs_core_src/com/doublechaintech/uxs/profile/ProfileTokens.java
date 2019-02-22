
package com.doublechaintech.uxs.profile;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class ProfileTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="profile";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected ProfileTokens(){
		//ensure not initialized outside the class
	}
	
	public ProfileTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProfileTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProfileTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProfileTokens start(){
		return new ProfileTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProfileTokens allTokens(){
		
		return start()
			.withPlatform()
			.withUserAlertList()
			.withTargetList()
			.withRatingList()
			.withReviewList()
			.withBlogList()
			.withBrandFilterList()
			.withPriceFilterList()
			.withCategoryFilterList()
			.withNewProductList()
			.withEditorPickProductList()
			.withTopRatedProductList()
			.withRecommandProductList();
	
	}
	public static ProfileTokens withoutListsTokens(){
		
		return start()
			.withPlatform();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public ProfileTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String USER_ALERT_LIST = "userAlertList";
	public String getUserAlertList(){
		return USER_ALERT_LIST;
	}
	public ProfileTokens withUserAlertList(){		
		addSimpleOptions(USER_ALERT_LIST);
		return this;
	}
	public ProfileTokens analyzeUserAlertList(){		
		addSimpleOptions(USER_ALERT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserAlertListEnabled(){		
		
		return checkOptions(this.options(), USER_ALERT_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromUserAlertList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_ALERT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userAlertListSortCounter = 0;
	public ProfileTokens sortUserAlertListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_ALERT_LIST,userAlertListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userAlertListSearchCounter = 0;
	public ProfileTokens searchUserAlertListWith(String field, String verb, String value){		
		addSearchMoreOptions(USER_ALERT_LIST,userAlertListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfUserAlertList(String verb, String value){	
		String field = "id|message|location";
		addSearchMoreOptions(USER_ALERT_LIST,userAlertListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfUserAlertList(int rowsPerPage){		
		addSimpleOptions(USER_ALERT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfUserAlertList(int currentPageNumber){		
		addSimpleOptions(USER_ALERT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfUserAlertList(String[] columns){		
		addSimpleOptions(USER_ALERT_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfUserAlertList(String[] columns){		
		addSimpleOptions(USER_ALERT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TARGET_LIST = "targetList";
	public String getTargetList(){
		return TARGET_LIST;
	}
	public ProfileTokens withTargetList(){		
		addSimpleOptions(TARGET_LIST);
		return this;
	}
	public ProfileTokens analyzeTargetList(){		
		addSimpleOptions(TARGET_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTargetListEnabled(){		
		
		return checkOptions(this.options(), TARGET_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromTargetList(String idsSeperatedWithComma){		
		addSimpleOptions(TARGET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int targetListSortCounter = 0;
	public ProfileTokens sortTargetListWith(String field, String descOrAsc){		
		addSortMoreOptions(TARGET_LIST,targetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int targetListSearchCounter = 0;
	public ProfileTokens searchTargetListWith(String field, String verb, String value){		
		addSearchMoreOptions(TARGET_LIST,targetListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfTargetList(String verb, String value){	
		String field = "id|name|location";
		addSearchMoreOptions(TARGET_LIST,targetListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfTargetList(int rowsPerPage){		
		addSimpleOptions(TARGET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfTargetList(int currentPageNumber){		
		addSimpleOptions(TARGET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfTargetList(String[] columns){		
		addSimpleOptions(TARGET_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfTargetList(String[] columns){		
		addSimpleOptions(TARGET_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RATING_LIST = "ratingList";
	public String getRatingList(){
		return RATING_LIST;
	}
	public ProfileTokens withRatingList(){		
		addSimpleOptions(RATING_LIST);
		return this;
	}
	public ProfileTokens analyzeRatingList(){		
		addSimpleOptions(RATING_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRatingListEnabled(){		
		
		return checkOptions(this.options(), RATING_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromRatingList(String idsSeperatedWithComma){		
		addSimpleOptions(RATING_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int ratingListSortCounter = 0;
	public ProfileTokens sortRatingListWith(String field, String descOrAsc){		
		addSortMoreOptions(RATING_LIST,ratingListSortCounter++, field, descOrAsc);
		return this;
	}
	private int ratingListSearchCounter = 0;
	public ProfileTokens searchRatingListWith(String field, String verb, String value){		
		addSearchMoreOptions(RATING_LIST,ratingListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfRatingList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(RATING_LIST,ratingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfRatingList(int rowsPerPage){		
		addSimpleOptions(RATING_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfRatingList(int currentPageNumber){		
		addSimpleOptions(RATING_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfRatingList(String[] columns){		
		addSimpleOptions(RATING_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfRatingList(String[] columns){		
		addSimpleOptions(RATING_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String REVIEW_LIST = "reviewList";
	public String getReviewList(){
		return REVIEW_LIST;
	}
	public ProfileTokens withReviewList(){		
		addSimpleOptions(REVIEW_LIST);
		return this;
	}
	public ProfileTokens analyzeReviewList(){		
		addSimpleOptions(REVIEW_LIST+".anaylze");
		return this;
	}
	public boolean analyzeReviewListEnabled(){		
		
		return checkOptions(this.options(), REVIEW_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromReviewList(String idsSeperatedWithComma){		
		addSimpleOptions(REVIEW_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int reviewListSortCounter = 0;
	public ProfileTokens sortReviewListWith(String field, String descOrAsc){		
		addSortMoreOptions(REVIEW_LIST,reviewListSortCounter++, field, descOrAsc);
		return this;
	}
	private int reviewListSearchCounter = 0;
	public ProfileTokens searchReviewListWith(String field, String verb, String value){		
		addSearchMoreOptions(REVIEW_LIST,reviewListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfReviewList(String verb, String value){	
		String field = "id|title|content";
		addSearchMoreOptions(REVIEW_LIST,reviewListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfReviewList(int rowsPerPage){		
		addSimpleOptions(REVIEW_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfReviewList(int currentPageNumber){		
		addSimpleOptions(REVIEW_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfReviewList(String[] columns){		
		addSimpleOptions(REVIEW_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfReviewList(String[] columns){		
		addSimpleOptions(REVIEW_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String BLOG_LIST = "blogList";
	public String getBlogList(){
		return BLOG_LIST;
	}
	public ProfileTokens withBlogList(){		
		addSimpleOptions(BLOG_LIST);
		return this;
	}
	public ProfileTokens analyzeBlogList(){		
		addSimpleOptions(BLOG_LIST+".anaylze");
		return this;
	}
	public boolean analyzeBlogListEnabled(){		
		
		return checkOptions(this.options(), BLOG_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromBlogList(String idsSeperatedWithComma){		
		addSimpleOptions(BLOG_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int blogListSortCounter = 0;
	public ProfileTokens sortBlogListWith(String field, String descOrAsc){		
		addSortMoreOptions(BLOG_LIST,blogListSortCounter++, field, descOrAsc);
		return this;
	}
	private int blogListSearchCounter = 0;
	public ProfileTokens searchBlogListWith(String field, String verb, String value){		
		addSearchMoreOptions(BLOG_LIST,blogListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfBlogList(String verb, String value){	
		String field = "id|title|content";
		addSearchMoreOptions(BLOG_LIST,blogListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfBlogList(int rowsPerPage){		
		addSimpleOptions(BLOG_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfBlogList(int currentPageNumber){		
		addSimpleOptions(BLOG_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfBlogList(String[] columns){		
		addSimpleOptions(BLOG_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfBlogList(String[] columns){		
		addSimpleOptions(BLOG_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String BRAND_FILTER_LIST = "brandFilterList";
	public String getBrandFilterList(){
		return BRAND_FILTER_LIST;
	}
	public ProfileTokens withBrandFilterList(){		
		addSimpleOptions(BRAND_FILTER_LIST);
		return this;
	}
	public ProfileTokens analyzeBrandFilterList(){		
		addSimpleOptions(BRAND_FILTER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeBrandFilterListEnabled(){		
		
		return checkOptions(this.options(), BRAND_FILTER_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromBrandFilterList(String idsSeperatedWithComma){		
		addSimpleOptions(BRAND_FILTER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int brandFilterListSortCounter = 0;
	public ProfileTokens sortBrandFilterListWith(String field, String descOrAsc){		
		addSortMoreOptions(BRAND_FILTER_LIST,brandFilterListSortCounter++, field, descOrAsc);
		return this;
	}
	private int brandFilterListSearchCounter = 0;
	public ProfileTokens searchBrandFilterListWith(String field, String verb, String value){		
		addSearchMoreOptions(BRAND_FILTER_LIST,brandFilterListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfBrandFilterList(String verb, String value){	
		String field = "id|name|internalId";
		addSearchMoreOptions(BRAND_FILTER_LIST,brandFilterListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfBrandFilterList(int rowsPerPage){		
		addSimpleOptions(BRAND_FILTER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfBrandFilterList(int currentPageNumber){		
		addSimpleOptions(BRAND_FILTER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfBrandFilterList(String[] columns){		
		addSimpleOptions(BRAND_FILTER_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfBrandFilterList(String[] columns){		
		addSimpleOptions(BRAND_FILTER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PRICE_FILTER_LIST = "priceFilterList";
	public String getPriceFilterList(){
		return PRICE_FILTER_LIST;
	}
	public ProfileTokens withPriceFilterList(){		
		addSimpleOptions(PRICE_FILTER_LIST);
		return this;
	}
	public ProfileTokens analyzePriceFilterList(){		
		addSimpleOptions(PRICE_FILTER_LIST+".anaylze");
		return this;
	}
	public boolean analyzePriceFilterListEnabled(){		
		
		return checkOptions(this.options(), PRICE_FILTER_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromPriceFilterList(String idsSeperatedWithComma){		
		addSimpleOptions(PRICE_FILTER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int priceFilterListSortCounter = 0;
	public ProfileTokens sortPriceFilterListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRICE_FILTER_LIST,priceFilterListSortCounter++, field, descOrAsc);
		return this;
	}
	private int priceFilterListSearchCounter = 0;
	public ProfileTokens searchPriceFilterListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRICE_FILTER_LIST,priceFilterListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfPriceFilterList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(PRICE_FILTER_LIST,priceFilterListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfPriceFilterList(int rowsPerPage){		
		addSimpleOptions(PRICE_FILTER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfPriceFilterList(int currentPageNumber){		
		addSimpleOptions(PRICE_FILTER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfPriceFilterList(String[] columns){		
		addSimpleOptions(PRICE_FILTER_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfPriceFilterList(String[] columns){		
		addSimpleOptions(PRICE_FILTER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CATEGORY_FILTER_LIST = "categoryFilterList";
	public String getCategoryFilterList(){
		return CATEGORY_FILTER_LIST;
	}
	public ProfileTokens withCategoryFilterList(){		
		addSimpleOptions(CATEGORY_FILTER_LIST);
		return this;
	}
	public ProfileTokens analyzeCategoryFilterList(){		
		addSimpleOptions(CATEGORY_FILTER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCategoryFilterListEnabled(){		
		
		return checkOptions(this.options(), CATEGORY_FILTER_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromCategoryFilterList(String idsSeperatedWithComma){		
		addSimpleOptions(CATEGORY_FILTER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int categoryFilterListSortCounter = 0;
	public ProfileTokens sortCategoryFilterListWith(String field, String descOrAsc){		
		addSortMoreOptions(CATEGORY_FILTER_LIST,categoryFilterListSortCounter++, field, descOrAsc);
		return this;
	}
	private int categoryFilterListSearchCounter = 0;
	public ProfileTokens searchCategoryFilterListWith(String field, String verb, String value){		
		addSearchMoreOptions(CATEGORY_FILTER_LIST,categoryFilterListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfCategoryFilterList(String verb, String value){	
		String field = "id|name|internalId";
		addSearchMoreOptions(CATEGORY_FILTER_LIST,categoryFilterListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfCategoryFilterList(int rowsPerPage){		
		addSimpleOptions(CATEGORY_FILTER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfCategoryFilterList(int currentPageNumber){		
		addSimpleOptions(CATEGORY_FILTER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfCategoryFilterList(String[] columns){		
		addSimpleOptions(CATEGORY_FILTER_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfCategoryFilterList(String[] columns){		
		addSimpleOptions(CATEGORY_FILTER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String NEW_PRODUCT_LIST = "newProductList";
	public String getNewProductList(){
		return NEW_PRODUCT_LIST;
	}
	public ProfileTokens withNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST);
		return this;
	}
	public ProfileTokens analyzeNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeNewProductListEnabled(){		
		
		return checkOptions(this.options(), NEW_PRODUCT_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromNewProductList(String idsSeperatedWithComma){		
		addSimpleOptions(NEW_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int newProductListSortCounter = 0;
	public ProfileTokens sortNewProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(NEW_PRODUCT_LIST,newProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int newProductListSearchCounter = 0;
	public ProfileTokens searchNewProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfNewProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfNewProductList(int rowsPerPage){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfNewProductList(int currentPageNumber){		
		addSimpleOptions(NEW_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EDITOR_PICK_PRODUCT_LIST = "editorPickProductList";
	public String getEditorPickProductList(){
		return EDITOR_PICK_PRODUCT_LIST;
	}
	public ProfileTokens withEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST);
		return this;
	}
	public ProfileTokens analyzeEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEditorPickProductListEnabled(){		
		
		return checkOptions(this.options(), EDITOR_PICK_PRODUCT_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromEditorPickProductList(String idsSeperatedWithComma){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int editorPickProductListSortCounter = 0;
	public ProfileTokens sortEditorPickProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int editorPickProductListSearchCounter = 0;
	public ProfileTokens searchEditorPickProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfEditorPickProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfEditorPickProductList(int rowsPerPage){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfEditorPickProductList(int currentPageNumber){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TOP_RATED_PRODUCT_LIST = "topRatedProductList";
	public String getTopRatedProductList(){
		return TOP_RATED_PRODUCT_LIST;
	}
	public ProfileTokens withTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST);
		return this;
	}
	public ProfileTokens analyzeTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTopRatedProductListEnabled(){		
		
		return checkOptions(this.options(), TOP_RATED_PRODUCT_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromTopRatedProductList(String idsSeperatedWithComma){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int topRatedProductListSortCounter = 0;
	public ProfileTokens sortTopRatedProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int topRatedProductListSearchCounter = 0;
	public ProfileTokens searchTopRatedProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfTopRatedProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfTopRatedProductList(int rowsPerPage){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfTopRatedProductList(int currentPageNumber){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RECOMMAND_PRODUCT_LIST = "recommandProductList";
	public String getRecommandProductList(){
		return RECOMMAND_PRODUCT_LIST;
	}
	public ProfileTokens withRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST);
		return this;
	}
	public ProfileTokens analyzeRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRecommandProductListEnabled(){		
		
		return checkOptions(this.options(), RECOMMAND_PRODUCT_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromRecommandProductList(String idsSeperatedWithComma){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int recommandProductListSortCounter = 0;
	public ProfileTokens sortRecommandProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int recommandProductListSearchCounter = 0;
	public ProfileTokens searchRecommandProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfRecommandProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfRecommandProductList(int rowsPerPage){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfRecommandProductList(int currentPageNumber){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ProfileTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserAlertList(verb, value);	
		searchAllTextOfTargetList(verb, value);	
		searchAllTextOfRatingList(verb, value);	
		searchAllTextOfReviewList(verb, value);	
		searchAllTextOfBlogList(verb, value);	
		searchAllTextOfBrandFilterList(verb, value);	
		searchAllTextOfPriceFilterList(verb, value);	
		searchAllTextOfCategoryFilterList(verb, value);	
		searchAllTextOfNewProductList(verb, value);	
		searchAllTextOfEditorPickProductList(verb, value);	
		searchAllTextOfTopRatedProductList(verb, value);	
		searchAllTextOfRecommandProductList(verb, value);	
		return this;
	}
}

