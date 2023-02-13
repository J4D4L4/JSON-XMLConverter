package converter;

public abstract class RegExValidator {

    abstract boolean closesElement(String line);
    abstract boolean isSingleLineElement(String line);
    abstract boolean hasClosingElement(String line);
    abstract boolean justClosingElement(String line);

}
