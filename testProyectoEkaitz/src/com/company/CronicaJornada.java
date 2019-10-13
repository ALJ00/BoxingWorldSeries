package com.company;

import java.io.*;
import java.util.Date;

public class CronicaJornada implements Serializable {

    Date fecha;
    String cronica;
    String nombrePeriodista;

    public CronicaJornada(Date fecha, String cronica, String nombrePeriodista) {
        this.fecha = fecha;
        this.cronica = cronica;
        this.nombrePeriodista = nombrePeriodista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCronica() {
        return cronica;
    }

    public void setCronica(String cronica) {
        this.cronica = cronica;
    }

    public String getNombrePeriodista() {
        return nombrePeriodista;
    }

    public void setNombrePeriodista(String nombrePeriodista) {
        this.nombrePeriodista = nombrePeriodista;
    }

    public void EscribirCronicaSerializable(CronicaJornada cronicaJornada, int n) throws IOException {

        // declaro el fichero
        File fichero = new File("cronicajornada"+n+".dat");
        FileOutputStream fileOutputStream = new FileOutputStream(fichero);

        // conecto el flujo de bytes al flujo de datos
        ObjectOutputStream dataOS = new ObjectOutputStream(fileOutputStream);

        // escribo la cronica en el fichero
        dataOS.writeObject(cronicaJornada);

        // cierro el stream de la salida
        dataOS.close();


    }


}
