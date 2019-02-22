
package com.doublechaintech.uxs.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.rating.Rating;
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.blog.Blog;

@JsonSerialize(using = ProductSerializer.class)
public class Product extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String BRAND_PROPERTY                 = "brand"             ;
	public static final String PRODUCT_COVER_IMAGE_PROPERTY   = "productCoverImage" ;
	public static final String ORIGIN_PROPERTY                = "origin"            ;
	public static final String CATALOG_PROPERTY               = "catalog"           ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RATING_LIST                              = "ratingList"        ;
	public static final String REVIEW_LIST                              = "reviewList"        ;
	public static final String BLOG_LIST                                = "blogList"          ;

	public static final String INTERNAL_TYPE="Product";
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
	protected		LevelNCategory      	mParentCategory     ;
	protected		Brand               	mBrand              ;
	protected		String              	mProductCoverImage  ;
	protected		String              	mOrigin             ;
	protected		Catalog             	mCatalog            ;
	protected		String              	mRemark             ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Rating>   	mRatingList         ;
	protected		SmartList<Review>   	mReviewList         ;
	protected		SmartList<Blog>     	mBlogList           ;
	
		
	public 	Product(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setParentCategory( null );
		setBrand( null );
		setCatalog( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Product(String name, LevelNCategory parentCategory, Brand brand, String productCoverImage, String origin, Catalog catalog, String remark, DateTime lastUpdateTime, Platform platform)
	{
		setName(name);
		setParentCategory(parentCategory);
		setBrand(brand);
		setProductCoverImage(productCoverImage);
		setOrigin(origin);
		setCatalog(catalog);
		setRemark(remark);
		setLastUpdateTime(lastUpdateTime);
		setPlatform(platform);

		this.mRatingList = new SmartList<Rating>();
		this.mReviewList = new SmartList<Review>();
		this.mBlogList = new SmartList<Blog>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			changeProductCoverImageProperty(newValueExpr);
		}
		if(ORIGIN_PROPERTY.equals(property)){
			changeOriginProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeProductCoverImageProperty(String newValueExpr){
		String oldValue = getProductCoverImage();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateProductCoverImage(newValue);
		this.onChangeProperty(PRODUCT_COVER_IMAGE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOriginProperty(String newValueExpr){
		String oldValue = getOrigin();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOrigin(newValue);
		this.onChangeProperty(ORIGIN_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeRemarkProperty(String newValueExpr){
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemark(newValue);
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Product updateId(String id){
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
	public Product updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setParentCategory(LevelNCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelNCategory getParentCategory(){
		return this.mParentCategory;
	}
	public Product updateParentCategory(LevelNCategory parentCategory){
		this.mParentCategory = parentCategory;;
		this.changed = true;
		return this;
	}
	
	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
	}
	
	public void setBrand(Brand brand){
		this.mBrand = brand;;
	}
	public Brand getBrand(){
		return this.mBrand;
	}
	public Product updateBrand(Brand brand){
		this.mBrand = brand;;
		this.changed = true;
		return this;
	}
	
	
	public void clearBrand(){
		setBrand ( null );
		this.changed = true;
	}
	
	public void setProductCoverImage(String productCoverImage){
		this.mProductCoverImage = trimString(encodeUrl(productCoverImage));;
	}
	public String getProductCoverImage(){
		return this.mProductCoverImage;
	}
	public Product updateProductCoverImage(String productCoverImage){
		this.mProductCoverImage = trimString(encodeUrl(productCoverImage));;
		this.changed = true;
		return this;
	}
	
	
	public void setOrigin(String origin){
		this.mOrigin = trimString(origin);;
	}
	public String getOrigin(){
		return this.mOrigin;
	}
	public Product updateOrigin(String origin){
		this.mOrigin = trimString(origin);;
		this.changed = true;
		return this;
	}
	
	
	public void setCatalog(Catalog catalog){
		this.mCatalog = catalog;;
	}
	public Catalog getCatalog(){
		return this.mCatalog;
	}
	public Product updateCatalog(Catalog catalog){
		this.mCatalog = catalog;;
		this.changed = true;
		return this;
	}
	
	
	public void clearCatalog(){
		setCatalog ( null );
		this.changed = true;
	}
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public Product updateRemark(String remark){
		this.mRemark = trimString(remark);;
		this.changed = true;
		return this;
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public Product updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Product updatePlatform(Platform platform){
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
	public Product updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
			rating.setProduct(this);
		}

		this.mRatingList = ratingList;
		this.mRatingList.setListInternalName (RATING_LIST );
		
	}
	
	public  void addRating(Rating rating){
		rating.setProduct(this);
		getRatingList().add(rating);
	}
	public  void addRatingList(SmartList<Rating> ratingList){
		for( Rating rating:ratingList){
			rating.setProduct(this);
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
        // rating.clearProduct(); //disconnect with Product
        rating.clearFromAll(); //disconnect with Product
		
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
		rating.setProduct(null);
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
			review.setProduct(this);
		}

		this.mReviewList = reviewList;
		this.mReviewList.setListInternalName (REVIEW_LIST );
		
	}
	
	public  void addReview(Review review){
		review.setProduct(this);
		getReviewList().add(review);
	}
	public  void addReviewList(SmartList<Review> reviewList){
		for( Review review:reviewList){
			review.setProduct(this);
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
        // review.clearProduct(); //disconnect with Product
        review.clearFromAll(); //disconnect with Product
		
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
		review.setProduct(null);
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
			blog.setProduct(this);
		}

		this.mBlogList = blogList;
		this.mBlogList.setListInternalName (BLOG_LIST );
		
	}
	
	public  void addBlog(Blog blog){
		blog.setProduct(this);
		getBlogList().add(blog);
	}
	public  void addBlogList(SmartList<Blog> blogList){
		for( Blog blog:blogList){
			blog.setProduct(this);
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
        // blog.clearProduct(); //disconnect with Product
        blog.clearFromAll(); //disconnect with Product
		
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
		blog.setProduct(null);
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

		addToEntityList(this, entityList, getParentCategory(), internalType);
		addToEntityList(this, entityList, getBrand(), internalType);
		addToEntityList(this, entityList, getCatalog(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getRatingList(), internalType);
		collectFromList(this, entityList, getReviewList(), internalType);
		collectFromList(this, entityList, getBlogList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getRatingList());
		listOfList.add( getReviewList());
		listOfList.add( getBlogList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PARENT_CATEGORY_PROPERTY, getParentCategory());
		appendKeyValuePair(result, BRAND_PROPERTY, getBrand());
		appendKeyValuePair(result, PRODUCT_COVER_IMAGE_PROPERTY, getProductCoverImage());
		appendKeyValuePair(result, ORIGIN_PROPERTY, getOrigin());
		appendKeyValuePair(result, CATALOG_PROPERTY, getCatalog());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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
		
		
		if(baseDest instanceof Product){
		
		
			Product dest =(Product)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setParentCategory(getParentCategory());
			dest.setBrand(getBrand());
			dest.setProductCoverImage(getProductCoverImage());
			dest.setOrigin(getOrigin());
			dest.setCatalog(getCatalog());
			dest.setRemark(getRemark());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setRatingList(getRatingList());
			dest.setReviewList(getReviewList());
			dest.setBlogList(getBlogList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Product{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparentCategory='LevelNCategory("+getParentCategory().getId()+")';");
 		}
		if(getBrand() != null ){
 			stringBuilder.append("\tbrand='Brand("+getBrand().getId()+")';");
 		}
		stringBuilder.append("\tproductCoverImage='"+getProductCoverImage()+"';");
		stringBuilder.append("\torigin='"+getOrigin()+"';");
		if(getCatalog() != null ){
 			stringBuilder.append("\tcatalog='Catalog("+getCatalog().getId()+")';");
 		}
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

