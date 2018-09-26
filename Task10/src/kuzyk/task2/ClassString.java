package kuzyk.task2;

/**
 * The type Class string.
 */
public class ClassString {
    /**
     * The Str.
     */
    String str = new String();

    /**
     * Instantiates a new Class string.
     *
     * @param str the str
     */
    public ClassString(String str){
        this.str=str;
    }

    @Override
    public int hashCode() {
        return str.length();
    }
}
