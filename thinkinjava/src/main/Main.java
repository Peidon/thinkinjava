package main;

public class Main {

	public static void main(String[] args) {
		System.out.println(decode("3aefg5[ab]"));
	}
	static int i = 0;
	static char[] array;
	public static String decode(String s) {
		if (array == null)
			array = s.toCharArray();
		StringBuffer ans = new StringBuffer();
		while (i < array.length) {
			if (Character.isDigit(array[i])) {
				int t = Character.getNumericValue(array[i++]);
				String d = null;
				if(array[i] == '[')
					d = decode(s);
				while (t > 0) {
					if (d != null)
						ans.append(d);
					else
						ans.append(array[i]);
					t--;
				}
				i++;
			}
			else if(Character.isLetter(array[i]))
				ans.append(array[i++]);
			else i++;
		}
		return ans.toString();
	}
}
