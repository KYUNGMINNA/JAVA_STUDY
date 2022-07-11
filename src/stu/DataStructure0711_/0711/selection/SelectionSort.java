package stu.DataStructure0711_;

import java.util.Arrays;

public class SelectionSort {

	public static void sort(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			
			int minIndex=i;
			
			//최소값을 가지는 인덱스를 찾자
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<minIndex) {
					minIndex=j;
				}
			}
			swap(arr,minIndex,i);
		}
		
		
	}
	
	public static void swap(int[] arr ,int i ,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr= {33,11,99,1,22,88,55,44,66,77};
		
		sort(arr);
		System.out.println("정렬 후 : "+Arrays.toString(arr));
	}

}
