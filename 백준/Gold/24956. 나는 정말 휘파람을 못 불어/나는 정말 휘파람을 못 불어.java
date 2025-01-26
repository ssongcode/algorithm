import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static String S;
	static int[] w, h, e, prefixW, suffixE;
	static long mod = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		S = br.readLine();
		w = new int[N + 1];
		h = new int[N + 1];
		e = new int[N + 2];
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'W')
				w[i + 1]++;
			else if (S.charAt(i) == 'H')
				h[i + 1]++;
			else if (S.charAt(i) == 'E')
				e[i + 1]++;
		}
	}

	static void pro() throws IOException {
		// H를 기준으로 앞에 W가 몇 개 있고, 뒤에 E가 몇 개 있는지 확인
		prefixW = new int[N + 1];
		suffixE = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			prefixW[i] = prefixW[i - 1] + w[i];
		}
		for (int i = N; i >= 1; i--) {
			suffixE[i] = suffixE[i + 1] + e[i];
		}
		// H발견할 때마다 앞의 W개수 * (2의 E제곱 - eC0 - eC1)
		// prefixW[i] * (pow(2,suffixE[i]) -1 - suffixE[i])
		long ans = 0;
		int w, e;
		for (int i = 1; i <= N; i++) {
			if (h[i] != 0) {
				w = prefixW[i];
				e = suffixE[i];
				ans = (ans + (w * ((pow(2, e) - 1 - e + mod) % mod)) % mod) % mod;
			}
		}
		System.out.println(ans);
	}

	static long pow(long a, long b) {
		// 지수가 0인 경우
		if (b == 0)
			return 1;

		// 반으로 나눈 거듭제곱 계산
		long res = pow(a, b / 2);

		// 지수가 짝수인 경우
		if (b % 2 == 0)
			return res * res % mod;
		// 지수가 홀수인 경우
		else
			return res * res * a % mod;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}