package uno;
class B {
    int x=4;
    B(int x) {this.x=x;}
}
public class A {
    A() {
        B b1=new B(3);
        B b2=new B(3);
        System.out.println(b1.equals(b2));
    }
    public static void main(String Args[]) {
        new A();
    }
}