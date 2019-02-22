
package com.doublechaintech.uxs.brand;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface BrandManager{

		

	public Brand createBrand(UxsUserContext userContext, String brandName, String logo, String remark, String platformId) throws Exception;	
	public Brand updateBrand(UxsUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Brand loadBrand(UxsUserContext userContext, String brandId, String [] tokensExpr) throws Exception;
	public Brand internalSaveBrand(UxsUserContext userContext, Brand brand) throws Exception;
	public Brand internalSaveBrand(UxsUserContext userContext, Brand brand,Map<String,Object>option) throws Exception;
	
	public Brand transferToAnotherPlatform(UxsUserContext userContext, String brandId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String brandId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Brand newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductManager getProductManager(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeProduct(UxsUserContext userContext, String brandId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateProduct(UxsUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NewProductManager getNewProductManager(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addNewProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeNewProduct(UxsUserContext userContext, String brandId, String newProductId, int newProductVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateNewProduct(UxsUserContext userContext, String brandId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EditorPickProductManager getEditorPickProductManager(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addEditorPickProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeEditorPickProduct(UxsUserContext userContext, String brandId, String editorPickProductId, int editorPickProductVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateEditorPickProduct(UxsUserContext userContext, String brandId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TopRatedProductManager getTopRatedProductManager(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addTopRatedProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeTopRatedProduct(UxsUserContext userContext, String brandId, String topRatedProductId, int topRatedProductVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateTopRatedProduct(UxsUserContext userContext, String brandId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RecommandProductManager getRecommandProductManager(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Brand addRecommandProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId , String [] tokensExpr)  throws Exception;
	public  Brand removeRecommandProduct(UxsUserContext userContext, String brandId, String recommandProductId, int recommandProductVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateRecommandProduct(UxsUserContext userContext, String brandId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


