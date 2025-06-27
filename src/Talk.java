import java.util.regex.*;

class Talk {
    private static final int LIGHTNING_DURATION = 5;
    private static final Pattern TALK_PATTERN = Pattern.compile("(.+)\\s(\\d+)min$");

    private final String title;
    private final int duration;

    public Talk(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    static Talk parse(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException("Talk description cannot be empty.");
        }

        line = line.trim();
        if (line.endsWith("lightning")) {
            String title = line.replace("lightning", "").trim();
            return new Talk(title, LIGHTNING_DURATION);
        }

        Matcher matcher = TALK_PATTERN.matcher(line);
        if (matcher.matches()) {
            String title = matcher.group(1).trim();
            int duration = Integer.parseInt(matcher.group(2));
            return new Talk(title, duration);
        }

        throw new IllegalArgumentException("Invalid talk format: " + line);
    }

    int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " " + (duration == LIGHTNING_DURATION ? "lightning" : duration + "min");
    }
}
