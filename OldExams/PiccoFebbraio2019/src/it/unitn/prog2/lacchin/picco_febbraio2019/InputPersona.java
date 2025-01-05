package it.unitn.prog2.lacchin.picco_febbraio2019;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class InputPersona extends Input{

    public InputPersona (Catalogo main) {
        super(main);
        tx1.setText("Nome");
        tx2.setText("Cognome");
        tx3.setText("Anno di nascita");


        controlla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean corretto = true;
                int n;
                Persona persona = null;

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
                    persona = new Persona(field1.getText(),field2.getText(),Integer.valueOf(field3.getText()));
                    if(main.persone.size() > 0) {
                        corretto = equivalenti(persona);

                    }
                }
                if (corretto) {
                    main.persone.add(persona);
                    System.out.println("Record valido!");
                    HBox record = new HBox();
                    Text t1 = new Text(field1.getText());
                    Text t2 = new Text(field2.getText());
                    Text t3 = new Text(field3.getText());
                    record.setAlignment(Pos.TOP_LEFT);
                    record.setSpacing(2);
                    record.getChildren().addAll(t1,t2,t3);
                    main.listaPersone.testi.getChildren().add(record);
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

        for (Record p : main.persone) {
            if (((Persona) p).equals(s) && p!=s)
                return false;

        }
        return true;
    }
}
