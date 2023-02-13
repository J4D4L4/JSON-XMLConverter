package converter.tests;

import converter.XMLRegExValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XMLRegexTests {

    XMLRegExValidator validator = new XMLRegExValidator();

    @Test
    public void isSingleLineElementTest(){

        String elementTrue= "<XMLClosedElement />";
        String elementFalse= "<XMLOpenElement>";
        Assertions.assertTrue(validator.isSingleLineElement(elementTrue));
        Assertions.assertFalse(validator.isSingleLineElement(elementFalse));


    }

    @Test
    public void getEndOfOpeningElementTest(){

        String element5= "<XML>";
        String element7= "<XMLOp>";
        Assertions.assertEquals(5, validator.getEndOfOpeningElement(element5));
        Assertions.assertEquals(7, validator.getEndOfOpeningElement(element7));

    }

    @Test
    public void getStartOfClosingElementTest(){

        String element5= "</XML>";
        String element7= "</XMLOp>";
        String elemenlator= "<nameXMl> valueXML </nameXML>";
        Assertions.assertEquals(0, validator.getStartOfClosingElement(element5));
        Assertions.assertEquals(0, validator.getStartOfClosingElement(element7));
        Assertions.assertEquals(19, validator.getStartOfClosingElement(elemenlator));

    }

}
