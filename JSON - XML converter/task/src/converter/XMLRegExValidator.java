package converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLRegExValidator extends RegExValidator{


    @Override
    boolean closesElement(String line) {
        return false;
    }

    @Override
    public boolean isSingleLineElement(String line) {
        String singleLineElementRule = "<(\\w|\\s)+\\/>$";
        Pattern javaPattern = Pattern.compile(singleLineElementRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        return (matcher.find());
    }

    @Override
    public boolean hasClosingElement(String line) {
        String singleLineElementRule = "<\\/(\\w|\\s)+>$";
        Pattern javaPattern = Pattern.compile(singleLineElementRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        return (matcher.find());
    }

    @Override
    public boolean justClosingElement(String line) {
        String singleLineElementRule = "^<\\/(\\w|\\s)+>";
        Pattern javaPattern = Pattern.compile(singleLineElementRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        return (matcher.find());
    }


    public int getEndOfOpeningElement(String line) {
        String openingElementRule = "<(\\w|\\s)+>";
        Pattern javaPattern = Pattern.compile(openingElementRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        if(matcher.find()){
            return matcher.end();
        }
        return -1;
    }


    public int getStartOfClosingElement(String line) {
        String endingElementRule = "<\\/(\\w|\\s)+>$";
        Pattern javaPattern = Pattern.compile(endingElementRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        if(matcher.find()){
            return matcher.start();
        }
        return -1;
    }
}
