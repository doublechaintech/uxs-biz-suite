package com.doublechaintech.uxs.newproduct;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.uxs.UxsObjectPlainCustomSerializer;
public class NewProductSerializer extends UxsObjectPlainCustomSerializer<NewProduct>{

	@Override
	public void serialize(NewProduct newProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, newProduct, provider);
		
	}
}


