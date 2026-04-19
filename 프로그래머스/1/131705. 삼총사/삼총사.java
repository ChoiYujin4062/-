class Solution {
    static int answerCount = 0;
    static int sum = 0;
    
    public int solution(int[] number) {
        int answer = 0;
        
        DFS(number, 0, 0);
        
        answer = answerCount;
        
        return answer;
    }
    
    void DFS(int[] number, int start, int count){
        if(count == 3) {
            if(sum == 0) {
                answerCount++;
            }
            return;
        }
        
        for(int i=start; i<number.length; i++) {
            sum += number[i];
            DFS(number, i+1, count+1); 
            sum -= number[i];
        }
    } 
}