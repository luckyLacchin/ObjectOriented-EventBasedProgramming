import java.util.*;
public class A {
    A(int m){
        Collection<Char> b = new TreeSet<char>();
        for (int k=0;k<10;k++) {
            //char s='W'+(k%m); non posso farlo, ma
            char s='W'+1; //posso farlo! Ma dopo non posso mettere i char in una collection, non sono un oggetto!
            b.add(s);
        }
        int count=0;
        Iterator<char> i=b.iterator();
        while (i.hasNext()) {
            char s=i.next();
            System.out.print(s);
        }
    }
    public static void main(String[] a) { new A(3); }
}