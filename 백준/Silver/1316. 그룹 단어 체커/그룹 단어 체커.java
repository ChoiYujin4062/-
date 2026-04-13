import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	static int count = 0;
	
	static void GroupWord(String str) {
		String[] arr = str.split("");
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			if(i>0 && !arr[i-1].equals(arr[i])) {
				if(set.contains(arr[i])) {
					count++;
					return;
				}
			}
			set.add(arr[i]);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(tokenizer.nextToken());
		for(int i=0; i<N; i++) {
			String str = reader.readLine();
			GroupWord(str);
		}
		
		writer.write((N - count) + "");
		
		writer.flush();
	}
}