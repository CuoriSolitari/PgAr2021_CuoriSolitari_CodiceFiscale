package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        ArrayList<Persona> persone = Xml.ReadPersone();


        for (Persona p: persone){
            System.out.println(p.toString());
        }

        System.out.println(CodiceFiscale.generaCF(persone.get(0)));
    }
}