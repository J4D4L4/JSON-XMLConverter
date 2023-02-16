package converter;

import java.util.List;

public class JSONReader extends Reader{

    JSONRegExValidator validator = new JSONRegExValidator();
    @Override
    public Element readNextObject(String objectAsString, Element parent) {
        if(validator.isSingleLineElement(objectAsString)){
            return createSingleLineElement(objectAsString,parent);

        }
        else
            return createElementWithAttributes(objectAsString,parent);
    }


    public Element createSingleLineElement(String elementAsString, Element parent) {
        String name = elementAsString.substring(validator.getStartofName(elementAsString),validator.getEndOfName(elementAsString));
        if(validator.getStartOfValue(elementAsString) != -1) {

            String value = elementAsString.substring(validator.getStartOfValue(elementAsString),validator.getEndOfValue(elementAsString));
            return new Element(name,value,null, parent);

        }
        else
            return new Element(name, "null", null, parent);

    }

    public Element createElementWithAttributes(String objectAsString, Element parent) {

        List<String> attributeNames = validator.getListOfAttributeNames(objectAsString);
        List<String> attributeValues = validator.getListOfAttributeValues(objectAsString);
        List<Attribute> attributes = createListOfAttribute(attributeNames, attributeValues);
        String name = validator.getName(objectAsString);
        return new Element(name,validator.getValue(objectAsString),attributes,parent);

    }

}

