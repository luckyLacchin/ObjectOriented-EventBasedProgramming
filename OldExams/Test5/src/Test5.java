public class Test5 {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        J j= b;
        System.out.println(j.m(5) + b.m("hello"));
    }
}
interface I {
    int m(int z);
}

interface H {}
interface J extends I,H {
    int m(String s);
}
class A implements I {
    int x = 5;
    public int m(int z) { return x + z; }
}
class B implements J {
    public int m(String s) { return s.length(); }
}