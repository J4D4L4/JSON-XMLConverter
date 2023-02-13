package converter;

import java.util.ArrayList;
import java.util.List;

public class Element {

    public String name;
    public String value;
    List<String> attributes;
    Element parent;
    List<Element> children;

    Element(String name, String value, List<String> attributes, Element parent){

        this.name = name;
        this.value = value;
        this. attributes = attributes;
        this.parent = parent;
        this.children = new ArrayList<>();

    }


}
