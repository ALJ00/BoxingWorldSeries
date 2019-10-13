package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LeerXml {

    private ArrayList<Jornada> list = new ArrayList<Jornada>();

    public LeerXml() throws ParserConfigurationException, IOException, SAXException {

        // funcion para acceder a los datos del xml
        File archivo = new File("jornadas.xml");

        // creo el builder
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();

        // parseo el archivo
        Document document = documentBuilder.parse(archivo);
        document.getDocumentElement().normalize();

        //System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());

        // creo el nodo del tag raiz Jornada
        NodeList listaJornadas = document.getElementsByTagName("Jornada");
        for (int temp = 0; temp < listaJornadas.getLength(); temp++) {
            Node nodo = listaJornadas.item(temp);
            //System.out.println("Elemento:" + nodo.getNodeName());
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodo;

                //System.out.println("Fecha: " + element.getAttribute("fecha"));
                //System.out.println("Boxeador1: " + element.getElementsByTagName("Boxeador1").item(0).getTextContent());
                //System.out.println("Boxeador2: " + element.getElementsByTagName("Boxeador2").item(0).getTextContent());
                //System.out.println("PuntosBoxeador1: " + element.getElementsByTagName("PuntosBoxeador1").item(0).getTextContent());
                //System.out.println("PuntosBoxeador2: " + element.getElementsByTagName("PuntosBoxeador2").item(0).getTextContent());
                //System.out.println("password: " + element.getElementsByTagName("321423").item(0).getTextContent());

                String nombre1 = element.getElementsByTagName("Boxeador1").item(0).getTextContent();
                String nombre2 = element.getElementsByTagName("Boxeador2").item(0).getTextContent();
                String fecha = element.getAttribute("fecha");
                String puntBox1 = element.getElementsByTagName("PuntosBoxeador1").item(0).getTextContent();
                String puntBox2 = element.getElementsByTagName("PuntosBoxeador2").item(0).getTextContent();


                Jornada jornada = new Jornada(nombre1, nombre2, fecha, Integer.parseInt(puntBox1),Integer.parseInt(puntBox2));


                this.list.add(jornada);

            }
        }


    }

    public ArrayList<Jornada> getList() {
        return list;
    }
}
