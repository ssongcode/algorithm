import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int H, M;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		if (M < 45) {
			M = 60 + (M - 45);
			H = H - 1;
		} else {
			M = M - 45;
		}
		if (H < 0) {
			H = 23;
		}
		System.out.println(H + blank + M);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
