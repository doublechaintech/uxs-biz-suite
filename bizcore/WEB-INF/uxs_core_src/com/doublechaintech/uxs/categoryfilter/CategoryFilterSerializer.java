package com.doublechaintech.uxs.categoryfilter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.uxs.UxsObjectPlainCustomSerializer;
public class CategoryFilterSerializer extends UxsObjectPlainCustomSerializer<CategoryFilter>{

	@Override
	public void serialize(CategoryFilter categoryFilter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, categoryFilter, provider);
		
	}
}


