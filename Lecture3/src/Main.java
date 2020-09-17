import java.util.Scanner;		//	Scanner 클래스 사용을 위해서 추가 필요.
public class Main {
	//	1부터 n까지 합을 구하는 함수입니다.
	static long sum(int n) {
		long s = 0;
		for(int i=1;i<=n;i++) {
			s += i;		// 	s = s + i;
		}
		return s;
	}
	static long sum1(long n) {
		return n*(n+1)/2;
	}
	public static void main(String[] args) {
		//	Scanner 클래스 오브젝트를 하나 생성합니다.
		Scanner scan = new Scanner(System.in);

		//	입력 대기시간도 시간이 흐르기때문에 측정의 정확성을 위해서 입력은 측정하는 곳 밖에서 처리합니다.
		System.out.print("n을 입력하세요 : ");
		int n = scan.nextInt();
		
		//	System.currentTimeMillis() 함수는 현재 시간을 ms 단위로 보여줍니다.
		//	특정날짜, 시간을 0으로 해서, 누적된 값을 보여줍니다.
		//	특정작업의 경과시간을 측정하기 위해서 특정작업 시작전의 시간을 기록해서 start 변수에 저장합니다
		long start = System.currentTimeMillis();
		
		//	이곳에서 특정 작업을 합니다.
		System.out.println("Sum from 1 to "+n+" is "+sum1(n)+".");
		
		//	특정작업이 끝났을 때의 시간을 end에 저장합니다.
		long end = System.currentTimeMillis();
		
		//	경과 시간은 (end-start) ms가 됩니다.
		System.out.println("Elapsed time is "+(end-start)+"ms.");
	}
}
