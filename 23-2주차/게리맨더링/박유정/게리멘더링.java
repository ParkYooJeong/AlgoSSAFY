package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �Ը������ {
	static int max = Integer.MAX_VALUE;
	static int N, sum, answer = max;
	static int[] per;
	static boolean[] selected;
	static int[] input;
	static ArrayList<Integer>[] al;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		per = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			per[i] = Integer.parseInt(st.nextToken());
			sum += per[i];
		}

		al = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			al[i] = new ArrayList<Integer>();
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				al[i].add(Integer.parseInt(st.nextToken()) - 1);

			}
		}

		selected = new boolean[N];
		input = new int[N];

		sub(0, 0);

		if (answer == max)
			System.out.println(-1);
		else {
			System.out.println(answer);
		}

	}

	private static void sub(int cnt,  int tcnt) {
		if (cnt == N) {

			if (tcnt == 0 || tcnt == N)// �� ���ű��� ��� �ϳ��� ������ �����ؾ� �Ѵ�.
				return;

			if (bfs(tcnt, true) && bfs(N - tcnt, false)) {// ��� ����Ǿ� �ִ�.
				int s = 0;

				for (int i = 0; i < N; i++) {
					if (selected[i]) {// �α� ����
						s += per[i];
					}
				}
				answer = answer > (int) Math.abs(sum - 2 * s) ? (int) Math.abs(sum - 2 * s) : answer;// �ּ�
			}
			return;
		}
		selected[cnt] = true;
		sub(cnt + 1,  tcnt + 1);
		selected[cnt] = false;
		sub(cnt + 1,  tcnt);
	}

	private static boolean bfs(int M, boolean flag) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visit[] = new boolean[N];

		for (int i = 0; i < N; i++) {
			if (selected[i] == flag) {// ù���� ��� �־��ְ� bfs
				q.add(i);
				visit[i] = true;
				break;
			}
		}
		int cnt = 0;

		while (!q.isEmpty()) {
			int n = q.poll();
			cnt++;

			if (cnt == M) // �κ������� ��� �̾���������
				return true;

			for (int i = 0; i < al[n].size(); i++) {
				int m = al[n].get(i);
				if (visit[m] || selected[m] != flag)
					continue;
				visit[m] = true;
				q.add(m);
			}
		}
		return false;
	}
}
