package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class  Xml {

    public void readPersone(Persona[] array){

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        File file = new File("inputPersone.xml");

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("inputPersone.xml", new FileInputStream("inputPersone.xml"));

            while(xmlr.hasNext()){
                switch (xmlr.getEventType()){

                }
                xmlr.next();

            }
        }
        catch (FileNotFoundException | XMLStreamException e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

    }

}





