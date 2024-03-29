package com.company;

import java.util.Random;

public class Boxeador extends Thread{

    private String nombre;
    private Ring ring;
    private int golpes;

    public Boxeador(String nombre, Ring ring) {

        this.nombre = nombre;
        this.ring = ring;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGolpes() {
        return golpes;
    }

    public void pegar() {
        golpes++;
    }

    @Override
    public void run() {

        while (ring.getGolpes() < 100) {

            ring.pegar(this);
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException ie) {}
        }
    }



}
