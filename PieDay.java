import java.util.*;

/**
 * This was honestly one of the most challenging problems I have ever solved I
 * first attempted the preoblems months ago but I was stuck and decided to try
 * it again later. Eventually, after learning topics like memoizations and
 * learning the basics of hashmaps I came back to the problem and was able to
 * solve it after roughly an hour of trying im very proud of this solution and
 * hopefully my future self will be aswell
 * 
 * As always, here is the link to the problem: https://dmoj.ca/problem/ccc15j5
 *
 * 2021-01-30
 */

public class PieDay {

	static HashMap<String, Integer> map = new HashMap<>();

	static int doWork(int pies, int people, int min) {
		String key = pies + "," + people + "," + min;

		if (map.containsKey(key)) {
			return map.get(key);
		}
		if (people == 0 && pies == 0) {
			return 1;
		}

		if (people > pies) {
			return 0;
		}

		if (people == 1 && pies > 0) {
			return 1;
		}

		int total = 0;

		for (int i = min; i < (pies / people) + 1; i++) {
			total = total + doWork(pies - i, people - 1, i);
		}
		map.put(key, total);
		return total;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pies, people;
		pies = sc.nextInt();
		people = sc.nextInt();
		
		System.out.println(doWork(pies, people, 1));
	}

}
