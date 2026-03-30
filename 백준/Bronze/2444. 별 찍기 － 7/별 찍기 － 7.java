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
		
		int N = Integer.parseInt(tokenizer.nextToken());
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<N-i; j++) {
				writer.write(" ");
			}
			for(int j=0; j<2*i-1; j++) {
				writer.write("*");
			}
			writer.write("\n");	
		}
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<N-i; j++) {
				writer.write(" ");
			}
			for(int j=2*i-1; j>0; j--) {
				writer.write("*");
			}
			writer.write("\n");
		}
		
		writer.flush();
	}
}