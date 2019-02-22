package com.doublechaintech.uxs;

import java.util.HashMap;
import java.util.Map;

import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.platform.PlatformTokens;
import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.site.SiteDAO;
import com.doublechaintech.uxs.site.SiteTokens;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.catalog.CatalogDAO;
import com.doublechaintech.uxs.catalog.CatalogTokens;
import com.doublechaintech.uxs.levelonecategory.LevelOneCategory;
import com.doublechaintech.uxs.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.uxs.levelonecategory.LevelOneCategoryTokens;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategoryDAO;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategoryTokens;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.levelncategory.LevelNCategoryDAO;
import com.doublechaintech.uxs.levelncategory.LevelNCategoryTokens;
import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.brand.BrandDAO;
import com.doublechaintech.uxs.brand.BrandTokens;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.product.ProductTokens;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.banner.BannerDAO;
import com.doublechaintech.uxs.banner.BannerTokens;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.profile.ProfileDAO;
import com.doublechaintech.uxs.profile.ProfileTokens;
import com.doublechaintech.uxs.useralert.UserAlert;
import com.doublechaintech.uxs.useralert.UserAlertDAO;
import com.doublechaintech.uxs.useralert.UserAlertTokens;
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.target.TargetDAO;
import com.doublechaintech.uxs.target.TargetTokens;
import com.doublechaintech.uxs.rating.Rating;
import com.doublechaintech.uxs.rating.RatingDAO;
import com.doublechaintech.uxs.rating.RatingTokens;
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.review.ReviewDAO;
import com.doublechaintech.uxs.review.ReviewTokens;
import com.doublechaintech.uxs.blog.Blog;
import com.doublechaintech.uxs.blog.BlogDAO;
import com.doublechaintech.uxs.blog.BlogTokens;
import com.doublechaintech.uxs.brandfilter.BrandFilter;
import com.doublechaintech.uxs.brandfilter.BrandFilterDAO;
import com.doublechaintech.uxs.brandfilter.BrandFilterTokens;
import com.doublechaintech.uxs.pricefilter.PriceFilter;
import com.doublechaintech.uxs.pricefilter.PriceFilterDAO;
import com.doublechaintech.uxs.pricefilter.PriceFilterTokens;
import com.doublechaintech.uxs.categoryfilter.CategoryFilter;
import com.doublechaintech.uxs.categoryfilter.CategoryFilterDAO;
import com.doublechaintech.uxs.categoryfilter.CategoryFilterTokens;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.newproduct.NewProductTokens;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductTokens;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductTokens;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductTokens;
import com.doublechaintech.uxs.userdomain.UserDomain;
import com.doublechaintech.uxs.userdomain.UserDomainDAO;
import com.doublechaintech.uxs.userdomain.UserDomainTokens;
import com.doublechaintech.uxs.userwhitelist.UserWhiteList;
import com.doublechaintech.uxs.userwhitelist.UserWhiteListDAO;
import com.doublechaintech.uxs.userwhitelist.UserWhiteListTokens;
import com.doublechaintech.uxs.secuser.SecUser;
import com.doublechaintech.uxs.secuser.SecUserDAO;
import com.doublechaintech.uxs.secuser.SecUserTokens;
import com.doublechaintech.uxs.secuserblocking.SecUserBlocking;
import com.doublechaintech.uxs.secuserblocking.SecUserBlockingDAO;
import com.doublechaintech.uxs.secuserblocking.SecUserBlockingTokens;
import com.doublechaintech.uxs.userapp.UserApp;
import com.doublechaintech.uxs.userapp.UserAppDAO;
import com.doublechaintech.uxs.userapp.UserAppTokens;
import com.doublechaintech.uxs.listaccess.ListAccess;
import com.doublechaintech.uxs.listaccess.ListAccessDAO;
import com.doublechaintech.uxs.listaccess.ListAccessTokens;
import com.doublechaintech.uxs.objectaccess.ObjectAccess;
import com.doublechaintech.uxs.objectaccess.ObjectAccessDAO;
import com.doublechaintech.uxs.objectaccess.ObjectAccessTokens;
import com.doublechaintech.uxs.loginhistory.LoginHistory;
import com.doublechaintech.uxs.loginhistory.LoginHistoryDAO;
import com.doublechaintech.uxs.loginhistory.LoginHistoryTokens;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.genericform.GenericFormDAO;
import com.doublechaintech.uxs.genericform.GenericFormTokens;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formmessage.FormMessageDAO;
import com.doublechaintech.uxs.formmessage.FormMessageTokens;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessageDAO;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessageTokens;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formfield.FormFieldDAO;
import com.doublechaintech.uxs.formfield.FormFieldTokens;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formaction.FormActionDAO;
import com.doublechaintech.uxs.formaction.FormActionTokens;

