package edu.brandeis.cs.cs131.pa1.filter.sequential;

import edu.brandeis.cs.cs131.pa1.filter.Filter;

public class CatFilter extends SequentialFilter {
	String[] words;

	public CatFilter(String[] wordsArray) {
		this.words = wordsArray;
	}

	@Override
	protected String processLine(String line) {
		String theLine = this.words[1];
		return null;
	}

}
