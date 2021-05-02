package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
*/
public class MainClass {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        String prova = "FRMPLA01D26D434N";

        int day;
        day = 30;
        int year;
        year = 2020;
        int month;
        month = 3;


        boolean b = Data.VerificaData(day,month,year);
        if ( b == false )
            System.out.println("data non valida");
        else
            System.out.println("data corretta");
        if ( month==2 && day > 29 )
            System.out.println("il mese di febbraio ha al massimo 29 giorni");


        boolean a = CodiceFiscale.verificaCF(prova);
        if (a==false) System.out.println("ciao");
        else System.out.println("bella");

         Xlm lettura= Xlm.Readfile();

        Data data = new Data( day, month, year);
        System.out.println(data.getCarattere_mese());
    }
}