package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이진탐색_문제02 {

	
	public static int N;
	public static int M;
	
	public static int[] A;
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		//Scanner 보다 빠른 입력 수단
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine()); //첫번째 줄 전체 입력 받기
		
		
		N=Integer.parseInt(st.nextToken());  //강의의 수
		M=Integer.parseInt(st.nextToken()); //블루레이의 수
		
		A=new int[N];  //강의 배열 
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		//최대 길이의 레슨과 , 레슨 길이의 총합을 구하기
		// --> 한 강의 당 한 장의 블루레이를 쓸 때의 최소값 ,--> 한장의 블루레이가 가질 수 잇있는 최대 값 
		int start=0,end=0;
		for(int i=0;i<N;i++) {
			if(start<A[i]) {
				start=A[i];
				end+=A[i];
			}
		}
		
		int answer=0; 
		while(start<=end) {
			int mid=(start+end)/2;  //블루레이의 크기 
			if(isRightSize(mid)) { //아직 여유 있구나
				answer=mid;
				end=mid-1;
			}else {
				start=mid+1;
				
			}
		}
		System.out.println(answer);					
	}
	
	
	
	private static boolean isRightSize(int mid) {
		int cnt=0;  //블루레이의 개수
		int total=0;
		
		for(int i=0;i<N;i++) {
			if(total+A[i] > mid) { //강의 길이의 합이 블뤠레이 사이즈 보다 크다면
				cnt++; //블루레이의 개수 올림
				total=A[i];  //누적이 아닌 다음요소를 집어 넣는다.
			}else {
				total+=A[i];
			}		
		}
		return cnt<M;
	}

	
	
	
	
}



























