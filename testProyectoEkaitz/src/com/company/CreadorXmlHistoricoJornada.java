package com.company;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

public class CreadorXmlHistoricoJornada {

    private ArrayList<Jornada> jornadaArrayList = new ArrayList<Jornada>();

    public CreadorXmlHistoricoJornada(ArrayList<Jornada> jornadaArrayList) throws ParserConfigurationException, TransformerException {
        this.jornadaArrayList = jornadaArrayList;


        // creo instancia para construir el parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Jornadas", null);
        document.setXmlVersion("1.0");

        //Creo el nodo raiz del documento xml
        Element raiz = document.getDocumentElement(); //nodo jornada


        for (Jornada jornada : this.jornadaArrayList
        ) {


            // Creo los items Jornada y sus atributos
            Element itemElemento = document.createElement("Jornada");
            itemElemento.setAttribute("fecha", jornada.getFecha());

            // Creo el elemento Boxeador 1
            Element elem1 = document.createElement("Boxeador1");
            Text text1 = document.createTextNode(jornada.getBoxeador1()); //damos valor
            elem1.appendChild(text1);

            // Creo el elemento boxeador 2
            Element elem2 = document.createElement("Boxeador2");
            Text text2 = document.createTextNode(jornada.getGetBoxeador2());
            elem2.appendChild(text2);

            // Creo el elemento puntos boxeador 1
            Element elem3 = document.createElement("PuntosBoxeador1");
            Text text3 = document.createTextNode(Integer.toString(jornada.getPuntosBox1()));
            elem3.appendChild(text3);

            // Creo el elemento puntos boxeador 2
            Element elem4 = document.createElement("PuntosBoxeador2");
            Text text4 = document.createTextNode(Integer.toString(jornada.getPuntosBox2()));
            elem4.appendChild(text4);

            // Añado los hijos al elemeto padre item
            itemElemento.appendChild(elem1);
            itemElemento.appendChild(elem2);
            itemElemento.appendChild(elem3);
            itemElemento.appendChild(elem4);

            // añado a la raiz del documento el elemento item con sus correspondientes hijos
            raiz.appendChild(itemElemento);


        }
        //Se crea la fuente XML a partir del documento
        Source source = new DOMSource(document);

        //Se crea el resultado en el fichero Empleados.xml
        Result result = new StreamResult(new java.io.File("jornadas.xml"));

        //Se obtiene un TransformerFactory
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        //Se realiza la transformación de documento a fichero
        transformer.transform(source, result);


    }
}
