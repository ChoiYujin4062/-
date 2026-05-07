import java.util.*;

class Solution {
    static int N, M;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        var visited = new boolean[N][M];
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {0,0,0});
        while(queue.size() >0) {
            int[] temp = queue.remove();
            int row = temp[0], col = temp[1], distance = temp[2];
            if(maps[row][col] == 0) continue;
            if(visited[row][col]) continue;
            visited[row][col] = true;
            
            if(row == N-1 && col == M-1) answer = distance+1;
            if(row > 0) queue.add(new int[] {row-1, col, distance+1});
            if(col > 0) queue.add(new int[] {row, col-1, distance+1});
            if(row < N-1) queue.add(new int[] {row+1, col, distance+1});
            if(col < M-1) queue.add(new int[] {row, col+1, distance+1});
        }
        if(answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
}