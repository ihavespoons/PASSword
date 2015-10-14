import java.util.*;

public class rand {
	public static void main(String arg[]) {
		String str = new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
		StringBuffer sb = new StringBuffer();
		// String ar = null;
		Random r = new Random();
		int te = 0;
		for (int i = 1; i <= 8; i++) {
			te = r.nextInt(62);
			// ar = ar + str.charAt(te);
			sb.append(str.charAt(te));
		}
		// String abc = "";
		// char arr[] = str.toCharArray();
		System.out.println(sb.toString());
	}
}