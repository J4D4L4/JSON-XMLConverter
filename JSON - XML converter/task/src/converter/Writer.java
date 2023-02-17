package converter;

import java.util.ArrayList;
import java.util.List;

public abstract class Writer {

    public abstract void writeElement(Element element);

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }



}
