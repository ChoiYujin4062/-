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
		
		for(int i=0; i<T; i++) {
			String str = reader.readLine();
			writer.write(str.charAt(0) + "" + str.charAt(str.length()-1) + "\n");
		}
		
		writer.flush();
	}
}