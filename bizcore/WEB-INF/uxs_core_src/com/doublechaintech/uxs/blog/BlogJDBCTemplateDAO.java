
package com.doublechaintech.uxs.blog;

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
import com.doublechaintech.uxs.profile.Profile;

import com.doublechaintech.uxs.product.ProductDAO;
import com.doublechaintech.uxs.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class BlogJDBCTemplateDAO extends UxsNamingServiceDAO implements BlogDAO{
 
 	
 	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO productDAO){
	 	this.productDAO = productDAO;
 	}
 	public ProductDAO getProductDAO(){
	 	return this.productDAO;
 	}
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}


			
		

	
	/*
	protected Blog load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalBlog(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Blog load(String id,Map<String,Object> options) throws Exception{
		return loadInternalBlog(BlogTable.withId(id), options);
	}
	
	
	
	public Blog save(Blog blog,Map<String,Object> options){
		
		String methodName="save(Blog blog,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(blog, methodName, "blog");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalBlog(blog,options);
	}
	public Blog clone(String blogId, Map<String,Object> options) throws Exception{
	
		return clone(BlogTable.withId(blogId),options);
	}
	
	protected Blog clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String blogId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Blog newBlog = loadInternalBlog(accessKey, options);
		newBlog.setVersion(0);
		
		

		
		saveInternalBlog(newBlog,options);
		
		return newBlog;
	}
	
	
	
	

	protected void throwIfHasException(String blogId,int version,int count) throws Exception{
		if (count == 1) {
			throw new BlogVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new BlogNotFoundException(
					"The " + this.getTableName() + "(" + blogId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String blogId, int version) throws Exception{
	
		String methodName="delete(String blogId, int version)";
		assertMethodArgumentNotNull(blogId, methodName, "blogId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{blogId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(blogId,version);
		}
		
	
	}
	
	
	
	
	

	public Blog disconnectFromAll(String blogId, int version) throws Exception{
	
		
		Blog blog = loadInternalBlog(BlogTable.withId(blogId), emptyOptions());
		blog.clearFromAll();
		this.saveBlog(blog);
		return blog;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return BlogTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "blog";
	}
	@Override
	protected String getBeanName() {
		
		return "blog";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return BlogTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, BlogTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, BlogTokens.USER);
 	}
 	

 	
  

 	protected boolean isExtractProductEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, BlogTokens.PRODUCT);
 	}

 	protected boolean isSaveProductEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, BlogTokens.PRODUCT);
 	}
 	

 	
 
		

	

	protected BlogMapper getBlogMapper(){
		return new BlogMapper();
	}

	
	
	protected Blog extractBlog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Blog blog = loadSingleObject(accessKey, getBlogMapper());
			return blog;
		}catch(EmptyResultDataAccessException e){
			throw new BlogNotFoundException("Blog("+accessKey+") is not found!");
		}

	}

	
	

	protected Blog loadInternalBlog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Blog blog = extractBlog(accessKey, loadOptions);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(blog, loadOptions);
 		}
  	
 		if(isExtractProductEnabled(loadOptions)){
	 		extractProduct(blog, loadOptions);
 		}
 
		
		return blog;
		
	}

	 

 	protected Blog extractUser(Blog blog, Map<String,Object> options) throws Exception{

		if(blog.getUser() == null){
			return blog;
		}
		String userId = blog.getUser().getId();
		if( userId == null){
			return blog;
		}
		Profile user = getProfileDAO().load(userId,options);
		if(user != null){
			blog.setUser(user);
		}
		
 		
 		return blog;
 	}
 		
  

 	protected Blog extractProduct(Blog blog, Map<String,Object> options) throws Exception{

		if(blog.getProduct() == null){
			return blog;
		}
		String productId = blog.getProduct().getId();
		if( productId == null){
			return blog;
		}
		Product product = getProductDAO().load(productId,options);
		if(product != null){
			blog.setProduct(product);
		}
		
 		
 		return blog;
 	}
 		
 
		
		
  	
 	public SmartList<Blog> findBlogByUser(String profileId,Map<String,Object> options){
 	
  		SmartList<Blog> resultList = queryWith(BlogTable.COLUMN_USER, profileId, options, getBlogMapper());
		// analyzeBlogByUser(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Blog> findBlogByUser(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Blog> resultList =  queryWithRange(BlogTable.COLUMN_USER, profileId, options, getBlogMapper(), start, count);
 		//analyzeBlogByUser(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeBlogByUser(SmartList<Blog> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Blog.USER_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Blog.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Blog");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Blog.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Blog.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countBlogByUser(String profileId,Map<String,Object> options){

 		return countWith(BlogTable.COLUMN_USER, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countBlogByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(BlogTable.COLUMN_USER, ids, options);
	}
 	
  	
 	public SmartList<Blog> findBlogByProduct(String productId,Map<String,Object> options){
 	
  		SmartList<Blog> resultList = queryWith(BlogTable.COLUMN_PRODUCT, productId, options, getBlogMapper());
		// analyzeBlogByProduct(resultList, productId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Blog> findBlogByProduct(String productId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Blog> resultList =  queryWithRange(BlogTable.COLUMN_PRODUCT, productId, options, getBlogMapper(), start, count);
 		//analyzeBlogByProduct(resultList, productId, options);
 		return resultList;
 		
 	}
 	public void analyzeBlogByProduct(SmartList<Blog> resultList, String productId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Blog.PRODUCT_PROPERTY, productId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem updateTimeStatsItem = new StatsItem();
		//Blog.UPDATE_TIME_PROPERTY
		updateTimeStatsItem.setDisplayName("Blog");
		updateTimeStatsItem.setInternalName(formatKeyForDateLine(Blog.UPDATE_TIME_PROPERTY));
		updateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Blog.UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(updateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countBlogByProduct(String productId,Map<String,Object> options){

 		return countWith(BlogTable.COLUMN_PRODUCT, productId, options);
 	}
 	@Override
	public Map<String, Integer> countBlogByProductIds(String[] ids, Map<String, Object> options) {
		return countWithIds(BlogTable.COLUMN_PRODUCT, ids, options);
	}
 	
 	
		
		
		

	

	protected Blog saveBlog(Blog  blog){
		
		if(!blog.isChanged()){
			return blog;
		}
		
		
		String SQL=this.getSaveBlogSQL(blog);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveBlogParameters(blog);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		blog.incVersion();
		return blog;
	
	}
	public SmartList<Blog> saveBlogList(SmartList<Blog> blogList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitBlogList(blogList);
		
		batchBlogCreate((List<Blog>)lists[CREATE_LIST_INDEX]);
		
		batchBlogUpdate((List<Blog>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Blog blog:blogList){
			if(blog.isChanged()){
				blog.incVersion();
			}
			
		
		}
		
		
		return blogList;
	}

	public SmartList<Blog> removeBlogList(SmartList<Blog> blogList,Map<String,Object> options){
		
		
		super.removeList(blogList, options);
		
		return blogList;
		
		
	}
	
	protected List<Object[]> prepareBlogBatchCreateArgs(List<Blog> blogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Blog blog:blogList ){
			Object [] parameters = prepareBlogCreateParameters(blog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBlogBatchUpdateArgs(List<Blog> blogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Blog blog:blogList ){
			if(!blog.isChanged()){
				continue;
			}
			Object [] parameters = prepareBlogUpdateParameters(blog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchBlogCreate(List<Blog> blogList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBlogBatchCreateArgs(blogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchBlogUpdate(List<Blog> blogList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBlogBatchUpdateArgs(blogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitBlogList(List<Blog> blogList){
		
		List<Blog> blogCreateList=new ArrayList<Blog>();
		List<Blog> blogUpdateList=new ArrayList<Blog>();
		
		for(Blog blog: blogList){
			if(isUpdateRequest(blog)){
				blogUpdateList.add( blog);
				continue;
			}
			blogCreateList.add(blog);
		}
		
		return new Object[]{blogCreateList,blogUpdateList};
	}
	
	protected boolean isUpdateRequest(Blog blog){
 		return blog.getVersion() > 0;
 	}
 	protected String getSaveBlogSQL(Blog blog){
 		if(isUpdateRequest(blog)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveBlogParameters(Blog blog){
 		if(isUpdateRequest(blog) ){
 			return prepareBlogUpdateParameters(blog);
 		}
 		return prepareBlogCreateParameters(blog);
 	}
 	protected Object[] prepareBlogUpdateParameters(Blog blog){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = blog.getTitle();
 		parameters[1] = blog.getContent(); 	
 		if(blog.getUser() != null){
 			parameters[2] = blog.getUser().getId();
 		}
  	
 		if(blog.getProduct() != null){
 			parameters[3] = blog.getProduct().getId();
 		}
 
 		parameters[4] = blog.getUpdateTime();		
 		parameters[5] = blog.nextVersion();
 		parameters[6] = blog.getId();
 		parameters[7] = blog.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareBlogCreateParameters(Blog blog){
		Object[] parameters = new Object[6];
		String newBlogId=getNextId();
		blog.setId(newBlogId);
		parameters[0] =  blog.getId();
 
 		parameters[1] = blog.getTitle();
 		parameters[2] = blog.getContent(); 	
 		if(blog.getUser() != null){
 			parameters[3] = blog.getUser().getId();
 		
 		}
 		 	
 		if(blog.getProduct() != null){
 			parameters[4] = blog.getProduct().getId();
 		
 		}
 		
 		parameters[5] = blog.getUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected Blog saveInternalBlog(Blog blog, Map<String,Object> options){
		
		saveBlog(blog);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(blog, options);
 		}
  	
 		if(isSaveProductEnabled(options)){
	 		saveProduct(blog, options);
 		}
 
		
		return blog;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Blog saveUser(Blog blog, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(blog.getUser() == null){
 			return blog;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(blog.getUser(),options);
 		return blog;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Blog saveProduct(Blog blog, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(blog.getProduct() == null){
 			return blog;//do nothing when it is null
 		}
 		
 		getProductDAO().save(blog.getProduct(),options);
 		return blog;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Blog present(Blog blog,Map<String, Object> options){
	

		return blog;
	
	}
		

	

	protected String getTableName(){
		return BlogTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Blog> blogList) {		
		this.enhanceListInternal(blogList, this.getBlogMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Blog> blogList = ownerEntity.collectRefsWithType(Blog.INTERNAL_TYPE);
		this.enhanceList(blogList);
		
	}
	
	@Override
	public SmartList<Blog> findBlogWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getBlogMapper());

	}
	@Override
	public int countBlogWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countBlogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Blog> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getBlogMapper());
	}
}


