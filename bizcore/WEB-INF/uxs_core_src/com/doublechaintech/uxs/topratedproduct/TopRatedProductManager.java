
package com.doublechaintech.uxs.topratedproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface TopRatedProductManager{

		

	public TopRatedProduct createTopRatedProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception;	
	public TopRatedProduct updateTopRatedProduct(UxsUserContext userContext,String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TopRatedProduct loadTopRatedProduct(UxsUserContext userContext, String topRatedProductId, String [] tokensExpr) throws Exception;
	public TopRatedProduct internalSaveTopRatedProduct(UxsUserContext userContext, TopRatedProduct topRatedProduct) throws Exception;
	public TopRatedProduct internalSaveTopRatedProduct(UxsUserContext userContext, TopRatedProduct topRatedProduct,Map<String,Object>option) throws Exception;
	
	public TopRatedProduct transferToAnotherParentCategory(UxsUserContext userContext, String topRatedProductId, String anotherParentCategoryId)  throws Exception;
 	public TopRatedProduct transferToAnotherBrand(UxsUserContext userContext, String topRatedProductId, String anotherBrandId)  throws Exception;
 	public TopRatedProduct transferToAnotherCatalog(UxsUserContext userContext, String topRatedProductId, String anotherCatalogId)  throws Exception;
 	public TopRatedProduct transferToAnotherProfile(UxsUserContext userContext, String topRatedProductId, String anotherProfileId)  throws Exception;
 	public TopRatedProduct transferToAnotherPlatform(UxsUserContext userContext, String topRatedProductId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String topRatedProductId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, TopRatedProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


