package converter.tests;

import converter.Element;
import converter.XMLReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XMLReaderTest {
    XMLReader xmlReader = new XMLReader();
    java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
    @Test
    public void readNextObjectTest(){

        String xmlLine ="<nameXMl> valueXML </nameXML>";
        Element toTestObject = xmlReader.readNextObject(xmlLine, null);
        Assertions.assertTrue(toTestObject.name.equals("nameXMl"));
        Assertions.assertTrue("valueXML".equals(toTestObject.value));

    }
}
