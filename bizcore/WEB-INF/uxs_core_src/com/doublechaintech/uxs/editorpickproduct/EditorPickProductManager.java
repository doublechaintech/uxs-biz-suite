
package com.doublechaintech.uxs.editorpickproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface EditorPickProductManager{

		

	public EditorPickProduct createEditorPickProduct(UxsUserContext userContext, String name, String parentCategoryId, String brandId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception;	
	public EditorPickProduct updateEditorPickProduct(UxsUserContext userContext,String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EditorPickProduct loadEditorPickProduct(UxsUserContext userContext, String editorPickProductId, String [] tokensExpr) throws Exception;
	public EditorPickProduct internalSaveEditorPickProduct(UxsUserContext userContext, EditorPickProduct editorPickProduct) throws Exception;
	public EditorPickProduct internalSaveEditorPickProduct(UxsUserContext userContext, EditorPickProduct editorPickProduct,Map<String,Object>option) throws Exception;
	
	public EditorPickProduct transferToAnotherParentCategory(UxsUserContext userContext, String editorPickProductId, String anotherParentCategoryId)  throws Exception;
 	public EditorPickProduct transferToAnotherBrand(UxsUserContext userContext, String editorPickProductId, String anotherBrandId)  throws Exception;
 	public EditorPickProduct transferToAnotherCatalog(UxsUserContext userContext, String editorPickProductId, String anotherCatalogId)  throws Exception;
 	public EditorPickProduct transferToAnotherProfile(UxsUserContext userContext, String editorPickProductId, String anotherProfileId)  throws Exception;
 	public EditorPickProduct transferToAnotherPlatform(UxsUserContext userContext, String editorPickProductId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String editorPickProductId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, EditorPickProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


