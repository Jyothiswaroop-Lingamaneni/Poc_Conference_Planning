import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(
                "Writing Fast Tests Against Enterprise Rails 60min",
                "Overdoing it in Python 45min",
                "Lua for the Masses 30min",
                "Ruby Errors from Mismatched Gem Versions 45min",
                "Common Ruby Errors 45min",
                "Rails for Python Developers lightning",
                "Communicating Over Distance 60min",
                "Accounting-Driven Development 45min",
                "Woah 30min",
                "Sit Down and Write 30min",
                "Pair Programming vs Noise 45min",
                "Rails Magic 60min",
                "Ruby on Rails: Why We Should Move On 60min",
                "Clojure Ate Scala (on my project) 45min",
                "Programming in the Boondocks of Seattle 30min",
                "Ruby vs. Clojure for Back-End Development 30min",
                "Ruby on Rails Legacy App Maintenance 60min",
                "A World Without HackerNews 30min",
                "User Interface CSS in Rails Apps 30min"

        );

        List<Talk> talks = parseInput(input);
        EventPlanner scheduler = new EventPlanner(talks);
        scheduler.schedule();
    }

    static List<Talk> parseInput(List<String> inputLines) {
        List<Talk> talks = new ArrayList<>();
        for (String line : inputLines) {
            try {
                talks.add(Talk.parse(line));
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid input skipped: " + e.getMessage());
            }
        }
        return talks;
    }
}