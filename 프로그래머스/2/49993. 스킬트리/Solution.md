# 프로그래머스 스킬트리

## 입출력 예
<pre>
skill              skill_trees	              return
"CBD"	  ["BACDE", "CBADF", "AECB", "BDA"]	    2
</pre>
## 풀이에 대한 설명
String 배열로 받은 skill_trees 안에 있는 원소가 skill 문자열 순서대로 존재하는지 확인하면 해결되는 문제(정규식을 이용)

1. skill_trees 내의 모든 원소들을 확인하기 위해 skill_trees 배열의 길이만큼 반복
2. skill_trees 의 원소를 "[^ ]" 정규식을 이용해 괄호 안의 skill 문자열을 제외한 다른 문자들을 공백 문자로 replace 함(입출력 예를 예시로 들면, BACDE는 CD, CBADF는 CBD가 됨)
3. 그렇다면 indexOf() 메소드를 사용해 replace 된 원소들에서 skill 문자열이 시작되는 위치를 반환하면 됨
4. 반환되는 위치가 0일 때(무조건 C로 시작될 때), 즉 skill의 순서대로 남은 원소가 존재할 때 answer의 값을 1 증가시킴
5. answer 리턴

## 풀어나가는 과정에서 시행착오
정규식과 indexOf() 메소드를 사용하면 쉽게 풀 수 있었던 문제
다만 indexOf() 사용법을 몰라 약간 헤멨던 문제.

