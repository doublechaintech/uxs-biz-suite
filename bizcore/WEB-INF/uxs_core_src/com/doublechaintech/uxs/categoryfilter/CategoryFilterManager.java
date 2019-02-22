
package com.doublechaintech.uxs.categoryfilter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface CategoryFilterManager{

		

	public CategoryFilter createCategoryFilter(UxsUserContext userContext, String name, String internalId, String profileId) throws Exception;	
	public CategoryFilter updateCategoryFilter(UxsUserContext userContext,String categoryFilterId, int categoryFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CategoryFilter loadCategoryFilter(UxsUserContext userContext, String categoryFilterId, String [] tokensExpr) throws Exception;
	public CategoryFilter internalSaveCategoryFilter(UxsUserContext userContext, CategoryFilter categoryFilter) throws Exception;
	public CategoryFilter internalSaveCategoryFilter(UxsUserContext userContext, CategoryFilter categoryFilter,Map<String,Object>option) throws Exception;
	
	public CategoryFilter transferToAnotherProfile(UxsUserContext userContext, String categoryFilterId, String anotherProfileId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String categoryFilterId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, CategoryFilter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


