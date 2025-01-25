import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, A, B;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		stk();
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			stk();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		int s, e, mid, x, y, cnt, ans = 0;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			// 찾아야하는 좌표 1
			x = arr[i][0] + A;
			y = arr[i][1];
			s = i;
			e = N - 1;
			while (s <= e) {
				mid = (s + e) / 2;
				if (arr[mid][0] > x)
					e = mid - 1;
				else if (arr[mid][0] < x)
					s = mid + 1;
				else {
					if (arr[mid][1] > y)
						e = mid - 1;
					else if (arr[mid][1] < y)
						s = mid + 1;
					else {
						cnt++;
						break;
					}
				}
			}

			// 찾아야하는 좌표 2
			x = arr[i][0] + A;
			y = arr[i][1] + B;
			s = i;
			e = N - 1;
			while (s <= e) {
				mid = (s + e) / 2;
				if (arr[mid][0] > x)
					e = mid - 1;
				else if (arr[mid][0] < x)
					s = mid + 1;
				else {
					if (arr[mid][1] > y)
						e = mid - 1;
					else if (arr[mid][1] < y)
						s = mid + 1;
					else {
						cnt++;
						break;
					}
				}
			}

			// 찾아야하는 좌표 3
			x = arr[i][0];
			y = arr[i][1] + B;
			s = i;
			e = N - 1;
			while (s <= e) {
				mid = (s + e) / 2;
				if (arr[mid][0] > x)
					e = mid - 1;
				else if (arr[mid][0] < x)
					s = mid + 1;
				else {
					if (arr[mid][1] > y)
						e = mid - 1;
					else if (arr[mid][1] < y)
						s = mid + 1;
					else {
						cnt++;
						break;
					}
				}
			}

			if (cnt == 3)
				ans++;
		}
		System.out.println(ans);
	}

	static int lowerBound(int s, int num) {
		int e = N - 1;
		int mid, ans = N - 1;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid][0] >= num) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}
		return ans;
	}

	static int upperBound(int s, int num) {
		int e = N - 1;
		int mid, ans = N - 1;
		while (s <= e) {
			mid = (s + e) / 2;
			if (arr[mid][0] > num) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}
		return ans;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}