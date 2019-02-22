
package com.doublechaintech.uxs.levelncategory;

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


import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;

import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.newproduct.NewProductDAO;
import com.doublechaintech.uxs.topratedproduct.TopRatedProductDAO;
import com.doublechaintech.uxs.recommandproduct.RecommandProductDAO;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategoryDAO;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProductDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class LevelNCategoryJDBCTemplateDAO extends UxsNamingServiceDAO implements LevelNCategoryDAO{
 
 	
 	private  LevelTwoCategoryDAO  levelTwoCategoryDAO;
 	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO levelTwoCategoryDAO){
	 	this.levelTwoCategoryDAO = levelTwoCategoryDAO;
 	}
 	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
	 	return this.levelTwoCategoryDAO;
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
	protected LevelNCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelNCategory(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LevelNCategory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelNCategory(LevelNCategoryTable.withId(id), options);
	}
	
	
	
	public LevelNCategory save(LevelNCategory levelNCategory,Map<String,Object> options){
		
		String methodName="save(LevelNCategory levelNCategory,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelNCategory, methodName, "levelNCategory");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelNCategory(levelNCategory,options);
	}
	public LevelNCategory clone(String levelNCategoryId, Map<String,Object> options) throws Exception{
	
		return clone(LevelNCategoryTable.withId(levelNCategoryId),options);
	}
	
	protected LevelNCategory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelNCategoryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelNCategory newLevelNCategory = loadInternalLevelNCategory(accessKey, options);
		newLevelNCategory.setVersion(0);
		
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newLevelNCategory.getProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveNewProductListEnabled(options)){
 			for(NewProduct item: newLevelNCategory.getNewProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEditorPickProductListEnabled(options)){
 			for(EditorPickProduct item: newLevelNCategory.getEditorPickProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTopRatedProductListEnabled(options)){
 			for(TopRatedProduct item: newLevelNCategory.getTopRatedProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRecommandProductListEnabled(options)){
 			for(RecommandProduct item: newLevelNCategory.getRecommandProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelNCategory(newLevelNCategory,options);
		
		return newLevelNCategory;
	}
	
	
	
	

	protected void throwIfHasException(String levelNCategoryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LevelNCategoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelNCategoryNotFoundException(
					"The " + this.getTableName() + "(" + levelNCategoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String levelNCategoryId, int version) throws Exception{
	
		String methodName="delete(String levelNCategoryId, int version)";
		assertMethodArgumentNotNull(levelNCategoryId, methodName, "levelNCategoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelNCategoryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelNCategoryId,version);
		}
		
	
	}
	
	
	
	
	

	public LevelNCategory disconnectFromAll(String levelNCategoryId, int version) throws Exception{
	
		
		LevelNCategory levelNCategory = loadInternalLevelNCategory(LevelNCategoryTable.withId(levelNCategoryId), emptyOptions());
		levelNCategory.clearFromAll();
		this.saveLevelNCategory(levelNCategory);
		return levelNCategory;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LevelNCategoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_n_category";
	}
	@Override
	protected String getBeanName() {
		
		return "levelNCategory";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelNCategoryTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelNCategoryTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelNCategoryTokens.PARENTCATEGORY);
 	}
 	

 	
 
		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelNCategoryTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,LevelNCategoryTokens.PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelNCategoryTokens.PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractNewProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelNCategoryTokens.NEW_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeNewProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,LevelNCategoryTokens.NEW_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveNewProductListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelNCategoryTokens.NEW_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractEditorPickProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelNCategoryTokens.EDITOR_PICK_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeEditorPickProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,LevelNCategoryTokens.EDITOR_PICK_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveEditorPickProductListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelNCategoryTokens.EDITOR_PICK_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTopRatedProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelNCategoryTokens.TOP_RATED_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeTopRatedProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,LevelNCategoryTokens.TOP_RATED_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveTopRatedProductListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelNCategoryTokens.TOP_RATED_PRODUCT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRecommandProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelNCategoryTokens.RECOMMAND_PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeRecommandProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,LevelNCategoryTokens.RECOMMAND_PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveRecommandProductListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelNCategoryTokens.RECOMMAND_PRODUCT_LIST);
		
 	}
 	
		

	

	protected LevelNCategoryMapper getLevelNCategoryMapper(){
		return new LevelNCategoryMapper();
	}

	
	
	protected LevelNCategory extractLevelNCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LevelNCategory levelNCategory = loadSingleObject(accessKey, getLevelNCategoryMapper());
			return levelNCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelNCategoryNotFoundException("LevelNCategory("+accessKey+") is not found!");
		}

	}

	
	

	protected LevelNCategory loadInternalLevelNCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelNCategory levelNCategory = extractLevelNCategory(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(levelNCategory, loadOptions);
 		}
 
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(levelNCategory, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		analyzeProductList(levelNCategory, loadOptions);
 		}
 		
		
		if(isExtractNewProductListEnabled(loadOptions)){
	 		extractNewProductList(levelNCategory, loadOptions);
 		}	
 		if(isAnalyzeNewProductListEnabled(loadOptions)){
	 		analyzeNewProductList(levelNCategory, loadOptions);
 		}
 		
		
		if(isExtractEditorPickProductListEnabled(loadOptions)){
	 		extractEditorPickProductList(levelNCategory, loadOptions);
 		}	
 		if(isAnalyzeEditorPickProductListEnabled(loadOptions)){
	 		analyzeEditorPickProductList(levelNCategory, loadOptions);
 		}
 		
		
		if(isExtractTopRatedProductListEnabled(loadOptions)){
	 		extractTopRatedProductList(levelNCategory, loadOptions);
 		}	
 		if(isAnalyzeTopRatedProductListEnabled(loadOptions)){
	 		analyzeTopRatedProductList(levelNCategory, loadOptions);
 		}
 		
		
		if(isExtractRecommandProductListEnabled(loadOptions)){
	 		extractRecommandProductList(levelNCategory, loadOptions);
 		}	
 		if(isAnalyzeRecommandProductListEnabled(loadOptions)){
	 		analyzeRecommandProductList(levelNCategory, loadOptions);
 		}
 		
		
		return levelNCategory;
		
	}

	 

 	protected LevelNCategory extractParentCategory(LevelNCategory levelNCategory, Map<String,Object> options) throws Exception{

		if(levelNCategory.getParentCategory() == null){
			return levelNCategory;
		}
		String parentCategoryId = levelNCategory.getParentCategory().getId();
		if( parentCategoryId == null){
			return levelNCategory;
		}
		LevelTwoCategory parentCategory = getLevelTwoCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			levelNCategory.setParentCategory(parentCategory);
		}
		
 		
 		return levelNCategory;
 	}
 		
 
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelNCategory extractProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByParentCategory(levelNCategory.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			levelNCategory.setProductList(productList);
		}
		
		return levelNCategory;
	
	}	
	
	protected LevelNCategory analyzeProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<Product> productList = levelNCategory.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByParentCategory(productList, levelNCategory.getId(), options);
			
		}
		
		return levelNCategory;
	
	}	
	
		
	protected void enhanceNewProductList(SmartList<NewProduct> newProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelNCategory extractNewProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<NewProduct> newProductList = getNewProductDAO().findNewProductByParentCategory(levelNCategory.getId(),options);
		if(newProductList != null){
			enhanceNewProductList(newProductList,options);
			levelNCategory.setNewProductList(newProductList);
		}
		
		return levelNCategory;
	
	}	
	
	protected LevelNCategory analyzeNewProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();
		if(newProductList != null){
			getNewProductDAO().analyzeNewProductByParentCategory(newProductList, levelNCategory.getId(), options);
			
		}
		
		return levelNCategory;
	
	}	
	
		
	protected void enhanceEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelNCategory extractEditorPickProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = getEditorPickProductDAO().findEditorPickProductByParentCategory(levelNCategory.getId(),options);
		if(editorPickProductList != null){
			enhanceEditorPickProductList(editorPickProductList,options);
			levelNCategory.setEditorPickProductList(editorPickProductList);
		}
		
		return levelNCategory;
	
	}	
	
	protected LevelNCategory analyzeEditorPickProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();
		if(editorPickProductList != null){
			getEditorPickProductDAO().analyzeEditorPickProductByParentCategory(editorPickProductList, levelNCategory.getId(), options);
			
		}
		
		return levelNCategory;
	
	}	
	
		
	protected void enhanceTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelNCategory extractTopRatedProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = getTopRatedProductDAO().findTopRatedProductByParentCategory(levelNCategory.getId(),options);
		if(topRatedProductList != null){
			enhanceTopRatedProductList(topRatedProductList,options);
			levelNCategory.setTopRatedProductList(topRatedProductList);
		}
		
		return levelNCategory;
	
	}	
	
	protected LevelNCategory analyzeTopRatedProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();
		if(topRatedProductList != null){
			getTopRatedProductDAO().analyzeTopRatedProductByParentCategory(topRatedProductList, levelNCategory.getId(), options);
			
		}
		
		return levelNCategory;
	
	}	
	
		
	protected void enhanceRecommandProductList(SmartList<RecommandProduct> recommandProductList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelNCategory extractRecommandProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = getRecommandProductDAO().findRecommandProductByParentCategory(levelNCategory.getId(),options);
		if(recommandProductList != null){
			enhanceRecommandProductList(recommandProductList,options);
			levelNCategory.setRecommandProductList(recommandProductList);
		}
		
		return levelNCategory;
	
	}	
	
	protected LevelNCategory analyzeRecommandProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();
		if(recommandProductList != null){
			getRecommandProductDAO().analyzeRecommandProductByParentCategory(recommandProductList, levelNCategory.getId(), options);
			
		}
		
		return levelNCategory;
	
	}	
	
		
		
  	
 	public SmartList<LevelNCategory> findLevelNCategoryByParentCategory(String levelTwoCategoryId,Map<String,Object> options){
 	
  		SmartList<LevelNCategory> resultList = queryWith(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, levelTwoCategoryId, options, getLevelNCategoryMapper());
		// analyzeLevelNCategoryByParentCategory(resultList, levelTwoCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LevelNCategory> findLevelNCategoryByParentCategory(String levelTwoCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LevelNCategory> resultList =  queryWithRange(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, levelTwoCategoryId, options, getLevelNCategoryMapper(), start, count);
 		//analyzeLevelNCategoryByParentCategory(resultList, levelTwoCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeLevelNCategoryByParentCategory(SmartList<LevelNCategory> resultList, String levelTwoCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLevelNCategoryByParentCategory(String levelTwoCategoryId,Map<String,Object> options){

 		return countWith(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, levelTwoCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countLevelNCategoryByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
 	
		
		
		

	

	protected LevelNCategory saveLevelNCategory(LevelNCategory  levelNCategory){
		
		if(!levelNCategory.isChanged()){
			return levelNCategory;
		}
		
		
		String SQL=this.getSaveLevelNCategorySQL(levelNCategory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelNCategoryParameters(levelNCategory);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelNCategory.incVersion();
		return levelNCategory;
	
	}
	public SmartList<LevelNCategory> saveLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelNCategoryList(levelNCategoryList);
		
		batchLevelNCategoryCreate((List<LevelNCategory>)lists[CREATE_LIST_INDEX]);
		
		batchLevelNCategoryUpdate((List<LevelNCategory>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelNCategory levelNCategory:levelNCategoryList){
			if(levelNCategory.isChanged()){
				levelNCategory.incVersion();
			}
			
		
		}
		
		
		return levelNCategoryList;
	}

	public SmartList<LevelNCategory> removeLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options){
		
		
		super.removeList(levelNCategoryList, options);
		
		return levelNCategoryList;
		
		
	}
	
	protected List<Object[]> prepareLevelNCategoryBatchCreateArgs(List<LevelNCategory> levelNCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelNCategory levelNCategory:levelNCategoryList ){
			Object [] parameters = prepareLevelNCategoryCreateParameters(levelNCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelNCategoryBatchUpdateArgs(List<LevelNCategory> levelNCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelNCategory levelNCategory:levelNCategoryList ){
			if(!levelNCategory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelNCategoryUpdateParameters(levelNCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelNCategoryCreate(List<LevelNCategory> levelNCategoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelNCategoryBatchCreateArgs(levelNCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelNCategoryUpdate(List<LevelNCategory> levelNCategoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelNCategoryBatchUpdateArgs(levelNCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelNCategoryList(List<LevelNCategory> levelNCategoryList){
		
		List<LevelNCategory> levelNCategoryCreateList=new ArrayList<LevelNCategory>();
		List<LevelNCategory> levelNCategoryUpdateList=new ArrayList<LevelNCategory>();
		
		for(LevelNCategory levelNCategory: levelNCategoryList){
			if(isUpdateRequest(levelNCategory)){
				levelNCategoryUpdateList.add( levelNCategory);
				continue;
			}
			levelNCategoryCreateList.add(levelNCategory);
		}
		
		return new Object[]{levelNCategoryCreateList,levelNCategoryUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelNCategory levelNCategory){
 		return levelNCategory.getVersion() > 0;
 	}
 	protected String getSaveLevelNCategorySQL(LevelNCategory levelNCategory){
 		if(isUpdateRequest(levelNCategory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelNCategoryParameters(LevelNCategory levelNCategory){
 		if(isUpdateRequest(levelNCategory) ){
 			return prepareLevelNCategoryUpdateParameters(levelNCategory);
 		}
 		return prepareLevelNCategoryCreateParameters(levelNCategory);
 	}
 	protected Object[] prepareLevelNCategoryUpdateParameters(LevelNCategory levelNCategory){
 		Object[] parameters = new Object[5];
  	
 		if(levelNCategory.getParentCategory() != null){
 			parameters[0] = levelNCategory.getParentCategory().getId();
 		}
 
 		parameters[1] = levelNCategory.getName();		
 		parameters[2] = levelNCategory.nextVersion();
 		parameters[3] = levelNCategory.getId();
 		parameters[4] = levelNCategory.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelNCategoryCreateParameters(LevelNCategory levelNCategory){
		Object[] parameters = new Object[3];
		String newLevelNCategoryId=getNextId();
		levelNCategory.setId(newLevelNCategoryId);
		parameters[0] =  levelNCategory.getId();
  	
 		if(levelNCategory.getParentCategory() != null){
 			parameters[1] = levelNCategory.getParentCategory().getId();
 		
 		}
 		
 		parameters[2] = levelNCategory.getName();		
 				
 		return parameters;
 	}
 	
	protected LevelNCategory saveInternalLevelNCategory(LevelNCategory levelNCategory, Map<String,Object> options){
		
		saveLevelNCategory(levelNCategory);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(levelNCategory, options);
 		}
 
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(levelNCategory, options);
	 		//removeProductList(levelNCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveNewProductListEnabled(options)){
	 		saveNewProductList(levelNCategory, options);
	 		//removeNewProductList(levelNCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveEditorPickProductListEnabled(options)){
	 		saveEditorPickProductList(levelNCategory, options);
	 		//removeEditorPickProductList(levelNCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTopRatedProductListEnabled(options)){
	 		saveTopRatedProductList(levelNCategory, options);
	 		//removeTopRatedProductList(levelNCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRecommandProductListEnabled(options)){
	 		saveRecommandProductList(levelNCategory, options);
	 		//removeRecommandProductList(levelNCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		return levelNCategory;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelNCategory saveParentCategory(LevelNCategory levelNCategory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelNCategory.getParentCategory() == null){
 			return levelNCategory;//do nothing when it is null
 		}
 		
 		getLevelTwoCategoryDAO().save(levelNCategory.getParentCategory(),options);
 		return levelNCategory;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public LevelNCategory planToRemoveProductList(LevelNCategory levelNCategory, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return levelNCategory;
		}
		if(externalProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = levelNCategory.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return levelNCategory;	
	
	}


	//disconnect LevelNCategory with brand in Product
	public LevelNCategory planToRemoveProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(Product.BRAND_PROPERTY, brandId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return levelNCategory;
		}
		if(externalProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(Product product: externalProductList){
			product.clearBrand();
			product.clearParentCategory();
			
		}
		
		
		SmartList<Product> productList = levelNCategory.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return levelNCategory;
	}
	
	public int countProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(Product.BRAND_PROPERTY, brandId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with catalog in Product
	public LevelNCategory planToRemoveProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return levelNCategory;
		}
		if(externalProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(Product product: externalProductList){
			product.clearCatalog();
			product.clearParentCategory();
			
		}
		
		
		SmartList<Product> productList = levelNCategory.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return levelNCategory;
	}
	
	public int countProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with platform in Product
	public LevelNCategory planToRemoveProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(Product.PLATFORM_PROPERTY, platformId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return levelNCategory;
		}
		if(externalProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(Product product: externalProductList){
			product.clearPlatform();
			product.clearParentCategory();
			
		}
		
		
		SmartList<Product> productList = levelNCategory.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return levelNCategory;
	}
	
	public int countProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(Product.PLATFORM_PROPERTY, platformId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	public LevelNCategory planToRemoveNewProductList(LevelNCategory levelNCategory, String newProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(NewProduct.ID_PROPERTY, newProductIds);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return levelNCategory;
		}
		if(externalNewProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(NewProduct newProduct: externalNewProductList){

			newProduct.clearFromAll();
		}
		
		
		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return levelNCategory;	
	
	}


	//disconnect LevelNCategory with brand in NewProduct
	public LevelNCategory planToRemoveNewProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return levelNCategory;
		}
		if(externalNewProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearBrand();
			newProduct.clearParentCategory();
			
		}
		
		
		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return levelNCategory;
	}
	
	public int countNewProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(NewProduct.BRAND_PROPERTY, brandId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with catalog in NewProduct
	public LevelNCategory planToRemoveNewProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return levelNCategory;
		}
		if(externalNewProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearCatalog();
			newProduct.clearParentCategory();
			
		}
		
		
		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return levelNCategory;
	}
	
	public int countNewProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(NewProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with profile in NewProduct
	public LevelNCategory planToRemoveNewProductListWithProfile(LevelNCategory levelNCategory, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return levelNCategory;
		}
		if(externalNewProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearProfile();
			newProduct.clearParentCategory();
			
		}
		
		
		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return levelNCategory;
	}
	
	public int countNewProductListWithProfile(String levelNCategoryId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(NewProduct.PROFILE_PROPERTY, profileId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with platform in NewProduct
	public LevelNCategory planToRemoveNewProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<NewProduct> externalNewProductList = getNewProductDAO().
				findNewProductWithKey(key, options);
		if(externalNewProductList == null){
			return levelNCategory;
		}
		if(externalNewProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(NewProduct newProduct: externalNewProductList){
			newProduct.clearPlatform();
			newProduct.clearParentCategory();
			
		}
		
		
		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();		
		newProductList.addAllToRemoveList(externalNewProductList);
		return levelNCategory;
	}
	
	public int countNewProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NewProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(NewProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getNewProductDAO().countNewProductWithKey(key, options);
		return count;
	}
	
	public LevelNCategory planToRemoveEditorPickProductList(LevelNCategory levelNCategory, String editorPickProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(EditorPickProduct.ID_PROPERTY, editorPickProductIds);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return levelNCategory;
		}
		if(externalEditorPickProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){

			editorPickProduct.clearFromAll();
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return levelNCategory;	
	
	}


	//disconnect LevelNCategory with brand in EditorPickProduct
	public LevelNCategory planToRemoveEditorPickProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return levelNCategory;
		}
		if(externalEditorPickProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearBrand();
			editorPickProduct.clearParentCategory();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return levelNCategory;
	}
	
	public int countEditorPickProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(EditorPickProduct.BRAND_PROPERTY, brandId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with catalog in EditorPickProduct
	public LevelNCategory planToRemoveEditorPickProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return levelNCategory;
		}
		if(externalEditorPickProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearCatalog();
			editorPickProduct.clearParentCategory();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return levelNCategory;
	}
	
	public int countEditorPickProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(EditorPickProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with profile in EditorPickProduct
	public LevelNCategory planToRemoveEditorPickProductListWithProfile(LevelNCategory levelNCategory, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return levelNCategory;
		}
		if(externalEditorPickProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearProfile();
			editorPickProduct.clearParentCategory();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return levelNCategory;
	}
	
	public int countEditorPickProductListWithProfile(String levelNCategoryId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(EditorPickProduct.PROFILE_PROPERTY, profileId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with platform in EditorPickProduct
	public LevelNCategory planToRemoveEditorPickProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<EditorPickProduct> externalEditorPickProductList = getEditorPickProductDAO().
				findEditorPickProductWithKey(key, options);
		if(externalEditorPickProductList == null){
			return levelNCategory;
		}
		if(externalEditorPickProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(EditorPickProduct editorPickProduct: externalEditorPickProductList){
			editorPickProduct.clearPlatform();
			editorPickProduct.clearParentCategory();
			
		}
		
		
		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();		
		editorPickProductList.addAllToRemoveList(externalEditorPickProductList);
		return levelNCategory;
	}
	
	public int countEditorPickProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EditorPickProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(EditorPickProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getEditorPickProductDAO().countEditorPickProductWithKey(key, options);
		return count;
	}
	
	public LevelNCategory planToRemoveTopRatedProductList(LevelNCategory levelNCategory, String topRatedProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(TopRatedProduct.ID_PROPERTY, topRatedProductIds);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return levelNCategory;
		}
		if(externalTopRatedProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){

			topRatedProduct.clearFromAll();
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return levelNCategory;	
	
	}


	//disconnect LevelNCategory with brand in TopRatedProduct
	public LevelNCategory planToRemoveTopRatedProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return levelNCategory;
		}
		if(externalTopRatedProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearBrand();
			topRatedProduct.clearParentCategory();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return levelNCategory;
	}
	
	public int countTopRatedProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(TopRatedProduct.BRAND_PROPERTY, brandId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with catalog in TopRatedProduct
	public LevelNCategory planToRemoveTopRatedProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return levelNCategory;
		}
		if(externalTopRatedProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearCatalog();
			topRatedProduct.clearParentCategory();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return levelNCategory;
	}
	
	public int countTopRatedProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(TopRatedProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with profile in TopRatedProduct
	public LevelNCategory planToRemoveTopRatedProductListWithProfile(LevelNCategory levelNCategory, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return levelNCategory;
		}
		if(externalTopRatedProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearProfile();
			topRatedProduct.clearParentCategory();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return levelNCategory;
	}
	
	public int countTopRatedProductListWithProfile(String levelNCategoryId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(TopRatedProduct.PROFILE_PROPERTY, profileId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with platform in TopRatedProduct
	public LevelNCategory planToRemoveTopRatedProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<TopRatedProduct> externalTopRatedProductList = getTopRatedProductDAO().
				findTopRatedProductWithKey(key, options);
		if(externalTopRatedProductList == null){
			return levelNCategory;
		}
		if(externalTopRatedProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(TopRatedProduct topRatedProduct: externalTopRatedProductList){
			topRatedProduct.clearPlatform();
			topRatedProduct.clearParentCategory();
			
		}
		
		
		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();		
		topRatedProductList.addAllToRemoveList(externalTopRatedProductList);
		return levelNCategory;
	}
	
	public int countTopRatedProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TopRatedProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(TopRatedProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getTopRatedProductDAO().countTopRatedProductWithKey(key, options);
		return count;
	}
	
	public LevelNCategory planToRemoveRecommandProductList(LevelNCategory levelNCategory, String recommandProductIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(RecommandProduct.ID_PROPERTY, recommandProductIds);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return levelNCategory;
		}
		if(externalRecommandProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){

			recommandProduct.clearFromAll();
		}
		
		
		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return levelNCategory;	
	
	}


	//disconnect LevelNCategory with brand in RecommandProduct
	public LevelNCategory planToRemoveRecommandProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return levelNCategory;
		}
		if(externalRecommandProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearBrand();
			recommandProduct.clearParentCategory();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return levelNCategory;
	}
	
	public int countRecommandProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(RecommandProduct.BRAND_PROPERTY, brandId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with catalog in RecommandProduct
	public LevelNCategory planToRemoveRecommandProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return levelNCategory;
		}
		if(externalRecommandProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearCatalog();
			recommandProduct.clearParentCategory();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return levelNCategory;
	}
	
	public int countRecommandProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(RecommandProduct.CATALOG_PROPERTY, catalogId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with profile in RecommandProduct
	public LevelNCategory planToRemoveRecommandProductListWithProfile(LevelNCategory levelNCategory, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return levelNCategory;
		}
		if(externalRecommandProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearProfile();
			recommandProduct.clearParentCategory();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return levelNCategory;
	}
	
	public int countRecommandProductListWithProfile(String levelNCategoryId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(RecommandProduct.PROFILE_PROPERTY, profileId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with platform in RecommandProduct
	public LevelNCategory planToRemoveRecommandProductListWithPlatform(LevelNCategory levelNCategory, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		
		SmartList<RecommandProduct> externalRecommandProductList = getRecommandProductDAO().
				findRecommandProductWithKey(key, options);
		if(externalRecommandProductList == null){
			return levelNCategory;
		}
		if(externalRecommandProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(RecommandProduct recommandProduct: externalRecommandProductList){
			recommandProduct.clearPlatform();
			recommandProduct.clearParentCategory();
			
		}
		
		
		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();		
		recommandProductList.addAllToRemoveList(externalRecommandProductList);
		return levelNCategory;
	}
	
	public int countRecommandProductListWithPlatform(String levelNCategoryId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RecommandProduct.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(RecommandProduct.PLATFORM_PROPERTY, platformId);
		
		int count = getRecommandProductDAO().countRecommandProductWithKey(key, options);
		return count;
	}
	

		
	protected LevelNCategory saveProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = levelNCategory.getProductList();
		if(productList == null){
			//null list means nothing
			return levelNCategory;
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
		
		
		return levelNCategory;
	
	}
	
	protected LevelNCategory removeProductList(LevelNCategory levelNCategory, Map<String,Object> options){
	
	
		SmartList<Product> productList = levelNCategory.getProductList();
		if(productList == null){
			return levelNCategory;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return levelNCategory;
		}
		if(toRemoveProductList.isEmpty()){
			return levelNCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return levelNCategory;
	
	}
	
	

 	
 	
	
	
	
		
	protected LevelNCategory saveNewProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		
		
		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();
		if(newProductList == null){
			//null list means nothing
			return levelNCategory;
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
		
		
		return levelNCategory;
	
	}
	
	protected LevelNCategory removeNewProductList(LevelNCategory levelNCategory, Map<String,Object> options){
	
	
		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();
		if(newProductList == null){
			return levelNCategory;
		}	
	
		SmartList<NewProduct> toRemoveNewProductList = newProductList.getToRemoveList();
		
		if(toRemoveNewProductList == null){
			return levelNCategory;
		}
		if(toRemoveNewProductList.isEmpty()){
			return levelNCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNewProductDAO().removeNewProductList(toRemoveNewProductList,options);
		
		return levelNCategory;
	
	}
	
	

 	
 	
	
	
	
		
	protected LevelNCategory saveEditorPickProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		
		
		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();
		if(editorPickProductList == null){
			//null list means nothing
			return levelNCategory;
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
		
		
		return levelNCategory;
	
	}
	
	protected LevelNCategory removeEditorPickProductList(LevelNCategory levelNCategory, Map<String,Object> options){
	
	
		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();
		if(editorPickProductList == null){
			return levelNCategory;
		}	
	
		SmartList<EditorPickProduct> toRemoveEditorPickProductList = editorPickProductList.getToRemoveList();
		
		if(toRemoveEditorPickProductList == null){
			return levelNCategory;
		}
		if(toRemoveEditorPickProductList.isEmpty()){
			return levelNCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEditorPickProductDAO().removeEditorPickProductList(toRemoveEditorPickProductList,options);
		
		return levelNCategory;
	
	}
	
	

 	
 	
	
	
	
		
	protected LevelNCategory saveTopRatedProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		
		
		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();
		if(topRatedProductList == null){
			//null list means nothing
			return levelNCategory;
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
		
		
		return levelNCategory;
	
	}
	
	protected LevelNCategory removeTopRatedProductList(LevelNCategory levelNCategory, Map<String,Object> options){
	
	
		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();
		if(topRatedProductList == null){
			return levelNCategory;
		}	
	
		SmartList<TopRatedProduct> toRemoveTopRatedProductList = topRatedProductList.getToRemoveList();
		
		if(toRemoveTopRatedProductList == null){
			return levelNCategory;
		}
		if(toRemoveTopRatedProductList.isEmpty()){
			return levelNCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTopRatedProductDAO().removeTopRatedProductList(toRemoveTopRatedProductList,options);
		
		return levelNCategory;
	
	}
	
	

 	
 	
	
	
	
		
	protected LevelNCategory saveRecommandProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		
		
		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();
		if(recommandProductList == null){
			//null list means nothing
			return levelNCategory;
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
		
		
		return levelNCategory;
	
	}
	
	protected LevelNCategory removeRecommandProductList(LevelNCategory levelNCategory, Map<String,Object> options){
	
	
		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();
		if(recommandProductList == null){
			return levelNCategory;
		}	
	
		SmartList<RecommandProduct> toRemoveRecommandProductList = recommandProductList.getToRemoveList();
		
		if(toRemoveRecommandProductList == null){
			return levelNCategory;
		}
		if(toRemoveRecommandProductList.isEmpty()){
			return levelNCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRecommandProductDAO().removeRecommandProductList(toRemoveRecommandProductList,options);
		
		return levelNCategory;
	
	}
	
	

 	
 	
	
	
	
		

	public LevelNCategory present(LevelNCategory levelNCategory,Map<String, Object> options){
	
		presentProductList(levelNCategory,options);
		presentNewProductList(levelNCategory,options);
		presentEditorPickProductList(levelNCategory,options);
		presentTopRatedProductList(levelNCategory,options);
		presentRecommandProductList(levelNCategory,options);

		return levelNCategory;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LevelNCategory presentProductList(
			LevelNCategory levelNCategory,
			Map<String, Object> options) {

		SmartList<Product> productList = levelNCategory.getProductList();		
				SmartList<Product> newList= presentSubList(levelNCategory.getId(),
				productList,
				options,
				getProductDAO()::countProductByParentCategory,
				getProductDAO()::findProductByParentCategory
				);

		
		levelNCategory.setProductList(newList);
		

		return levelNCategory;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected LevelNCategory presentNewProductList(
			LevelNCategory levelNCategory,
			Map<String, Object> options) {

		SmartList<NewProduct> newProductList = levelNCategory.getNewProductList();		
				SmartList<NewProduct> newList= presentSubList(levelNCategory.getId(),
				newProductList,
				options,
				getNewProductDAO()::countNewProductByParentCategory,
				getNewProductDAO()::findNewProductByParentCategory
				);

		
		levelNCategory.setNewProductList(newList);
		

		return levelNCategory;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected LevelNCategory presentEditorPickProductList(
			LevelNCategory levelNCategory,
			Map<String, Object> options) {

		SmartList<EditorPickProduct> editorPickProductList = levelNCategory.getEditorPickProductList();		
				SmartList<EditorPickProduct> newList= presentSubList(levelNCategory.getId(),
				editorPickProductList,
				options,
				getEditorPickProductDAO()::countEditorPickProductByParentCategory,
				getEditorPickProductDAO()::findEditorPickProductByParentCategory
				);

		
		levelNCategory.setEditorPickProductList(newList);
		

		return levelNCategory;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected LevelNCategory presentTopRatedProductList(
			LevelNCategory levelNCategory,
			Map<String, Object> options) {

		SmartList<TopRatedProduct> topRatedProductList = levelNCategory.getTopRatedProductList();		
				SmartList<TopRatedProduct> newList= presentSubList(levelNCategory.getId(),
				topRatedProductList,
				options,
				getTopRatedProductDAO()::countTopRatedProductByParentCategory,
				getTopRatedProductDAO()::findTopRatedProductByParentCategory
				);

		
		levelNCategory.setTopRatedProductList(newList);
		

		return levelNCategory;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected LevelNCategory presentRecommandProductList(
			LevelNCategory levelNCategory,
			Map<String, Object> options) {

		SmartList<RecommandProduct> recommandProductList = levelNCategory.getRecommandProductList();		
				SmartList<RecommandProduct> newList= presentSubList(levelNCategory.getId(),
				recommandProductList,
				options,
				getRecommandProductDAO()::countRecommandProductByParentCategory,
				getRecommandProductDAO()::findRecommandProductByParentCategory
				);

		
		levelNCategory.setRecommandProductList(newList);
		

		return levelNCategory;
	}			
		

	
    public SmartList<LevelNCategory> requestCandidateLevelNCategoryForProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getLevelNCategoryMapper());
    }
		
    public SmartList<LevelNCategory> requestCandidateLevelNCategoryForNewProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getLevelNCategoryMapper());
    }
		
    public SmartList<LevelNCategory> requestCandidateLevelNCategoryForEditorPickProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getLevelNCategoryMapper());
    }
		
    public SmartList<LevelNCategory> requestCandidateLevelNCategoryForTopRatedProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getLevelNCategoryMapper());
    }
		
    public SmartList<LevelNCategory> requestCandidateLevelNCategoryForRecommandProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getLevelNCategoryMapper());
    }
		

	protected String getTableName(){
		return LevelNCategoryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LevelNCategory> levelNCategoryList) {		
		this.enhanceListInternal(levelNCategoryList, this.getLevelNCategoryMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LevelNCategory> levelNCategoryList = ownerEntity.collectRefsWithType(LevelNCategory.INTERNAL_TYPE);
		this.enhanceList(levelNCategoryList);
		
	}
	
	@Override
	public SmartList<LevelNCategory> findLevelNCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLevelNCategoryMapper());

	}
	@Override
	public int countLevelNCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLevelNCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LevelNCategory> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLevelNCategoryMapper());
	}
}


