
package com.doublechaintech.uxs.brandfilter;

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

public class BrandFilterJDBCTemplateDAO extends UxsNamingServiceDAO implements BrandFilterDAO{
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}


			
		

	
	/*
	protected BrandFilter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalBrandFilter(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public BrandFilter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalBrandFilter(BrandFilterTable.withId(id), options);
	}
	
	
	
	public BrandFilter save(BrandFilter brandFilter,Map<String,Object> options){
		
		String methodName="save(BrandFilter brandFilter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(brandFilter, methodName, "brandFilter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalBrandFilter(brandFilter,options);
	}
	public BrandFilter clone(String brandFilterId, Map<String,Object> options) throws Exception{
	
		return clone(BrandFilterTable.withId(brandFilterId),options);
	}
	
	protected BrandFilter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String brandFilterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		BrandFilter newBrandFilter = loadInternalBrandFilter(accessKey, options);
		newBrandFilter.setVersion(0);
		
		

		
		saveInternalBrandFilter(newBrandFilter,options);
		
		return newBrandFilter;
	}
	
	
	
	

	protected void throwIfHasException(String brandFilterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new BrandFilterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new BrandFilterNotFoundException(
					"The " + this.getTableName() + "(" + brandFilterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String brandFilterId, int version) throws Exception{
	
		String methodName="delete(String brandFilterId, int version)";
		assertMethodArgumentNotNull(brandFilterId, methodName, "brandFilterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{brandFilterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(brandFilterId,version);
		}
		
	
	}
	
	
	
	
	

	public BrandFilter disconnectFromAll(String brandFilterId, int version) throws Exception{
	
		
		BrandFilter brandFilter = loadInternalBrandFilter(BrandFilterTable.withId(brandFilterId), emptyOptions());
		brandFilter.clearFromAll();
		this.saveBrandFilter(brandFilter);
		return brandFilter;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return BrandFilterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "brand_filter";
	}
	@Override
	protected String getBeanName() {
		
		return "brandFilter";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return BrandFilterTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, BrandFilterTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, BrandFilterTokens.PROFILE);
 	}
 	

 	
 
		

	

	protected BrandFilterMapper getBrandFilterMapper(){
		return new BrandFilterMapper();
	}

	
	
	protected BrandFilter extractBrandFilter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			BrandFilter brandFilter = loadSingleObject(accessKey, getBrandFilterMapper());
			return brandFilter;
		}catch(EmptyResultDataAccessException e){
			throw new BrandFilterNotFoundException("BrandFilter("+accessKey+") is not found!");
		}

	}

	
	

	protected BrandFilter loadInternalBrandFilter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		BrandFilter brandFilter = extractBrandFilter(accessKey, loadOptions);
 	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(brandFilter, loadOptions);
 		}
 
		
		return brandFilter;
		
	}

	 

 	protected BrandFilter extractProfile(BrandFilter brandFilter, Map<String,Object> options) throws Exception{

		if(brandFilter.getProfile() == null){
			return brandFilter;
		}
		String profileId = brandFilter.getProfile().getId();
		if( profileId == null){
			return brandFilter;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			brandFilter.setProfile(profile);
		}
		
 		
 		return brandFilter;
 	}
 		
 
		
		
  	
 	public SmartList<BrandFilter> findBrandFilterByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<BrandFilter> resultList = queryWith(BrandFilterTable.COLUMN_PROFILE, profileId, options, getBrandFilterMapper());
		// analyzeBrandFilterByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<BrandFilter> findBrandFilterByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<BrandFilter> resultList =  queryWithRange(BrandFilterTable.COLUMN_PROFILE, profileId, options, getBrandFilterMapper(), start, count);
 		//analyzeBrandFilterByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeBrandFilterByProfile(SmartList<BrandFilter> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countBrandFilterByProfile(String profileId,Map<String,Object> options){

 		return countWith(BrandFilterTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countBrandFilterByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(BrandFilterTable.COLUMN_PROFILE, ids, options);
	}
 	
 	
		
		
		

	

	protected BrandFilter saveBrandFilter(BrandFilter  brandFilter){
		
		if(!brandFilter.isChanged()){
			return brandFilter;
		}
		
		
		String SQL=this.getSaveBrandFilterSQL(brandFilter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveBrandFilterParameters(brandFilter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		brandFilter.incVersion();
		return brandFilter;
	
	}
	public SmartList<BrandFilter> saveBrandFilterList(SmartList<BrandFilter> brandFilterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitBrandFilterList(brandFilterList);
		
		batchBrandFilterCreate((List<BrandFilter>)lists[CREATE_LIST_INDEX]);
		
		batchBrandFilterUpdate((List<BrandFilter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(BrandFilter brandFilter:brandFilterList){
			if(brandFilter.isChanged()){
				brandFilter.incVersion();
			}
			
		
		}
		
		
		return brandFilterList;
	}

	public SmartList<BrandFilter> removeBrandFilterList(SmartList<BrandFilter> brandFilterList,Map<String,Object> options){
		
		
		super.removeList(brandFilterList, options);
		
		return brandFilterList;
		
		
	}
	
	protected List<Object[]> prepareBrandFilterBatchCreateArgs(List<BrandFilter> brandFilterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(BrandFilter brandFilter:brandFilterList ){
			Object [] parameters = prepareBrandFilterCreateParameters(brandFilter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBrandFilterBatchUpdateArgs(List<BrandFilter> brandFilterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(BrandFilter brandFilter:brandFilterList ){
			if(!brandFilter.isChanged()){
				continue;
			}
			Object [] parameters = prepareBrandFilterUpdateParameters(brandFilter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchBrandFilterCreate(List<BrandFilter> brandFilterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBrandFilterBatchCreateArgs(brandFilterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchBrandFilterUpdate(List<BrandFilter> brandFilterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBrandFilterBatchUpdateArgs(brandFilterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitBrandFilterList(List<BrandFilter> brandFilterList){
		
		List<BrandFilter> brandFilterCreateList=new ArrayList<BrandFilter>();
		List<BrandFilter> brandFilterUpdateList=new ArrayList<BrandFilter>();
		
		for(BrandFilter brandFilter: brandFilterList){
			if(isUpdateRequest(brandFilter)){
				brandFilterUpdateList.add( brandFilter);
				continue;
			}
			brandFilterCreateList.add(brandFilter);
		}
		
		return new Object[]{brandFilterCreateList,brandFilterUpdateList};
	}
	
	protected boolean isUpdateRequest(BrandFilter brandFilter){
 		return brandFilter.getVersion() > 0;
 	}
 	protected String getSaveBrandFilterSQL(BrandFilter brandFilter){
 		if(isUpdateRequest(brandFilter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveBrandFilterParameters(BrandFilter brandFilter){
 		if(isUpdateRequest(brandFilter) ){
 			return prepareBrandFilterUpdateParameters(brandFilter);
 		}
 		return prepareBrandFilterCreateParameters(brandFilter);
 	}
 	protected Object[] prepareBrandFilterUpdateParameters(BrandFilter brandFilter){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = brandFilter.getName();
 		parameters[1] = brandFilter.getInternalId(); 	
 		if(brandFilter.getProfile() != null){
 			parameters[2] = brandFilter.getProfile().getId();
 		}
 		
 		parameters[3] = brandFilter.nextVersion();
 		parameters[4] = brandFilter.getId();
 		parameters[5] = brandFilter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareBrandFilterCreateParameters(BrandFilter brandFilter){
		Object[] parameters = new Object[4];
		String newBrandFilterId=getNextId();
		brandFilter.setId(newBrandFilterId);
		parameters[0] =  brandFilter.getId();
 
 		parameters[1] = brandFilter.getName();
 		parameters[2] = brandFilter.getInternalId(); 	
 		if(brandFilter.getProfile() != null){
 			parameters[3] = brandFilter.getProfile().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected BrandFilter saveInternalBrandFilter(BrandFilter brandFilter, Map<String,Object> options){
		
		saveBrandFilter(brandFilter);
 	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(brandFilter, options);
 		}
 
		
		return brandFilter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected BrandFilter saveProfile(BrandFilter brandFilter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(brandFilter.getProfile() == null){
 			return brandFilter;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(brandFilter.getProfile(),options);
 		return brandFilter;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public BrandFilter present(BrandFilter brandFilter,Map<String, Object> options){
	

		return brandFilter;
	
	}
		

	

	protected String getTableName(){
		return BrandFilterTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<BrandFilter> brandFilterList) {		
		this.enhanceListInternal(brandFilterList, this.getBrandFilterMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<BrandFilter> brandFilterList = ownerEntity.collectRefsWithType(BrandFilter.INTERNAL_TYPE);
		this.enhanceList(brandFilterList);
		
	}
	
	@Override
	public SmartList<BrandFilter> findBrandFilterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getBrandFilterMapper());

	}
	@Override
	public int countBrandFilterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countBrandFilterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<BrandFilter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getBrandFilterMapper());
	}
}


