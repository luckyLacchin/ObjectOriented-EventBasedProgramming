public class T3 {
    public static void main(String[] args) {
        A2 a = new A2(10);
        a.m("adige");
        A2 a1 = new C2();
        C2 c1 = (C2) a1;
        c1.m("arno");
        A2 a2 = new B2();
        C2 c2 = (C2) a2;
        c2.m("tevere");
    }
}
class A2 {
    static int n=0;
    int x=1;
    A2(int x) { this.x = x; }
    public void m(String s) { System.out.print(s.length() * x); }
}
class B2 extends A2 {
    B2() { super(n++);}
}
class C2 extends B2 {}
