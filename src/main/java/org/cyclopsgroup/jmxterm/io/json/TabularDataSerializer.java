package org.cyclopsgroup.jmxterm.io.json;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.management.openmbean.TabularData;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Custom JSON serializer for {@link TabularData} objects.
 * 
 * @author <a href="mailto:hwestphal@gmx.de">Harald Westphal</a>
 */
public class TabularDataSerializer implements JsonSerializer<TabularData> {

	@Override
	public JsonElement serialize(TabularData data, Type type, JsonSerializationContext context) {
		List<String> indexNames = data.getTabularType().getIndexNames();
		if (indexNames.size() == 1) {
			JsonObject object = new JsonObject();
			for (Object value : data.values()) {
				JsonObject valueObject = context.serialize(value).getAsJsonObject();
				String key = valueObject.remove(indexNames.get(0)).getAsString();
				Set<Entry<String, JsonElement>> entries = valueObject.entrySet();
				if (entries.size() == 1) {
					object.add(key, entries.iterator().next().getValue());
				} else {
					object.add(key, valueObject);
				}
			}
			return object;
		}

		JsonArray array = new JsonArray();
		for (Object value : data.values()) {
			array.add(context.serialize(value));
		}
		return array;
	}

}
