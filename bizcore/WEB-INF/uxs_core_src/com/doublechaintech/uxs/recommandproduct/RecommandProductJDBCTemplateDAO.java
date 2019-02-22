
package com.doublechaintech.uxs.recommandproduct;

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

public class RecommandProductJDBCTemplateDAO extends UxsNamingServiceDAO implements RecommandProductDAO{
 
 	
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
	protected RecommandProduct load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRecommandProduct(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RecommandProduct load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRecommandProduct(RecommandProductTable.withId(id), options);
	}
	
	
	
	public RecommandProduct save(RecommandProduct recommandProduct,Map<String,Object> options){
		
		String methodName="save(RecommandProduct recommandProduct,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(recommandProduct, methodName, "recommandProduct");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRecommandProduct(recommandProduct,options);
	}
	public RecommandProduct clone(String recommandProductId, Map<String,Object> options) throws Exception{
	
		return clone(RecommandProductTable.withId(recommandProductId),options);
	}
	
	protected RecommandProduct clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String recommandProductId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RecommandProduct newRecommandProduct = loadInternalRecommandProduct(accessKey, options);
		newRecommandProduct.setVersion(0);
		
		

		
		saveInternalRecommandProduct(newRecommandProduct,options);
		
		return newRecommandProduct;
	}
	
	
	
	

	protected void throwIfHasException(String recommandProductId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RecommandProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RecommandProductNotFoundException(
					"The " + this.getTableName() + "(" + recommandProductId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String recommandProductId, int version) throws Exception{
	
		String methodName="delete(String recommandProductId, int version)";
		assertMethodArgumentNotNull(recommandProductId, methodName, "recommandProductId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{recommandProductId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(recommandProductId,version);
		}
		
	
	}
	
	
	
	
	

	public RecommandProduct disconnectFromAll(String recommandProductId, int version) throws Exception{
	
		
		RecommandProduct recommandProduct = loadInternalRecommandProduct(RecommandProductTable.withId(recommandProductId), emptyOptions());
		recommandProduct.clearFromAll();
		this.saveRecommandProduct(recommandProduct);
		return recommandProduct;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RecommandProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "recommand_product";
	}
	@Override
	protected String getBeanName() {
		
		return "recommandProduct";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RecommandProductTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RecommandProductTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RecommandProductTokens.PARENTCATEGORY);
 	}
 	

 	
  

 	protected boolean isExtractBrandEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RecommandProductTokens.BRAND);
 	}

 	protected boolean isSaveBrandEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RecommandProductTokens.BRAND);
 	}
 	

 	
  

 	protected boolean isExtractCatalogEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RecommandProductTokens.CATALOG);
 	}

 	protected boolean isSaveCatalogEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RecommandProductTokens.CATALOG);
 	}
 	

 	
  

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RecommandProductTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RecommandProductTokens.PROFILE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RecommandProductTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RecommandProductTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected RecommandProductMapper getRecommandProductMapper(){
		return new RecommandProductMapper();
	}

	
	
	protected RecommandProduct extractRecommandProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RecommandProduct recommandProduct = loadSingleObject(accessKey, getRecommandProductMapper());
			return recommandProduct;
		}catch(EmptyResultDataAccessException e){
			throw new RecommandProductNotFoundException("RecommandProduct("+accessKey+") is not found!");
		}

	}

	
	

	protected RecommandProduct loadInternalRecommandProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RecommandProduct recommandProduct = extractRecommandProduct(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(recommandProduct, loadOptions);
 		}
  	
 		if(isExtractBrandEnabled(loadOptions)){
	 		extractBrand(recommandProduct, loadOptions);
 		}
  	
 		if(isExtractCatalogEnabled(loadOptions)){
	 		extractCatalog(recommandProduct, loadOptions);
 		}
  	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(recommandProduct, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(recommandProduct, loadOptions);
 		}
 
		
		return recommandProduct;
		
	}

	 

 	protected RecommandProduct extractParentCategory(RecommandProduct recommandProduct, Map<String,Object> options) throws Exception{

		if(recommandProduct.getParentCategory() == null){
			return recommandProduct;
		}
		String parentCategoryId = recommandProduct.getParentCategory().getId();
		if( parentCategoryId == null){
			return recommandProduct;
		}
		LevelNCategory parentCategory = getLevelNCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			recommandProduct.setParentCategory(parentCategory);
		}
		
 		
 		return recommandProduct;
 	}
 		
  

 	protected RecommandProduct extractBrand(RecommandProduct recommandProduct, Map<String,Object> options) throws Exception{

		if(recommandProduct.getBrand() == null){
			return recommandProduct;
		}
		String brandId = recommandProduct.getBrand().getId();
		if( brandId == null){
			return recommandProduct;
		}
		Brand brand = getBrandDAO().load(brandId,options);
		if(brand != null){
			recommandProduct.setBrand(brand);
		}
		
 		
 		return recommandProduct;
 	}
 		
  

 	protected RecommandProduct extractCatalog(RecommandProduct recommandProduct, Map<String,Object> options) throws Exception{

		if(recommandProduct.getCatalog() == null){
			return recommandProduct;
		}
		String catalogId = recommandProduct.getCatalog().getId();
		if( catalogId == null){
			return recommandProduct;
		}
		Catalog catalog = getCatalogDAO().load(catalogId,options);
		if(catalog != null){
			recommandProduct.setCatalog(catalog);
		}
		
 		
 		return recommandProduct;
 	}
 		
  

 	protected RecommandProduct extractProfile(RecommandProduct recommandProduct, Map<String,Object> options) throws Exception{

		if(recommandProduct.getProfile() == null){
			return recommandProduct;
		}
		String profileId = recommandProduct.getProfile().getId();
		if( profileId == null){
			return recommandProduct;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			recommandProduct.setProfile(profile);
		}
		
 		
 		return recommandProduct;
 	}
 		
  

 	protected RecommandProduct extractPlatform(RecommandProduct recommandProduct, Map<String,Object> options) throws Exception{

		if(recommandProduct.getPlatform() == null){
			return recommandProduct;
		}
		String platformId = recommandProduct.getPlatform().getId();
		if( platformId == null){
			return recommandProduct;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			recommandProduct.setPlatform(platform);
		}
		
 		
 		return recommandProduct;
 	}
 		
 
		
		
  	
 	public SmartList<RecommandProduct> findRecommandProductByParentCategory(String levelNCategoryId,Map<String,Object> options){
 	
  		SmartList<RecommandProduct> resultList = queryWith(RecommandProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options, getRecommandProductMapper());
		// analyzeRecommandProductByParentCategory(resultList, levelNCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RecommandProduct> findRecommandProductByParentCategory(String levelNCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RecommandProduct> resultList =  queryWithRange(RecommandProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options, getRecommandProductMapper(), start, count);
 		//analyzeRecommandProductByParentCategory(resultList, levelNCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeRecommandProductByParentCategory(SmartList<RecommandProduct> resultList, String levelNCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RecommandProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Recommand Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RecommandProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RecommandProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRecommandProductByParentCategory(String levelNCategoryId,Map<String,Object> options){

 		return countWith(RecommandProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countRecommandProductByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RecommandProductTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
  	
 	public SmartList<RecommandProduct> findRecommandProductByBrand(String brandId,Map<String,Object> options){
 	
  		SmartList<RecommandProduct> resultList = queryWith(RecommandProductTable.COLUMN_BRAND, brandId, options, getRecommandProductMapper());
		// analyzeRecommandProductByBrand(resultList, brandId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RecommandProduct> findRecommandProductByBrand(String brandId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RecommandProduct> resultList =  queryWithRange(RecommandProductTable.COLUMN_BRAND, brandId, options, getRecommandProductMapper(), start, count);
 		//analyzeRecommandProductByBrand(resultList, brandId, options);
 		return resultList;
 		
 	}
 	public void analyzeRecommandProductByBrand(SmartList<RecommandProduct> resultList, String brandId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RecommandProduct.BRAND_PROPERTY, brandId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RecommandProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Recommand Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RecommandProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RecommandProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRecommandProductByBrand(String brandId,Map<String,Object> options){

 		return countWith(RecommandProductTable.COLUMN_BRAND, brandId, options);
 	}
 	@Override
	public Map<String, Integer> countRecommandProductByBrandIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RecommandProductTable.COLUMN_BRAND, ids, options);
	}
 	
  	
 	public SmartList<RecommandProduct> findRecommandProductByCatalog(String catalogId,Map<String,Object> options){
 	
  		SmartList<RecommandProduct> resultList = queryWith(RecommandProductTable.COLUMN_CATALOG, catalogId, options, getRecommandProductMapper());
		// analyzeRecommandProductByCatalog(resultList, catalogId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RecommandProduct> findRecommandProductByCatalog(String catalogId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RecommandProduct> resultList =  queryWithRange(RecommandProductTable.COLUMN_CATALOG, catalogId, options, getRecommandProductMapper(), start, count);
 		//analyzeRecommandProductByCatalog(resultList, catalogId, options);
 		return resultList;
 		
 	}
 	public void analyzeRecommandProductByCatalog(SmartList<RecommandProduct> resultList, String catalogId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RecommandProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Recommand Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RecommandProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RecommandProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRecommandProductByCatalog(String catalogId,Map<String,Object> options){

 		return countWith(RecommandProductTable.COLUMN_CATALOG, catalogId, options);
 	}
 	@Override
	public Map<String, Integer> countRecommandProductByCatalogIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RecommandProductTable.COLUMN_CATALOG, ids, options);
	}
 	
  	
 	public SmartList<RecommandProduct> findRecommandProductByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<RecommandProduct> resultList = queryWith(RecommandProductTable.COLUMN_PROFILE, profileId, options, getRecommandProductMapper());
		// analyzeRecommandProductByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RecommandProduct> findRecommandProductByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RecommandProduct> resultList =  queryWithRange(RecommandProductTable.COLUMN_PROFILE, profileId, options, getRecommandProductMapper(), start, count);
 		//analyzeRecommandProductByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeRecommandProductByProfile(SmartList<RecommandProduct> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RecommandProduct.PROFILE_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RecommandProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Recommand Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RecommandProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RecommandProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRecommandProductByProfile(String profileId,Map<String,Object> options){

 		return countWith(RecommandProductTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countRecommandProductByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RecommandProductTable.COLUMN_PROFILE, ids, options);
	}
 	
  	
 	public SmartList<RecommandProduct> findRecommandProductByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<RecommandProduct> resultList = queryWith(RecommandProductTable.COLUMN_PLATFORM, platformId, options, getRecommandProductMapper());
		// analyzeRecommandProductByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RecommandProduct> findRecommandProductByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RecommandProduct> resultList =  queryWithRange(RecommandProductTable.COLUMN_PLATFORM, platformId, options, getRecommandProductMapper(), start, count);
 		//analyzeRecommandProductByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeRecommandProductByPlatform(SmartList<RecommandProduct> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RecommandProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Recommand Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RecommandProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RecommandProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRecommandProductByPlatform(String platformId,Map<String,Object> options){

 		return countWith(RecommandProductTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countRecommandProductByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RecommandProductTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected RecommandProduct saveRecommandProduct(RecommandProduct  recommandProduct){
		
		if(!recommandProduct.isChanged()){
			return recommandProduct;
		}
		
		
		String SQL=this.getSaveRecommandProductSQL(recommandProduct);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRecommandProductParameters(recommandProduct);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		recommandProduct.incVersion();
		return recommandProduct;
	
	}
	public SmartList<RecommandProduct> saveRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRecommandProductList(recommandProductList);
		
		batchRecommandProductCreate((List<RecommandProduct>)lists[CREATE_LIST_INDEX]);
		
		batchRecommandProductUpdate((List<RecommandProduct>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RecommandProduct recommandProduct:recommandProductList){
			if(recommandProduct.isChanged()){
				recommandProduct.incVersion();
			}
			
		
		}
		
		
		return recommandProductList;
	}

	public SmartList<RecommandProduct> removeRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options){
		
		
		super.removeList(recommandProductList, options);
		
		return recommandProductList;
		
		
	}
	
	protected List<Object[]> prepareRecommandProductBatchCreateArgs(List<RecommandProduct> recommandProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RecommandProduct recommandProduct:recommandProductList ){
			Object [] parameters = prepareRecommandProductCreateParameters(recommandProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRecommandProductBatchUpdateArgs(List<RecommandProduct> recommandProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RecommandProduct recommandProduct:recommandProductList ){
			if(!recommandProduct.isChanged()){
				continue;
			}
			Object [] parameters = prepareRecommandProductUpdateParameters(recommandProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRecommandProductCreate(List<RecommandProduct> recommandProductList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRecommandProductBatchCreateArgs(recommandProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRecommandProductUpdate(List<RecommandProduct> recommandProductList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRecommandProductBatchUpdateArgs(recommandProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRecommandProductList(List<RecommandProduct> recommandProductList){
		
		List<RecommandProduct> recommandProductCreateList=new ArrayList<RecommandProduct>();
		List<RecommandProduct> recommandProductUpdateList=new ArrayList<RecommandProduct>();
		
		for(RecommandProduct recommandProduct: recommandProductList){
			if(isUpdateRequest(recommandProduct)){
				recommandProductUpdateList.add( recommandProduct);
				continue;
			}
			recommandProductCreateList.add(recommandProduct);
		}
		
		return new Object[]{recommandProductCreateList,recommandProductUpdateList};
	}
	
	protected boolean isUpdateRequest(RecommandProduct recommandProduct){
 		return recommandProduct.getVersion() > 0;
 	}
 	protected String getSaveRecommandProductSQL(RecommandProduct recommandProduct){
 		if(isUpdateRequest(recommandProduct)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRecommandProductParameters(RecommandProduct recommandProduct){
 		if(isUpdateRequest(recommandProduct) ){
 			return prepareRecommandProductUpdateParameters(recommandProduct);
 		}
 		return prepareRecommandProductCreateParameters(recommandProduct);
 	}
 	protected Object[] prepareRecommandProductUpdateParameters(RecommandProduct recommandProduct){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = recommandProduct.getName(); 	
 		if(recommandProduct.getParentCategory() != null){
 			parameters[1] = recommandProduct.getParentCategory().getId();
 		}
  	
 		if(recommandProduct.getBrand() != null){
 			parameters[2] = recommandProduct.getBrand().getId();
 		}
 
 		parameters[3] = recommandProduct.getProductCoverImage();
 		parameters[4] = recommandProduct.getOrigin(); 	
 		if(recommandProduct.getCatalog() != null){
 			parameters[5] = recommandProduct.getCatalog().getId();
 		}
 
 		parameters[6] = recommandProduct.getRemark();
 		parameters[7] = recommandProduct.getLastUpdateTime(); 	
 		if(recommandProduct.getProfile() != null){
 			parameters[8] = recommandProduct.getProfile().getId();
 		}
  	
 		if(recommandProduct.getPlatform() != null){
 			parameters[9] = recommandProduct.getPlatform().getId();
 		}
 		
 		parameters[10] = recommandProduct.nextVersion();
 		parameters[11] = recommandProduct.getId();
 		parameters[12] = recommandProduct.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRecommandProductCreateParameters(RecommandProduct recommandProduct){
		Object[] parameters = new Object[11];
		String newRecommandProductId=getNextId();
		recommandProduct.setId(newRecommandProductId);
		parameters[0] =  recommandProduct.getId();
 
 		parameters[1] = recommandProduct.getName(); 	
 		if(recommandProduct.getParentCategory() != null){
 			parameters[2] = recommandProduct.getParentCategory().getId();
 		
 		}
 		 	
 		if(recommandProduct.getBrand() != null){
 			parameters[3] = recommandProduct.getBrand().getId();
 		
 		}
 		
 		parameters[4] = recommandProduct.getProductCoverImage();
 		parameters[5] = recommandProduct.getOrigin(); 	
 		if(recommandProduct.getCatalog() != null){
 			parameters[6] = recommandProduct.getCatalog().getId();
 		
 		}
 		
 		parameters[7] = recommandProduct.getRemark();
 		parameters[8] = recommandProduct.getLastUpdateTime(); 	
 		if(recommandProduct.getProfile() != null){
 			parameters[9] = recommandProduct.getProfile().getId();
 		
 		}
 		 	
 		if(recommandProduct.getPlatform() != null){
 			parameters[10] = recommandProduct.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected RecommandProduct saveInternalRecommandProduct(RecommandProduct recommandProduct, Map<String,Object> options){
		
		saveRecommandProduct(recommandProduct);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(recommandProduct, options);
 		}
  	
 		if(isSaveBrandEnabled(options)){
	 		saveBrand(recommandProduct, options);
 		}
  	
 		if(isSaveCatalogEnabled(options)){
	 		saveCatalog(recommandProduct, options);
 		}
  	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(recommandProduct, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(recommandProduct, options);
 		}
 
		
		return recommandProduct;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RecommandProduct saveParentCategory(RecommandProduct recommandProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(recommandProduct.getParentCategory() == null){
 			return recommandProduct;//do nothing when it is null
 		}
 		
 		getLevelNCategoryDAO().save(recommandProduct.getParentCategory(),options);
 		return recommandProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RecommandProduct saveBrand(RecommandProduct recommandProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(recommandProduct.getBrand() == null){
 			return recommandProduct;//do nothing when it is null
 		}
 		
 		getBrandDAO().save(recommandProduct.getBrand(),options);
 		return recommandProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RecommandProduct saveCatalog(RecommandProduct recommandProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(recommandProduct.getCatalog() == null){
 			return recommandProduct;//do nothing when it is null
 		}
 		
 		getCatalogDAO().save(recommandProduct.getCatalog(),options);
 		return recommandProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RecommandProduct saveProfile(RecommandProduct recommandProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(recommandProduct.getProfile() == null){
 			return recommandProduct;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(recommandProduct.getProfile(),options);
 		return recommandProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RecommandProduct savePlatform(RecommandProduct recommandProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(recommandProduct.getPlatform() == null){
 			return recommandProduct;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(recommandProduct.getPlatform(),options);
 		return recommandProduct;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public RecommandProduct present(RecommandProduct recommandProduct,Map<String, Object> options){
	

		return recommandProduct;
	
	}
		

	

	protected String getTableName(){
		return RecommandProductTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RecommandProduct> recommandProductList) {		
		this.enhanceListInternal(recommandProductList, this.getRecommandProductMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RecommandProduct> recommandProductList = ownerEntity.collectRefsWithType(RecommandProduct.INTERNAL_TYPE);
		this.enhanceList(recommandProductList);
		
	}
	
	@Override
	public SmartList<RecommandProduct> findRecommandProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRecommandProductMapper());

	}
	@Override
	public int countRecommandProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRecommandProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RecommandProduct> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRecommandProductMapper());
	}
}


