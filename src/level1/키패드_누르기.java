package level1;

public class 키패드_누르기 {

    /*
    상하좌우만 가능
    L *시작 1 4 7
    R #시작 3 6 9

    2 5 8 0 더 가까운손 / 거리가 같으면 hand에 따라
     */
    public static String solution(int[] numbers, String hand) {
        String answer = "";

        char [] arr = {'x',
                'L','M','R',
                'L','M','R',
                'L','M','R',
                '*','M','#'
        };
        //처음 손가락 좌표위치
        int leftI = 3;
        int leftJ = 0;
        int rightI = 3;
        int rightJ = 2;

        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0) numbers[i]=11;
            int x = (numbers[i]-1)/3;
            int y = (numbers[i]-1)%3;

            //1 4 7 일때
            if(arr[numbers[i]]=='L'){
                //finger[x][y] = 'L';
                answer += "L";
                leftI = x;
                leftJ = y;
            }
            //3 6 9 일때
            else if(arr[numbers[i]]=='R'){
                //finger[x][y] = 'R';
                answer += "R";
                rightI = x;
                rightJ = y;
            }

            //가운데 일때 2 5 8 0
            else if(arr[numbers[i]]=='M'){

                //왼손오른손의 이전 좌표값과 현재 좌표값(눌러야하는번호)의 차이 비교
                if(Math.abs(leftI-x)+Math.abs(leftJ-y) < Math.abs(rightI-x)+Math.abs(rightJ-y)) {
                    //finger[x][y] ='L';
                    answer += "L";
                    leftI = x;
                    leftJ = y;
                }
                else if(Math.abs(leftI-x)+Math.abs(leftJ-y) > Math.abs(rightI-x)+Math.abs(rightJ-y)) {
                    //finger[x][y] ='R';
                    answer += "R";
                    rightI = x;
                    rightJ = y;
                }
                //위치 같을 경우
                else {
                    //왼손잡이
                    if(hand.equals("left")) {
                        answer += "L";
                        leftI = x;
                        leftJ = y;
                    }
                    //오른손잡이
                    else {
                        answer += "R";
                        rightI = x;
                        rightJ = y;
                    }
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] n1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int [] n2  =  {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int [] n3  =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(solution(n1,"right"));
        System.out.println(solution(n2,"left"));
        System.out.println(solution(n3,"right"));

    }
}