public class DAOGroup {

	protected PlatformDAO platformDAO;

	protected SiteDAO siteDAO;

	protected CatalogDAO catalogDAO;

	protected LevelOneCategoryDAO levelOneCategoryDAO;

	protected LevelTwoCategoryDAO levelTwoCategoryDAO;

	protected LevelNCategoryDAO levelNCategoryDAO;

	protected BrandDAO brandDAO;

	protected ProductDAO productDAO;

	protected BannerDAO bannerDAO;

	protected ProfileDAO profileDAO;

	protected UserAlertDAO userAlertDAO;

	protected TargetDAO targetDAO;

	protected RatingDAO ratingDAO;

	protected ReviewDAO reviewDAO;

	protected BlogDAO blogDAO;

	protected BrandFilterDAO brandFilterDAO;

	protected PriceFilterDAO priceFilterDAO;

	protected CategoryFilterDAO categoryFilterDAO;

	protected NewProductDAO newProductDAO;

	protected EditorPickProductDAO editorPickProductDAO;

	protected TopRatedProductDAO topRatedProductDAO;

	protected RecommandProductDAO recommandProductDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected SecUserBlockingDAO secUserBlockingDAO;

	protected UserAppDAO userAppDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	

	public PlatformDAO getPlatformDAO(){
		return this.platformDAO;
	}
	public void setPlatformDAO(PlatformDAO dao){
		this.platformDAO = dao;
	}


	public SiteDAO getSiteDAO(){
		return this.siteDAO;
	}
	public void setSiteDAO(SiteDAO dao){
		this.siteDAO = dao;
	}


