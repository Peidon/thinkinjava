package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		final int n = cin.nextInt();
		cin.nextLine();
		String input = cin.nextLine();
		String[] nums = new String[n];
		String[] opts;
		if (n > 1) {
			opts = new String[n - 1];
			String[] chs = input.split(" ");
			for (int i = 0; i < chs.length; i++) {
				if ((i & 1) == 1) opts[(i - 1) >> 1] = chs[i];
				else nums[i >> 1] = chs[i];
			}

			int numl = 0;
			int preopi = 0;
			while(numl < nums.length - 1){
				int numr = numl + 1;
				int opi = preopi + 1;
				while (opi < n && opts[opi].equals(opts[preopi])) {
					preopi = opi;
					opi++;
					numr = opi + 1;
				}

				final String[] temp = new String[numr - numl + 1];
				System.arraycopy(nums, numl, temp, 0, temp.length);
				Arrays.sort(temp);
				int i = numl;
				for (; i < temp.length - 1; i++){
					System.out.print(temp[i] + " " + opts[opi - 1] + " ");
				}
				System.out.print(temp[i]);
				numl = i + 1;
			}
		}
		else System.out.println(input);
	}
}