import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] H, P, S;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		H = new int[N + 2];
		P = new int[N + 2];
		S = new int[N + 2];
		char ch;
		for (int i = 1; i <= N; i++) {
			ch = br.readLine().charAt(0);
			if (ch == 'H')
				H[i]++;
			else if (ch == 'P')
				P[i]++;
			else
				S[i]++;
		}

	}

	static void pro() throws IOException {
		int[] prefixH = new int[N + 2];
		int[] prefixP = new int[N + 2];
		int[] prefixS = new int[N + 2];
		int[] suffixH = new int[N + 2];
		int[] suffixP = new int[N + 2];
		int[] suffixS = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			prefixH[i] = prefixH[i - 1] + H[i];
			prefixP[i] = prefixP[i - 1] + P[i];
			prefixS[i] = prefixS[i - 1] + S[i];
		}
		for (int i = N; i >= 0; i--) {
			suffixH[i] = suffixH[i + 1] + H[i];
			suffixP[i] = suffixP[i + 1] + P[i];
			suffixS[i] = suffixS[i + 1] + S[i];
		}

		int prefixMax = 0, suffixMax = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			prefixMax = Math.max(prefixH[i], prefixP[i]);
			prefixMax = Math.max(prefixMax, prefixS[i]);
			suffixMax = Math.max(suffixH[i + 1], suffixP[i + 1]);
			suffixMax = Math.max(suffixMax, suffixS[i + 1]);
			max = Math.max(max, prefixMax + suffixMax);
		}
		
		System.out.println(max);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}