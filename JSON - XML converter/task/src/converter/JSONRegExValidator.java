package converter;

import java.util.ArrayList;
import java.util.List;
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

    // first name is element name, all following are attribute names
    public List<String> getListOfAttributeNames(String line){
        List<String> listOfNames = new ArrayList<>();
        List<String> attributeLines = getAttributeLines(line);
        String nameRule = "\"@(\\w|\\s|\\d)+\"?";
        Pattern javaPattern = Pattern.compile(nameRule, Pattern.CASE_INSENSITIVE);
        for(String attribute : attributeLines){
            Matcher matcher = javaPattern.matcher(attribute);
            matcher.find();
            String name =attribute.substring(matcher.start()+2,matcher.end()-1);
            listOfNames.add(name);
        }

        return listOfNames;

    }

    public List<String> getListOfAttributeValues(String line){
        List<String> listOfNames = new ArrayList<>();
        List<String> attributeLines = getAttributeLines(line);
        String valueRule = ":\\s(\".+\"|\\d+)";
        String hasDigits = ":\\s(\\d+)";
        Pattern javaPattern = Pattern.compile(valueRule, Pattern.CASE_INSENSITIVE);
        Pattern digitpattern = Pattern.compile(hasDigits,Pattern.CASE_INSENSITIVE);
        for(String attribute : attributeLines){
            Matcher matcher = javaPattern.matcher(attribute);
            matcher.find();
            Matcher digitMatcher = digitpattern.matcher(attribute);
            String value= "";
            if (!digitMatcher.find())
                value =attribute.substring(matcher.start()+3,matcher.end()-1);
            else
                value = attribute.substring(matcher.start()+2,matcher.end());

            listOfNames.add(value);
        }

        return listOfNames;

    }

    public String getName(String line){
        String elementAttributeRule = "\"\\w+";
        Pattern javaPattern = Pattern.compile(elementAttributeRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        if (matcher.find())
            return line.substring(matcher.start()+1,matcher.end());

        else  return null;

    }

    public List<String> getAttributeLines(String line){

        List<String> listOfAttributes = new ArrayList<>();
        String elementAttributeRule = "\"@(\\w|\\d|\\s)*\"\\s:\\s\"{0,1}(\\s|\\w|\\d)+\"{0,1},";
        Pattern javaPattern = Pattern.compile(elementAttributeRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        while (matcher.find())
            listOfAttributes.add(line.substring(matcher.start(),matcher.end()));

        return listOfAttributes;

    }

    public String getValue(String line){
        String elementAttributeRule = "\"#\\w+\"\\s:\\s(\"(.*)?|null)";
        String valueRule ="(:\\s\".+|null)";
        Pattern javaPattern = Pattern.compile(elementAttributeRule, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(line);
        matcher.find();
        String valueLine = line.substring(matcher.start()+1,matcher.end());
        javaPattern = Pattern.compile(valueRule, Pattern.CASE_INSENSITIVE);
        Matcher valueMatcher = javaPattern.matcher(valueLine);
        if(valueMatcher.find())
            if(valueLine.substring(valueMatcher.start(),valueMatcher.start()+1).equals("n"))
                return valueLine.substring(valueMatcher.start(), valueMatcher.end());
            else
                return valueLine.substring(valueMatcher.start()+3, valueMatcher.end()-1);
        else return null;


    }


}
