package com.company;

import java.io.Serializable;

public class Jornada  {

    private String boxeador1;
    private String getBoxeador2;
    private String fecha;
    private int puntosBox1;
    private int puntosBox2;

    public Jornada(String boxeador1, String getBoxeador2, String fecha, int puntosBox1, int puntosBox2) {
        this.boxeador1 = boxeador1;
        this.getBoxeador2 = getBoxeador2;
        this.fecha = fecha;
        this.puntosBox1 = puntosBox1;
        this.puntosBox2 = puntosBox2;
    }


    public String getBoxeador1() {
        return boxeador1;
    }

    public void setBoxeador1(String boxeador1) {
        this.boxeador1 = boxeador1;
    }

    public String getGetBoxeador2() {
        return getBoxeador2;
    }

    public void setGetBoxeador2(String getBoxeador2) {
        this.getBoxeador2 = getBoxeador2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPuntosBox1() {
        return puntosBox1;
    }

    public void setPuntosBox1(int puntosBox1) {
        this.puntosBox1 = puntosBox1;
    }

    public int getPuntosBox2() {
        return puntosBox2;
    }

    public void setPuntosBox2(int puntosBox2) {
        this.puntosBox2 = puntosBox2;
    }
}
