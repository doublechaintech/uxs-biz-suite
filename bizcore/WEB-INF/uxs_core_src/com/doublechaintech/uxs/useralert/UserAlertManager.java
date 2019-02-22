
package com.doublechaintech.uxs.useralert;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface UserAlertManager{

		

	public UserAlert createUserAlert(UxsUserContext userContext, String message, String profileId, String location, String platformId) throws Exception;	
	public UserAlert updateUserAlert(UxsUserContext userContext,String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserAlert loadUserAlert(UxsUserContext userContext, String userAlertId, String [] tokensExpr) throws Exception;
	public UserAlert internalSaveUserAlert(UxsUserContext userContext, UserAlert userAlert) throws Exception;
	public UserAlert internalSaveUserAlert(UxsUserContext userContext, UserAlert userAlert,Map<String,Object>option) throws Exception;
	
	public UserAlert transferToAnotherProfile(UxsUserContext userContext, String userAlertId, String anotherProfileId)  throws Exception;
 	public UserAlert transferToAnotherPlatform(UxsUserContext userContext, String userAlertId, String anotherPlatformId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String userAlertId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, UserAlert newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


