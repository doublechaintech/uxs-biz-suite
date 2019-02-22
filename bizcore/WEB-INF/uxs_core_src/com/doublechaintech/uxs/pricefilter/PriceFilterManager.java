
package com.doublechaintech.uxs.pricefilter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface PriceFilterManager{

		

	public PriceFilter createPriceFilter(UxsUserContext userContext, String name, BigDecimal priceStart, BigDecimal priceEnd, String profileId) throws Exception;	
	public PriceFilter updatePriceFilter(UxsUserContext userContext,String priceFilterId, int priceFilterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PriceFilter loadPriceFilter(UxsUserContext userContext, String priceFilterId, String [] tokensExpr) throws Exception;
	public PriceFilter internalSavePriceFilter(UxsUserContext userContext, PriceFilter priceFilter) throws Exception;
	public PriceFilter internalSavePriceFilter(UxsUserContext userContext, PriceFilter priceFilter,Map<String,Object>option) throws Exception;
	
	public PriceFilter transferToAnotherProfile(UxsUserContext userContext, String priceFilterId, String anotherProfileId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String priceFilterId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, PriceFilter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


