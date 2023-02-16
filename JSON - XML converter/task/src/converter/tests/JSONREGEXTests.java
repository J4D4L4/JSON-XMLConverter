package converter.tests;

import converter.JSONRegExValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONREGEXTests {
    JSONRegExValidator validator = new JSONRegExValidator();
    @Test
    public void isSingleLineElementTest(){

        String elementTrue= "{\"jdk\" : \"1.8.9\"}";
        String elementFalse= "{\"jdk\" : \"1.8.9";
        Assertions.assertTrue(validator.isSingleLineElement(elementTrue));
        Assertions.assertFalse(validator.isSingleLineElement(elementFalse));


    }

    @Test
    public void hasClosingElementTest(){

        String elementTrue= "{\"jdk\" : \"1.8.9\"}";
        String elementFalse= "{\"jdk\" : \"1.8.9";
        Assertions.assertTrue(validator.hasClosingElement(elementTrue));
        Assertions.assertFalse(validator.hasClosingElement(elementFalse));


    }

    @Test
    public void justClosingElementTest(){

        String elementTrue= "}";
        String elementFalse= "{\"jdk\" : \"1.8.9\"}";
        Assertions.assertTrue(validator.justClosingElement(elementTrue));
        Assertions.assertFalse(validator.justClosingElement(elementFalse));

    }

    @Test
    public void getStartofNameTest(){

        String elementOne= "{\"JDK\"}";
        String ElementTwo= "{\"jdk\" : \"1.8.9\"}";
        Assertions.assertEquals(2,validator.getStartofName(elementOne));
        Assertions.assertEquals(2,validator.getStartofName(ElementTwo));

    }

    @Test
    public void getEndOfNameTest(){

        String elementOne= "{\"JDK\"}";
        String ElementTwo= "{\"jdk\" : \"1.8.9\"}";
        Assertions.assertEquals(5,validator.getEndOfName(elementOne));
        Assertions.assertEquals(5,validator.getEndOfName(ElementTwo));

    }

    @Test
    public void getStartOfValueTest(){

        String elementOne= "{\"JDK\"}";
        String ElementTwo= "{\"jdk\" : \"1.8.9\"}";
        Assertions.assertEquals(-1,validator.getStartOfValue(elementOne));
        Assertions.assertEquals(10,validator.getStartOfValue(ElementTwo));

    }

    @Test
    public void getEndOfValueTest(){

        String elementOne= "{\"JDK\"}";
        String ElementTwo= "{\"jdk\" : \"1.8.9\"}";
        Assertions.assertEquals(-1,validator.getEndOfValue(elementOne));
        Assertions.assertEquals(15,validator.getEndOfValue(ElementTwo));

    }


    @Test
    public void getListOfAttributeNamesTest(){

        String elementOne= """
                                  {
                                  "employee" : {
                                      "@department" : "manager",
                                      "#employee" : "Garry Smith"
                                  }
                              }""";
        Assertions.assertEquals("department",validator.getListOfAttributeNames(elementOne).get(0));

    }

    @Test
    public void getListOfAttributesTest(){

        String elementOne= """
                                  {
                                  "employee" : {
                                      "@department" : "manager",
                                      "#employee" : "Garry Smith"
                                  }
                              }""";
        Assertions.assertEquals("manager",validator.getListOfAttributeValues(elementOne).get(0));

    }

    @Test
    public void getValueTest(){

        String elementOne= """
                                  {
                                  "employee" : {
                                      "@department" : "manager",
                                      "#employee" : "Garry Smith"
                                  }
                              }""";
        Assertions.assertEquals("Garry Smith",validator.getValue(elementOne));

    }


}
