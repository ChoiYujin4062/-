import java.util.*;

class Solution {
    static int town;
    static ArrayList<int[]>[] edges;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        town = N;
        edges = new ArrayList[town+1];
        for(int i=1; i<=town; ++i) {
            edges[i] = new ArrayList<int[]>();
        }
        
        for(int[] link:road) {
            int a = link[0], b = link[1], cost = link[2];
            edges[a].add(new int[] {b, cost});
            edges[b].add(new int[] {a, cost});
        }
        
        int[] distances = dijkstra(1);
        
        for(int i=0; i<distances.length; i++) {
            if(distances[i] != 0 && distances[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static int[] dijkstra(int start) {
        var distances = new int[town+1];
        Arrays.fill(distances, -1);
        var visited = new boolean[town+1];
        var queue = new PriorityQueue<int[]>((a,b) -> a[1]-b[1]);
        queue.add(new int[] {start, 0});
        while(queue.size() > 0) {
            int[] temp = queue.remove();
            int node = temp[0], distance = temp[1];
            if(visited[node]) continue;
            else visited[node] = true;
            distances[node] = distance;
            for(int[] e:edges[node]) {
                int neighbor = e[0], cost = e[1];
                queue.add(new int[] {neighbor, distance + cost});
            }
        }
        return distances;
    }
}