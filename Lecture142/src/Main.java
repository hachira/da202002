//	Lecture 14-2 �ؽ� ���̺� �����ϱ�
//	�ؽ����̺��� Map<KEY, VALUE> ������ �ڷᱸ���� ���� ���˴ϴ�.
//	������ �ʿ���� Map �ڷᱸ���� ��쿡 ����Ͽ� ���� UnorderedMap ���·� �̸��� �ٲ�� ���˴ϴ�.
//	���� Set<KEY> �ڷᱸ���ε� ����մϴ�.
//	�Ϲ������� KEY�� �ߺ��Ǿ�� �� �˴ϴ�.  (Map, Set ��� �ߺ� ������� �ʽ��ϴ�.)
//	�ߺ��� Set<KEY>�� Map<Key, int> ���·� ��˴ϴ�.
import java.util.Scanner;
class HashTable<KEY, VALUE> {
	//	�ؽ� ���̺� �ʿ��� �ڷᱸ����
	KEY[] keys;				//	Ű�� ������ �迭
	VALUE[] values;			//	������ ������ �迭
	int size;				//	�ؽ� ���̺��� ũ��
	//	������ (�ؽ����̺� ũ�⸦ �Է����� �޾Ƽ� �ʱⰪ ����)
	HashTable(int msize) {
		//	�迭�� �Ҵ��մϴ�.
		size = msize;
		keys = (KEY[]) new Object[size];
		values = (VALUE[]) new Object[size];
	}
	//	�ؽø� ���ϴ� �Լ�.
	//	���׸� Ÿ�Կ��� hashCode()��� �Լ��� �����մϴ�.  ��ȯ���� int ���Դϴ�.
	//	������ ����� ���� �Ŀ� size�� ���� ���������� ����մϴ�.
	int hash(KEY key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}
	int hash2(KEY key) {
		return (key.hashCode() & 0x7fffffff) % 7 + 1;
	}
	//	�ؽ����̺� �־��� <key, value> ���� �߰��մϴ�.
	void put(KEY key, VALUE value) {
		//	�ؽð��� ���մϴ�.
		int h = hash(key);
		int d = hash2(key);
		//	���� 1�� ���縦 �ϸ鼭 ����� ĭ�� ã���ϴ�.
		while(keys[h]!=null) {
			System.out.println(key+" : "+keys[h]+"�� �̹� �ش� �ڸ��� �ֽ��ϴ�");
			h = (h+d)%size;
		}
		//	���ڸ��� ã������, key���� value���� �����մϴ�.
		keys[h] = key;
		values[h] = value;
	}
	//	�ؽ����̺��� key ���� ���� value ���� ã���ϴ�.
	//	��ã���� null ��ȯ
	VALUE get(KEY key) {
		//	�ؽð��� ���մϴ�.
		int h = hash(key);
		int d = hash2(key);
		//	���� 1�� ���縦 �ϸ鼭 ����� ĭ�� ã���ϴ�.
		while(values[h]!=null) {
			//	���� Ű���� �˻��ؼ� ��ȯ
			if(key.equals(keys[h])) return values[h];
			h = (h+d)%size;
		}
		return null;
	}
	//	�ؽ����̺��� key ���� �����ϴ��� �˻��մϴ�.
	boolean contain(KEY key) {
		return get(key) != null;
	}
}
public class Main {
	public static void main(String[] args) {
		//	�ؽ����̺� Ŭ���� ������Ʈ�� �����մϴ�.
		//	�ؽ����̺� ũ��� 13���� �Ҳ���.  (10�� ������ ������ ������ 0.77)
		HashTable<String, Integer> map = new HashTable(13);
		map.put("�ϳ�", 1);
		map.put("��", 2);
		map.put("��", 3);
		map.put("��", 4);
		map.put("�ټ�", 5);
		map.put("����", 6);
		map.put("�ϰ�", 7);
		map.put("����", 8);
		map.put("��ȩ", 9);
		map.put("��", 10);
		//	�Է��� �ް�, �ش� ������ ������ ���, �ƴϸ� ���ٰ� ���
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("Ű �Է� : ");
			String key = scan.next();
			if(key.equals("������")) break;
			if(map.contain(key)) {
				System.out.println(key+"�� "+map.get(key)+"�Դϴ�");
			}
			else {
				System.out.println(key+"�� ���ε��� �ʾҽ��ϴ�");
			}
		}
	}
}
