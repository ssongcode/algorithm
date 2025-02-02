import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int A, B, C;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int h = 0, m = 0, H = 0, M = 0;
		h = C / 60;
		m = C % 60;
		H = A + h;
		M = B + m;

		if (M >= 60) {
			H += 1;
			M -= 60;
		}
		if (H >= 24)
			H -= 24;

		System.out.println(H + " " + M);

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}