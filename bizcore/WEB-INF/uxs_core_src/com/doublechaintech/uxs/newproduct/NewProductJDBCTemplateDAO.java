
package com.doublechaintech.uxs.newproduct;

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

public class NewProductJDBCTemplateDAO extends UxsNamingServiceDAO implements NewProductDAO{
 
 	
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
	protected NewProduct load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalNewProduct(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public NewProduct load(String id,Map<String,Object> options) throws Exception{
		return loadInternalNewProduct(NewProductTable.withId(id), options);
	}
	
	
	
	public NewProduct save(NewProduct newProduct,Map<String,Object> options){
		
		String methodName="save(NewProduct newProduct,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(newProduct, methodName, "newProduct");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalNewProduct(newProduct,options);
	}
	public NewProduct clone(String newProductId, Map<String,Object> options) throws Exception{
	
		return clone(NewProductTable.withId(newProductId),options);
	}
	
	protected NewProduct clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String newProductId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		NewProduct newNewProduct = loadInternalNewProduct(accessKey, options);
		newNewProduct.setVersion(0);
		
		

		
		saveInternalNewProduct(newNewProduct,options);
		
		return newNewProduct;
	}
	
	
	
	

	protected void throwIfHasException(String newProductId,int version,int count) throws Exception{
		if (count == 1) {
			throw new NewProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new NewProductNotFoundException(
					"The " + this.getTableName() + "(" + newProductId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String newProductId, int version) throws Exception{
	
		String methodName="delete(String newProductId, int version)";
		assertMethodArgumentNotNull(newProductId, methodName, "newProductId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{newProductId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(newProductId,version);
		}
		
	
	}
	
	
	
	
	

	public NewProduct disconnectFromAll(String newProductId, int version) throws Exception{
	
		
		NewProduct newProduct = loadInternalNewProduct(NewProductTable.withId(newProductId), emptyOptions());
		newProduct.clearFromAll();
		this.saveNewProduct(newProduct);
		return newProduct;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return NewProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "new_product";
	}
	@Override
	protected String getBeanName() {
		
		return "newProduct";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return NewProductTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NewProductTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NewProductTokens.PARENTCATEGORY);
 	}
 	

 	
  

 	protected boolean isExtractBrandEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NewProductTokens.BRAND);
 	}

 	protected boolean isSaveBrandEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NewProductTokens.BRAND);
 	}
 	

 	
  

 	protected boolean isExtractCatalogEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NewProductTokens.CATALOG);
 	}

 	protected boolean isSaveCatalogEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NewProductTokens.CATALOG);
 	}
 	

 	
  

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NewProductTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NewProductTokens.PROFILE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NewProductTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NewProductTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected NewProductMapper getNewProductMapper(){
		return new NewProductMapper();
	}

	
	
	protected NewProduct extractNewProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			NewProduct newProduct = loadSingleObject(accessKey, getNewProductMapper());
			return newProduct;
		}catch(EmptyResultDataAccessException e){
			throw new NewProductNotFoundException("NewProduct("+accessKey+") is not found!");
		}

	}

	
	

	protected NewProduct loadInternalNewProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		NewProduct newProduct = extractNewProduct(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(newProduct, loadOptions);
 		}
  	
 		if(isExtractBrandEnabled(loadOptions)){
	 		extractBrand(newProduct, loadOptions);
 		}
  	
 		if(isExtractCatalogEnabled(loadOptions)){
	 		extractCatalog(newProduct, loadOptions);
 		}
  	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(newProduct, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(newProduct, loadOptions);
 		}
 
		
		return newProduct;
		
	}

	 

 	protected NewProduct extractParentCategory(NewProduct newProduct, Map<String,Object> options) throws Exception{

		if(newProduct.getParentCategory() == null){
			return newProduct;
		}
		String parentCategoryId = newProduct.getParentCategory().getId();
		if( parentCategoryId == null){
			return newProduct;
		}
		LevelNCategory parentCategory = getLevelNCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			newProduct.setParentCategory(parentCategory);
		}
		
 		
 		return newProduct;
 	}
 		
  

 	protected NewProduct extractBrand(NewProduct newProduct, Map<String,Object> options) throws Exception{

		if(newProduct.getBrand() == null){
			return newProduct;
		}
		String brandId = newProduct.getBrand().getId();
		if( brandId == null){
			return newProduct;
		}
		Brand brand = getBrandDAO().load(brandId,options);
		if(brand != null){
			newProduct.setBrand(brand);
		}
		
 		
 		return newProduct;
 	}
 		
  

 	protected NewProduct extractCatalog(NewProduct newProduct, Map<String,Object> options) throws Exception{

		if(newProduct.getCatalog() == null){
			return newProduct;
		}
		String catalogId = newProduct.getCatalog().getId();
		if( catalogId == null){
			return newProduct;
		}
		Catalog catalog = getCatalogDAO().load(catalogId,options);
		if(catalog != null){
			newProduct.setCatalog(catalog);
		}
		
 		
 		return newProduct;
 	}
 		
  

 	protected NewProduct extractProfile(NewProduct newProduct, Map<String,Object> options) throws Exception{

		if(newProduct.getProfile() == null){
			return newProduct;
		}
		String profileId = newProduct.getProfile().getId();
		if( profileId == null){
			return newProduct;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			newProduct.setProfile(profile);
		}
		
 		
 		return newProduct;
 	}
 		
  

 	protected NewProduct extractPlatform(NewProduct newProduct, Map<String,Object> options) throws Exception{

		if(newProduct.getPlatform() == null){
			return newProduct;
		}
		String platformId = newProduct.getPlatform().getId();
		if( platformId == null){
			return newProduct;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			newProduct.setPlatform(platform);
		}
		
 		
 		return newProduct;
 	}
 		
 
		
		
  	
 	public SmartList<NewProduct> findNewProductByParentCategory(String levelNCategoryId,Map<String,Object> options){
 	
  		SmartList<NewProduct> resultList = queryWith(NewProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options, getNewProductMapper());
		// analyzeNewProductByParentCategory(resultList, levelNCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<NewProduct> findNewProductByParentCategory(String levelNCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<NewProduct> resultList =  queryWithRange(NewProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options, getNewProductMapper(), start, count);
 		//analyzeNewProductByParentCategory(resultList, levelNCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeNewProductByParentCategory(SmartList<NewProduct> resultList, String levelNCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//NewProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("New Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(NewProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(NewProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNewProductByParentCategory(String levelNCategoryId,Map<String,Object> options){

 		return countWith(NewProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countNewProductByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NewProductTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
  	
 	public SmartList<NewProduct> findNewProductByBrand(String brandId,Map<String,Object> options){
 	
  		SmartList<NewProduct> resultList = queryWith(NewProductTable.COLUMN_BRAND, brandId, options, getNewProductMapper());
		// analyzeNewProductByBrand(resultList, brandId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<NewProduct> findNewProductByBrand(String brandId, int start, int count,Map<String,Object> options){
 		
 		SmartList<NewProduct> resultList =  queryWithRange(NewProductTable.COLUMN_BRAND, brandId, options, getNewProductMapper(), start, count);
 		//analyzeNewProductByBrand(resultList, brandId, options);
 		return resultList;
 		
 	}
 	public void analyzeNewProductByBrand(SmartList<NewProduct> resultList, String brandId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(NewProduct.BRAND_PROPERTY, brandId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//NewProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("New Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(NewProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(NewProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNewProductByBrand(String brandId,Map<String,Object> options){

 		return countWith(NewProductTable.COLUMN_BRAND, brandId, options);
 	}
 	@Override
	public Map<String, Integer> countNewProductByBrandIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NewProductTable.COLUMN_BRAND, ids, options);
	}
 	
  	
 	public SmartList<NewProduct> findNewProductByCatalog(String catalogId,Map<String,Object> options){
 	
  		SmartList<NewProduct> resultList = queryWith(NewProductTable.COLUMN_CATALOG, catalogId, options, getNewProductMapper());
		// analyzeNewProductByCatalog(resultList, catalogId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<NewProduct> findNewProductByCatalog(String catalogId, int start, int count,Map<String,Object> options){
 		
 		SmartList<NewProduct> resultList =  queryWithRange(NewProductTable.COLUMN_CATALOG, catalogId, options, getNewProductMapper(), start, count);
 		//analyzeNewProductByCatalog(resultList, catalogId, options);
 		return resultList;
 		
 	}
 	public void analyzeNewProductByCatalog(SmartList<NewProduct> resultList, String catalogId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(NewProduct.CATALOG_PROPERTY, catalogId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//NewProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("New Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(NewProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(NewProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNewProductByCatalog(String catalogId,Map<String,Object> options){

 		return countWith(NewProductTable.COLUMN_CATALOG, catalogId, options);
 	}
 	@Override
	public Map<String, Integer> countNewProductByCatalogIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NewProductTable.COLUMN_CATALOG, ids, options);
	}
 	
  	
 	public SmartList<NewProduct> findNewProductByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<NewProduct> resultList = queryWith(NewProductTable.COLUMN_PROFILE, profileId, options, getNewProductMapper());
		// analyzeNewProductByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<NewProduct> findNewProductByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<NewProduct> resultList =  queryWithRange(NewProductTable.COLUMN_PROFILE, profileId, options, getNewProductMapper(), start, count);
 		//analyzeNewProductByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeNewProductByProfile(SmartList<NewProduct> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(NewProduct.PROFILE_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//NewProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("New Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(NewProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(NewProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNewProductByProfile(String profileId,Map<String,Object> options){

 		return countWith(NewProductTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countNewProductByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NewProductTable.COLUMN_PROFILE, ids, options);
	}
 	
  	
 	public SmartList<NewProduct> findNewProductByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<NewProduct> resultList = queryWith(NewProductTable.COLUMN_PLATFORM, platformId, options, getNewProductMapper());
		// analyzeNewProductByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<NewProduct> findNewProductByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<NewProduct> resultList =  queryWithRange(NewProductTable.COLUMN_PLATFORM, platformId, options, getNewProductMapper(), start, count);
 		//analyzeNewProductByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeNewProductByPlatform(SmartList<NewProduct> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(NewProduct.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//NewProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("New Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(NewProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(NewProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNewProductByPlatform(String platformId,Map<String,Object> options){

 		return countWith(NewProductTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countNewProductByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NewProductTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected NewProduct saveNewProduct(NewProduct  newProduct){
		
		if(!newProduct.isChanged()){
			return newProduct;
		}
		
		
		String SQL=this.getSaveNewProductSQL(newProduct);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveNewProductParameters(newProduct);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		newProduct.incVersion();
		return newProduct;
	
	}
	public SmartList<NewProduct> saveNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitNewProductList(newProductList);
		
		batchNewProductCreate((List<NewProduct>)lists[CREATE_LIST_INDEX]);
		
		batchNewProductUpdate((List<NewProduct>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(NewProduct newProduct:newProductList){
			if(newProduct.isChanged()){
				newProduct.incVersion();
			}
			
		
		}
		
		
		return newProductList;
	}

	public SmartList<NewProduct> removeNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options){
		
		
		super.removeList(newProductList, options);
		
		return newProductList;
		
		
	}
	
	protected List<Object[]> prepareNewProductBatchCreateArgs(List<NewProduct> newProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(NewProduct newProduct:newProductList ){
			Object [] parameters = prepareNewProductCreateParameters(newProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareNewProductBatchUpdateArgs(List<NewProduct> newProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(NewProduct newProduct:newProductList ){
			if(!newProduct.isChanged()){
				continue;
			}
			Object [] parameters = prepareNewProductUpdateParameters(newProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchNewProductCreate(List<NewProduct> newProductList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareNewProductBatchCreateArgs(newProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchNewProductUpdate(List<NewProduct> newProductList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareNewProductBatchUpdateArgs(newProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitNewProductList(List<NewProduct> newProductList){
		
		List<NewProduct> newProductCreateList=new ArrayList<NewProduct>();
		List<NewProduct> newProductUpdateList=new ArrayList<NewProduct>();
		
		for(NewProduct newProduct: newProductList){
			if(isUpdateRequest(newProduct)){
				newProductUpdateList.add( newProduct);
				continue;
			}
			newProductCreateList.add(newProduct);
		}
		
		return new Object[]{newProductCreateList,newProductUpdateList};
	}
	
	protected boolean isUpdateRequest(NewProduct newProduct){
 		return newProduct.getVersion() > 0;
 	}
 	protected String getSaveNewProductSQL(NewProduct newProduct){
 		if(isUpdateRequest(newProduct)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveNewProductParameters(NewProduct newProduct){
 		if(isUpdateRequest(newProduct) ){
 			return prepareNewProductUpdateParameters(newProduct);
 		}
 		return prepareNewProductCreateParameters(newProduct);
 	}
 	protected Object[] prepareNewProductUpdateParameters(NewProduct newProduct){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = newProduct.getName(); 	
 		if(newProduct.getParentCategory() != null){
 			parameters[1] = newProduct.getParentCategory().getId();
 		}
  	
 		if(newProduct.getBrand() != null){
 			parameters[2] = newProduct.getBrand().getId();
 		}
 
 		parameters[3] = newProduct.getProductCoverImage();
 		parameters[4] = newProduct.getOrigin(); 	
 		if(newProduct.getCatalog() != null){
 			parameters[5] = newProduct.getCatalog().getId();
 		}
  	
 		if(newProduct.getProfile() != null){
 			parameters[6] = newProduct.getProfile().getId();
 		}
 
 		parameters[7] = newProduct.getRemark();
 		parameters[8] = newProduct.getLastUpdateTime(); 	
 		if(newProduct.getPlatform() != null){
 			parameters[9] = newProduct.getPlatform().getId();
 		}
 		
 		parameters[10] = newProduct.nextVersion();
 		parameters[11] = newProduct.getId();
 		parameters[12] = newProduct.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareNewProductCreateParameters(NewProduct newProduct){
		Object[] parameters = new Object[11];
		String newNewProductId=getNextId();
		newProduct.setId(newNewProductId);
		parameters[0] =  newProduct.getId();
 
 		parameters[1] = newProduct.getName(); 	
 		if(newProduct.getParentCategory() != null){
 			parameters[2] = newProduct.getParentCategory().getId();
 		
 		}
 		 	
 		if(newProduct.getBrand() != null){
 			parameters[3] = newProduct.getBrand().getId();
 		
 		}
 		
 		parameters[4] = newProduct.getProductCoverImage();
 		parameters[5] = newProduct.getOrigin(); 	
 		if(newProduct.getCatalog() != null){
 			parameters[6] = newProduct.getCatalog().getId();
 		
 		}
 		 	
 		if(newProduct.getProfile() != null){
 			parameters[7] = newProduct.getProfile().getId();
 		
 		}
 		
 		parameters[8] = newProduct.getRemark();
 		parameters[9] = newProduct.getLastUpdateTime(); 	
 		if(newProduct.getPlatform() != null){
 			parameters[10] = newProduct.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected NewProduct saveInternalNewProduct(NewProduct newProduct, Map<String,Object> options){
		
		saveNewProduct(newProduct);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(newProduct, options);
 		}
  	
 		if(isSaveBrandEnabled(options)){
	 		saveBrand(newProduct, options);
 		}
  	
 		if(isSaveCatalogEnabled(options)){
	 		saveCatalog(newProduct, options);
 		}
  	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(newProduct, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(newProduct, options);
 		}
 
		
		return newProduct;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected NewProduct saveParentCategory(NewProduct newProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(newProduct.getParentCategory() == null){
 			return newProduct;//do nothing when it is null
 		}
 		
 		getLevelNCategoryDAO().save(newProduct.getParentCategory(),options);
 		return newProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected NewProduct saveBrand(NewProduct newProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(newProduct.getBrand() == null){
 			return newProduct;//do nothing when it is null
 		}
 		
 		getBrandDAO().save(newProduct.getBrand(),options);
 		return newProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected NewProduct saveCatalog(NewProduct newProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(newProduct.getCatalog() == null){
 			return newProduct;//do nothing when it is null
 		}
 		
 		getCatalogDAO().save(newProduct.getCatalog(),options);
 		return newProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected NewProduct saveProfile(NewProduct newProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(newProduct.getProfile() == null){
 			return newProduct;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(newProduct.getProfile(),options);
 		return newProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected NewProduct savePlatform(NewProduct newProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(newProduct.getPlatform() == null){
 			return newProduct;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(newProduct.getPlatform(),options);
 		return newProduct;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public NewProduct present(NewProduct newProduct,Map<String, Object> options){
	

		return newProduct;
	
	}
		

	

	protected String getTableName(){
		return NewProductTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<NewProduct> newProductList) {		
		this.enhanceListInternal(newProductList, this.getNewProductMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<NewProduct> newProductList = ownerEntity.collectRefsWithType(NewProduct.INTERNAL_TYPE);
		this.enhanceList(newProductList);
		
	}
	
	@Override
	public SmartList<NewProduct> findNewProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getNewProductMapper());

	}
	@Override
	public int countNewProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countNewProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<NewProduct> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getNewProductMapper());
	}
}


