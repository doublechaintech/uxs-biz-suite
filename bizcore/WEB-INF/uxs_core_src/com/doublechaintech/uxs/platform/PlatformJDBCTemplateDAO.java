
package com.doublechaintech.uxs.platform;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.uxs.UxsNamingServiceDAO;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.AccessKey;
import com.doublechaintech.uxs.DateKey;
import com.doublechaintech.uxs.StatsInfo;
import com.doublechaintech.uxs.StatsItem;

import com.doublechaintech.uxs.MultipleAccessKey;
import com.doublechaintech.uxs.UxsUserContext;


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

import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.brand.BrandDAO;
import com.doublechaintech.uxs.site.SiteDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.banner.BannerDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.catalog.CatalogDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;
import com.doublechaintech.uxs.useralert.UserAlertDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class PlatformJDBCTemplateDAO extends UxsNamingServiceDAO implements PlatformDAO{


			
		
	
  	private  SiteDAO  siteDAO;
 	public void setSiteDAO(SiteDAO pSiteDAO){
 	
 		if(pSiteDAO == null){
 			throw new IllegalStateException("Do not try to set siteDAO to null.");
 		}
	 	this.siteDAO = pSiteDAO;
 	}
 	public SiteDAO getSiteDAO(){
 		if(this.siteDAO == null){
 			throw new IllegalStateException("The siteDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.siteDAO;
 	}	
 	
			
		
	
  	private  CatalogDAO  catalogDAO;
 	public void setCatalogDAO(CatalogDAO pCatalogDAO){
 	
 		if(pCatalogDAO == null){
 			throw new IllegalStateException("Do not try to set catalogDAO to null.");
 		}
	 	this.catalogDAO = pCatalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
 		if(this.catalogDAO == null){
 			throw new IllegalStateException("The catalogDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.catalogDAO;
 	}	
 	
			
		
	
  	private  BrandDAO  brandDAO;
 	public void setBrandDAO(BrandDAO pBrandDAO){
 	
 		if(pBrandDAO == null){
 			throw new IllegalStateException("Do not try to set brandDAO to null.");
 		}
	 	this.brandDAO = pBrandDAO;
 	}
 	public BrandDAO getBrandDAO(){
 		if(this.brandDAO == null){
 			throw new IllegalStateException("The brandDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.brandDAO;
 	}	
 	
			
		
	
  	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO pProductDAO){
 	
 		if(pProductDAO == null){
 			throw new IllegalStateException("Do not try to set productDAO to null.");
 		}
	 	this.productDAO = pProductDAO;
 	}
 	public ProductDAO getProductDAO(){
 		if(this.productDAO == null){
 			throw new IllegalStateException("The productDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productDAO;
 	}	
 	
			
		
	
  	private  BannerDAO  bannerDAO;
 	public void setBannerDAO(BannerDAO pBannerDAO){
 	
 		if(pBannerDAO == null){
 			throw new IllegalStateException("Do not try to set bannerDAO to null.");
 		}
	 	this.bannerDAO = pBannerDAO;
 	}
 	public BannerDAO getBannerDAO(){
 		if(this.bannerDAO == null){
 			throw new IllegalStateException("The bannerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.bannerDAO;
 	}	
 	
			
		
	
  	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO pProfileDAO){
 	
 		if(pProfileDAO == null){
 			throw new IllegalStateException("Do not try to set profileDAO to null.");
 		}
	 	this.profileDAO = pProfileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
 		if(this.profileDAO == null){
 			throw new IllegalStateException("The profileDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.profileDAO;
 	}	
 	
			
		
	
  	private  UserAlertDAO  userAlertDAO;
 	public void setUserAlertDAO(UserAlertDAO pUserAlertDAO){
 	
 		if(pUserAlertDAO == null){
 			throw new IllegalStateException("Do not try to set userAlertDAO to null.");
 		}
	 	this.userAlertDAO = pUserAlertDAO;
 	}
 	public UserAlertDAO getUserAlertDAO(){
 		if(this.userAlertDAO == null){
 			throw new IllegalStateException("The userAlertDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAlertDAO;
 	}	
 	
			
		
	
  	private  NewProductDAO  newProductDAO;
 	public void setNewProductDAO(NewProductDAO pNewProductDAO){
 	
 		if(pNewProductDAO == null){
 			throw new IllegalStateException("Do not try to set newProductDAO to null.");
 		}
	 	this.newProductDAO = pNewProductDAO;
 	}
 	public NewProductDAO getNewProductDAO(){
 		if(this.newProductDAO == null){
 			throw new IllegalStateException("The newProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.newProductDAO;
 	}	
 	
			
		
	
  	private  EditorPickProductDAO  editorPickProductDAO;
 	public void setEditorPickProductDAO(EditorPickProductDAO pEditorPickProductDAO){
 	
 		if(pEditorPickProductDAO == null){
 			throw new IllegalStateException("Do not try to set editorPickProductDAO to null.");
 		}
	 	this.editorPickProductDAO = pEditorPickProductDAO;
 	}
 	public EditorPickProductDAO getEditorPickProductDAO(){
 		if(this.editorPickProductDAO == null){
 			throw new IllegalStateException("The editorPickProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.editorPickProductDAO;
 	}	
 	
			
		
	
  	private  TopRatedProductDAO  topRatedProductDAO;
 	public void setTopRatedProductDAO(TopRatedProductDAO pTopRatedProductDAO){
 	
 		if(pTopRatedProductDAO == null){
 			throw new IllegalStateException("Do not try to set topRatedProductDAO to null.");
 		}
	 	this.topRatedProductDAO = pTopRatedProductDAO;
 	}
 	public TopRatedProductDAO getTopRatedProductDAO(){
 		if(this.topRatedProductDAO == null){
 			throw new IllegalStateException("The topRatedProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.topRatedProductDAO;
 	}	
 	
			
		
	
  	private  RecommandProductDAO  recommandProductDAO;
 	public void setRecommandProductDAO(RecommandProductDAO pRecommandProductDAO){
 	
 		if(pRecommandProductDAO == null){
 			throw new IllegalStateException("Do not try to set recommandProductDAO to null.");
 		}
	 	this.recommandProductDAO = pRecommandProductDAO;
 	}
 	public RecommandProductDAO getRecommandProductDAO(){
 		if(this.recommandProductDAO == null){
 			throw new IllegalStateException("The recommandProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.recommandProductDAO;
 	}	
 	
			
		

	
	/*
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveSiteListEnabled(options)){
 			for(Site item: newPlatform.getSiteList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCatalogListEnabled(options)){
 			for(Catalog item: newPlatform.getCatalogList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveBrandListEnabled(options)){
 			for(Brand item: newPlatform.getBrandList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newPlatform.getProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveBannerListEnabled(options)){
 			for(Banner item: newPlatform.getBannerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProfileListEnabled(options)){
 			for(Profile item: newPlatform.getProfileList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveUserAlertListEnabled(options)){
 			for(UserAlert item: newPlatform.getUserAlertList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveNewProductListEnabled(options)){
 			for(NewProduct item: newPlatform.getNewProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEditorPickProductListEnabled(options)){
 			for(EditorPickProduct item: newPlatform.getEditorPickProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTopRatedProductListEnabled(options)){
 			for(TopRatedProduct item: newPlatform.getTopRatedProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRecommandProductListEnabled(options)){
 			for(RecommandProduct item: newPlatform.getRecommandProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractSiteListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.SITE_LIST);
 	}
 	protected boolean isAnalyzeSiteListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.SITE_LIST+".analyze");
 	}
	
	protected boolean isSaveSiteListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.SITE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractCatalogListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.CATALOG_LIST);
 	}
 	protected boolean isAnalyzeCatalogListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.CATALOG_LIST+".analyze");
 	}
	
	protected boolean isSaveCatalogListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.CATALOG_LIST);
		
 	}
 	
		
	
	protected boolean isExtractBrandListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.BRAND_LIST);
 	}
 	protected boolean isAnalyzeBrandListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.BRAND_LIST+".analyze");
 	}
	
	protected boolean isSaveBrandListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.BRAND_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractBannerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.BANNER_LIST);
 	}
 	protected boolean isAnalyzeBannerListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.BANNER_LIST+".analyze");
 	}
	
	protected boolean isSaveBannerListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.BANNER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProfileListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PROFILE_LIST);
 	}
 	protected boolean isAnalyzeProfileListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.PROFILE_LIST+".analyze");
 	}
	
	protected boolean isSaveProfileListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PROFILE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractUserAlertListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.USER_ALERT_LIST);
 	}
 	protected boolean isAnalyzeUserAlertListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.USER_ALERT_LIST+".analyze");
 	}
	
	protected boolean isSaveUserAlertListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.USER_ALERT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractNewProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.NEW_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeNewProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.NEW_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveNewProductListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.NEW_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractEditorPickProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.EDITOR_PICK_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeEditorPickProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.EDITOR_PICK_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveEditorPickProductListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.EDITOR_PICK_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTopRatedProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TOP_RATED_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeTopRatedProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.TOP_RATED_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveTopRatedProductListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.TOP_RATED_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRecommandProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.RECOMMAND_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeRecommandProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.RECOMMAND_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveRecommandProductListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.RECOMMAND_PRODUCT_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractSiteListEnabled(loadOptions)){
	 		extractSiteList(platform, loadOptions);
 		}	
 		if(isAnalyzeSiteListEnabled(loadOptions)){
	 		analyzeSiteList(platform, loadOptions);
 		}
 		
		
		if(isExtractCatalogListEnabled(loadOptions)){
	 		extractCatalogList(platform, loadOptions);
 		}	
 		if(isAnalyzeCatalogListEnabled(loadOptions)){
	 		analyzeCatalogList(platform, loadOptions);
 		}
 		
		
		if(isExtractBrandListEnabled(loadOptions)){
	 		extractBrandList(platform, loadOptions);
 		}	
 		if(isAnalyzeBrandListEnabled(loadOptions)){
	 		analyzeBrandList(platform, loadOptions);
 		}
 		
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(platform, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		analyzeProductList(platform, loadOptions);
 		}
 		
		
		if(isExtractBannerListEnabled(loadOptions)){
	 		extractBannerList(platform, loadOptions);
 		}	
 		if(isAnalyzeBannerListEnabled(loadOptions)){
	 		analyzeBannerList(platform, loadOptions);
 		}
 		
		
		if(isExtractProfileListEnabled(loadOptions)){
	 		extractProfileList(platform, loadOptions);
 		}	
 		if(isAnalyzeProfileListEnabled(loadOptions)){
	 		analyzeProfileList(platform, loadOptions);
 		}
 		
		
		if(isExtractUserAlertListEnabled(loadOptions)){
	 		extractUserAlertList(platform, loadOptions);
 		}	
 		if(isAnalyzeUserAlertListEnabled(loadOptions)){
	 		analyzeUserAlertList(platform, loadOptions);
 		}
 		
		
		if(isExtractNewProductListEnabled(loadOptions)){
	 		extractNewProductList(platform, loadOptions);
 		}	
 		if(isAnalyzeNewProductListEnabled(loadOptions)){
	 		analyzeNewProductList(platform, loadOptions);
 		}
 		
		
		if(isExtractEditorPickProductListEnabled(loadOptions)){
	 		extractEditorPickProductList(platform, loadOptions);
 		}	
 		if(isAnalyzeEditorPickProductListEnabled(loadOptions)){
	 		analyzeEditorPickProductList(platform, loadOptions);
 		}
 		
		
		if(isExtractTopRatedProductListEnabled(loadOptions)){
	 		extractTopRatedProductList(platform, loadOptions);
 		}	
 		if(isAnalyzeTopRatedProductListEnabled(loadOptions)){
	 		analyzeTopRatedProductList(platform, loadOptions);
 		}
 		
		
		if(isExtractRecommandProductListEnabled(loadOptions)){
	 		extractRecommandProductList(platform, loadOptions);
 		}	
 		if(isAnalyzeRecommandProductListEnabled(loadOptions)){
	 		analyzeRecommandProductList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceSiteList(SmartList<Site> siteList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractSiteList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Site> siteList = getSiteDAO().findSiteByPlatform(platform.getId(),options);
		if(siteList != null){
			enhanceSiteList(siteList,options);
			platform.setSiteList(siteList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeSiteList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Site> siteList = platform.getSiteList();
		if(siteList != null){
			getSiteDAO().analyzeSiteByPlatform(siteList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractCatalogList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Catalog> catalogList = getCatalogDAO().findCatalogByPlatform(platform.getId(),options);
		if(catalogList != null){
			enhanceCatalogList(catalogList,options);
			platform.setCatalogList(catalogList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeCatalogList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();
		if(catalogList != null){
			getCatalogDAO().analyzeCatalogByPlatform(catalogList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceBrandList(SmartList<Brand> brandList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractBrandList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Brand> brandList = getBrandDAO().findBrandByPlatform(platform.getId(),options);
		if(brandList != null){
			enhanceBrandList(brandList,options);
			platform.setBrandList(brandList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeBrandList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Brand> brandList = platform.getBrandList();
		if(brandList != null){
			getBrandDAO().analyzeBrandByPlatform(brandList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByPlatform(platform.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			platform.setProductList(productList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Product> productList = platform.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByPlatform(productList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceBannerList(SmartList<Banner> bannerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractBannerList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Banner> bannerList = getBannerDAO().findBannerByPlatform(platform.getId(),options);
		if(bannerList != null){
			enhanceBannerList(bannerList,options);
			platform.setBannerList(bannerList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeBannerList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList != null){
			getBannerDAO().analyzeBannerByPlatform(bannerList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = getProfileDAO().findProfileByPlatform(platform.getId(),options);
		if(profileList != null){
			enhanceProfileList(profileList,options);
			platform.setProfileList(profileList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList != null){
			getProfileDAO().analyzeProfileByPlatform(profileList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceUserAlertList(SmartList<UserAlert> userAlertList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractUserAlertList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<UserAlert> userAlertList = getUserAlertDAO().findUserAlertByPlatform(platform.getId(),options);
		if(userAlertList != null){
			enhanceUserAlertList(userAlertList,options);
			platform.setUserAlertList(userAlertList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeUserAlertList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();
		if(userAlertList != null){
			getUserAlertDAO().analyzeUserAlertByPlatform(userAlertList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractNewProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<NewProduct> newProductList = getNewProductDAO().findNewProductByPlatform(platform.getId(),options);
		if(newProductList != null){
			enhanceNewProductList(newProductList,options);
			platform.setNewProductList(newProductList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeNewProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<NewProduct> newProductList = platform.getNewProductList();
		if(newProductList != null){
			getNewProductDAO().analyzeNewProductByPlatform(newProductList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractEditorPickProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = getEditorPickProductDAO().findEditorPickProductByPlatform(platform.getId(),options);
		if(editorPickProductList != null){
			enhanceEditorPickProductList(editorPickProductList,options);
			platform.setEditorPickProductList(editorPickProductList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeEditorPickProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();
		if(editorPickProductList != null){
			getEditorPickProductDAO().analyzeEditorPickProductByPlatform(editorPickProductList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractTopRatedProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = getTopRatedProductDAO().findTopRatedProductByPlatform(platform.getId(),options);
		if(topRatedProductList != null){
			enhanceTopRatedProductList(topRatedProductList,options);
			platform.setTopRatedProductList(topRatedProductList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeTopRatedProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();
		if(topRatedProductList != null){
			getTopRatedProductDAO().analyzeTopRatedProductByPlatform(topRatedProductList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractRecommandProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = getRecommandProductDAO().findRecommandProductByPlatform(platform.getId(),options);
		if(recommandProductList != null){
			enhanceRecommandProductList(recommandProductList,options);
			platform.setRecommandProductList(recommandProductList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeRecommandProductList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();
		if(recommandProductList != null){
			getRecommandProductDAO().analyzeRecommandProductByPlatform(recommandProductList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = platform.getName();		
 		parameters[1] = platform.nextVersion();
 		parameters[2] = platform.getId();
 		parameters[3] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[2];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveSiteListEnabled(options)){
	 		saveSiteList(platform, options);
	 		//removeSiteList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveCatalogListEnabled(options)){
	 		saveCatalogList(platform, options);
	 		//removeCatalogList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveBrandListEnabled(options)){
	 		saveBrandList(platform, options);
	 		//removeBrandList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(platform, options);
	 		//removeProductList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveBannerListEnabled(options)){
	 		saveBannerList(platform, options);
	 		//removeBannerList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProfileListEnabled(options)){
	 		saveProfileList(platform, options);
	 		//removeProfileList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveUserAlertListEnabled(options)){
	 		saveUserAlertList(platform, options);
	 		//removeUserAlertList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveNewProductListEnabled(options)){
	 		saveNewProductList(platform, options);
	 		//removeNewProductList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveEditorPickProductListEnabled(options)){
	 		saveEditorPickProductList(platform, options);
	 		//removeEditorPickProductList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTopRatedProductListEnabled(options)){
	 		saveTopRatedProductList(platform, options);
	 		//removeTopRatedProductList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRecommandProductListEnabled(options)){
	 		saveRecommandProductList(platform, options);
	 		//removeRecommandProductList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveSiteList(Platform platform, String siteIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Site.PLATFORM_PROPERTY, platform.getId());
		key.put(Site.ID_PROPERTY, siteIds);
		
		SmartList<Site> externalSiteList = getSiteDAO().
				findSiteWithKey(key, options);
		if(externalSiteList == null){
			return platform;
		}
		if(externalSiteList.isEmpty()){
			return platform;
		}
		
		for(Site site: externalSiteList){

			site.clearFromAll();
		}
		
		
		SmartList<Site> siteList = platform.getSiteList();		
		siteList.addAllToRemoveList(externalSiteList);
		return platform;	
	
	}


	public Platform planToRemoveCatalogList(Platform platform, String catalogIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platform.getId());
		key.put(Catalog.ID_PROPERTY, catalogIds);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return platform;
		}
		if(externalCatalogList.isEmpty()){
			return platform;
		}
		
		for(Catalog catalog: externalCatalogList){

			catalog.clearFromAll();
		}
		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return platform;	
	
	}


	//disconnect Platform with seller_id in Catalog
	public Platform planToRemoveCatalogListWithSellerId(Platform platform, String sellerIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platform.getId());
		key.put(Catalog.SELLER_ID_PROPERTY, sellerIdId);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return platform;
		}
		if(externalCatalogList.isEmpty()){
			return platform;
		}
		
		for(Catalog catalog: externalCatalogList){
			catalog.clearSellerId();
			catalog.clearPlatform();
			
		}
		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return platform;
	}
	
	public int countCatalogListWithSellerId(String platformId, String sellerIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platformId);
		key.put(Catalog.SELLER_ID_PROPERTY, sellerIdId);
		
		int count = getCatalogDAO().countCatalogWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with site in Catalog
	public Platform planToRemoveCatalogListWithSite(Platform platform, String siteId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platform.getId());
		key.put(Catalog.SITE_PROPERTY, siteId);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return platform;
		}
		if(externalCatalogList.isEmpty()){
			return platform;
		}
		
		for(Catalog catalog: externalCatalogList){
			catalog.clearSite();
			catalog.clearPlatform();
			
		}
		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return platform;
	}
	
	public int countCatalogListWithSite(String platformId, String siteId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.PLATFORM_PROPERTY, platformId);
		key.put(Catalog.SITE_PROPERTY, siteId);
		
		int count = getCatalogDAO().countCatalogWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveBrandList(Platform platform, String brandIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Brand.PLATFORM_PROPERTY, platform.getId());
		key.put(Brand.ID_PROPERTY, brandIds);
		
		SmartList<Brand> externalBrandList = getBrandDAO().
				findBrandWithKey(key, options);
		if(externalBrandList == null){
			return platform;
		}
		if(externalBrandList.isEmpty()){
			return platform;
		}
		
		for(Brand brand: externalBrandList){

			brand.clearFromAll();
		}
		
		
		SmartList<Brand> brandList = platform.getBrandList();		
		brandList.addAllToRemoveList(externalBrandList);
		return platform;	
	
	}


	public Platform planToRemoveProductList(Platform platform, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;	
	
	}


	//disconnect Platform with parent_category in Product
	public Platform planToRemoveProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){
			product.clearParentCategory();
			product.clearPlatform();
			
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;
	}
	
	public int countProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platformId);
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with brand in Product
	public Platform planToRemoveProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.BRAND_PROPERTY, brandId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){
			product.clearBrand();
			product.clearPlatform();
			
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;
	}
	
	public int countProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platformId);
		key.put(Product.BRAND_PROPERTY, brandId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with catalog in Product
	public Platform planToRemoveProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platform.getId());
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return platform;
		}
		if(externalProductList.isEmpty()){
			return platform;
		}
		
		for(Product product: externalProductList){
			product.clearCatalog();
			product.clearPlatform();
			
		}
		
		
		SmartList<Product> productList = platform.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return platform;
	}
	
	public int countProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PLATFORM_PROPERTY, platformId);
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveBannerList(Platform platform, String bannerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Banner.PLATFORM_PROPERTY, platform.getId());
		key.put(Banner.ID_PROPERTY, bannerIds);
		
		SmartList<Banner> externalBannerList = getBannerDAO().
				findBannerWithKey(key, options);
		if(externalBannerList == null){
			return platform;
		}
		if(externalBannerList.isEmpty()){
			return platform;
		}
		
		for(Banner banner: externalBannerList){

			banner.clearFromAll();
		}
		
		
		SmartList<Banner> bannerList = platform.getBannerList();		
		bannerList.addAllToRemoveList(externalBannerList);
		return platform;	
	
	}


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Profile.PLATFORM_PROPERTY, platform.getId());
		key.put(Profile.ID_PROPERTY, profileIds);
		
		SmartList<Profile> externalProfileList = getProfileDAO().
				findProfileWithKey(key, options);
		if(externalProfileList == null){
			return platform;
		}
		if(externalProfileList.isEmpty()){
			return platform;
		}
		
		for(Profile profile: externalProfileList){

			profile.clearFromAll();
		}
		
		
		SmartList<Profile> profileList = platform.getProfileList();		
		profileList.addAllToRemoveList(externalProfileList);
		return platform;	
	
	}


	public Platform planToRemoveUserAlertList(Platform platform, String userAlertIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PLATFORM_PROPERTY, platform.getId());
		key.put(UserAlert.ID_PROPERTY, userAlertIds);
		
		SmartList<UserAlert> externalUserAlertList = getUserAlertDAO().
				findUserAlertWithKey(key, options);
		if(externalUserAlertList == null){
			return platform;
		}
		if(externalUserAlertList.isEmpty()){
			return platform;
		}
		
		for(UserAlert userAlert: externalUserAlertList){

			userAlert.clearFromAll();
		}
		
		
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();		
		userAlertList.addAllToRemoveList(externalUserAlertList);
		return platform;	
	
	}


	//disconnect Platform with profile in UserAlert
	public Platform planToRemoveUserAlertListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PLATFORM_PROPERTY, platform.getId());
		key.put(UserAlert.PROFILE_PROPERTY, profileId);
		
		SmartList<UserAlert> externalUserAlertList = getUserAlertDAO().
				findUserAlertWithKey(key, options);
		if(externalUserAlertList == null){
			return platform;
		}
		if(externalUserAlertList.isEmpty()){
			return platform;
		}
		
		for(UserAlert userAlert: externalUserAlertList){
			userAlert.clearProfile();
			userAlert.clearPlatform();
			
		}
		
		
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();		
		userAlertList.addAllToRemoveList(externalUserAlertList);
		return platform;
	}
	
	public int countUserAlertListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PLATFORM_PROPERTY, platformId);
		key.put(UserAlert.PROFILE_PROPERTY, profileId);
		
		int count = getUserAlertDAO().countUserAlertWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveNewProductList(Platform platform, String newProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(NewProduct.ID_PROPERTY, newProductIds);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return platform;
		}
		if(externalNewProductList.isEmpty()){
			return platform;
		}
		
		for(NewProduct newProduct: externalNewProductList){

			newProduct.clearFromAll();
		}
		
		
		SmartList<NewProduct> newProductList = platform.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return platform;	
	
	}


	//disconnect Platform with parent_category in NewProduct
	public Platform planToRemoveNewProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return platform;
		}
		if(externalNewProductList.isEmpty()){
			return platform;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearParentCategory();
			newProduct.clearPlatform();
			
		}
		
		
		SmartList<NewProduct> newProductList = platform.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return platform;
	}
	
	public int countNewProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with brand in NewProduct
	public Platform planToRemoveNewProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return platform;
		}
		if(externalNewProductList.isEmpty()){
			return platform;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearBrand();
			newProduct.clearPlatform();
			
		}
		
		
		SmartList<NewProduct> newProductList = platform.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return platform;
	}
	
	public int countNewProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with catalog in NewProduct
	public Platform planToRemoveNewProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return platform;
		}
		if(externalNewProductList.isEmpty()){
			return platform;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearCatalog();
			newProduct.clearPlatform();
			
		}
		
		
		SmartList<NewProduct> newProductList = platform.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return platform;
	}
	
	public int countNewProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with profile in NewProduct
	public Platform planToRemoveNewProductListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return platform;
		}
		if(externalNewProductList.isEmpty()){
			return platform;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearProfile();
			newProduct.clearPlatform();
			
		}
		
		
		SmartList<NewProduct> newProductList = platform.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return platform;
	}
	
	public int countNewProductListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveEditorPickProductList(Platform platform, String editorPickProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(EditorPickProduct.ID_PROPERTY, editorPickProductIds);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return platform;
		}
		if(externalEditorPickProductList.isEmpty()){
			return platform;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){

			editorPickProduct.clearFromAll();
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return platform;	
	
	}


	//disconnect Platform with parent_category in EditorPickProduct
	public Platform planToRemoveEditorPickProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return platform;
		}
		if(externalEditorPickProductList.isEmpty()){
			return platform;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearParentCategory();
			editorPickProduct.clearPlatform();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return platform;
	}
	
	public int countEditorPickProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with brand in EditorPickProduct
	public Platform planToRemoveEditorPickProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return platform;
		}
		if(externalEditorPickProductList.isEmpty()){
			return platform;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearBrand();
			editorPickProduct.clearPlatform();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return platform;
	}
	
	public int countEditorPickProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with catalog in EditorPickProduct
	public Platform planToRemoveEditorPickProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return platform;
		}
		if(externalEditorPickProductList.isEmpty()){
			return platform;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearCatalog();
			editorPickProduct.clearPlatform();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return platform;
	}
	
	public int countEditorPickProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with profile in EditorPickProduct
	public Platform planToRemoveEditorPickProductListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return platform;
		}
		if(externalEditorPickProductList.isEmpty()){
			return platform;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearProfile();
			editorPickProduct.clearPlatform();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return platform;
	}
	
	public int countEditorPickProductListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveTopRatedProductList(Platform platform, String topRatedProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(TopRatedProduct.ID_PROPERTY, topRatedProductIds);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return platform;
		}
		if(externalTopRatedProductList.isEmpty()){
			return platform;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){

			topRatedProduct.clearFromAll();
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return platform;	
	
	}


	//disconnect Platform with parent_category in TopRatedProduct
	public Platform planToRemoveTopRatedProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return platform;
		}
		if(externalTopRatedProductList.isEmpty()){
			return platform;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearParentCategory();
			topRatedProduct.clearPlatform();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return platform;
	}
	
	public int countTopRatedProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with brand in TopRatedProduct
	public Platform planToRemoveTopRatedProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return platform;
		}
		if(externalTopRatedProductList.isEmpty()){
			return platform;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearBrand();
			topRatedProduct.clearPlatform();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return platform;
	}
	
	public int countTopRatedProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with catalog in TopRatedProduct
	public Platform planToRemoveTopRatedProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return platform;
		}
		if(externalTopRatedProductList.isEmpty()){
			return platform;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearCatalog();
			topRatedProduct.clearPlatform();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return platform;
	}
	
	public int countTopRatedProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with profile in TopRatedProduct
	public Platform planToRemoveTopRatedProductListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return platform;
		}
		if(externalTopRatedProductList.isEmpty()){
			return platform;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearProfile();
			topRatedProduct.clearPlatform();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return platform;
	}
	
	public int countTopRatedProductListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveRecommandProductList(Platform platform, String recommandProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(RecommandProduct.ID_PROPERTY, recommandProductIds);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return platform;
		}
		if(externalRecommandProductList.isEmpty()){
			return platform;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){

			recommandProduct.clearFromAll();
		}
		
		
		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return platform;	
	
	}


	//disconnect Platform with parent_category in RecommandProduct
	public Platform planToRemoveRecommandProductListWithParentCategory(Platform platform, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return platform;
		}
		if(externalRecommandProductList.isEmpty()){
			return platform;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearParentCategory();
			recommandProduct.clearPlatform();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return platform;
	}
	
	public int countRecommandProductListWithParentCategory(String platformId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with brand in RecommandProduct
	public Platform planToRemoveRecommandProductListWithBrand(Platform platform, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return platform;
		}
		if(externalRecommandProductList.isEmpty()){
			return platform;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearBrand();
			recommandProduct.clearPlatform();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return platform;
	}
	
	public int countRecommandProductListWithBrand(String platformId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with catalog in RecommandProduct
	public Platform planToRemoveRecommandProductListWithCatalog(Platform platform, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return platform;
		}
		if(externalRecommandProductList.isEmpty()){
			return platform;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearCatalog();
			recommandProduct.clearPlatform();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return platform;
	}
	
	public int countRecommandProductListWithCatalog(String platformId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with profile in RecommandProduct
	public Platform planToRemoveRecommandProductListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platform.getId());
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return platform;
		}
		if(externalRecommandProductList.isEmpty()){
			return platform;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearProfile();
			recommandProduct.clearPlatform();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return platform;
	}
	
	public int countRecommandProductListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	

		
	protected Platform saveSiteList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Site> siteList = platform.getSiteList();
		if(siteList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Site> mergedUpdateSiteList = new SmartList<Site>();
		
		
		mergedUpdateSiteList.addAll(siteList); 
		if(siteList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSiteList.addAll(siteList.getToRemoveList());
			siteList.removeAll(siteList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSiteDAO().saveSiteList(mergedUpdateSiteList,options);
		
		if(siteList.getToRemoveList() != null){
			siteList.removeAll(siteList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeSiteList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Site> siteList = platform.getSiteList();
		if(siteList == null){
			return platform;
		}	
	
		SmartList<Site> toRemoveSiteList = siteList.getToRemoveList();
		
		if(toRemoveSiteList == null){
			return platform;
		}
		if(toRemoveSiteList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSiteDAO().removeSiteList(toRemoveSiteList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveCatalogList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Catalog> catalogList = platform.getCatalogList();
		if(catalogList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Catalog> mergedUpdateCatalogList = new SmartList<Catalog>();
		
		
		mergedUpdateCatalogList.addAll(catalogList); 
		if(catalogList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCatalogList.addAll(catalogList.getToRemoveList());
			catalogList.removeAll(catalogList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCatalogDAO().saveCatalogList(mergedUpdateCatalogList,options);
		
		if(catalogList.getToRemoveList() != null){
			catalogList.removeAll(catalogList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeCatalogList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Catalog> catalogList = platform.getCatalogList();
		if(catalogList == null){
			return platform;
		}	
	
		SmartList<Catalog> toRemoveCatalogList = catalogList.getToRemoveList();
		
		if(toRemoveCatalogList == null){
			return platform;
		}
		if(toRemoveCatalogList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCatalogDAO().removeCatalogList(toRemoveCatalogList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveBrandList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Brand> brandList = platform.getBrandList();
		if(brandList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Brand> mergedUpdateBrandList = new SmartList<Brand>();
		
		
		mergedUpdateBrandList.addAll(brandList); 
		if(brandList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateBrandList.addAll(brandList.getToRemoveList());
			brandList.removeAll(brandList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getBrandDAO().saveBrandList(mergedUpdateBrandList,options);
		
		if(brandList.getToRemoveList() != null){
			brandList.removeAll(brandList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeBrandList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Brand> brandList = platform.getBrandList();
		if(brandList == null){
			return platform;
		}	
	
		SmartList<Brand> toRemoveBrandList = brandList.getToRemoveList();
		
		if(toRemoveBrandList == null){
			return platform;
		}
		if(toRemoveBrandList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getBrandDAO().removeBrandList(toRemoveBrandList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveProductList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = platform.getProductList();
		if(productList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Product> mergedUpdateProductList = new SmartList<Product>();
		
		
		mergedUpdateProductList.addAll(productList); 
		if(productList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProductList.addAll(productList.getToRemoveList());
			productList.removeAll(productList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProductDAO().saveProductList(mergedUpdateProductList,options);
		
		if(productList.getToRemoveList() != null){
			productList.removeAll(productList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeProductList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Product> productList = platform.getProductList();
		if(productList == null){
			return platform;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return platform;
		}
		if(toRemoveProductList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveBannerList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Banner> mergedUpdateBannerList = new SmartList<Banner>();
		
		
		mergedUpdateBannerList.addAll(bannerList); 
		if(bannerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateBannerList.addAll(bannerList.getToRemoveList());
			bannerList.removeAll(bannerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getBannerDAO().saveBannerList(mergedUpdateBannerList,options);
		
		if(bannerList.getToRemoveList() != null){
			bannerList.removeAll(bannerList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeBannerList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList == null){
			return platform;
		}	
	
		SmartList<Banner> toRemoveBannerList = bannerList.getToRemoveList();
		
		if(toRemoveBannerList == null){
			return platform;
		}
		if(toRemoveBannerList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getBannerDAO().removeBannerList(toRemoveBannerList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveProfileList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Profile> mergedUpdateProfileList = new SmartList<Profile>();
		
		
		mergedUpdateProfileList.addAll(profileList); 
		if(profileList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProfileList.addAll(profileList.getToRemoveList());
			profileList.removeAll(profileList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProfileDAO().saveProfileList(mergedUpdateProfileList,options);
		
		if(profileList.getToRemoveList() != null){
			profileList.removeAll(profileList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeProfileList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			return platform;
		}	
	
		SmartList<Profile> toRemoveProfileList = profileList.getToRemoveList();
		
		if(toRemoveProfileList == null){
			return platform;
		}
		if(toRemoveProfileList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProfileDAO().removeProfileList(toRemoveProfileList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveUserAlertList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();
		if(userAlertList == null){
			//null list means nothing
			return platform;
		}
		SmartList<UserAlert> mergedUpdateUserAlertList = new SmartList<UserAlert>();
		
		
		mergedUpdateUserAlertList.addAll(userAlertList); 
		if(userAlertList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserAlertList.addAll(userAlertList.getToRemoveList());
			userAlertList.removeAll(userAlertList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserAlertDAO().saveUserAlertList(mergedUpdateUserAlertList,options);
		
		if(userAlertList.getToRemoveList() != null){
			userAlertList.removeAll(userAlertList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeUserAlertList(Platform platform, Map<String,Object> options){
	
	
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();
		if(userAlertList == null){
			return platform;
		}	
	
		SmartList<UserAlert> toRemoveUserAlertList = userAlertList.getToRemoveList();
		
		if(toRemoveUserAlertList == null){
			return platform;
		}
		if(toRemoveUserAlertList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserAlertDAO().removeUserAlertList(toRemoveUserAlertList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveNewProductList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<NewProduct> newProductList = platform.getNewProductList();
		if(newProductList == null){
			//null list means nothing
			return platform;
		}
		SmartList<NewProduct> mergedUpdateNewProductList = new SmartList<NewProduct>();
		
		
		mergedUpdateNewProductList.addAll(newProductList); 
		if(newProductList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateNewProductList.addAll(newProductList.getToRemoveList());
			newProductList.removeAll(newProductList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getNewProductDAO().saveNewProductList(mergedUpdateNewProductList,options);
		
		if(newProductList.getToRemoveList() != null){
			newProductList.removeAll(newProductList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeNewProductList(Platform platform, Map<String,Object> options){
	
	
		SmartList<NewProduct> newProductList = platform.getNewProductList();
		if(newProductList == null){
			return platform;
		}	
	
		SmartList<NewProduct> toRemoveNewProductList = newProductList.getToRemoveList();
		
		if(toRemoveNewProductList == null){
			return platform;
		}
		if(toRemoveNewProductList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNewProductDAO().removeNewProductList(toRemoveNewProductList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveEditorPickProductList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();
		if(editorPickProductList == null){
			//null list means nothing
			return platform;
		}
		SmartList<EditorPickProduct> mergedUpdateEditorPickProductList = new SmartList<EditorPickProduct>();
		
		
		mergedUpdateEditorPickProductList.addAll(editorPickProductList); 
		if(editorPickProductList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEditorPickProductList.addAll(editorPickProductList.getToRemoveList());
			editorPickProductList.removeAll(editorPickProductList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getEditorPickProductDAO().saveEditorPickProductList(mergedUpdateEditorPickProductList,options);
		
		if(editorPickProductList.getToRemoveList() != null){
			editorPickProductList.removeAll(editorPickProductList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeEditorPickProductList(Platform platform, Map<String,Object> options){
	
	
		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();
		if(editorPickProductList == null){
			return platform;
		}	
	
		SmartList<EditorPickProduct> toRemoveEditorPickProductList = editorPickProductList.getToRemoveList();
		
		if(toRemoveEditorPickProductList == null){
			return platform;
		}
		if(toRemoveEditorPickProductList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEditorPickProductDAO().removeEditorPickProductList(toRemoveEditorPickProductList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveTopRatedProductList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();
		if(topRatedProductList == null){
			//null list means nothing
			return platform;
		}
		SmartList<TopRatedProduct> mergedUpdateTopRatedProductList = new SmartList<TopRatedProduct>();
		
		
		mergedUpdateTopRatedProductList.addAll(topRatedProductList); 
		if(topRatedProductList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTopRatedProductList.addAll(topRatedProductList.getToRemoveList());
			topRatedProductList.removeAll(topRatedProductList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTopRatedProductDAO().saveTopRatedProductList(mergedUpdateTopRatedProductList,options);
		
		if(topRatedProductList.getToRemoveList() != null){
			topRatedProductList.removeAll(topRatedProductList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeTopRatedProductList(Platform platform, Map<String,Object> options){
	
	
		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();
		if(topRatedProductList == null){
			return platform;
		}	
	
		SmartList<TopRatedProduct> toRemoveTopRatedProductList = topRatedProductList.getToRemoveList();
		
		if(toRemoveTopRatedProductList == null){
			return platform;
		}
		if(toRemoveTopRatedProductList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTopRatedProductDAO().removeTopRatedProductList(toRemoveTopRatedProductList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveRecommandProductList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();
		if(recommandProductList == null){
			//null list means nothing
			return platform;
		}
		SmartList<RecommandProduct> mergedUpdateRecommandProductList = new SmartList<RecommandProduct>();
		
		
		mergedUpdateRecommandProductList.addAll(recommandProductList); 
		if(recommandProductList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRecommandProductList.addAll(recommandProductList.getToRemoveList());
			recommandProductList.removeAll(recommandProductList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRecommandProductDAO().saveRecommandProductList(mergedUpdateRecommandProductList,options);
		
		if(recommandProductList.getToRemoveList() != null){
			recommandProductList.removeAll(recommandProductList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeRecommandProductList(Platform platform, Map<String,Object> options){
	
	
		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();
		if(recommandProductList == null){
			return platform;
		}	
	
		SmartList<RecommandProduct> toRemoveRecommandProductList = recommandProductList.getToRemoveList();
		
		if(toRemoveRecommandProductList == null){
			return platform;
		}
		if(toRemoveRecommandProductList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRecommandProductDAO().removeRecommandProductList(toRemoveRecommandProductList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentSiteList(platform,options);
		presentCatalogList(platform,options);
		presentBrandList(platform,options);
		presentProductList(platform,options);
		presentBannerList(platform,options);
		presentProfileList(platform,options);
		presentUserAlertList(platform,options);
		presentNewProductList(platform,options);
		presentEditorPickProductList(platform,options);
		presentTopRatedProductList(platform,options);
		presentRecommandProductList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentSiteList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Site> siteList = platform.getSiteList();		
				SmartList<Site> newList= presentSubList(platform.getId(),
				siteList,
				options,
				getSiteDAO()::countSiteByPlatform,
				getSiteDAO()::findSiteByPlatform
				);

		
		platform.setSiteList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentCatalogList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Catalog> catalogList = platform.getCatalogList();		
				SmartList<Catalog> newList= presentSubList(platform.getId(),
				catalogList,
				options,
				getCatalogDAO()::countCatalogByPlatform,
				getCatalogDAO()::findCatalogByPlatform
				);

		
		platform.setCatalogList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentBrandList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Brand> brandList = platform.getBrandList();		
				SmartList<Brand> newList= presentSubList(platform.getId(),
				brandList,
				options,
				getBrandDAO()::countBrandByPlatform,
				getBrandDAO()::findBrandByPlatform
				);

		
		platform.setBrandList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProductList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Product> productList = platform.getProductList();		
				SmartList<Product> newList= presentSubList(platform.getId(),
				productList,
				options,
				getProductDAO()::countProductByPlatform,
				getProductDAO()::findProductByPlatform
				);

		
		platform.setProductList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentBannerList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Banner> bannerList = platform.getBannerList();		
				SmartList<Banner> newList= presentSubList(platform.getId(),
				bannerList,
				options,
				getBannerDAO()::countBannerByPlatform,
				getBannerDAO()::findBannerByPlatform
				);

		
		platform.setBannerList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProfileList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Profile> profileList = platform.getProfileList();		
				SmartList<Profile> newList= presentSubList(platform.getId(),
				profileList,
				options,
				getProfileDAO()::countProfileByPlatform,
				getProfileDAO()::findProfileByPlatform
				);

		
		platform.setProfileList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentUserAlertList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<UserAlert> userAlertList = platform.getUserAlertList();		
				SmartList<UserAlert> newList= presentSubList(platform.getId(),
				userAlertList,
				options,
				getUserAlertDAO()::countUserAlertByPlatform,
				getUserAlertDAO()::findUserAlertByPlatform
				);

		
		platform.setUserAlertList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentNewProductList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<NewProduct> newProductList = platform.getNewProductList();		
				SmartList<NewProduct> newList= presentSubList(platform.getId(),
				newProductList,
				options,
				getNewProductDAO()::countNewProductByPlatform,
				getNewProductDAO()::findNewProductByPlatform
				);

		
		platform.setNewProductList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentEditorPickProductList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<EditorPickProduct> editorPickProductList = platform.getEditorPickProductList();		
				SmartList<EditorPickProduct> newList= presentSubList(platform.getId(),
				editorPickProductList,
				options,
				getEditorPickProductDAO()::countEditorPickProductByPlatform,
				getEditorPickProductDAO()::findEditorPickProductByPlatform
				);

		
		platform.setEditorPickProductList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentTopRatedProductList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<TopRatedProduct> topRatedProductList = platform.getTopRatedProductList();		
				SmartList<TopRatedProduct> newList= presentSubList(platform.getId(),
				topRatedProductList,
				options,
				getTopRatedProductDAO()::countTopRatedProductByPlatform,
				getTopRatedProductDAO()::findTopRatedProductByPlatform
				);

		
		platform.setTopRatedProductList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentRecommandProductList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<RecommandProduct> recommandProductList = platform.getRecommandProductList();		
				SmartList<RecommandProduct> newList= presentSubList(platform.getId(),
				recommandProductList,
				options,
				getRecommandProductDAO()::countRecommandProductByPlatform,
				getRecommandProductDAO()::findRecommandProductByPlatform
				);

		
		platform.setRecommandProductList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForSite(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForCatalog(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForBrand(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForBanner(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForProfile(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForUserAlert(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
}


