
package com.doublechaintech.uxs.newproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface NewProductManager{

		

	public NewProduct createNewProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception;	
	public NewProduct updateNewProduct(UxsUserContext userContext,String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public NewProduct loadNewProduct(UxsUserContext userContext, String newProductId, String [] tokensExpr) throws Exception;
	public NewProduct internalSaveNewProduct(UxsUserContext userContext, NewProduct newProduct) throws Exception;
	public NewProduct internalSaveNewProduct(UxsUserContext userContext, NewProduct newProduct,Map<String,Object>option) throws Exception;
	
	public NewProduct transferToAnotherParentCategory(UxsUserContext userContext, String newProductId, String anotherParentCategoryId)  throws Exception;
 	public NewProduct transferToAnotherBrand(UxsUserContext userContext, String newProductId, String anotherBrandId)  throws Exception;
 	public NewProduct transferToAnotherCatalog(UxsUserContext userContext, String newProductId, String anotherCatalogId)  throws Exception;
 	public NewProduct transferToAnotherProfile(UxsUserContext userContext, String newProductId, String anotherProfileId)  throws Exception;
 	public NewProduct transferToAnotherPlatform(UxsUserContext userContext, String newProductId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String newProductId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, NewProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


