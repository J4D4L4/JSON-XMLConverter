package converter.tests;

import converter.XMLRegExValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void getStartOfFirstAttributeTest(){

        String element10= "<employee department = \"manager\">Garry Smith</employee>";
        String element8= "<person rate = \"1\" name = \"Torvalds\" />";
        String noFind= "<host>127.0.0.1</host>";
        Assertions.assertEquals(10, validator.getStartOfFirstAttribute(element10));
        Assertions.assertEquals(8, validator.getStartOfFirstAttribute(element8));
        Assertions.assertEquals(-1, validator.getStartOfFirstAttribute(noFind));

    }

    @Test
    public void getAmountOAttributeTest(){

        String element2= "<person rate = \"1\" name = \"Torvalds\" />";
        String element1= "<employee department = \"manager\">Garry Smith</employee>";
        String noFind= "<host>127.0.0.1</host>";
        Assertions.assertEquals(2, validator.getAmountOAttribute(element2));
        Assertions.assertEquals(1, validator.getAmountOAttribute(element1));
        Assertions.assertEquals(0, validator.getAmountOAttribute(noFind));

    }

    @Test
    public void getListOfAttributesValuesTest(){

        String element2= "<person rate = \"1\" name = \"Torvalds\" />";
        String element1= "<employee department = \"manager\">Garry Smith</employee>";
        String noFind= "<host>127.0.0.1</host>";
        List<String> ele1String = validator.getListOfAttributesValues(element2);
        Assertions.assertEquals(2, ele1String.size());
        Assertions.assertEquals("1", ele1String.get(0));

    }

    @Test
    public void getListOfAttributesNamesTest(){

        String element2= "<person rate = \"1\" name = \"Torvalds\" />";
        String element1= "<employee department = \"manager\">Garry Smith</employee>";
        String noFind= "<host>127.0.0.1</host>";
        List<String> ele1String = validator.getListOfAttributesNames(element2);
        Assertions.assertEquals(2, ele1String.size());
        Assertions.assertEquals("rate", ele1String.get(0));

    }

    @Test
    public void getValueTest(){

        String element2= "<employee department = \"manager\">Garry Smith</employee>";
        String element1= "<employee department = \"manager\">Garry Smith</employee>";
        String noFind= "<host>127.0.0.1</host>";
        String ele1String = validator.getValue(element1);
        Assertions.assertEquals("Garry Smith",ele1String);


    }
    @Test
    public void getNameTest(){

        String element2= "<employee department = \"manager\">Garry Smith</employee>";
        String element1= "<employee department = \"manager\">Garry Smith</employee>";
        String noFind= "<host>127.0.0.1</host>";
        String ele1String = validator.getName(element1);
        Assertions.assertEquals("employee",ele1String);


    }




}
