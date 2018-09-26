package kuzyk.task2;

public class ClassChar {
    String str =new String();
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
