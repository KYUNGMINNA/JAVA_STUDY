package search;

import java.util.Arrays;

public class Search {

	//선형 탐색 
	public static int linearSearch(int[] arr,int target) {
		for(int i=0;i<arr.length;i++) {
			if(target==arr[i]) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	//이진 탐색 
	public static int binarySearch(int[] arr,int target) {
		
		//왼쪽 포인터 , 중앙 포인터 , 오른쪽 포인터
		int left=0;
		int right=arr.length-1;
		int mid;
		
		while(left <=right) {
			//mid 인덱스 계산
			mid=(left+right)/2;
			
			if(arr[mid]==target) {
				return mid;
			}else if (target<arr[mid]) {
				right=mid-1;
			}else {
				left=mid+1;
			}
			
			
		}
		
		return -1;
	}
	
	
	
	
	
	public static void main(String[] args) {

		int[] arr= {3,7,11,12,27,49,53,68,72,91};
		
		int target=53;
		
		System.out.printf("Linear Search(%d 's index:)%d \n",target,linearSearch(arr, target));
		System.out.printf("Binary Search(%d 's index:)%d \n",target,binarySearch(arr, target));
		
		System.out.println(Arrays.binarySearch(arr, target));
		
	}

}
