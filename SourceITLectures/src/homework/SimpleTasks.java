package homework;

import java.sql.Time;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

public class SimpleTasks {

	public static void main(String[] args) {
		//bubble sort
		int[] array = { 8, 2, 5, 3, 6, 4, 1, 7 };
		System.out.println(Arrays.toString(sort(array)));
		
		System.out.println(upperCaseFirstLetters("When I was younger\r\n" + "I never needed\r\n"));
		piSymbols(5);
	}

	public static String upperCaseFirstLetters(String text) {
		String[] str = text.split(" ");
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i].substring(0, 1).toUpperCase() + str[i].substring(1, str[i].length()) + " ");

		}
		return sb.toString();
	}

	public static void piSymbols(int range) {
		for (int i = 1; i <= range; i++) {
			System.out.println((new Formatter()).format(Locale.ENGLISH, "Pi = %." + i + "f", Math.PI));
		}
	}

	public static double getDegrees(Time t) {
		
		return 0;
	}
	
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
}
