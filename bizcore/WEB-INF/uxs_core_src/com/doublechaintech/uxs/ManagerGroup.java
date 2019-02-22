package com.doublechaintech.uxs;


import com.doublechaintech.uxs.platform.PlatformManager;

import com.doublechaintech.uxs.site.SiteManager;

import com.doublechaintech.uxs.catalog.CatalogManager;

import com.doublechaintech.uxs.levelonecategory.LevelOneCategoryManager;

import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategoryManager;

import com.doublechaintech.uxs.levelncategory.LevelNCategoryManager;

import com.doublechaintech.uxs.brand.BrandManager;

import com.doublechaintech.uxs.product.ProductManager;

import com.doublechaintech.uxs.banner.BannerManager;

import com.doublechaintech.uxs.profile.ProfileManager;

import com.doublechaintech.uxs.useralert.UserAlertManager;

import com.doublechaintech.uxs.target.TargetManager;

import com.doublechaintech.uxs.rating.RatingManager;

import com.doublechaintech.uxs.review.ReviewManager;

import com.doublechaintech.uxs.blog.BlogManager;

import com.doublechaintech.uxs.brandfilter.BrandFilterManager;

import com.doublechaintech.uxs.pricefilter.PriceFilterManager;

import com.doublechaintech.uxs.categoryfilter.CategoryFilterManager;

import com.doublechaintech.uxs.newproduct.NewProductManager;

import com.doublechaintech.uxs.editorpickproduct.EditorPickProductManager;

import com.doublechaintech.uxs.topratedproduct.TopRatedProductManager;

import com.doublechaintech.uxs.recommandproduct.RecommandProductManager;

import com.doublechaintech.uxs.userdomain.UserDomainManager;

import com.doublechaintech.uxs.userwhitelist.UserWhiteListManager;

import com.doublechaintech.uxs.secuser.SecUserManager;

import com.doublechaintech.uxs.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.uxs.userapp.UserAppManager;

import com.doublechaintech.uxs.listaccess.ListAccessManager;

import com.doublechaintech.uxs.objectaccess.ObjectAccessManager;

import com.doublechaintech.uxs.loginhistory.LoginHistoryManager;

import com.doublechaintech.uxs.genericform.GenericFormManager;

import com.doublechaintech.uxs.formmessage.FormMessageManager;

import com.doublechaintech.uxs.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.uxs.formfield.FormFieldManager;

import com.doublechaintech.uxs.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected SiteManager siteManager;

	protected CatalogManager catalogManager;

	protected LevelOneCategoryManager levelOneCategoryManager;

	protected LevelTwoCategoryManager levelTwoCategoryManager;

	protected LevelNCategoryManager levelNCategoryManager;

	protected BrandManager brandManager;

	protected ProductManager productManager;

	protected BannerManager bannerManager;

	protected ProfileManager profileManager;

	protected UserAlertManager userAlertManager;

	protected TargetManager targetManager;

	protected RatingManager ratingManager;

	protected ReviewManager reviewManager;

	protected BlogManager blogManager;

	protected BrandFilterManager brandFilterManager;

	protected PriceFilterManager priceFilterManager;

	protected CategoryFilterManager categoryFilterManager;

	protected NewProductManager newProductManager;

	protected EditorPickProductManager editorPickProductManager;

	protected TopRatedProductManager topRatedProductManager;

	protected RecommandProductManager recommandProductManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public SiteManager getSiteManager(){
		return this.siteManager;
	}
	public void setSiteManager(SiteManager manager){
		this.siteManager = manager;
	}


	public CatalogManager getCatalogManager(){
		return this.catalogManager;
	}
	public void setCatalogManager(CatalogManager manager){
		this.catalogManager = manager;
	}


	public LevelOneCategoryManager getLevelOneCategoryManager(){
		return this.levelOneCategoryManager;
	}
	public void setLevelOneCategoryManager(LevelOneCategoryManager manager){
		this.levelOneCategoryManager = manager;
	}


	public LevelTwoCategoryManager getLevelTwoCategoryManager(){
		return this.levelTwoCategoryManager;
	}
	public void setLevelTwoCategoryManager(LevelTwoCategoryManager manager){
		this.levelTwoCategoryManager = manager;
	}


	public LevelNCategoryManager getLevelNCategoryManager(){
		return this.levelNCategoryManager;
	}
	public void setLevelNCategoryManager(LevelNCategoryManager manager){
		this.levelNCategoryManager = manager;
	}


	public BrandManager getBrandManager(){
		return this.brandManager;
	}
	public void setBrandManager(BrandManager manager){
		this.brandManager = manager;
	}


	public ProductManager getProductManager(){
		return this.productManager;
	}
	public void setProductManager(ProductManager manager){
		this.productManager = manager;
	}


	public BannerManager getBannerManager(){
		return this.bannerManager;
	}
	public void setBannerManager(BannerManager manager){
		this.bannerManager = manager;
	}


	public ProfileManager getProfileManager(){
		return this.profileManager;
	}
	public void setProfileManager(ProfileManager manager){
		this.profileManager = manager;
	}


	public UserAlertManager getUserAlertManager(){
		return this.userAlertManager;
	}
	public void setUserAlertManager(UserAlertManager manager){
		this.userAlertManager = manager;
	}


	public TargetManager getTargetManager(){
		return this.targetManager;
	}
	public void setTargetManager(TargetManager manager){
		this.targetManager = manager;
	}


	public RatingManager getRatingManager(){
		return this.ratingManager;
	}
	public void setRatingManager(RatingManager manager){
		this.ratingManager = manager;
	}


	public ReviewManager getReviewManager(){
		return this.reviewManager;
	}
	public void setReviewManager(ReviewManager manager){
		this.reviewManager = manager;
	}


	public BlogManager getBlogManager(){
		return this.blogManager;
	}
	public void setBlogManager(BlogManager manager){
		this.blogManager = manager;
	}


	public BrandFilterManager getBrandFilterManager(){
		return this.brandFilterManager;
	}
	public void setBrandFilterManager(BrandFilterManager manager){
		this.brandFilterManager = manager;
	}


	public PriceFilterManager getPriceFilterManager(){
		return this.priceFilterManager;
	}
	public void setPriceFilterManager(PriceFilterManager manager){
		this.priceFilterManager = manager;
	}


	public CategoryFilterManager getCategoryFilterManager(){
		return this.categoryFilterManager;
	}
	public void setCategoryFilterManager(CategoryFilterManager manager){
		this.categoryFilterManager = manager;
	}


	public NewProductManager getNewProductManager(){
		return this.newProductManager;
	}
	public void setNewProductManager(NewProductManager manager){
		this.newProductManager = manager;
	}


	public EditorPickProductManager getEditorPickProductManager(){
		return this.editorPickProductManager;
	}
	public void setEditorPickProductManager(EditorPickProductManager manager){
		this.editorPickProductManager = manager;
	}


	public TopRatedProductManager getTopRatedProductManager(){
		return this.topRatedProductManager;
	}
	public void setTopRatedProductManager(TopRatedProductManager manager){
		this.topRatedProductManager = manager;
	}


	public RecommandProductManager getRecommandProductManager(){
		return this.recommandProductManager;
	}
	public void setRecommandProductManager(RecommandProductManager manager){
		this.recommandProductManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









