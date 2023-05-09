import java.util.*;

public class Main {
	static int total = 0;
	static boolean[][] canvas;

	static void flipRow(int row) {
		for (int i = 1; i < canvas[row].length; i++) {
			if (canvas[row][i]) {
				total--;
				canvas[row][i] = false;
			} else {
				canvas[row][i] = true;
				total++;
			}
		}
	}

	static void flipCol(int col) {
		for (int i = 1; i < canvas.length; i++) {
			if (canvas[i][col]) {
				total--;
				canvas[i][col] = false;
			} else {
				canvas[i][col] = true;
				total++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m, n, k;
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		canvas = new boolean[m + 1][n + 1];
		int[] rowStrokes = new int[m + 1];
		int[] colStrokes = new int[n + 1];

		int temp;
		String choice;
		for (int i = 0; i < k; i++) {
			choice = sc.next();
			temp = sc.nextInt();

			if (choice.equals("R")) {
				rowStrokes[temp]++;
			} else if (choice.equals("C")) {
				colStrokes[temp]++;
			}
		}
		for (int i = 0; i < rowStrokes.length; i++) {
			if (rowStrokes[i] % 2 != 0) {
				flipRow(i);
			}
		}

		for (int i = 0; i < colStrokes.length; i++) {
			if (colStrokes[i] % 2 != 0) {
				flipCol(i);
			}
		}
		System.out.println(total);
	}
}