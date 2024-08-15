import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int a, b, c, n;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		int output = 0;
		Loop: for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
				for (int k = 0; k < 300; k++) {
					if (a * i + b * j + c * k == n) {
						output = 1;
						break Loop;
					}

				}
			}
		}
		System.out.print(output);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
