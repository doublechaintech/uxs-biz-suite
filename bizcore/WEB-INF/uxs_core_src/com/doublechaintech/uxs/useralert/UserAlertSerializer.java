package com.doublechaintech.uxs.useralert;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.uxs.UxsObjectPlainCustomSerializer;
public class UserAlertSerializer extends UxsObjectPlainCustomSerializer<UserAlert>{

	@Override
	public void serialize(UserAlert userAlert, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userAlert, provider);
		
	}
}


