class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
              
        for(int i=0; i<skill_trees.length; i++) {
            String temp = skill_trees[i].replaceAll("[^" + skill + "]", "");
            if(skill.indexOf(temp) == 0) answer++;
        }
        return answer;
    }
}