
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
			.withTargetList()
			.withRatingList()
			.withReviewList()
			.withBlogList();
	
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
	
	
		
	
	public  ProfileTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTargetList(verb, value);	
		searchAllTextOfRatingList(verb, value);	
		searchAllTextOfReviewList(verb, value);	
		searchAllTextOfBlogList(verb, value);	
		return this;
	}
}

