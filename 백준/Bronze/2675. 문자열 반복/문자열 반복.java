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
		
		int T = Integer.parseInt(tokenizer.nextToken());
		int[] arrR = new int[T];
		String[] arrS = new String[T];
		
		for(int i=0; i<T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			arrR[i] = Integer.parseInt(tokenizer.nextToken());
			arrS[i] = tokenizer.nextToken();
		}
		
		for(int i=0; i<T; i++) {
			for(int j=0; j<arrS[i].length(); j++) {
				for(int k=0; k<arrR[i]; k++) {
					writer.write(arrS[i].charAt(j) + "");
				}
			}
			writer.write("\n");
		}
		
		writer.flush();
	}
}