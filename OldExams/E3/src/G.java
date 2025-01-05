import java.util.Iterator;
import java.util.LinkedList;

class E3 {
    static int counter=4;
    private int value=2;
    E3(){value=++counter;}
    public String toString(){
        return this.getClass().getName()+value+" ";}
    public void finalize(){System.out.print("F"+value);}
}
public class G extends E3{
    public static void main(String d[]){
        LinkedList<E3> x=new LinkedList<E3>();
        E3 a1=new G();
        G a2 =new G();
        E3 a3=new E3();
        x.add(a1);x.add(a3);
        a1=null; a2=null; a3=null;
        Iterator<E3> it=x.iterator();
        while (it.hasNext()){System.out.print(it.next());}
        System.gc();System.runFinalization();
}}