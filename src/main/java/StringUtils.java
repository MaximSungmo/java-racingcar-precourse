import java.util.Collection;

public class StringUtils {

    public static String join(Collection<String> stringCollection, String glue) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringCollection) {
            appendGlue(stringBuilder, glue);
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    private static void appendGlue(StringBuilder stringBuilder, String glue) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append(glue);
        }
    }
}
