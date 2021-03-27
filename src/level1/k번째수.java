package level1;
import java.util.*;

public class k번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        /*
        1 5 2 6 3 7 4
                //list
        2 5 3 // 5 2 6 3 // 2 3 5 6 // 5
        4 4 1 // 6 // 6 // 6
        1 7 3 // 1 5 2 6 3 7 4 // 1 2 3 4 5 6 7 // 3
        */

        for(int i=0;i<commands.length;i++){
            ArrayList <Integer> list = new ArrayList<Integer>();
            for(int j=commands[i][0]-1;j<=commands[i][1]-1;j++){

                list.add(array[j]);
            }
            Collections.sort(list);

            int b = commands[i][2]-1;
            answer[i] = list.get(b);
        }

        return answer;
    }

    public static void main(String[] args) {
        //[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]
        // 답 5 6 3

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        for(int i : solution(array,commands)) System.out.println(i);
    }

}

