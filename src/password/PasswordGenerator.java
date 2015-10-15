package password;

import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator {
	private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SYMBOLS = "~`!@#$%^&*()-_=+[{]}\\|;\'\",<.>/? ";

	protected static String generate(int length, boolean upper, boolean lower, boolean numbers, boolean symbols) {
		String[] characterSpace = generateCharacterSpace(upper, lower, numbers, symbols);
		StringBuffer stringBuffer = new StringBuffer();
		Random random = new Random();
		int j;
		int k;
		for (int i = 0; i < length; i++) {
			j = random.nextInt(characterSpace.length);
			k = random.nextInt(characterSpace[j].length());
			stringBuffer.append(characterSpace[j].charAt(k));
		}
		return stringBuffer.toString();
	}

	private static String[] generateCharacterSpace(boolean upper, boolean lower, boolean numbers, boolean symbols) {
		ArrayList<String> list = new ArrayList<String>();
		if (upper) {
			list.add(UPPER);
		}
		if (lower) {
			list.add(LOWER);
		}
		if (numbers) {
			list.add(NUMBERS);
		}
		if (symbols) {
			list.add(SYMBOLS);
		}
		return list.toArray(new String[list.size()]);
	}
}
