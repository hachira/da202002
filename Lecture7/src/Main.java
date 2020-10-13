import java.util.Scanner;
public class Main {
	//	후위 표기법으로 작성된 연산식을 연산합니다.
	//	연산결과를 반환합니다.
	static int calc(String exp) {
		//	스택을 위한 선언
		int[] stack = new int[1000];
		int top = -1;
		
		//	exp 문자열에 들어가있는 모든 문자에 대해서 처리합니다.
		for(int i = 0; i < exp.length(); i++) {
			//	1. i번째 문자를 읽습니다.
			char ch = exp.charAt(i);
			//	2. 숫자인 경우 스택에 push합니다.
			if(ch >= '0' && ch <= '9') {
				stack[++top] = ch - '0';
			}
			//	3. 연산자인 경우 스택에서 두번 값을 뺀후 결과값을 push합니다.
			else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				//	스택에 아이템 갯수가 2개 이상이 아닌 경우 에러 발생
				if(top < 1) {
					System.out.println("Error");
					return 0; 
				}
				int b = stack[top--];
				int a = stack[top--];
				int r = 0;
				if(ch == '+') r = a+b;
				else if(ch == '-') r = a-b;
				else if(ch == '*') r = a*b;
				else if(ch == '/') r = a/b;
				//	연산 결과를 스택에 push합니다.
				stack[++top] = r;
			}
		}

		//	스택의 가장 위에 있는 것이 결과이므로 가장 위의 아이템을 반환합니다.
		return stack[top];
	}
	public static void main(String[] args) {
		//	입력을 위해서 Scanner 오브젝트를 생성합니다.
		Scanner scan = new Scanner(System.in);
		
		//	문자열을 받습니다.
		String ex = scan.next();
		//	연산결과를 출력합니다.
		System.out.println(ex + " = " + calc(ex));
	}
}
