
package com.doublechaintech.uxs.editorpickproduct;

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

public class EditorPickProductJDBCTemplateDAO extends UxsNamingServiceDAO implements EditorPickProductDAO{
 
 	
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
	protected EditorPickProduct load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEditorPickProduct(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public EditorPickProduct load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEditorPickProduct(EditorPickProductTable.withId(id), options);
	}
	
	
	
	public EditorPickProduct save(EditorPickProduct editorPickProduct,Map<String,Object> options){
		
		String methodName="save(EditorPickProduct editorPickProduct,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(editorPickProduct, methodName, "editorPickProduct");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEditorPickProduct(editorPickProduct,options);
	}
	public EditorPickProduct clone(String editorPickProductId, Map<String,Object> options) throws Exception{
	
		return clone(EditorPickProductTable.withId(editorPickProductId),options);
	}
	
	protected EditorPickProduct clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String editorPickProductId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EditorPickProduct newEditorPickProduct = loadInternalEditorPickProduct(accessKey, options);
		newEditorPickProduct.setVersion(0);
		
		

		
		saveInternalEditorPickProduct(newEditorPickProduct,options);
		
		return newEditorPickProduct;
	}
	
	
	
	

	protected void throwIfHasException(String editorPickProductId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EditorPickProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EditorPickProductNotFoundException(
					"The " + this.getTableName() + "(" + editorPickProductId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String editorPickProductId, int version) throws Exception{
	
		String methodName="delete(String editorPickProductId, int version)";
		assertMethodArgumentNotNull(editorPickProductId, methodName, "editorPickProductId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{editorPickProductId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(editorPickProductId,version);
		}
		
	
	}
	
	
	
	
	

	public EditorPickProduct disconnectFromAll(String editorPickProductId, int version) throws Exception{
	
		
		EditorPickProduct editorPickProduct = loadInternalEditorPickProduct(EditorPickProductTable.withId(editorPickProductId), emptyOptions());
		editorPickProduct.clearFromAll();
		this.saveEditorPickProduct(editorPickProduct);
		return editorPickProduct;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return EditorPickProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "editor_pick_product";
	}
	@Override
	protected String getBeanName() {
		
		return "editorPickProduct";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EditorPickProductTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EditorPickProductTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EditorPickProductTokens.PARENTCATEGORY);
 	}
 	

 	
  

 	protected boolean isExtractBrandEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EditorPickProductTokens.BRAND);
 	}

 	protected boolean isSaveBrandEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EditorPickProductTokens.BRAND);
 	}
 	

 	
  

 	protected boolean isExtractCatalogEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EditorPickProductTokens.CATALOG);
 	}

 	protected boolean isSaveCatalogEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EditorPickProductTokens.CATALOG);
 	}
 	

 	
  

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EditorPickProductTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EditorPickProductTokens.PROFILE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EditorPickProductTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EditorPickProductTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected EditorPickProductMapper getEditorPickProductMapper(){
		return new EditorPickProductMapper();
	}

	
	
	protected EditorPickProduct extractEditorPickProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EditorPickProduct editorPickProduct = loadSingleObject(accessKey, getEditorPickProductMapper());
			return editorPickProduct;
		}catch(EmptyResultDataAccessException e){
			throw new EditorPickProductNotFoundException("EditorPickProduct("+accessKey+") is not found!");
		}

	}

	
	

	protected EditorPickProduct loadInternalEditorPickProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EditorPickProduct editorPickProduct = extractEditorPickProduct(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(editorPickProduct, loadOptions);
 		}
  	
 		if(isExtractBrandEnabled(loadOptions)){
	 		extractBrand(editorPickProduct, loadOptions);
 		}
  	
 		if(isExtractCatalogEnabled(loadOptions)){
	 		extractCatalog(editorPickProduct, loadOptions);
 		}
  	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(editorPickProduct, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(editorPickProduct, loadOptions);
 		}
 
		
		return editorPickProduct;
		
	}

	 

 	protected EditorPickProduct extractParentCategory(EditorPickProduct editorPickProduct, Map<String,Object> options) throws Exception{

		if(editorPickProduct.getParentCategory() == null){
			return editorPickProduct;
		}
		String parentCategoryId = editorPickProduct.getParentCategory().getId();
		if( parentCategoryId == null){
			return editorPickProduct;
		}
		LevelNCategory parentCategory = getLevelNCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			editorPickProduct.setParentCategory(parentCategory);
		}
		
 		
 		return editorPickProduct;
 	}
 		
  

 	protected EditorPickProduct extractBrand(EditorPickProduct editorPickProduct, Map<String,Object> options) throws Exception{

		if(editorPickProduct.getBrand() == null){
			return editorPickProduct;
		}
		String brandId = editorPickProduct.getBrand().getId();
		if( brandId == null){
			return editorPickProduct;
		}
		Brand brand = getBrandDAO().load(brandId,options);
		if(brand != null){
			editorPickProduct.setBrand(brand);
		}
		
 		
 		return editorPickProduct;
 	}
 		
  

 	protected EditorPickProduct extractCatalog(EditorPickProduct editorPickProduct, Map<String,Object> options) throws Exception{

		if(editorPickProduct.getCatalog() == null){
			return editorPickProduct;
		}
		String catalogId = editorPickProduct.getCatalog().getId();
		if( catalogId == null){
			return editorPickProduct;
		}
		Catalog catalog = getCatalogDAO().load(catalogId,options);
		if(catalog != null){
			editorPickProduct.setCatalog(catalog);
		}
		
 		
 		return editorPickProduct;
 	}
 		
  

 	protected EditorPickProduct extractProfile(EditorPickProduct editorPickProduct, Map<String,Object> options) throws Exception{

		if(editorPickProduct.getProfile() == null){
			return editorPickProduct;
		}
		String profileId = editorPickProduct.getProfile().getId();
		if( profileId == null){
			return editorPickProduct;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			editorPickProduct.setProfile(profile);
		}
		
 		
 		return editorPickProduct;
 	}
 		
  

 	protected EditorPickProduct extractPlatform(EditorPickProduct editorPickProduct, Map<String,Object> options) throws Exception{

		if(editorPickProduct.getPlatform() == null){
			return editorPickProduct;
		}
		String platformId = editorPickProduct.getPlatform().getId();
		if( platformId == null){
			return editorPickProduct;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			editorPickProduct.setPlatform(platform);
		}
		
 		
 		return editorPickProduct;
 	}
 		
 
		
		
  	
 	public SmartList<EditorPickProduct> findEditorPickProductByParentCategory(String levelNCategoryId,Map<String,Object> options){
 	
  		SmartList<EditorPickProduct> resultList = queryWith(EditorPickProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options, getEditorPickProductMapper());
		// analyzeEditorPickProductByParentCategory(resultList, levelNCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EditorPickProduct> findEditorPickProductByParentCategory(String levelNCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EditorPickProduct> resultList =  queryWithRange(EditorPickProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options, getEditorPickProductMapper(), start, count);
 		//analyzeEditorPickProductByParentCategory(resultList, levelNCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeEditorPickProductByParentCategory(SmartList<EditorPickProduct> resultList, String levelNCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//EditorPickProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Editor Pick Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEditorPickProductByParentCategory(String levelNCategoryId,Map<String,Object> options){

 		return countWith(EditorPickProductTable.COLUMN_PARENT_CATEGORY, levelNCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countEditorPickProductByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EditorPickProductTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
  	
 	public SmartList<EditorPickProduct> findEditorPickProductByBrand(String brandId,Map<String,Object> options){
 	
  		SmartList<EditorPickProduct> resultList = queryWith(EditorPickProductTable.COLUMN_BRAND, brandId, options, getEditorPickProductMapper());
		// analyzeEditorPickProductByBrand(resultList, brandId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EditorPickProduct> findEditorPickProductByBrand(String brandId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EditorPickProduct> resultList =  queryWithRange(EditorPickProductTable.COLUMN_BRAND, brandId, options, getEditorPickProductMapper(), start, count);
 		//analyzeEditorPickProductByBrand(resultList, brandId, options);
 		return resultList;
 		
 	}
 	public void analyzeEditorPickProductByBrand(SmartList<EditorPickProduct> resultList, String brandId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EditorPickProduct.BRAND_PROPERTY, brandId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//EditorPickProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Editor Pick Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEditorPickProductByBrand(String brandId,Map<String,Object> options){

 		return countWith(EditorPickProductTable.COLUMN_BRAND, brandId, options);
 	}
 	@Override
	public Map<String, Integer> countEditorPickProductByBrandIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EditorPickProductTable.COLUMN_BRAND, ids, options);
	}
 	
  	
 	public SmartList<EditorPickProduct> findEditorPickProductByCatalog(String catalogId,Map<String,Object> options){
 	
  		SmartList<EditorPickProduct> resultList = queryWith(EditorPickProductTable.COLUMN_CATALOG, catalogId, options, getEditorPickProductMapper());
		// analyzeEditorPickProductByCatalog(resultList, catalogId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EditorPickProduct> findEditorPickProductByCatalog(String catalogId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EditorPickProduct> resultList =  queryWithRange(EditorPickProductTable.COLUMN_CATALOG, catalogId, options, getEditorPickProductMapper(), start, count);
 		//analyzeEditorPickProductByCatalog(resultList, catalogId, options);
 		return resultList;
 		
 	}
 	public void analyzeEditorPickProductByCatalog(SmartList<EditorPickProduct> resultList, String catalogId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//EditorPickProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Editor Pick Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEditorPickProductByCatalog(String catalogId,Map<String,Object> options){

 		return countWith(EditorPickProductTable.COLUMN_CATALOG, catalogId, options);
 	}
 	@Override
	public Map<String, Integer> countEditorPickProductByCatalogIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EditorPickProductTable.COLUMN_CATALOG, ids, options);
	}
 	
  	
 	public SmartList<EditorPickProduct> findEditorPickProductByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<EditorPickProduct> resultList = queryWith(EditorPickProductTable.COLUMN_PROFILE, profileId, options, getEditorPickProductMapper());
		// analyzeEditorPickProductByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EditorPickProduct> findEditorPickProductByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EditorPickProduct> resultList =  queryWithRange(EditorPickProductTable.COLUMN_PROFILE, profileId, options, getEditorPickProductMapper(), start, count);
 		//analyzeEditorPickProductByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeEditorPickProductByProfile(SmartList<EditorPickProduct> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//EditorPickProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Editor Pick Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEditorPickProductByProfile(String profileId,Map<String,Object> options){

 		return countWith(EditorPickProductTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countEditorPickProductByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EditorPickProductTable.COLUMN_PROFILE, ids, options);
	}
 	
  	
 	public SmartList<EditorPickProduct> findEditorPickProductByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<EditorPickProduct> resultList = queryWith(EditorPickProductTable.COLUMN_PLATFORM, platformId, options, getEditorPickProductMapper());
		// analyzeEditorPickProductByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EditorPickProduct> findEditorPickProductByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EditorPickProduct> resultList =  queryWithRange(EditorPickProductTable.COLUMN_PLATFORM, platformId, options, getEditorPickProductMapper(), start, count);
 		//analyzeEditorPickProductByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeEditorPickProductByPlatform(SmartList<EditorPickProduct> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//EditorPickProduct.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("Editor Pick Product");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(EditorPickProduct.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEditorPickProductByPlatform(String platformId,Map<String,Object> options){

 		return countWith(EditorPickProductTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countEditorPickProductByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EditorPickProductTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected EditorPickProduct saveEditorPickProduct(EditorPickProduct  editorPickProduct){
		
		if(!editorPickProduct.isChanged()){
			return editorPickProduct;
		}
		
		
		String SQL=this.getSaveEditorPickProductSQL(editorPickProduct);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEditorPickProductParameters(editorPickProduct);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		editorPickProduct.incVersion();
		return editorPickProduct;
	
	}
	public SmartList<EditorPickProduct> saveEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEditorPickProductList(editorPickProductList);
		
		batchEditorPickProductCreate((List<EditorPickProduct>)lists[CREATE_LIST_INDEX]);
		
		batchEditorPickProductUpdate((List<EditorPickProduct>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EditorPickProduct editorPickProduct:editorPickProductList){
			if(editorPickProduct.isChanged()){
				editorPickProduct.incVersion();
			}
			
		
		}
		
		
		return editorPickProductList;
	}

	public SmartList<EditorPickProduct> removeEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options){
		
		
		super.removeList(editorPickProductList, options);
		
		return editorPickProductList;
		
		
	}
	
	protected List<Object[]> prepareEditorPickProductBatchCreateArgs(List<EditorPickProduct> editorPickProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EditorPickProduct editorPickProduct:editorPickProductList ){
			Object [] parameters = prepareEditorPickProductCreateParameters(editorPickProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEditorPickProductBatchUpdateArgs(List<EditorPickProduct> editorPickProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EditorPickProduct editorPickProduct:editorPickProductList ){
			if(!editorPickProduct.isChanged()){
				continue;
			}
			Object [] parameters = prepareEditorPickProductUpdateParameters(editorPickProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEditorPickProductCreate(List<EditorPickProduct> editorPickProductList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEditorPickProductBatchCreateArgs(editorPickProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEditorPickProductUpdate(List<EditorPickProduct> editorPickProductList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEditorPickProductBatchUpdateArgs(editorPickProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEditorPickProductList(List<EditorPickProduct> editorPickProductList){
		
		List<EditorPickProduct> editorPickProductCreateList=new ArrayList<EditorPickProduct>();
		List<EditorPickProduct> editorPickProductUpdateList=new ArrayList<EditorPickProduct>();
		
		for(EditorPickProduct editorPickProduct: editorPickProductList){
			if(isUpdateRequest(editorPickProduct)){
				editorPickProductUpdateList.add( editorPickProduct);
				continue;
			}
			editorPickProductCreateList.add(editorPickProduct);
		}
		
		return new Object[]{editorPickProductCreateList,editorPickProductUpdateList};
	}
	
	protected boolean isUpdateRequest(EditorPickProduct editorPickProduct){
 		return editorPickProduct.getVersion() > 0;
 	}
 	protected String getSaveEditorPickProductSQL(EditorPickProduct editorPickProduct){
 		if(isUpdateRequest(editorPickProduct)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEditorPickProductParameters(EditorPickProduct editorPickProduct){
 		if(isUpdateRequest(editorPickProduct) ){
 			return prepareEditorPickProductUpdateParameters(editorPickProduct);
 		}
 		return prepareEditorPickProductCreateParameters(editorPickProduct);
 	}
 	protected Object[] prepareEditorPickProductUpdateParameters(EditorPickProduct editorPickProduct){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = editorPickProduct.getName(); 	
 		if(editorPickProduct.getParentCategory() != null){
 			parameters[1] = editorPickProduct.getParentCategory().getId();
 		}
  	
 		if(editorPickProduct.getBrand() != null){
 			parameters[2] = editorPickProduct.getBrand().getId();
 		}
 
 		parameters[3] = editorPickProduct.getProductCoverImage();
 		parameters[4] = editorPickProduct.getOrigin(); 	
 		if(editorPickProduct.getCatalog() != null){
 			parameters[5] = editorPickProduct.getCatalog().getId();
 		}
  	
 		if(editorPickProduct.getProfile() != null){
 			parameters[6] = editorPickProduct.getProfile().getId();
 		}
 
 		parameters[7] = editorPickProduct.getRemark();
 		parameters[8] = editorPickProduct.getLastUpdateTime(); 	
 		if(editorPickProduct.getPlatform() != null){
 			parameters[9] = editorPickProduct.getPlatform().getId();
 		}
 		
 		parameters[10] = editorPickProduct.nextVersion();
 		parameters[11] = editorPickProduct.getId();
 		parameters[12] = editorPickProduct.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEditorPickProductCreateParameters(EditorPickProduct editorPickProduct){
		Object[] parameters = new Object[11];
		String newEditorPickProductId=getNextId();
		editorPickProduct.setId(newEditorPickProductId);
		parameters[0] =  editorPickProduct.getId();
 
 		parameters[1] = editorPickProduct.getName(); 	
 		if(editorPickProduct.getParentCategory() != null){
 			parameters[2] = editorPickProduct.getParentCategory().getId();
 		
 		}
 		 	
 		if(editorPickProduct.getBrand() != null){
 			parameters[3] = editorPickProduct.getBrand().getId();
 		
 		}
 		
 		parameters[4] = editorPickProduct.getProductCoverImage();
 		parameters[5] = editorPickProduct.getOrigin(); 	
 		if(editorPickProduct.getCatalog() != null){
 			parameters[6] = editorPickProduct.getCatalog().getId();
 		
 		}
 		 	
 		if(editorPickProduct.getProfile() != null){
 			parameters[7] = editorPickProduct.getProfile().getId();
 		
 		}
 		
 		parameters[8] = editorPickProduct.getRemark();
 		parameters[9] = editorPickProduct.getLastUpdateTime(); 	
 		if(editorPickProduct.getPlatform() != null){
 			parameters[10] = editorPickProduct.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected EditorPickProduct saveInternalEditorPickProduct(EditorPickProduct editorPickProduct, Map<String,Object> options){
		
		saveEditorPickProduct(editorPickProduct);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(editorPickProduct, options);
 		}
  	
 		if(isSaveBrandEnabled(options)){
	 		saveBrand(editorPickProduct, options);
 		}
  	
 		if(isSaveCatalogEnabled(options)){
	 		saveCatalog(editorPickProduct, options);
 		}
  	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(editorPickProduct, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(editorPickProduct, options);
 		}
 
		
		return editorPickProduct;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EditorPickProduct saveParentCategory(EditorPickProduct editorPickProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(editorPickProduct.getParentCategory() == null){
 			return editorPickProduct;//do nothing when it is null
 		}
 		
 		getLevelNCategoryDAO().save(editorPickProduct.getParentCategory(),options);
 		return editorPickProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EditorPickProduct saveBrand(EditorPickProduct editorPickProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(editorPickProduct.getBrand() == null){
 			return editorPickProduct;//do nothing when it is null
 		}
 		
 		getBrandDAO().save(editorPickProduct.getBrand(),options);
 		return editorPickProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EditorPickProduct saveCatalog(EditorPickProduct editorPickProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(editorPickProduct.getCatalog() == null){
 			return editorPickProduct;//do nothing when it is null
 		}
 		
 		getCatalogDAO().save(editorPickProduct.getCatalog(),options);
 		return editorPickProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EditorPickProduct saveProfile(EditorPickProduct editorPickProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(editorPickProduct.getProfile() == null){
 			return editorPickProduct;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(editorPickProduct.getProfile(),options);
 		return editorPickProduct;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EditorPickProduct savePlatform(EditorPickProduct editorPickProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(editorPickProduct.getPlatform() == null){
 			return editorPickProduct;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(editorPickProduct.getPlatform(),options);
 		return editorPickProduct;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public EditorPickProduct present(EditorPickProduct editorPickProduct,Map<String, Object> options){
	

		return editorPickProduct;
	
	}
		

	

	protected String getTableName(){
		return EditorPickProductTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<EditorPickProduct> editorPickProductList) {		
		this.enhanceListInternal(editorPickProductList, this.getEditorPickProductMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EditorPickProduct> editorPickProductList = ownerEntity.collectRefsWithType(EditorPickProduct.INTERNAL_TYPE);
		this.enhanceList(editorPickProductList);
		
	}
	
	@Override
	public SmartList<EditorPickProduct> findEditorPickProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getEditorPickProductMapper());

	}
	@Override
	public int countEditorPickProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countEditorPickProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<EditorPickProduct> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEditorPickProductMapper());
	}
}


