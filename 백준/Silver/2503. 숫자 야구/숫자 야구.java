import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			stk();
			arr[i][0] = Integer.parseInt(st.nextToken()); // 정수
			arr[i][1] = Integer.parseInt(st.nextToken()); // 스트라이크
			arr[i][2] = Integer.parseInt(st.nextToken()); // 볼
		}
	}

	static void pro() throws IOException {
		int cnt = 0;
		for (int i = 123; i <= 987; i++) {
			if (isContainZero(i)) continue;
			if (!isDifferent(i)) continue;
			if (isCorrect(i))
				cnt++;
		}
		System.out.print(cnt);
	}

	static boolean isContainZero(int tmp) throws IOException {
		String str = String.valueOf(tmp);
		if (str.contains(String.valueOf(0)))
			return true;
		else
			return false;
	}

	static boolean isDifferent(int tmp) throws IOException {
		String str = String.valueOf(tmp);
		if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2))
			return false;
		else
			return true;
	}

	static boolean isCorrect(int tmp) throws IOException {
		int s, b;
		String str1 = String.valueOf(tmp);
		for (int i = 0; i < n; i++) {
			s = 0;
			b = 0;
			String str2 = String.valueOf(arr[i][0]);
			for (int j = 0; j < 3; j++) {
				if (str1.charAt(j) == str2.charAt(j))
					s++;
				if (str1.contains(String.valueOf(str2.charAt(j))) && str1.charAt(j) != str2.charAt(j))
					b++;
			}
			if (s != arr[i][1] || b != arr[i][2])
				return false;
		}
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}