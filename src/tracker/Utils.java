package tracker;

public final class Utils {
    public static boolean emptyOrWhitespace(String string) {
        return string == null || string.trim().isEmpty();
    }
}
