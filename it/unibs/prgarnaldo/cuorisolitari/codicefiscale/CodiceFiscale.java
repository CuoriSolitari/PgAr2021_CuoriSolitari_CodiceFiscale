package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

import java.util.Locale;

public class CodiceFiscale {

    private String nome;
    private String cognome;
    private boolean sesso;
    private Data data;
    private String luogo;
    private char car_ctrl;
    private String codice_fiscale;


    /**
     * Questo metodo genera una stringa che è il codice fiscale corretto dei dati della personaa
     *
     * @param nome
     * @param cognome
     * @param sesso
     * @param data
     * @param luogo
     * @param carCtrl
     * @return
     */

    public String generaCF(String nome, String cognome, boolean sesso, Data data, String luogo, char carCtrl) {

        String codice_fiscale = null;

        //GETTER dei 3 caratteri relativi al cognome

        //Si cercano 3 consonanti
        for ( int i = 0; i < cognome.length(); i++ ) {
            if ( controllaConsonante(cognome.charAt(i)) == true ) {
                if (codice_fiscale.length() < 3)
                    codice_fiscale += cognome.charAt(i);
                else i = cognome.length();
            }
        }

        //Si passa alle vocali in caso di consonanti minori di 3
        if ( codice_fiscale.length() < 3) {
            for ( int i = 0; i < cognome.length(); i++) {
                if ( controllaConsonante(cognome.charAt(i)) == false)
                    codice_fiscale += cognome.charAt(i);
                if ( codice_fiscale.length() == 3)
                    i = cognome.length();
            }
            //In caso di cognome di meno di 3 lettere si aggiunge un numero di X sufficienti
            while ( codice_fiscale.length() < 3)
                codice_fiscale += 'X';
        }

        //GETTER dei 3 caratteri relativi al cognome

        //Si cercano 3 consonanti
        for ( int i = 0; i < cognome.length(); i++ ) {
            if ( controllaConsonante(cognome.charAt(i)) == true ) {
                if (codice_fiscale.length() < 3)
                    codice_fiscale += cognome.charAt(i);
                else i = cognome.length();
            }
        }

        //Si passa alle vocali in caso di consonanti minori di 3
        if ( codice_fiscale.length() < 3) {
            for ( int i = 0; i < cognome.length(); i++) {
                if ( controllaConsonante(cognome.charAt(i)) == false)
                    codice_fiscale += cognome.charAt(i);
                if ( codice_fiscale.length() == 3)
                    i = cognome.length();
            }
            //In caso di cognome di meno di 3 lettere si aggiunge un numero di X sufficienti
            while ( codice_fiscale.length() < 3)
                codice_fiscale += 'X';
        }

        //GETTER dei 5 caratteri relativi al giorno di nascita

        //Carattere relativo all'anno
        String anno = String.valueOf(data.getAnno());
        codice_fiscale += anno.charAt(2) + anno.charAt(3);

        //Carattere relativo al mese
        codice_fiscale += data.getCarattere_mese();

        //Carattere relativo al giorno
        if ( sesso == true ) {
            String giorno = String.valueOf(data.getGiorno());
            codice_fiscale += data.getGiorno();
        }
        else {
            int day = data.getGiorno() + 40;
            String giorno = String.valueOf(day);
            codice_fiscale += giorno;
        }

        //GETTER dei 4 caratteri relativi al comune di nascita
        //lo faccio dopo

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

    public boolean controllaConsonante(char lettera) {
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
    public String carattereControllo(String codice) {

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
        int ascii = 65 + somma % 26;
        String carattere_controllo = Integer.toString(ascii);

        return carattere_controllo;
    }
}