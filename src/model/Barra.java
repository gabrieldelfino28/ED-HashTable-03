package model;

public class Barra {

    public String nome;
    public int volume;
    public int peso;

    public Barra(String nome, int volume, int peso) {
        this.nome = nome;
        this.volume = volume;
        this.peso = peso;
    }

    public Barra() {
        super();
    }

    @Override
    public String toString() {
        return nome + ";volume=" + volume + ";peso=" + peso;
    }
}
