# 백준 1012. 유기농배추

## 풀이에 대한 설명
연결 그래프의 개수를 구하는 문제<br><br>
전역변수
<pre>
  static int ROW, COL; // 배추밭 field[] 배열의 행과 열의 크기를 저장
	static int[][] field; //배추밭
	static boolean[][] visited; // 방문 여부 기록
</pre>
<br>
배추흰지렁이(연결그래프)의 개수를 구하는  Solution
<pre>
    int answer = 0;
		
		visited = new boolean[ROW][COL];
		for(int i=0; i<ROW; ++i) {
			for(int j=0; j<COL; ++j) {
				if(field[i][j] == 1 && !visited[i][j]) { // 현재 탐색 중인 칸에 배추가 있고 아직 방문하지 않은 칸이라면
					++answer; // 배추흰지렁이 개수를 증가시키고
					DFS(i, j); // DFS 호출하여 상하좌우 탐색
				}
			}
		}
		return answer;
</pre>
<br>
DFS 탐색
<pre>
    if(field[row][col] != 1 || visited[row][col]) return; // 배추가 있는 칸 = 1
		else visited[row][col] = true;
		if(row > 0) DFS(row-1, col);
		if(col > 0) DFS(row, col-1);
		if(row < ROW-1) DFS(row+1, col);
		if(col < COL-1) DFS(row, col+1);
</pre><br>
main함수
<pre>
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var tokenizer = new StringTokenizer(reader.readLine());
		
		int T = Integer.parseInt(tokenizer.nextToken());
		for(int i=0; i<T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			COL = Integer.parseInt(tokenizer.nextToken()); // M
			ROW = Integer.parseInt(tokenizer.nextToken()); // N
			int K = Integer.parseInt(tokenizer.nextToken());
			field = new int[ROW][COL];
			for(int j=0; j<K; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(tokenizer.nextToken());
				int y = Integer.parseInt(tokenizer.nextToken());
				field[ROW-1-y][x] = 1; // 문제에서 예제 입력으로 주어지는 x,y 좌표
			}
			writer.write(Solution(K) + "\n");
		}
		writer.flush();
</pre><br>

## 풀어나가는 과정에서 시행착오
자바의 2차원 배열에서 인덱스를 계산할 때 행과 열은 왼쪽 위에서부터 계산하는데, 주어진 문제에서 배추의 좌표는 xy 좌표평면으로 주어지기 때문에
field에 배추의 좌표를 넣을 때 인덱스를 잘 계산해야 하는 문제
