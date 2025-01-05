public class G implements Cloneable{
    int k=0;
    @Override
    public G clone() {
        G copia=null;
        try {
            copia= (G) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.exit(0);
        }
        copia.k++;
        return copia;
    }
    public boolean equals(Object x) {
        if (! (x instanceof G)) return false;
        return k==((G)x).k;
    }
    public static void main(String[] args) {
        G b= new G();
        G c=b.clone();
        G d=new G();
        System.out.println(b+" "+" "+c);
        if (b.equals(c)) System.out.print("A");
        if (c.equals(d)) System.out.print("B");
        if (d.equals(b)) System.out.print("C");
    }}