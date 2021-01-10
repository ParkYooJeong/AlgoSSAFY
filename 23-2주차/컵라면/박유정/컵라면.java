package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class �Ŷ�� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {// ������κ�����, �Ŷ�� ������
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(arr[0][1]);// ù������ �־���
		int time = 1;// ����ð�

		for (int i = 1; i < N; i++) {
			if (arr[i][0] > time) {// ������θ��� �ȵȰ�(����ð� ���� ū��)
				q.add(arr[i][1]);
				time++;
			}

			else if (q.peek() < arr[i][1]) {// ��������� �����Ǿ���, ������������߿� �Ŷ���� �� �̵��ΰ�
				q.poll();// ����������
				q.add(arr[i][1]);// ���粨�� ���
			}
		}
		int sum = 0;
		for (int n : q) {
			sum += n;
		}
		System.out.println(sum);
	}
}
