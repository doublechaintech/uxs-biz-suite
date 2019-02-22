
package com.doublechaintech.uxs.categoryfilter;

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


import com.doublechaintech.uxs.profile.Profile;

import com.doublechaintech.uxs.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class CategoryFilterJDBCTemplateDAO extends UxsNamingServiceDAO implements CategoryFilterDAO{
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}


			
		

	
	/*
	protected CategoryFilter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCategoryFilter(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public CategoryFilter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCategoryFilter(CategoryFilterTable.withId(id), options);
	}
	
	
	
	public CategoryFilter save(CategoryFilter categoryFilter,Map<String,Object> options){
		
		String methodName="save(CategoryFilter categoryFilter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(categoryFilter, methodName, "categoryFilter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCategoryFilter(categoryFilter,options);
	}
	public CategoryFilter clone(String categoryFilterId, Map<String,Object> options) throws Exception{
	
		return clone(CategoryFilterTable.withId(categoryFilterId),options);
	}
	
	protected CategoryFilter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String categoryFilterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CategoryFilter newCategoryFilter = loadInternalCategoryFilter(accessKey, options);
		newCategoryFilter.setVersion(0);
		
		

		
		saveInternalCategoryFilter(newCategoryFilter,options);
		
		return newCategoryFilter;
	}
	
	
	
	

	protected void throwIfHasException(String categoryFilterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CategoryFilterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CategoryFilterNotFoundException(
					"The " + this.getTableName() + "(" + categoryFilterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String categoryFilterId, int version) throws Exception{
	
		String methodName="delete(String categoryFilterId, int version)";
		assertMethodArgumentNotNull(categoryFilterId, methodName, "categoryFilterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{categoryFilterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(categoryFilterId,version);
		}
		
	
	}
	
	
	
	
	

	public CategoryFilter disconnectFromAll(String categoryFilterId, int version) throws Exception{
	
		
		CategoryFilter categoryFilter = loadInternalCategoryFilter(CategoryFilterTable.withId(categoryFilterId), emptyOptions());
		categoryFilter.clearFromAll();
		this.saveCategoryFilter(categoryFilter);
		return categoryFilter;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return CategoryFilterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "category_filter";
	}
	@Override
	protected String getBeanName() {
		
		return "categoryFilter";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CategoryFilterTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CategoryFilterTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CategoryFilterTokens.PROFILE);
 	}
 	

 	
 
		

	

	protected CategoryFilterMapper getCategoryFilterMapper(){
		return new CategoryFilterMapper();
	}

	
	
	protected CategoryFilter extractCategoryFilter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			CategoryFilter categoryFilter = loadSingleObject(accessKey, getCategoryFilterMapper());
			return categoryFilter;
		}catch(EmptyResultDataAccessException e){
			throw new CategoryFilterNotFoundException("CategoryFilter("+accessKey+") is not found!");
		}

	}

	
	

	protected CategoryFilter loadInternalCategoryFilter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CategoryFilter categoryFilter = extractCategoryFilter(accessKey, loadOptions);
 	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(categoryFilter, loadOptions);
 		}
 
		
		return categoryFilter;
		
	}

	 

 	protected CategoryFilter extractProfile(CategoryFilter categoryFilter, Map<String,Object> options) throws Exception{

		if(categoryFilter.getProfile() == null){
			return categoryFilter;
		}
		String profileId = categoryFilter.getProfile().getId();
		if( profileId == null){
			return categoryFilter;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			categoryFilter.setProfile(profile);
		}
		
 		
 		return categoryFilter;
 	}
 		
 
		
		
  	
 	public SmartList<CategoryFilter> findCategoryFilterByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<CategoryFilter> resultList = queryWith(CategoryFilterTable.COLUMN_PROFILE, profileId, options, getCategoryFilterMapper());
		// analyzeCategoryFilterByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CategoryFilter> findCategoryFilterByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CategoryFilter> resultList =  queryWithRange(CategoryFilterTable.COLUMN_PROFILE, profileId, options, getCategoryFilterMapper(), start, count);
 		//analyzeCategoryFilterByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeCategoryFilterByProfile(SmartList<CategoryFilter> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countCategoryFilterByProfile(String profileId,Map<String,Object> options){

 		return countWith(CategoryFilterTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countCategoryFilterByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CategoryFilterTable.COLUMN_PROFILE, ids, options);
	}
 	
 	
		
		
		

	

	protected CategoryFilter saveCategoryFilter(CategoryFilter  categoryFilter){
		
		if(!categoryFilter.isChanged()){
			return categoryFilter;
		}
		
		
		String SQL=this.getSaveCategoryFilterSQL(categoryFilter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCategoryFilterParameters(categoryFilter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		categoryFilter.incVersion();
		return categoryFilter;
	
	}
	public SmartList<CategoryFilter> saveCategoryFilterList(SmartList<CategoryFilter> categoryFilterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCategoryFilterList(categoryFilterList);
		
		batchCategoryFilterCreate((List<CategoryFilter>)lists[CREATE_LIST_INDEX]);
		
		batchCategoryFilterUpdate((List<CategoryFilter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(CategoryFilter categoryFilter:categoryFilterList){
			if(categoryFilter.isChanged()){
				categoryFilter.incVersion();
			}
			
		
		}
		
		
		return categoryFilterList;
	}

	public SmartList<CategoryFilter> removeCategoryFilterList(SmartList<CategoryFilter> categoryFilterList,Map<String,Object> options){
		
		
		super.removeList(categoryFilterList, options);
		
		return categoryFilterList;
		
		
	}
	
	protected List<Object[]> prepareCategoryFilterBatchCreateArgs(List<CategoryFilter> categoryFilterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CategoryFilter categoryFilter:categoryFilterList ){
			Object [] parameters = prepareCategoryFilterCreateParameters(categoryFilter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCategoryFilterBatchUpdateArgs(List<CategoryFilter> categoryFilterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CategoryFilter categoryFilter:categoryFilterList ){
			if(!categoryFilter.isChanged()){
				continue;
			}
			Object [] parameters = prepareCategoryFilterUpdateParameters(categoryFilter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCategoryFilterCreate(List<CategoryFilter> categoryFilterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCategoryFilterBatchCreateArgs(categoryFilterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCategoryFilterUpdate(List<CategoryFilter> categoryFilterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCategoryFilterBatchUpdateArgs(categoryFilterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCategoryFilterList(List<CategoryFilter> categoryFilterList){
		
		List<CategoryFilter> categoryFilterCreateList=new ArrayList<CategoryFilter>();
		List<CategoryFilter> categoryFilterUpdateList=new ArrayList<CategoryFilter>();
		
		for(CategoryFilter categoryFilter: categoryFilterList){
			if(isUpdateRequest(categoryFilter)){
				categoryFilterUpdateList.add( categoryFilter);
				continue;
			}
			categoryFilterCreateList.add(categoryFilter);
		}
		
		return new Object[]{categoryFilterCreateList,categoryFilterUpdateList};
	}
	
	protected boolean isUpdateRequest(CategoryFilter categoryFilter){
 		return categoryFilter.getVersion() > 0;
 	}
 	protected String getSaveCategoryFilterSQL(CategoryFilter categoryFilter){
 		if(isUpdateRequest(categoryFilter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCategoryFilterParameters(CategoryFilter categoryFilter){
 		if(isUpdateRequest(categoryFilter) ){
 			return prepareCategoryFilterUpdateParameters(categoryFilter);
 		}
 		return prepareCategoryFilterCreateParameters(categoryFilter);
 	}
 	protected Object[] prepareCategoryFilterUpdateParameters(CategoryFilter categoryFilter){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = categoryFilter.getName();
 		parameters[1] = categoryFilter.getInternalId(); 	
 		if(categoryFilter.getProfile() != null){
 			parameters[2] = categoryFilter.getProfile().getId();
 		}
 		
 		parameters[3] = categoryFilter.nextVersion();
 		parameters[4] = categoryFilter.getId();
 		parameters[5] = categoryFilter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCategoryFilterCreateParameters(CategoryFilter categoryFilter){
		Object[] parameters = new Object[4];
		String newCategoryFilterId=getNextId();
		categoryFilter.setId(newCategoryFilterId);
		parameters[0] =  categoryFilter.getId();
 
 		parameters[1] = categoryFilter.getName();
 		parameters[2] = categoryFilter.getInternalId(); 	
 		if(categoryFilter.getProfile() != null){
 			parameters[3] = categoryFilter.getProfile().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected CategoryFilter saveInternalCategoryFilter(CategoryFilter categoryFilter, Map<String,Object> options){
		
		saveCategoryFilter(categoryFilter);
 	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(categoryFilter, options);
 		}
 
		
		return categoryFilter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CategoryFilter saveProfile(CategoryFilter categoryFilter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(categoryFilter.getProfile() == null){
 			return categoryFilter;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(categoryFilter.getProfile(),options);
 		return categoryFilter;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public CategoryFilter present(CategoryFilter categoryFilter,Map<String, Object> options){
	

		return categoryFilter;
	
	}
		

	

	protected String getTableName(){
		return CategoryFilterTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<CategoryFilter> categoryFilterList) {		
		this.enhanceListInternal(categoryFilterList, this.getCategoryFilterMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<CategoryFilter> categoryFilterList = ownerEntity.collectRefsWithType(CategoryFilter.INTERNAL_TYPE);
		this.enhanceList(categoryFilterList);
		
	}
	
	@Override
	public SmartList<CategoryFilter> findCategoryFilterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getCategoryFilterMapper());

	}
	@Override
	public int countCategoryFilterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countCategoryFilterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<CategoryFilter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCategoryFilterMapper());
	}
}


