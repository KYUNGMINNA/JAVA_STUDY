package stu.DataStructure0711_;

import java.util.Arrays;

public class InsertionSort {


	public static void sort(int[] arr) {
	
		for(int i =1;i<arr.length;i++) {
			
			int targetNum=arr[i];
			int j=i-1;
			
			//타겟으로 잡은 숫자가 이전 요소의 값보다 크기 전 까지 반복.
			while(j>=0 && targetNum<arr[j]) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=targetNum;
		}
		
	}



	public static void main(String[] args) {
		int[] arr= {33,11,99,1,22,88,55,44,66,77};

		sort(arr);
		System.out.println("정렬 후 : "+Arrays.toString(arr));
	}

}
