public class B1 {
    String [] a;// = new String[0];
    int [] k;
    void initialize(){
        for (int k=9;k>=0;--k) a[k]=""+k;
    }
    void stampa(int k){
        System.out.println(a[k]);
    }
    B1() {initialize(); stampa(0); }
    public static void main(String a[]){
        new B1();
    }
    public static void main(String a){
        new B1();
    }
}