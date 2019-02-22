
package com.doublechaintech.uxs.levelonecategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface LevelOneCategoryManager{

		

	public LevelOneCategory createLevelOneCategory(UxsUserContext userContext, String catalogId, String name) throws Exception;	
	public LevelOneCategory updateLevelOneCategory(UxsUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelOneCategory loadLevelOneCategory(UxsUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(UxsUserContext userContext, LevelOneCategory levelOneCategory) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(UxsUserContext userContext, LevelOneCategory levelOneCategory,Map<String,Object>option) throws Exception;
	
	public LevelOneCategory transferToAnotherCatalog(UxsUserContext userContext, String levelOneCategoryId, String anotherCatalogId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String levelOneCategoryId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, LevelOneCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelTwoCategoryManager getLevelTwoCategoryManager(UxsUserContext userContext, String levelOneCategoryId, String name ,String [] tokensExpr)  throws Exception;
	
	public  LevelOneCategory addLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelOneCategory removeLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneCategory updateLevelTwoCategory(UxsUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


