
package com.doublechaintech.uxs.useralert;

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
import com.doublechaintech.uxs.platform.Platform;

import com.doublechaintech.uxs.platform.PlatformDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class UserAlertJDBCTemplateDAO extends UxsNamingServiceDAO implements UserAlertDAO{
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected UserAlert load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUserAlert(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public UserAlert load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUserAlert(UserAlertTable.withId(id), options);
	}
	
	
	
	public UserAlert save(UserAlert userAlert,Map<String,Object> options){
		
		String methodName="save(UserAlert userAlert,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(userAlert, methodName, "userAlert");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUserAlert(userAlert,options);
	}
	public UserAlert clone(String userAlertId, Map<String,Object> options) throws Exception{
	
		return clone(UserAlertTable.withId(userAlertId),options);
	}
	
	protected UserAlert clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userAlertId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		UserAlert newUserAlert = loadInternalUserAlert(accessKey, options);
		newUserAlert.setVersion(0);
		
		

		
		saveInternalUserAlert(newUserAlert,options);
		
		return newUserAlert;
	}
	
	
	
	

	protected void throwIfHasException(String userAlertId,int version,int count) throws Exception{
		if (count == 1) {
			throw new UserAlertVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserAlertNotFoundException(
					"The " + this.getTableName() + "(" + userAlertId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String userAlertId, int version) throws Exception{
	
		String methodName="delete(String userAlertId, int version)";
		assertMethodArgumentNotNull(userAlertId, methodName, "userAlertId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userAlertId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userAlertId,version);
		}
		
	
	}
	
	
	
	
	

	public UserAlert disconnectFromAll(String userAlertId, int version) throws Exception{
	
		
		UserAlert userAlert = loadInternalUserAlert(UserAlertTable.withId(userAlertId), emptyOptions());
		userAlert.clearFromAll();
		this.saveUserAlert(userAlert);
		return userAlert;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return UserAlertTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user_alert";
	}
	@Override
	protected String getBeanName() {
		
		return "userAlert";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserAlertTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserAlertTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserAlertTokens.PROFILE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserAlertTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserAlertTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected UserAlertMapper getUserAlertMapper(){
		return new UserAlertMapper();
	}

	
	
	protected UserAlert extractUserAlert(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			UserAlert userAlert = loadSingleObject(accessKey, getUserAlertMapper());
			return userAlert;
		}catch(EmptyResultDataAccessException e){
			throw new UserAlertNotFoundException("UserAlert("+accessKey+") is not found!");
		}

	}

	
	

	protected UserAlert loadInternalUserAlert(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		UserAlert userAlert = extractUserAlert(accessKey, loadOptions);
 	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(userAlert, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(userAlert, loadOptions);
 		}
 
		
		return userAlert;
		
	}

	 

 	protected UserAlert extractProfile(UserAlert userAlert, Map<String,Object> options) throws Exception{

		if(userAlert.getProfile() == null){
			return userAlert;
		}
		String profileId = userAlert.getProfile().getId();
		if( profileId == null){
			return userAlert;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			userAlert.setProfile(profile);
		}
		
 		
 		return userAlert;
 	}
 		
  

 	protected UserAlert extractPlatform(UserAlert userAlert, Map<String,Object> options) throws Exception{

		if(userAlert.getPlatform() == null){
			return userAlert;
		}
		String platformId = userAlert.getPlatform().getId();
		if( platformId == null){
			return userAlert;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			userAlert.setPlatform(platform);
		}
		
 		
 		return userAlert;
 	}
 		
 
		
		
  	
 	public SmartList<UserAlert> findUserAlertByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<UserAlert> resultList = queryWith(UserAlertTable.COLUMN_PROFILE, profileId, options, getUserAlertMapper());
		// analyzeUserAlertByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<UserAlert> findUserAlertByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<UserAlert> resultList =  queryWithRange(UserAlertTable.COLUMN_PROFILE, profileId, options, getUserAlertMapper(), start, count);
 		//analyzeUserAlertByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserAlertByProfile(SmartList<UserAlert> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(UserAlert.PROFILE_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateStatsItem = new StatsItem();
		//UserAlert.LAST_UPDATE_PROPERTY
		lastUpdateStatsItem.setDisplayName("User Alert");
		lastUpdateStatsItem.setInternalName(formatKeyForDateLine(UserAlert.LAST_UPDATE_PROPERTY));
		lastUpdateStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(UserAlert.LAST_UPDATE_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countUserAlertByProfile(String profileId,Map<String,Object> options){

 		return countWith(UserAlertTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countUserAlertByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserAlertTable.COLUMN_PROFILE, ids, options);
	}
 	
  	
 	public SmartList<UserAlert> findUserAlertByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<UserAlert> resultList = queryWith(UserAlertTable.COLUMN_PLATFORM, platformId, options, getUserAlertMapper());
		// analyzeUserAlertByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<UserAlert> findUserAlertByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<UserAlert> resultList =  queryWithRange(UserAlertTable.COLUMN_PLATFORM, platformId, options, getUserAlertMapper(), start, count);
 		//analyzeUserAlertByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserAlertByPlatform(SmartList<UserAlert> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(UserAlert.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateStatsItem = new StatsItem();
		//UserAlert.LAST_UPDATE_PROPERTY
		lastUpdateStatsItem.setDisplayName("User Alert");
		lastUpdateStatsItem.setInternalName(formatKeyForDateLine(UserAlert.LAST_UPDATE_PROPERTY));
		lastUpdateStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(UserAlert.LAST_UPDATE_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countUserAlertByPlatform(String platformId,Map<String,Object> options){

 		return countWith(UserAlertTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countUserAlertByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserAlertTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected UserAlert saveUserAlert(UserAlert  userAlert){
		
		if(!userAlert.isChanged()){
			return userAlert;
		}
		
		
		String SQL=this.getSaveUserAlertSQL(userAlert);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserAlertParameters(userAlert);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		userAlert.incVersion();
		return userAlert;
	
	}
	public SmartList<UserAlert> saveUserAlertList(SmartList<UserAlert> userAlertList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserAlertList(userAlertList);
		
		batchUserAlertCreate((List<UserAlert>)lists[CREATE_LIST_INDEX]);
		
		batchUserAlertUpdate((List<UserAlert>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(UserAlert userAlert:userAlertList){
			if(userAlert.isChanged()){
				userAlert.incVersion();
			}
			
		
		}
		
		
		return userAlertList;
	}

	public SmartList<UserAlert> removeUserAlertList(SmartList<UserAlert> userAlertList,Map<String,Object> options){
		
		
		super.removeList(userAlertList, options);
		
		return userAlertList;
		
		
	}
	
	protected List<Object[]> prepareUserAlertBatchCreateArgs(List<UserAlert> userAlertList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserAlert userAlert:userAlertList ){
			Object [] parameters = prepareUserAlertCreateParameters(userAlert);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserAlertBatchUpdateArgs(List<UserAlert> userAlertList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserAlert userAlert:userAlertList ){
			if(!userAlert.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserAlertUpdateParameters(userAlert);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserAlertCreate(List<UserAlert> userAlertList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserAlertBatchCreateArgs(userAlertList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserAlertUpdate(List<UserAlert> userAlertList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserAlertBatchUpdateArgs(userAlertList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserAlertList(List<UserAlert> userAlertList){
		
		List<UserAlert> userAlertCreateList=new ArrayList<UserAlert>();
		List<UserAlert> userAlertUpdateList=new ArrayList<UserAlert>();
		
		for(UserAlert userAlert: userAlertList){
			if(isUpdateRequest(userAlert)){
				userAlertUpdateList.add( userAlert);
				continue;
			}
			userAlertCreateList.add(userAlert);
		}
		
		return new Object[]{userAlertCreateList,userAlertUpdateList};
	}
	
	protected boolean isUpdateRequest(UserAlert userAlert){
 		return userAlert.getVersion() > 0;
 	}
 	protected String getSaveUserAlertSQL(UserAlert userAlert){
 		if(isUpdateRequest(userAlert)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserAlertParameters(UserAlert userAlert){
 		if(isUpdateRequest(userAlert) ){
 			return prepareUserAlertUpdateParameters(userAlert);
 		}
 		return prepareUserAlertCreateParameters(userAlert);
 	}
 	protected Object[] prepareUserAlertUpdateParameters(UserAlert userAlert){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = userAlert.getMessage(); 	
 		if(userAlert.getProfile() != null){
 			parameters[1] = userAlert.getProfile().getId();
 		}
 
 		parameters[2] = userAlert.getLocation();
 		parameters[3] = userAlert.getLastUpdate(); 	
 		if(userAlert.getPlatform() != null){
 			parameters[4] = userAlert.getPlatform().getId();
 		}
 		
 		parameters[5] = userAlert.nextVersion();
 		parameters[6] = userAlert.getId();
 		parameters[7] = userAlert.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserAlertCreateParameters(UserAlert userAlert){
		Object[] parameters = new Object[6];
		String newUserAlertId=getNextId();
		userAlert.setId(newUserAlertId);
		parameters[0] =  userAlert.getId();
 
 		parameters[1] = userAlert.getMessage(); 	
 		if(userAlert.getProfile() != null){
 			parameters[2] = userAlert.getProfile().getId();
 		
 		}
 		
 		parameters[3] = userAlert.getLocation();
 		parameters[4] = userAlert.getLastUpdate(); 	
 		if(userAlert.getPlatform() != null){
 			parameters[5] = userAlert.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected UserAlert saveInternalUserAlert(UserAlert userAlert, Map<String,Object> options){
		
		saveUserAlert(userAlert);
 	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(userAlert, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(userAlert, options);
 		}
 
		
		return userAlert;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected UserAlert saveProfile(UserAlert userAlert, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userAlert.getProfile() == null){
 			return userAlert;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(userAlert.getProfile(),options);
 		return userAlert;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected UserAlert savePlatform(UserAlert userAlert, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userAlert.getPlatform() == null){
 			return userAlert;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(userAlert.getPlatform(),options);
 		return userAlert;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public UserAlert present(UserAlert userAlert,Map<String, Object> options){
	

		return userAlert;
	
	}
		

	

	protected String getTableName(){
		return UserAlertTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<UserAlert> userAlertList) {		
		this.enhanceListInternal(userAlertList, this.getUserAlertMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<UserAlert> userAlertList = ownerEntity.collectRefsWithType(UserAlert.INTERNAL_TYPE);
		this.enhanceList(userAlertList);
		
	}
	
	@Override
	public SmartList<UserAlert> findUserAlertWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getUserAlertMapper());

	}
	@Override
	public int countUserAlertWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countUserAlertWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<UserAlert> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getUserAlertMapper());
	}
}


