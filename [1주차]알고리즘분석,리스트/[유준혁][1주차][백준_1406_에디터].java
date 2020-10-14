package workspace;
import java.io.*;
import java.util.*;
import java.util.stream.*;
class Main {
	public static void main(String[] a) throws Exception{
		/*
		 * ù��° �õ�
		 * StringBuffer �� insert �޼ҵ嶧���� �ð��ʰ��� ���� �� ��.
		 * JAVA DOC ã�ƺ��� AbstarctStringBuilder�� shift->System.arraycopy�� �̿��ϴ� �� �߰�
		 * �߰�,���� ��û�� ���� �� ���� �迭�� �ø��� ���̴� ������ �ϴٺ��� �ð��� �����ɸ��� ��.
		 */
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuffer input = new StringBuffer(br.readLine());
//		int i=Integer.parseInt(br.readLine());
//		int index=input.length();
//		int len=index;
//		while(i-->0) {
//			String s = br.readLine();
//			switch(s.charAt(0)) {
//			case 'L':if(index>0)--index;break;
//			case 'D':if(index<len)++index;break;
//			case 'B':if(index>0) {input.deleteCharAt(--index);}break;
//			case 'P':input.insert(index++, s.charAt(2));len++;break;
//			}
//		}
//		System.out.println(new String(input));
		/*
		 * �ι�° �õ�
		 * ����� ����ϳ� ���� �޸𸮸� ���� Stack ���.
		 * s1�� index 0���� ������ �ϰ� s2�� top�������� ������ �ùٸ��� �������. 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		for(byte b : br.readLine().getBytes())s1.add((char)b);
		int i=Integer.parseInt(br.readLine());
		while(i-->0) {
			String s = br.readLine();
			switch(s.charAt(0)) {
			case 'L':if(s1.size()>0)s2.add(s1.pop());break;
			case 'D':if(s2.size()>0)s1.add(s2.pop());break;
			case 'B':if(s1.size()>0)s1.pop();break;
			case 'P':s1.add(s.charAt(2));break;
			}
		}
		StringBuffer sb = new StringBuffer();
		for(i=0; i<s1.size(); i++)sb.append(s1.get(i));
		while(s2.size()>0)sb.append(s2.pop());
		System.out.println(sb);
	}
}
