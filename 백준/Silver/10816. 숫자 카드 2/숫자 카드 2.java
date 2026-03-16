import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int upperBound(int[] arr, int num) {
		int left = 0;
		int right = arr.length;
		
		while(left<right) {
			int mid = (left+right)/2;
			
			if(num<arr[mid]) {
				right = mid;
			}
			else
				left = mid+1;
		}
		
		return left;
	}
	
	static int lowerBound(int[] arr, int num) {
		int left = 0;
		int right = arr.length;
		
		while(left<right) {
			int mid = (left+right)/2;
			
			if(num > arr[mid]) {
				left = mid+1;
			}
			else
				right = mid;
		}
		
		return left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int[] arr1 = new int[N];
		
		tokenizer = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(arr1);
		
		tokenizer = new StringTokenizer(reader.readLine());
		int M = Integer.parseInt(tokenizer.nextToken());
		
		tokenizer = new StringTokenizer(reader.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(tokenizer.nextToken());
			int count = upperBound(arr1, num) - lowerBound(arr1, num);
			writer.write(count + " ");
		}
		
		writer.flush();
		
	}
}