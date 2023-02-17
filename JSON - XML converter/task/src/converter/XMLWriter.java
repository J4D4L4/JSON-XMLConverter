package converter;

import java.security.PublicKey;

public class XMLWriter extends Writer{
    @Override
    public void writeElement(Element element) {

        if(element.value.equals("null")){
            System.out.printf(writeElementWithoutValue(element));
        }

        else
            System.out.printf(writeElementWithValue(element));

    }

    public String writeAttribute(Element element) {

        String attributeString ="";

        for(Attribute attribute : element.attributes){
            if(isNumeric(attribute.value))
                attributeString += " "+attribute.name+" : "+attribute.value+"";
            else
                attributeString += " "+attribute.name+" : \""+attribute.value+"\"";
        }

        return attributeString;
    }
/*
    public String writeValue(Element element) {
        String nameString = "";
        nameString += "\""+element.name+"\" : \""+element.value+"\"";
        return nameString;

    }*/

    public String writeElementWithValue(Element element) {

        return String.format("<%s %s> %s </%s>",element.name, writeAttribute(element), element.value, element.name);

    }

    public String writeElementWithoutValue(Element element) {
        return String.format("<%s %s />", element.name, writeAttribute(element));
    }
}
