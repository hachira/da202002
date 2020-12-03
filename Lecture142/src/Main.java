//	Lecture 14-2 해시 테이블 구현하기
//	해시테이블은 Map<KEY, VALUE> 형태의 자료구조로 많이 사용됩니다.
//	정렬이 필요없는 Map 자료구조이 경우에 사용하여 보통 UnorderedMap 형태로 이름이 바뀌어 사용됩니다.
//	또한 Set<KEY> 자료구조로도 사용합니다.
//	일반적으로 KEY는 중복되어서는 안 됩니다.  (Map, Set 모두 중복 허용하지 않습니다.)
//	중복된 Set<KEY>는 Map<Key, int> 형태로 운영됩니다.
import java.util.Scanner;
class HashTable<KEY, VALUE> {
	//	해시 테이블에 필요한 자료구조형
	KEY[] keys;				//	키를 저장할 배열
	VALUE[] values;			//	값들을 저장할 배열
	int size;				//	해시 테이블의 크기
	//	생성자 (해시테이블 크기를 입력으로 받아서 초기값 설정)
	HashTable(int msize) {
		//	배열을 할당합니다.
		size = msize;
		keys = (KEY[]) new Object[size];
		values = (VALUE[]) new Object[size];
	}
	//	해시를 구하는 함수.
	//	제네릭 타입에는 hashCode()라는 함수를 제공합니다.  반환값은 int 형입니다.
	//	강제로 양수를 만든 후에 size로 나눈 나머지값을 사용합니다.
	int hash(KEY key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}
	int hash2(KEY key) {
		return (key.hashCode() & 0x7fffffff) % 7 + 1;
	}
	//	해시테이블에 주어진 <key, value> 쌍을 추가합니다.
	void put(KEY key, VALUE value) {
		//	해시값을 구합니다.
		int h = hash(key);
		int d = hash2(key);
		//	선형 1차 조사를 하면서 비어진 칸을 찾습니다.
		while(keys[h]!=null) {
			System.out.println(key+" : "+keys[h]+"가 이미 해당 자리에 있습니다");
			h = (h+d)%size;
		}
		//	빈자리를 찾았으니, key값과 value값을 저장합니다.
		keys[h] = key;
		values[h] = value;
	}
	//	해시테이블에서 key 값에 대한 value 값을 찾습니다.
	//	못찾으면 null 반환
	VALUE get(KEY key) {
		//	해시값을 구합니다.
		int h = hash(key);
		int d = hash2(key);
		//	선형 1차 조사를 하면서 비어진 칸을 찾습니다.
		while(values[h]!=null) {
			//	같은 키인지 검사해서 반환
			if(key.equals(keys[h])) return values[h];
			h = (h+d)%size;
		}
		return null;
	}
	//	해시테이블에서 key 값이 존재하는지 검사합니다.
	boolean contain(KEY key) {
		return get(key) != null;
	}
}
public class Main {
	public static void main(String[] args) {
		//	해시테이블 클래스 오브젝트를 생성합니다.
		//	해시테이블 크기는 13으로 할께요.  (10개 데이터 넣으면 적재율 0.77)
		HashTable<String, Integer> map = new HashTable(13);
		map.put("하나", 1);
		map.put("둘", 2);
		map.put("셋", 3);
		map.put("넷", 4);
		map.put("다섯", 5);
		map.put("여섯", 6);
		map.put("일곱", 7);
		map.put("여덟", 8);
		map.put("아홉", 9);
		map.put("열", 10);
		//	입력을 받고서, 해당 내용이 있으면 출력, 아니면 없다고 출력
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("키 입력 : ");
			String key = scan.next();
			if(key.equals("나가기")) break;
			if(map.contain(key)) {
				System.out.println(key+"는 "+map.get(key)+"입니다");
			}
			else {
				System.out.println(key+"는 매핑되지 않았습니다");
			}
		}
	}
}
