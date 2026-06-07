# 백준 15649. N과 M(1)

## 풀이에 대한 설명
순열로 구현하는 문제
<br>
전역변수
<pre>
  static int N, M;
	static int[] A; // 1부터 N까지 배열
	static ArrayList<Integer> selected = new ArrayList<>(); // 선택된 숫자를 담아두는 리스트 selected
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
</pre>
<br>
DFS 구현
<br>
<pre>
    public static void DFS() throws IOException {
		if(selected.size() == M) {
			for(int i:selected) {
				writer.write(i + " ");
			}
			writer.write('\n');
			return;
		}
		for(int i:A) {
			if(!selected.contains(i)) { // 중복 방지
				selected.add(i); // selected에 i(현재 탐색중인) 추가
				DFS();
				selected.remove(selected.size()-1); // 백트래킹
			}
		}
	}
</pre>
<br>
메인함수 
<br>
<pre>
    public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		
		A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = i+1;
		}
		
		DFS();
		
		writer.flush();
	}
</pre>
<br>
## 풀어나가는 과정에서 시행착오
순열을 구현하면 쉽게 풀 수 있는 문제
