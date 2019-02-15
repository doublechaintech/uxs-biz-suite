
package com.doublechaintech.uxs.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface FormActionManager{

		

	public FormAction createFormAction(UxsUserContext userContext, String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception;	
	public FormAction updateFormAction(UxsUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(UxsUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(UxsUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(UxsUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;
	
	public FormAction transferToAnotherForm(UxsUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}














