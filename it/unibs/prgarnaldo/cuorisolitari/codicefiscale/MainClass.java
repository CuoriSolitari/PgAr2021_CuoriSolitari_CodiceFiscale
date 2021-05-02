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

        for ( int i = 0; i < persone.size(); i++ )
            System.out.println(CodiceFiscale.generaCF(persone.get(i)));
    }
}