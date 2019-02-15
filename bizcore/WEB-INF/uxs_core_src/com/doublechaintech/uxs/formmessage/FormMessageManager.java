
package com.doublechaintech.uxs.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(UxsUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(UxsUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(UxsUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(UxsUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(UxsUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(UxsUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


