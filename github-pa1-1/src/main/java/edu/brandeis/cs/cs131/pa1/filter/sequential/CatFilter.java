package edu.brandeis.cs.cs131.pa1.filter.sequential;

public class CatFilter extends SequentialFilter {
	String[] words;

	public CatFilter(String subCommand) {
		input = new Pipe();
		output = new Pipe();
		this.words = subCommand.split(" ");
	}

	@Override
	protected String processLine(String line) {
		return null;
	}

}
