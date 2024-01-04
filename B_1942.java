import java.util.Scanner;

public class B_1942 {
    private static int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    private static String[] daysOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int days = calculateDays(x, y);

        System.out.println(calculateDayOfWeek(days));
    }

    public static int calculateDays(int x, int y) {
        int days = y;

        for(int i=1; i<x; i++) {
            days += months[i];
        }

        return days;
    }

    public static String calculateDayOfWeek(int days) {
        return daysOfWeek[days % 7];
    }
}
