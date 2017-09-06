package wordcount;

public class CounterImp implements Counter {

	@Override
	public boolean blankCount(String s) {
		if (s=="" || s == null) {
			throw new IllegalArgumentException();
		} else {
			if(-1 == s.indexOf(" ")) {
				return false;
			}
			return true;
		}
	}
}
