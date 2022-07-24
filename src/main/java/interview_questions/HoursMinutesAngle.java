package interview_questions;

public class HoursMinutesAngle {
    public static void main(String[] args) {
        System.out.println(getAngle(12,30));

        System.out.println(getAngle(3,30));
        System.out.println(getAngle(12,15));
    }

    public static int getAngle(int hours, int minutes) {
        int hoursAngle = (hours % 12) * 30 + (minutes * 30) / 60;
        int minutesAngle = minutes * 6;
        int result = Math.abs(hoursAngle - minutesAngle);
        return Math.min(result, 360 - result);
    }
}
