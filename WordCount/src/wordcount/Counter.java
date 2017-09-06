package wordcount;

public interface Counter {
	/**
	 * Checks to see if the passed string contains a space.
	 * @param s - String to check
	 * @return boolean returns <i>true</i> if the <b>String</b> contains a space, otherwise returns <i>false</i>.
	 * @throws IllegalArgumentException
	 */
	public boolean blankCount(String s);

}
