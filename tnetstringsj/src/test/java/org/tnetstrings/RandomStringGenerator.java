package org.tnetstrings;

import java.nio.charset.Charset;
import java.util.Random;

public class RandomStringGenerator {
	private final static Random random = new Random();
	private final static Charset ASCII = Charset.forName("US-ASCII");
	
	private static final char[] symbols;
	
	static {
		StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			tmp.append(ch);
		for (char ch = 'a'; ch <= 'z'; ++ch)
			tmp.append(ch);
		symbols = tmp.toString().toCharArray();
	}
	
	public static String nextString() {
		return nextString(random.nextInt(2048));
	}
	
	// http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
	public static String nextString(int length) {
		if (length == 0) {
			return "";
		}
		final char[] buf;
		buf = new char[length];
		for (int idx = 0; idx < buf.length; ++idx) 
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}
	
	public static String[] generateRandomNetstrings(int n) {
		String[] result = new String[n];
		for(int i = 0; i < n; i++) {
			String s = nextString();
			result[i] = TNetstring.parseString(TNetstring.dump(s, ASCII), 0, s.length() + 
					(""+s.length()).length() + 2, ASCII);
		}
		return result;
	}
}
