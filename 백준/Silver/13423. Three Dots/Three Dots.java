import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, N, L;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		T = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		int s, e, mid, cnt;
		for (int t = 0; t < T; t++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			stk();
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			} // 입력
			Arrays.sort(arr);

			// 두 점 선택
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					L = arr[j] - arr[i]; // 두 점의 거리
					s = j + 1;
					e = N - 1;
					int tmp;
					while (s <= e) {
						mid = (s + e) / 2;
						if (arr[mid] - arr[j] > L)
							e = mid - 1;
						else if (arr[mid] - arr[j] < L)
							s = mid + 1;
						else {
							cnt++;
							break;
						}
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}