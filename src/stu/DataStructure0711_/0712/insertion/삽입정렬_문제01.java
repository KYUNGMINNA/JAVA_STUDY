package stu.DataStructure0711_;

import java.util.Arrays;
import java.util.Scanner;

public class 삽입정렬_문제01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("사람 수: ");
		int N = sc.nextInt();
		
		int[] A = new int[N]; //사람 수만큼의 배열을 선언. (소요 시간이 들어감.)
		for(int i=0; i<N; i++) {
			System.out.print((i+1) + "번째 사람의 소요시간: ");
			A[i] = sc.nextInt();
		}
		
		System.out.println("사람 수: " + N);
		System.out.println("소요 시간: " + Arrays.toString(A));
		
		//A 배열을 정렬해야 한다. (삽입 정렬)
		for(int i=1; i<N; i++) {
			int targetNum = A[i];
			int j = i;
			while(j > 0 && A[j-1] >= targetNum) {
				A[j] = A[j-1];
				j--;
			}
			A[j] = targetNum;
		}
		
		int total = 0; //사람별 대기시간 총합.
		int prevTotal = 0; //이전까지의 대기시간 총합.
		
		for(int i=0; i<N; i++) {
			//이전까지의 대기 시간과 현재 사람이 걸리는 시간을 더해줌.
			total += prevTotal + A[i];
			
			//이전까지의 누적합에다가 현재 걸리는 시간을 더해줌.
			prevTotal += A[i];
		}
		
		System.out.println("총 누적대기시간: " + total);
		
		

	}

}




















