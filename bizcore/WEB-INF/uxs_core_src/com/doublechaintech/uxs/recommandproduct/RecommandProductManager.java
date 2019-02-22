
package com.doublechaintech.uxs.recommandproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface RecommandProductManager{

		

	public RecommandProduct createRecommandProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception;	
	public RecommandProduct updateRecommandProduct(UxsUserContext userContext,String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RecommandProduct loadRecommandProduct(UxsUserContext userContext, String recommandProductId, String [] tokensExpr) throws Exception;
	public RecommandProduct internalSaveRecommandProduct(UxsUserContext userContext, RecommandProduct recommandProduct) throws Exception;
	public RecommandProduct internalSaveRecommandProduct(UxsUserContext userContext, RecommandProduct recommandProduct,Map<String,Object>option) throws Exception;
	
	public RecommandProduct transferToAnotherParentCategory(UxsUserContext userContext, String recommandProductId, String anotherParentCategoryId)  throws Exception;
 	public RecommandProduct transferToAnotherBrand(UxsUserContext userContext, String recommandProductId, String anotherBrandId)  throws Exception;
 	public RecommandProduct transferToAnotherCatalog(UxsUserContext userContext, String recommandProductId, String anotherCatalogId)  throws Exception;
 	public RecommandProduct transferToAnotherProfile(UxsUserContext userContext, String recommandProductId, String anotherProfileId)  throws Exception;
 	public RecommandProduct transferToAnotherPlatform(UxsUserContext userContext, String recommandProductId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String recommandProductId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, RecommandProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


