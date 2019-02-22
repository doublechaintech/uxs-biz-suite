
package com.doublechaintech.uxs.brandfilter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface BrandFilterManager{

		

	public BrandFilter createBrandFilter(UxsUserContext userContext, String name, String internalId, String profileId) throws Exception;	
	public BrandFilter updateBrandFilter(UxsUserContext userContext,String brandFilterId, int brandFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public BrandFilter loadBrandFilter(UxsUserContext userContext, String brandFilterId, String [] tokensExpr) throws Exception;
	public BrandFilter internalSaveBrandFilter(UxsUserContext userContext, BrandFilter brandFilter) throws Exception;
	public BrandFilter internalSaveBrandFilter(UxsUserContext userContext, BrandFilter brandFilter,Map<String,Object>option) throws Exception;
	
	public BrandFilter transferToAnotherProfile(UxsUserContext userContext, String brandFilterId, String anotherProfileId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String brandFilterId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, BrandFilter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


