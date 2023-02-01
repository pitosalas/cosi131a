package edu.brandeis.cs.cs131.pa1.filter.sequential;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages the parsing and execution of a command. It splits the raw
 * input into separated subcommands, creates subcommand filters, and links them
 * into a list.
 */
public class SequentialCommandBuilder {

	public static List<SequentialFilter> createFiltersFromCommand(String command) {
		List<SequentialFilter> resultList = new ArrayList<SequentialFilter>();
		resultList.add(constructFilterFromSubCommand(command));
		return  resultList;
//		throw new UnsupportedOperationException("UNIMPLEMENTED");
	}

	private static SequentialFilter constructFilterFromSubCommand(String subCommand) {
		SequentialFilter commandFilter = null;
		String[] words = subCommand.trim().split(" ");
		if (words.length == 0)
			return null;
		
		if (words[0].equals("exit")) {
			commandFilter = new ExitFilter(subCommand);			
		}

		if (words[0].equals("cat")) {
			commandFilter = new CatFilter(subCommand);
		}
		return commandFilter;
	}

	private static void linkFilters(List<SequentialFilter> filters) {

		throw new UnsupportedOperationException("UNIMPLEMENTED");
	}
}
