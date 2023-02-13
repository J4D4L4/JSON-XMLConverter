package converter.tests;
import converter.Element;
import converter.JSONReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonReaderTest {

    JSONReader jsonReader = new JSONReader();
    java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());


    @Test
    public void readNextObjectTest(){

        String string1 ="{\"jdk\" : \"1.8.9\"}";
        String string2 = "{\"storage\" : null}";

        Element element1 = jsonReader.readNextObject(string1, null);
        Element element2 = jsonReader.readNextObject(string2, null);

        Assertions.assertTrue(element1.value.equals("1.8.9"));
        Assertions.assertTrue(element2.name.equals("storage"));


    }



}
