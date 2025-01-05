interface A {
    int f(int x);
}
class B implements A,Comparable {
    public int f(int w) {
        return w*2;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
class C extends B {
    int f(float w){
        return (int)(w*4);
    }}
public class Main {
    public static void main(String[] args) {
        A a = new C();
        System.out.print(a.f(3));
    }}