import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, T, P;
	static int[] people;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		people = new int[6];
		stk();
		for (int i = 0; i < 6; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		stk();
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		int t = 0, p = 0, mod = 0;
		for (int i = 0; i < 6; i++) {
			if (people[i] % T == 0)
				t += people[i] / T;
			else
				t += people[i] / T + 1;
		}
		p = N / P;
		mod = N % P;
		System.out.println(t);
		System.out.println(p + " " + mod);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}