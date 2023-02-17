package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLRegExValidator extends RegExValidator{


    @Override
    boolean closesElement(String line) {
        return false;
    }

    @Override
    public boolean isSingleLineElement(String line) {
        String singleLineElementRule = "\\/>$";
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

    public int getStartOfFirstAttribute(String line) {
        String getStartOfFirstAttributeRule = "<.*?\\s";
        Pattern javaPattern = Pattern.compile(getStartOfFirstAttributeRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        if(matcher.find()){
            return matcher.end();
        }
        return -1;
    }

    public int getAmountOAttribute(String line) {
        String getStartOfFirstAttributeRule = "\\s.+?\\s=\\s\"(\\w|\\s)+\"?";
        Pattern javaPattern = Pattern.compile(getStartOfFirstAttributeRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);

        return (int)matcher.results().count();
    }

    public List<String> getListOfAttributesNames(String line) {
        List<String> listOfAttributeName = new ArrayList<>();

        String attributeNameRule = "\\b\\w+\\s=";
        Pattern javaPattern = Pattern.compile(attributeNameRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        while (matcher.find()){
            listOfAttributeName.add(line.substring(matcher.start(), matcher.end() - 2));
        }
        return listOfAttributeName;

    }

    public List<String> getListOfAttributesValues(String line) {
        List<String> listOfAttributeValues = new ArrayList<>();

        String attributeNameRule = "=\\s\"(\\w|\\s|\\d)+";
        Pattern javaPattern = Pattern.compile(attributeNameRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        while (matcher.find()){
            listOfAttributeValues.add(line.substring(matcher.start()+3, matcher.end()));
        }
        return listOfAttributeValues;

    }

    public String getValue(String line) {



        String attributeNameRule = ">.*?<";
        Pattern javaPattern = Pattern.compile(attributeNameRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        matcher.find();
        return  line.substring(matcher.start()+1, matcher.end()-1);

    }

    public String getName(String line) {
        String nameRule = "<.+?\\s";
        Pattern javaPattern = Pattern.compile(nameRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        matcher.find();
        return  line.substring(matcher.start()+1, matcher.end()-1);


    }

    public boolean hasValue(String line) {



        String attributeNameRule = ">.*?<";
        Pattern javaPattern = Pattern.compile(attributeNameRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        return  (matcher.find());

    }



}
