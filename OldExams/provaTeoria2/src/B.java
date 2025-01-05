public class B {
    static String k="pluto";
    public static void main(String a[]){
        new B();
        //initialize("pippo");
        System.out.println(k);
    }
    void main(){
        new B();
    }
    void initialize(String s){k=s;}
}