public class Test {
    public static void main(String[] args) {
        A a = new A();
        B b = a.m(5);
        b.m();
    }
}
class A {
    B m(int x) { return new B(x); }
}
class B {
    int x;
    B(int x) { this.x = x; }
    void m() throws MyException { if (x%2 != 0) throw new MyException(); }
}
class MyException extends Exception {}