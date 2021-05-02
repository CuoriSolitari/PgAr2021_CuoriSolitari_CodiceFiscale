package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;

public class CodiceFiscale {

    private Persona persona;
    private char car_ctrl;
    private String codice_fiscale;

    /**
     * Questo metodo genera una stringa che è il codice fiscale corretto dei dati della personaa
     *
     * @param persona
     * @return
     */

    public static String generaCF(Persona persona) {

        String codice_fiscale = "";

        //GETTER dei 3 caratteri relativi al cognome

        //Si cercano 3 consonanti
        for ( int i = 0; i < persona.getCognome().length(); i++ ) {
            if ( controllaConsonante(persona.getCognome().charAt(i)) == true ) {
                if (codice_fiscale.length() < 3)
                    codice_fiscale += persona.getCognome().charAt(i);
                else i = persona.getCognome().length();
            }
        }

        //Si passa alle vocali in caso di consonanti minori di 3
        if ( codice_fiscale.length() < 3) {
            for ( int i = 0; i < persona.getCognome().length(); i++) {
                if ( controllaConsonante(persona.getCognome().charAt(i)) == false)
                    codice_fiscale += persona.getCognome().charAt(i);
                if ( codice_fiscale.length() == 3)
                    i = persona.getCognome().length();
            }
            //In caso di cognome di meno di 3 lettere si aggiunge un numero di X sufficienti
            while ( codice_fiscale.length() < 3)
                codice_fiscale += 'X';
        }

        //GETTER dei 3 caratteri relativi al nome

        //Si cercano 3 consonanti
        for ( int i = 0; i < persona.getNome().length(); i++ ) {
            if ( controllaConsonante(persona.getNome().charAt(i)) == true ) {
                if (codice_fiscale.length() < 6)
                    codice_fiscale += persona.getNome().charAt(i);
                else i = persona.getNome().length();
            }
        }

        //Si passa alle vocali in caso di consonanti minori di 3
        if ( codice_fiscale.length() < 6) {
            for ( int i = 0; i < persona.getNome().length(); i++) {
                if ( controllaConsonante(persona.getNome().charAt(i)) == false)
                    codice_fiscale += persona.getNome().charAt(i);
                if ( codice_fiscale.length() == 6)
                    i = persona.getNome().length();
            }
            //In caso di cognome di meno di 3 lettere si aggiunge un numero di X sufficienti
            while ( codice_fiscale.length() < 6)
                codice_fiscale += 'X';
        }

        //GETTER dei 5 caratteri relativi al giorno di nascita


        //Carattere relativo all'anno
        String anno = String.valueOf(persona.getData().getAnno());
        String year = String.valueOf(anno.charAt(2)) + anno.charAt(3);
        codice_fiscale += year;

        //Carattere relativo al mese
        codice_fiscale += persona.getData().getCarattere_mese();

        //Carattere relativo al giorno
        if (persona.isSesso() == true ) {
            String giorno = String.valueOf(persona.getData().getGiorno());
            codice_fiscale += persona.getData().getGiorno();
        }
        else {
            int day = persona.getData().getGiorno() + 40;
            String giorno = String.valueOf(day);
            codice_fiscale += giorno;
        }

        //GETTER dei 4 caratteri relativi al comune di nascita
        codice_fiscale += CaratteriLuogo(persona.getLuogo());

        //GETTER del carattere di controllo
        codice_fiscale = codice_fiscale.toUpperCase();
        codice_fiscale += carattereControllo(codice_fiscale);

        return codice_fiscale;
    }

    /**
     * Questo metodo ha una stringa in ingresso e restituisce vero nel caso il codice fiscale sia valido, falso se non lo è,
     * consiste in un ciclo che controlla la vlidità di ogni carattere della stringa
     *
     * @param codice
     * @return
     */
    public static boolean verificaCF(String codice){

        //Se la stringa contine meno di 16 caratteri si ferma subito perchè non può essere un codice fiscale
        if (16 != codice.length()){
            return false;
        }
        //Ciclo for che controlla carattere per carattere la stringa codice fiscale
        for(int i=0; i<16; i++){
            //Controlla tutti le posizioni dei caratteri
            if(i>=0 && i<=5 || i==8 || i==11 || i==15){
                //Se non è un carattere maiuscolo secondo la tabella ASCII restituisce falso
                if(codice.charAt(i)<65 || codice.charAt(i)>90)
                    return false;
            }
            //Controlla tutti le posizioni dei numeri
            else{
                //Se non è un numero secondo la tabella ASCII restituisce falso
                if(codice.charAt(i)<48 || codice.charAt(i)>57)
                    return false;
            }
        }
        return true;
    }

    public static boolean controllaConsonante(char lettera) {
        if ( lettera != 'A' && lettera != 'E' && lettera != 'I' && lettera != 'O' && lettera != 'U' && lettera != 'a' && lettera != 'e' && lettera != 'i' && lettera != 'o' && lettera != 'u') {
            return true;
        }
        else return false;
    }

    /**
     * Questo codice si occupa di generare il carattere di controllo di un codice fiscale
     *
     * @param codice
     * @return
     */
    public static String carattereControllo(String codice) {

        int somma = 0;
        int[] array_dispari = new int[]{1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23};

        for ( int i = 0; i < codice.length(); i++ ) {
            //Per le posizioni dispari
            if ( i % 2 == 0 ) {
                //Se il carattere è un numero n alla somma si aggiunge array_dispari[n]. L'ASCII di 0 (zero) è 48
                if ( (int) codice.charAt(i) - 65 < 0)
                    somma += array_dispari[(int) codice.charAt(i) - 48];
                else
                    somma += array_dispari[(int) codice.charAt(i) - 65];
            }
            //Per le posizioni pari
            else {
                //Se il carattere è un numero n alla somma si aggiunge tale numero n. L'ASCII di 0 (zero) è 48
                if ( (int) codice.charAt(i) - 65 < 0)
                    somma += (int) codice.charAt(i) - 48;
                else
                    somma += (int) codice.charAt(i) - 65;
            }
        }
        //il carattere di controllo avrà come codice ASCII il codice della A + il resto di somma/26
        int ascii = 65 + (somma % 26);
        String carattere_controllo = Character.toString(ascii);

        return carattere_controllo;
    }

    public static String CaratteriLuogo(String luogo_persona) {

        File file = new File("it/unibs/prgarnaldo/cuorisolitari/codicefiscale/comuni.xml");
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String codice = "";

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
                            if ( luogo_persona == xmlr.getText() ) {
                                xmlr.next();
                                xmlr.next();
                                xmlr.next();
                                codice = xmlr.getText();
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
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

        return codice;
    }
}