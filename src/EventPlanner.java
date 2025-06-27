
import java.util.*;

class EventPlanner {
    private final List<Talk> talks;

    EventPlanner(List<Talk> talks) {
        this.talks = new ArrayList<>(talks);
        this.talks.sort(Comparator.comparingInt(Talk::getDuration).reversed());
    }

    void schedule() {
        List<Track> tracks = new ArrayList<>();
        while (!talks.isEmpty()) {
            Track track = new Track();
            talks.removeIf(track::addTalk);
            tracks.add(track);
        }

        int trackNumber = 1;
        for (Track track : tracks) {
            track.printTrack(trackNumber++);
        }
    }

}