	public CatalogDAO getCatalogDAO(){
		return this.catalogDAO;
	}
	public void setCatalogDAO(CatalogDAO dao){
		this.catalogDAO = dao;
	}


	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
		return this.levelOneCategoryDAO;
	}
	public void setLevelOneCategoryDAO(LevelOneCategoryDAO dao){
		this.levelOneCategoryDAO = dao;
	}


	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
		return this.levelTwoCategoryDAO;
	}
	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO dao){
		this.levelTwoCategoryDAO = dao;
	}


	public LevelNCategoryDAO getLevelNCategoryDAO(){
		return this.levelNCategoryDAO;
	}
	public void setLevelNCategoryDAO(LevelNCategoryDAO dao){
		this.levelNCategoryDAO = dao;
	}


	public BrandDAO getBrandDAO(){
		return this.brandDAO;
	}
	public void setBrandDAO(BrandDAO dao){
		this.brandDAO = dao;
	}


	public ProductDAO getProductDAO(){
		return this.productDAO;
	}
	public void setProductDAO(ProductDAO dao){
		this.productDAO = dao;
	}


	public BannerDAO getBannerDAO(){
		return this.bannerDAO;
	}
	public void setBannerDAO(BannerDAO dao){
		this.bannerDAO = dao;
	}


	public ProfileDAO getProfileDAO(){
		return this.profileDAO;
	}
	public void setProfileDAO(ProfileDAO dao){
		this.profileDAO = dao;
	}


	public UserAlertDAO getUserAlertDAO(){
		return this.userAlertDAO;
	}
	public void setUserAlertDAO(UserAlertDAO dao){
		this.userAlertDAO = dao;
	}


	public TargetDAO getTargetDAO(){
		return this.targetDAO;
	}
	public void setTargetDAO(TargetDAO dao){
		this.targetDAO = dao;
	}


	public RatingDAO getRatingDAO(){
		return this.ratingDAO;
	}
	public void setRatingDAO(RatingDAO dao){
		this.ratingDAO = dao;
	}


	public ReviewDAO getReviewDAO(){
		return this.reviewDAO;
	}
	public void setReviewDAO(ReviewDAO dao){
		this.reviewDAO = dao;
	}


	public BlogDAO getBlogDAO(){
		return this.blogDAO;
	}
	public void setBlogDAO(BlogDAO dao){
		this.blogDAO = dao;
	}


	public BrandFilterDAO getBrandFilterDAO(){
		return this.brandFilterDAO;
	}
	public void setBrandFilterDAO(BrandFilterDAO dao){
		this.brandFilterDAO = dao;
	}


	public PriceFilterDAO getPriceFilterDAO(){
		return this.priceFilterDAO;
	}
	public void setPriceFilterDAO(PriceFilterDAO dao){
		this.priceFilterDAO = dao;
	}


	public CategoryFilterDAO getCategoryFilterDAO(){
		return this.categoryFilterDAO;
	}
	public void setCategoryFilterDAO(CategoryFilterDAO dao){
		this.categoryFilterDAO = dao;
	}


	public NewProductDAO getNewProductDAO(){
		return this.newProductDAO;
	}
	public void setNewProductDAO(NewProductDAO dao){
		this.newProductDAO = dao;
	}


	public EditorPickProductDAO getEditorPickProductDAO(){
		return this.editorPickProductDAO;
	}
	public void setEditorPickProductDAO(EditorPickProductDAO dao){
		this.editorPickProductDAO = dao;
	}


	public TopRatedProductDAO getTopRatedProductDAO(){
		return this.topRatedProductDAO;
	}
	public void setTopRatedProductDAO(TopRatedProductDAO dao){
		this.topRatedProductDAO = dao;
	}


	public RecommandProductDAO getRecommandProductDAO(){
		return this.recommandProductDAO;
	}
	public void setRecommandProductDAO(RecommandProductDAO dao){
		this.recommandProductDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public SecUserBlockingDAO getSecUserBlockingDAO(){
		return this.secUserBlockingDAO;
	}
	public void setSecUserBlockingDAO(SecUserBlockingDAO dao){
		this.secUserBlockingDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public ObjectAccessDAO getObjectAccessDAO(){
		return this.objectAccessDAO;
	}
	public void setObjectAccessDAO(ObjectAccessDAO dao){
		this.objectAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public GenericFormDAO getGenericFormDAO(){
		return this.genericFormDAO;
	}
	public void setGenericFormDAO(GenericFormDAO dao){
		this.genericFormDAO = dao;
	}


	public FormMessageDAO getFormMessageDAO(){
		return this.formMessageDAO;
	}
	public void setFormMessageDAO(FormMessageDAO dao){
		this.formMessageDAO = dao;
	}


	public FormFieldMessageDAO getFormFieldMessageDAO(){
		return this.formFieldMessageDAO;
	}
	public void setFormFieldMessageDAO(FormFieldMessageDAO dao){
		this.formFieldMessageDAO = dao;
	}


	public FormFieldDAO getFormFieldDAO(){
		return this.formFieldDAO;
	}
	public void setFormFieldDAO(FormFieldDAO dao){
		this.formFieldDAO = dao;
	}


	public FormActionDAO getFormActionDAO(){
		return this.formActionDAO;
	}
	public void setFormActionDAO(FormActionDAO dao){
		this.formActionDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("Platform", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPlatformDAO().load(id, PlatformTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().present((Platform)data, tokens);
			}
		});

		internalLoaderMap.put("Site", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSiteDAO().load(id, SiteTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSiteDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSiteDAO().present((Site)data, tokens);
			}
		});

		internalLoaderMap.put("Catalog", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCatalogDAO().load(id, CatalogTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCatalogDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCatalogDAO().present((Catalog)data, tokens);
			}
		});

		internalLoaderMap.put("LevelOneCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().load(id, LevelOneCategoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().present((LevelOneCategory)data, tokens);
			}
		});

		internalLoaderMap.put("LevelTwoCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().load(id, LevelTwoCategoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().present((LevelTwoCategory)data, tokens);
			}
		});

		internalLoaderMap.put("LevelNCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelNCategoryDAO().load(id, LevelNCategoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelNCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelNCategoryDAO().present((LevelNCategory)data, tokens);
			}
		});

		internalLoaderMap.put("Brand", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getBrandDAO().load(id, BrandTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBrandDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBrandDAO().present((Brand)data, tokens);
			}
		});

		internalLoaderMap.put("Product", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProductDAO().load(id, ProductTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductDAO().present((Product)data, tokens);
			}
		});

		internalLoaderMap.put("Banner", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getBannerDAO().load(id, BannerTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBannerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBannerDAO().present((Banner)data, tokens);
			}
		});

		internalLoaderMap.put("Profile", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProfileDAO().load(id, ProfileTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProfileDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProfileDAO().present((Profile)data, tokens);
			}
		});

		internalLoaderMap.put("UserAlert", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAlertDAO().load(id, UserAlertTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAlertDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAlertDAO().present((UserAlert)data, tokens);
			}
		});

		internalLoaderMap.put("Target", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTargetDAO().load(id, TargetTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTargetDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTargetDAO().present((Target)data, tokens);
			}
		});

		internalLoaderMap.put("Rating", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRatingDAO().load(id, RatingTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRatingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRatingDAO().present((Rating)data, tokens);
			}
		});

		internalLoaderMap.put("Review", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getReviewDAO().load(id, ReviewTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getReviewDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getReviewDAO().present((Review)data, tokens);
			}
		});

		internalLoaderMap.put("Blog", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getBlogDAO().load(id, BlogTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBlogDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBlogDAO().present((Blog)data, tokens);
			}
		});

		internalLoaderMap.put("BrandFilter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getBrandFilterDAO().load(id, BrandFilterTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBrandFilterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBrandFilterDAO().present((BrandFilter)data, tokens);
			}
		});

		internalLoaderMap.put("PriceFilter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPriceFilterDAO().load(id, PriceFilterTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPriceFilterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPriceFilterDAO().present((PriceFilter)data, tokens);
			}
		});

		internalLoaderMap.put("CategoryFilter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCategoryFilterDAO().load(id, CategoryFilterTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCategoryFilterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCategoryFilterDAO().present((CategoryFilter)data, tokens);
			}
		});

		internalLoaderMap.put("NewProduct", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getNewProductDAO().load(id, NewProductTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getNewProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getNewProductDAO().present((NewProduct)data, tokens);
			}
		});

		internalLoaderMap.put("EditorPickProduct", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEditorPickProductDAO().load(id, EditorPickProductTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEditorPickProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEditorPickProductDAO().present((EditorPickProduct)data, tokens);
			}
		});

		internalLoaderMap.put("TopRatedProduct", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTopRatedProductDAO().load(id, TopRatedProductTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTopRatedProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTopRatedProductDAO().present((TopRatedProduct)data, tokens);
			}
		});

		internalLoaderMap.put("RecommandProduct", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRecommandProductDAO().load(id, RecommandProductTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRecommandProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRecommandProductDAO().present((RecommandProduct)data, tokens);
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
		});

		internalLoaderMap.put("SecUserBlocking", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, SecUserBlockingTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().present((SecUserBlocking)data, tokens);
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}

