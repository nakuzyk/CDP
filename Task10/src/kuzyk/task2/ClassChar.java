package kuzyk.task2;

/**
 * The type Class char.
 */
public class ClassChar {
    /**
     * The Str.
     */
    String str =new String();

    /**
     * Instantiates a new Class char.
     *
     * @param str the str
     */
    public ClassChar(String str){
        this.str=str;
    }

    @Override
    public int hashCode(){
        char [] maschar=str.toCharArray();
        int result = maschar[0] + maschar[1] + maschar[2] + maschar[3];
        return result;
    }
}
