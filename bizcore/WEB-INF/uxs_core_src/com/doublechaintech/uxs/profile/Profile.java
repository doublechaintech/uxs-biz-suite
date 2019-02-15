
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
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.blog.Blog;

@JsonSerialize(using = ProfileSerializer.class)
public class Profile extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TARGET_LIST                              = "targetList"        ;
	public static final String RATING_LIST                              = "ratingList"        ;
	public static final String REVIEW_LIST                              = "reviewList"        ;
	public static final String BLOG_LIST                                = "blogList"          ;

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
	
	
	protected		SmartList<Target>   	mTargetList         ;
	protected		SmartList<Rating>   	mRatingList         ;
	protected		SmartList<Review>   	mReviewList         ;
	protected		SmartList<Blog>     	mBlogList           ;
	
		
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

		this.mTargetList = new SmartList<Target>();
		this.mRatingList = new SmartList<Rating>();
		this.mReviewList = new SmartList<Review>();
		this.mBlogList = new SmartList<Blog>();	
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTargetList(), internalType);
		collectFromList(this, entityList, getRatingList(), internalType);
		collectFromList(this, entityList, getReviewList(), internalType);
		collectFromList(this, entityList, getBlogList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTargetList());
		listOfList.add( getRatingList());
		listOfList.add( getReviewList());
		listOfList.add( getBlogList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
		
			Profile dest =(Profile)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setTargetList(getTargetList());
			dest.setRatingList(getRatingList());
			dest.setReviewList(getReviewList());
			dest.setBlogList(getBlogList());

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

