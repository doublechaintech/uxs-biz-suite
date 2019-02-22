package com.doublechaintech.uxs.site;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.uxs.UxsObjectPlainCustomSerializer;
public class SiteSerializer extends UxsObjectPlainCustomSerializer<Site>{

	@Override
	public void serialize(Site site, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, site, provider);
		
	}
}


