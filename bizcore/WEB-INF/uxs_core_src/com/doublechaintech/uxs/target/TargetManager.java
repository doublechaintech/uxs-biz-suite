
package com.doublechaintech.uxs.target;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface TargetManager{

		

	public Target createTarget(UxsUserContext userContext, String name, String profileId, String bannerId, String location) throws Exception;	
	public Target updateTarget(UxsUserContext userContext,String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Target loadTarget(UxsUserContext userContext, String targetId, String [] tokensExpr) throws Exception;
	public Target internalSaveTarget(UxsUserContext userContext, Target target) throws Exception;
	public Target internalSaveTarget(UxsUserContext userContext, Target target,Map<String,Object>option) throws Exception;
	
	public Target transferToAnotherProfile(UxsUserContext userContext, String targetId, String anotherProfileId)  throws Exception;
 	public Target transferToAnotherBanner(UxsUserContext userContext, String targetId, String anotherBannerId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String targetId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, Target newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


