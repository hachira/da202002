//	Lecture 14 ������׷����� ���� ū ���簢�� ���� ���ϱ�
//	������׷��� ������ �׷����� �׸� ���Դϴ�.
//	�̶� ��������� ������׷� �׷������� ���� ���� ���簢���� ���̸� ���ϴ� ������
//	�������� �˰����� ��ǥ�� �����Դϴ�.
//	�Է��� ������ ��(N)�� �Է¹ް� �� ������ ������ �Է¹޽��ϴ�.
//	{ 3, 1, 4, 3 } �� ������ ���� ����� �Է�����
//	4 3 1 4 3
//	�� �˴ϴ�.
//	����� ���� ū ���簢�� ���̸� ����ϸ� �˴ϴ�.
//	6
import java.util.Scanner;
public class Main {
	//	���������� ���� histo �Լ�
	static int histo(int[] v, int a, int b) {
		return 0;
	}
	//	���� ū ���簢���� ���̸� ��ȯ�մϴ�.
	//	n : ������ ��
	//	v : n���� ���õ��� ����
	//	��ȯ : ���簢���� ����
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	public static void main(String[] args) {
		//	��ĳ�� ������Ʈ ����
		Scanner scan = new Scanner(System.in);
		//	������ �� �Է�
		int n = scan.nextInt();
		//	������ ������ �迭 ����
		int[] v = new int[n];
		//	n���� ������ �Է¹޾� �迭 v�� ����
		for(int i = 0;i<n; i++) {
			v[i] = scan.nextInt();
		}
		//	���� ū ���簢���� ���� ���
		int r = histo(v, n);
		//	���
		System.out.println(r);
	}
}
