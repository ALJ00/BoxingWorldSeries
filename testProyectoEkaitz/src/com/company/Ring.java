package com.company;

public class Ring {

    private int golpes;
    private String texto;

    public Ring() {
        golpes = 0;
    }

    public int getGolpes() {
        return golpes;
    }

    public synchronized void pegar(Boxeador boxeador) {

        boxeador.pegar();
        golpes++;

        this.texto = "Pegada de " + boxeador.getNombre() + " (" + boxeador.getGolpes() + ")";

        System.out.println("Pegada de " + boxeador.getNombre() + " (" + boxeador.getGolpes() + ")");

    }

    public String getTexto() {
        return texto;
    }
}
