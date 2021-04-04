package level1;

import java.util.Stack;

public class 비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        int[] a = new int[n];
        String [] answer = new String[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            //비트연산
            answer[i] = Integer.toBinaryString(arr1[i]|arr2[i]);
/*
            a[i] = (arr1[i]|arr2[i]);

            //이진법만들기
            for(int j=0;j<n;j++){
                stack.push(a[i]%2);
                a[i] /= 2;
            }
            //answer[i] = "";
            answer[i]= Integer.toString(stack.pop());
            while (!stack.empty()) answer[i] += Integer.toString(stack.pop());

*/

            answer[i] = String.format("%" + n + "s", answer[i]); //자릿수대로 이진수 맞출 수 있다!!
            answer[i] = answer[i].replace("0"," ");
            answer[i]= answer[i].replace("1","#");
        }
        return answer;
    }

    public static void main(String[] args) {
        //케이스1      "#####","# # #", "### #", "# ##", "#####"
        int n1 = 5;
        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};

        //케이스2      "######", "### #", "## ##", " #### ", " #####", "### # "
        int n2 =6;
        int [] arr3 = {46, 33, 33 ,22, 31, 50};
        int [] arr4 = {27 ,56, 19, 14, 14, 10};

        //for(String i: solution(n1,arr1,arr2))  //케이스1
        for(String i: solution(n2,arr3,arr4))    //케이스2
        System.out.println(i);
    }
}
