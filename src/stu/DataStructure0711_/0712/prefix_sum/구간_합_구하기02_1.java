package stu.DataStructure0711_;

import java.util.Scanner;

public class 구간_합_구하기02_1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] A = new int[N][N];
		
		//원본 배열 A 채우기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		//구간 합 배열 D 구하기
		int[][] D = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i-1][j-1];
			}
		}
		
		for(int i=0; i<M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			System.out.println(D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]);
		}
		
		sc.close();
		
	}

}


















