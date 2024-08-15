import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int[] arr = new int[5];

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		for (int n = 1; n <= 1000000; n++) {
			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 5; j++) {
					for (int k = j + 1; k < 5; k++) {
						if (n % arr[i] == 0 && n % arr[j] == 0 && n % arr[k] == 0) {
							System.out.print(n);
							return;
						}
					}
				}
			}
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
