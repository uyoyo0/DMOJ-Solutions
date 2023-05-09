import java.util.Scanner;

public class SunFlowers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tr;//top right
		int tl;//top left
		int br;//bottom right
		int bl;//bottom left
		int num = sc.nextInt();
		int[][] dat = new int[num][num];
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				dat[i][j] = sc.nextInt();
			}
		}
		
		tr = dat[0][num - 1];
		tl = dat[0][0];
		br = dat[num - 1][num - 1];
		bl = dat[num - 1][0];
		
		int thisone = Math.min(Math.min(tr, tl), Math.min(br, bl));
		
		if (thisone == tl) {// 360 rotation
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					System.out.print(dat[i][j] + " ");
				}
				System.out.println();
			}
		}else if (thisone == tr) {
			for (int i = num - 1; i > - 1; i--) {
				for (int j = 0; j < num; j++) {
					System.out.print(dat[j][i] + " ");
				}
				System.out.println();
			}
			
		}else if (thisone == bl) {
			
			for (int i = 0; i < num;i++) {
				for (int j = num - 1; j > - 1; j--) {
					System.out.print(dat[j][i] + " ");
				}
				System.out.println();
			}
		}else if (thisone == br) {
			
			for (int i = num - 1; i > - 1; i--) {
				for (int j = num - 1; j > - 1; j--) {
					System.out.print(dat[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
