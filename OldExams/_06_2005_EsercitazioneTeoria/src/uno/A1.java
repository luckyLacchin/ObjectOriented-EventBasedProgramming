package uno;
public class A1{
    static int f(int x) {x++; return x-1;}
    private int g(int x) {x--; return x+1;}
    public static void main(String String[]) {
        int z=3;
        System.out.println(f(z));
        //System.out.println(g(z)); Non-static method 'g(int)' cannot be referenced from a static context
    }
}