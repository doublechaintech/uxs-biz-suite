
package com.doublechaintech.uxs.levelncategory;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class LevelNCategoryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="levelNCategory";
	
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
	protected LevelNCategoryTokens(){
		//ensure not initialized outside the class
	}
	
	public LevelNCategoryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LevelNCategoryTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LevelNCategoryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LevelNCategoryTokens start(){
		return new LevelNCategoryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LevelNCategoryTokens allTokens(){
		
		return start()
			.withParentCategory()
			.withProductList()
			.withNewProductList()
			.withEditorPickProductList()
			.withTopRatedProductList()
			.withRecommandProductList();
	
	}
	public static LevelNCategoryTokens withoutListsTokens(){
		
		return start()
			.withParentCategory();
	
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

	protected static final String PARENTCATEGORY = "parentCategory";
	public String getParentCategory(){
		return PARENTCATEGORY;
	}
	public LevelNCategoryTokens withParentCategory(){		
		addSimpleOptions(PARENTCATEGORY);
		return this;
	}
	
	
	protected static final String PRODUCT_LIST = "productList";
	public String getProductList(){
		return PRODUCT_LIST;
	}
	public LevelNCategoryTokens withProductList(){		
		addSimpleOptions(PRODUCT_LIST);
		return this;
	}
	public LevelNCategoryTokens analyzeProductList(){		
		addSimpleOptions(PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_LIST+".anaylze");
	}
	public LevelNCategoryTokens extractMoreFromProductList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productListSortCounter = 0;
	public LevelNCategoryTokens sortProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_LIST,productListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productListSearchCounter = 0;
	public LevelNCategoryTokens searchProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	public LevelNCategoryTokens searchAllTextOfProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LevelNCategoryTokens rowsPerPageOfProductList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LevelNCategoryTokens currentPageNumberOfProductList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LevelNCategoryTokens retainColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public LevelNCategoryTokens excludeColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String NEW_PRODUCT_LIST = "newProductList";
	public String getNewProductList(){
		return NEW_PRODUCT_LIST;
	}
	public LevelNCategoryTokens withNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST);
		return this;
	}
	public LevelNCategoryTokens analyzeNewProductList(){		
		addSimpleOptions(NEW_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeNewProductListEnabled(){		
		
		return checkOptions(this.options(), NEW_PRODUCT_LIST+".anaylze");
	}
	public LevelNCategoryTokens extractMoreFromNewProductList(String idsSeperatedWithComma){		
		addSimpleOptions(NEW_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int newProductListSortCounter = 0;
	public LevelNCategoryTokens sortNewProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(NEW_PRODUCT_LIST,newProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int newProductListSearchCounter = 0;
	public LevelNCategoryTokens searchNewProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public LevelNCategoryTokens searchAllTextOfNewProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(NEW_PRODUCT_LIST,newProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LevelNCategoryTokens rowsPerPageOfNewProductList(int rowsPerPage){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LevelNCategoryTokens currentPageNumberOfNewProductList(int currentPageNumber){		
		addSimpleOptions(NEW_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LevelNCategoryTokens retainColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public LevelNCategoryTokens excludeColumnsOfNewProductList(String[] columns){		
		addSimpleOptions(NEW_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EDITOR_PICK_PRODUCT_LIST = "editorPickProductList";
	public String getEditorPickProductList(){
		return EDITOR_PICK_PRODUCT_LIST;
	}
	public LevelNCategoryTokens withEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST);
		return this;
	}
	public LevelNCategoryTokens analyzeEditorPickProductList(){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEditorPickProductListEnabled(){		
		
		return checkOptions(this.options(), EDITOR_PICK_PRODUCT_LIST+".anaylze");
	}
	public LevelNCategoryTokens extractMoreFromEditorPickProductList(String idsSeperatedWithComma){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int editorPickProductListSortCounter = 0;
	public LevelNCategoryTokens sortEditorPickProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int editorPickProductListSearchCounter = 0;
	public LevelNCategoryTokens searchEditorPickProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public LevelNCategoryTokens searchAllTextOfEditorPickProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(EDITOR_PICK_PRODUCT_LIST,editorPickProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LevelNCategoryTokens rowsPerPageOfEditorPickProductList(int rowsPerPage){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LevelNCategoryTokens currentPageNumberOfEditorPickProductList(int currentPageNumber){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LevelNCategoryTokens retainColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public LevelNCategoryTokens excludeColumnsOfEditorPickProductList(String[] columns){		
		addSimpleOptions(EDITOR_PICK_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TOP_RATED_PRODUCT_LIST = "topRatedProductList";
	public String getTopRatedProductList(){
		return TOP_RATED_PRODUCT_LIST;
	}
	public LevelNCategoryTokens withTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST);
		return this;
	}
	public LevelNCategoryTokens analyzeTopRatedProductList(){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTopRatedProductListEnabled(){		
		
		return checkOptions(this.options(), TOP_RATED_PRODUCT_LIST+".anaylze");
	}
	public LevelNCategoryTokens extractMoreFromTopRatedProductList(String idsSeperatedWithComma){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int topRatedProductListSortCounter = 0;
	public LevelNCategoryTokens sortTopRatedProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int topRatedProductListSearchCounter = 0;
	public LevelNCategoryTokens searchTopRatedProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public LevelNCategoryTokens searchAllTextOfTopRatedProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(TOP_RATED_PRODUCT_LIST,topRatedProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LevelNCategoryTokens rowsPerPageOfTopRatedProductList(int rowsPerPage){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LevelNCategoryTokens currentPageNumberOfTopRatedProductList(int currentPageNumber){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LevelNCategoryTokens retainColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public LevelNCategoryTokens excludeColumnsOfTopRatedProductList(String[] columns){		
		addSimpleOptions(TOP_RATED_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String RECOMMAND_PRODUCT_LIST = "recommandProductList";
	public String getRecommandProductList(){
		return RECOMMAND_PRODUCT_LIST;
	}
	public LevelNCategoryTokens withRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST);
		return this;
	}
	public LevelNCategoryTokens analyzeRecommandProductList(){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRecommandProductListEnabled(){		
		
		return checkOptions(this.options(), RECOMMAND_PRODUCT_LIST+".anaylze");
	}
	public LevelNCategoryTokens extractMoreFromRecommandProductList(String idsSeperatedWithComma){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int recommandProductListSortCounter = 0;
	public LevelNCategoryTokens sortRecommandProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int recommandProductListSearchCounter = 0;
	public LevelNCategoryTokens searchRecommandProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	public LevelNCategoryTokens searchAllTextOfRecommandProductList(String verb, String value){	
		String field = "id|name|origin|remark";
		addSearchMoreOptions(RECOMMAND_PRODUCT_LIST,recommandProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LevelNCategoryTokens rowsPerPageOfRecommandProductList(int rowsPerPage){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LevelNCategoryTokens currentPageNumberOfRecommandProductList(int currentPageNumber){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LevelNCategoryTokens retainColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public LevelNCategoryTokens excludeColumnsOfRecommandProductList(String[] columns){		
		addSimpleOptions(RECOMMAND_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  LevelNCategoryTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfProductList(verb, value);	
		searchAllTextOfNewProductList(verb, value);	
		searchAllTextOfEditorPickProductList(verb, value);	
		searchAllTextOfTopRatedProductList(verb, value);	
		searchAllTextOfRecommandProductList(verb, value);	
		return this;
	}
}

