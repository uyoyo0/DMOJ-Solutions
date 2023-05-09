
/**
 * Another practice problem

 * Heres the link:
 * https://dmoj.ca/problem/ccc19s2
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PAP {

	static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i < Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static void findPrimes(int n) {
		int temp;

		for (int i = 2; i < n; i++) {
			temp = (n * 2) - i;

			if (isPrime(i) && isPrime(temp) && (i + temp) / 2 == n) {
				System.out.println(i + " " + temp);
				break;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		ArrayList<Integer> nums = new ArrayList<Integer>(tests);

		for (int i = 0; i < tests; i++) {
			nums.add(sc.nextInt());
		}

		for (int num : nums) {
			findPrimes(num);
		}
	}

}
