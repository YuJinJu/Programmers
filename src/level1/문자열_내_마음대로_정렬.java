package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 문자열_내_마음대로_정렬 {
        public static String[] solution(String[] strings, int n) {
            String[] answer = new String[strings.length];
            Arrays.sort(strings);   //인덱스의 문자가 같을 때를 방지해 미리 오름차순으로 정렬

            //remove 사용하기 위해 list
            ArrayList<String> list = new ArrayList<>();
            for (int i=0;i< strings.length;i++) {
                list.add(strings[i]);
            }

            //인덱스의 문자 추출해서 정렬
            String [] a = new String[strings.length];
            for (int i=0;i< strings.length;i++){
                a[i] = strings[i].substring(n,n+1);
            }
            Arrays.sort(a);

            //인덱스 문자와 문자열 비교
            for(int i=0;i<a.length;i++){
                for (int j=0;j<list.size();j++){
                    String tmp = list.get(j).substring(n,n+1);
                    if(a[i].equals(tmp)){
                        answer[i] = list.get(j);
                        list.remove(j);
                        break;
                    }
                }
            }

            return answer;


        }
    public static void main(String[] args) {
        /*
strings	                n	return
["sun", "bed", "car"]	1	["car", "bed", "sun"]
["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
         */
        String [] s1 = {"sun","bed","car"};
        String [] s2 = {"abce","abcd","cdx"};

        for(String i : solution(s1,1))
        System.out.print(i+" ");

        System.out.println();

        for(String i : solution(s2,2))
        System.out.print(i+" ");
    }
}
