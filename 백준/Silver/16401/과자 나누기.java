package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
      public static void main(String[] args) throws IOException{
    	  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    	  var tokenizer = new StringTokenizer(reader.readLine());
    	  
    	  int M = Integer.parseInt(tokenizer.nextToken());
    	  int N = Integer.parseInt(tokenizer.nextToken());
    	  int[] arr = new int[N];
    	  int max = 0;
    	  int result = 0;
    	  
    	  tokenizer = new StringTokenizer(reader.readLine());
    	  for(int i=0; i<N; i++) {
    		  arr[i] = Integer.parseInt(tokenizer.nextToken());
    		  if(arr[i]>max) {
    			  max = arr[i];
    		  }
    	  }
    	  
    	  int left = 1;
    	  int right = max;
    	  long middle = 0; // 수정 전 코드: int middle;
    	  
    	  while(left <= right) {
    		  middle = (left+right)/2;
    		  if(middle == 0) break;
    		  
    		  long count = 0; // 수정 전 코드: int count;
    		  for(int i=0; i<arr.length; i++) {
    			  count += arr[i]/middle;
    		  }
    		  
    		  if(count >= M) {
    			  result = middle;
    			  left = middle + 1;
    		  }
    		  else {
    			  right = middle -1;
    		  }
    	  }
    	  
    	  writer.write(result + "");
    	  
    	  writer.flush();
    	  
      }
}
