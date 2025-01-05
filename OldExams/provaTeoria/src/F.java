public class F{
    int x=2;
    F(int x) {
        f(x);
        f();
        System.out.println(x);
    }
    void f() { x++; System.out.print(x);}
    void f(int x) { this.x++; x--;System.out.print(x);}
    public static void main(String arg[]) {
        F x=new F(9);
        //B a = new A();
        B a = (B) (new A());
    }}