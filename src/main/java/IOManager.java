import java.util.Scanner;

public class IOManager {

	Scanner s = new Scanner(System.in);

	public void println(String string) {
		System.out.println(string);
	}

	public void print(String string) {
		System.out.print(string);
	}

	public int getYear() {
		int year;
		while (true) {
			this.print("\n년도를 입력해주십시오 : ");
			try {
				year = s.nextInt();
			} catch (Exception e) {
				this.println("잘못된 입력값입니다.");
				throw e;
			}
			if (year < 1900) {
				this.println("1900년 이전의 년도는 입력하실 수 없습니다.");
			} else {
				return year;
			}
		}
	}

	public int getMonth() {
		int month;
		while (true) {
			this.print("\n월을 입력해주십시오 : ");
			try {
				month = s.nextInt();
			} catch (Exception e) {
				this.println("잘못된 입력값입니다.");
				throw e;
			}
			if (month < 1 || month > 12) {
				this.println("올바른 달이 아닙니다.");
			} else {
				return month;
			}
		}
	}

	public void result(int input, int month, boolean leap) {
		int remains = input % 7;
		int count = 1;
		int limit=month-1;
		Month_table[] table = Month_table.values();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				
				if(leap&& month ==2) {
					limit = 12;
				}
				
				if(count>table[limit].getValue()) {
					return;
				}
				
				
				if (remains+1 > 0) {
					this.print("\t");
					remains--;
				} else
					this.print(Integer.toString(count++) + "\t");
			}
			this.println("");
		}

	}
}
