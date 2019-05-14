public class Date {
	private final int base_year = 1900; // 기준 연도
	private final int base_month = 1; // 기준 월. 실제로는 1980년 1월 1을 기준으로 계산

	private int year = 0;
	private int month = 0;

	public Date() {
	}

	public Date(int year, int month) { // 년 월 기준 연도 저장
		this.year = year;
		this.month = month;
	}

	public int getBase_year() {
		return base_year;
	}

	public int getBase_month() {
		return base_month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}