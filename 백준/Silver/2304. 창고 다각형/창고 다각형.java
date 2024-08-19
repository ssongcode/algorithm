import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int n;
	static int[] arr = new int[1010];
	static int maxY;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		int x, y;
		for (int i = 0; i < n; i++) {
			stk();
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x] = y;
			maxY = Math.max(maxY, y);
		}
	}

	static void pro() throws IOException {
		int x = 0;
		int tmp = 0;
		int sum = 0;
		int max;
		while (x < 1000) {
			max = 0;
			for (int i = x + 1; i <= 1000; i++) {
				if (arr[i] > arr[x]) {
					tmp = i;
					break;
				}
				if (arr[i] >= max) {
					max = arr[i];
					tmp = i;
				}
			}
			sum += (tmp - x) * (Math.min(arr[x], arr[tmp]));
			x = tmp;
		}
		sum += maxY;
		System.out.print(sum);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}