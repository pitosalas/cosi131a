package edu.brandeis.cs.cs131.pa1.filter.sequential;

import java.util.List;
import java.util.Scanner;

import edu.brandeis.cs.cs131.pa1.filter.Message;

/**
 * The main implementation of the REPL loop (read-eval-print loop). It reads
 * commands from the user, parses them, executes them and displays the result.
 */
public class SequentialREPL {

	/**
	 * The main method that will execute the REPL loop
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {

		Scanner consoleReader = new Scanner(System.in);
		System.out.print(Message.WELCOME);
		boolean continue_loop = true;

		while (continue_loop) {
			System.out.print(Message.NEWCOMMAND);

			// read user command, if its just whitespace, skip to next command
			String cmd = consoleReader.nextLine();
			List<SequentialFilter> commands = SequentialCommandBuilder.createFiltersFromCommand(cmd);
			
		}
		System.out.print(Message.GOODBYE);
		consoleReader.close();

	}

}
