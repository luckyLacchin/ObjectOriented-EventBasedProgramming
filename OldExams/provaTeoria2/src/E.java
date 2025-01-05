public class E {
    static int s=0;
    E(int i){s=i;}
    public static void main(String[] args) {
        E b1=new E(3);
        E b2=new E(3);
        E b3=new E(1);
        if (b1.equals(b2)) System.out.print("K");
        else System.out.print("I");
        if (b1.s==b3.s) System.out.print("D");
        else System.out.print("A");

    }
    public void f() {
        System.out.println(this.s);
        ++this.s;
    }
}
