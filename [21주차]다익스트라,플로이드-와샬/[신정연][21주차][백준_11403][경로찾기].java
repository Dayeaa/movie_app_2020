package week22;

import java.io.*;

/*
 * �÷��̵� �ͼ� �˰���
 * 
 * ����_11404_��� ã��
 */
public class Problem_11403 {
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				int a = Integer.parseInt(input[j]);
				arr[i][j] = a;
			}
		}
		
		for(int i=0; i<n; i++) {  // ����
			for(int j=0; j<n; j++) {  // ���
				for(int k=0; k<n; k++) {  // ����
					if(arr[j][i] + arr[i][k] == 2) arr[j][k] = 1;  // ��򰡸� ���ļ� ������ ������ ���
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
