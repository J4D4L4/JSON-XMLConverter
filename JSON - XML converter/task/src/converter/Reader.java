package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Reader {

    public List<String> getUserInput() {
        List<String> userInput = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            userInput.add(scanner.nextLine());
        }
        return userInput;
    }
    public abstract Element readNextObject(String objectAsString, Element parent);

}
