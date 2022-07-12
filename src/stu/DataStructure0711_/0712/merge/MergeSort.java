package stu.DataStructure0711_;

import java.util.Arrays;

public class MergeSort {
	
	//병합 작업에 쓰일 임시 배열.
	private static int[] temp;
	
	//병합 정렬 알고리즘
	
	/**
	 * @param arr - 분할 할 배열
	 * @param s - 분할 시작 위치
	 * @param e - 분할 끝 위치
	 */
	private static void mergeSort(int[] arr, int s, int e) {
		
		//분할한 배열의 원소가 1개 이하면 return
		if(e - s < 1) return; //재귀함수 종료.
		
		//분할의 중앙점을 찾아야 함.
		int m = (s + e) / 2;
		
		//분할 작업 (더 쪼개지지 않을 때 까지 반복)
		mergeSort(arr, s, m); //왼쪽
		mergeSort(arr, m+1, e); //오른쪽
		
		//병합 작업
		
		//부분 배열을 임시 배열에 저장.
		for(int i=s; i<=e; i++) {
			temp[i] = arr[i];
		}
		
		//포인터 2개 선언
		int p1 = s;
		int p2 = m + 1;
		
		//포인터끼리 비교한 후 원본 배열에 넣어야 할 위치를 지정.
		int insertSpot = s;
		
		while(p1 <= m && p2 <= e) {
			if(temp[p1] < temp[p2]) {
				//왼쪽 배열의 값이 더 작다면 왼쪽 배열 요소를 집어넣자.
				//그리고 나서 포인터의 값, spot의 값을 하나씩 올리자.
				arr[insertSpot++] = temp[p1++];
			} else {
				//오른쪽 배열의 크기가 더 작다면 오른쪽 배열 요소를 집어넣자.
				//마찬가지로 포인터 값과 spot의 값도 하나씩 올리자.
				arr[insertSpot++] = temp[p2++];
			}
		}
		
		/*
		 왼쪽 또는 오른쪽 배열이 먼저 소모된 경우에는,
		 남아있는 쪽의 배열 요소를 마저 채워 넣어 주셔야 합니다. 
		 */
		while(p1 <= m) {
			arr[insertSpot++] = temp[p1++];
		} 
		
		while(p2 <= e) {
			arr[insertSpot++] = temp[p2++];
		}
		
	}
	
	public static void sort(int[] arr) {
		temp = new int[arr.length];
		mergeSort(arr, 0, arr.length-1);
	}
	
	

	public static void main(String[] args) {

		int[] arr = {33, 11, 99, 1, 22, 88, 55, 44, 66, 77};

		sort(arr);

		System.out.println("정렬 후: " + Arrays.toString(arr));

	}

}
