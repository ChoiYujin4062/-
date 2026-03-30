import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = reader.readLine();
		char[] arr = str.toCharArray();
		int compare = 1;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != arr[(arr.length-1)-i]) {
				compare = 0;
				break;
			}
		}
		
		writer.write(compare + "");
		
		writer.flush();
	}
}