public  class D {
    static int x=1;
    class String5 {
        String s;
        String5() {this.s=""+(++x);}
        public void finalize() { System.out.print(s); }
    }
    String5 a=new String5();
    void f() {String5 a=new String5();
    }
    public void finalize() { System.out.print("A"); }
    public static void main(String[] args) {
        D a5=new D();   a5.f();
        a5=new D();     a5.f();
        System.gc();    System.runFinalization();
    }}
