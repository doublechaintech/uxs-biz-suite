
package com.doublechaintech.uxs.catalog;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class CatalogTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="catalog";
	
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
	protected CatalogTokens(){
		//ensure not initialized outside the class
	}
	
	public CatalogTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static CatalogTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected CatalogTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static CatalogTokens start(){
		return new CatalogTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static CatalogTokens allTokens(){
		
		return start()
			.withSite()
			.withPlatform()
			.withLevelOneCategoryList()
			.withProductList()
			.withNewProductList()
			.withEditorPickProductList()
			.withTopRatedProductList()
			.withRecommandProductList();
	
	}
	public static CatalogTokens withoutListsTokens(){
		
		return start()
			.withSite()
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

	protected static final String SITE = "site";
	public String getSite(){
		return SITE;
	}
	public CatalogTokens withSite(){		
		addSimpleOptions(SITE);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public CatalogTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String LEVEL_ONE_CATEGORY_LIST = "levelOneCategoryList";
	public String getLevelOneCategoryList(){
		return LEVEL_ONE_CATEGORY_LIST;
	}
	public CatalogTokens withLevelOneCategoryList(){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST);
		return this;
	}
	public CatalogTokens analyzeLevelOneCategoryList(){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLevelOneCategoryListEnabled(){		
		
		return checkOptions(this.options(), LEVEL_ONE_CATEGORY_LIST+".anaylze");
	}
	public CatalogTokens extractMoreFromLevelOneCategoryList(String idsSeperatedWithComma){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int levelOneCategoryListSortCounter = 0;
	public CatalogTokens sortLevelOneCategoryListWith(String field, String descOrAsc){		
		addSortMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSortCounter++, field, descOrAsc);
		return this;
	}
	private int levelOneCategoryListSearchCounter = 0;
	public CatalogTokens searchLevelOneCategoryListWith(String field, String verb, String value){		
		addSearchMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CatalogTokens searchAllTextOfLevelOneCategoryList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CatalogTokens rowsPerPageOfLevelOneCategoryList(int rowsPerPage){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfLevelOneCategoryList(int currentPageNumber){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfLevelOneCategoryList(String[] columns){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfLevelOneCategoryList(String[] columns){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PRODUCT_LIST = "productList";
	public String getProductList(){
		return PRODUCT_LIST;
	}
	public CatalogTokens withProductList(){		
		addSimpleOptions(PRODUCT_LIST);
		return this;
	}
	public CatalogTokens analyzeProductList(){		
		addSimpleOptions(PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_LIST+".anaylze");
	}
	public CatalogTokens extractMoreFromProductList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productListSortCounter = 0;
	public CatalogTokens sortProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_LIST,productListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productListSearchCounter = 0;
	public CatalogTokens searchProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CatalogTokens searchAllTextOfProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CatalogTokens rowsPerPageOfProductList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfProductList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String NEW_PRODUCT_LIST = "newProductList";
	public String getNewProductList(){
		return NEW_PRODUCT_LIST;
	}
	public CatalogTokens withNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST);
		return this;
	}
	public CatalogTokens analyzeNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeNewProductListEnabled(){		
		
		return checkOptions(this.options(), NEW_PRODUCT_LIST+".anaylze");
	}
	public CatalogTokens extractMoreFromNewProductList(String idsSeperatedWithComma){		
		addSimpleOptions(NEW_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int newProductListSortCounter = 0;
	public CatalogTokens sortNewProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(NEW_PRODUCT_LIST,newProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int newProductListSearchCounter = 0;
	public CatalogTokens searchNewProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CatalogTokens searchAllTextOfNewProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CatalogTokens rowsPerPageOfNewProductList(int rowsPerPage){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfNewProductList(int currentPageNumber){		
		addSimpleOptions(NEW_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EDITOR_PICK_PRODUCT_LIST = "editorPickProductList";
	public String getEditorPickProductList(){
		return EDITOR_PICK_PRODUCT_LIST;
	}
	public CatalogTokens withEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST);
		return this;
	}
	public CatalogTokens analyzeEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEditorPickProductListEnabled(){		
		
		return checkOptions(this.options(), EDITOR_PICK_PRODUCT_LIST+".anaylze");
	}
	public CatalogTokens extractMoreFromEditorPickProductList(String idsSeperatedWithComma){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int editorPickProductListSortCounter = 0;
	public CatalogTokens sortEditorPickProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int editorPickProductListSearchCounter = 0;
	public CatalogTokens searchEditorPickProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CatalogTokens searchAllTextOfEditorPickProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CatalogTokens rowsPerPageOfEditorPickProductList(int rowsPerPage){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfEditorPickProductList(int currentPageNumber){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TOP_RATED_PRODUCT_LIST = "topRatedProductList";
	public String getTopRatedProductList(){
		return TOP_RATED_PRODUCT_LIST;
	}
	public CatalogTokens withTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST);
		return this;
	}
	public CatalogTokens analyzeTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTopRatedProductListEnabled(){		
		
		return checkOptions(this.options(), TOP_RATED_PRODUCT_LIST+".anaylze");
	}
	public CatalogTokens extractMoreFromTopRatedProductList(String idsSeperatedWithComma){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int topRatedProductListSortCounter = 0;
	public CatalogTokens sortTopRatedProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int topRatedProductListSearchCounter = 0;
	public CatalogTokens searchTopRatedProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CatalogTokens searchAllTextOfTopRatedProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CatalogTokens rowsPerPageOfTopRatedProductList(int rowsPerPage){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfTopRatedProductList(int currentPageNumber){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RECOMMAND_PRODUCT_LIST = "recommandProductList";
	public String getRecommandProductList(){
		return RECOMMAND_PRODUCT_LIST;
	}
	public CatalogTokens withRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST);
		return this;
	}
	public CatalogTokens analyzeRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRecommandProductListEnabled(){		
		
		return checkOptions(this.options(), RECOMMAND_PRODUCT_LIST+".anaylze");
	}
	public CatalogTokens extractMoreFromRecommandProductList(String idsSeperatedWithComma){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int recommandProductListSortCounter = 0;
	public CatalogTokens sortRecommandProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int recommandProductListSearchCounter = 0;
	public CatalogTokens searchRecommandProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CatalogTokens searchAllTextOfRecommandProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CatalogTokens rowsPerPageOfRecommandProductList(int rowsPerPage){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfRecommandProductList(int currentPageNumber){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  CatalogTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfLevelOneCategoryList(verb, value);	
		searchAllTextOfProductList(verb, value);	
		searchAllTextOfNewProductList(verb, value);	
		searchAllTextOfEditorPickProductList(verb, value);	
		searchAllTextOfTopRatedProductList(verb, value);	
		searchAllTextOfRecommandProductList(verb, value);	
		return this;
	}
}

