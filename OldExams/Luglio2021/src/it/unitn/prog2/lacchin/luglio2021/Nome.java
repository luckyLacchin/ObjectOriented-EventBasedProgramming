package it.unitn.prog2.lacchin.luglio2021;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Objects;

import static javafx.scene.text.Font.font;

public class Nome extends Text {

    String nome;
    public Nome () {
        super();
        this.setFont(font("Arial",30));
        this.setFill(Color.RED);
    }
    public Nome (String nome) {
        super();
        this.setFont(font("Arial",30));
        this.setFill(Color.RED);
        this.setText(nome);
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nome nome1 = (Nome) o;
        return Objects.equals(nome, nome1.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public String getNome() {
        return nome;
    }
}
