package converter;

public class JsonWriter extends Writer{
    @Override
    public void writeElement(Element element) {
        if(element.value != "null")
            System.out.printf("{\"%s\" : \"%s\"}%n", element.name,element.value);
        else
            System.out.printf("{\"%s\" : %s}%n", element.name,element.value);

    }
}
