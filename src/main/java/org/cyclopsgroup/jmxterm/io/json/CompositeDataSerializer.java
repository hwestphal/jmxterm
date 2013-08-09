package org.cyclopsgroup.jmxterm.io.json;

import java.lang.reflect.Type;

import javax.management.openmbean.CompositeData;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Custom JSON serializer for {@link CompositeData} objects.
 * 
 * @author <a href="mailto:hwestphal@gmx.de">Harald Westphal</a>
 */
class CompositeDataSerializer implements JsonSerializer<CompositeData> {

	@Override
	public JsonElement serialize(CompositeData data, Type type, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		for (String key : data.getCompositeType().keySet()) {
			Object value = data.get(key);
			result.add(key, context.serialize(value));
		}
		return result;
	}

}
