
package com.doublechaintech.uxs.topratedproduct;

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
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;

import com.doublechaintech.uxs.brand.BrandDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.catalog.CatalogDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;
import com.doublechaintech.uxs.levelncategory.LevelNCategoryDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TopRatedProductJDBCTemplateDAO extends UxsNamingServiceDAO implements TopRatedProductDAO{
 
 	
 	private  CatalogDAO  catalogDAO;
 	public void setCatalogDAO(CatalogDAO catalogDAO){
	 	this.catalogDAO = catalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
	 	return this.catalogDAO;
 	}
 
 	
 	private  LevelNCategoryDAO  levelNCategoryDAO;
 	public void setLevelNCategoryDAO(LevelNCategoryDAO levelNCategoryDAO){
	 	this.levelNCategoryDAO = levelNCategoryDAO;
 	}
 	public LevelNCategoryDAO getLevelNCategoryDAO(){
	 	return this.levelNCategoryDAO;
 	}
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}
 
 	
 	private  BrandDAO  brandDAO;
 	public void setBrandDAO(BrandDAO brandDAO){
	 	this.brandDAO = brandDAO;
 	}
 	public BrandDAO getBrandDAO(){
	 	return this.brandDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected TopRatedProduct load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTopRatedProduct(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TopRatedProduct load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTopRatedProduct(TopRatedProductTable.withId(id), options);
	}
	
	
	
	public TopRatedProduct save(TopRatedProduct topRatedProduct,Map<String,Object> options){
		
		String methodName="save(TopRatedProduct topRatedProduct,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(topRatedProduct, methodName, "topRatedProduct");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTopRatedProduct(topRatedProduct,options);
	}
	public TopRatedProduct clone(String topRatedProductId, Map<String,Object> options) throws Exception{
	
		return clone(TopRatedProductTable.withId(topRatedProductId),options);
	}
	
	protected TopRatedProduct clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String topRatedProductId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TopRatedProduct newTopRatedProduct = loadInternalTopRatedProduct(accessKey, options);
		newTopRatedProduct.setVersion(0);
		
		

		
		saveInternalTopRatedProduct(newTopRatedProduct,options);
		
		return newTopRatedProduct;
	}
	
	
	
	

	protected void throwIfHasException(String topRatedProductId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TopRatedProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TopRatedProductNotFoundException(
					"The " + this.getTableName() + "(" + topRatedProductId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String topRatedProductId, int version) throws Exception{
	
		String methodName="delete(String topRatedProductId, int version)";
		assertMethodArgumentNotNull(topRatedProductId, methodName, "topRatedProductId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{topRatedProductId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(topRatedProductId,version);
		}
		
	
	}
	
	
	
	
	

	public TopRatedProduct disconnectFromAll(String topRatedProductId, int version) throws Exception{
	
		
		TopRatedProduct topRatedProduct = loadInternalTopRatedProduct(TopRatedProductTable.withId(topRatedProductId), emptyOptions());
		topRatedProduct.clearFromAll();
		this.saveTopRatedProduct(topRatedProduct);
		return topRatedProduct;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TopRatedProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "top_rated_product";
	}
	@Override
	protected String getBeanName() {
		
		return "topRatedProduct";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TopRatedProductTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TopRatedProductTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TopRatedProductTokens.PARENTCATEGORY);
 	}
 	

 	
  

 	protected boolean isExtractBrandEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TopRatedProductTokens.BRAND);
 	}

 	protected boolean isSaveBrandEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TopRatedProductTokens.BRAND);
 	}
 	

 	
  

 	protected boolean isExtractCatalogEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TopRatedProductTokens.CATALOG);
 	}

 	protected boolean isSaveCatalogEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TopRatedProductTokens.CATALOG);
 	}
 	

 	
  

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TopRatedProductTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TopRatedProductTokens.PROFILE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TopRatedProductTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TopRatedProductTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected TopRatedProductMapper getTopRatedProductMapper(){
		return new TopRatedProductMapper();
	}

	
	
	protected TopRatedProduct extractTopRatedProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TopRatedProduct topRatedProduct = loadSingleObject(accessKey, getTopRatedProductMapper());
			return topRatedProduct;
		}catch(EmptyResultDataAccessException e){
			throw new TopRatedProductNotFoundException("TopRatedProduct("+accessKey+") is not found!");
		}

	}

	
	

	protected TopRatedProduct loadInternalTopRatedProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TopRatedProduct topRatedProduct = extractTopRatedProduct(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(topRatedProduct, loadOptions);
 		}
  	
 		if(isExtractBrandEnabled(loadOptions)){
	 		extractBrand(topRatedProduct, loadOptions);
 		}
  	
 		if(isExtractCatalogEnabled(loadOptions)){
	 		extractCatalog(topRatedProduct, loadOptions);
 		}
  	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(topRatedProduct, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(topRatedProduct, loadOptions);
 		}
 
		
		return topRatedProduct;
		
	}

	 

 	protected TopRatedProduct extractParentCategory(TopRatedProduct topRatedProduct, Map<String,Object> options) throws Exception{

		if(topRatedProduct.getParentCategory() == null){
			return topRatedProduct;
		}
		String parentCategoryId = topRatedProduct.getParentCategory().getId();
		if( parentCategoryId == null){
			return topRatedProduct;
		}
		LevelNCategory parentCategory = getLevelNCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			topRatedProduct.setParentCategory(parentCategory);
		}
		
 		
 		return topRatedProduct;
 	}
 		
  

 	protected TopRatedProduct extractBrand(TopRatedProduct topRatedProduct, Map<String,Object> options) throws Exception{

		if(topRatedProduct.getBrand() == null){
			return topRatedProduct;
		}
		String brandId = topRatedProduct.getBrand().getId();
		if( brandId == null){
			return topRatedProduct;
		}
		Brand brand = getBrandDAO().load(brandId,options);
		if(brand != null){
			topRatedProduct.setBrand(brand);
		}
		
 		
 		return topRatedProduct;
 	}
 		
  

 	protected TopRatedProduct extractCatalog(TopRatedProduct topRatedProduct, Map<String,Object> options) throws Exception{

		if(topRatedProduct.getCatalog() == null){
			return topRatedProduct;
		}
		String catalogId = topRatedProduct.getCatalog().getId();
		if( catalogId == null){
			return topRatedProduct;
		}
		Catalog catalog = getCatalogDAO().load(catalogId,options);
		if(catalog != null){
			topRatedProduct.setCatalog(catalog);
		}
		
 		
 		return topRatedProduct;
 	}
 		
  

 	protected TopRatedProduct extractProfile(TopRatedProduct topRatedProduct, Map<String,Object> options) throws Exception{

		if(topRatedProduct.getProfile() == null){
			return topRatedProduct;
		}
		String profileId = topRatedProduct.getProfile().getId();
		if( profileId == null){
			return topRatedProduct;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			topRatedProduct.setProfile(profile);
		}
		
 		
 		return topRatedProduct;
 	}
 		
  

 	protected TopRatedProduct extractPlatform(TopRatedProduct topRatedProduct, Map<String,Object> options) throws Exception{

		if(topRatedProduct.getPlatform() == null){
			return topRatedProduct;
		}
		String platformId = topRatedProduct.getPlatform().getId();
		if( platformId == null){
			return topRatedProduct;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			topRatedProduct.setPlatform(platform);
		}
		
 		
 		return topRatedProduct;
 	}
 		
 
		
		
  	
 	public SmartList<TopRatedProduct> findTopRatedProductByParentCategory(String levelNCategoryId,Map<String,Object> options){
 	
  		SmartList<TopRatedProduct> resultList = queryWith(TopRatedProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options, getTopRatedProductMapper());
		// analyzeTopRatedProductByParentCategory(resultList, levelNCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TopRatedProduct> findTopRatedProductByParentCategory(String levelNCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TopRatedProduct> resultList =  queryWithRange(TopRatedProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options, getTopRatedProductMapper(), start, count);
 		//analyzeTopRatedProductByParentCategory(resultList, levelNCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeTopRatedProductByParentCategory(SmartList<TopRatedProduct> resultList, String levelNCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//TopRatedProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Top Rated Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTopRatedProductByParentCategory(String levelNCategoryId,Map<String,Object> options){

 		return countWith(TopRatedProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countTopRatedProductByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TopRatedProductTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
  	
 	public SmartList<TopRatedProduct> findTopRatedProductByBrand(String brandId,Map<String,Object> options){
 	
  		SmartList<TopRatedProduct> resultList = queryWith(TopRatedProductTable.COLUMN_BRAND, brandId, options, getTopRatedProductMapper());
		// analyzeTopRatedProductByBrand(resultList, brandId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TopRatedProduct> findTopRatedProductByBrand(String brandId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TopRatedProduct> resultList =  queryWithRange(TopRatedProductTable.COLUMN_BRAND, brandId, options, getTopRatedProductMapper(), start, count);
 		//analyzeTopRatedProductByBrand(resultList, brandId, options);
 		return resultList;
 		
 	}
 	public void analyzeTopRatedProductByBrand(SmartList<TopRatedProduct> resultList, String brandId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TopRatedProduct.BRAND_PROPERTY, brandId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//TopRatedProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Top Rated Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTopRatedProductByBrand(String brandId,Map<String,Object> options){

 		return countWith(TopRatedProductTable.COLUMN_BRAND, brandId, options);
 	}
 	@Override
	public Map<String, Integer> countTopRatedProductByBrandIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TopRatedProductTable.COLUMN_BRAND, ids, options);
	}
 	
  	
 	public SmartList<TopRatedProduct> findTopRatedProductByCatalog(String catalogId,Map<String,Object> options){
 	
  		SmartList<TopRatedProduct> resultList = queryWith(TopRatedProductTable.COLUMN_CATALOG, catalogId, options, getTopRatedProductMapper());
		// analyzeTopRatedProductByCatalog(resultList, catalogId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TopRatedProduct> findTopRatedProductByCatalog(String catalogId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TopRatedProduct> resultList =  queryWithRange(TopRatedProductTable.COLUMN_CATALOG, catalogId, options, getTopRatedProductMapper(), start, count);
 		//analyzeTopRatedProductByCatalog(resultList, catalogId, options);
 		return resultList;
 		
 	}
 	public void analyzeTopRatedProductByCatalog(SmartList<TopRatedProduct> resultList, String catalogId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//TopRatedProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Top Rated Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTopRatedProductByCatalog(String catalogId,Map<String,Object> options){

 		return countWith(TopRatedProductTable.COLUMN_CATALOG, catalogId, options);
 	}
 	@Override
	public Map<String, Integer> countTopRatedProductByCatalogIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TopRatedProductTable.COLUMN_CATALOG, ids, options);
	}
 	
  	
 	public SmartList<TopRatedProduct> findTopRatedProductByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<TopRatedProduct> resultList = queryWith(TopRatedProductTable.COLUMN_PROFILE, profileId, options, getTopRatedProductMapper());
		// analyzeTopRatedProductByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TopRatedProduct> findTopRatedProductByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TopRatedProduct> resultList =  queryWithRange(TopRatedProductTable.COLUMN_PROFILE, profileId, options, getTopRatedProductMapper(), start, count);
 		//analyzeTopRatedProductByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeTopRatedProductByProfile(SmartList<TopRatedProduct> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//TopRatedProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Top Rated Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTopRatedProductByProfile(String profileId,Map<String,Object> options){

 		return countWith(TopRatedProductTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countTopRatedProductByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TopRatedProductTable.COLUMN_PROFILE, ids, options);
	}
 	
  	
 	public SmartList<TopRatedProduct> findTopRatedProductByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<TopRatedProduct> resultList = queryWith(TopRatedProductTable.COLUMN_PLATFORM, platformId, options, getTopRatedProductMapper());
		// analyzeTopRatedProductByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TopRatedProduct> findTopRatedProductByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TopRatedProduct> resultList =  queryWithRange(TopRatedProductTable.COLUMN_PLATFORM, platformId, options, getTopRatedProductMapper(), start, count);
 		//analyzeTopRatedProductByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeTopRatedProductByPlatform(SmartList<TopRatedProduct> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//TopRatedProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Top Rated Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TopRatedProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTopRatedProductByPlatform(String platformId,Map<String,Object> options){

 		return countWith(TopRatedProductTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countTopRatedProductByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TopRatedProductTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected TopRatedProduct saveTopRatedProduct(TopRatedProduct  topRatedProduct){
		
		if(!topRatedProduct.isChanged()){
			return topRatedProduct;
		}
		
		
		String SQL=this.getSaveTopRatedProductSQL(topRatedProduct);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTopRatedProductParameters(topRatedProduct);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		topRatedProduct.incVersion();
		return topRatedProduct;
	
	}
	public SmartList<TopRatedProduct> saveTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTopRatedProductList(topRatedProductList);
		
		batchTopRatedProductCreate((List<TopRatedProduct>)lists[CREATE_LIST_INDEX]);
		
		batchTopRatedProductUpdate((List<TopRatedProduct>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TopRatedProduct topRatedProduct:topRatedProductList){
			if(topRatedProduct.isChanged()){
				topRatedProduct.incVersion();
			}
			
		
		}
		
		
		return topRatedProductList;
	}

	public SmartList<TopRatedProduct> removeTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options){
		
		
		super.removeList(topRatedProductList, options);
		
		return topRatedProductList;
		
		
	}
	
	protected List<Object[]> prepareTopRatedProductBatchCreateArgs(List<TopRatedProduct> topRatedProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TopRatedProduct topRatedProduct:topRatedProductList ){
			Object [] parameters = prepareTopRatedProductCreateParameters(topRatedProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTopRatedProductBatchUpdateArgs(List<TopRatedProduct> topRatedProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TopRatedProduct topRatedProduct:topRatedProductList ){
			if(!topRatedProduct.isChanged()){
				continue;
			}
			Object [] parameters = prepareTopRatedProductUpdateParameters(topRatedProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTopRatedProductCreate(List<TopRatedProduct> topRatedProductList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTopRatedProductBatchCreateArgs(topRatedProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTopRatedProductUpdate(List<TopRatedProduct> topRatedProductList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTopRatedProductBatchUpdateArgs(topRatedProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTopRatedProductList(List<TopRatedProduct> topRatedProductList){
		
		List<TopRatedProduct> topRatedProductCreateList=new ArrayList<TopRatedProduct>();
		List<TopRatedProduct> topRatedProductUpdateList=new ArrayList<TopRatedProduct>();
		
		for(TopRatedProduct topRatedProduct: topRatedProductList){
			if(isUpdateRequest(topRatedProduct)){
				topRatedProductUpdateList.add( topRatedProduct);
				continue;
			}
			topRatedProductCreateList.add(topRatedProduct);
		}
		
		return new Object[]{topRatedProductCreateList,topRatedProductUpdateList};
	}
	
	protected boolean isUpdateRequest(TopRatedProduct topRatedProduct){
 		return topRatedProduct.getVersion() > 0;
 	}
 	protected String getSaveTopRatedProductSQL(TopRatedProduct topRatedProduct){
 		if(isUpdateRequest(topRatedProduct)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTopRatedProductParameters(TopRatedProduct topRatedProduct){
 		if(isUpdateRequest(topRatedProduct) ){
 			return prepareTopRatedProductUpdateParameters(topRatedProduct);
 		}
 		return prepareTopRatedProductCreateParameters(topRatedProduct);
 	}
 	protected Object[] prepareTopRatedProductUpdateParameters(TopRatedProduct topRatedProduct){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = topRatedProduct.getName(); 	
 		if(topRatedProduct.getParentCategory() != null){
 			parameters[1] = topRatedProduct.getParentCategory().getId();
 		}
  	
 		if(topRatedProduct.getBrand() != null){
 			parameters[2] = topRatedProduct.getBrand().getId();
 		}
 
 		parameters[3] = topRatedProduct.getProductCoverImage();
 		parameters[4] = topRatedProduct.getOrigin(); 	
 		if(topRatedProduct.getCatalog() != null){
 			parameters[5] = topRatedProduct.getCatalog().getId();
 		}
 
 		parameters[6] = topRatedProduct.getRemark();
 		parameters[7] = topRatedProduct.getLastUpdateTime(); 	
 		if(topRatedProduct.getProfile() != null){
 			parameters[8] = topRatedProduct.getProfile().getId();
 		}
  	
 		if(topRatedProduct.getPlatform() != null){
 			parameters[9] = topRatedProduct.getPlatform().getId();
 		}
 		
 		parameters[10] = topRatedProduct.nextVersion();
 		parameters[11] = topRatedProduct.getId();
 		parameters[12] = topRatedProduct.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTopRatedProductCreateParameters(TopRatedProduct topRatedProduct){
		Object[] parameters = new Object[11];
		String newTopRatedProductId=getNextId();
		topRatedProduct.setId(newTopRatedProductId);
		parameters[0] =  topRatedProduct.getId();
 
 		parameters[1] = topRatedProduct.getName(); 	
 		if(topRatedProduct.getParentCategory() != null){
 			parameters[2] = topRatedProduct.getParentCategory().getId();
 		
 		}
 		 	
 		if(topRatedProduct.getBrand() != null){
 			parameters[3] = topRatedProduct.getBrand().getId();
 		
 		}
 		
 		parameters[4] = topRatedProduct.getProductCoverImage();
 		parameters[5] = topRatedProduct.getOrigin(); 	
 		if(topRatedProduct.getCatalog() != null){
 			parameters[6] = topRatedProduct.getCatalog().getId();
 		
 		}
 		
 		parameters[7] = topRatedProduct.getRemark();
 		parameters[8] = topRatedProduct.getLastUpdateTime(); 	
 		if(topRatedProduct.getProfile() != null){
 			parameters[9] = topRatedProduct.getProfile().getId();
 		
 		}
 		 	
 		if(topRatedProduct.getPlatform() != null){
 			parameters[10] = topRatedProduct.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TopRatedProduct saveInternalTopRatedProduct(TopRatedProduct topRatedProduct, Map<String,Object> options){
		
		saveTopRatedProduct(topRatedProduct);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(topRatedProduct, options);
 		}
  	
 		if(isSaveBrandEnabled(options)){
	 		saveBrand(topRatedProduct, options);
 		}
  	
 		if(isSaveCatalogEnabled(options)){
	 		saveCatalog(topRatedProduct, options);
 		}
  	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(topRatedProduct, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(topRatedProduct, options);
 		}
 
		
		return topRatedProduct;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TopRatedProduct saveParentCategory(TopRatedProduct topRatedProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(topRatedProduct.getParentCategory() == null){
 			return topRatedProduct;//do nothing when it is null
 		}
 		
 		getLevelNCategoryDAO().save(topRatedProduct.getParentCategory(),options);
 		return topRatedProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TopRatedProduct saveBrand(TopRatedProduct topRatedProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(topRatedProduct.getBrand() == null){
 			return topRatedProduct;//do nothing when it is null
 		}
 		
 		getBrandDAO().save(topRatedProduct.getBrand(),options);
 		return topRatedProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TopRatedProduct saveCatalog(TopRatedProduct topRatedProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(topRatedProduct.getCatalog() == null){
 			return topRatedProduct;//do nothing when it is null
 		}
 		
 		getCatalogDAO().save(topRatedProduct.getCatalog(),options);
 		return topRatedProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TopRatedProduct saveProfile(TopRatedProduct topRatedProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(topRatedProduct.getProfile() == null){
 			return topRatedProduct;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(topRatedProduct.getProfile(),options);
 		return topRatedProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TopRatedProduct savePlatform(TopRatedProduct topRatedProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(topRatedProduct.getPlatform() == null){
 			return topRatedProduct;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(topRatedProduct.getPlatform(),options);
 		return topRatedProduct;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public TopRatedProduct present(TopRatedProduct topRatedProduct,Map<String, Object> options){
	

		return topRatedProduct;
	
	}
		

	

	protected String getTableName(){
		return TopRatedProductTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TopRatedProduct> topRatedProductList) {		
		this.enhanceListInternal(topRatedProductList, this.getTopRatedProductMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TopRatedProduct> topRatedProductList = ownerEntity.collectRefsWithType(TopRatedProduct.INTERNAL_TYPE);
		this.enhanceList(topRatedProductList);
		
	}
	
	@Override
	public SmartList<TopRatedProduct> findTopRatedProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTopRatedProductMapper());

	}
	@Override
	public int countTopRatedProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTopRatedProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TopRatedProduct> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTopRatedProductMapper());
	}
}


