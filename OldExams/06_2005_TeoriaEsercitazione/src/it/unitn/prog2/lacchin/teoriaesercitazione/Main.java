package it.unitn.prog2.lacchin.teoriaesercitazione;

class DemoAssert {
    int y=5;
    public void stampaInteroPositivo(int i) {
        assert i >= 0 : stampaErroreAssert();
        System.out.println(i);
    }
    public int stampaErroreAssert() {
        System.out.println("XX");
        return -1;
    }
    public static void main(String args[]) {
        //x=10;
        DemoAssert test = new DemoAssert();
        test.stampaInteroPositivo(y);
    }
}