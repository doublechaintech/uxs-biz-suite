
package com.doublechaintech.uxs.product;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class ProductTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="product";
	
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
	protected ProductTokens(){
		//ensure not initialized outside the class
	}
	
	public ProductTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProductTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProductTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProductTokens start(){
		return new ProductTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProductTokens allTokens(){
		
		return start()
			.withPlatform()
			.withRatingList()
			.withReviewList()
			.withBlogList();
	
	}
	public static ProductTokens withoutListsTokens(){
		
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
	public ProductTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String RATING_LIST = "ratingList";
	public String getRatingList(){
		return RATING_LIST;
	}
	public ProductTokens withRatingList(){		
		addSimpleOptions(RATING_LIST);
		return this;
	}
	public ProductTokens analyzeRatingList(){		
		addSimpleOptions(RATING_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRatingListEnabled(){		
		
		return checkOptions(this.options(), RATING_LIST+".anaylze");
	}
	public ProductTokens extractMoreFromRatingList(String idsSeperatedWithComma){		
		addSimpleOptions(RATING_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int ratingListSortCounter = 0;
	public ProductTokens sortRatingListWith(String field, String descOrAsc){		
		addSortMoreOptions(RATING_LIST,ratingListSortCounter++, field, descOrAsc);
		return this;
	}
	private int ratingListSearchCounter = 0;
	public ProductTokens searchRatingListWith(String field, String verb, String value){		
		addSearchMoreOptions(RATING_LIST,ratingListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProductTokens searchAllTextOfRatingList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(RATING_LIST,ratingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProductTokens rowsPerPageOfRatingList(int rowsPerPage){		
		addSimpleOptions(RATING_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProductTokens currentPageNumberOfRatingList(int currentPageNumber){		
		addSimpleOptions(RATING_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProductTokens retainColumnsOfRatingList(String[] columns){		
		addSimpleOptions(RATING_LIST+"RetainColumns",columns);
		return this;
	}
	public ProductTokens excludeColumnsOfRatingList(String[] columns){		
		addSimpleOptions(RATING_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String REVIEW_LIST = "reviewList";
	public String getReviewList(){
		return REVIEW_LIST;
	}
	public ProductTokens withReviewList(){		
		addSimpleOptions(REVIEW_LIST);
		return this;
	}
	public ProductTokens analyzeReviewList(){		
		addSimpleOptions(REVIEW_LIST+".anaylze");
		return this;
	}
	public boolean analyzeReviewListEnabled(){		
		
		return checkOptions(this.options(), REVIEW_LIST+".anaylze");
	}
	public ProductTokens extractMoreFromReviewList(String idsSeperatedWithComma){		
		addSimpleOptions(REVIEW_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int reviewListSortCounter = 0;
	public ProductTokens sortReviewListWith(String field, String descOrAsc){		
		addSortMoreOptions(REVIEW_LIST,reviewListSortCounter++, field, descOrAsc);
		return this;
	}
	private int reviewListSearchCounter = 0;
	public ProductTokens searchReviewListWith(String field, String verb, String value){		
		addSearchMoreOptions(REVIEW_LIST,reviewListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProductTokens searchAllTextOfReviewList(String verb, String value){	
		String field = "id|title|content";
		addSearchMoreOptions(REVIEW_LIST,reviewListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProductTokens rowsPerPageOfReviewList(int rowsPerPage){		
		addSimpleOptions(REVIEW_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProductTokens currentPageNumberOfReviewList(int currentPageNumber){		
		addSimpleOptions(REVIEW_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProductTokens retainColumnsOfReviewList(String[] columns){		
		addSimpleOptions(REVIEW_LIST+"RetainColumns",columns);
		return this;
	}
	public ProductTokens excludeColumnsOfReviewList(String[] columns){		
		addSimpleOptions(REVIEW_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String BLOG_LIST = "blogList";
	public String getBlogList(){
		return BLOG_LIST;
	}
	public ProductTokens withBlogList(){		
		addSimpleOptions(BLOG_LIST);
		return this;
	}
	public ProductTokens analyzeBlogList(){		
		addSimpleOptions(BLOG_LIST+".anaylze");
		return this;
	}
	public boolean analyzeBlogListEnabled(){		
		
		return checkOptions(this.options(), BLOG_LIST+".anaylze");
	}
	public ProductTokens extractMoreFromBlogList(String idsSeperatedWithComma){		
		addSimpleOptions(BLOG_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int blogListSortCounter = 0;
	public ProductTokens sortBlogListWith(String field, String descOrAsc){		
		addSortMoreOptions(BLOG_LIST,blogListSortCounter++, field, descOrAsc);
		return this;
	}
	private int blogListSearchCounter = 0;
	public ProductTokens searchBlogListWith(String field, String verb, String value){		
		addSearchMoreOptions(BLOG_LIST,blogListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProductTokens searchAllTextOfBlogList(String verb, String value){	
		String field = "id|title|content";
		addSearchMoreOptions(BLOG_LIST,blogListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProductTokens rowsPerPageOfBlogList(int rowsPerPage){		
		addSimpleOptions(BLOG_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProductTokens currentPageNumberOfBlogList(int currentPageNumber){		
		addSimpleOptions(BLOG_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProductTokens retainColumnsOfBlogList(String[] columns){		
		addSimpleOptions(BLOG_LIST+"RetainColumns",columns);
		return this;
	}
	public ProductTokens excludeColumnsOfBlogList(String[] columns){		
		addSimpleOptions(BLOG_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ProductTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfRatingList(verb, value);	
		searchAllTextOfReviewList(verb, value);	
		searchAllTextOfBlogList(verb, value);	
		return this;
	}
}

