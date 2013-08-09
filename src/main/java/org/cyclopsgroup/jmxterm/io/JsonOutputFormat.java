package org.cyclopsgroup.jmxterm.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Print values in JSON format.
 * 
 * @author <a href="mailto:hwestphal@gmx.de">Harald Westphal</a>
 */
public class JsonOutputFormat implements IValueOutputFormat {

	private static final Gson GSON = new GsonBuilder().create();

	@Override
	public void printExpression(CommandOutput output, String name, Object value, String description) {
		output.print(name);
		output.print(" = ");
		printValue(output, value);
	}

	@Override
	public void printValue(CommandOutput output, Object value) {
		output.print(GSON.toJson(value));
		output.print(";");
	}

}
