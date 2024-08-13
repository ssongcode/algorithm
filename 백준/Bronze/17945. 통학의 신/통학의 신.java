import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int a, b;
//	 X^2 + 2Ax + B = 0

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE;
		for (int i = -3000; i <= 3000; i++) {
			if (i * i + 2 * a * i + b == 0) {
				if (i > y) {
					x = y;
					y = i;
				}
			}
		}
		if (x != Integer.MIN_VALUE)
			System.out.print(x + " " + y);
		else
			System.out.print(y);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
