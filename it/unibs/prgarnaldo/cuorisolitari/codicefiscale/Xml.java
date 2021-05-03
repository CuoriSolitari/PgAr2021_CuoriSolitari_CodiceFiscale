package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Xml {

    /**
     * Legge il file inputPersone.xml e aggiunge tutti i dati in un array di persone
     *
     * @return persone
     */
    public static ArrayList<Persona> ReadPersone() {

        ArrayList<Persona> persone = new ArrayList<>();
        File file = new File("it/unibs/prgarnaldo/cuorisolitari/codicefiscale/inputPersone.xml");
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String nome_persona = null;
        String cognome_persona = null;
        String sesso_persona = null;
        Data data_persona= null;
        String luogo_persona = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(String.valueOf(file), new FileInputStream(file));
            while (xmlr.hasNext()){

                switch (xmlr.getEventType()){

                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        if ((xmlr.getLocalName()) == "nome") {
                            xmlr.next();
                            nome_persona = xmlr.getText();
                        } else if ((xmlr.getLocalName()) == "cognome") {
                            xmlr.next();
                            cognome_persona = xmlr.getText();
                        } else if (xmlr.getLocalName() == "sesso") {
                            xmlr.next();
                            sesso_persona = xmlr.getText();
                        } else if ((xmlr.getLocalName()) == "data_nascita") {
                            xmlr.next();
                            String data = xmlr.getText();
                            //Esclude il carattere - e crea una data da una stringa a interi
                            String[] splitArray = data.split("-");
                            int anno = Integer.parseInt(splitArray[0]);
                            int mese = Integer.parseInt(splitArray[1]);
                            int giorno = Integer.parseInt(splitArray[2]);
                            data_persona = new Data(giorno, mese, anno);
                        } else if ((xmlr.getLocalName()) == "comune_nascita") {
                            xmlr.next();
                            luogo_persona = xmlr.getText();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if ((xmlr.getLocalName()) == "persona")
                        {
                            Persona persona = new Persona(nome_persona, cognome_persona, sesso_persona, data_persona, luogo_persona);
                            persone.add(persona);
                        }

                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("// commento " + xmlr.getText());
                        break;
                    case XMLStreamConstants.CHARACTERS:
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

        return persone;
    }

    /**
     * Legge il file codiciFiscali.xml e aggiunge tutti i dati in un array di stringhe
     *
     * @return arrayCF
     */
    public static ArrayList<String> readCF() {

        ArrayList<String> arrayCF = new ArrayList<>();

        File file = new File("it/unibs/prgarnaldo/cuorisolitari/codicefiscale/codiciFiscali.xml");
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String codice = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(String.valueOf(file), new FileInputStream(file));
            while (xmlr.hasNext()){

                switch (xmlr.getEventType()){

                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        if ((xmlr.getLocalName()) == "codice") {
                            xmlr.next();
                            codice = xmlr.getText();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if ((xmlr.getLocalName()) == "codice"){
                            arrayCF.add(codice);
                        }

                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("// commento " + xmlr.getText());
                        break;
                    case XMLStreamConstants.CHARACTERS:
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


        return arrayCF;
    }

}

