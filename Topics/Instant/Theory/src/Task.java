// You can experiment here, it won’t be checked

import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    // put your code here
    Scanner sc = new Scanner(System.in);
    int days = Integer.parseInt(sc.nextLine());
    String region = sc.nextLine();

    Instant instant = Instant.EPOCH;
    instant = instant.minus(Period.ofDays(days));

    System.out.println(instant.atZone(ZoneId.of(region)));
  }
}
