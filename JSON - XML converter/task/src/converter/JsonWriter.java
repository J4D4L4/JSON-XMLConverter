package converter;

public class JsonWriter extends Writer{
    @Override
    public void writeElement(Element element) {
        System.out.print(createStringOfElement(element));
    }

    public String writeAttributes(Element element) {

        String attributeString = "";

        for(Attribute attribute : element.attributes) {

            attributeString += "\"@"+attribute.name+"\" : "+ "\""+attribute.value+"\",";

        }
        return attributeString;

    }

    public String writeValue(Element element) {
        String nameString = "";
        if (element.value.equals("null"))
            nameString += "\"#"+element.name+"\" : "+element.value+"%n";
        else
            nameString += "\"#"+element.name+"\" : \""+element.value+"\"";
        return nameString;

    }


    public String createStringOfElement(Element element) {

        if(element.attributes.size() == 0){
            return String.format("{\"%s\" : %s}", element.name,element.value);
        }
        else {

            String elementString =String.format( """
                    {
                        %s : {
                            %s
                            %s
                        }
                    }
                    """,element.name,writeAttributes(element), writeValue(element));
            return elementString;
        }

    }

}
