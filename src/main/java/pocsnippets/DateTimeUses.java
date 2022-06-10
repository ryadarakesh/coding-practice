package pocsnippets;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUses {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

        ZonedDateTime currentIndDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(currentIndDateTime);

        ZonedDateTime currentPakDateTime = ZonedDateTime.now(ZoneId.of("Asia/Karachi"));
        System.out.println(currentPakDateTime);
    }
}
