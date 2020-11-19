//	Lecture 12 Merge Sort Programming
//	분할정복(Divide and Conquer) 기법을 이용한 합병정렬(Merge Sort) 프로그램을 작성해봅니다.
import java.util.Scanner;		//	입력처리를 위한 모듈
import java.util.Random;		//	무작위값 생성을 위한 모듈
public class Main {
	//	선택정렬을 위한 함수
	static void selectionSort(int[] v, int n) {
		selectionSort(v, 0, n-1);
	}
	//	선택정렬 구간을 위한 함수 v[a]~v[b] 배열 내용까지를 정렬합니다.
	static void selectionSort(int[] v, int a, int b) {
		for(int i=a;i<b;i++) {
			int min = i;
			for(int j=i+1;j<=b;j++) {
				if(v[min]>v[j]) min=j;
			}
			int t = v[i]; v[i] = v[min]; v[min] = t;
		}
	}
	//	배열을 합칠때 임시로 사용할 배열
	static int[] tv;
	//	합병정렬을 위해서 앞의 배열과 뒤의 배열을 합치는 과정
	//	v : 두개로 나뉘어져서 정렬된 배열
	//	v[a]~v[c] : 정렬된 전반부 배열
	//	v[c+1]~v[b] : 정렬된 후반부 배열
	static void merge(int[] v, int a, int b, int c) {
		//	1. 배열의 전반부를 탐색할 변수, 배열의 후반부를 탐색할 변수, 저장할 임시 배열을 지정할 변수를 초기화합니다.
		int i = a, j = c+1, k = a;
		//	2. 전반부 배열값과 후반부 배열값을 비교해서 임시 배열에 저장합니다.
		while(i<=c && j<=b) {
			if(v[i]<v[j]) tv[k++] = v[i++];
			else tv[k++] = v[j++];
		}
		//	3. 짜투리 배열공간을 임시 배열에 저장합니다.
		while(i<=c) tv[k++] = v[i++];
		while(j<=b) tv[k++] = v[j++];
		//	4. 임시 배열 내용을 v 배열로 복사합니다.
		for(i=a;i<=b;i++) v[i]=tv[i];
	}
	//	병합정렬을 위한 함수
	static void mergeSort(int[] v, int n) {
		//	임시 저장 배열을 여기서 할당합니다.
		tv = new int[n];
		mergeSort(v, 0, n-1);
	}
	//	합병정렬 구간을 위한 함수.  v[a]~v[b] 배열 내용가지 정렬
	static void mergeSort(int[] v, int a, int b) {
		//	0. v[a]~v[b] 구간에 있는 배열 원소의 갯수가 1개 이하인 경우는 정렬 불필요
		if(a>=b) return;
		//	1. 중앙값을 찾습니다.
		int c = (a+b)/2;
		//	2. 전반부 배열과 후반부 배열을 각각 정렬합니다.
		mergeSort(v, a, c);
		mergeSort(v, c+1, b);
		//	3. 정렬된 두개의 배열을 합칩니다.
		merge(v, a, b, c);
	}
	public static void main(String[] args) {
		//	정렬할 데이터의 갯수를 입력받습니다.
		Scanner scan = new Scanner(System.in);
		System.out.print("데이터의 갯수 입력 : ");
		int n = scan.nextInt();
		
		//	정렬할 데이터를 저장할 배열을 할당합니다.
		//	배열은 대조군과 실험군 두가지를 생성토록 합니다.
		//	대조군은 이미 알고 있는 알고리즘으로 처리해서 결과를 저장하고,
		//	실험군은 새로운 알고리즘으로 처리해서 결과를 저장합니다.
		//	대조군과 실험군은 처리된 시간 비교, 결과 비교를 합니다.
		int[] v1 = new int[n];
		int[] v2 = new int[n];
		
		//	무작위수를 발생시켜서 배열에 저장합니다.
		Random r = new Random(1000);
		for(int i = 0; i < n; i++) v1[i] = v2[i] = r.nextInt(1000000);
		
		//	선택정렬을 이용하여 연산을 합니다.
		long t1 = System.currentTimeMillis();
		selectionSort(v1, n);
		t1 = System.currentTimeMillis()-t1;
		
		//	합병정렬을 이용하여 연산을 합니다.
		long t2 = System.currentTimeMillis();
		mergeSort(v2, n);
		t2 = System.currentTimeMillis()-t2;
		
		System.out.println("선택정렬 : "+t1+"ms");
		System.out.println("합병정렬 : "+t2+"ms");
		
		//	데이터가 올바른지 검사합니다.
		boolean isValid = true;
		for(int i=0; i<n; i++) if(v1[i]!=v2[i]) { isValid=false; break; }
		System.out.println(isValid?"올바른 정렬 결과":"잘못된 정렬 결과");
	}
}
