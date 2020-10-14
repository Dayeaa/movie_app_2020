package d0224_Simulation_1_3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try {
			
			// �Է� �� �ʿ��� ���� ����
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[R][C];
			
			boolean[][] visit = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					visit[i][j] = false;
				}
			}
			
			List<int[]> water = new ArrayList<int[]>();
			
			int[] now = new int[2];
			
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') {
						int[] arr = new int[2];
						arr[0] = i;
						arr[1] = j;
						water.add(arr);
					}else if(map[i][j] == 'S') {
						now[0] = i;
						now[1] = j;
						map[i][j] = '.';
						
						visit[i][j] = true;
					}
				}
			}
			
			Queue<int[]> coordinates = new LinkedList<int[]>();
			coordinates.add(now);
			
			int minTime = -1;
			
			
			
			////////////////////////////////////////////////////////////////////////////////////
						
			// �� �ð�(1��)���� �����Ѵ�.
			
			// ���� ���� �۶߸��� ������ �� ��,
			// ����ġ�� �̵��� �� �ִ� ��� ����� ���� �����Ѵ�.
			
			// ����ġ�� �ִ� ���� ��ü�� �� ���� �湮�� �� �ִ� �ð���ŭ �����̸� (R*C - 1��)
			// ����ġ�� ����� ���� �����ϸ� ��� �����Ѵ�(�ּ� �ð��̹Ƿ�).
			
			// �ߺ��� ���ֱ� ���� �湮�� ĭ�� visit ó����
			
			for (int time = 1; time < R*C; time++) {
				
				// �� ������ �ϱ�
				List<int[]> extendedWater = new ArrayList<int[]>(); 
				for (int[] w : water) {
					int i = w[0];
					int j = w[1];
					
					if(0 < i && map[i-1][j] == '.') {
						map[i-1][j] = '*';
						
						int[] arr = new int[2];
						arr[0] = i-1;
						arr[1] = j;
						
						extendedWater.add(arr);
					}
					
					if(i < R - 1 && map[i+1][j] == '.') {
						map[i+1][j] = '*';
						
						int[] arr = new int[2];
						arr[0] = i+1;
						arr[1] = j;
						
						extendedWater.add(arr);
					}
					
					if(0 < j && map[i][j-1] == '.') {
						map[i][j-1] = '*';
						
						int[] arr = new int[2];
						arr[0] = i;
						arr[1] = j-1;
						
						extendedWater.add(arr);
					}
					
					if(j < C - 1 && map[i][j+1] == '.') {
						map[i][j+1] = '*';
						
						int[] arr = new int[2];
						arr[0] = i;
						arr[1] = j+1;
						
						extendedWater.add(arr);
					}
				}
				water = extendedWater;
				
				// ���� ��ġ�� ���� ��� �̵� ������ ����� ���� ����
				Queue<int[]> nextCoordinates = new LinkedList<int[]>();
				while(!coordinates.isEmpty()) {
					int i = coordinates.peek()[0];
					int j = coordinates.poll()[1];
					
					if( 0 < i && map[i-1][j] == 'D'
						||	i < R-1 && map[i+1][j] == 'D'
						||	0 < j && map[i][j-1] == 'D'
						||	j < C-1 && map[i][j+1] == 'D')	
					{
						minTime = time;
						break;
					}
					
					if(0 < i && map[i-1][j] == '.' && visit[i-1][j] == false) {
						int[] next = new int[2];
						next[0] = i-1;
						next[1] = j;
						
						nextCoordinates.add(next);
						visit[i-1][j] = true;
					}
					if(i < R-1 && map[i+1][j] == '.' && visit[i+1][j] == false) {
						int[] next = new int[2];
						next[0] = i+1;
						next[1] = j;
						
						nextCoordinates.add(next);
						visit[i+1][j] = true;
					}
					if(0 < j && map[i][j-1] == '.' && visit[i][j-1] == false) {
						int[] next = new int[2];
						next[0] = i;
						next[1] = j-1;
						
						nextCoordinates.add(next);
						visit[i][j-1] = true;
					}
					if(j < C-1 && map[i][j+1] == '.' && visit[i][j+1] == false) {
						int[] next = new int[2];
						next[0] = i;
						next[1] = j+1;
						
						nextCoordinates.add(next);
						visit[i][j+1] = true;
					}					
				}
				coordinates = nextCoordinates;
				
				if(minTime != -1) break;
			}
			
			////////////////////////////////////////////////////////////////////////////////////
			
			
			
			// ���
			if(minTime == -1) {
				System.out.println("KAKTUS");
			}else {
				System.out.println(minTime);
			}			
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}