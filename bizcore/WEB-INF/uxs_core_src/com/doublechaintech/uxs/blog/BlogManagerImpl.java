
package com.doublechaintech.uxs.blog;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;


import com.doublechaintech.uxs.Message;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;

import com.doublechaintech.uxs.UxsUserContext;
//import com.doublechaintech.uxs.BaseManagerImpl;
import com.doublechaintech.uxs.UxsCheckerManager;
import com.doublechaintech.uxs.CustomUxsCheckerManager;

import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.profile.Profile;

import com.doublechaintech.uxs.product.CandidateProduct;
import com.doublechaintech.uxs.profile.CandidateProfile;







public class BlogManagerImpl extends CustomUxsCheckerManager implements BlogManager {
	
	private static final String SERVICE_TYPE = "Blog";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws BlogManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new BlogManagerException(message);

	}
	
	

 	protected Blog saveBlog(UxsUserContext userContext, Blog blog, String [] tokensExpr) throws Exception{	
 		//return getBlogDAO().save(blog, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveBlog(userContext, blog, tokens);
 	}
 	
 	protected Blog saveBlogDetail(UxsUserContext userContext, Blog blog) throws Exception{	

 		
 		return saveBlog(userContext, blog, allTokens());
 	}
 	
 	public Blog loadBlog(UxsUserContext userContext, String blogId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().throwExceptionIfHasErrors( BlogManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Blog blog = loadBlog( userContext, blogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,blog, tokens);
 	}
 	
 	
 	 public Blog searchBlog(UxsUserContext userContext, String blogId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().throwExceptionIfHasErrors( BlogManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Blog blog = loadBlog( userContext, blogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,blog, tokens);
 	}
 	
 	

 	protected Blog present(UxsUserContext userContext, Blog blog, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,blog,tokens);
		
		
		Blog  blogToPresent = userContext.getDAOGroup().getBlogDAO().present(blog, tokens);
		
		List<BaseEntity> entityListToNaming = blogToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getBlogDAO().alias(entityListToNaming);
		
		return  blogToPresent;
		
		
	}
 
 	
 	
 	public Blog loadBlogDetail(UxsUserContext userContext, String blogId) throws Exception{	
 		Blog blog = loadBlog( userContext, blogId, allTokens());
 		return present(userContext,blog, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String blogId) throws Exception{	
 		Blog blog = loadBlog( userContext, blogId, viewTokens());
 		return present(userContext,blog, allTokens());
		
 	}
 	protected Blog saveBlog(UxsUserContext userContext, Blog blog, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getBlogDAO().save(blog, tokens);
 	}
 	protected Blog loadBlog(UxsUserContext userContext, String blogId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().throwExceptionIfHasErrors( BlogManagerException.class);

 
 		return userContext.getDAOGroup().getBlogDAO().load(blogId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Blog blog, Map<String, Object> tokens){
		super.addActions(userContext, blog, tokens);
		
		addAction(userContext, blog, tokens,"@create","createBlog","createBlog/","main","primary");
		addAction(userContext, blog, tokens,"@update","updateBlog","updateBlog/"+blog.getId()+"/","main","primary");
		addAction(userContext, blog, tokens,"@copy","cloneBlog","cloneBlog/"+blog.getId()+"/","main","primary");
		
		addAction(userContext, blog, tokens,"blog.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+blog.getId()+"/","main","primary");
		addAction(userContext, blog, tokens,"blog.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+blog.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Blog blog, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Blog createBlog(UxsUserContext userContext,String title, String content, String userId, String productId) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfBlog(title);
		userContext.getChecker().checkContentOfBlog(content);
	
		userContext.getChecker().throwExceptionIfHasErrors(BlogManagerException.class);


		Blog blog=createNewBlog();	

		blog.setTitle(title);
		blog.setContent(content);
			
		Profile user = loadProfile(userContext, userId,emptyOptions());
		blog.setUser(user);
		
		
			
		Product product = loadProduct(userContext, productId,emptyOptions());
		blog.setProduct(product);
		
		
		blog.setUpdateTime(userContext.now());

		blog = saveBlog(userContext, blog, emptyOptions());
		
		onNewInstanceCreated(userContext, blog);
		return blog;

		
	}
	protected Blog createNewBlog() 
	{
		
		return new Blog();		
	}
	
	protected void checkParamsForUpdatingBlog(UxsUserContext userContext,String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfBlog(blogId);
		userContext.getChecker().checkVersionOfBlog( blogVersion);
		

		if(Blog.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfBlog(parseString(newValueExpr));
		}
		if(Blog.CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkContentOfBlog(parseString(newValueExpr));
		}		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(BlogManagerException.class);
	
		
	}
	
	
	
	public Blog clone(UxsUserContext userContext, String fromBlogId) throws Exception{
		
		return userContext.getDAOGroup().getBlogDAO().clone(fromBlogId, this.allTokens());
	}
	
	public Blog internalSaveBlog(UxsUserContext userContext, Blog blog) throws Exception 
	{
		return internalSaveBlog(userContext, blog, allTokens());

	}
	public Blog internalSaveBlog(UxsUserContext userContext, Blog blog, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingBlog(userContext, blogId, blogVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(blog){ 
			//will be good when the blog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Blog.
			
			
			blog = saveBlog(userContext, blog, options);
			return blog;
			
		}

	}
	
	public Blog updateBlog(UxsUserContext userContext,String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBlog(userContext, blogId, blogVersion, property, newValueExpr, tokensExpr);
		
		
		
		Blog blog = loadBlog(userContext, blogId, allTokens());
		if(blog.getVersion() != blogVersion){
			String message = "The target version("+blog.getVersion()+") is not equals to version("+blogVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(blog){ 
			//will be good when the blog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Blog.
			blog.updateUpdateTime(userContext.now());
			blog.changeProperty(property, newValueExpr);
			blog = saveBlog(userContext, blog, tokens().done());
			return present(userContext,blog, mergedAllTokens(tokensExpr));
			//return saveBlog(userContext, blog, tokens().done());
		}

	}
	
	public Blog updateBlogProperty(UxsUserContext userContext,String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBlog(userContext, blogId, blogVersion, property, newValueExpr, tokensExpr);
		
		Blog blog = loadBlog(userContext, blogId, allTokens());
		if(blog.getVersion() != blogVersion){
			String message = "The target version("+blog.getVersion()+") is not equals to version("+blogVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(blog){ 
			//will be good when the blog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Blog.
			
			blog.changeProperty(property, newValueExpr);
			blog.updateUpdateTime(userContext.now());
			blog = saveBlog(userContext, blog, tokens().done());
			return present(userContext,blog, mergedAllTokens(tokensExpr));
			//return saveBlog(userContext, blog, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected BlogTokens tokens(){
		return BlogTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return BlogTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return BlogTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUser(UxsUserContext userContext, String blogId, String anotherUserId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfBlog(blogId);
 		userContext.getChecker().checkIdOfProfile(anotherUserId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(BlogManagerException.class);
 		
 	}
 	public Blog transferToAnotherUser(UxsUserContext userContext, String blogId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, blogId,anotherUserId);
 
		Blog blog = loadBlog(userContext, blogId, allTokens());	
		synchronized(blog){
			//will be good when the blog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile user = loadProfile(userContext, anotherUserId, emptyOptions());		
			blog.updateUser(user);		
			blog = saveBlog(userContext, blog, emptyOptions());
			
			return present(userContext,blog, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidateUser(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfile result = new CandidateProfile();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForBlog(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProduct(UxsUserContext userContext, String blogId, String anotherProductId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfBlog(blogId);
 		userContext.getChecker().checkIdOfProduct(anotherProductId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(BlogManagerException.class);
 		
 	}
 	public Blog transferToAnotherProduct(UxsUserContext userContext, String blogId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, blogId,anotherProductId);
 
		Blog blog = loadBlog(userContext, blogId, allTokens());	
		synchronized(blog){
			//will be good when the blog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(userContext, anotherProductId, emptyOptions());		
			blog.updateProduct(product);		
			blog = saveBlog(userContext, blog, emptyOptions());
			
			return present(userContext,blog, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProduct requestCandidateProduct(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProduct result = new CandidateProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Product> candidateList = userContext.getDAOGroup().getProductDAO().requestCandidateProductForBlog(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Product loadProduct(UxsUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProductDAO().load(newProductId, options);
 	}
 	
 	
 	
	
	 	
 	protected Profile loadProfile(UxsUserContext userContext, String newUserId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newUserId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String blogId, int blogVersion) throws Exception {
		//deleteInternal(userContext, blogId, blogVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String blogId, int blogVersion) throws Exception{
			
		userContext.getDAOGroup().getBlogDAO().delete(blogId, blogVersion);
	}
	
	public Blog forgetByAll(UxsUserContext userContext, String blogId, int blogVersion) throws Exception {
		return forgetByAllInternal(userContext, blogId, blogVersion);		
	}
	protected Blog forgetByAllInternal(UxsUserContext userContext,
			String blogId, int blogVersion) throws Exception{
			
		return userContext.getDAOGroup().getBlogDAO().disconnectFromAll(blogId, blogVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new BlogManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getBlogDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(UxsUserContext userContext, Blog newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


