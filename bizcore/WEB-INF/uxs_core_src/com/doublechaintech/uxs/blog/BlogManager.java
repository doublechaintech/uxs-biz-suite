
package com.doublechaintech.uxs.blog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface BlogManager{

		

	public Blog createBlog(UxsUserContext userContext, String title, String content, String userId, String productId) throws Exception;	
	public Blog updateBlog(UxsUserContext userContext,String blogId, int blogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Blog loadBlog(UxsUserContext userContext, String blogId, String [] tokensExpr) throws Exception;
	public Blog internalSaveBlog(UxsUserContext userContext, Blog blog) throws Exception;
	public Blog internalSaveBlog(UxsUserContext userContext, Blog blog,Map<String,Object>option) throws Exception;
	
	public Blog transferToAnotherUser(UxsUserContext userContext, String blogId, String anotherUserId)  throws Exception;
 	public Blog transferToAnotherProduct(UxsUserContext userContext, String blogId, String anotherProductId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String blogId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Blog newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


