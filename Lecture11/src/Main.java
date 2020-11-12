//	Lecture 11
//	기본 정렬 프로그램 작성하기.  (선택정렬 & 삽입정렬)
import java.util.Random;		//	random 함수 사용을 위한 라이브러리
import java.util.Scanner;		//	키보드 입력을 하기 위한 라이브러리
public class Main {
	//	선택정렬 함수 (v : 정렬할 배열, n : 배열의 크기)
	static void selectionSort(int[] v, int n) {
		//	1. 배열 인덱스 0부터 n-2까지에 대해서
		for(int i = 0; i <= n-2; i++) {
			//	2. [i, n-1] 범위 안에서 최소값을 가지는 배열 인덱스를 찾습니다.
			int min = i;
            for(int j=i+1; j<n; j++) {
                if(v[min]>v[j]) min=j;
            }
			//	3. v[min] 과 v[i]를 서로 맞바꿉니다.
			int tmp = v[min];
			v[min] = v[i];
			v[i] = tmp;
		}
	}
	//	삽입정렬 함수 (v : 정렬할 배열, n : 배열의 크기)
	static void insertionSort(int[] v, int n) {
		//	1. [1..n-1] 범위에 대해서 수행
		for(int i = 1; i < n; i++) {
			//	2. v[i] 값을 [0..i-1] 배열의 적당한 곳에 끼어 넣는다.
			//	2-1. last 값에 i값으로 초기화하고, r 변수에 v[i]값을 복사(대피)합니다.
			int last = i;
			int r = v[i];
			//	2-2. last 값이 0보다 크고, v[last-1] 이 r 값보다 큰 값인 한 다음작업 수행
			//	2-2-1. v[last-1] 값을 오른쪽 배열공간인 v[last]로 이동
			//	2-2.2. last 값을 하나 감소
			while( last > 0 && v[last-1] > r ) {
				v[last] = v[last-1];
				last--;
			}
			//	2-3. v[last]에 r값을 복사
			v[last] = r;
		}
	}
	public static void main(String[] args) {
		//	무작위 값을 생성하기 위하여 Random 오브젝트를 생성.
		Random rand = new Random(100);
		//	정렬할 데이터의 크기를 입력 받습니다.
		System.out.print("Enter the size of array : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//	크기가 n인 배열을 생성합니다.
		int[] v = new int[n];
		//	크기가 n인 배열에 무작위값을 넣습니다.
		for(int i = 0; i < n; i++) {
			v[i] = rand.nextInt(10000);
		}
		//	시간 측정을 위해서 현재 시간을 저장합니다.
		long t = System.currentTimeMillis();
		//	정렬을 실행합니다.
		selectionSort(v, n);
		//	시간 측정 결과를 출력합니다.
		long elapsed = System.currentTimeMillis()-t;
		System.out.println("Elapsed : " + elapsed + "ms");
		//	데이터에 맞게 정렬되었는디 앞의 20개의 데이터를 출력합니다.
		for(int i = 0; i < 20; i++) {
			System.out.print(v[i]+" ");
		}
	}
}
