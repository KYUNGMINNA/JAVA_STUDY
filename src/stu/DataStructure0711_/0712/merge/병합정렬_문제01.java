package stu.DataStructure0711_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 2751
public class 병합정렬_문제01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		sort(A);
		
		StringBuilder sb = new StringBuilder();
		for(int i : A) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);

	}
	
	//임시 배열
	private static int[] temp;
	
	private static void sort(int[] arr) {
		temp = new int[arr.length];
		mergeSort(arr, 0, arr.length-1);
	}
	
	private static void mergeSort(int[] arr, int s, int e) {
		
		if(e - s < 1) return; //재귀함수 종료
		
		//중앙점 찾기
		int m = (s + e) / 2;
		
		//재귀방식으로 분할
		mergeSort(arr, s, m);
		mergeSort(arr, m+1, e);
		
		//병합 작업
		for(int i=s; i<=e; i++) {
			temp[i] = arr[i];
		}
		
		int p1 = s;
		int p2 = m + 1;
		int insertSpot = s;
		
		while(p1 <= m && p2 <= e) {
			if(temp[p1] < temp[p2]) {
				arr[insertSpot++] = temp[p1++];
			} else {
				arr[insertSpot++] = temp[p2++];
			}
		}
		
		while(p1 <= m) {
			arr[insertSpot++] = temp[p1++];
		}
		
		while(p2 <= e) {
			arr[insertSpot++] = temp[p2++];
		}
				
	}
	
	
	
	

}














