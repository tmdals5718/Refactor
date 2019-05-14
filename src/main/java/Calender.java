import java.util.Scanner;

public class Calenderr {
    int base_year = 1980; // 기준 연도
    int base_month = 1; // 기준 월. 실제로는 1980년 1월 1을 기준으로 계산
    int total_sum = 0; // 기준 날짜에서 입력받은 날짜까지 총 일수

    int[] month_table = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 각 월의 총 일수

    public int is_leap_year(int n) { // 윤년이 있는 년도를 조사하는 메소드. 윤년인 경우 1리턴
        if (n % 4 == 0) { // 4의 배수는 윤년
            if (n % 100 == 0) { // 100의 배수는 윤년이 아님
                if (n % 400 == 0) // 그중에서 400의 배수는 윤년
                    return 1;
                return 0;
            }
            return 1;
        } else
            return 0;
    }

    public int total_to_month(int total) {// 기준 날짜부터 입력받은 날짜까지 총 일수를 구해서 반환하는 메소드
        boolean CHK = false; // 무한 루프를 돌리기 위한 boolean변수
        int i = 0; // 월
        int cnt = 0; // 총 일수를 월로 바꾸어서 cnt 저장
        int chk_leap_year = base_year; // 총 일수를 월로 바꾸려면 윤년이 있는 날을 고려해야함
        // 기준연도부터 윤년을 조사

        while (CHK != true) {
            if (is_leap_year(chk_leap_year) == 1) // 만약 지금 연도가 윤년이면
                month_table[1] = 29; // 2월은 하루가 증가

            if (total >= month_table[i]) { // 총 일수가 month_table[]배열의 총 일수 보다 작다면,
                total -= month_table[i++]; // 총 일수를 month_table 배열의 현재 월의 일수로 빼주고 다음달로 증가
                cnt++; // 월이 증가합니다.
                if (i == 12) {// 만약 12월이 된다면 계절이 변해 다시 제자리로 오는것처럼
                    i -= 12; // 다시 12를빼서 0으로 만들어줍니다.
                    chk_leap_year++; // 12개월이 지났음으로 연도 증가
                }
                month_table[1] = 28; // 윤년을 평년의 해로 바꾸어줌
            } else
                break;
        }
        cnt %= 12; // 위의 무한루프를 통해 총일수를 총월수로 계산됨. 이제 12 나머지 연산을 해주면
        // 몇년도 몇월이라는 값으로 바꿀 수 있음
        return (cnt + 1); // 바꾼 월을 반환
    }

    public int count_leap(int n) { // 기준 연도부터 시작해서 입력받은 연도까지의 윤년이 있는 날을 셈.
        int i; // 기준연도 저장
        int cnt = 0; // 윤년의 개수

        for (i = base_year; i < (base_year - n); i++) { // 기준연도부터 입력받은 연도까지 i를 증가시키며 윤년이낀 갯수를 구함
            if (is_leap_year(i) == 1)  // 윤년이라면 총 윤년의 개수를 증가시킴
                cnt++;
        }

        //카운트한 윤년의 갯수를 리턴
        if (cnt < 0)
            return 0;

        return cnt;
    }

    public boolean convert_to_day(int nYear) { // 기준 연도부터 입력받은 연도까지 총 일수를 구하는 메소드
        total_sum = ((nYear - base_year) * 365) + count_leap((base_year - nYear));
        if(total_sum < 0)
            return false;
        return true;
    }

    void result(int nYear, int mth) {
        int i, j;
        int d = 0;
        int year = 0;
        int month;
        int sum = 0;

        convert_to_day(nYear); // 기준연도부터 현재 연도까지 년 단위로 총일수를 구함

        int day; // 요일을 결정하는 변수. 예를들어 기준일부터 현재일까지 차이가 7이고
        // 기준일이 월요일이면 7로 나눠서 나머지가 0이되니까 월요일임을 알수 있듯이
        // day는 숫자로서 요일을 결정할 수 있음
        
        if (nYear >= base_year) {
            if (is_leap_year(nYear) == 1) // 윤달이 낀날의 2월은 하루 증가
                month_table[1] = 29;

            for (i = 0; i < (mth - base_month); i++)
                total_sum += month_table[i];
            // 나머지 기준월부터 현재월까지의 총일수를 구함
            // 즉 기준 연도의 월부터 현재 연도의 월까지의 총일수를 구함.

            day = (total_sum + 2) % 7;
            // 현재까지의 총일수를 7의 나머지로 연산. 2를 더해준 이유는 1980년도 1월 1일이 화요일이기 때문

            System.out.println("총 일수 = " + total_sum);
            month = total_to_month(total_sum); // 입력받은 해당 날짜의 정확한 달을 구해서 저장

            System.out.println(month + "월의 달력");
            System.out.println("일  월  화  수  목  금  토");

            for (i = 0; i < day; i++) // day 변수는 요일이므로 갯수만큼 공백을 만들어 줌.
                System.out.print("\t");

            for (j = 1; j <= month_table[month - 1]; j++) {
                // 배열은 0부터 시작하기때문에 month-1을 해줌
                System.out.print(j + "\t");// j를 증가시켜가며 차례데로 날짜를 출력합니다.
                if (((j + day) % 7) == 0)
                    System.out.println();
                //처음 요일을 출력하기위한 공백만큼 계산해서 출력
            }
            System.out.println();
            month_table[1] = 28; // 윤년이었으면 다시 평년으로 바꾸어 줌
        }
    }

    public static void main(String args[]) {
        int year, month;
        Scanner s = new Scanner(System.in);
        Calenderr cldUser = new Calenderr();
        System.out.println("연도와 월을 입력하시오. (ex. 2019 5)");
        year = s.nextInt(); //연도 입력
        month = s.nextInt();// 월을 입력
        cldUser.result(year, month); // year, month를 넘겨주면 cldUser클래스가 결과를 출력
    }

}
