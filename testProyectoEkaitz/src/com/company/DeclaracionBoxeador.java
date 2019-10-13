package com.company;

import java.io.*;

public class DeclaracionBoxeador implements Serializable {

    private String nombreBoxeador;
    private String declaracionBoxeador;

    public DeclaracionBoxeador(String nombreBoxeador, String declaracionBoxeador) {
        this.nombreBoxeador = nombreBoxeador;
        this.declaracionBoxeador = declaracionBoxeador;
    }

    public String getNombreBoxeador() {
        return nombreBoxeador;
    }

    public void setNombreBoxeador(String nombreBoxeador) {
        this.nombreBoxeador = nombreBoxeador;
    }

    public String getDeclaracionBoxeador() {
        return declaracionBoxeador;
    }

    public void setDeclaracionBoxeador(String declaracionBoxeador) {
        this.declaracionBoxeador = declaracionBoxeador;
    }

    public void EscribirDeclaracionBoxeadorSerializable(DeclaracionBoxeador declaracionBoxeador) throws IOException {

        // declaro el fichero
        File fichero = new File("/declaracionboxeador.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(fichero);

        // conecto el flujo de bytes al flujo de datos
        ObjectOutputStream dataOS = new ObjectOutputStream(fileOutputStream);

        // escribo la declaracion en el fichero
        dataOS.writeObject(declaracionBoxeador);

        // cierro el stream de la salida
        dataOS.close();


    }
}
