public class Controller {
	public static void main(String args[]) {
		IOManager io = new IOManager();

		io.println("§§§ 『달력 출력기』 §§§\n========================\n(1900년 1월달 부터 가능합니다)");
		Calender calender = new Calender(io.getYear(), io.getMonth());
		io.println("==================================================");
		io.println("\t\t\t"+calender.getMonth()+" 월");
		io.println("==================================================");
		io.println("일\t 월\t 화\t 수\t 목\t 금\t 토\t");
		io.result(calender.run() ,calender.getMonth(), calender.Is_Leap_Year(calender.getYear()));
	}

}
