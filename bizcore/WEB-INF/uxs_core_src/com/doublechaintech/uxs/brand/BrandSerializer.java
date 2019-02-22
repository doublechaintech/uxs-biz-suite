package com.doublechaintech.uxs.brand;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.uxs.UxsObjectPlainCustomSerializer;
public class BrandSerializer extends UxsObjectPlainCustomSerializer<Brand>{

	@Override
	public void serialize(Brand brand, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, brand, provider);
		
	}
}


