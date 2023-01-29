package cs131.pa1.filter.sequential;

import java.util.List;

/**
 * This class manages the parsing and execution of a command. It splits the raw
 * input into separated subcommands, creates subcommand filters, and links them
 * into a list.
 * 
 * @author cs131a
 *
 */
public class SequentialCommandBuilder {
	/**
	 * Creates and returns a list of filters from the specified command
	 * 
	 * @param command the command to create filters from
	 * @return the list of SequentialFilter that represent the specified command
	 */
	public static List<SequentialFilter> createFiltersFromCommand(String command) {
		return null;
	}

	/**
	 * Returns the filter that appears last in the specified command
	 * 
	 * @param command the command to search from
	 * @return the SequentialFilter that appears last in the specified command
	 */
	private static SequentialFilter determineFinalFilter(String command) {
		return null;
	}

	/**
	 * Returns a string that contains the specified command without the final filter
	 * 
	 * @param command the command to parse and remove the final filter from
	 * @return the adjusted command that does not contain the final filter
	 */
	private static String adjustCommandToRemoveFinalFilter(String command) {
		return null;
	}

	/**
	 * Creates a single filter from the specified subCommand
	 * 
	 * @param subCommand the command to create a filter from
	 * @return the SequentialFilter created from the given subCommand
	 */
	private static SequentialFilter constructFilterFromSubCommand(String subCommand) {
		return null;
	}

	/**
	 * links the given filters with the order they appear in the list
	 * 
	 * @param filters the given filters to link
	 * @return true if the link was successful, false if there were errors
	 *         encountered. Any error should be displayed by using the Message enum.
	 */
	private static boolean linkFilters(List<SequentialFilter> filters) {
		return false;
	}
}
