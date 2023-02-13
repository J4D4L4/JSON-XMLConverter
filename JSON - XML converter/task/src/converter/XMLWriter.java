package converter;

public class XMLWriter extends Writer{
    @Override
    public void writeElement(Element element) {

        if(element.value=="null"){
            System.out.printf("<%s />", element.name);
        }

        else
            System.out.printf("<%s> %s </%s>", element.name, element.value, element.name);

    }
}
