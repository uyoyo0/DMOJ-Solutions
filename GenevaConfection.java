import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class GenevaConfection {
	public static Stack<Integer> cars = new Stack<Integer>();
	public static ArrayList<String> list = new ArrayList<String>();
	
	public static void doWork() {
		boolean willWork = true;
		Stack<Integer> tempStack = new Stack<Integer>();
		int order = 1;

		while (!(cars.empty())) {
			if (cars.peek() == order) {
				cars.pop();
				order++;
			} else if(tempStack.empty() == false && tempStack.peek() == order) {
				tempStack.pop();
				order++;
			}else {
				tempStack.add(cars.pop());
			}
		}

		while (!(tempStack.empty())) {
			if (tempStack.peek() == order) {
				tempStack.pop();
				order++;
			} else{
				willWork = false;
				break;
			}
		}

		if (willWork) {
			list.add("Y");
		} else {
			list.add("N");
		}
		tempStack.clear();
		cars.clear();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testNum, carNum;

		testNum = sc.nextInt();

		for (int i = 0; i < testNum; i++) {
			carNum = sc.nextInt();
			for (int x = 0; x < carNum; x++) {
				cars.add(sc.nextInt());
			}
			doWork();
		}
		
		for (String output: list) {
			System.out.println(output);
		}
	}
}
