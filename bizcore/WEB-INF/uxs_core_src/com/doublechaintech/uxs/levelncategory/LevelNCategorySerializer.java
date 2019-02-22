package com.doublechaintech.uxs.levelncategory;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.uxs.UxsObjectPlainCustomSerializer;
public class LevelNCategorySerializer extends UxsObjectPlainCustomSerializer<LevelNCategory>{

	@Override
	public void serialize(LevelNCategory levelNCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, levelNCategory, provider);
		
	}
}


