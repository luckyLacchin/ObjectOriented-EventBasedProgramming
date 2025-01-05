import java.util.*;
public class T5 {
    T5(){
        Collection<String> a = new ArrayList<String>();
        Collection<String> b = new HashSet<String>();
        for (int k=0;k<10;k++) {
            String s="A"+(k%4);
            a.add(s);
            b.add(s);
        }
        System.out.println(a.size()+" "+b.size());
    }
    public static void main(String[] a) { new T5(); }
}