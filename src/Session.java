
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Session {
    private final List<Talk> talks;
    private final int maxMinutes;
    private final LocalTime startTime;
    private int usedMinutes;

    public Session(int maxMinutes, LocalTime startTime) {
        this.talks = new ArrayList<>();
        this.maxMinutes = maxMinutes;
        this.startTime = startTime;
        this.usedMinutes = 0;
    }

    boolean addTalk(Talk talk) {
        if (usedMinutes + talk.getDuration() <= maxMinutes) {
            talks.add(talk);
            usedMinutes += talk.getDuration();
            return true;
        }
        return false;
    }

    void provideOrder() {
        LocalTime time = startTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
        for (Talk talk : talks) {
            System.out.println(time.format(formatter) + " " + talk);
            time = time.plusMinutes(talk.getDuration());
        }
    }

    LocalTime getSessionEndTime() {
        return startTime.plusMinutes(usedMinutes);
    }
}
