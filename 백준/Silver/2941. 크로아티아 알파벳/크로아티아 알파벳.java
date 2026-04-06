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
		
		
		String[] Alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(String s : Alpha) {
			if(str.contains(s)) {
				str = str.replace(s, "*");
			}
		}
		
		writer.write(str.length() + "");
		
		writer.flush();
	}
}