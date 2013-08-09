package org.cyclopsgroup.jmxterm.io;

/**
 * Interface for printing out object values in particular format.
 */
public interface IValueOutputFormat {
	/**
	 * Print out equal expression of an variable with description
	 * 
	 * @param output
	 *            Output to print to
	 * @param name
	 *            Name of variable
	 * @param value
	 *            Value of variable
	 * @param description
	 *            Description of variable
	 */
	void printExpression(CommandOutput output, String name, Object value, String description);

	/**
	 * @param output
	 *            Output writer where value is printed to
	 * @param value
	 *            Value to print
	 */
	void printValue(CommandOutput output, Object value);
}
