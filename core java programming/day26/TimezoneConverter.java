package day26;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class TimezoneConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		System.out.println("Enter the date and time (yyyy-MM-dd HH:mm): ");
		String datets=sc.nextLine();
		LocalDateTime localdt=LocalDateTime.parse(datets, formatter);
		System.out.println("Enter the source timezone (e.g., America/New_York): ");
		String sourcetz=sc.nextLine();
		ZoneId sourcezid=ZoneId.of(sourcetz);
		System.out.println("Enter the target timezone (e.g., Europe/London): ");
		
		String targetzid=sc.nextLine();
		ZoneId targetz=ZoneId.of(targetzid);
		
		ZonedDateTime sourcezdt=ZonedDateTime.of(localdt, sourcezid);
		ZonedDateTime targetzdt=sourcezdt.withZoneSameInstant(targetz);
		System.out.println("The time in "+ targetzid+" is : "+ targetzdt.format(formatter));
	}

}
