package d0217_SegmentTree_P2042;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

���� �� ���ϱ�

����
� N���� ���� �־��� �ִ�. �׷��� �߰��� ���� ������ ����� �Ͼ�� �� �߰��� � �κ��� ���� ���Ϸ� �Ѵ�. 
���࿡ 1,2,3,4,5 ��� ���� �ְ�, 3��° ���� 6���� �ٲٰ� 2��°���� 5��°���� ���� ���϶�� �Ѵٸ� 17�� ����ϸ� �Ǵ� ���̴�. 
�׸��� �� ���¿��� �ټ� ��° ���� 2�� �ٲٰ� 3��°���� 5��°���� ���� ���϶�� �Ѵٸ� 12�� �� ���̴�.

�Է�
ù° �ٿ� ���� ���� N(1 �� N �� 1,000,000)�� M(1 �� M �� 10,000), K(1 �� K �� 10,000) �� �־�����. 
M�� ���� ������ �Ͼ�� ȸ���̰�, K�� ������ ���� ���ϴ� ȸ���̴�. 
�׸��� ��° �ٺ��� N+1��° �ٱ��� N���� ���� �־�����. 
�׸��� N+2��° �ٺ��� N+M+K+1��° �ٱ��� �� ���� ���� a, b, c�� �־����µ�, 
a�� 1�� ��� b��° ���� c�� �ٲٰ� a�� 2�� ��쿡�� b��° ������ c��° �������� ���� ���Ͽ� ����ϸ� �ȴ�.

a�� 1�� ��� c�� long long ������ ���� �ʴ´�.

���
ù° �ٺ��� K�ٿ� ���� ���� ������ ���� ����Ѵ�. ��, ������ long long ������ ���� �ʴ´�.

���� �Է�
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

���� ���
17
12

 */
public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			long[] arr = new long[N+1];
			
			for (int i = 1; i <= N; i++) {
				arr[i] = Long.parseLong(br.readLine());
			}
			
			
			// if
			//        	2^(n-1) < N <= 2^n
			// 	  	   	->  (n-1) < logN <= n
			// then 
			//        	let n=��logN��
			int n = 0;
			int m = 1;
			for (int i = 0; i <= 20; i++) {
				if(N <= m) {
					n = i;
					break;
				}else {
					m *= 2;
				}
			}
			
			long[] tree = new long[m*2];
			tree[1] = init(arr, tree, 1, 1, N);
			
			
			
			for (int i = 0; i < M + K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(a == 1) {
					int b = Integer.parseInt(st.nextToken());
					long c = Long.parseLong(st.nextToken());
					
					long diff = c - arr[b];
					arr[b] = c;
					
					update(tree, 1, 1, N, b, diff);
				}else if(a == 2) {
					int b = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					
					long sum = sum(tree, 1, 1, N, b, c);
					System.out.println(sum);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static long init(long[] arr, long[] tree, int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];
		}else {
			return tree[node] = init(arr, tree, node*2, start, (start+end)/2) 
										+ init(arr, tree, node*2 + 1, (start+end)/2 + 1, end);
		}
	}
	
	static void update(long[] tree, int node, int start, int end, int index, long diff) {
		tree[node] += diff;
		if(start == end) {
			return;
		}else if(index <= (start+end)/2) {
			update(tree, node*2, start, (start+end)/2, index, diff);
		}else {
			update(tree, node*2 + 1, (start+end)/2 + 1, end, index, diff);
		}
	}
	
	static long sum(long[] tree, int node, int start, int end, int left, int right) {
		if(left <= start && end <= right) {
			return tree[node];
		}else if(right <= (start+end)/2) {
			return sum(tree, node*2, start, (start+end)/2, left, right);
		}else if((start+end)/2 + 1 <= left) {
			return sum(tree, node*2+1, (start+end)/2 + 1, end, left, right);
		}else {
			return sum(tree, node*2, start, (start+end)/2, left, right) + sum(tree, node*2+1, (start+end)/2 + 1, end, left, right);
		}
	}

}
