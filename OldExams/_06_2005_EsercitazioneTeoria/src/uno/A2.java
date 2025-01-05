package uno;
public class A2 {
    C c=null;
    public A2() {
        System.out.print("+10");
        C c1=new C();
        c=new C();
    }
    public static void main(String[] args) {
        A2 a = new A2();
        System.gc();
        new C();
        a = null;
        System.gc();
    }
}
class C {
    static int count=0;
    String name=null;
    public C() {
        name="2"+(++count);
        System.out.print("+"+name);
    }
    protected void finalize() {
        System.out.print("-"+name);
    }
}
