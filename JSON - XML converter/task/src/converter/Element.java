package converter;

import java.util.ArrayList;
import java.util.List;

public class Element {

    public String name;
    public String value;
    List<Attribute> attributes;
    Element parent;
    List<Element> children;

    Element(String name, String value, List<Attribute> attributes, Element parent){

        this.name = name;
        this.value = value;
        this. attributes = attributes;
        this.parent = parent;
        this.children = new ArrayList<>();

    }


}
