package day26;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class DaysBetweenDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Enter the first date (yyyy-MM-dd): ");
		String firstds= sc.nextLine();
		LocalDate firstd=LocalDate.parse(firstds, formatter);
		System.out.println("Enter the second date (yyyy-MM-dd): ");
		String secondds=sc.nextLine();
		LocalDate secondd=LocalDate.parse(secondds, formatter);
		
		long daysb=ChronoUnit.DAYS.between(firstd, secondd);
		System.out.println("Number of days between "+firstd+" and "+secondd+" is: "+daysb);
	}

}
