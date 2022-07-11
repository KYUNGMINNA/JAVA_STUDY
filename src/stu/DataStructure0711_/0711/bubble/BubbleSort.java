package stu.DataStructure0711_;

import java.util.Arrays;

public class BubbleSort {

	//버블 정렬
	public static void sort(int[] arr) {
		
		//비교 범위를 잡아주는 반복문 
		for(int i=arr.length-1;i>0;i--) {
			
			//실제 비교를 통한 정렬 
			boolean flag=false;
			
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {  //바로 뒤의 값이랑 비교해서 앞에 것이 더 크다?
					//swap
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=true;
					
				}
			}
			if(!flag) break;  //swap이 한번도 발생하지 않았을 경우 
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr= {33,11,99,1,22,88,55,44,66,77};
		
		sort(arr);
		System.out.println("정렬 후 : "+Arrays.toString(arr));
	}

}
