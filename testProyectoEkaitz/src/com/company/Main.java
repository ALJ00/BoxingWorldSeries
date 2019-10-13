package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


public class Main {

    //funcion principal de la aplicación
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        //variables de control
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Jornada> jornadaArrayList = new ArrayList<Jornada>();

        // variables para dar color al texto por consola
        String green = "\033[32m";
        String yellow = "\033[33m";
        String blue = "\033[34m";
        String purple = "\033[35m";
        String cyan = "\033[36m";
        String white = "\033[37m";
        String red = "\033[31m";
        String reset = "\u001B[0m";

        System.out.println(red + "******************** Bienvenido la gran final de las Series Mundiales de Boxeo **********************" + reset);
        System.out.println("");
        dormirPrograma();

        System.out.println(blue + "Retransmitiendo la gran final en directo para Medios Egibide" + reset);
        System.out.println("");
        dormirPrograma();

        System.out.println(blue + "Antes de ver el gran duelo a tres jornadas/combates vamos a ver cómo están las apuestas, " +
                "¿qué dicen los pronósticos?\n " +
                "- Adelante diario Marca ---->" + reset);
        System.out.println("");
        dormirPrograma();

        leerPronosticoMarca(yellow, reset);
        System.out.println("");
        dormirPrograma();

        System.out.println(blue + "Pues bien, esto dice Andrés para en diario Marca, y ¿qué dicen nuestros compañeros de As? \n" +
                "-Adelante diario As ----> " + reset);
        System.out.println("");
        dormirPrograma();

        // muestro por consola el pronostico de As del doc pronosticoAs.txt
        leerPronosticoAs(yellow, reset);
        System.out.println("");
        dormirPrograma();

        System.out.print(blue + "Ya habéis oido, Ane de As a favor también de Tyson, pero, ¿Quién será el campeón de este año 2019?\n" +
                ", saltan al ring los contrincantes, el duelo comienza en ... ");

        // simulacion de cuenta atrás
        for (int i = 3; i > 0; i--) {
            System.out.print(blue + " " + i + " " + reset);
            try {
                Thread.sleep(2000);

            } catch (Exception e) {
                e.getMessage();
            }


        }

        System.out.println("");
        dormirPrograma();

        System.out.println(blue + "Comienza el combate ----------------->>>>>>>>>>" + reset);
        System.out.println("");
        dormirPrograma();

        for (int i = 0; i < 3; i++) {

            Jornada jornada1 = creacionJornada();

            jornadaArrayList.add(jornada1);

            System.out.println("Introduzca la crónica del combate: ");
            String cronica = br.readLine();

            while (cronica.equalsIgnoreCase("")) {

                System.out.println("Error, introduzca alguna crónica: ");
                cronica = br.readLine();
            }

            System.out.println("Introduzca tu nombre: ");
            String nombre = br.readLine();

            while (nombre.equalsIgnoreCase("")) {

                System.out.println("Error, introduzca algun nombre: ");
                nombre = br.readLine();
            }

            Date fecha = new Date();
            fecha.toString();

            CronicaJornada cronicaJornada = new CronicaJornada(fecha, cronica, nombre);
            cronicaJornada.EscribirCronicaSerializable(cronicaJornada, i + 1);

            if (i == 0) {
                dormirPrograma();
                System.out.println(blue + "Gran duelo el que acabamos de ver, pero estó está sin resolver, ¿Quién será el gran vencedor? \n" +
                        " que comience sel segundo combate ------>"+reset);
                dormirPrograma();

            } else if (i == 1) {
                dormirPrograma();
                System.out.println(blue + "Gran segundo combate, \n" +
                        " adelante tercer combate ------>"+reset);
                dormirPrograma();

            } else {

                dormirPrograma();
                System.out.println(blue + "Apasionante lo vivido en esta gran final, INIGUALABLE !!!" + reset);
                dormirPrograma();
            }


        }

        CreadorXmlHistoricoJornada creadorXmlHistoricoJornada = new CreadorXmlHistoricoJornada(jornadaArrayList);

        dormirPrograma();

        System.out.println(blue + "Pues esto es todo queridos espectadores, gran combate el vivido" + reset);
        dormirPrograma();
        System.out.println(red + "******************** Procedemos a cerrar las Series Mundiales de Boxeo **********************" + reset);
        dormirPrograma();
        System.out.println(red + " ---- El post combate, resumen de lo sucedido ----" + reset);
        System.out.println(red+"Procedemos a ver las tablas de los combates"+reset);

        LeerXml leerXml = new LeerXml();
        mostrarTablaCombates(leerXml.getList());
        dormirPrograma();

        System.out.println(red+"Procedemos a ver la crónica del primer combate"+reset);
        leerCronicaJornada(1);
        dormirPrograma();
        System.out.println("");

