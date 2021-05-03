package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

import UniBSFpLib.src.it.unibs.fp.mylib.InputDati;

import javax.xml.stream.XMLStreamException;
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

        } while(comando != 4);

    }
}