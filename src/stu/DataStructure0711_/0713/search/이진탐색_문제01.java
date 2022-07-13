package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//뱍쥰 1920
public class 이진탐색_문제01 {
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int NN=Integer.parseInt(br.readLine());
		int[] A=new int[NN];
		
		//한번에 여러개 입력 받기 위함 객체 StringTokenizer
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<NN;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int MM=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<MM;i++) {
			int target=Integer.parseInt(st.nextToken());
			
			if(binarySearch(A, target)!=-1) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
 
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			
			if(binarySearch(arr, sc.nextInt()) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	
	public static int binarySearch(int[] arr, int target) {
 
		int left = 0;					
		int right = arr.length - 1;	
 
		
		while(left <= right) {
 
			int mid = (left + right) / 2;	
 
			if(target==arr[mid]) return mid;
	
			if(target < arr[mid]) right = mid - 1;
			else left = mid + 1;
		}
 
		return -1;
 
	}
}