
package com.doublechaintech.uxs.catalog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface CatalogManager{

		

	public Catalog createCatalog(UxsUserContext userContext, String name, String sellerId, String siteId, String platformId) throws Exception;	
	public Catalog updateCatalog(UxsUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Catalog loadCatalog(UxsUserContext userContext, String catalogId, String [] tokensExpr) throws Exception;
	public Catalog internalSaveCatalog(UxsUserContext userContext, Catalog catalog) throws Exception;
	public Catalog internalSaveCatalog(UxsUserContext userContext, Catalog catalog,Map<String,Object>option) throws Exception;
	
	public Catalog transferToAnotherSite(UxsUserContext userContext, String catalogId, String anotherSiteId)  throws Exception;
 	public Catalog transferToAnotherPlatform(UxsUserContext userContext, String catalogId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String catalogId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Catalog newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelOneCategoryManager getLevelOneCategoryManager(UxsUserContext userContext, String catalogId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addLevelOneCategory(UxsUserContext userContext, String catalogId, String name , String [] tokensExpr)  throws Exception;
	public  Catalog removeLevelOneCategory(UxsUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateLevelOneCategory(UxsUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProductManager getProductManager(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addProduct(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Catalog removeProduct(UxsUserContext userContext, String catalogId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateProduct(UxsUserContext userContext, String catalogId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addNewProduct(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Catalog removeNewProduct(UxsUserContext userContext, String catalogId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateNewProduct(UxsUserContext userContext, String catalogId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addEditorPickProduct(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Catalog removeEditorPickProduct(UxsUserContext userContext, String catalogId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateEditorPickProduct(UxsUserContext userContext, String catalogId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addTopRatedProduct(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  Catalog removeTopRatedProduct(UxsUserContext userContext, String catalogId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateTopRatedProduct(UxsUserContext userContext, String catalogId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addRecommandProduct(UxsUserContext userContext, String catalogId, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  Catalog removeRecommandProduct(UxsUserContext userContext, String catalogId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateRecommandProduct(UxsUserContext userContext, String catalogId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


