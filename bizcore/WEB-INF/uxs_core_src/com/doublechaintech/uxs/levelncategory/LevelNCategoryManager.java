
package com.doublechaintech.uxs.levelncategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface LevelNCategoryManager{

		

	public LevelNCategory createLevelNCategory(UxsUserContext userContext, String parentCategoryId, String name) throws Exception;	
	public LevelNCategory updateLevelNCategory(UxsUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelNCategory loadLevelNCategory(UxsUserContext userContext, String levelNCategoryId, String [] tokensExpr) throws Exception;
	public LevelNCategory internalSaveLevelNCategory(UxsUserContext userContext, LevelNCategory levelNCategory) throws Exception;
	public LevelNCategory internalSaveLevelNCategory(UxsUserContext userContext, LevelNCategory levelNCategory,Map<String,Object>option) throws Exception;
	
	public LevelNCategory transferToAnotherParentCategory(UxsUserContext userContext, String levelNCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String levelNCategoryId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, LevelNCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductManager getProductManager(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeProduct(UxsUserContext userContext, String levelNCategoryId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateProduct(UxsUserContext userContext, String levelNCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addNewProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeNewProduct(UxsUserContext userContext, String levelNCategoryId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateNewProduct(UxsUserContext userContext, String levelNCategoryId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateEditorPickProduct(UxsUserContext userContext, String levelNCategoryId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateTopRatedProduct(UxsUserContext userContext, String levelNCategoryId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addRecommandProduct(UxsUserContext userContext, String levelNCategoryId, String name, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeRecommandProduct(UxsUserContext userContext, String levelNCategoryId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateRecommandProduct(UxsUserContext userContext, String levelNCategoryId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


