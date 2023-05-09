
/*
 * @ Author Uyiosa Iyekekpolor
 * @ Version 2021/01/05
 * Solution to DMOJ question titled: "Floor Plan", https://dmoj.ca/problem/ccc03s3
 * This is easily the most challenging problem i have solved so far, it took me 
 * roughly 2 hours to complete(to be fair on myself, i was helping my friend with his own CS work whilst 
 * working on this problem)
 */
import java.util.ArrayList;
import java.util.Scanner;

public class FloorPlan {
	final static char WALL = 'I';
	final static char FLOOR = '.';
	public static char[][] grid;
	public static ArrayList<Integer> rooms = new ArrayList<Integer>();
	public static int tiles;
	public static int roomsComplete = 0;

	public static void fillGrid() {

		Scanner sc = new Scanner(System.in);
		int row, col;
		String input = "";

		tiles = sc.nextInt();
		row = sc.nextInt();
		col = sc.nextInt();
		sc.nextLine();// read newline

		grid = new char[row][col];
		for (int r = 0; r < grid.length; r++) {
			input = sc.nextLine();
			for (int c = 0; c < grid[r].length; c++) {
				grid[r][c] = input.charAt(c);
			}
		}

	}

	public static void findRooms() {

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == FLOOR) {
					rooms.add(countTiles(row, col));
				}
			}
		}
	}

	public static int countTiles(int row, int col) {

		if (row > grid.length - 1 || row < 0 || col > grid[row].length - 1 || col < 0 || grid[row][col] != FLOOR) {
			return 0;
		} else {
			grid[row][col] = WALL;
			return 1 + countTiles(row + 1, col) + countTiles(row - 1, col) + countTiles(row, col + 1)
					+ countTiles(row, col - 1);
		}
	}

	public static int findMax(int[] array) {
		int temp = 0;
		int index = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > temp) {
				temp = array[i];
				index = i;
			}
		}
		array[index] = -1;
		return temp;

	}

	public static void outputWork(int[] array) {
		int temp, totalTiles = 0, tilesUsed = 0, tilesLeft;
		totalTiles = tiles;

		for (int i = 0; i < array.length; i++) {
			temp = findMax(array);

			if (tiles >= temp) {
				tiles = tiles - temp;
				roomsComplete++;
				tilesUsed = tilesUsed + temp;
			} else {
				break;
			}
		}
		tilesLeft = totalTiles - tilesUsed;

		if (roomsComplete > 1) {
			System.out.println(roomsComplete + " rooms, " + tilesLeft + " square metre(s) left over");
		} else if (roomsComplete == 1) {
			System.out.println(roomsComplete + " room, " + tilesLeft + " square metre(s) left over");
		} else {
			System.out.println(roomsComplete + " rooms, " + tilesLeft + " square metre(s) left over");
		}
	}

	public static void main(String[] args) {
		fillGrid();
		findRooms();
		int[] array = new int[rooms.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = rooms.get(i);
		}
		outputWork(array);

	}
}
