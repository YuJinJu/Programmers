package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터2 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int k : priorities) q.add(k);

        Arrays.sort(priorities);

        while (location != -1){
            Integer poll = q.poll();
            if(poll<priorities[priorities.length-1-answer]){
                q.add(poll);
                if(location==0) location = q.size();
                location--;
            }else{
                location--;
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int [] p1 = {2,1,3,2};
        int [] p2 = {1,1,9,1,1,1};
        System.out.println(solution(p1,2));
        System.out.println(solution(p2,0));
    }
}
