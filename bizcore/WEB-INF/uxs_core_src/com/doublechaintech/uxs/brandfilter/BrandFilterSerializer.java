package com.doublechaintech.uxs.brandfilter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.uxs.UxsObjectPlainCustomSerializer;
public class BrandFilterSerializer extends UxsObjectPlainCustomSerializer<BrandFilter>{

	@Override
	public void serialize(BrandFilter brandFilter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, brandFilter, provider);
		
	}
}


