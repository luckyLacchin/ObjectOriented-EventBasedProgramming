package it.unitn.prog2.lacchin.picco_febbraio2019;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class InputAuto extends Input{

    public InputAuto (Catalogo main) {
        super(main);
        tx1.setText("Marca");
        tx2.setText("Modello");
        tx3.setText("Prezzo");


        controlla.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                boolean corretto = true;
                int n;
                Automobile automobile = null;
                if (field1.getText().equals("") || field2.getText().equals("") ||
                            field1.getText().equals("")) {
                    System.out.println("Riempire tutti i textField!");
                    corretto = false;
                }
                if (corretto) {
                    try {
                        n = Integer.parseInt(field3.getText());
                    } catch (NumberFormatException e) {
                        System.out.println("Inserire un formato di un numero valido!");
                        corretto = false;
                    }
                }
                if (corretto) {
                    automobile = new Automobile(field1.getText(),field2.getText(),Integer.valueOf(field3.getText()));
                    if(main.persone.size() > 0) {
                        corretto = equivalenti(automobile);
                    }
                }
                if (corretto) {
                    main.automobili.add(automobile);
                    System.out.println("Record valido!");
                    HBox record = new HBox();
                    Text t1 = new Text(field1.getText());
                    Text t2 = new Text(field2.getText());
                    Text t3 = new Text(field3.getText());
                    record.setAlignment(Pos.TOP_LEFT);
                    record.setSpacing(2);
                    record.getChildren().addAll(t1,t2,t3);
                    main.listaAutomobili.testi.getChildren().add(record);
                    stage.close();
                }
                else {
                    System.out.println("Record non valido!");
                }
            }
        });
    }

    @Override
    public boolean equivalenti (Record s) {

        for (Record p : main.automobili) {
            if (p.equals(s) && p!=s)
                return false;
        }
        return true;
    }
}
