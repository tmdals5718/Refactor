public class Calender {
	private Date date;
	private int total_days = 0;
	private Month_table[] month_table = Month_table.values();

	public Calender(int year, int month) {
		date = new Date(year, month);
	}

	public boolean Is_Leap_Year(int input) {
		if ((input % 4 == 0 && input % 100 != 0) || input % 400 == 0) /// inline 방식/////
			return true;
		else
			return false;
	}

	private int days() {// 기준 날짜부터 입력받은 날짜까지 총 일수를 구해서 반환하는 메소드

		for (int i = 0; i < (date.getYear() - date.getBase_year()); i++) { // 기준연도부터 입력받은 연도까지 i를 증가시키며 윤년이낀 갯수를 구함
			if(this.Is_Leap_Year(i+date.getBase_year()))total_days +=366;
			else total_days += 365;
		}
		for (int i = 0; i < date.getMonth() - 1; i++) {
			if (this.Is_Leap_Year(date.getYear()) && i == 1) {
				total_days += month_table[12].getValue();
			}
			total_days += month_table[i].getValue();
		}
		return total_days;
	}
	public int getMonth() {
		return date.getMonth();
	}
	public int getYear() {
		return date.getYear();
	}

	public int run() {
		return days();
	}
}
