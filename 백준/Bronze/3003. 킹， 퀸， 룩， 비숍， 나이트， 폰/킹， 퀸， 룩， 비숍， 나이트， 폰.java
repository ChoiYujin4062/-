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
		
		int[] arr = {1,1,2,2,2,8};
		
		for(int i=0; i<arr.length; i++) {
			int n = Integer.parseInt(tokenizer.nextToken());
			writer.write(arr[i] - n + " ");
		}
		
		writer.flush();
		
	}
}