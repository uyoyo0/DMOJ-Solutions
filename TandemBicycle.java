/**
 * You know the drill:
 * https://dmoj.ca/problem/ccc16s2
 */
import java.util.*;

public class TandemBicycle {

	public static void main(String[] args) {
		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> two = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		boolean qOne = sc.nextInt() == 1;
		int citizens = sc.nextInt();
		int count = 0;
		int total = 0;
		int[] speeds = new int[citizens];
	
		for (int i = 0; i < citizens; i++) {
			one.add(sc.nextInt());
		}
		
		for (int i = 0; i < citizens; i++) {
			two.add(sc.nextInt());
		}
		
		Collections.sort(one);
		Collections.sort(two);
		
		if (qOne) {
			for (int i = 0; i < one.size(); i++) {
				speeds[i] = Math.max(one.get(i), two.get(i));
			}
		}else {
			Collections.reverse(one);
			Collections.reverse(two);
			
			for (int i = 0; i < speeds.length; i ++) {
				
				speeds[i] = Math.max(one.get(0), two.get(two.size() - 1));
				one.remove(0);
				two.remove(two.size() - 1);
			}
		}
		
		for (int i : speeds) {
			total+= i;
		}
		System.out.println(total);
	}

}
