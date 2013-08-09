package org.cyclopsgroup.jmxterm.io.json;

import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

import org.cyclopsgroup.jmxterm.io.CommandOutput;
import org.cyclopsgroup.jmxterm.io.IValueOutputFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Print values in JSON format.
 * 
 * @author <a href="mailto:hwestphal@gmx.de">Harald Westphal</a>
 */
public class JsonOutputFormat implements IValueOutputFormat {

	private static final Gson GSON = new GsonBuilder().registerTypeHierarchyAdapter(CompositeData.class, new CompositeDataSerializer())
			.registerTypeHierarchyAdapter(TabularData.class, new TabularDataSerializer()).create();

	@Override
	public void printExpression(CommandOutput output, String name, Object value, String description) {
		output.print(GSON.toJson(name));
		output.print(":");
		printValue(output, value);
		output.print(",");
	}

	@Override
	public void printValue(CommandOutput output, Object value) {
		output.print(GSON.toJson(value));
	}

}
