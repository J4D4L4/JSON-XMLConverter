package converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONRegExValidator extends RegExValidator{
    @Override
    boolean closesElement(String line) {
        return false;
    }

    @Override
    public boolean isSingleLineElement(String line) {
        String singleLineElementRule = "\\{\"(\\w|\\s)+\"\\s*:\\s*(\\w|\\s|\\W)+}";
        Pattern javaPattern = Pattern.compile(singleLineElementRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        return (matcher.find());
    }

    @Override
    public boolean hasClosingElement(String line) {
        String singleLineElementRule = "}$";
        Pattern javaPattern = Pattern.compile(singleLineElementRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        return (matcher.find());
    }

    @Override
    public boolean justClosingElement(String line) {
        String singleLineElementRule = "^}";
        Pattern javaPattern = Pattern.compile(singleLineElementRule);
        Matcher matcher = javaPattern.matcher(line);
        return (matcher.matches() && line.length() == 1);
    }

    public int getStartofName(String line) {

        String startOfNameRule = "[{]\"";
        Pattern javaPattern = Pattern.compile(startOfNameRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        matcher.find();
        return (matcher.end());

    }

    public int getEndOfName(String line) {

        String endOfNameRule = "^\\{\"(\\s|\\w)+";
        Pattern javaPattern = Pattern.compile(endOfNameRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        matcher.find();
        return (matcher.end());

    }

    public int getStartOfValue(String line) {

        String startOfValueRule = "^\\{\"(\\s|\\w)+\"\\s*:\\s*\"";
        Pattern javaPattern = Pattern.compile(startOfValueRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        if(matcher.find())
            return (matcher.end());
        else return -1;

    }

    public int getEndOfValue(String line) {

        String EndOfValueRule = "^\\{\"(\\s|\\w)+\"\\s*:\\s*\"(\\s|\\w|\\W)+\"";
        Pattern javaPattern = Pattern.compile(EndOfValueRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        if(matcher.find())
            return (matcher.end()-1);
        else return -1;

    }


}
