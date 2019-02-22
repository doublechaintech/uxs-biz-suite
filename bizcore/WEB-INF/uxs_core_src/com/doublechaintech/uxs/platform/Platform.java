
package com.doublechaintech.uxs.platform;

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
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.useralert.UserAlert;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SITE_LIST                                = "siteList"          ;
	public static final String CATALOG_LIST                             = "catalogList"       ;
	public static final String BRAND_LIST                               = "brandList"         ;
	public static final String PRODUCT_LIST                             = "productList"       ;
	public static final String BANNER_LIST                              = "bannerList"        ;
	public static final String PROFILE_LIST                             = "profileList"       ;
	public static final String USER_ALERT_LIST                          = "userAlertList"     ;
	public static final String NEW_PRODUCT_LIST                         = "newProductList"    ;
	public static final String EDITOR_PICK_PRODUCT_LIST                 = "editorPickProductList";
	public static final String TOP_RATED_PRODUCT_LIST                   = "topRatedProductList";
	public static final String RECOMMAND_PRODUCT_LIST                   = "recommandProductList";

	public static final String INTERNAL_TYPE="Platform";
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
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Site>     	mSiteList           ;
	protected		SmartList<Catalog>  	mCatalogList        ;
	protected		SmartList<Brand>    	mBrandList          ;
	protected		SmartList<Product>  	mProductList        ;
	protected		SmartList<Banner>   	mBannerList         ;
	protected		SmartList<Profile>  	mProfileList        ;
	protected		SmartList<UserAlert>	mUserAlertList      ;
	protected		SmartList<NewProduct>	mNewProductList     ;
	protected		SmartList<EditorPickProduct>	mEditorPickProductList;
	protected		SmartList<TopRatedProduct>	mTopRatedProductList;
	protected		SmartList<RecommandProduct>	mRecommandProductList;
	
		
	public 	Platform(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name)
	{
		setName(name);

		this.mSiteList = new SmartList<Site>();
		this.mCatalogList = new SmartList<Catalog>();
		this.mBrandList = new SmartList<Brand>();
		this.mProductList = new SmartList<Product>();
		this.mBannerList = new SmartList<Banner>();
		this.mProfileList = new SmartList<Profile>();
		this.mUserAlertList = new SmartList<UserAlert>();
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
	public Platform updateId(String id){
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
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Site> getSiteList(){
		if(this.mSiteList == null){
			this.mSiteList = new SmartList<Site>();
			this.mSiteList.setListInternalName (SITE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSiteList;	
	}
	public  void setSiteList(SmartList<Site> siteList){
		for( Site site:siteList){
			site.setPlatform(this);
		}

		this.mSiteList = siteList;
		this.mSiteList.setListInternalName (SITE_LIST );
		
	}
	
	public  void addSite(Site site){
		site.setPlatform(this);
		getSiteList().add(site);
	}
	public  void addSiteList(SmartList<Site> siteList){
		for( Site site:siteList){
			site.setPlatform(this);
		}
		getSiteList().addAll(siteList);
	}
	public  void mergeSiteList(SmartList<Site> siteList){
		if(siteList==null){
			return;
		}
		if(siteList.isEmpty()){
			return;
		}
		addSiteList( siteList );
		
	}
	public  Site removeSite(Site siteIndex){
		
		int index = getSiteList().indexOf(siteIndex);
        if(index < 0){
        	String message = "Site("+siteIndex.getId()+") with version='"+siteIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Site site = getSiteList().get(index);        
        // site.clearPlatform(); //disconnect with Platform
        site.clearFromAll(); //disconnect with Platform
		
		boolean result = getSiteList().planToRemove(site);
        if(!result){
        	String message = "Site("+siteIndex.getId()+") with version='"+siteIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return site;
        
	
	}
	//断舍离
	public  void breakWithSite(Site site){
		
		if(site == null){
			return;
		}
		site.setPlatform(null);
		//getSiteList().remove();
	
	}
	
	public  boolean hasSite(Site site){
	
		return getSiteList().contains(site);
  
	}
	
	public void copySiteFrom(Site site) {

		Site siteInList = findTheSite(site);
		Site newSite = new Site();
		siteInList.copyTo(newSite);
		newSite.setVersion(0);//will trigger copy
		getSiteList().add(newSite);
		addItemToFlexiableObject(COPIED_CHILD, newSite);
	}
	
	public  Site findTheSite(Site site){
		
		int index =  getSiteList().indexOf(site);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Site("+site.getId()+") with version='"+site.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSiteList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSiteList(){
		getSiteList().clear();
	}
	
	
	


	public  SmartList<Catalog> getCatalogList(){
		if(this.mCatalogList == null){
			this.mCatalogList = new SmartList<Catalog>();
			this.mCatalogList.setListInternalName (CATALOG_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCatalogList;	
	}
	public  void setCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setPlatform(this);
		}

		this.mCatalogList = catalogList;
		this.mCatalogList.setListInternalName (CATALOG_LIST );
		
	}
	
	public  void addCatalog(Catalog catalog){
		catalog.setPlatform(this);
		getCatalogList().add(catalog);
	}
	public  void addCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setPlatform(this);
		}
		getCatalogList().addAll(catalogList);
	}
	public  void mergeCatalogList(SmartList<Catalog> catalogList){
		if(catalogList==null){
			return;
		}
		if(catalogList.isEmpty()){
			return;
		}
		addCatalogList( catalogList );
		
	}
	public  Catalog removeCatalog(Catalog catalogIndex){
		
		int index = getCatalogList().indexOf(catalogIndex);
        if(index < 0){
        	String message = "Catalog("+catalogIndex.getId()+") with version='"+catalogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Catalog catalog = getCatalogList().get(index);        
        // catalog.clearPlatform(); //disconnect with Platform
        catalog.clearFromAll(); //disconnect with Platform
		
		boolean result = getCatalogList().planToRemove(catalog);
        if(!result){
        	String message = "Catalog("+catalogIndex.getId()+") with version='"+catalogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return catalog;
        
	
	}
	//断舍离
	public  void breakWithCatalog(Catalog catalog){
		
		if(catalog == null){
			return;
		}
		catalog.setPlatform(null);
		//getCatalogList().remove();
	
	}
	
	public  boolean hasCatalog(Catalog catalog){
	
		return getCatalogList().contains(catalog);
  
	}
	
	public void copyCatalogFrom(Catalog catalog) {

		Catalog catalogInList = findTheCatalog(catalog);
		Catalog newCatalog = new Catalog();
		catalogInList.copyTo(newCatalog);
		newCatalog.setVersion(0);//will trigger copy
		getCatalogList().add(newCatalog);
		addItemToFlexiableObject(COPIED_CHILD, newCatalog);
	}
	
	public  Catalog findTheCatalog(Catalog catalog){
		
		int index =  getCatalogList().indexOf(catalog);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Catalog("+catalog.getId()+") with version='"+catalog.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCatalogList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCatalogList(){
		getCatalogList().clear();
	}
	
	
	


	public  SmartList<Brand> getBrandList(){
		if(this.mBrandList == null){
			this.mBrandList = new SmartList<Brand>();
			this.mBrandList.setListInternalName (BRAND_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mBrandList;	
	}
	public  void setBrandList(SmartList<Brand> brandList){
		for( Brand brand:brandList){
			brand.setPlatform(this);
		}

		this.mBrandList = brandList;
		this.mBrandList.setListInternalName (BRAND_LIST );
		
	}
	
	public  void addBrand(Brand brand){
		brand.setPlatform(this);
		getBrandList().add(brand);
	}
	public  void addBrandList(SmartList<Brand> brandList){
		for( Brand brand:brandList){
			brand.setPlatform(this);
		}
		getBrandList().addAll(brandList);
	}
	public  void mergeBrandList(SmartList<Brand> brandList){
		if(brandList==null){
			return;
		}
		if(brandList.isEmpty()){
			return;
		}
		addBrandList( brandList );
		
	}
	public  Brand removeBrand(Brand brandIndex){
		
		int index = getBrandList().indexOf(brandIndex);
        if(index < 0){
        	String message = "Brand("+brandIndex.getId()+") with version='"+brandIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Brand brand = getBrandList().get(index);        
        // brand.clearPlatform(); //disconnect with Platform
        brand.clearFromAll(); //disconnect with Platform
		
		boolean result = getBrandList().planToRemove(brand);
        if(!result){
        	String message = "Brand("+brandIndex.getId()+") with version='"+brandIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return brand;
        
	
	}
	//断舍离
	public  void breakWithBrand(Brand brand){
		
		if(brand == null){
			return;
		}
		brand.setPlatform(null);
		//getBrandList().remove();
	
	}
	
	public  boolean hasBrand(Brand brand){
	
		return getBrandList().contains(brand);
  
	}
	
	public void copyBrandFrom(Brand brand) {

		Brand brandInList = findTheBrand(brand);
		Brand newBrand = new Brand();
		brandInList.copyTo(newBrand);
		newBrand.setVersion(0);//will trigger copy
		getBrandList().add(newBrand);
		addItemToFlexiableObject(COPIED_CHILD, newBrand);
	}
	
	public  Brand findTheBrand(Brand brand){
		
		int index =  getBrandList().indexOf(brand);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Brand("+brand.getId()+") with version='"+brand.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getBrandList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpBrandList(){
		getBrandList().clear();
	}
	
	
	


	public  SmartList<Product> getProductList(){
		if(this.mProductList == null){
			this.mProductList = new SmartList<Product>();
			this.mProductList.setListInternalName (PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProductList;	
	}
	public  void setProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setPlatform(this);
		}

		this.mProductList = productList;
		this.mProductList.setListInternalName (PRODUCT_LIST );
		
	}
	
	public  void addProduct(Product product){
		product.setPlatform(this);
		getProductList().add(product);
	}
	public  void addProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setPlatform(this);
		}
		getProductList().addAll(productList);
	}
	public  void mergeProductList(SmartList<Product> productList){
		if(productList==null){
			return;
		}
		if(productList.isEmpty()){
			return;
		}
		addProductList( productList );
		
	}
	public  Product removeProduct(Product productIndex){
		
		int index = getProductList().indexOf(productIndex);
        if(index < 0){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Product product = getProductList().get(index);        
        // product.clearPlatform(); //disconnect with Platform
        product.clearFromAll(); //disconnect with Platform
		
		boolean result = getProductList().planToRemove(product);
        if(!result){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return product;
        
	
	}
	//断舍离
	public  void breakWithProduct(Product product){
		
		if(product == null){
			return;
		}
		product.setPlatform(null);
		//getProductList().remove();
	
	}
	
	public  boolean hasProduct(Product product){
	
		return getProductList().contains(product);
  
	}
	
	public void copyProductFrom(Product product) {

		Product productInList = findTheProduct(product);
		Product newProduct = new Product();
		productInList.copyTo(newProduct);
		newProduct.setVersion(0);//will trigger copy
		getProductList().add(newProduct);
		addItemToFlexiableObject(COPIED_CHILD, newProduct);
	}
	
	public  Product findTheProduct(Product product){
		
		int index =  getProductList().indexOf(product);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Product("+product.getId()+") with version='"+product.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProductList(){
		getProductList().clear();
	}
	
	
	


	public  SmartList<Banner> getBannerList(){
		if(this.mBannerList == null){
			this.mBannerList = new SmartList<Banner>();
			this.mBannerList.setListInternalName (BANNER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mBannerList;	
	}
	public  void setBannerList(SmartList<Banner> bannerList){
		for( Banner banner:bannerList){
			banner.setPlatform(this);
		}

		this.mBannerList = bannerList;
		this.mBannerList.setListInternalName (BANNER_LIST );
		
	}
	
	public  void addBanner(Banner banner){
		banner.setPlatform(this);
		getBannerList().add(banner);
	}
	public  void addBannerList(SmartList<Banner> bannerList){
		for( Banner banner:bannerList){
			banner.setPlatform(this);
		}
		getBannerList().addAll(bannerList);
	}
	public  void mergeBannerList(SmartList<Banner> bannerList){
		if(bannerList==null){
			return;
		}
		if(bannerList.isEmpty()){
			return;
		}
		addBannerList( bannerList );
		
	}
	public  Banner removeBanner(Banner bannerIndex){
		
		int index = getBannerList().indexOf(bannerIndex);
        if(index < 0){
        	String message = "Banner("+bannerIndex.getId()+") with version='"+bannerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Banner banner = getBannerList().get(index);        
        // banner.clearPlatform(); //disconnect with Platform
        banner.clearFromAll(); //disconnect with Platform
		
		boolean result = getBannerList().planToRemove(banner);
        if(!result){
        	String message = "Banner("+bannerIndex.getId()+") with version='"+bannerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return banner;
        
	
	}
	//断舍离
	public  void breakWithBanner(Banner banner){
		
		if(banner == null){
			return;
		}
		banner.setPlatform(null);
		//getBannerList().remove();
	
	}
	
	public  boolean hasBanner(Banner banner){
	
		return getBannerList().contains(banner);
  
	}
	
	public void copyBannerFrom(Banner banner) {

		Banner bannerInList = findTheBanner(banner);
		Banner newBanner = new Banner();
		bannerInList.copyTo(newBanner);
		newBanner.setVersion(0);//will trigger copy
		getBannerList().add(newBanner);
		addItemToFlexiableObject(COPIED_CHILD, newBanner);
	}
	
	public  Banner findTheBanner(Banner banner){
		
		int index =  getBannerList().indexOf(banner);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Banner("+banner.getId()+") with version='"+banner.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getBannerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpBannerList(){
		getBannerList().clear();
	}
	
	
	


	public  SmartList<Profile> getProfileList(){
		if(this.mProfileList == null){
			this.mProfileList = new SmartList<Profile>();
			this.mProfileList.setListInternalName (PROFILE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProfileList;	
	}
	public  void setProfileList(SmartList<Profile> profileList){
		for( Profile profile:profileList){
			profile.setPlatform(this);
		}

		this.mProfileList = profileList;
		this.mProfileList.setListInternalName (PROFILE_LIST );
		
	}
	
	public  void addProfile(Profile profile){
		profile.setPlatform(this);
		getProfileList().add(profile);
	}
	public  void addProfileList(SmartList<Profile> profileList){
		for( Profile profile:profileList){
			profile.setPlatform(this);
		}
		getProfileList().addAll(profileList);
	}
	public  void mergeProfileList(SmartList<Profile> profileList){
		if(profileList==null){
			return;
		}
		if(profileList.isEmpty()){
			return;
		}
		addProfileList( profileList );
		
	}
	public  Profile removeProfile(Profile profileIndex){
		
		int index = getProfileList().indexOf(profileIndex);
        if(index < 0){
        	String message = "Profile("+profileIndex.getId()+") with version='"+profileIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Profile profile = getProfileList().get(index);        
        // profile.clearPlatform(); //disconnect with Platform
        profile.clearFromAll(); //disconnect with Platform
		
		boolean result = getProfileList().planToRemove(profile);
        if(!result){
        	String message = "Profile("+profileIndex.getId()+") with version='"+profileIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return profile;
        
	
	}
	//断舍离
	public  void breakWithProfile(Profile profile){
		
		if(profile == null){
			return;
		}
		profile.setPlatform(null);
		//getProfileList().remove();
	
	}
	
	public  boolean hasProfile(Profile profile){
	
		return getProfileList().contains(profile);
  
	}
	
	public void copyProfileFrom(Profile profile) {

		Profile profileInList = findTheProfile(profile);
		Profile newProfile = new Profile();
		profileInList.copyTo(newProfile);
		newProfile.setVersion(0);//will trigger copy
		getProfileList().add(newProfile);
		addItemToFlexiableObject(COPIED_CHILD, newProfile);
	}
	
	public  Profile findTheProfile(Profile profile){
		
		int index =  getProfileList().indexOf(profile);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Profile("+profile.getId()+") with version='"+profile.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProfileList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProfileList(){
		getProfileList().clear();
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
			userAlert.setPlatform(this);
		}

		this.mUserAlertList = userAlertList;
		this.mUserAlertList.setListInternalName (USER_ALERT_LIST );
		
	}
	
	public  void addUserAlert(UserAlert userAlert){
		userAlert.setPlatform(this);
		getUserAlertList().add(userAlert);
	}
	public  void addUserAlertList(SmartList<UserAlert> userAlertList){
		for( UserAlert userAlert:userAlertList){
			userAlert.setPlatform(this);
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
        // userAlert.clearPlatform(); //disconnect with Platform
        userAlert.clearFromAll(); //disconnect with Platform
		
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
		userAlert.setPlatform(null);
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
			newProduct.setPlatform(this);
		}

		this.mNewProductList = newProductList;
		this.mNewProductList.setListInternalName (NEW_PRODUCT_LIST );
		
	}
	
	public  void addNewProduct(NewProduct newProduct){
		newProduct.setPlatform(this);
		getNewProductList().add(newProduct);
	}
	public  void addNewProductList(SmartList<NewProduct> newProductList){
		for( NewProduct newProduct:newProductList){
			newProduct.setPlatform(this);
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
        // newProduct.clearPlatform(); //disconnect with Platform
        newProduct.clearFromAll(); //disconnect with Platform
		
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
		newProduct.setPlatform(null);
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
			editorPickProduct.setPlatform(this);
		}

		this.mEditorPickProductList = editorPickProductList;
		this.mEditorPickProductList.setListInternalName (EDITOR_PICK_PRODUCT_LIST );
		
	}
	
	public  void addEditorPickProduct(EditorPickProduct editorPickProduct){
		editorPickProduct.setPlatform(this);
		getEditorPickProductList().add(editorPickProduct);
	}
	public  void addEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		for( EditorPickProduct editorPickProduct:editorPickProductList){
			editorPickProduct.setPlatform(this);
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
        // editorPickProduct.clearPlatform(); //disconnect with Platform
        editorPickProduct.clearFromAll(); //disconnect with Platform
		
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
		editorPickProduct.setPlatform(null);
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
			topRatedProduct.setPlatform(this);
		}

		this.mTopRatedProductList = topRatedProductList;
		this.mTopRatedProductList.setListInternalName (TOP_RATED_PRODUCT_LIST );
		
	}
	
	public  void addTopRatedProduct(TopRatedProduct topRatedProduct){
		topRatedProduct.setPlatform(this);
		getTopRatedProductList().add(topRatedProduct);
	}
	public  void addTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		for( TopRatedProduct topRatedProduct:topRatedProductList){
			topRatedProduct.setPlatform(this);
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
        // topRatedProduct.clearPlatform(); //disconnect with Platform
        topRatedProduct.clearFromAll(); //disconnect with Platform
		
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
		topRatedProduct.setPlatform(null);
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
			recommandProduct.setPlatform(this);
		}

		this.mRecommandProductList = recommandProductList;
		this.mRecommandProductList.setListInternalName (RECOMMAND_PRODUCT_LIST );
		
	}
	
	public  void addRecommandProduct(RecommandProduct recommandProduct){
		recommandProduct.setPlatform(this);
		getRecommandProductList().add(recommandProduct);
	}
	public  void addRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		for( RecommandProduct recommandProduct:recommandProductList){
			recommandProduct.setPlatform(this);
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
        // recommandProduct.clearPlatform(); //disconnect with Platform
        recommandProduct.clearFromAll(); //disconnect with Platform
		
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
		recommandProduct.setPlatform(null);
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


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getSiteList(), internalType);
		collectFromList(this, entityList, getCatalogList(), internalType);
		collectFromList(this, entityList, getBrandList(), internalType);
		collectFromList(this, entityList, getProductList(), internalType);
		collectFromList(this, entityList, getBannerList(), internalType);
		collectFromList(this, entityList, getProfileList(), internalType);
		collectFromList(this, entityList, getUserAlertList(), internalType);
		collectFromList(this, entityList, getNewProductList(), internalType);
		collectFromList(this, entityList, getEditorPickProductList(), internalType);
		collectFromList(this, entityList, getTopRatedProductList(), internalType);
		collectFromList(this, entityList, getRecommandProductList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getSiteList());
		listOfList.add( getCatalogList());
		listOfList.add( getBrandList());
		listOfList.add( getProductList());
		listOfList.add( getBannerList());
		listOfList.add( getProfileList());
		listOfList.add( getUserAlertList());
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
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SITE_LIST, getSiteList());
		if(!getSiteList().isEmpty()){
			appendKeyValuePair(result, "siteCount", getSiteList().getTotalCount());
			appendKeyValuePair(result, "siteCurrentPageNumber", getSiteList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CATALOG_LIST, getCatalogList());
		if(!getCatalogList().isEmpty()){
			appendKeyValuePair(result, "catalogCount", getCatalogList().getTotalCount());
			appendKeyValuePair(result, "catalogCurrentPageNumber", getCatalogList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, BRAND_LIST, getBrandList());
		if(!getBrandList().isEmpty()){
			appendKeyValuePair(result, "brandCount", getBrandList().getTotalCount());
			appendKeyValuePair(result, "brandCurrentPageNumber", getBrandList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PRODUCT_LIST, getProductList());
		if(!getProductList().isEmpty()){
			appendKeyValuePair(result, "productCount", getProductList().getTotalCount());
			appendKeyValuePair(result, "productCurrentPageNumber", getProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, BANNER_LIST, getBannerList());
		if(!getBannerList().isEmpty()){
			appendKeyValuePair(result, "bannerCount", getBannerList().getTotalCount());
			appendKeyValuePair(result, "bannerCurrentPageNumber", getBannerList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PROFILE_LIST, getProfileList());
		if(!getProfileList().isEmpty()){
			appendKeyValuePair(result, "profileCount", getProfileList().getTotalCount());
			appendKeyValuePair(result, "profileCurrentPageNumber", getProfileList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, USER_ALERT_LIST, getUserAlertList());
		if(!getUserAlertList().isEmpty()){
			appendKeyValuePair(result, "userAlertCount", getUserAlertList().getTotalCount());
			appendKeyValuePair(result, "userAlertCurrentPageNumber", getUserAlertList().getCurrentPageNumber());
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
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setSiteList(getSiteList());
			dest.setCatalogList(getCatalogList());
			dest.setBrandList(getBrandList());
			dest.setProductList(getProductList());
			dest.setBannerList(getBannerList());
			dest.setProfileList(getProfileList());
			dest.setUserAlertList(getUserAlertList());
			dest.setNewProductList(getNewProductList());
			dest.setEditorPickProductList(getEditorPickProductList());
			dest.setTopRatedProductList(getTopRatedProductList());
			dest.setRecommandProductList(getRecommandProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
			
			Platform dest =(Platform)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());
			dest.mergeSiteList(getSiteList());
			dest.mergeCatalogList(getCatalogList());
			dest.mergeBrandList(getBrandList());
			dest.mergeProductList(getProductList());
			dest.mergeBannerList(getBannerList());
			dest.mergeProfileList(getProfileList());
			dest.mergeUserAlertList(getUserAlertList());
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

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

