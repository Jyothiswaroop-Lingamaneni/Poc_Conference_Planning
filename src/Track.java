
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Track {
    private final Session morning;
    private final Session afternoon;

    public Track() {
        morning = new Session(180, LocalTime.of(9, 0));
        afternoon = new Session(240, LocalTime.of(13, 0));
    }

    boolean addTalk(Talk talk) {
        return morning.addTalk(talk) || afternoon.addTalk(talk);
    }

    void printTrack(int number) {
        System.out.println("Track " + number + ":");
        morning.provideOrder();
        System.out.println("12:00PM Lunch");
        afternoon.provideOrder();

        LocalTime end = afternoon.getSessionEndTime();
        if (end.isBefore(LocalTime.of(16, 0))) {
            end = LocalTime.of(16, 0);
        } else if (end.isAfter(LocalTime.of(17, 0))) {
            end = LocalTime.of(17, 0);
        }

        System.out.println(end.format(DateTimeFormatter.ofPattern("hh:mma")) + " Networking Event");
    }
}