        System.out.println(red+"Procedemos a ver la crónica del segundo combate"+reset);
        leerCronicaJornada(2);
        dormirPrograma();
        System.out.println("");

        System.out.println(red+"Procedemos a ver la crónica del tercer combate"+reset);
        leerCronicaJornada(3);
        dormirPrograma();
        System.out.println("");


        System.out.println(red + "******************** Gracias compañeros, cerramos central informativa **********************" + reset);

    }

    // función que ralentiza el programa 5 segundos
    private static void dormirPrograma() {
        try {
            Thread.sleep(5000);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    // función para crear una nueva jornada
    private static Jornada creacionJornada() {

        Date fechaJornada = new Date();

        String f = fechaJornada.toString();
        System.out.println(f);

        Ring ring = new Ring();
        Boxeador boxeador1 = new Boxeador("Tyson", ring);
        Boxeador boxeador2 = new Boxeador("Rocky", ring);

        boxeador1.start();
        boxeador2.start();

        try {
            boxeador1.join();
            boxeador2.join();
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }

        System.out.println("Fin del combate");

        if (boxeador1.getGolpes() > boxeador2.getGolpes())
            System.out.println("Ha ganado " + boxeador1.getNombre() + " con un total de " + boxeador1.getGolpes() + " golpes");
        else if (boxeador1.getGolpes() < boxeador2.getGolpes())
            System.out.println("Ha ganado " + boxeador2.getNombre() + " con un total de " + boxeador2.getGolpes() + " golpes");
        else
            System.out.println("Empate");


        return new Jornada(boxeador1.getNombre(), boxeador2.getNombre(), f, boxeador1.getGolpes(),
                boxeador2.getGolpes());


    }

    // funcion para leer un objeto serializable, lee una jornada y lo enseña por pantalla
    private static void leerCronicaJornada(int n) throws IOException {

        //Objeto File
        File fichero = new File("cronicajornada" + n + ".dat");

        //Flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);

        //Conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        try {
            while (true) {
                //Leemos una cronica, pero debemos hacer casting en readObject
                CronicaJornada cronicaJornada = (CronicaJornada) dataIS.readObject();
                //No podemos utilizar println de esta manera, así que utilizamos %n para saltos de línea
                // %s --> String
                // %d --> Int
                System.out.printf("Nombre periodista: %s%nCrónica: %s %nFecha: %tD", cronicaJornada.getNombrePeriodista(),
                        cronicaJornada.getCronica(), cronicaJornada.getFecha());
            }
        } catch (EOFException | ClassNotFoundException eo) {
            //System.out.println("Fin de lectura");
        }
        dataIS.close(); //Cerramos el flujo de entrada
    }

    //funcion que lee los datos del fichero pronosticoMarca.txt
    private static void leerPronosticoMarca(String color1, String color2) throws IOException {

        File fichero = new File("pronosticoMarca.txt");//declaro fichero

        FileReader fic = new FileReader(fichero); //creo el flujo de entrada
        int i;

        while ((i = fic.read()) != -1) //se va leyendo un caracter

            System.out.print(color1 + (char) i + color2);

        fic.close(); //cierro fichero


    }

    // funcion que lee datos del fichero pronosticoAs.txt.txt utilizando Buffered reader
    private static void leerPronosticoAs(String color1, String color2) {

        try {
            FileReader fr = new FileReader("pronosticoAs.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null)
                System.out.println(color1 + linea + color2);
            br.close();
        } catch (FileNotFoundException fn) {
            fn.getMessage();
            System.out.println("Error de lectura");
        } catch (IOException io) {
            System.out.println("Error de E/S");
        }


    }

    // funcion para crerar la interfaz de la tabla
    private static void mostrarTablaCombates(ArrayList<Jornada> jornadas) {

        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);

        //creo 3 columnas con sus etiquetas
        //estas son las columnas del JTable
        modelo.addColumn("Boxeador 1");
        modelo.addColumn("Boxeador 2");
        modelo.addColumn("Fecha");
        modelo.addColumn("Puntos Boxeador 1");
        modelo.addColumn("Puntos Boxeador 2");


        for (Jornada j : jornadas
        ) {

            Object[] datos = new Object[5];//Crea un vector
            //para almacenar los valores del ResultSet
            datos[0] = j.getBoxeador1();
            datos[1] = j.getGetBoxeador2();
            datos[2] = j.getFecha();
            datos[3] = j.getPuntosBox1();
            datos[4] = j.getPuntosBox2();



            //añado el modelo a la tabla
            modelo.addRow(datos);

            //System.out.print("hola"+act.getNombre().toString());

        }


        //datos=null;//limpia los datos de el vector de la memoria


        JFrame f = new JFrame();
        f.setBounds(10, 10, 300, 200);
        f.getContentPane().add(new JScrollPane(tabla));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


}



