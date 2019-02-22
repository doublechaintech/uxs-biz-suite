
package com.doublechaintech.uxs.leveltwocategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface LevelTwoCategoryManager{

		

	public LevelTwoCategory createLevelTwoCategory(UxsUserContext userContext, String parentCategoryId, String name) throws Exception;	
	public LevelTwoCategory updateLevelTwoCategory(UxsUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelTwoCategory loadLevelTwoCategory(UxsUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(UxsUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(UxsUserContext userContext, LevelTwoCategory levelTwoCategory,Map<String,Object>option) throws Exception;
	
	public LevelTwoCategory transferToAnotherParentCategory(UxsUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, LevelTwoCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelNCategoryManager getLevelNCategoryManager(UxsUserContext userContext, String levelTwoCategoryId, String name ,String [] tokensExpr)  throws Exception;
	
	public  LevelTwoCategory addLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory removeLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, String levelNCategoryId, int levelNCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory updateLevelNCategory(UxsUserContext userContext, String levelTwoCategoryId, String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


