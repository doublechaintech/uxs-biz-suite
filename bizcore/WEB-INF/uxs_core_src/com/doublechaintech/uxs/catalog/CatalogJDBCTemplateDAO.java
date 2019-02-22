
package com.doublechaintech.uxs.catalog;

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


import com.doublechaintech.uxs.levelonecategory.LevelOneCategory;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;

import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.site.SiteDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class CatalogJDBCTemplateDAO extends UxsNamingServiceDAO implements CatalogDAO{
 
 	
 	private  SiteDAO  siteDAO;
 	public void setSiteDAO(SiteDAO siteDAO){
	 	this.siteDAO = siteDAO;
 	}
 	public SiteDAO getSiteDAO(){
	 	return this.siteDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  LevelOneCategoryDAO  levelOneCategoryDAO;
 	public void setLevelOneCategoryDAO(LevelOneCategoryDAO pLevelOneCategoryDAO){
 	
 		if(pLevelOneCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneCategoryDAO to null.");
 		}
	 	this.levelOneCategoryDAO = pLevelOneCategoryDAO;
 	}
 	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
 		if(this.levelOneCategoryDAO == null){
 			throw new IllegalStateException("The levelOneCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelOneCategoryDAO;
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
	protected Catalog load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCatalog(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Catalog load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCatalog(CatalogTable.withId(id), options);
	}
	
	
	
	public Catalog save(Catalog catalog,Map<String,Object> options){
		
		String methodName="save(Catalog catalog,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(catalog, methodName, "catalog");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCatalog(catalog,options);
	}
	public Catalog clone(String catalogId, Map<String,Object> options) throws Exception{
	
		return clone(CatalogTable.withId(catalogId),options);
	}
	
	protected Catalog clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String catalogId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Catalog newCatalog = loadInternalCatalog(accessKey, options);
		newCatalog.setVersion(0);
		
		
 		
 		if(isSaveLevelOneCategoryListEnabled(options)){
 			for(LevelOneCategory item: newCatalog.getLevelOneCategoryList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newCatalog.getProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveNewProductListEnabled(options)){
 			for(NewProduct item: newCatalog.getNewProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEditorPickProductListEnabled(options)){
 			for(EditorPickProduct item: newCatalog.getEditorPickProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTopRatedProductListEnabled(options)){
 			for(TopRatedProduct item: newCatalog.getTopRatedProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRecommandProductListEnabled(options)){
 			for(RecommandProduct item: newCatalog.getRecommandProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCatalog(newCatalog,options);
		
		return newCatalog;
	}
	
	
	
	

	protected void throwIfHasException(String catalogId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CatalogVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CatalogNotFoundException(
					"The " + this.getTableName() + "(" + catalogId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String catalogId, int version) throws Exception{
	
		String methodName="delete(String catalogId, int version)";
		assertMethodArgumentNotNull(catalogId, methodName, "catalogId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{catalogId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(catalogId,version);
		}
		
	
	}
	
	
	
	
	

	public Catalog disconnectFromAll(String catalogId, int version) throws Exception{
	
		
		Catalog catalog = loadInternalCatalog(CatalogTable.withId(catalogId), emptyOptions());
		catalog.clearFromAll();
		this.saveCatalog(catalog);
		return catalog;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return CatalogTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "catalog";
	}
	@Override
	protected String getBeanName() {
		
		return "catalog";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CatalogTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSiteEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CatalogTokens.SITE);
 	}

 	protected boolean isSaveSiteEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CatalogTokens.SITE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CatalogTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CatalogTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractLevelOneCategoryListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.LEVEL_ONE_CATEGORY_LIST);
 	}
 	protected boolean isAnalyzeLevelOneCategoryListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,CatalogTokens.LEVEL_ONE_CATEGORY_LIST+".analyze");
 	}
	
	protected boolean isSaveLevelOneCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.LEVEL_ONE_CATEGORY_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,CatalogTokens.PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractNewProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.NEW_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeNewProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,CatalogTokens.NEW_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveNewProductListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.NEW_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractEditorPickProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.EDITOR_PICK_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeEditorPickProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,CatalogTokens.EDITOR_PICK_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveEditorPickProductListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.EDITOR_PICK_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTopRatedProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.TOP_RATED_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeTopRatedProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,CatalogTokens.TOP_RATED_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveTopRatedProductListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.TOP_RATED_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRecommandProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.RECOMMAND_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeRecommandProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,CatalogTokens.RECOMMAND_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveRecommandProductListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.RECOMMAND_PRODUCT_LIST);
		
 	}
 	
		

	

	protected CatalogMapper getCatalogMapper(){
		return new CatalogMapper();
	}

	
	
	protected Catalog extractCatalog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Catalog catalog = loadSingleObject(accessKey, getCatalogMapper());
			return catalog;
		}catch(EmptyResultDataAccessException e){
			throw new CatalogNotFoundException("Catalog("+accessKey+") is not found!");
		}

	}

	
	

	protected Catalog loadInternalCatalog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Catalog catalog = extractCatalog(accessKey, loadOptions);
 	
 		if(isExtractSiteEnabled(loadOptions)){
	 		extractSite(catalog, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(catalog, loadOptions);
 		}
 
		
		if(isExtractLevelOneCategoryListEnabled(loadOptions)){
	 		extractLevelOneCategoryList(catalog, loadOptions);
 		}	
 		if(isAnalyzeLevelOneCategoryListEnabled(loadOptions)){
	 		analyzeLevelOneCategoryList(catalog, loadOptions);
 		}
 		
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(catalog, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		analyzeProductList(catalog, loadOptions);
 		}
 		
		
		if(isExtractNewProductListEnabled(loadOptions)){
	 		extractNewProductList(catalog, loadOptions);
 		}	
 		if(isAnalyzeNewProductListEnabled(loadOptions)){
	 		analyzeNewProductList(catalog, loadOptions);
 		}
 		
		
		if(isExtractEditorPickProductListEnabled(loadOptions)){
	 		extractEditorPickProductList(catalog, loadOptions);
 		}	
 		if(isAnalyzeEditorPickProductListEnabled(loadOptions)){
	 		analyzeEditorPickProductList(catalog, loadOptions);
 		}
 		
		
		if(isExtractTopRatedProductListEnabled(loadOptions)){
	 		extractTopRatedProductList(catalog, loadOptions);
 		}	
 		if(isAnalyzeTopRatedProductListEnabled(loadOptions)){
	 		analyzeTopRatedProductList(catalog, loadOptions);
 		}
 		
		
		if(isExtractRecommandProductListEnabled(loadOptions)){
	 		extractRecommandProductList(catalog, loadOptions);
 		}	
 		if(isAnalyzeRecommandProductListEnabled(loadOptions)){
	 		analyzeRecommandProductList(catalog, loadOptions);
 		}
 		
		
		return catalog;
		
	}

	 

 	protected Catalog extractSite(Catalog catalog, Map<String,Object> options) throws Exception{

		if(catalog.getSite() == null){
			return catalog;
		}
		String siteId = catalog.getSite().getId();
		if( siteId == null){
			return catalog;
		}
		Site site = getSiteDAO().load(siteId,options);
		if(site != null){
			catalog.setSite(site);
		}
		
 		
 		return catalog;
 	}
 		
  

 	protected Catalog extractPlatform(Catalog catalog, Map<String,Object> options) throws Exception{

		if(catalog.getPlatform() == null){
			return catalog;
		}
		String platformId = catalog.getPlatform().getId();
		if( platformId == null){
			return catalog;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			catalog.setPlatform(platform);
		}
		
 		
 		return catalog;
 	}
 		
 
		
	protected void enhanceLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<LevelOneCategory> levelOneCategoryList = getLevelOneCategoryDAO().findLevelOneCategoryByCatalog(catalog.getId(),options);
		if(levelOneCategoryList != null){
			enhanceLevelOneCategoryList(levelOneCategoryList,options);
			catalog.setLevelOneCategoryList(levelOneCategoryList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList != null){
			getLevelOneCategoryDAO().analyzeLevelOneCategoryByCatalog(levelOneCategoryList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByCatalog(catalog.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			catalog.setProductList(productList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<Product> productList = catalog.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByCatalog(productList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
	protected void enhanceNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractNewProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<NewProduct> newProductList = getNewProductDAO().findNewProductByCatalog(catalog.getId(),options);
		if(newProductList != null){
			enhanceNewProductList(newProductList,options);
			catalog.setNewProductList(newProductList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeNewProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<NewProduct> newProductList = catalog.getNewProductList();
		if(newProductList != null){
			getNewProductDAO().analyzeNewProductByCatalog(newProductList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
	protected void enhanceEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractEditorPickProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = getEditorPickProductDAO().findEditorPickProductByCatalog(catalog.getId(),options);
		if(editorPickProductList != null){
			enhanceEditorPickProductList(editorPickProductList,options);
			catalog.setEditorPickProductList(editorPickProductList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeEditorPickProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();
		if(editorPickProductList != null){
			getEditorPickProductDAO().analyzeEditorPickProductByCatalog(editorPickProductList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
	protected void enhanceTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractTopRatedProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = getTopRatedProductDAO().findTopRatedProductByCatalog(catalog.getId(),options);
		if(topRatedProductList != null){
			enhanceTopRatedProductList(topRatedProductList,options);
			catalog.setTopRatedProductList(topRatedProductList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeTopRatedProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();
		if(topRatedProductList != null){
			getTopRatedProductDAO().analyzeTopRatedProductByCatalog(topRatedProductList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
	protected void enhanceRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractRecommandProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = getRecommandProductDAO().findRecommandProductByCatalog(catalog.getId(),options);
		if(recommandProductList != null){
			enhanceRecommandProductList(recommandProductList,options);
			catalog.setRecommandProductList(recommandProductList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeRecommandProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();
		if(recommandProductList != null){
			getRecommandProductDAO().analyzeRecommandProductByCatalog(recommandProductList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
		
  	
 	public SmartList<Catalog> findCatalogBySite(String siteId,Map<String,Object> options){
 	
  		SmartList<Catalog> resultList = queryWith(CatalogTable.COLUMN_SITE, siteId, options, getCatalogMapper());
		// analyzeCatalogBySite(resultList, siteId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Catalog> findCatalogBySite(String siteId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Catalog> resultList =  queryWithRange(CatalogTable.COLUMN_SITE, siteId, options, getCatalogMapper(), start, count);
 		//analyzeCatalogBySite(resultList, siteId, options);
 		return resultList;
 		
 	}
 	public void analyzeCatalogBySite(SmartList<Catalog> resultList, String siteId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Catalog.SITE_PROPERTY, siteId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCatalogBySite(String siteId,Map<String,Object> options){

 		return countWith(CatalogTable.COLUMN_SITE, siteId, options);
 	}
 	@Override
	public Map<String, Integer> countCatalogBySiteIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CatalogTable.COLUMN_SITE, ids, options);
	}
 	
  	
 	public SmartList<Catalog> findCatalogByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Catalog> resultList = queryWith(CatalogTable.COLUMN_PLATFORM, platformId, options, getCatalogMapper());
		// analyzeCatalogByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Catalog> findCatalogByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Catalog> resultList =  queryWithRange(CatalogTable.COLUMN_PLATFORM, platformId, options, getCatalogMapper(), start, count);
 		//analyzeCatalogByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeCatalogByPlatform(SmartList<Catalog> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Catalog.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCatalogByPlatform(String platformId,Map<String,Object> options){

 		return countWith(CatalogTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countCatalogByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CatalogTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Catalog saveCatalog(Catalog  catalog){
		
		if(!catalog.isChanged()){
			return catalog;
		}
		
		
		String SQL=this.getSaveCatalogSQL(catalog);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCatalogParameters(catalog);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		catalog.incVersion();
		return catalog;
	
	}
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCatalogList(catalogList);
		
		batchCatalogCreate((List<Catalog>)lists[CREATE_LIST_INDEX]);
		
		batchCatalogUpdate((List<Catalog>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Catalog catalog:catalogList){
			if(catalog.isChanged()){
				catalog.incVersion();
			}
			
		
		}
		
		
		return catalogList;
	}

	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		
		
		super.removeList(catalogList, options);
		
		return catalogList;
		
		
	}
	
	protected List<Object[]> prepareCatalogBatchCreateArgs(List<Catalog> catalogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Catalog catalog:catalogList ){
			Object [] parameters = prepareCatalogCreateParameters(catalog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCatalogBatchUpdateArgs(List<Catalog> catalogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Catalog catalog:catalogList ){
			if(!catalog.isChanged()){
				continue;
			}
			Object [] parameters = prepareCatalogUpdateParameters(catalog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCatalogCreate(List<Catalog> catalogList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCatalogBatchCreateArgs(catalogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCatalogUpdate(List<Catalog> catalogList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCatalogBatchUpdateArgs(catalogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCatalogList(List<Catalog> catalogList){
		
		List<Catalog> catalogCreateList=new ArrayList<Catalog>();
		List<Catalog> catalogUpdateList=new ArrayList<Catalog>();
		
		for(Catalog catalog: catalogList){
			if(isUpdateRequest(catalog)){
				catalogUpdateList.add( catalog);
				continue;
			}
			catalogCreateList.add(catalog);
		}
		
		return new Object[]{catalogCreateList,catalogUpdateList};
	}
	
	protected boolean isUpdateRequest(Catalog catalog){
 		return catalog.getVersion() > 0;
 	}
 	protected String getSaveCatalogSQL(Catalog catalog){
 		if(isUpdateRequest(catalog)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCatalogParameters(Catalog catalog){
 		if(isUpdateRequest(catalog) ){
 			return prepareCatalogUpdateParameters(catalog);
 		}
 		return prepareCatalogCreateParameters(catalog);
 	}
 	protected Object[] prepareCatalogUpdateParameters(Catalog catalog){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = catalog.getName();
 		parameters[1] = catalog.getSellerId(); 	
 		if(catalog.getSite() != null){
 			parameters[2] = catalog.getSite().getId();
 		}
  	
 		if(catalog.getPlatform() != null){
 			parameters[3] = catalog.getPlatform().getId();
 		}
 		
 		parameters[4] = catalog.nextVersion();
 		parameters[5] = catalog.getId();
 		parameters[6] = catalog.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCatalogCreateParameters(Catalog catalog){
		Object[] parameters = new Object[5];
		String newCatalogId=getNextId();
		catalog.setId(newCatalogId);
		parameters[0] =  catalog.getId();
 
 		parameters[1] = catalog.getName();
 		parameters[2] = catalog.getSellerId(); 	
 		if(catalog.getSite() != null){
 			parameters[3] = catalog.getSite().getId();
 		
 		}
 		 	
 		if(catalog.getPlatform() != null){
 			parameters[4] = catalog.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Catalog saveInternalCatalog(Catalog catalog, Map<String,Object> options){
		
		saveCatalog(catalog);
 	
 		if(isSaveSiteEnabled(options)){
	 		saveSite(catalog, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(catalog, options);
 		}
 
		
		if(isSaveLevelOneCategoryListEnabled(options)){
	 		saveLevelOneCategoryList(catalog, options);
	 		//removeLevelOneCategoryList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(catalog, options);
	 		//removeProductList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveNewProductListEnabled(options)){
	 		saveNewProductList(catalog, options);
	 		//removeNewProductList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveEditorPickProductListEnabled(options)){
	 		saveEditorPickProductList(catalog, options);
	 		//removeEditorPickProductList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTopRatedProductListEnabled(options)){
	 		saveTopRatedProductList(catalog, options);
	 		//removeTopRatedProductList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRecommandProductListEnabled(options)){
	 		saveRecommandProductList(catalog, options);
	 		//removeRecommandProductList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		return catalog;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Catalog saveSite(Catalog catalog, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(catalog.getSite() == null){
 			return catalog;//do nothing when it is null
 		}
 		
 		getSiteDAO().save(catalog.getSite(),options);
 		return catalog;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Catalog savePlatform(Catalog catalog, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(catalog.getPlatform() == null){
 			return catalog;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(catalog.getPlatform(),options);
 		return catalog;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Catalog planToRemoveLevelOneCategoryList(Catalog catalog, String levelOneCategoryIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelOneCategory.CATALOG_PROPERTY, catalog.getId());
		key.put(LevelOneCategory.ID_PROPERTY, levelOneCategoryIds);
		
		SmartList<LevelOneCategory> externalLevelOneCategoryList = getLevelOneCategoryDAO().
				findLevelOneCategoryWithKey(key, options);
		if(externalLevelOneCategoryList == null){
			return catalog;
		}
		if(externalLevelOneCategoryList.isEmpty()){
			return catalog;
		}
		
		for(LevelOneCategory levelOneCategory: externalLevelOneCategoryList){

			levelOneCategory.clearFromAll();
		}
		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();		
		levelOneCategoryList.addAllToRemoveList(externalLevelOneCategoryList);
		return catalog;	
	
	}


	public Catalog planToRemoveProductList(Catalog catalog, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalog.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return catalog;
		}
		if(externalProductList.isEmpty()){
			return catalog;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = catalog.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return catalog;	
	
	}


	//disconnect Catalog with parent_category in Product
	public Catalog planToRemoveProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalog.getId());
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return catalog;
		}
		if(externalProductList.isEmpty()){
			return catalog;
		}
		
		for(Product product: externalProductList){
			product.clearParentCategory();
			product.clearCatalog();
			
		}
		
		
		SmartList<Product> productList = catalog.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return catalog;
	}
	
	public int countProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalogId);
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with brand in Product
	public Catalog planToRemoveProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalog.getId());
		key.put(Product.BRAND_PROPERTY, brandId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return catalog;
		}
		if(externalProductList.isEmpty()){
			return catalog;
		}
		
		for(Product product: externalProductList){
			product.clearBrand();
			product.clearCatalog();
			
		}
		
		
		SmartList<Product> productList = catalog.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return catalog;
	}
	
	public int countProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalogId);
		key.put(Product.BRAND_PROPERTY, brandId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with platform in Product
	public Catalog planToRemoveProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalog.getId());
		key.put(Product.PLATFORM_PROPERTY, platformId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return catalog;
		}
		if(externalProductList.isEmpty()){
			return catalog;
		}
		
		for(Product product: externalProductList){
			product.clearPlatform();
			product.clearCatalog();
			
		}
		
		
		SmartList<Product> productList = catalog.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return catalog;
	}
	
	public int countProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalogId);
		key.put(Product.PLATFORM_PROPERTY, platformId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	public Catalog planToRemoveNewProductList(Catalog catalog, String newProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(NewProduct.ID_PROPERTY, newProductIds);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return catalog;
		}
		if(externalNewProductList.isEmpty()){
			return catalog;
		}
		
		for(NewProduct newProduct: externalNewProductList){

			newProduct.clearFromAll();
		}
		
		
		SmartList<NewProduct> newProductList = catalog.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return catalog;	
	
	}


	//disconnect Catalog with parent_category in NewProduct
	public Catalog planToRemoveNewProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return catalog;
		}
		if(externalNewProductList.isEmpty()){
			return catalog;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearParentCategory();
			newProduct.clearCatalog();
			
		}
		
		
		SmartList<NewProduct> newProductList = catalog.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return catalog;
	}
	
	public int countNewProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with brand in NewProduct
	public Catalog planToRemoveNewProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return catalog;
		}
		if(externalNewProductList.isEmpty()){
			return catalog;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearBrand();
			newProduct.clearCatalog();
			
		}
		
		
		SmartList<NewProduct> newProductList = catalog.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return catalog;
	}
	
	public int countNewProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with profile in NewProduct
	public Catalog planToRemoveNewProductListWithProfile(Catalog catalog, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return catalog;
		}
		if(externalNewProductList.isEmpty()){
			return catalog;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearProfile();
			newProduct.clearCatalog();
			
		}
		
		
		SmartList<NewProduct> newProductList = catalog.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return catalog;
	}
	
	public int countNewProductListWithProfile(String catalogId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with platform in NewProduct
	public Catalog planToRemoveNewProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return catalog;
		}
		if(externalNewProductList.isEmpty()){
			return catalog;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearPlatform();
			newProduct.clearCatalog();
			
		}
		
		
		SmartList<NewProduct> newProductList = catalog.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return catalog;
	}
	
	public int countNewProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	public Catalog planToRemoveEditorPickProductList(Catalog catalog, String editorPickProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(EditorPickProduct.ID_PROPERTY, editorPickProductIds);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return catalog;
		}
		if(externalEditorPickProductList.isEmpty()){
			return catalog;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){

			editorPickProduct.clearFromAll();
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return catalog;	
	
	}


	//disconnect Catalog with parent_category in EditorPickProduct
	public Catalog planToRemoveEditorPickProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return catalog;
		}
		if(externalEditorPickProductList.isEmpty()){
			return catalog;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearParentCategory();
			editorPickProduct.clearCatalog();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return catalog;
	}
	
	public int countEditorPickProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with brand in EditorPickProduct
	public Catalog planToRemoveEditorPickProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return catalog;
		}
		if(externalEditorPickProductList.isEmpty()){
			return catalog;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearBrand();
			editorPickProduct.clearCatalog();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return catalog;
	}
	
	public int countEditorPickProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with profile in EditorPickProduct
	public Catalog planToRemoveEditorPickProductListWithProfile(Catalog catalog, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return catalog;
		}
		if(externalEditorPickProductList.isEmpty()){
			return catalog;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearProfile();
			editorPickProduct.clearCatalog();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return catalog;
	}
	
	public int countEditorPickProductListWithProfile(String catalogId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with platform in EditorPickProduct
	public Catalog planToRemoveEditorPickProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return catalog;
		}
		if(externalEditorPickProductList.isEmpty()){
			return catalog;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearPlatform();
			editorPickProduct.clearCatalog();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return catalog;
	}
	
	public int countEditorPickProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	public Catalog planToRemoveTopRatedProductList(Catalog catalog, String topRatedProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(TopRatedProduct.ID_PROPERTY, topRatedProductIds);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return catalog;
		}
		if(externalTopRatedProductList.isEmpty()){
			return catalog;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){

			topRatedProduct.clearFromAll();
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return catalog;	
	
	}


	//disconnect Catalog with parent_category in TopRatedProduct
	public Catalog planToRemoveTopRatedProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return catalog;
		}
		if(externalTopRatedProductList.isEmpty()){
			return catalog;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearParentCategory();
			topRatedProduct.clearCatalog();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return catalog;
	}
	
	public int countTopRatedProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with brand in TopRatedProduct
	public Catalog planToRemoveTopRatedProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return catalog;
		}
		if(externalTopRatedProductList.isEmpty()){
			return catalog;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearBrand();
			topRatedProduct.clearCatalog();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return catalog;
	}
	
	public int countTopRatedProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with profile in TopRatedProduct
	public Catalog planToRemoveTopRatedProductListWithProfile(Catalog catalog, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return catalog;
		}
		if(externalTopRatedProductList.isEmpty()){
			return catalog;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearProfile();
			topRatedProduct.clearCatalog();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return catalog;
	}
	
	public int countTopRatedProductListWithProfile(String catalogId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with platform in TopRatedProduct
	public Catalog planToRemoveTopRatedProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return catalog;
		}
		if(externalTopRatedProductList.isEmpty()){
			return catalog;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearPlatform();
			topRatedProduct.clearCatalog();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return catalog;
	}
	
	public int countTopRatedProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	public Catalog planToRemoveRecommandProductList(Catalog catalog, String recommandProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(RecommandProduct.ID_PROPERTY, recommandProductIds);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return catalog;
		}
		if(externalRecommandProductList.isEmpty()){
			return catalog;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){

			recommandProduct.clearFromAll();
		}
		
		
		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return catalog;	
	
	}


	//disconnect Catalog with parent_category in RecommandProduct
	public Catalog planToRemoveRecommandProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return catalog;
		}
		if(externalRecommandProductList.isEmpty()){
			return catalog;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearParentCategory();
			recommandProduct.clearCatalog();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return catalog;
	}
	
	public int countRecommandProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with brand in RecommandProduct
	public Catalog planToRemoveRecommandProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return catalog;
		}
		if(externalRecommandProductList.isEmpty()){
			return catalog;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearBrand();
			recommandProduct.clearCatalog();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return catalog;
	}
	
	public int countRecommandProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with profile in RecommandProduct
	public Catalog planToRemoveRecommandProductListWithProfile(Catalog catalog, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return catalog;
		}
		if(externalRecommandProductList.isEmpty()){
			return catalog;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearProfile();
			recommandProduct.clearCatalog();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return catalog;
	}
	
	public int countRecommandProductListWithProfile(String catalogId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with platform in RecommandProduct
	public Catalog planToRemoveRecommandProductListWithPlatform(Catalog catalog, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalog.getId());
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return catalog;
		}
		if(externalRecommandProductList.isEmpty()){
			return catalog;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearPlatform();
			recommandProduct.clearCatalog();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return catalog;
	}
	
	public int countRecommandProductListWithPlatform(String catalogId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	

		
	protected Catalog saveLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList == null){
			//null list means nothing
			return catalog;
		}
		SmartList<LevelOneCategory> mergedUpdateLevelOneCategoryList = new SmartList<LevelOneCategory>();
		
		
		mergedUpdateLevelOneCategoryList.addAll(levelOneCategoryList); 
		if(levelOneCategoryList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelOneCategoryList.addAll(levelOneCategoryList.getToRemoveList());
			levelOneCategoryList.removeAll(levelOneCategoryList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLevelOneCategoryDAO().saveLevelOneCategoryList(mergedUpdateLevelOneCategoryList,options);
		
		if(levelOneCategoryList.getToRemoveList() != null){
			levelOneCategoryList.removeAll(levelOneCategoryList.getToRemoveList());
		}
		
		
		return catalog;
	
	}
	
	protected Catalog removeLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList == null){
			return catalog;
		}	
	
		SmartList<LevelOneCategory> toRemoveLevelOneCategoryList = levelOneCategoryList.getToRemoveList();
		
		if(toRemoveLevelOneCategoryList == null){
			return catalog;
		}
		if(toRemoveLevelOneCategoryList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelOneCategoryDAO().removeLevelOneCategoryList(toRemoveLevelOneCategoryList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		
	protected Catalog saveProductList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = catalog.getProductList();
		if(productList == null){
			//null list means nothing
			return catalog;
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
		
		
		return catalog;
	
	}
	
	protected Catalog removeProductList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<Product> productList = catalog.getProductList();
		if(productList == null){
			return catalog;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return catalog;
		}
		if(toRemoveProductList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		
	protected Catalog saveNewProductList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<NewProduct> newProductList = catalog.getNewProductList();
		if(newProductList == null){
			//null list means nothing
			return catalog;
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
		
		
		return catalog;
	
	}
	
	protected Catalog removeNewProductList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<NewProduct> newProductList = catalog.getNewProductList();
		if(newProductList == null){
			return catalog;
		}	
	
		SmartList<NewProduct> toRemoveNewProductList = newProductList.getToRemoveList();
		
		if(toRemoveNewProductList == null){
			return catalog;
		}
		if(toRemoveNewProductList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNewProductDAO().removeNewProductList(toRemoveNewProductList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		
	protected Catalog saveEditorPickProductList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();
		if(editorPickProductList == null){
			//null list means nothing
			return catalog;
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
		
		
		return catalog;
	
	}
	
	protected Catalog removeEditorPickProductList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();
		if(editorPickProductList == null){
			return catalog;
		}	
	
		SmartList<EditorPickProduct> toRemoveEditorPickProductList = editorPickProductList.getToRemoveList();
		
		if(toRemoveEditorPickProductList == null){
			return catalog;
		}
		if(toRemoveEditorPickProductList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEditorPickProductDAO().removeEditorPickProductList(toRemoveEditorPickProductList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		
	protected Catalog saveTopRatedProductList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();
		if(topRatedProductList == null){
			//null list means nothing
			return catalog;
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
		
		
		return catalog;
	
	}
	
	protected Catalog removeTopRatedProductList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();
		if(topRatedProductList == null){
			return catalog;
		}	
	
		SmartList<TopRatedProduct> toRemoveTopRatedProductList = topRatedProductList.getToRemoveList();
		
		if(toRemoveTopRatedProductList == null){
			return catalog;
		}
		if(toRemoveTopRatedProductList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTopRatedProductDAO().removeTopRatedProductList(toRemoveTopRatedProductList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		
	protected Catalog saveRecommandProductList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();
		if(recommandProductList == null){
			//null list means nothing
			return catalog;
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
		
		
		return catalog;
	
	}
	
	protected Catalog removeRecommandProductList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();
		if(recommandProductList == null){
			return catalog;
		}	
	
		SmartList<RecommandProduct> toRemoveRecommandProductList = recommandProductList.getToRemoveList();
		
		if(toRemoveRecommandProductList == null){
			return catalog;
		}
		if(toRemoveRecommandProductList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRecommandProductDAO().removeRecommandProductList(toRemoveRecommandProductList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		

	public Catalog present(Catalog catalog,Map<String, Object> options){
	
		presentLevelOneCategoryList(catalog,options);
		presentProductList(catalog,options);
		presentNewProductList(catalog,options);
		presentEditorPickProductList(catalog,options);
		presentTopRatedProductList(catalog,options);
		presentRecommandProductList(catalog,options);

		return catalog;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentLevelOneCategoryList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();		
				SmartList<LevelOneCategory> newList= presentSubList(catalog.getId(),
				levelOneCategoryList,
				options,
				getLevelOneCategoryDAO()::countLevelOneCategoryByCatalog,
				getLevelOneCategoryDAO()::findLevelOneCategoryByCatalog
				);

		
		catalog.setLevelOneCategoryList(newList);
		

		return catalog;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentProductList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<Product> productList = catalog.getProductList();		
				SmartList<Product> newList= presentSubList(catalog.getId(),
				productList,
				options,
				getProductDAO()::countProductByCatalog,
				getProductDAO()::findProductByCatalog
				);

		
		catalog.setProductList(newList);
		

		return catalog;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentNewProductList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<NewProduct> newProductList = catalog.getNewProductList();		
				SmartList<NewProduct> newList= presentSubList(catalog.getId(),
				newProductList,
				options,
				getNewProductDAO()::countNewProductByCatalog,
				getNewProductDAO()::findNewProductByCatalog
				);

		
		catalog.setNewProductList(newList);
		

		return catalog;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentEditorPickProductList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<EditorPickProduct> editorPickProductList = catalog.getEditorPickProductList();		
				SmartList<EditorPickProduct> newList= presentSubList(catalog.getId(),
				editorPickProductList,
				options,
				getEditorPickProductDAO()::countEditorPickProductByCatalog,
				getEditorPickProductDAO()::findEditorPickProductByCatalog
				);

		
		catalog.setEditorPickProductList(newList);
		

		return catalog;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentTopRatedProductList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<TopRatedProduct> topRatedProductList = catalog.getTopRatedProductList();		
				SmartList<TopRatedProduct> newList= presentSubList(catalog.getId(),
				topRatedProductList,
				options,
				getTopRatedProductDAO()::countTopRatedProductByCatalog,
				getTopRatedProductDAO()::findTopRatedProductByCatalog
				);

		
		catalog.setTopRatedProductList(newList);
		

		return catalog;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentRecommandProductList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<RecommandProduct> recommandProductList = catalog.getRecommandProductList();		
				SmartList<RecommandProduct> newList= presentSubList(catalog.getId(),
				recommandProductList,
				options,
				getRecommandProductDAO()::countRecommandProductByCatalog,
				getRecommandProductDAO()::findRecommandProductByCatalog
				);

		
		catalog.setRecommandProductList(newList);
		

		return catalog;
	}			
		

	
    public SmartList<Catalog> requestCandidateCatalogForLevelOneCategory(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		
    public SmartList<Catalog> requestCandidateCatalogForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		
    public SmartList<Catalog> requestCandidateCatalogForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		
    public SmartList<Catalog> requestCandidateCatalogForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		
    public SmartList<Catalog> requestCandidateCatalogForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		
    public SmartList<Catalog> requestCandidateCatalogForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		

	protected String getTableName(){
		return CatalogTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Catalog> catalogList) {		
		this.enhanceListInternal(catalogList, this.getCatalogMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Catalog> catalogList = ownerEntity.collectRefsWithType(Catalog.INTERNAL_TYPE);
		this.enhanceList(catalogList);
		
	}
	
	@Override
	public SmartList<Catalog> findCatalogWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getCatalogMapper());

	}
	@Override
	public int countCatalogWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countCatalogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Catalog> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCatalogMapper());
	}
}


