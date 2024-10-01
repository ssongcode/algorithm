import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int A, B;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
	}

	static void pro() throws IOException {
		while (true) {
			stk();
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if (A == 0 && B == 0)
				break;
			sb.append(A + B).append(endl);
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
