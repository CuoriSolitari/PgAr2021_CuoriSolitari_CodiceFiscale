package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

import UniBSFpLib.src.it.unibs.fp.mylib.InputDati;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainClass {

    public static final String MSG_INFO = "\nEcco di comandi disponibili per questo programma:\n1- Stampa inputPersone.xml\n2- Stampa codiciFiscali.xml\n3- genera  codiciPersone.xml\n4- Esci";

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        ArrayList<Persona> persone = Xml.ReadPersone();
        ArrayList<String> codici_fiscali = Xml.readCF();
        int comando = 0;

        do{
            System.out.println(MSG_INFO);
            comando = InputDati.leggiIntero("Inserire un comando: ", 1, 4);

            //COMANDO 1: stampa inputPersone.xml
            if(comando == 1){
                for (Persona p: persone){
                    System.out.println(p.toString());
                }
            }
            //COMANDO 2: stampa codiciFiscali.xml
            else if(comando == 2){
                for(String codice: codici_fiscali) {
                    boolean valido;
                    valido = CodiceFiscale.verificaCF(codice);
                    System.out.println(codice + " " + valido);
                }
            }
            //Comando 3: genera l'XML
            else if(comando == 3){
                File file = new File("it/unibs/prgarnaldo/cuorisolitari/codicefiscale/codiciPersone.xml");
                XMLOutputFactory xmlof = null;
                XMLStreamWriter xmlw = null;
                try {
                    xmlw.writeStartElement("Output");
                    xmlw.writeComment("INIZIO LISTA");
                    for (int i = 0; i < persone.size(); i++) {
                        xmlw.writeStartElement("persona");
                        xmlw.writeAttribute("id", Integer.toString(i));
                        xmlw.writeStartElement("nome");
                        xmlw.writeCharacters(persone.get(i).getNome());
                        xmlw.writeEndElement();
                        xmlw.writeStartElement("cognome");
                        xmlw.writeCharacters(persone.get(i).getCognome());
                        xmlw.writeEndElement();
                        xmlw.writeStartElement("sesso");
                        if (persone.get(i).isSesso())
                            xmlw.writeCharacters("M");
                        else xmlw.writeCharacters("F");
                        xmlw.writeEndElement();
                        xmlw.writeStartElement("luogo");
                        xmlw.writeCharacters(persone.get(i).getLuogo());
                        xmlw.writeEndElement();
                        xmlw.writeStartElement("data");
                        xmlw.writeCharacters(persone.get(i).getData().toString());
                        xmlw.writeEndElement();

                        xmlw.writeEndElement();
                    }
                    xmlw.writeEndElement();
                    xmlw.writeEndDocument();
                    xmlw.flush();
                    xmlw.close();
                } catch (Exception e) {
                    System.out.println("Errore nella scrittura");
                }
            }

        } while(comando != 4);

    }
}