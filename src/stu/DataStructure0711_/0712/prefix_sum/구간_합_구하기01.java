package stu.DataStructure0711_;

import java.util.Arrays;
import java.util.Scanner;

//백준 11659
public class 구간_합_구하기01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//배열의 개수 N과 테스트 케이스 M을 입력받기
		System.out.print("배열의 개수: ");
		int N = sc.nextInt();
		System.out.print("테스트 횟수: ");
		int M = sc.nextInt();
		
		long[] A = new long[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		//합배열 S를 만들자.
		//S[i] = S[i-1] + A[i]
		long[] S = new long[A.length + 1];
		for(int i=1; i<=A.length; i++) {
			S[i] = S[i-1] + A[i-1];
		}
		
//		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(S));
		
		//구간합 공식
		//(x, y) -> S[y] - S[x-1]
		//(1, 3) -> S[3] - S[0]
		
		for(int i=0; i<M; i++) {
			System.out.print("시작값: ");
			int x = sc.nextInt();
			System.out.print("끝값: ");
			int y = sc.nextInt();
			System.out.println(S[y] - S[x-1]);
		}
		
		sc.close();
		
	}
	
	
}






















