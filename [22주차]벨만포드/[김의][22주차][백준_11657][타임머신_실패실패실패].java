package d0210_BellmanFord_P11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
����
N���� ���ð� �ִ�. �׸��� �� ���ÿ��� ����Ͽ� �ٸ� ���ÿ� �����ϴ� ������ M�� �ִ�. �� ������ A, B, C�� ��Ÿ�� �� �ִµ�, A�� ���۵���, B�� ��������, C�� ������ Ÿ�� �̵��ϴµ� �ɸ��� �ð��̴�. �ð� C�� ����� �ƴ� ��찡 �ִ�. C = 0�� ���� ���� �̵��� �ϴ� ���, C < 0�� ���� Ÿ�Ӹӽ����� �ð��� �ǵ��ư��� ����̴�.

1�� ���ÿ��� ����ؼ� ������ ���÷� ���� ���� ���� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ���� N (1 �� N �� 500), ���� �뼱�� ���� M (1 �� M �� 6,000)�� �־�����. ��° �ٺ��� M���� �ٿ��� ���� �뼱�� ���� A, B, C (1 �� A, B �� N, -10,000 �� C �� 10,000)�� �־�����. 

���
���� 1�� ���ÿ��� ����� � ���÷� ���� �������� �ð��� ������ ���� ������ �ǵ��� �� �ִٸ� ù° �ٿ� -1�� ����Ѵ�. �׷��� �ʴٸ� N-1�� �ٿ� ���� �� �ٿ� 1�� ���ÿ��� ����� 2�� ����, 3�� ����, ..., N�� ���÷� ���� ���� ���� �ð��� ������� ����Ѵ�. ���� �ش� ���÷� ���� ��ΰ� ���ٸ� ��� -1�� ����Ѵ�.

�����Է�1
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

�������1
4
3

�����Է�2
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2

�������2
-1

�����Է�3
3 2
1 2 4
1 2 3

�������3
3
-1
 */

public class Main {
	public static final int INF = 500000000;

	public static void main(String[] args) {
		try {
			int V, E;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			Vertex[] vertices = new Vertex[V+1];
			for (int i = 1; i <= V; i++) {
				vertices[i] = new Vertex();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				Edge edge = new Edge(vertices[end], cost);
				
				vertices[start].addEdgeTovertex(edge);
			}
			
			vertices[1].dist = 0;
			
			for (int i = 1; i < V; i++) {
				for (int j = i; j <= V; j++) {
					Vertex v1= vertices[j];
					for (Edge edge : v1.edgeList) {
						Vertex v2 = edge.endVertex;
						int cost = edge.cost;
						if(v1.dist +cost < v2.dist) {
							v2.dist = v1.dist + cost;
						}
					}
				}
				
				for (int j = 1; j < i; j++) {
					Vertex v1= vertices[j];
					for (Edge edge : v1.edgeList) {
						Vertex v2 = edge.endVertex;
						int cost = edge.cost;
						if(v1.dist +cost < v2.dist) {
							v2.dist = v1.dist + cost;
						}
					}
				}
			}

			for(int i = 1; i <= V; i++) {
				Vertex v1 = vertices[i];
				for (Edge edge : v1.edgeList) {
					Vertex v2 = edge.endVertex;
					int cost = edge.cost;
					if(v1.dist + cost < v2.dist) {
						System.out.println("-1");
						br.close();
						return;
					}
				}
			}
			
			
			for (int i = 2; i <= V; i++) {
				if (vertices[i].dist == INF) {
					System.out.println("-1");
				} else {
					System.out.println(vertices[i].dist);
				}
			}
			
			
			
			br.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Vertex implements Comparable<Vertex>{
	public int dist;
	public List<Edge> edgeList;
	
	public Vertex() {
		dist = Main.INF;
		edgeList = new ArrayList<Edge>();
	}
	
	public void addEdgeTovertex(Edge edge) {
		this.edgeList.add(edge);
	}

	@Override
	public int compareTo(Vertex target) {
		return this.dist > target.dist ? 1 : -1;
	}
}

class Edge{
	public Vertex endVertex;
	public int cost;
	
	public Edge(Vertex endVertex, int cost) {
		this.endVertex = endVertex;
		this.cost = cost;
	}
}
