# 프로그래머스 배달

## 풀이에 대한 설명
다익스트라 알고리즘을 사용해 모든 지점 최단거리를 구하고 K시간 이하의 마을들을 count함<br>

전역변수
<pre>
  static int town; //  마을(정점)의 수
  static ArrayList<int[]>[] edges; // 간선 정보 배열 edges
</pre>
다익스트라 알고리즘
<pre>
   var distances = new int[town+1]; // 각 마을까지의 최단 거리를 기록하는 배열 distances
   Arrays.fill(distances, -1); // distances 배열을 -1로 모두 초기화(아직 방문하지 않았거나 도달할 수 없음)
   var visited = new boolean[town+1];
   var queue = new PriorityQueue<int[]>((a,b) -> a[1]-b[1]); // 오름차순 정렬
   queue.add(new int[] {start, 0});
   while(queue.size() > 0) {
       int[] temp = queue.remove();
       int node = temp[0], distance = temp[1];
       if(visited[node]) continue;
       else visited[node] = true;
       distances[node] = distance; // 현재까지 누적된 거리 distance의 값이 최단 거리
       for(int[] e:edges[node]) {
           int neighbor = e[0], cost = e[1];
           queue.add(new int[] {neighbor, distance + cost});
       }
   }
   return distances; 
</pre>
메인함수
<pre>
  int answer = 0;  
  town = N;
  edges = new ArrayList[town+1];
  for(int i=1; i<=town; ++i) {
      edges[i] = new ArrayList<int[]>();
  }
  // 양방향 연결      
  for(int[] link:road) {
      int a = link[0], b = link[1], cost = link[2];
      edges[a].add(new int[] {b, cost});
      edges[b].add(new int[] {a, cost});
  }
  int[] distances = dijkstra(1); // distances 배열에 1번 마을에서 출발하여 각 마을까지의 최단 거리를 모두 저장

  // 각 마을까지의 최단 거리가 모두 저장된 distances 배열에서 K시간 이내로 걸리는 마을이 있을 때 마다 answer의 값을 1 증가시킴
  for(int i=0; i<distances.length; i++) {
      if(distances[i] != 0 && distances[i] <= K) { // 1번 마을(시작점)은 항상 '0'이므로 제외)
          answer++;
      }
  }   
  return answer;
</pre>


## 풀어나가는 과정에서 시행착오
다익스트라 알고리즘을 사용하여 쉽게 풀 수 있었던 문제
'1번 마을'에서 각 마을까지의 최단거리를 구하는 문제이므로 distances[] 배열에서 1번 마을에 걸리는 시간을 제외해야 한다
