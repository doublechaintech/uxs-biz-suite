
package com.doublechaintech.uxs.formfieldmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.UxsUserContext;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;

public interface FormFieldMessageManager{

		

	public FormFieldMessage createFormFieldMessage(UxsUserContext userContext, String title, String parameterName, String formId, String level) throws Exception;	
	public FormFieldMessage updateFormFieldMessage(UxsUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormFieldMessage loadFormFieldMessage(UxsUserContext userContext, String formFieldMessageId, String [] tokensExpr) throws Exception;
	public FormFieldMessage internalSaveFormFieldMessage(UxsUserContext userContext, FormFieldMessage formFieldMessage) throws Exception;
	public FormFieldMessage internalSaveFormFieldMessage(UxsUserContext userContext, FormFieldMessage formFieldMessage,Map<String,Object>option) throws Exception;
	
	public FormFieldMessage transferToAnotherForm(UxsUserContext userContext, String formFieldMessageId, String anotherFormId)  throws Exception;
 

	public void delete(UxsUserContext userContext, String formFieldMessageId, int version) throws Exception;
	public int deleteAll(UxsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(UxsUserContext userContext, FormFieldMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


