package taskString;

import java.util.Scanner;

public class subStringTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// write the String need to reserved SubStrings of it

		System.out.println("Write String Word: ");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		String finalWord = "";
		Boolean flag = true;
		String reverseSubString = "";
		for (int i = 0; i <= word.length() - 1; i++) {
			if (flag == true) {
				finalWord += word.charAt(i);
			}
			if (word.charAt(i) == '(') {
				flag = false;
				continue;
			}
			if (word.charAt(i) == ')') {
				flag = true;
				finalWord = finalWord + reverseSubString + word.charAt(i);
				reverseSubString = "";
			}
			if (flag == false) {
				reverseSubString = word.charAt(i) + reverseSubString;
			}

		}
		System.out.println(finalWord);

	}

}
