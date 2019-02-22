
package com.doublechaintech.uxs.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.rating.Rating;
import com.doublechaintech.uxs.pricefilter.PriceFilter;
import com.doublechaintech.uxs.useralert.UserAlert;
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.brandfilter.BrandFilter;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;
import com.doublechaintech.uxs.blog.Blog;
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.categoryfilter.CategoryFilter;

@JsonSerialize(using = ProfileSerializer.class)
public class Profile extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_ALERT_LIST                          = "userAlertList"     ;
	public static final String TARGET_LIST                              = "targetList"        ;
	public static final String RATING_LIST                              = "ratingList"        ;
	public static final String REVIEW_LIST                              = "reviewList"        ;
	public static final String BLOG_LIST                                = "blogList"          ;
	public static final String BRAND_FILTER_LIST                        = "brandFilterList"   ;
	public static final String PRICE_FILTER_LIST                        = "priceFilterList"   ;
	public static final String CATEGORY_FILTER_LIST                     = "categoryFilterList";
	public static final String NEW_PRODUCT_LIST                         = "newProductList"    ;
	public static final String EDITOR_PICK_PRODUCT_LIST                 = "editorPickProductList";
	public static final String TOP_RATED_PRODUCT_LIST                   = "topRatedProductList";
	public static final String RECOMMAND_PRODUCT_LIST                   = "recommandProductList";

	public static final String INTERNAL_TYPE="Profile";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<UserAlert>	mUserAlertList      ;
	protected		SmartList<Target>   	mTargetList         ;
	protected		SmartList<Rating>   	mRatingList         ;
	protected		SmartList<Review>   	mReviewList         ;
	protected		SmartList<Blog>     	mBlogList           ;
	protected		SmartList<BrandFilter>	mBrandFilterList    ;
	protected		SmartList<PriceFilter>	mPriceFilterList    ;
	protected		SmartList<CategoryFilter>	mCategoryFilterList ;
	protected		SmartList<NewProduct>	mNewProductList     ;
	protected		SmartList<EditorPickProduct>	mEditorPickProductList;
	protected		SmartList<TopRatedProduct>	mTopRatedProductList;
	protected		SmartList<RecommandProduct>	mRecommandProductList;
	
		
	public 	Profile(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Profile(String name, Platform platform)
	{
		setName(name);
		setPlatform(platform);

		this.mUserAlertList = new SmartList<UserAlert>();
		this.mTargetList = new SmartList<Target>();
		this.mRatingList = new SmartList<Rating>();
		this.mReviewList = new SmartList<Review>();
		this.mBlogList = new SmartList<Blog>();
		this.mBrandFilterList = new SmartList<BrandFilter>();
		this.mPriceFilterList = new SmartList<PriceFilter>();
		this.mCategoryFilterList = new SmartList<CategoryFilter>();
		this.mNewProductList = new SmartList<NewProduct>();
		this.mEditorPickProductList = new SmartList<EditorPickProduct>();
		this.mTopRatedProductList = new SmartList<TopRatedProduct>();
		this.mRecommandProductList = new SmartList<RecommandProduct>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Profile updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Profile updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Profile updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Profile updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<UserAlert> getUserAlertList(){
		if(this.mUserAlertList == null){
			this.mUserAlertList = new SmartList<UserAlert>();
			this.mUserAlertList.setListInternalName (USER_ALERT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mUserAlertList;	
	}
	public  void setUserAlertList(SmartList<UserAlert> userAlertList){
		for( UserAlert userAlert:userAlertList){
			userAlert.setProfile(this);
		}

		this.mUserAlertList = userAlertList;
		this.mUserAlertList.setListInternalName (USER_ALERT_LIST );
		
	}
	
	public  void addUserAlert(UserAlert userAlert){
		userAlert.setProfile(this);
		getUserAlertList().add(userAlert);
	}
	public  void addUserAlertList(SmartList<UserAlert> userAlertList){
		for( UserAlert userAlert:userAlertList){
			userAlert.setProfile(this);
		}
		getUserAlertList().addAll(userAlertList);
	}
	public  void mergeUserAlertList(SmartList<UserAlert> userAlertList){
		if(userAlertList==null){
			return;
		}
		if(userAlertList.isEmpty()){
			return;
		}
		addUserAlertList( userAlertList );
		
	}
	public  UserAlert removeUserAlert(UserAlert userAlertIndex){
		
		int index = getUserAlertList().indexOf(userAlertIndex);
        if(index < 0){
        	String message = "UserAlert("+userAlertIndex.getId()+") with version='"+userAlertIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        UserAlert userAlert = getUserAlertList().get(index);        
        // userAlert.clearProfile(); //disconnect with Profile
        userAlert.clearFromAll(); //disconnect with Profile
		
		boolean result = getUserAlertList().planToRemove(userAlert);
        if(!result){
        	String message = "UserAlert("+userAlertIndex.getId()+") with version='"+userAlertIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return userAlert;
        
	
	}
	//断舍离
	public  void breakWithUserAlert(UserAlert userAlert){
		
		if(userAlert == null){
			return;
		}
		userAlert.setProfile(null);
		//getUserAlertList().remove();
	
	}
	
	public  boolean hasUserAlert(UserAlert userAlert){
	
		return getUserAlertList().contains(userAlert);
  
	}
	
	public void copyUserAlertFrom(UserAlert userAlert) {

		UserAlert userAlertInList = findTheUserAlert(userAlert);
		UserAlert newUserAlert = new UserAlert();
		userAlertInList.copyTo(newUserAlert);
		newUserAlert.setVersion(0);//will trigger copy
		getUserAlertList().add(newUserAlert);
		addItemToFlexiableObject(COPIED_CHILD, newUserAlert);
	}
	
	public  UserAlert findTheUserAlert(UserAlert userAlert){
		
		int index =  getUserAlertList().indexOf(userAlert);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "UserAlert("+userAlert.getId()+") with version='"+userAlert.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getUserAlertList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUserAlertList(){
		getUserAlertList().clear();
	}
	
	
	


	public  SmartList<Target> getTargetList(){
		if(this.mTargetList == null){
			this.mTargetList = new SmartList<Target>();
			this.mTargetList.setListInternalName (TARGET_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTargetList;	
	}
	public  void setTargetList(SmartList<Target> targetList){
		for( Target target:targetList){
			target.setProfile(this);
		}

		this.mTargetList = targetList;
		this.mTargetList.setListInternalName (TARGET_LIST );
		
	}
	
	public  void addTarget(Target target){
		target.setProfile(this);
		getTargetList().add(target);
	}
	public  void addTargetList(SmartList<Target> targetList){
		for( Target target:targetList){
			target.setProfile(this);
		}
		getTargetList().addAll(targetList);
	}
	public  void mergeTargetList(SmartList<Target> targetList){
		if(targetList==null){
			return;
		}
		if(targetList.isEmpty()){
			return;
		}
		addTargetList( targetList );
		
	}
	public  Target removeTarget(Target targetIndex){
		
		int index = getTargetList().indexOf(targetIndex);
        if(index < 0){
        	String message = "Target("+targetIndex.getId()+") with version='"+targetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Target target = getTargetList().get(index);        
        // target.clearProfile(); //disconnect with Profile
        target.clearFromAll(); //disconnect with Profile
		
		boolean result = getTargetList().planToRemove(target);
        if(!result){
        	String message = "Target("+targetIndex.getId()+") with version='"+targetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return target;
        
	
	}
	//断舍离
	public  void breakWithTarget(Target target){
		
		if(target == null){
			return;
		}
		target.setProfile(null);
		//getTargetList().remove();
	
	}
	
	public  boolean hasTarget(Target target){
	
		return getTargetList().contains(target);
  
	}
	
	public void copyTargetFrom(Target target) {

		Target targetInList = findTheTarget(target);
		Target newTarget = new Target();
		targetInList.copyTo(newTarget);
		newTarget.setVersion(0);//will trigger copy
		getTargetList().add(newTarget);
		addItemToFlexiableObject(COPIED_CHILD, newTarget);
	}
	
	public  Target findTheTarget(Target target){
		
		int index =  getTargetList().indexOf(target);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Target("+target.getId()+") with version='"+target.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTargetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTargetList(){
		getTargetList().clear();
	}
	
	
	


	public  SmartList<Rating> getRatingList(){
		if(this.mRatingList == null){
			this.mRatingList = new SmartList<Rating>();
			this.mRatingList.setListInternalName (RATING_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRatingList;	
	}
	public  void setRatingList(SmartList<Rating> ratingList){
		for( Rating rating:ratingList){
			rating.setUser(this);
		}

		this.mRatingList = ratingList;
		this.mRatingList.setListInternalName (RATING_LIST );
		
	}
	
	public  void addRating(Rating rating){
		rating.setUser(this);
		getRatingList().add(rating);
	}
	public  void addRatingList(SmartList<Rating> ratingList){
		for( Rating rating:ratingList){
			rating.setUser(this);
		}
		getRatingList().addAll(ratingList);
	}
	public  void mergeRatingList(SmartList<Rating> ratingList){
		if(ratingList==null){
			return;
		}
		if(ratingList.isEmpty()){
			return;
		}
		addRatingList( ratingList );
		
	}
	public  Rating removeRating(Rating ratingIndex){
		
		int index = getRatingList().indexOf(ratingIndex);
        if(index < 0){
        	String message = "Rating("+ratingIndex.getId()+") with version='"+ratingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Rating rating = getRatingList().get(index);        
        // rating.clearUser(); //disconnect with User
        rating.clearFromAll(); //disconnect with User
		
		boolean result = getRatingList().planToRemove(rating);
        if(!result){
        	String message = "Rating("+ratingIndex.getId()+") with version='"+ratingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return rating;
        
	
	}
	//断舍离
	public  void breakWithRating(Rating rating){
		
		if(rating == null){
			return;
		}
		rating.setUser(null);
		//getRatingList().remove();
	
	}
	
	public  boolean hasRating(Rating rating){
	
		return getRatingList().contains(rating);
  
	}
	
	public void copyRatingFrom(Rating rating) {

		Rating ratingInList = findTheRating(rating);
		Rating newRating = new Rating();
		ratingInList.copyTo(newRating);
		newRating.setVersion(0);//will trigger copy
		getRatingList().add(newRating);
		addItemToFlexiableObject(COPIED_CHILD, newRating);
	}
	
	public  Rating findTheRating(Rating rating){
		
		int index =  getRatingList().indexOf(rating);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Rating("+rating.getId()+") with version='"+rating.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRatingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRatingList(){
		getRatingList().clear();
	}
	
	
	


	public  SmartList<Review> getReviewList(){
		if(this.mReviewList == null){
			this.mReviewList = new SmartList<Review>();
			this.mReviewList.setListInternalName (REVIEW_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mReviewList;	
	}
	public  void setReviewList(SmartList<Review> reviewList){
		for( Review review:reviewList){
			review.setUser(this);
		}

		this.mReviewList = reviewList;
		this.mReviewList.setListInternalName (REVIEW_LIST );
		
	}
	
	public  void addReview(Review review){
		review.setUser(this);
		getReviewList().add(review);
	}
	public  void addReviewList(SmartList<Review> reviewList){
		for( Review review:reviewList){
			review.setUser(this);
		}
		getReviewList().addAll(reviewList);
	}
	public  void mergeReviewList(SmartList<Review> reviewList){
		if(reviewList==null){
			return;
		}
		if(reviewList.isEmpty()){
			return;
		}
		addReviewList( reviewList );
		
	}
	public  Review removeReview(Review reviewIndex){
		
		int index = getReviewList().indexOf(reviewIndex);
        if(index < 0){
        	String message = "Review("+reviewIndex.getId()+") with version='"+reviewIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Review review = getReviewList().get(index);        
        // review.clearUser(); //disconnect with User
        review.clearFromAll(); //disconnect with User
		
		boolean result = getReviewList().planToRemove(review);
        if(!result){
        	String message = "Review("+reviewIndex.getId()+") with version='"+reviewIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return review;
        
	
	}
	//断舍离
	public  void breakWithReview(Review review){
		
		if(review == null){
			return;
		}
		review.setUser(null);
		//getReviewList().remove();
	
	}
	
	public  boolean hasReview(Review review){
	
		return getReviewList().contains(review);
  
	}
	
	public void copyReviewFrom(Review review) {

		Review reviewInList = findTheReview(review);
		Review newReview = new Review();
		reviewInList.copyTo(newReview);
		newReview.setVersion(0);//will trigger copy
		getReviewList().add(newReview);
		addItemToFlexiableObject(COPIED_CHILD, newReview);
	}
	
	public  Review findTheReview(Review review){
		
		int index =  getReviewList().indexOf(review);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Review("+review.getId()+") with version='"+review.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getReviewList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpReviewList(){
		getReviewList().clear();
	}
	
	
	


	public  SmartList<Blog> getBlogList(){
		if(this.mBlogList == null){
			this.mBlogList = new SmartList<Blog>();
			this.mBlogList.setListInternalName (BLOG_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mBlogList;	
	}
	public  void setBlogList(SmartList<Blog> blogList){
		for( Blog blog:blogList){
			blog.setUser(this);
		}

		this.mBlogList = blogList;
		this.mBlogList.setListInternalName (BLOG_LIST );
		
	}
	
	public  void addBlog(Blog blog){
		blog.setUser(this);
		getBlogList().add(blog);
	}
	public  void addBlogList(SmartList<Blog> blogList){
		for( Blog blog:blogList){
			blog.setUser(this);
		}
		getBlogList().addAll(blogList);
	}
	public  void mergeBlogList(SmartList<Blog> blogList){
		if(blogList==null){
			return;
		}
		if(blogList.isEmpty()){
			return;
		}
		addBlogList( blogList );
		
	}
	public  Blog removeBlog(Blog blogIndex){
		
		int index = getBlogList().indexOf(blogIndex);
        if(index < 0){
        	String message = "Blog("+blogIndex.getId()+") with version='"+blogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Blog blog = getBlogList().get(index);        
        // blog.clearUser(); //disconnect with User
        blog.clearFromAll(); //disconnect with User
		
		boolean result = getBlogList().planToRemove(blog);
        if(!result){
        	String message = "Blog("+blogIndex.getId()+") with version='"+blogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return blog;
        
	
	}
	//断舍离
	public  void breakWithBlog(Blog blog){
		
		if(blog == null){
			return;
		}
		blog.setUser(null);
		//getBlogList().remove();
	
	}
	
	public  boolean hasBlog(Blog blog){
	
		return getBlogList().contains(blog);
  
	}
	
	public void copyBlogFrom(Blog blog) {

		Blog blogInList = findTheBlog(blog);
		Blog newBlog = new Blog();
		blogInList.copyTo(newBlog);
		newBlog.setVersion(0);//will trigger copy
		getBlogList().add(newBlog);
		addItemToFlexiableObject(COPIED_CHILD, newBlog);
	}
	
	public  Blog findTheBlog(Blog blog){
		
		int index =  getBlogList().indexOf(blog);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Blog("+blog.getId()+") with version='"+blog.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getBlogList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpBlogList(){
		getBlogList().clear();
	}
	
	
	


	public  SmartList<BrandFilter> getBrandFilterList(){
		if(this.mBrandFilterList == null){
			this.mBrandFilterList = new SmartList<BrandFilter>();
			this.mBrandFilterList.setListInternalName (BRAND_FILTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mBrandFilterList;	
	}
	public  void setBrandFilterList(SmartList<BrandFilter> brandFilterList){
		for( BrandFilter brandFilter:brandFilterList){
			brandFilter.setProfile(this);
		}

		this.mBrandFilterList = brandFilterList;
		this.mBrandFilterList.setListInternalName (BRAND_FILTER_LIST );
		
	}
	
	public  void addBrandFilter(BrandFilter brandFilter){
		brandFilter.setProfile(this);
		getBrandFilterList().add(brandFilter);
	}
	public  void addBrandFilterList(SmartList<BrandFilter> brandFilterList){
		for( BrandFilter brandFilter:brandFilterList){
			brandFilter.setProfile(this);
		}
		getBrandFilterList().addAll(brandFilterList);
	}
	public  void mergeBrandFilterList(SmartList<BrandFilter> brandFilterList){
		if(brandFilterList==null){
			return;
		}
		if(brandFilterList.isEmpty()){
			return;
		}
		addBrandFilterList( brandFilterList );
		
	}
	public  BrandFilter removeBrandFilter(BrandFilter brandFilterIndex){
		
		int index = getBrandFilterList().indexOf(brandFilterIndex);
        if(index < 0){
        	String message = "BrandFilter("+brandFilterIndex.getId()+") with version='"+brandFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        BrandFilter brandFilter = getBrandFilterList().get(index);        
        // brandFilter.clearProfile(); //disconnect with Profile
        brandFilter.clearFromAll(); //disconnect with Profile
		
		boolean result = getBrandFilterList().planToRemove(brandFilter);
        if(!result){
        	String message = "BrandFilter("+brandFilterIndex.getId()+") with version='"+brandFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return brandFilter;
        
	
	}
	//断舍离
	public  void breakWithBrandFilter(BrandFilter brandFilter){
		
		if(brandFilter == null){
			return;
		}
		brandFilter.setProfile(null);
		//getBrandFilterList().remove();
	
	}
	
	public  boolean hasBrandFilter(BrandFilter brandFilter){
	
		return getBrandFilterList().contains(brandFilter);
  
	}
	
	public void copyBrandFilterFrom(BrandFilter brandFilter) {

		BrandFilter brandFilterInList = findTheBrandFilter(brandFilter);
		BrandFilter newBrandFilter = new BrandFilter();
		brandFilterInList.copyTo(newBrandFilter);
		newBrandFilter.setVersion(0);//will trigger copy
		getBrandFilterList().add(newBrandFilter);
		addItemToFlexiableObject(COPIED_CHILD, newBrandFilter);
	}
	
	public  BrandFilter findTheBrandFilter(BrandFilter brandFilter){
		
		int index =  getBrandFilterList().indexOf(brandFilter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "BrandFilter("+brandFilter.getId()+") with version='"+brandFilter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getBrandFilterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpBrandFilterList(){
		getBrandFilterList().clear();
	}
	
	
	


	public  SmartList<PriceFilter> getPriceFilterList(){
		if(this.mPriceFilterList == null){
			this.mPriceFilterList = new SmartList<PriceFilter>();
			this.mPriceFilterList.setListInternalName (PRICE_FILTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPriceFilterList;	
	}
	public  void setPriceFilterList(SmartList<PriceFilter> priceFilterList){
		for( PriceFilter priceFilter:priceFilterList){
			priceFilter.setProfile(this);
		}

		this.mPriceFilterList = priceFilterList;
		this.mPriceFilterList.setListInternalName (PRICE_FILTER_LIST );
		
	}
	
	public  void addPriceFilter(PriceFilter priceFilter){
		priceFilter.setProfile(this);
		getPriceFilterList().add(priceFilter);
	}
	public  void addPriceFilterList(SmartList<PriceFilter> priceFilterList){
		for( PriceFilter priceFilter:priceFilterList){
			priceFilter.setProfile(this);
		}
		getPriceFilterList().addAll(priceFilterList);
	}
	public  void mergePriceFilterList(SmartList<PriceFilter> priceFilterList){
		if(priceFilterList==null){
			return;
		}
		if(priceFilterList.isEmpty()){
			return;
		}
		addPriceFilterList( priceFilterList );
		
	}
	public  PriceFilter removePriceFilter(PriceFilter priceFilterIndex){
		
		int index = getPriceFilterList().indexOf(priceFilterIndex);
        if(index < 0){
        	String message = "PriceFilter("+priceFilterIndex.getId()+") with version='"+priceFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PriceFilter priceFilter = getPriceFilterList().get(index);        
        // priceFilter.clearProfile(); //disconnect with Profile
        priceFilter.clearFromAll(); //disconnect with Profile
		
		boolean result = getPriceFilterList().planToRemove(priceFilter);
        if(!result){
        	String message = "PriceFilter("+priceFilterIndex.getId()+") with version='"+priceFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return priceFilter;
        
	
	}
	//断舍离
	public  void breakWithPriceFilter(PriceFilter priceFilter){
		
		if(priceFilter == null){
			return;
		}
		priceFilter.setProfile(null);
		//getPriceFilterList().remove();
	
	}
	
	public  boolean hasPriceFilter(PriceFilter priceFilter){
	
		return getPriceFilterList().contains(priceFilter);
  
	}
	
	public void copyPriceFilterFrom(PriceFilter priceFilter) {

		PriceFilter priceFilterInList = findThePriceFilter(priceFilter);
		PriceFilter newPriceFilter = new PriceFilter();
		priceFilterInList.copyTo(newPriceFilter);
		newPriceFilter.setVersion(0);//will trigger copy
		getPriceFilterList().add(newPriceFilter);
		addItemToFlexiableObject(COPIED_CHILD, newPriceFilter);
	}
	
	public  PriceFilter findThePriceFilter(PriceFilter priceFilter){
		
		int index =  getPriceFilterList().indexOf(priceFilter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PriceFilter("+priceFilter.getId()+") with version='"+priceFilter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPriceFilterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPriceFilterList(){
		getPriceFilterList().clear();
	}
	
	
	


	public  SmartList<CategoryFilter> getCategoryFilterList(){
		if(this.mCategoryFilterList == null){
			this.mCategoryFilterList = new SmartList<CategoryFilter>();
			this.mCategoryFilterList.setListInternalName (CATEGORY_FILTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCategoryFilterList;	
	}
	public  void setCategoryFilterList(SmartList<CategoryFilter> categoryFilterList){
		for( CategoryFilter categoryFilter:categoryFilterList){
			categoryFilter.setProfile(this);
		}

		this.mCategoryFilterList = categoryFilterList;
		this.mCategoryFilterList.setListInternalName (CATEGORY_FILTER_LIST );
		
	}
	
	public  void addCategoryFilter(CategoryFilter categoryFilter){
		categoryFilter.setProfile(this);
		getCategoryFilterList().add(categoryFilter);
	}
	public  void addCategoryFilterList(SmartList<CategoryFilter> categoryFilterList){
		for( CategoryFilter categoryFilter:categoryFilterList){
			categoryFilter.setProfile(this);
		}
		getCategoryFilterList().addAll(categoryFilterList);
	}
	public  void mergeCategoryFilterList(SmartList<CategoryFilter> categoryFilterList){
		if(categoryFilterList==null){
			return;
		}
		if(categoryFilterList.isEmpty()){
			return;
		}
		addCategoryFilterList( categoryFilterList );
		
	}
	public  CategoryFilter removeCategoryFilter(CategoryFilter categoryFilterIndex){
		
		int index = getCategoryFilterList().indexOf(categoryFilterIndex);
        if(index < 0){
        	String message = "CategoryFilter("+categoryFilterIndex.getId()+") with version='"+categoryFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        CategoryFilter categoryFilter = getCategoryFilterList().get(index);        
        // categoryFilter.clearProfile(); //disconnect with Profile
        categoryFilter.clearFromAll(); //disconnect with Profile
		
		boolean result = getCategoryFilterList().planToRemove(categoryFilter);
        if(!result){
        	String message = "CategoryFilter("+categoryFilterIndex.getId()+") with version='"+categoryFilterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return categoryFilter;
        
	
	}
	//断舍离
	public  void breakWithCategoryFilter(CategoryFilter categoryFilter){
		
		if(categoryFilter == null){
			return;
		}
		categoryFilter.setProfile(null);
		//getCategoryFilterList().remove();
	
	}
	
	public  boolean hasCategoryFilter(CategoryFilter categoryFilter){
	
		return getCategoryFilterList().contains(categoryFilter);
  
	}
	
	public void copyCategoryFilterFrom(CategoryFilter categoryFilter) {

		CategoryFilter categoryFilterInList = findTheCategoryFilter(categoryFilter);
		CategoryFilter newCategoryFilter = new CategoryFilter();
		categoryFilterInList.copyTo(newCategoryFilter);
		newCategoryFilter.setVersion(0);//will trigger copy
		getCategoryFilterList().add(newCategoryFilter);
		addItemToFlexiableObject(COPIED_CHILD, newCategoryFilter);
	}
	
	public  CategoryFilter findTheCategoryFilter(CategoryFilter categoryFilter){
		
		int index =  getCategoryFilterList().indexOf(categoryFilter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "CategoryFilter("+categoryFilter.getId()+") with version='"+categoryFilter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCategoryFilterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCategoryFilterList(){
		getCategoryFilterList().clear();
	}
	
	
	


	public  SmartList<NewProduct> getNewProductList(){
		if(this.mNewProductList == null){
			this.mNewProductList = new SmartList<NewProduct>();
			this.mNewProductList.setListInternalName (NEW_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mNewProductList;	
	}
	public  void setNewProductList(SmartList<NewProduct> newProductList){
		for( NewProduct newProduct:newProductList){
			newProduct.setProfile(this);
		}

		this.mNewProductList = newProductList;
		this.mNewProductList.setListInternalName (NEW_PRODUCT_LIST );
		
	}
	
	public  void addNewProduct(NewProduct newProduct){
		newProduct.setProfile(this);
		getNewProductList().add(newProduct);
	}
	public  void addNewProductList(SmartList<NewProduct> newProductList){
		for( NewProduct newProduct:newProductList){
			newProduct.setProfile(this);
		}
		getNewProductList().addAll(newProductList);
	}
	public  void mergeNewProductList(SmartList<NewProduct> newProductList){
		if(newProductList==null){
			return;
		}
		if(newProductList.isEmpty()){
			return;
		}
		addNewProductList( newProductList );
		
	}
	public  NewProduct removeNewProduct(NewProduct newProductIndex){
		
		int index = getNewProductList().indexOf(newProductIndex);
        if(index < 0){
        	String message = "NewProduct("+newProductIndex.getId()+") with version='"+newProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        NewProduct newProduct = getNewProductList().get(index);        
        // newProduct.clearProfile(); //disconnect with Profile
        newProduct.clearFromAll(); //disconnect with Profile
		
		boolean result = getNewProductList().planToRemove(newProduct);
        if(!result){
        	String message = "NewProduct("+newProductIndex.getId()+") with version='"+newProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return newProduct;
        
	
	}
	//断舍离
	public  void breakWithNewProduct(NewProduct newProduct){
		
		if(newProduct == null){
			return;
		}
		newProduct.setProfile(null);
		//getNewProductList().remove();
	
	}
	
	public  boolean hasNewProduct(NewProduct newProduct){
	
		return getNewProductList().contains(newProduct);
  
	}
	
	public void copyNewProductFrom(NewProduct newProduct) {

		NewProduct newProductInList = findTheNewProduct(newProduct);
		NewProduct newNewProduct = new NewProduct();
		newProductInList.copyTo(newNewProduct);
		newNewProduct.setVersion(0);//will trigger copy
		getNewProductList().add(newNewProduct);
		addItemToFlexiableObject(COPIED_CHILD, newNewProduct);
	}
	
	public  NewProduct findTheNewProduct(NewProduct newProduct){
		
		int index =  getNewProductList().indexOf(newProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "NewProduct("+newProduct.getId()+") with version='"+newProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getNewProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpNewProductList(){
		getNewProductList().clear();
	}
	
	
	


	public  SmartList<EditorPickProduct> getEditorPickProductList(){
		if(this.mEditorPickProductList == null){
			this.mEditorPickProductList = new SmartList<EditorPickProduct>();
			this.mEditorPickProductList.setListInternalName (EDITOR_PICK_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEditorPickProductList;	
	}
	public  void setEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		for( EditorPickProduct editorPickProduct:editorPickProductList){
			editorPickProduct.setProfile(this);
		}

		this.mEditorPickProductList = editorPickProductList;
		this.mEditorPickProductList.setListInternalName (EDITOR_PICK_PRODUCT_LIST );
		
	}
	
	public  void addEditorPickProduct(EditorPickProduct editorPickProduct){
		editorPickProduct.setProfile(this);
		getEditorPickProductList().add(editorPickProduct);
	}
	public  void addEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		for( EditorPickProduct editorPickProduct:editorPickProductList){
			editorPickProduct.setProfile(this);
		}
		getEditorPickProductList().addAll(editorPickProductList);
	}
	public  void mergeEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		if(editorPickProductList==null){
			return;
		}
		if(editorPickProductList.isEmpty()){
			return;
		}
		addEditorPickProductList( editorPickProductList );
		
	}
	public  EditorPickProduct removeEditorPickProduct(EditorPickProduct editorPickProductIndex){
		
		int index = getEditorPickProductList().indexOf(editorPickProductIndex);
        if(index < 0){
        	String message = "EditorPickProduct("+editorPickProductIndex.getId()+") with version='"+editorPickProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EditorPickProduct editorPickProduct = getEditorPickProductList().get(index);        
        // editorPickProduct.clearProfile(); //disconnect with Profile
        editorPickProduct.clearFromAll(); //disconnect with Profile
		
		boolean result = getEditorPickProductList().planToRemove(editorPickProduct);
        if(!result){
        	String message = "EditorPickProduct("+editorPickProductIndex.getId()+") with version='"+editorPickProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return editorPickProduct;
        
	
	}
	//断舍离
	public  void breakWithEditorPickProduct(EditorPickProduct editorPickProduct){
		
		if(editorPickProduct == null){
			return;
		}
		editorPickProduct.setProfile(null);
		//getEditorPickProductList().remove();
	
	}
	
	public  boolean hasEditorPickProduct(EditorPickProduct editorPickProduct){
	
		return getEditorPickProductList().contains(editorPickProduct);
  
	}
	
	public void copyEditorPickProductFrom(EditorPickProduct editorPickProduct) {

		EditorPickProduct editorPickProductInList = findTheEditorPickProduct(editorPickProduct);
		EditorPickProduct newEditorPickProduct = new EditorPickProduct();
		editorPickProductInList.copyTo(newEditorPickProduct);
		newEditorPickProduct.setVersion(0);//will trigger copy
		getEditorPickProductList().add(newEditorPickProduct);
		addItemToFlexiableObject(COPIED_CHILD, newEditorPickProduct);
	}
	
	public  EditorPickProduct findTheEditorPickProduct(EditorPickProduct editorPickProduct){
		
		int index =  getEditorPickProductList().indexOf(editorPickProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EditorPickProduct("+editorPickProduct.getId()+") with version='"+editorPickProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEditorPickProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEditorPickProductList(){
		getEditorPickProductList().clear();
	}
	
	
	


	public  SmartList<TopRatedProduct> getTopRatedProductList(){
		if(this.mTopRatedProductList == null){
			this.mTopRatedProductList = new SmartList<TopRatedProduct>();
			this.mTopRatedProductList.setListInternalName (TOP_RATED_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTopRatedProductList;	
	}
	public  void setTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		for( TopRatedProduct topRatedProduct:topRatedProductList){
			topRatedProduct.setProfile(this);
		}

		this.mTopRatedProductList = topRatedProductList;
		this.mTopRatedProductList.setListInternalName (TOP_RATED_PRODUCT_LIST );
		
	}
	
	public  void addTopRatedProduct(TopRatedProduct topRatedProduct){
		topRatedProduct.setProfile(this);
		getTopRatedProductList().add(topRatedProduct);
	}
	public  void addTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		for( TopRatedProduct topRatedProduct:topRatedProductList){
			topRatedProduct.setProfile(this);
		}
		getTopRatedProductList().addAll(topRatedProductList);
	}
	public  void mergeTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		if(topRatedProductList==null){
			return;
		}
		if(topRatedProductList.isEmpty()){
			return;
		}
		addTopRatedProductList( topRatedProductList );
		
	}
	public  TopRatedProduct removeTopRatedProduct(TopRatedProduct topRatedProductIndex){
		
		int index = getTopRatedProductList().indexOf(topRatedProductIndex);
        if(index < 0){
        	String message = "TopRatedProduct("+topRatedProductIndex.getId()+") with version='"+topRatedProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TopRatedProduct topRatedProduct = getTopRatedProductList().get(index);        
        // topRatedProduct.clearProfile(); //disconnect with Profile
        topRatedProduct.clearFromAll(); //disconnect with Profile
		
		boolean result = getTopRatedProductList().planToRemove(topRatedProduct);
        if(!result){
        	String message = "TopRatedProduct("+topRatedProductIndex.getId()+") with version='"+topRatedProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return topRatedProduct;
        
	
	}
	//断舍离
	public  void breakWithTopRatedProduct(TopRatedProduct topRatedProduct){
		
		if(topRatedProduct == null){
			return;
		}
		topRatedProduct.setProfile(null);
		//getTopRatedProductList().remove();
	
	}
	
	public  boolean hasTopRatedProduct(TopRatedProduct topRatedProduct){
	
		return getTopRatedProductList().contains(topRatedProduct);
  
	}
	
	public void copyTopRatedProductFrom(TopRatedProduct topRatedProduct) {

		TopRatedProduct topRatedProductInList = findTheTopRatedProduct(topRatedProduct);
		TopRatedProduct newTopRatedProduct = new TopRatedProduct();
		topRatedProductInList.copyTo(newTopRatedProduct);
		newTopRatedProduct.setVersion(0);//will trigger copy
		getTopRatedProductList().add(newTopRatedProduct);
		addItemToFlexiableObject(COPIED_CHILD, newTopRatedProduct);
	}
	
	public  TopRatedProduct findTheTopRatedProduct(TopRatedProduct topRatedProduct){
		
		int index =  getTopRatedProductList().indexOf(topRatedProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TopRatedProduct("+topRatedProduct.getId()+") with version='"+topRatedProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTopRatedProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTopRatedProductList(){
		getTopRatedProductList().clear();
	}
	
	
	


	public  SmartList<RecommandProduct> getRecommandProductList(){
		if(this.mRecommandProductList == null){
			this.mRecommandProductList = new SmartList<RecommandProduct>();
			this.mRecommandProductList.setListInternalName (RECOMMAND_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRecommandProductList;	
	}
	public  void setRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		for( RecommandProduct recommandProduct:recommandProductList){
			recommandProduct.setProfile(this);
		}

		this.mRecommandProductList = recommandProductList;
		this.mRecommandProductList.setListInternalName (RECOMMAND_PRODUCT_LIST );
		
	}
	
	public  void addRecommandProduct(RecommandProduct recommandProduct){
		recommandProduct.setProfile(this);
		getRecommandProductList().add(recommandProduct);
	}
	public  void addRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		for( RecommandProduct recommandProduct:recommandProductList){
			recommandProduct.setProfile(this);
		}
		getRecommandProductList().addAll(recommandProductList);
	}
	public  void mergeRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		if(recommandProductList==null){
			return;
		}
		if(recommandProductList.isEmpty()){
			return;
		}
		addRecommandProductList( recommandProductList );
		
	}
	public  RecommandProduct removeRecommandProduct(RecommandProduct recommandProductIndex){
		
		int index = getRecommandProductList().indexOf(recommandProductIndex);
        if(index < 0){
        	String message = "RecommandProduct("+recommandProductIndex.getId()+") with version='"+recommandProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RecommandProduct recommandProduct = getRecommandProductList().get(index);        
        // recommandProduct.clearProfile(); //disconnect with Profile
        recommandProduct.clearFromAll(); //disconnect with Profile
		
		boolean result = getRecommandProductList().planToRemove(recommandProduct);
        if(!result){
        	String message = "RecommandProduct("+recommandProductIndex.getId()+") with version='"+recommandProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return recommandProduct;
        
	
	}
	//断舍离
	public  void breakWithRecommandProduct(RecommandProduct recommandProduct){
		
		if(recommandProduct == null){
			return;
		}
		recommandProduct.setProfile(null);
		//getRecommandProductList().remove();
	
	}
	
	public  boolean hasRecommandProduct(RecommandProduct recommandProduct){
	
		return getRecommandProductList().contains(recommandProduct);
  
	}
	
	public void copyRecommandProductFrom(RecommandProduct recommandProduct) {

		RecommandProduct recommandProductInList = findTheRecommandProduct(recommandProduct);
		RecommandProduct newRecommandProduct = new RecommandProduct();
		recommandProductInList.copyTo(newRecommandProduct);
		newRecommandProduct.setVersion(0);//will trigger copy
		getRecommandProductList().add(newRecommandProduct);
		addItemToFlexiableObject(COPIED_CHILD, newRecommandProduct);
	}
	
	public  RecommandProduct findTheRecommandProduct(RecommandProduct recommandProduct){
		
		int index =  getRecommandProductList().indexOf(recommandProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RecommandProduct("+recommandProduct.getId()+") with version='"+recommandProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRecommandProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRecommandProductList(){
		getRecommandProductList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getUserAlertList(), internalType);
		collectFromList(this, entityList, getTargetList(), internalType);
		collectFromList(this, entityList, getRatingList(), internalType);
		collectFromList(this, entityList, getReviewList(), internalType);
		collectFromList(this, entityList, getBlogList(), internalType);
		collectFromList(this, entityList, getBrandFilterList(), internalType);
		collectFromList(this, entityList, getPriceFilterList(), internalType);
		collectFromList(this, entityList, getCategoryFilterList(), internalType);
		collectFromList(this, entityList, getNewProductList(), internalType);
		collectFromList(this, entityList, getEditorPickProductList(), internalType);
		collectFromList(this, entityList, getTopRatedProductList(), internalType);
		collectFromList(this, entityList, getRecommandProductList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getUserAlertList());
		listOfList.add( getTargetList());
		listOfList.add( getRatingList());
		listOfList.add( getReviewList());
		listOfList.add( getBlogList());
		listOfList.add( getBrandFilterList());
		listOfList.add( getPriceFilterList());
		listOfList.add( getCategoryFilterList());
		listOfList.add( getNewProductList());
		listOfList.add( getEditorPickProductList());
		listOfList.add( getTopRatedProductList());
		listOfList.add( getRecommandProductList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, USER_ALERT_LIST, getUserAlertList());
		if(!getUserAlertList().isEmpty()){
			appendKeyValuePair(result, "userAlertCount", getUserAlertList().getTotalCount());
			appendKeyValuePair(result, "userAlertCurrentPageNumber", getUserAlertList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TARGET_LIST, getTargetList());
		if(!getTargetList().isEmpty()){
			appendKeyValuePair(result, "targetCount", getTargetList().getTotalCount());
			appendKeyValuePair(result, "targetCurrentPageNumber", getTargetList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RATING_LIST, getRatingList());
		if(!getRatingList().isEmpty()){
			appendKeyValuePair(result, "ratingCount", getRatingList().getTotalCount());
			appendKeyValuePair(result, "ratingCurrentPageNumber", getRatingList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, REVIEW_LIST, getReviewList());
		if(!getReviewList().isEmpty()){
			appendKeyValuePair(result, "reviewCount", getReviewList().getTotalCount());
			appendKeyValuePair(result, "reviewCurrentPageNumber", getReviewList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, BLOG_LIST, getBlogList());
		if(!getBlogList().isEmpty()){
			appendKeyValuePair(result, "blogCount", getBlogList().getTotalCount());
			appendKeyValuePair(result, "blogCurrentPageNumber", getBlogList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, BRAND_FILTER_LIST, getBrandFilterList());
		if(!getBrandFilterList().isEmpty()){
			appendKeyValuePair(result, "brandFilterCount", getBrandFilterList().getTotalCount());
			appendKeyValuePair(result, "brandFilterCurrentPageNumber", getBrandFilterList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PRICE_FILTER_LIST, getPriceFilterList());
		if(!getPriceFilterList().isEmpty()){
			appendKeyValuePair(result, "priceFilterCount", getPriceFilterList().getTotalCount());
			appendKeyValuePair(result, "priceFilterCurrentPageNumber", getPriceFilterList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CATEGORY_FILTER_LIST, getCategoryFilterList());
		if(!getCategoryFilterList().isEmpty()){
			appendKeyValuePair(result, "categoryFilterCount", getCategoryFilterList().getTotalCount());
			appendKeyValuePair(result, "categoryFilterCurrentPageNumber", getCategoryFilterList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, NEW_PRODUCT_LIST, getNewProductList());
		if(!getNewProductList().isEmpty()){
			appendKeyValuePair(result, "newProductCount", getNewProductList().getTotalCount());
			appendKeyValuePair(result, "newProductCurrentPageNumber", getNewProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EDITOR_PICK_PRODUCT_LIST, getEditorPickProductList());
		if(!getEditorPickProductList().isEmpty()){
			appendKeyValuePair(result, "editorPickProductCount", getEditorPickProductList().getTotalCount());
			appendKeyValuePair(result, "editorPickProductCurrentPageNumber", getEditorPickProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TOP_RATED_PRODUCT_LIST, getTopRatedProductList());
		if(!getTopRatedProductList().isEmpty()){
			appendKeyValuePair(result, "topRatedProductCount", getTopRatedProductList().getTotalCount());
			appendKeyValuePair(result, "topRatedProductCurrentPageNumber", getTopRatedProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RECOMMAND_PRODUCT_LIST, getRecommandProductList());
		if(!getRecommandProductList().isEmpty()){
			appendKeyValuePair(result, "recommandProductCount", getRecommandProductList().getTotalCount());
			appendKeyValuePair(result, "recommandProductCurrentPageNumber", getRecommandProductList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
		
			Profile dest =(Profile)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setUserAlertList(getUserAlertList());
			dest.setTargetList(getTargetList());
			dest.setRatingList(getRatingList());
			dest.setReviewList(getReviewList());
			dest.setBlogList(getBlogList());
			dest.setBrandFilterList(getBrandFilterList());
			dest.setPriceFilterList(getPriceFilterList());
			dest.setCategoryFilterList(getCategoryFilterList());
			dest.setNewProductList(getNewProductList());
			dest.setEditorPickProductList(getEditorPickProductList());
			dest.setTopRatedProductList(getTopRatedProductList());
			dest.setRecommandProductList(getRecommandProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
			
			Profile dest =(Profile)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeUserAlertList(getUserAlertList());
			dest.mergeTargetList(getTargetList());
			dest.mergeRatingList(getRatingList());
			dest.mergeReviewList(getReviewList());
			dest.mergeBlogList(getBlogList());
			dest.mergeBrandFilterList(getBrandFilterList());
			dest.mergePriceFilterList(getPriceFilterList());
			dest.mergeCategoryFilterList(getCategoryFilterList());
			dest.mergeNewProductList(getNewProductList());
			dest.mergeEditorPickProductList(getEditorPickProductList());
			dest.mergeTopRatedProductList(getTopRatedProductList());
			dest.mergeRecommandProductList(getRecommandProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Profile{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

