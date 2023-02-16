package converter;

import java.util.List;
import java.util.jar.Attributes;

public class XMLReader extends Reader{

    XMLRegExValidator validator = new XMLRegExValidator();


    public Element readNextObject(String objectAsString, Element parent) {

        if(validator.isSingleLineElement(objectAsString)) {
            return createNoAttributeElement(objectAsString,parent);
        }
        if(validator.hasClosingElement(objectAsString)){
            return createSingleLineElement(objectAsString,parent);
        }
    return null;
    }

    public Element createNoValueElement(String objectAsString, Element parent) {

        return new Element(null,null,null,null);

    }

    public Element createNoAttributeElement(String objectAsString, Element parent) {

        String name = validator.getName(objectAsString);
        return new Element(name,"null", null,parent);
    }

    public Element createAttributeElement(String objectAsString, Element parent) {
        String name = validator.getName(objectAsString);
        List<Attribute> listOfAttributes = createListOfAttribute(validator.getListOfAttributesNames(objectAsString),validator.getListOfAttributesValues(objectAsString));
        return new Element(name,validator.getValue(objectAsString), listOfAttributes,parent);

    }

    public Element createSingleLineElement(String objectAsString, Element parent) {

        if(validator.getAmountOAttribute(objectAsString)>0){
            return createAttributeElement(objectAsString,parent);
        }
        else {
            return createNoAttributeElement(objectAsString,parent);
        }

    }

}
