
package com.doublechaintech.uxs.brand;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class BrandTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="brand";
	
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
	protected BrandTokens(){
		//ensure not initialized outside the class
	}
	
	public BrandTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static BrandTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected BrandTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static BrandTokens start(){
		return new BrandTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static BrandTokens allTokens(){
		
		return start()
			.withPlatform()
			.withProductList()
			.withNewProductList()
			.withEditorPickProductList()
			.withTopRatedProductList()
			.withRecommandProductList();
	
	}
	public static BrandTokens withoutListsTokens(){
		
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
	public BrandTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String PRODUCT_LIST = "productList";
	public String getProductList(){
		return PRODUCT_LIST;
	}
	public BrandTokens withProductList(){		
		addSimpleOptions(PRODUCT_LIST);
		return this;
	}
	public BrandTokens analyzeProductList(){		
		addSimpleOptions(PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_LIST+".anaylze");
	}
	public BrandTokens extractMoreFromProductList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productListSortCounter = 0;
	public BrandTokens sortProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_LIST,productListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productListSearchCounter = 0;
	public BrandTokens searchProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	public BrandTokens searchAllTextOfProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public BrandTokens rowsPerPageOfProductList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public BrandTokens currentPageNumberOfProductList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public BrandTokens retainColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public BrandTokens excludeColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String NEW_PRODUCT_LIST = "newProductList";
	public String getNewProductList(){
		return NEW_PRODUCT_LIST;
	}
	public BrandTokens withNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST);
		return this;
	}
	public BrandTokens analyzeNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeNewProductListEnabled(){		
		
		return checkOptions(this.options(), NEW_PRODUCT_LIST+".anaylze");
	}
	public BrandTokens extractMoreFromNewProductList(String idsSeperatedWithComma){		
		addSimpleOptions(NEW_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int newProductListSortCounter = 0;
	public BrandTokens sortNewProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(NEW_PRODUCT_LIST,newProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int newProductListSearchCounter = 0;
	public BrandTokens searchNewProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public BrandTokens searchAllTextOfNewProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public BrandTokens rowsPerPageOfNewProductList(int rowsPerPage){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public BrandTokens currentPageNumberOfNewProductList(int currentPageNumber){		
		addSimpleOptions(NEW_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public BrandTokens retainColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public BrandTokens excludeColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EDITOR_PICK_PRODUCT_LIST = "editorPickProductList";
	public String getEditorPickProductList(){
		return EDITOR_PICK_PRODUCT_LIST;
	}
	public BrandTokens withEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST);
		return this;
	}
	public BrandTokens analyzeEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEditorPickProductListEnabled(){		
		
		return checkOptions(this.options(), EDITOR_PICK_PRODUCT_LIST+".anaylze");
	}
	public BrandTokens extractMoreFromEditorPickProductList(String idsSeperatedWithComma){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int editorPickProductListSortCounter = 0;
	public BrandTokens sortEditorPickProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int editorPickProductListSearchCounter = 0;
	public BrandTokens searchEditorPickProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public BrandTokens searchAllTextOfEditorPickProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public BrandTokens rowsPerPageOfEditorPickProductList(int rowsPerPage){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public BrandTokens currentPageNumberOfEditorPickProductList(int currentPageNumber){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public BrandTokens retainColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public BrandTokens excludeColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TOP_RATED_PRODUCT_LIST = "topRatedProductList";
	public String getTopRatedProductList(){
		return TOP_RATED_PRODUCT_LIST;
	}
	public BrandTokens withTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST);
		return this;
	}
	public BrandTokens analyzeTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTopRatedProductListEnabled(){		
		
		return checkOptions(this.options(), TOP_RATED_PRODUCT_LIST+".anaylze");
	}
	public BrandTokens extractMoreFromTopRatedProductList(String idsSeperatedWithComma){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int topRatedProductListSortCounter = 0;
	public BrandTokens sortTopRatedProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int topRatedProductListSearchCounter = 0;
	public BrandTokens searchTopRatedProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public BrandTokens searchAllTextOfTopRatedProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public BrandTokens rowsPerPageOfTopRatedProductList(int rowsPerPage){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public BrandTokens currentPageNumberOfTopRatedProductList(int currentPageNumber){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public BrandTokens retainColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public BrandTokens excludeColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RECOMMAND_PRODUCT_LIST = "recommandProductList";
	public String getRecommandProductList(){
		return RECOMMAND_PRODUCT_LIST;
	}
	public BrandTokens withRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST);
		return this;
	}
	public BrandTokens analyzeRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRecommandProductListEnabled(){		
		
		return checkOptions(this.options(), RECOMMAND_PRODUCT_LIST+".anaylze");
	}
	public BrandTokens extractMoreFromRecommandProductList(String idsSeperatedWithComma){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int recommandProductListSortCounter = 0;
	public BrandTokens sortRecommandProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int recommandProductListSearchCounter = 0;
	public BrandTokens searchRecommandProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public BrandTokens searchAllTextOfRecommandProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public BrandTokens rowsPerPageOfRecommandProductList(int rowsPerPage){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public BrandTokens currentPageNumberOfRecommandProductList(int currentPageNumber){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public BrandTokens retainColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public BrandTokens excludeColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  BrandTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfProductList(verb, value);	
		searchAllTextOfNewProductList(verb, value);	
		searchAllTextOfEditorPickProductList(verb, value);	
		searchAllTextOfTopRatedProductList(verb, value);	
		searchAllTextOfRecommandProductList(verb, value);	
		return this;
	}
}

