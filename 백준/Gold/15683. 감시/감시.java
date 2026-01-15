import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, len;
	static int[][] arr, board;
	static List<int[]> list = new ArrayList<>();
	static int[] lst;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][][] cctvDir = {
			{},
			{{0}, {1}, {2}, {3}},
			{{0,2}, {1,3}},
			{{0,1}, {1,2}, {2,3}, {3,0}},
			{{3,0,1}, {0,1,2}, {1,2,3}, {2,3,0}},
			{{0,1,2,3}}
	};
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0 || arr[i][j] == 6)
					continue;
				list.add(new int[] { i, j });
			}
		}
	}

	static void pro() throws IOException {
		len = list.size();
		lst = new int[len];

		recur(0);
		
		System.out.println(ans);
	}

	static void recur(int cur) throws IOException {
		// cctv 개수가 되면 종료
		if (cur == len) {
			// 사각지대 계산
			ans = Math.min(ans, getArea());
			return;
		}

		// cctv 방향 설정
		int x = list.get(cur)[0];
		int y = list.get(cur)[1];
		
		for (int i = 0; i < cctvDir[arr[x][y]].length; i++) {
			lst[cur] = i;
			recur(cur + 1);
		}
	}

	static int getArea() throws IOException {
		int x, y, nx, ny, dir, k, num;
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < len; i++) {
			x = list.get(i)[0];
			y = list.get(i)[1];
			num = arr[x][y];
			for(int j = 0; j<cctvDir[num][lst[i]].length; j++) {
				dir = cctvDir[num][lst[i]][j];
				k = 1;
				while (true) {
					nx = x + k * dx[dir];
					ny = y + k * dy[dir];
					if (!inRange(nx, ny))
						break;
					if (arr[nx][ny] == 6)
						break;
					board[nx][ny] = 7;
					k++;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0)
					sum++;
			}
		}

		return sum;
	}

	static boolean inRange(int x, int y) throws IOException {
		if (x < 0 || y < 0 || x == N || y == M)
			return false;
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
