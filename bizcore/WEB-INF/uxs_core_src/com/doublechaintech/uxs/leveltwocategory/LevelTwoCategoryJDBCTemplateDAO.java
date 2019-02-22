
package com.doublechaintech.uxs.leveltwocategory;

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
import com.doublechaintech.uxs.levelncategory.LevelNCategory;

import com.doublechaintech.uxs.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.uxs.levelncategory.LevelNCategoryDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class LevelTwoCategoryJDBCTemplateDAO extends UxsNamingServiceDAO implements LevelTwoCategoryDAO{
 
 	
 	private  LevelOneCategoryDAO  levelOneCategoryDAO;
 	public void setLevelOneCategoryDAO(LevelOneCategoryDAO levelOneCategoryDAO){
	 	this.levelOneCategoryDAO = levelOneCategoryDAO;
 	}
 	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
	 	return this.levelOneCategoryDAO;
 	}


			
		
	
  	private  LevelNCategoryDAO  levelNCategoryDAO;
 	public void setLevelNCategoryDAO(LevelNCategoryDAO pLevelNCategoryDAO){
 	
 		if(pLevelNCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelNCategoryDAO to null.");
 		}
	 	this.levelNCategoryDAO = pLevelNCategoryDAO;
 	}
 	public LevelNCategoryDAO getLevelNCategoryDAO(){
 		if(this.levelNCategoryDAO == null){
 			throw new IllegalStateException("The levelNCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelNCategoryDAO;
 	}	
 	
			
		

	
	/*
	protected LevelTwoCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoCategory(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LevelTwoCategory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoCategory(LevelTwoCategoryTable.withId(id), options);
	}
	
	
	
	public LevelTwoCategory save(LevelTwoCategory levelTwoCategory,Map<String,Object> options){
		
		String methodName="save(LevelTwoCategory levelTwoCategory,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelTwoCategory, methodName, "levelTwoCategory");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelTwoCategory(levelTwoCategory,options);
	}
	public LevelTwoCategory clone(String levelTwoCategoryId, Map<String,Object> options) throws Exception{
	
		return clone(LevelTwoCategoryTable.withId(levelTwoCategoryId),options);
	}
	
	protected LevelTwoCategory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelTwoCategoryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelTwoCategory newLevelTwoCategory = loadInternalLevelTwoCategory(accessKey, options);
		newLevelTwoCategory.setVersion(0);
		
		
 		
 		if(isSaveLevelNCategoryListEnabled(options)){
 			for(LevelNCategory item: newLevelTwoCategory.getLevelNCategoryList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelTwoCategory(newLevelTwoCategory,options);
		
		return newLevelTwoCategory;
	}
	
	
	
	

	protected void throwIfHasException(String levelTwoCategoryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LevelTwoCategoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelTwoCategoryNotFoundException(
					"The " + this.getTableName() + "(" + levelTwoCategoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String levelTwoCategoryId, int version) throws Exception{
	
		String methodName="delete(String levelTwoCategoryId, int version)";
		assertMethodArgumentNotNull(levelTwoCategoryId, methodName, "levelTwoCategoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelTwoCategoryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelTwoCategoryId,version);
		}
		
	
	}
	
	
	
	
	

	public LevelTwoCategory disconnectFromAll(String levelTwoCategoryId, int version) throws Exception{
	
		
		LevelTwoCategory levelTwoCategory = loadInternalLevelTwoCategory(LevelTwoCategoryTable.withId(levelTwoCategoryId), emptyOptions());
		levelTwoCategory.clearFromAll();
		this.saveLevelTwoCategory(levelTwoCategory);
		return levelTwoCategory;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LevelTwoCategoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_two_category";
	}
	@Override
	protected String getBeanName() {
		
		return "levelTwoCategory";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelTwoCategoryTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelTwoCategoryTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelTwoCategoryTokens.PARENTCATEGORY);
 	}
 	

 	
 
		
	
	protected boolean isExtractLevelNCategoryListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelTwoCategoryTokens.LEVEL_N_CATEGORY_LIST);
 	}
 	protected boolean isAnalyzeLevelNCategoryListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,LevelTwoCategoryTokens.LEVEL_N_CATEGORY_LIST+".analyze");
 	}
	
	protected boolean isSaveLevelNCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelTwoCategoryTokens.LEVEL_N_CATEGORY_LIST);
		
 	}
 	
		

	

	protected LevelTwoCategoryMapper getLevelTwoCategoryMapper(){
		return new LevelTwoCategoryMapper();
	}

	
	
	protected LevelTwoCategory extractLevelTwoCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LevelTwoCategory levelTwoCategory = loadSingleObject(accessKey, getLevelTwoCategoryMapper());
			return levelTwoCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelTwoCategoryNotFoundException("LevelTwoCategory("+accessKey+") is not found!");
		}

	}

	
	

	protected LevelTwoCategory loadInternalLevelTwoCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelTwoCategory levelTwoCategory = extractLevelTwoCategory(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(levelTwoCategory, loadOptions);
 		}
 
		
		if(isExtractLevelNCategoryListEnabled(loadOptions)){
	 		extractLevelNCategoryList(levelTwoCategory, loadOptions);
 		}	
 		if(isAnalyzeLevelNCategoryListEnabled(loadOptions)){
	 		analyzeLevelNCategoryList(levelTwoCategory, loadOptions);
 		}
 		
		
		return levelTwoCategory;
		
	}

	 

 	protected LevelTwoCategory extractParentCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options) throws Exception{

		if(levelTwoCategory.getParentCategory() == null){
			return levelTwoCategory;
		}
		String parentCategoryId = levelTwoCategory.getParentCategory().getId();
		if( parentCategoryId == null){
			return levelTwoCategory;
		}
		LevelOneCategory parentCategory = getLevelOneCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			levelTwoCategory.setParentCategory(parentCategory);
		}
		
 		
 		return levelTwoCategory;
 	}
 		
 
		
	protected void enhanceLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelTwoCategory extractLevelNCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		
		if(levelTwoCategory == null){
			return null;
		}
		if(levelTwoCategory.getId() == null){
			return levelTwoCategory;
		}

		
		
		SmartList<LevelNCategory> levelNCategoryList = getLevelNCategoryDAO().findLevelNCategoryByParentCategory(levelTwoCategory.getId(),options);
		if(levelNCategoryList != null){
			enhanceLevelNCategoryList(levelNCategoryList,options);
			levelTwoCategory.setLevelNCategoryList(levelNCategoryList);
		}
		
		return levelTwoCategory;
	
	}	
	
	protected LevelTwoCategory analyzeLevelNCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		
		if(levelTwoCategory == null){
			return null;
		}
		if(levelTwoCategory.getId() == null){
			return levelTwoCategory;
		}

		
		
		SmartList<LevelNCategory> levelNCategoryList = levelTwoCategory.getLevelNCategoryList();
		if(levelNCategoryList != null){
			getLevelNCategoryDAO().analyzeLevelNCategoryByParentCategory(levelNCategoryList, levelTwoCategory.getId(), options);
			
		}
		
		return levelTwoCategory;
	
	}	
	
		
		
  	
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId,Map<String,Object> options){
 	
  		SmartList<LevelTwoCategory> resultList = queryWith(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, levelOneCategoryId, options, getLevelTwoCategoryMapper());
		// analyzeLevelTwoCategoryByParentCategory(resultList, levelOneCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LevelTwoCategory> resultList =  queryWithRange(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, levelOneCategoryId, options, getLevelTwoCategoryMapper(), start, count);
 		//analyzeLevelTwoCategoryByParentCategory(resultList, levelOneCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeLevelTwoCategoryByParentCategory(SmartList<LevelTwoCategory> resultList, String levelOneCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLevelTwoCategoryByParentCategory(String levelOneCategoryId,Map<String,Object> options){

 		return countWith(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, levelOneCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countLevelTwoCategoryByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
 	
		
		
		

	

	protected LevelTwoCategory saveLevelTwoCategory(LevelTwoCategory  levelTwoCategory){
		
		if(!levelTwoCategory.isChanged()){
			return levelTwoCategory;
		}
		
		
		String SQL=this.getSaveLevelTwoCategorySQL(levelTwoCategory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelTwoCategoryParameters(levelTwoCategory);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelTwoCategory.incVersion();
		return levelTwoCategory;
	
	}
	public SmartList<LevelTwoCategory> saveLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelTwoCategoryList(levelTwoCategoryList);
		
		batchLevelTwoCategoryCreate((List<LevelTwoCategory>)lists[CREATE_LIST_INDEX]);
		
		batchLevelTwoCategoryUpdate((List<LevelTwoCategory>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList){
			if(levelTwoCategory.isChanged()){
				levelTwoCategory.incVersion();
			}
			
		
		}
		
		
		return levelTwoCategoryList;
	}

	public SmartList<LevelTwoCategory> removeLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options){
		
		
		super.removeList(levelTwoCategoryList, options);
		
		return levelTwoCategoryList;
		
		
	}
	
	protected List<Object[]> prepareLevelTwoCategoryBatchCreateArgs(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList ){
			Object [] parameters = prepareLevelTwoCategoryCreateParameters(levelTwoCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelTwoCategoryBatchUpdateArgs(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList ){
			if(!levelTwoCategory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelTwoCategoryUpdateParameters(levelTwoCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelTwoCategoryCreate(List<LevelTwoCategory> levelTwoCategoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelTwoCategoryBatchCreateArgs(levelTwoCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelTwoCategoryUpdate(List<LevelTwoCategory> levelTwoCategoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelTwoCategoryBatchUpdateArgs(levelTwoCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelTwoCategoryList(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<LevelTwoCategory> levelTwoCategoryCreateList=new ArrayList<LevelTwoCategory>();
		List<LevelTwoCategory> levelTwoCategoryUpdateList=new ArrayList<LevelTwoCategory>();
		
		for(LevelTwoCategory levelTwoCategory: levelTwoCategoryList){
			if(isUpdateRequest(levelTwoCategory)){
				levelTwoCategoryUpdateList.add( levelTwoCategory);
				continue;
			}
			levelTwoCategoryCreateList.add(levelTwoCategory);
		}
		
		return new Object[]{levelTwoCategoryCreateList,levelTwoCategoryUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelTwoCategory levelTwoCategory){
 		return levelTwoCategory.getVersion() > 0;
 	}
 	protected String getSaveLevelTwoCategorySQL(LevelTwoCategory levelTwoCategory){
 		if(isUpdateRequest(levelTwoCategory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelTwoCategoryParameters(LevelTwoCategory levelTwoCategory){
 		if(isUpdateRequest(levelTwoCategory) ){
 			return prepareLevelTwoCategoryUpdateParameters(levelTwoCategory);
 		}
 		return prepareLevelTwoCategoryCreateParameters(levelTwoCategory);
 	}
 	protected Object[] prepareLevelTwoCategoryUpdateParameters(LevelTwoCategory levelTwoCategory){
 		Object[] parameters = new Object[5];
  	
 		if(levelTwoCategory.getParentCategory() != null){
 			parameters[0] = levelTwoCategory.getParentCategory().getId();
 		}
 
 		parameters[1] = levelTwoCategory.getName();		
 		parameters[2] = levelTwoCategory.nextVersion();
 		parameters[3] = levelTwoCategory.getId();
 		parameters[4] = levelTwoCategory.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelTwoCategoryCreateParameters(LevelTwoCategory levelTwoCategory){
		Object[] parameters = new Object[3];
		String newLevelTwoCategoryId=getNextId();
		levelTwoCategory.setId(newLevelTwoCategoryId);
		parameters[0] =  levelTwoCategory.getId();
  	
 		if(levelTwoCategory.getParentCategory() != null){
 			parameters[1] = levelTwoCategory.getParentCategory().getId();
 		
 		}
 		
 		parameters[2] = levelTwoCategory.getName();		
 				
 		return parameters;
 	}
 	
	protected LevelTwoCategory saveInternalLevelTwoCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		saveLevelTwoCategory(levelTwoCategory);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(levelTwoCategory, options);
 		}
 
		
		if(isSaveLevelNCategoryListEnabled(options)){
	 		saveLevelNCategoryList(levelTwoCategory, options);
	 		//removeLevelNCategoryList(levelTwoCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		return levelTwoCategory;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelTwoCategory saveParentCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelTwoCategory.getParentCategory() == null){
 			return levelTwoCategory;//do nothing when it is null
 		}
 		
 		getLevelOneCategoryDAO().save(levelTwoCategory.getParentCategory(),options);
 		return levelTwoCategory;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public LevelTwoCategory planToRemoveLevelNCategoryList(LevelTwoCategory levelTwoCategory, String levelNCategoryIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelNCategory.PARENT_CATEGORY_PROPERTY, levelTwoCategory.getId());
		key.put(LevelNCategory.ID_PROPERTY, levelNCategoryIds);
		
		SmartList<LevelNCategory> externalLevelNCategoryList = getLevelNCategoryDAO().
				findLevelNCategoryWithKey(key, options);
		if(externalLevelNCategoryList == null){
			return levelTwoCategory;
		}
		if(externalLevelNCategoryList.isEmpty()){
			return levelTwoCategory;
		}
		
		for(LevelNCategory levelNCategory: externalLevelNCategoryList){

			levelNCategory.clearFromAll();
		}
		
		
		SmartList<LevelNCategory> levelNCategoryList = levelTwoCategory.getLevelNCategoryList();		
		levelNCategoryList.addAllToRemoveList(externalLevelNCategoryList);
		return levelTwoCategory;	
	
	}



		
	protected LevelTwoCategory saveLevelNCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		
		
		
		SmartList<LevelNCategory> levelNCategoryList = levelTwoCategory.getLevelNCategoryList();
		if(levelNCategoryList == null){
			//null list means nothing
			return levelTwoCategory;
		}
		SmartList<LevelNCategory> mergedUpdateLevelNCategoryList = new SmartList<LevelNCategory>();
		
		
		mergedUpdateLevelNCategoryList.addAll(levelNCategoryList); 
		if(levelNCategoryList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelNCategoryList.addAll(levelNCategoryList.getToRemoveList());
			levelNCategoryList.removeAll(levelNCategoryList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLevelNCategoryDAO().saveLevelNCategoryList(mergedUpdateLevelNCategoryList,options);
		
		if(levelNCategoryList.getToRemoveList() != null){
			levelNCategoryList.removeAll(levelNCategoryList.getToRemoveList());
		}
		
		
		return levelTwoCategory;
	
	}
	
	protected LevelTwoCategory removeLevelNCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
	
	
		SmartList<LevelNCategory> levelNCategoryList = levelTwoCategory.getLevelNCategoryList();
		if(levelNCategoryList == null){
			return levelTwoCategory;
		}	
	
		SmartList<LevelNCategory> toRemoveLevelNCategoryList = levelNCategoryList.getToRemoveList();
		
		if(toRemoveLevelNCategoryList == null){
			return levelTwoCategory;
		}
		if(toRemoveLevelNCategoryList.isEmpty()){
			return levelTwoCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelNCategoryDAO().removeLevelNCategoryList(toRemoveLevelNCategoryList,options);
		
		return levelTwoCategory;
	
	}
	
	

 	
 	
	
	
	
		

	public LevelTwoCategory present(LevelTwoCategory levelTwoCategory,Map<String, Object> options){
	
		presentLevelNCategoryList(levelTwoCategory,options);

		return levelTwoCategory;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LevelTwoCategory presentLevelNCategoryList(
			LevelTwoCategory levelTwoCategory,
			Map<String, Object> options) {

		SmartList<LevelNCategory> levelNCategoryList = levelTwoCategory.getLevelNCategoryList();		
				SmartList<LevelNCategory> newList= presentSubList(levelTwoCategory.getId(),
				levelNCategoryList,
				options,
				getLevelNCategoryDAO()::countLevelNCategoryByParentCategory,
				getLevelNCategoryDAO()::findLevelNCategoryByParentCategory
				);

		
		levelTwoCategory.setLevelNCategoryList(newList);
		

		return levelTwoCategory;
	}			
		

	
    public SmartList<LevelTwoCategory> requestCandidateLevelTwoCategoryForLevelNCategory(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getLevelTwoCategoryMapper());
    }
		

	protected String getTableName(){
		return LevelTwoCategoryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LevelTwoCategory> levelTwoCategoryList) {		
		this.enhanceListInternal(levelTwoCategoryList, this.getLevelTwoCategoryMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LevelTwoCategory> levelTwoCategoryList = ownerEntity.collectRefsWithType(LevelTwoCategory.INTERNAL_TYPE);
		this.enhanceList(levelTwoCategoryList);
		
	}
	
	@Override
	public SmartList<LevelTwoCategory> findLevelTwoCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLevelTwoCategoryMapper());

	}
	@Override
	public int countLevelTwoCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLevelTwoCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LevelTwoCategory> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLevelTwoCategoryMapper());
	}
}


