import java.util.Scanner;

public class Calenderr {
    int base_year = 1980; // 기준 연도
    int base_month = 1; // 기준 월. 실제로는 1980년 1월 1을 기준으로 계산
    int total_sum = 0; // 기준 날짜에서 입력받은 날짜까지 총 일수
    int year = 0;
    int month = 0;
    int[] month_table = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 각 월의 총 일수

     public int is_leap_year(int n) { // 윤년이 있는 년도를 조사하는 메소드. 윤년인 경우 1리턴
        if ( (n % 4 == 0 && n % 100 != 0 )|| n%400 ==0 ) 
            return 1;
        else
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

   void result() {
        setYear();
        setmonth();

        convert_to_day(year);

        if (year >= base_year) {
            if (is_leap_year(year) == 1)
                month_table[1] = 29;

            for (int i = 0; i < (month - base_month); i++)
                total_sum += month_table[i];

            int day = (total_sum + 2) % 7;

            int Cun_month = total_to_month(total_sum);

            print(Cun_month,day);

            month_table[1] = 28;
        }
    }

    public void print(int Cun_month,int day){
        System.out.println(month + "월의 달력");

        System.out.println("일  월  화  수  목  금  토");

        for (int i = 0; i < day; i++)
            System.out.print("\t");
        for (int j = 1; j <= month_table[Cun_month - 1]; j++) {
            System.out.print(j + "\t");
            if (((j + day) % 7) == 0)
                System.out.println();
        }
    }

    public int getYear(){ //get
        return year;
    }
    public void setYear(){ //set
        year = s.nextInt();
    }
    public int getmonth(){ //get
        return month;
    }
    public void setmonth(){ //set
        month = s.nextInt();
    }

    public static void main(String args[]) {
        int year, month;
        Scanner s = new Scanner(System.in);
        Calender cldUser = new Calender();
        System.out.println("연도와 월을 입력하시오. (ex. 2019 5)");
        cldUser.result();
    }

}
