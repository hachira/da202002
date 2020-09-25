import java.util.Scanner;

public class Main {
	//	입력값 n에 대하여, 1부터 n까지 소수의 개수를 세어서 반환하는 함수
	static int pi(int n) {
		//	소수의 개수를 셀 pcount라는 변수를 선언하고 0으로 초기화합니다.
		int pcount = 0;
		//	1부터 n까지 for 루프를 돌면서, 해당 수가 소수이면 pcount를 증가시킵니다.
		for(int p = 1; p <= n; p++) {
			//	p가 소수이면, pcount를 1 증가
			//	%는 나머지연산자입니다.
			//	10%3 = 10을 3으로 나눈 나머지 = 1
			//	if( p%d == 0 ) --> p는 d로 나누어떨어진다.
			//	약수의 개수를 저장할 변수 dcount 선언하고 0으로 초기화한다.
			int dcount = 0;
			for(int d = 1; d <= p; d++) {
				//	p를 d로 나눌 수 있다면, d는 p의 약수이므로 dcount를 1 증가시킨다.
				if(p%d == 0) dcount++;
			}
			//	약수의 개수가 2라면, p는 소수이므로 pcount를 1 증가시킨다.
			if(dcount==2) pcount++;
		}
		
		return pcount;
	}
	//	속도를 개선한 버전을 만들자.
	//	약수의 개수가 2개라는 조건을 그대로 쓰면 속도가 느리다.
	//	소수의 약수는 1과 자기자신이므로 1과 자기자신을 제외한 수에 대해서 나누어떨어지면 소수가 아니다.
	//	이 사실을 적용해서 만들어보도록 합니다.
	static int pi1(int n) {
		//	예외처리를 통해서 성능향상이 가능합니다.
		//	짝수소수는 오직 2밖에 없다는 사실을 이용해서 성능향상을 해보도록 합니다.
		if(n<2) return 0;
		if(n==2) return 1;
		int pcount = 1;
		//	이제 홀수 소수만 구해보도록 합니다.
		for( int p = 3; p <= n; p+=2 ) {
			//	나누어 떨어지는 수가 있을때, 탈출하는 명령어 break을 이용하여 구현합니다.
			boolean isPrime = true;
			//	d를 2부터 p-1까지 반복수행하면서, p를 나누어떨어뜨릴때 for루프를 빠져나오게 해서
			//	속도를 높입니다.
			//	모든 약수는 페어형태로 존재합니다.
			//	sqrt(p)보다 작거나 같은수와 크거나 같은 수가 곱으로 p가 합성수라면 약수를 이루게됩니다. 
			for(int d = 3; d*d <= p; d+=2) {
				if(p%d==0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) pcount++;
		}
		return pcount;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input n : ");
		int n = scanner.nextInt();
		
		long t = System.currentTimeMillis();
		System.out.println("pi("+n+")="+pi1(n));
		long t1 = System.currentTimeMillis();
		System.out.println("Elapsed time is "+(t1-t)+"ms.");
	}

}
