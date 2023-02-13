package converter;

import java.util.Scanner;

public class Main {
    static JsonWriter jsonWriter = new JsonWriter();
    static JSONReader jsonReader = new JSONReader();
    static XMLReader xmlReader = new XMLReader();
    static XMLWriter xmlWriter = new XMLWriter();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]){

        String input = scanner.nextLine();

        if(input.substring(0,1).equals("<")) {
            Element element = xmlReader.readNextObject(input, null);
            jsonWriter.writeElement(element);
        }
        else {
            Element element = jsonReader.readNextObject(input, null);
            xmlWriter.writeElement(element);
        }

    }


}
