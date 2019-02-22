
package com.doublechaintech.uxs.pricefilter;

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

public class PriceFilterJDBCTemplateDAO extends UxsNamingServiceDAO implements PriceFilterDAO{
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}


			
		

	
	/*
	protected PriceFilter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPriceFilter(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public PriceFilter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPriceFilter(PriceFilterTable.withId(id), options);
	}
	
	
	
	public PriceFilter save(PriceFilter priceFilter,Map<String,Object> options){
		
		String methodName="save(PriceFilter priceFilter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(priceFilter, methodName, "priceFilter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPriceFilter(priceFilter,options);
	}
	public PriceFilter clone(String priceFilterId, Map<String,Object> options) throws Exception{
	
		return clone(PriceFilterTable.withId(priceFilterId),options);
	}
	
	protected PriceFilter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String priceFilterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PriceFilter newPriceFilter = loadInternalPriceFilter(accessKey, options);
		newPriceFilter.setVersion(0);
		
		

		
		saveInternalPriceFilter(newPriceFilter,options);
		
		return newPriceFilter;
	}
	
	
	
	

	protected void throwIfHasException(String priceFilterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PriceFilterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PriceFilterNotFoundException(
					"The " + this.getTableName() + "(" + priceFilterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String priceFilterId, int version) throws Exception{
	
		String methodName="delete(String priceFilterId, int version)";
		assertMethodArgumentNotNull(priceFilterId, methodName, "priceFilterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{priceFilterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(priceFilterId,version);
		}
		
	
	}
	
	
	
	
	

	public PriceFilter disconnectFromAll(String priceFilterId, int version) throws Exception{
	
		
		PriceFilter priceFilter = loadInternalPriceFilter(PriceFilterTable.withId(priceFilterId), emptyOptions());
		priceFilter.clearFromAll();
		this.savePriceFilter(priceFilter);
		return priceFilter;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PriceFilterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "price_filter";
	}
	@Override
	protected String getBeanName() {
		
		return "priceFilter";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PriceFilterTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PriceFilterTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PriceFilterTokens.PROFILE);
 	}
 	

 	
 
		

	

	protected PriceFilterMapper getPriceFilterMapper(){
		return new PriceFilterMapper();
	}

	
	
	protected PriceFilter extractPriceFilter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			PriceFilter priceFilter = loadSingleObject(accessKey, getPriceFilterMapper());
			return priceFilter;
		}catch(EmptyResultDataAccessException e){
			throw new PriceFilterNotFoundException("PriceFilter("+accessKey+") is not found!");
		}

	}

	
	

	protected PriceFilter loadInternalPriceFilter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PriceFilter priceFilter = extractPriceFilter(accessKey, loadOptions);
 	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(priceFilter, loadOptions);
 		}
 
		
		return priceFilter;
		
	}

	 

 	protected PriceFilter extractProfile(PriceFilter priceFilter, Map<String,Object> options) throws Exception{

		if(priceFilter.getProfile() == null){
			return priceFilter;
		}
		String profileId = priceFilter.getProfile().getId();
		if( profileId == null){
			return priceFilter;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			priceFilter.setProfile(profile);
		}
		
 		
 		return priceFilter;
 	}
 		
 
		
		
  	
 	public SmartList<PriceFilter> findPriceFilterByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<PriceFilter> resultList = queryWith(PriceFilterTable.COLUMN_PROFILE, profileId, options, getPriceFilterMapper());
		// analyzePriceFilterByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PriceFilter> findPriceFilterByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PriceFilter> resultList =  queryWithRange(PriceFilterTable.COLUMN_PROFILE, profileId, options, getPriceFilterMapper(), start, count);
 		//analyzePriceFilterByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzePriceFilterByProfile(SmartList<PriceFilter> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countPriceFilterByProfile(String profileId,Map<String,Object> options){

 		return countWith(PriceFilterTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countPriceFilterByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PriceFilterTable.COLUMN_PROFILE, ids, options);
	}
 	
 	
		
		
		

	

	protected PriceFilter savePriceFilter(PriceFilter  priceFilter){
		
		if(!priceFilter.isChanged()){
			return priceFilter;
		}
		
		
		String SQL=this.getSavePriceFilterSQL(priceFilter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePriceFilterParameters(priceFilter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		priceFilter.incVersion();
		return priceFilter;
	
	}
	public SmartList<PriceFilter> savePriceFilterList(SmartList<PriceFilter> priceFilterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPriceFilterList(priceFilterList);
		
		batchPriceFilterCreate((List<PriceFilter>)lists[CREATE_LIST_INDEX]);
		
		batchPriceFilterUpdate((List<PriceFilter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PriceFilter priceFilter:priceFilterList){
			if(priceFilter.isChanged()){
				priceFilter.incVersion();
			}
			
		
		}
		
		
		return priceFilterList;
	}

	public SmartList<PriceFilter> removePriceFilterList(SmartList<PriceFilter> priceFilterList,Map<String,Object> options){
		
		
		super.removeList(priceFilterList, options);
		
		return priceFilterList;
		
		
	}
	
	protected List<Object[]> preparePriceFilterBatchCreateArgs(List<PriceFilter> priceFilterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PriceFilter priceFilter:priceFilterList ){
			Object [] parameters = preparePriceFilterCreateParameters(priceFilter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePriceFilterBatchUpdateArgs(List<PriceFilter> priceFilterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PriceFilter priceFilter:priceFilterList ){
			if(!priceFilter.isChanged()){
				continue;
			}
			Object [] parameters = preparePriceFilterUpdateParameters(priceFilter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPriceFilterCreate(List<PriceFilter> priceFilterList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePriceFilterBatchCreateArgs(priceFilterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPriceFilterUpdate(List<PriceFilter> priceFilterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePriceFilterBatchUpdateArgs(priceFilterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPriceFilterList(List<PriceFilter> priceFilterList){
		
		List<PriceFilter> priceFilterCreateList=new ArrayList<PriceFilter>();
		List<PriceFilter> priceFilterUpdateList=new ArrayList<PriceFilter>();
		
		for(PriceFilter priceFilter: priceFilterList){
			if(isUpdateRequest(priceFilter)){
				priceFilterUpdateList.add( priceFilter);
				continue;
			}
			priceFilterCreateList.add(priceFilter);
		}
		
		return new Object[]{priceFilterCreateList,priceFilterUpdateList};
	}
	
	protected boolean isUpdateRequest(PriceFilter priceFilter){
 		return priceFilter.getVersion() > 0;
 	}
 	protected String getSavePriceFilterSQL(PriceFilter priceFilter){
 		if(isUpdateRequest(priceFilter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePriceFilterParameters(PriceFilter priceFilter){
 		if(isUpdateRequest(priceFilter) ){
 			return preparePriceFilterUpdateParameters(priceFilter);
 		}
 		return preparePriceFilterCreateParameters(priceFilter);
 	}
 	protected Object[] preparePriceFilterUpdateParameters(PriceFilter priceFilter){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = priceFilter.getName();
 		parameters[1] = priceFilter.getPriceStart();
 		parameters[2] = priceFilter.getPriceEnd(); 	
 		if(priceFilter.getProfile() != null){
 			parameters[3] = priceFilter.getProfile().getId();
 		}
 		
 		parameters[4] = priceFilter.nextVersion();
 		parameters[5] = priceFilter.getId();
 		parameters[6] = priceFilter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePriceFilterCreateParameters(PriceFilter priceFilter){
		Object[] parameters = new Object[5];
		String newPriceFilterId=getNextId();
		priceFilter.setId(newPriceFilterId);
		parameters[0] =  priceFilter.getId();
 
 		parameters[1] = priceFilter.getName();
 		parameters[2] = priceFilter.getPriceStart();
 		parameters[3] = priceFilter.getPriceEnd(); 	
 		if(priceFilter.getProfile() != null){
 			parameters[4] = priceFilter.getProfile().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected PriceFilter saveInternalPriceFilter(PriceFilter priceFilter, Map<String,Object> options){
		
		savePriceFilter(priceFilter);
 	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(priceFilter, options);
 		}
 
		
		return priceFilter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PriceFilter saveProfile(PriceFilter priceFilter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(priceFilter.getProfile() == null){
 			return priceFilter;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(priceFilter.getProfile(),options);
 		return priceFilter;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public PriceFilter present(PriceFilter priceFilter,Map<String, Object> options){
	

		return priceFilter;
	
	}
		

	

	protected String getTableName(){
		return PriceFilterTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<PriceFilter> priceFilterList) {		
		this.enhanceListInternal(priceFilterList, this.getPriceFilterMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<PriceFilter> priceFilterList = ownerEntity.collectRefsWithType(PriceFilter.INTERNAL_TYPE);
		this.enhanceList(priceFilterList);
		
	}
	
	@Override
	public SmartList<PriceFilter> findPriceFilterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPriceFilterMapper());

	}
	@Override
	public int countPriceFilterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPriceFilterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<PriceFilter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPriceFilterMapper());
	}
}


