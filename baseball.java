package baseball;
import java.util.*;

public class baseball {

    public static void main(String[] args) {
				// (1) 초기값 설정
        Scanner scan = new Scanner(System.in);
        int[] number = new int[3];
        int[] intplayer = new int[3];
        int ball = 0;
        int strike = 0;
        int count = 1;

				// (2) 난수 생성
				// Math.random() 사용하여 1~9까지 난수 생성 후 중복 제거
				// Math.random() * 10의 결과는 0~ 9.9999...
				// 따라서 (int)(Math.random() * 9) + 1; -> 1~9
        for (int i = 0; i < 3; i++) {
            number[i] = (int) (Math.random() * 9) +1;
            for (int j = 0; j < i; j++) {    
                if (number[i] == number[j]) {
                    i--;
                    break;
                }
            }
        }
				// 난수 확인하고 싶을 때 주석 풀기
        //for (int i = 0; i < 3; i++) {
        //    System.out.print(number[i]);
        //}

				// (3) 게임 시작
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");


				// (4) 게임 Loop
        while (true) {
            System.out.println(count + "번째 시도:");
            String player = scan.next();
            // String -> char 배열로 변환
            //charAt(int index)로 추출한 숫자형 문자는 char형이므로 int형으로 변환 시 아스키코드로 변환된다.
            //따라서 '0'(48)을 빼주어야 의도한 리턴값을 얻을 수 있다.
            for(int i=0; i<player.length(); i++){
                intplayer[i] = player.charAt(i)-'0';
            }

				// (5) strike, ball 처리
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (intplayer[i] == number[j] && i == j) {
                        strike++;
                    } else if(intplayer[i] == number[j] && i!=j) {
                        ball++;
                    }
                }
            }
				// (6) 게임 종료, 1라운드 종료
            if (strike == 3) {
                System.out.println(count + "번만에 맞히셨습니다");
                System.out.println("게임을 종료합니다");
                break;
            }
            else{
                count++;
                System.out.println(ball + "B" + strike + "S");
                ball = 0;
                strike = 0;
            }
        }
    }
}
