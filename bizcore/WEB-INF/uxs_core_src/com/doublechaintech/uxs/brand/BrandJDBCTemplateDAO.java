
package com.doublechaintech.uxs.brand;

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


import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;

import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class BrandJDBCTemplateDAO extends UxsNamingServiceDAO implements BrandDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
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
	protected Brand load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalBrand(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Brand load(String id,Map<String,Object> options) throws Exception{
		return loadInternalBrand(BrandTable.withId(id), options);
	}
	
	
	
	public Brand save(Brand brand,Map<String,Object> options){
		
		String methodName="save(Brand brand,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(brand, methodName, "brand");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalBrand(brand,options);
	}
	public Brand clone(String brandId, Map<String,Object> options) throws Exception{
	
		return clone(BrandTable.withId(brandId),options);
	}
	
	protected Brand clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String brandId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Brand newBrand = loadInternalBrand(accessKey, options);
		newBrand.setVersion(0);
		
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newBrand.getProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveNewProductListEnabled(options)){
 			for(NewProduct item: newBrand.getNewProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEditorPickProductListEnabled(options)){
 			for(EditorPickProduct item: newBrand.getEditorPickProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTopRatedProductListEnabled(options)){
 			for(TopRatedProduct item: newBrand.getTopRatedProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRecommandProductListEnabled(options)){
 			for(RecommandProduct item: newBrand.getRecommandProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalBrand(newBrand,options);
		
		return newBrand;
	}
	
	
	
	

	protected void throwIfHasException(String brandId,int version,int count) throws Exception{
		if (count == 1) {
			throw new BrandVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new BrandNotFoundException(
					"The " + this.getTableName() + "(" + brandId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String brandId, int version) throws Exception{
	
		String methodName="delete(String brandId, int version)";
		assertMethodArgumentNotNull(brandId, methodName, "brandId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{brandId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(brandId,version);
		}
		
	
	}
	
	
	
	
	

	public Brand disconnectFromAll(String brandId, int version) throws Exception{
	
		
		Brand brand = loadInternalBrand(BrandTable.withId(brandId), emptyOptions());
		brand.clearFromAll();
		this.saveBrand(brand);
		return brand;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return BrandTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "brand";
	}
	@Override
	protected String getBeanName() {
		
		return "brand";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return BrandTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, BrandTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, BrandTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,BrandTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,BrandTokens.PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, BrandTokens.PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractNewProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,BrandTokens.NEW_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeNewProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,BrandTokens.NEW_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveNewProductListEnabled(Map<String,Object> options){
		return checkOptions(options, BrandTokens.NEW_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractEditorPickProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,BrandTokens.EDITOR_PICK_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeEditorPickProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,BrandTokens.EDITOR_PICK_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveEditorPickProductListEnabled(Map<String,Object> options){
		return checkOptions(options, BrandTokens.EDITOR_PICK_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTopRatedProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,BrandTokens.TOP_RATED_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeTopRatedProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,BrandTokens.TOP_RATED_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveTopRatedProductListEnabled(Map<String,Object> options){
		return checkOptions(options, BrandTokens.TOP_RATED_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRecommandProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,BrandTokens.RECOMMAND_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeRecommandProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,BrandTokens.RECOMMAND_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveRecommandProductListEnabled(Map<String,Object> options){
		return checkOptions(options, BrandTokens.RECOMMAND_PRODUCT_LIST);
		
 	}
 	
		

	

	protected BrandMapper getBrandMapper(){
		return new BrandMapper();
	}

	
	
	protected Brand extractBrand(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Brand brand = loadSingleObject(accessKey, getBrandMapper());
			return brand;
		}catch(EmptyResultDataAccessException e){
			throw new BrandNotFoundException("Brand("+accessKey+") is not found!");
		}

	}

	
	

	protected Brand loadInternalBrand(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Brand brand = extractBrand(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(brand, loadOptions);
 		}
 
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(brand, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		analyzeProductList(brand, loadOptions);
 		}
 		
		
		if(isExtractNewProductListEnabled(loadOptions)){
	 		extractNewProductList(brand, loadOptions);
 		}	
 		if(isAnalyzeNewProductListEnabled(loadOptions)){
	 		analyzeNewProductList(brand, loadOptions);
 		}
 		
		
		if(isExtractEditorPickProductListEnabled(loadOptions)){
	 		extractEditorPickProductList(brand, loadOptions);
 		}	
 		if(isAnalyzeEditorPickProductListEnabled(loadOptions)){
	 		analyzeEditorPickProductList(brand, loadOptions);
 		}
 		
		
		if(isExtractTopRatedProductListEnabled(loadOptions)){
	 		extractTopRatedProductList(brand, loadOptions);
 		}	
 		if(isAnalyzeTopRatedProductListEnabled(loadOptions)){
	 		analyzeTopRatedProductList(brand, loadOptions);
 		}
 		
		
		if(isExtractRecommandProductListEnabled(loadOptions)){
	 		extractRecommandProductList(brand, loadOptions);
 		}	
 		if(isAnalyzeRecommandProductListEnabled(loadOptions)){
	 		analyzeRecommandProductList(brand, loadOptions);
 		}
 		
		
		return brand;
		
	}

	 

 	protected Brand extractPlatform(Brand brand, Map<String,Object> options) throws Exception{

		if(brand.getPlatform() == null){
			return brand;
		}
		String platformId = brand.getPlatform().getId();
		if( platformId == null){
			return brand;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			brand.setPlatform(platform);
		}
		
 		
 		return brand;
 	}
 		
 
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Brand extractProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByBrand(brand.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			brand.setProductList(productList);
		}
		
		return brand;
	
	}	
	
	protected Brand analyzeProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<Product> productList = brand.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByBrand(productList, brand.getId(), options);
			
		}
		
		return brand;
	
	}	
	
		
	protected void enhanceNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Brand extractNewProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<NewProduct> newProductList = getNewProductDAO().findNewProductByBrand(brand.getId(),options);
		if(newProductList != null){
			enhanceNewProductList(newProductList,options);
			brand.setNewProductList(newProductList);
		}
		
		return brand;
	
	}	
	
	protected Brand analyzeNewProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<NewProduct> newProductList = brand.getNewProductList();
		if(newProductList != null){
			getNewProductDAO().analyzeNewProductByBrand(newProductList, brand.getId(), options);
			
		}
		
		return brand;
	
	}	
	
		
	protected void enhanceEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Brand extractEditorPickProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = getEditorPickProductDAO().findEditorPickProductByBrand(brand.getId(),options);
		if(editorPickProductList != null){
			enhanceEditorPickProductList(editorPickProductList,options);
			brand.setEditorPickProductList(editorPickProductList);
		}
		
		return brand;
	
	}	
	
	protected Brand analyzeEditorPickProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();
		if(editorPickProductList != null){
			getEditorPickProductDAO().analyzeEditorPickProductByBrand(editorPickProductList, brand.getId(), options);
			
		}
		
		return brand;
	
	}	
	
		
	protected void enhanceTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Brand extractTopRatedProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = getTopRatedProductDAO().findTopRatedProductByBrand(brand.getId(),options);
		if(topRatedProductList != null){
			enhanceTopRatedProductList(topRatedProductList,options);
			brand.setTopRatedProductList(topRatedProductList);
		}
		
		return brand;
	
	}	
	
	protected Brand analyzeTopRatedProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();
		if(topRatedProductList != null){
			getTopRatedProductDAO().analyzeTopRatedProductByBrand(topRatedProductList, brand.getId(), options);
			
		}
		
		return brand;
	
	}	
	
		
	protected void enhanceRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Brand extractRecommandProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = getRecommandProductDAO().findRecommandProductByBrand(brand.getId(),options);
		if(recommandProductList != null){
			enhanceRecommandProductList(recommandProductList,options);
			brand.setRecommandProductList(recommandProductList);
		}
		
		return brand;
	
	}	
	
	protected Brand analyzeRecommandProductList(Brand brand, Map<String,Object> options){
		
		
		if(brand == null){
			return null;
		}
		if(brand.getId() == null){
			return brand;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();
		if(recommandProductList != null){
			getRecommandProductDAO().analyzeRecommandProductByBrand(recommandProductList, brand.getId(), options);
			
		}
		
		return brand;
	
	}	
	
		
		
  	
 	public SmartList<Brand> findBrandByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Brand> resultList = queryWith(BrandTable.COLUMN_PLATFORM, platformId, options, getBrandMapper());
		// analyzeBrandByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Brand> findBrandByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Brand> resultList =  queryWithRange(BrandTable.COLUMN_PLATFORM, platformId, options, getBrandMapper(), start, count);
 		//analyzeBrandByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeBrandByPlatform(SmartList<Brand> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countBrandByPlatform(String platformId,Map<String,Object> options){

 		return countWith(BrandTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countBrandByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(BrandTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Brand saveBrand(Brand  brand){
		
		if(!brand.isChanged()){
			return brand;
		}
		
		
		String SQL=this.getSaveBrandSQL(brand);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveBrandParameters(brand);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		brand.incVersion();
		return brand;
	
	}
	public SmartList<Brand> saveBrandList(SmartList<Brand> brandList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitBrandList(brandList);
		
		batchBrandCreate((List<Brand>)lists[CREATE_LIST_INDEX]);
		
		batchBrandUpdate((List<Brand>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Brand brand:brandList){
			if(brand.isChanged()){
				brand.incVersion();
			}
			
		
		}
		
		
		return brandList;
	}

	public SmartList<Brand> removeBrandList(SmartList<Brand> brandList,Map<String,Object> options){
		
		
		super.removeList(brandList, options);
		
		return brandList;
		
		
	}
	
	protected List<Object[]> prepareBrandBatchCreateArgs(List<Brand> brandList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Brand brand:brandList ){
			Object [] parameters = prepareBrandCreateParameters(brand);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBrandBatchUpdateArgs(List<Brand> brandList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Brand brand:brandList ){
			if(!brand.isChanged()){
				continue;
			}
			Object [] parameters = prepareBrandUpdateParameters(brand);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchBrandCreate(List<Brand> brandList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBrandBatchCreateArgs(brandList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchBrandUpdate(List<Brand> brandList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBrandBatchUpdateArgs(brandList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitBrandList(List<Brand> brandList){
		
		List<Brand> brandCreateList=new ArrayList<Brand>();
		List<Brand> brandUpdateList=new ArrayList<Brand>();
		
		for(Brand brand: brandList){
			if(isUpdateRequest(brand)){
				brandUpdateList.add( brand);
				continue;
			}
			brandCreateList.add(brand);
		}
		
		return new Object[]{brandCreateList,brandUpdateList};
	}
	
	protected boolean isUpdateRequest(Brand brand){
 		return brand.getVersion() > 0;
 	}
 	protected String getSaveBrandSQL(Brand brand){
 		if(isUpdateRequest(brand)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveBrandParameters(Brand brand){
 		if(isUpdateRequest(brand) ){
 			return prepareBrandUpdateParameters(brand);
 		}
 		return prepareBrandCreateParameters(brand);
 	}
 	protected Object[] prepareBrandUpdateParameters(Brand brand){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = brand.getBrandName();
 		parameters[1] = brand.getLogo();
 		parameters[2] = brand.getRemark(); 	
 		if(brand.getPlatform() != null){
 			parameters[3] = brand.getPlatform().getId();
 		}
 		
 		parameters[4] = brand.nextVersion();
 		parameters[5] = brand.getId();
 		parameters[6] = brand.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareBrandCreateParameters(Brand brand){
		Object[] parameters = new Object[5];
		String newBrandId=getNextId();
		brand.setId(newBrandId);
		parameters[0] =  brand.getId();
 
 		parameters[1] = brand.getBrandName();
 		parameters[2] = brand.getLogo();
 		parameters[3] = brand.getRemark(); 	
 		if(brand.getPlatform() != null){
 			parameters[4] = brand.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Brand saveInternalBrand(Brand brand, Map<String,Object> options){
		
		saveBrand(brand);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(brand, options);
 		}
 
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(brand, options);
	 		//removeProductList(brand, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveNewProductListEnabled(options)){
	 		saveNewProductList(brand, options);
	 		//removeNewProductList(brand, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveEditorPickProductListEnabled(options)){
	 		saveEditorPickProductList(brand, options);
	 		//removeEditorPickProductList(brand, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTopRatedProductListEnabled(options)){
	 		saveTopRatedProductList(brand, options);
	 		//removeTopRatedProductList(brand, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRecommandProductListEnabled(options)){
	 		saveRecommandProductList(brand, options);
	 		//removeRecommandProductList(brand, options);
	 		//Not delete the record
	 		
 		}		
		
		return brand;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Brand savePlatform(Brand brand, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(brand.getPlatform() == null){
 			return brand;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(brand.getPlatform(),options);
 		return brand;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Brand planToRemoveProductList(Brand brand, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brand.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return brand;
		}
		if(externalProductList.isEmpty()){
			return brand;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = brand.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return brand;	
	
	}


	//disconnect Brand with parent_category in Product
	public Brand planToRemoveProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brand.getId());
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return brand;
		}
		if(externalProductList.isEmpty()){
			return brand;
		}
		
		for(Product product: externalProductList){
			product.clearParentCategory();
			product.clearBrand();
			
		}
		
		
		SmartList<Product> productList = brand.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return brand;
	}
	
	public int countProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brandId);
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with catalog in Product
	public Brand planToRemoveProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brand.getId());
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return brand;
		}
		if(externalProductList.isEmpty()){
			return brand;
		}
		
		for(Product product: externalProductList){
			product.clearCatalog();
			product.clearBrand();
			
		}
		
		
		SmartList<Product> productList = brand.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return brand;
	}
	
	public int countProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brandId);
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with platform in Product
	public Brand planToRemoveProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brand.getId());
		key.put(Product.PLATFORM_PROPERTY, platformId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return brand;
		}
		if(externalProductList.isEmpty()){
			return brand;
		}
		
		for(Product product: externalProductList){
			product.clearPlatform();
			product.clearBrand();
			
		}
		
		
		SmartList<Product> productList = brand.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return brand;
	}
	
	public int countProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.BRAND_PROPERTY, brandId);
		key.put(Product.PLATFORM_PROPERTY, platformId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	public Brand planToRemoveNewProductList(Brand brand, String newProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brand.getId());
		key.put(NewProduct.ID_PROPERTY, newProductIds);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return brand;
		}
		if(externalNewProductList.isEmpty()){
			return brand;
		}
		
		for(NewProduct newProduct: externalNewProductList){

			newProduct.clearFromAll();
		}
		
		
		SmartList<NewProduct> newProductList = brand.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return brand;	
	
	}


	//disconnect Brand with parent_category in NewProduct
	public Brand planToRemoveNewProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brand.getId());
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return brand;
		}
		if(externalNewProductList.isEmpty()){
			return brand;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearParentCategory();
			newProduct.clearBrand();
			
		}
		
		
		SmartList<NewProduct> newProductList = brand.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return brand;
	}
	
	public int countNewProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with catalog in NewProduct
	public Brand planToRemoveNewProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brand.getId());
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return brand;
		}
		if(externalNewProductList.isEmpty()){
			return brand;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearCatalog();
			newProduct.clearBrand();
			
		}
		
		
		SmartList<NewProduct> newProductList = brand.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return brand;
	}
	
	public int countNewProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with profile in NewProduct
	public Brand planToRemoveNewProductListWithProfile(Brand brand, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brand.getId());
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return brand;
		}
		if(externalNewProductList.isEmpty()){
			return brand;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearProfile();
			newProduct.clearBrand();
			
		}
		
		
		SmartList<NewProduct> newProductList = brand.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return brand;
	}
	
	public int countNewProductListWithProfile(String brandId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with platform in NewProduct
	public Brand planToRemoveNewProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brand.getId());
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return brand;
		}
		if(externalNewProductList.isEmpty()){
			return brand;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearPlatform();
			newProduct.clearBrand();
			
		}
		
		
		SmartList<NewProduct> newProductList = brand.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return brand;
	}
	
	public int countNewProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	public Brand planToRemoveEditorPickProductList(Brand brand, String editorPickProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brand.getId());
		key.put(EditorPickProduct.ID_PROPERTY, editorPickProductIds);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return brand;
		}
		if(externalEditorPickProductList.isEmpty()){
			return brand;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){

			editorPickProduct.clearFromAll();
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return brand;	
	
	}


	//disconnect Brand with parent_category in EditorPickProduct
	public Brand planToRemoveEditorPickProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brand.getId());
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return brand;
		}
		if(externalEditorPickProductList.isEmpty()){
			return brand;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearParentCategory();
			editorPickProduct.clearBrand();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return brand;
	}
	
	public int countEditorPickProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with catalog in EditorPickProduct
	public Brand planToRemoveEditorPickProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brand.getId());
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return brand;
		}
		if(externalEditorPickProductList.isEmpty()){
			return brand;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearCatalog();
			editorPickProduct.clearBrand();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return brand;
	}
	
	public int countEditorPickProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with profile in EditorPickProduct
	public Brand planToRemoveEditorPickProductListWithProfile(Brand brand, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brand.getId());
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return brand;
		}
		if(externalEditorPickProductList.isEmpty()){
			return brand;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearProfile();
			editorPickProduct.clearBrand();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return brand;
	}
	
	public int countEditorPickProductListWithProfile(String brandId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with platform in EditorPickProduct
	public Brand planToRemoveEditorPickProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brand.getId());
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return brand;
		}
		if(externalEditorPickProductList.isEmpty()){
			return brand;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearPlatform();
			editorPickProduct.clearBrand();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return brand;
	}
	
	public int countEditorPickProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	public Brand planToRemoveTopRatedProductList(Brand brand, String topRatedProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brand.getId());
		key.put(TopRatedProduct.ID_PROPERTY, topRatedProductIds);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return brand;
		}
		if(externalTopRatedProductList.isEmpty()){
			return brand;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){

			topRatedProduct.clearFromAll();
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return brand;	
	
	}


	//disconnect Brand with parent_category in TopRatedProduct
	public Brand planToRemoveTopRatedProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brand.getId());
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return brand;
		}
		if(externalTopRatedProductList.isEmpty()){
			return brand;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearParentCategory();
			topRatedProduct.clearBrand();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return brand;
	}
	
	public int countTopRatedProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with catalog in TopRatedProduct
	public Brand planToRemoveTopRatedProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brand.getId());
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return brand;
		}
		if(externalTopRatedProductList.isEmpty()){
			return brand;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearCatalog();
			topRatedProduct.clearBrand();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return brand;
	}
	
	public int countTopRatedProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with profile in TopRatedProduct
	public Brand planToRemoveTopRatedProductListWithProfile(Brand brand, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brand.getId());
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return brand;
		}
		if(externalTopRatedProductList.isEmpty()){
			return brand;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearProfile();
			topRatedProduct.clearBrand();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return brand;
	}
	
	public int countTopRatedProductListWithProfile(String brandId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with platform in TopRatedProduct
	public Brand planToRemoveTopRatedProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brand.getId());
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return brand;
		}
		if(externalTopRatedProductList.isEmpty()){
			return brand;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearPlatform();
			topRatedProduct.clearBrand();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return brand;
	}
	
	public int countTopRatedProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	public Brand planToRemoveRecommandProductList(Brand brand, String recommandProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brand.getId());
		key.put(RecommandProduct.ID_PROPERTY, recommandProductIds);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return brand;
		}
		if(externalRecommandProductList.isEmpty()){
			return brand;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){

			recommandProduct.clearFromAll();
		}
		
		
		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return brand;	
	
	}


	//disconnect Brand with parent_category in RecommandProduct
	public Brand planToRemoveRecommandProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brand.getId());
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return brand;
		}
		if(externalRecommandProductList.isEmpty()){
			return brand;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearParentCategory();
			recommandProduct.clearBrand();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return brand;
	}
	
	public int countRecommandProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with catalog in RecommandProduct
	public Brand planToRemoveRecommandProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brand.getId());
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return brand;
		}
		if(externalRecommandProductList.isEmpty()){
			return brand;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearCatalog();
			recommandProduct.clearBrand();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return brand;
	}
	
	public int countRecommandProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with profile in RecommandProduct
	public Brand planToRemoveRecommandProductListWithProfile(Brand brand, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brand.getId());
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return brand;
		}
		if(externalRecommandProductList.isEmpty()){
			return brand;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearProfile();
			recommandProduct.clearBrand();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return brand;
	}
	
	public int countRecommandProductListWithProfile(String brandId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect Brand with platform in RecommandProduct
	public Brand planToRemoveRecommandProductListWithPlatform(Brand brand, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brand.getId());
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return brand;
		}
		if(externalRecommandProductList.isEmpty()){
			return brand;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearPlatform();
			recommandProduct.clearBrand();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return brand;
	}
	
	public int countRecommandProductListWithPlatform(String brandId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	

		
	protected Brand saveProductList(Brand brand, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = brand.getProductList();
		if(productList == null){
			//null list means nothing
			return brand;
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
		
		
		return brand;
	
	}
	
	protected Brand removeProductList(Brand brand, Map<String,Object> options){
	
	
		SmartList<Product> productList = brand.getProductList();
		if(productList == null){
			return brand;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return brand;
		}
		if(toRemoveProductList.isEmpty()){
			return brand;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return brand;
	
	}
	
	

 	
 	
	
	
	
		
	protected Brand saveNewProductList(Brand brand, Map<String,Object> options){
		
		
		
		
		SmartList<NewProduct> newProductList = brand.getNewProductList();
		if(newProductList == null){
			//null list means nothing
			return brand;
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
		
		
		return brand;
	
	}
	
	protected Brand removeNewProductList(Brand brand, Map<String,Object> options){
	
	
		SmartList<NewProduct> newProductList = brand.getNewProductList();
		if(newProductList == null){
			return brand;
		}	
	
		SmartList<NewProduct> toRemoveNewProductList = newProductList.getToRemoveList();
		
		if(toRemoveNewProductList == null){
			return brand;
		}
		if(toRemoveNewProductList.isEmpty()){
			return brand;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNewProductDAO().removeNewProductList(toRemoveNewProductList,options);
		
		return brand;
	
	}
	
	

 	
 	
	
	
	
		
	protected Brand saveEditorPickProductList(Brand brand, Map<String,Object> options){
		
		
		
		
		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();
		if(editorPickProductList == null){
			//null list means nothing
			return brand;
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
		
		
		return brand;
	
	}
	
	protected Brand removeEditorPickProductList(Brand brand, Map<String,Object> options){
	
	
		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();
		if(editorPickProductList == null){
			return brand;
		}	
	
		SmartList<EditorPickProduct> toRemoveEditorPickProductList = editorPickProductList.getToRemoveList();
		
		if(toRemoveEditorPickProductList == null){
			return brand;
		}
		if(toRemoveEditorPickProductList.isEmpty()){
			return brand;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEditorPickProductDAO().removeEditorPickProductList(toRemoveEditorPickProductList,options);
		
		return brand;
	
	}
	
	

 	
 	
	
	
	
		
	protected Brand saveTopRatedProductList(Brand brand, Map<String,Object> options){
		
		
		
		
		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();
		if(topRatedProductList == null){
			//null list means nothing
			return brand;
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
		
		
		return brand;
	
	}
	
	protected Brand removeTopRatedProductList(Brand brand, Map<String,Object> options){
	
	
		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();
		if(topRatedProductList == null){
			return brand;
		}	
	
		SmartList<TopRatedProduct> toRemoveTopRatedProductList = topRatedProductList.getToRemoveList();
		
		if(toRemoveTopRatedProductList == null){
			return brand;
		}
		if(toRemoveTopRatedProductList.isEmpty()){
			return brand;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTopRatedProductDAO().removeTopRatedProductList(toRemoveTopRatedProductList,options);
		
		return brand;
	
	}
	
	

 	
 	
	
	
	
		
	protected Brand saveRecommandProductList(Brand brand, Map<String,Object> options){
		
		
		
		
		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();
		if(recommandProductList == null){
			//null list means nothing
			return brand;
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
		
		
		return brand;
	
	}
	
	protected Brand removeRecommandProductList(Brand brand, Map<String,Object> options){
	
	
		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();
		if(recommandProductList == null){
			return brand;
		}	
	
		SmartList<RecommandProduct> toRemoveRecommandProductList = recommandProductList.getToRemoveList();
		
		if(toRemoveRecommandProductList == null){
			return brand;
		}
		if(toRemoveRecommandProductList.isEmpty()){
			return brand;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRecommandProductDAO().removeRecommandProductList(toRemoveRecommandProductList,options);
		
		return brand;
	
	}
	
	

 	
 	
	
	
	
		

	public Brand present(Brand brand,Map<String, Object> options){
	
		presentProductList(brand,options);
		presentNewProductList(brand,options);
		presentEditorPickProductList(brand,options);
		presentTopRatedProductList(brand,options);
		presentRecommandProductList(brand,options);

		return brand;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Brand presentProductList(
			Brand brand,
			Map<String, Object> options) {

		SmartList<Product> productList = brand.getProductList();		
				SmartList<Product> newList= presentSubList(brand.getId(),
				productList,
				options,
				getProductDAO()::countProductByBrand,
				getProductDAO()::findProductByBrand
				);

		
		brand.setProductList(newList);
		

		return brand;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Brand presentNewProductList(
			Brand brand,
			Map<String, Object> options) {

		SmartList<NewProduct> newProductList = brand.getNewProductList();		
				SmartList<NewProduct> newList= presentSubList(brand.getId(),
				newProductList,
				options,
				getNewProductDAO()::countNewProductByBrand,
				getNewProductDAO()::findNewProductByBrand
				);

		
		brand.setNewProductList(newList);
		

		return brand;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Brand presentEditorPickProductList(
			Brand brand,
			Map<String, Object> options) {

		SmartList<EditorPickProduct> editorPickProductList = brand.getEditorPickProductList();		
				SmartList<EditorPickProduct> newList= presentSubList(brand.getId(),
				editorPickProductList,
				options,
				getEditorPickProductDAO()::countEditorPickProductByBrand,
				getEditorPickProductDAO()::findEditorPickProductByBrand
				);

		
		brand.setEditorPickProductList(newList);
		

		return brand;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Brand presentTopRatedProductList(
			Brand brand,
			Map<String, Object> options) {

		SmartList<TopRatedProduct> topRatedProductList = brand.getTopRatedProductList();		
				SmartList<TopRatedProduct> newList= presentSubList(brand.getId(),
				topRatedProductList,
				options,
				getTopRatedProductDAO()::countTopRatedProductByBrand,
				getTopRatedProductDAO()::findTopRatedProductByBrand
				);

		
		brand.setTopRatedProductList(newList);
		

		return brand;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Brand presentRecommandProductList(
			Brand brand,
			Map<String, Object> options) {

		SmartList<RecommandProduct> recommandProductList = brand.getRecommandProductList();		
				SmartList<RecommandProduct> newList= presentSubList(brand.getId(),
				recommandProductList,
				options,
				getRecommandProductDAO()::countRecommandProductByBrand,
				getRecommandProductDAO()::findRecommandProductByBrand
				);

		
		brand.setRecommandProductList(newList);
		

		return brand;
	}			
		

	
    public SmartList<Brand> requestCandidateBrandForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(BrandTable.COLUMN_BRAND_NAME, filterKey, pageNo, pageSize, getBrandMapper());
    }
		
    public SmartList<Brand> requestCandidateBrandForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(BrandTable.COLUMN_BRAND_NAME, filterKey, pageNo, pageSize, getBrandMapper());
    }
		
    public SmartList<Brand> requestCandidateBrandForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(BrandTable.COLUMN_BRAND_NAME, filterKey, pageNo, pageSize, getBrandMapper());
    }
		
    public SmartList<Brand> requestCandidateBrandForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(BrandTable.COLUMN_BRAND_NAME, filterKey, pageNo, pageSize, getBrandMapper());
    }
		
    public SmartList<Brand> requestCandidateBrandForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(BrandTable.COLUMN_BRAND_NAME, filterKey, pageNo, pageSize, getBrandMapper());
    }
		

	protected String getTableName(){
		return BrandTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Brand> brandList) {		
		this.enhanceListInternal(brandList, this.getBrandMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Brand> brandList = ownerEntity.collectRefsWithType(Brand.INTERNAL_TYPE);
		this.enhanceList(brandList);
		
	}
	
	@Override
	public SmartList<Brand> findBrandWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getBrandMapper());

	}
	@Override
	public int countBrandWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countBrandWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Brand> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getBrandMapper());
	}
}


