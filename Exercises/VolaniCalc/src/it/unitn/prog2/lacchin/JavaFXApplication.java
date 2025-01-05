package it.unitn.prog2.lacchin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

    Text output;
    Text cronologia;
    Text crono;
    static String storia = "Ultimi calcoli: ";
    static String result = "Risultato: ";
    static String n1="";
    static String n2="";
    static String op="";

    /**
     * ti checcko se mi dai nu numero
     * @param f una stringa e verifica se è un numero
     * @return be ritorna un bel booleano
     */
    static boolean isanumber(String f){
        boolean corretto=false;

        int i=0;
        char[] farr = f.toCharArray();

        while(i<f.length() && !corretto){
            if(farr[i]>='0' && farr[i]<='9'){
                corretto=true;
            }
            i++;
        }

        return corretto;
    }

    @Override
    public void start(Stage primaryStage) {

        int width=400;
        int height=300;

        GridPane calc = new GridPane();
        calc.setVgap(6);
        calc.setHgap(6);

        calc.setAlignment(Pos.CENTER);
        Button b1 = new Button("1");
        b1.setMinWidth(55);
        Button b2 = new Button("2");
        b2.setMinWidth(55);
        Button b3 = new Button("3");
        b3.setMinWidth(55);
        Button b4 = new Button("4");
        b4.setMinWidth(55);
        Button b5 = new Button("5");
        b5.setMinWidth(55);
        Button b6 = new Button("6");
        b6.setMinWidth(55);
        Button b7 = new Button("7");
        b7.setMinWidth(55);
        Button b8 = new Button("8");
        b8.setMinWidth(55);
        Button b9 = new Button("9");
        b9.setMinWidth(55);
        Button b0 = new Button("0");
        b0.setMinWidth(55);
        calc.add(b1,0,1);
        calc.add(b2,1,1);
        calc.add(b3,2,1);
        calc.add(b4,0,2);
        calc.add(b5,1,2);
        calc.add(b6,2,2);
        calc.add(b7,0,3);
        calc.add(b8,1,3);
        calc.add(b9,2,3);
        calc.add(b0,1,4);

        Button point = new Button(".");
        point.setMinWidth(55);
        calc.add(point,2,4);
        Button canc = new Button("canc");
        canc.setMinWidth(55);
        calc.add(canc,0,4);

        Button piu = new Button("+");
        piu.setMinWidth(55);
        Button meno = new Button("-");
        meno.setMinWidth(55);
        Button per = new Button("*");
        per.setMinWidth(55);
        Button diviso = new Button("/");
        diviso.setMinWidth(55);
        calc.add(piu,4,1);
        calc.add(meno,4,2);
        calc.add(per,4,3);
        calc.add(diviso,4,4);
        Button uguale = new Button("=");
        uguale.setMinWidth(55);
        calc.add(uguale,5,4);

        output = new Text(result);
        calc.add(output,0,0,4,1);
        cronologia = new Text(storia);
        calc.add(cronologia,0,5,2,1);
        crono = new Text();
        calc.add(crono,0,6,4,1);
        /////////////////////////////////////////
        ListenerCanc listenerCanc = new ListenerCanc();
        Listener0 listener0 = new Listener0();
        Listener1 listener1 = new Listener1();
        Listener2 listener2 = new Listener2();
        Listener3 listener3 = new Listener3();
        Listener4 listener4 = new Listener4();
        Listener5 listener5 = new Listener5();
        Listener6 listener6 = new Listener6();
        Listener7 listener7 = new Listener7();
        Listener8 listener8 = new Listener8();
        Listener9 listener9 = new Listener9();
        Listenerper listenerper = new Listenerper();
        Listenerpiu listenerpiu = new Listenerpiu();
        Listenerdiviso listenerdiviso = new Listenerdiviso();
        Listenermeno listenermeno = new Listenermeno();
        Listeneruguale listeneruguale = new Listeneruguale();
        Listenerpoint listenerpoint = new Listenerpoint();
        b0.addEventHandler(ActionEvent.ACTION,listener0);
        b1.addEventHandler(ActionEvent.ACTION,listener1);
        b2.addEventHandler(ActionEvent.ACTION,listener2);
        b3.addEventHandler(ActionEvent.ACTION,listener3);
        b4.addEventHandler(ActionEvent.ACTION,listener4);
        b5.addEventHandler(ActionEvent.ACTION,listener5);
        b6.addEventHandler(ActionEvent.ACTION,listener6);
        b7.addEventHandler(ActionEvent.ACTION,listener7);
        b8.addEventHandler(ActionEvent.ACTION,listener8);
        b9.addEventHandler(ActionEvent.ACTION,listener9);
        piu.addEventHandler(ActionEvent.ACTION,listenerpiu);
        per.addEventHandler(ActionEvent.ACTION,listenerper);
        meno.addEventHandler(ActionEvent.ACTION,listenermeno);
        diviso.addEventHandler(ActionEvent.ACTION,listenerdiviso);
        uguale.addEventHandler(ActionEvent.ACTION,listeneruguale);
        canc.addEventHandler(ActionEvent.ACTION,listenerCanc);
        point.addEventHandler(ActionEvent.ACTION,listenerpoint);
        /////////////////////////////////////////
        Scene scene = new Scene(calc,width,height);
        primaryStage.setTitle("Calcolatrice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class ListenerCanc implements EventHandler{
        @Override
        public void handle(Event event) {
            n1="";
            n2="";
            op="";
            result="Risultato: ";
            output.setText(result);
        }
    }
    class Listener1 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "1";
            } else {
                n2 = n2 + "1";
            }
            result = result + "1";
            output.setText(result);
        }
    }
    class Listener2 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "2";
            } else {
                n2 = n2 + "2";
            }
            result = result + "2";
            output.setText(result);
        }
    }
    class Listener3 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "3";
            } else {
                n2 = n2 + "3";
            }
            result = result + "3";
            output.setText(result);
        }
    }
    class Listener4 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "4";
            } else {
                n2 = n2 + "4";
            }
            result = result + "4";
            output.setText(result);
        }
    }
    class Listener5 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "5";
            } else {
                n2 = n2 + "5";
            }
            result = result + "5";
            output.setText(result);
        }
    }
    class Listener6 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "6";
            } else {
                n2 = n2 + "6";
            }
            result = result + "6";
            output.setText(result);
        }
    }
    class Listener7 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "7";
            } else {
                n2 = n2 + "7";
            }
            result = result + "7";
            output.setText(result);
        }
    }
    class Listener8 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "8";
            } else {
                n2 = n2 + "8";
            }
            result = result + "8";
            output.setText(result);
        }
    }
    class Listener9 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "9";
            } else {
                n2 = n2 + "9";
            }
            result = result + "9";
            output.setText(result);
        }
    }
    class Listener0 implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("")){
                n1 = n1 + "0";
            } else {
                n2 = n2 + "0";
            }
            result = result + "0";
            output.setText(result);
        }
    }
    class Listenerpiu implements EventHandler{
        @Override
        public void handle(Event event) {
            if(!n1.equals("") && op.equals("")){
                op = "+";
                result = result + op;
            }
            output.setText(result);
        }
    }
    class Listenermeno implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n1.equals("")){
                n1 = "-";
                result = result + n1;
            } else if(op.equals("")){
                op="-";
                result = result + op;
            } else if(n2.equals("")){
                n2 = "-";
                result = result + " " + n2;
            }
            output.setText(result);
        }
    }
    class Listenerper implements EventHandler{
        @Override
        public void handle(Event event) {
            if(!n1.equals("") && op.equals("")){
                op = "*";
                result = result + op;
            }
            output.setText(result);
        }
    }
    class Listenerdiviso implements EventHandler{
        @Override
        public void handle(Event event) {
            if(!n1.equals("") && op.equals("")){
                op = "/";
                result = result + op;
            }
            output.setText(result);
        }
    }
    class Listeneruguale implements EventHandler{
        @Override
        public void handle(Event event) {
            if(!op.equals("") && !n1.equals("") && !n2.equals("")){
                float num1 = Float.parseFloat(n1);
                float num2 = Float.parseFloat(n2);
                float ris;
                switch (op) {
                    case "+":
                        ris = num1 + num2;
                        break;
                    case "-":
                        ris = num1 - num2;
                        break;
                    case "*":
                        ris = num1 * num2;
                        break;
                    case "/":
                        ris = num1 / num2;
                        break;
                    default:
                        ris = 0;
                        break;
                }
                Float riswrap = Float.valueOf(ris);
                result = riswrap.toString();
                output.setText(result);
                System.out.println(result);
                crono.setText(n1+op+n2+"="+result);
                n1=riswrap.toString();
                n2="";
                op="";
            }
        }
    }
    class Listenerpoint implements EventHandler{
        @Override
        public void handle(Event event) {
            if(n2.equals("") && op.equals("") && !n1.contains(".")){
                n1 = n1 + ".";
                result = result + ".";
            } else if(isanumber(n1) && !op.equals("") && !n2.contains(".")){
                n2 = n2 + ".";
                result = result + ".";
            }
            output.setText(result);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}