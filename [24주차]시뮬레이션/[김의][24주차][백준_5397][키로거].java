package d0224_Simulation_2_5397;

/*
����
â���̴� �������� ��й�ȣ�� ��ġ�� ���ؼ� �����̰� ����ϴ� ��ǻ�Ϳ� Ű�ΰŸ� ��ġ�ߴ�. 
��ĥ�� ��ٸ� ���� â���̴� �����̰� ��й�ȣ â�� �Է��ϴ� ���ڸ� ���´�.

Ű�ΰŴ� ����ڰ� Ű���带 ���� ����� ��� ����Ѵ�. 
����, �����̰� ��й�ȣ�� �Է��� ��, ȭ��ǥ�� �齺���̽��� �Է��ص� ��Ȯ�� ��й�ȣ�� �˾Ƴ� �� �ִ�.

�����̰� ��й�ȣ â���� �Է��� Ű�� �־����� ��, �������� ��й�ȣ�� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. 
�� �׽�Ʈ ���̽��� ���ٷ� �̷���� �ְ�, �����̰� �Է��� ������� ���̰� L�� ���ڿ��� �־�����. (1 �� L�� ���� �� 1,000,000) 
�����̰� �齺���̽��� �Է��ߴٸ�, '-'�� �־�����. 
�̶� Ŀ���� �ٷ� �տ� ���ڰ� �����Ѵٸ�, �� ���ڸ� �����. 
ȭ��ǥ�� �Է��� '<'�� '>'�� �־�����. 
�̶��� Ŀ���� ��ġ�� ������ �� �ִٸ�, ���� �Ǵ� ���������� 1��ŭ �����δ�. 
������ ���ڴ� ��й�ȣ�� �Ϻ��̴�. 
����, ���߿� �齺���̽��� ���ؼ� ���� ���� �ִ�. 
���� Ŀ���� ��ġ�� ���� �������� �ƴ϶��, �� ���ڸ� �Է��ϰ�, Ŀ���� ���������� �� ĭ �̵��Ѵ�.

���
�� �׽�Ʈ ���̽��� ���ؼ�, �������� ��й�ȣ�� ����Ѵ�. 
��й�ȣ�� ���̴� �׻� 0���� ũ��.


���� �Է�
2
<<BP<A>>Cd-
ThIsIsS3Cr3t


���� ���
BAPC
ThIsIsS3Cr3t
 */


import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				List<Integer> list = new LinkedList<Integer>();
				ListIterator<Integer> ir = list.listIterator();
				
				while(true) {
					int c = br.read();
					
					if(c == '\n') break;
					
					if(c == '-') {
						if(ir.hasPrevious()) {
							ir.previous();
							ir.remove();
						}
					}
					else if(c == '<') {
						if(ir.hasPrevious()) {
							ir.previous();
						}
					}
					else if(c == '>') {
						if(ir.hasNext()) {
							ir.next();
						}
					}
					else {
						ir.add(c);
					}
				}
				
				for (Integer word : list) {
					bw.write(word);
				}
				bw.write('\n');
			}
			
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
