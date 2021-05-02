package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Xml {

    public static void  Readfile() {

        File file = new File("it/unibs/prgarnaldo/cuorisolitari/codicefiscale/inputPersone.xml");
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(String.valueOf(file), new FileInputStream(file));
            while (xmlr.hasNext()){

                switch (xmlr.getEventType()){

                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start Read Doc " + file);
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Tag " + xmlr.getLocalName());
                        for (int i = 0; i < xmlr.getAttributeCount(); i++)
                            System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("END-Tag " + xmlr.getLocalName());
                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("// commento " + xmlr.getText());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (xmlr.getText().trim().length() > 0)
                            System.out.println("-> " + xmlr.getText());
                        break;

                }
                xmlr.next();
            }
            xmlr.close();
        }

        catch (FileNotFoundException | XMLStreamException e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }


    }

}





