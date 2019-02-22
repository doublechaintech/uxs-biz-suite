
package com.doublechaintech.uxs.platform;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
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
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withSiteList()
			.withCatalogList()
			.withBrandList()
			.withProductList()
			.withBannerList()
			.withProfileList()
			.withUserAlertList()
			.withNewProductList()
			.withEditorPickProductList()
			.withTopRatedProductList()
			.withRecommandProductList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
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

	protected static final String SITE_LIST = "siteList";
	public String getSiteList(){
		return SITE_LIST;
	}
	public PlatformTokens withSiteList(){		
		addSimpleOptions(SITE_LIST);
		return this;
	}
	public PlatformTokens analyzeSiteList(){		
		addSimpleOptions(SITE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSiteListEnabled(){		
		
		return checkOptions(this.options(), SITE_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromSiteList(String idsSeperatedWithComma){		
		addSimpleOptions(SITE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int siteListSortCounter = 0;
	public PlatformTokens sortSiteListWith(String field, String descOrAsc){		
		addSortMoreOptions(SITE_LIST,siteListSortCounter++, field, descOrAsc);
		return this;
	}
	private int siteListSearchCounter = 0;
	public PlatformTokens searchSiteListWith(String field, String verb, String value){		
		addSearchMoreOptions(SITE_LIST,siteListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfSiteList(String verb, String value){	
		String field = "id|name|introduction";
		addSearchMoreOptions(SITE_LIST,siteListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfSiteList(int rowsPerPage){		
		addSimpleOptions(SITE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfSiteList(int currentPageNumber){		
		addSimpleOptions(SITE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfSiteList(String[] columns){		
		addSimpleOptions(SITE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfSiteList(String[] columns){		
		addSimpleOptions(SITE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CATALOG_LIST = "catalogList";
	public String getCatalogList(){
		return CATALOG_LIST;
	}
	public PlatformTokens withCatalogList(){		
		addSimpleOptions(CATALOG_LIST);
		return this;
	}
	public PlatformTokens analyzeCatalogList(){		
		addSimpleOptions(CATALOG_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCatalogListEnabled(){		
		
		return checkOptions(this.options(), CATALOG_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromCatalogList(String idsSeperatedWithComma){		
		addSimpleOptions(CATALOG_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int catalogListSortCounter = 0;
	public PlatformTokens sortCatalogListWith(String field, String descOrAsc){		
		addSortMoreOptions(CATALOG_LIST,catalogListSortCounter++, field, descOrAsc);
		return this;
	}
	private int catalogListSearchCounter = 0;
	public PlatformTokens searchCatalogListWith(String field, String verb, String value){		
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfCatalogList(String verb, String value){	
		String field = "id|name|sellerId";
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfCatalogList(int rowsPerPage){		
		addSimpleOptions(CATALOG_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfCatalogList(int currentPageNumber){		
		addSimpleOptions(CATALOG_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfCatalogList(String[] columns){		
		addSimpleOptions(CATALOG_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfCatalogList(String[] columns){		
		addSimpleOptions(CATALOG_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String BRAND_LIST = "brandList";
	public String getBrandList(){
		return BRAND_LIST;
	}
	public PlatformTokens withBrandList(){		
		addSimpleOptions(BRAND_LIST);
		return this;
	}
	public PlatformTokens analyzeBrandList(){		
		addSimpleOptions(BRAND_LIST+".anaylze");
		return this;
	}
	public boolean analyzeBrandListEnabled(){		
		
		return checkOptions(this.options(), BRAND_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromBrandList(String idsSeperatedWithComma){		
		addSimpleOptions(BRAND_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int brandListSortCounter = 0;
	public PlatformTokens sortBrandListWith(String field, String descOrAsc){		
		addSortMoreOptions(BRAND_LIST,brandListSortCounter++, field, descOrAsc);
		return this;
	}
	private int brandListSearchCounter = 0;
	public PlatformTokens searchBrandListWith(String field, String verb, String value){		
		addSearchMoreOptions(BRAND_LIST,brandListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfBrandList(String verb, String value){	
		String field = "id|brandName|remark";
		addSearchMoreOptions(BRAND_LIST,brandListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfBrandList(int rowsPerPage){		
		addSimpleOptions(BRAND_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfBrandList(int currentPageNumber){		
		addSimpleOptions(BRAND_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfBrandList(String[] columns){		
		addSimpleOptions(BRAND_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfBrandList(String[] columns){		
		addSimpleOptions(BRAND_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PRODUCT_LIST = "productList";
	public String getProductList(){
		return PRODUCT_LIST;
	}
	public PlatformTokens withProductList(){		
		addSimpleOptions(PRODUCT_LIST);
		return this;
	}
	public PlatformTokens analyzeProductList(){		
		addSimpleOptions(PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromProductList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productListSortCounter = 0;
	public PlatformTokens sortProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_LIST,productListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productListSearchCounter = 0;
	public PlatformTokens searchProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfProductList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfProductList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String BANNER_LIST = "bannerList";
	public String getBannerList(){
		return BANNER_LIST;
	}
	public PlatformTokens withBannerList(){		
		addSimpleOptions(BANNER_LIST);
		return this;
	}
	public PlatformTokens analyzeBannerList(){		
		addSimpleOptions(BANNER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeBannerListEnabled(){		
		
		return checkOptions(this.options(), BANNER_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromBannerList(String idsSeperatedWithComma){		
		addSimpleOptions(BANNER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int bannerListSortCounter = 0;
	public PlatformTokens sortBannerListWith(String field, String descOrAsc){		
		addSortMoreOptions(BANNER_LIST,bannerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int bannerListSearchCounter = 0;
	public PlatformTokens searchBannerListWith(String field, String verb, String value){		
		addSearchMoreOptions(BANNER_LIST,bannerListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfBannerList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(BANNER_LIST,bannerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfBannerList(int rowsPerPage){		
		addSimpleOptions(BANNER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfBannerList(int currentPageNumber){		
		addSimpleOptions(BANNER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfBannerList(String[] columns){		
		addSimpleOptions(BANNER_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfBannerList(String[] columns){		
		addSimpleOptions(BANNER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PROFILE_LIST = "profileList";
	public String getProfileList(){
		return PROFILE_LIST;
	}
	public PlatformTokens withProfileList(){		
		addSimpleOptions(PROFILE_LIST);
		return this;
	}
	public PlatformTokens analyzeProfileList(){		
		addSimpleOptions(PROFILE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProfileListEnabled(){		
		
		return checkOptions(this.options(), PROFILE_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromProfileList(String idsSeperatedWithComma){		
		addSimpleOptions(PROFILE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int profileListSortCounter = 0;
	public PlatformTokens sortProfileListWith(String field, String descOrAsc){		
		addSortMoreOptions(PROFILE_LIST,profileListSortCounter++, field, descOrAsc);
		return this;
	}
	private int profileListSearchCounter = 0;
	public PlatformTokens searchProfileListWith(String field, String verb, String value){		
		addSearchMoreOptions(PROFILE_LIST,profileListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfProfileList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(PROFILE_LIST,profileListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfProfileList(int rowsPerPage){		
		addSimpleOptions(PROFILE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfProfileList(int currentPageNumber){		
		addSimpleOptions(PROFILE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfProfileList(String[] columns){		
		addSimpleOptions(PROFILE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfProfileList(String[] columns){		
		addSimpleOptions(PROFILE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String USER_ALERT_LIST = "userAlertList";
	public String getUserAlertList(){
		return USER_ALERT_LIST;
	}
	public PlatformTokens withUserAlertList(){		
		addSimpleOptions(USER_ALERT_LIST);
		return this;
	}
	public PlatformTokens analyzeUserAlertList(){		
		addSimpleOptions(USER_ALERT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserAlertListEnabled(){		
		
		return checkOptions(this.options(), USER_ALERT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromUserAlertList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_ALERT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userAlertListSortCounter = 0;
	public PlatformTokens sortUserAlertListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_ALERT_LIST,userAlertListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userAlertListSearchCounter = 0;
	public PlatformTokens searchUserAlertListWith(String field, String verb, String value){		
		addSearchMoreOptions(USER_ALERT_LIST,userAlertListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfUserAlertList(String verb, String value){	
		String field = "id|message|location";
		addSearchMoreOptions(USER_ALERT_LIST,userAlertListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfUserAlertList(int rowsPerPage){		
		addSimpleOptions(USER_ALERT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfUserAlertList(int currentPageNumber){		
		addSimpleOptions(USER_ALERT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfUserAlertList(String[] columns){		
		addSimpleOptions(USER_ALERT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfUserAlertList(String[] columns){		
		addSimpleOptions(USER_ALERT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String NEW_PRODUCT_LIST = "newProductList";
	public String getNewProductList(){
		return NEW_PRODUCT_LIST;
	}
	public PlatformTokens withNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST);
		return this;
	}
	public PlatformTokens analyzeNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeNewProductListEnabled(){		
		
		return checkOptions(this.options(), NEW_PRODUCT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromNewProductList(String idsSeperatedWithComma){		
		addSimpleOptions(NEW_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int newProductListSortCounter = 0;
	public PlatformTokens sortNewProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(NEW_PRODUCT_LIST,newProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int newProductListSearchCounter = 0;
	public PlatformTokens searchNewProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfNewProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfNewProductList(int rowsPerPage){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfNewProductList(int currentPageNumber){		
		addSimpleOptions(NEW_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EDITOR_PICK_PRODUCT_LIST = "editorPickProductList";
	public String getEditorPickProductList(){
		return EDITOR_PICK_PRODUCT_LIST;
	}
	public PlatformTokens withEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST);
		return this;
	}
	public PlatformTokens analyzeEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEditorPickProductListEnabled(){		
		
		return checkOptions(this.options(), EDITOR_PICK_PRODUCT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromEditorPickProductList(String idsSeperatedWithComma){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int editorPickProductListSortCounter = 0;
	public PlatformTokens sortEditorPickProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int editorPickProductListSearchCounter = 0;
	public PlatformTokens searchEditorPickProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfEditorPickProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfEditorPickProductList(int rowsPerPage){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfEditorPickProductList(int currentPageNumber){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TOP_RATED_PRODUCT_LIST = "topRatedProductList";
	public String getTopRatedProductList(){
		return TOP_RATED_PRODUCT_LIST;
	}
	public PlatformTokens withTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST);
		return this;
	}
	public PlatformTokens analyzeTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTopRatedProductListEnabled(){		
		
		return checkOptions(this.options(), TOP_RATED_PRODUCT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromTopRatedProductList(String idsSeperatedWithComma){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int topRatedProductListSortCounter = 0;
	public PlatformTokens sortTopRatedProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int topRatedProductListSearchCounter = 0;
	public PlatformTokens searchTopRatedProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfTopRatedProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfTopRatedProductList(int rowsPerPage){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfTopRatedProductList(int currentPageNumber){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RECOMMAND_PRODUCT_LIST = "recommandProductList";
	public String getRecommandProductList(){
		return RECOMMAND_PRODUCT_LIST;
	}
	public PlatformTokens withRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST);
		return this;
	}
	public PlatformTokens analyzeRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRecommandProductListEnabled(){		
		
		return checkOptions(this.options(), RECOMMAND_PRODUCT_LIST+".anaylze");
	}
	public PlatformTokens extractMoreFromRecommandProductList(String idsSeperatedWithComma){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int recommandProductListSortCounter = 0;
	public PlatformTokens sortRecommandProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int recommandProductListSearchCounter = 0;
	public PlatformTokens searchRecommandProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfRecommandProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfRecommandProductList(int rowsPerPage){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfRecommandProductList(int currentPageNumber){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfSiteList(verb, value);	
		searchAllTextOfCatalogList(verb, value);	
		searchAllTextOfBrandList(verb, value);	
		searchAllTextOfProductList(verb, value);	
		searchAllTextOfBannerList(verb, value);	
		searchAllTextOfProfileList(verb, value);	
		searchAllTextOfUserAlertList(verb, value);	
		searchAllTextOfNewProductList(verb, value);	
		searchAllTextOfEditorPickProductList(verb, value);	
		searchAllTextOfTopRatedProductList(verb, value);	
		searchAllTextOfRecommandProductList(verb, value);	
		return this;
	}
}

