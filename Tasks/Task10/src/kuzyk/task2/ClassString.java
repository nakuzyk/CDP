package kuzyk.task2;

public class ClassString {
    String str = new String();
    public ClassString(String str){
        this.str=str;
    }

    @Override
    public int hashCode() {
        return str.length();
    }
}
