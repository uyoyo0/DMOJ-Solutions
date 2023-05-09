// 2020-11-24
//I submitted this to dmoj 
//This is the link to the assignment and its specifications
//https://dmoj.ca/problem/ccc06s2/submissions/

import java.util.Scanner;

public class CipherTexts {

	public int findIndexOf(char letter, char[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (letter == arr[i]) {
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CipherTexts t = new CipherTexts();
		int checkIndexOf;

		String plainText1 = "";
		String plainText2;
		String cypherText1 = "";
		String cypherText2 = "";

		plainText1 = sc.nextLine();
		cypherText1 = sc.nextLine();
		cypherText2 = sc.nextLine();

		char[] pText1 = plainText1.toCharArray();
		char[] cText1 = cypherText1.toCharArray();
		char[] cText2 = cypherText2.toCharArray();
		char[] pText2 = new char[cText2.length];

		for (int i = 0; i < pText2.length; i++) {
			checkIndexOf = t.findIndexOf(cText2[i], cText1);

			if (checkIndexOf != -1) {
				pText2[i] = pText1[checkIndexOf];
			} else {
				pText2[i] = '.';
			}
		}

		plainText2 = new String(pText2);
		System.out.println(plainText2);

	}
}
