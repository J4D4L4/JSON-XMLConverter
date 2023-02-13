package converter;

public class XMLReader extends Reader{

    XMLRegExValidator validator = new XMLRegExValidator();


    public Element readNextObject(String objectAsString, Element parent) {

        if(validator.isSingleLineElement(objectAsString)) {
            String name = objectAsString.substring(1, objectAsString.indexOf("/>"));
            return new Element(name,"null", null,parent);
        }
        if(validator.hasClosingElement(objectAsString)){
            String name = objectAsString.substring(1,objectAsString.indexOf(">")).replace(" ","");
            String value = objectAsString.substring(validator.getEndOfOpeningElement(objectAsString), validator.getStartOfClosingElement(objectAsString)).replace(" ","");
            return new Element(name, value, null, parent);

        }
    return null;
    }

    //public Element createSingleLineElement(String objectAsString, Element Parent) {
        //if(validator.(objectAsString));
    //}


}
