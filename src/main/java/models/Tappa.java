package models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Tappa {

    @SerializedName("nome")
    private final String nome;
    private final Tipo tipo;

    public Tappa(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public enum Tipo {
        LUOGO("Luogo"),
        CITTA("Città");

        private final String tipo;

        public String getTipo() {
            return tipo;
        }

        public static Tipo fromString(String tipo) {
            for (Tipo t : Tipo.values()) {
                if (Objects.equals(t.getTipo(), tipo))
                    return t;
            }

            return null;
        }

        Tipo(String tipo) {
            this.tipo = tipo;
        }
    }
}
