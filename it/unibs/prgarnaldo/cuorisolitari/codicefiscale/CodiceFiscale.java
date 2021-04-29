package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

public class CodiceFiscale {

    private String nome;
    private String cognome;
    private boolean sesso;
    private Data data;
    private String luogo;
    private char car_ctrl;
    private String codice_fiscale;


    public String generaCF(String nome, String cognome, char sesso, Data data, String luogo, char carCtrl) {

        String codice_fiscale = null;

        //GETTER dei 3 caratteri relativi al cognome
        for ( int i = 0; i < cognome.length(); i++ ) {
            //Si cercano 3 consonanti
            if ((int) cognome.charAt(i) != 65 && (int) cognome.charAt(i) != 69 && (int) cognome.charAt(i) != 73 && (int) cognome.charAt(i) != 79 && (int) cognome.charAt(i) != 85 && (int) cognome.charAt(i) != 97 && (int) cognome.charAt(i) != 101 && (int) cognome.charAt(i) != 105 && (int) cognome.charAt(i) != 111 && (int) cognome.charAt(i) != 117) {
                if (codice_fiscale.length() < 3)
                    codice_fiscale += cognome.charAt(i);
                else i = cognome.length();
            }
        }
        //Si passa alle vocali in caso di consonanti minori di 3
        if ( codice_fiscale.length() < 3) {
            for ( int i = 0; i < cognome.length(); i++) {
                if ((int) cognome.charAt(i) == 65 || (int) cognome.charAt(i) == 69 || (int) cognome.charAt(i) == 73 || (int) cognome.charAt(i) == 79 || (int) cognome.charAt(i) == 85 || (int) cognome.charAt(i) == 97 || (int) cognome.charAt(i) == 101 || (int) cognome.charAt(i) == 105 || (int) cognome.charAt(i) == 111 || (int) cognome.charAt(i) == 117)
                    codice_fiscale += cognome.charAt(i);
            }
            //In caso di cognome di meno di 3 lettere si aggiunge un numero di X sufficienti
            while ( codice_fiscale.length() < 3)
                codice_fiscale += 'X';
        }

        //GETTER dei 3 caratteri relativi al nome
        for ( int i = 0; i < nome.length(); i++ ) {
            //Si cercano 3 consonanti
            if ((int) nome.charAt(i) != 65 && (int) nome.charAt(i) != 69 && (int) nome.charAt(i) != 73 && (int) nome.charAt(i) != 79 && (int) nome.charAt(i) != 85 && (int) nome.charAt(i) != 97 && (int) nome.charAt(i) != 101 && (int) nome.charAt(i) != 105 && (int) nome.charAt(i) != 111 && (int) nome.charAt(i) != 117) {
                if (codice_fiscale.length() < 6)
                    codice_fiscale += nome.charAt(i);
                else i = nome.length();
            }
        }
        //Si passa alle vocali in caso di consonanti minori di 3
        if ( codice_fiscale.length() < 6) {
            for ( int i = 0; i < nome.length(); i++) {
                if ((int) nome.charAt(i) == 65 || (int) nome.charAt(i) == 69 || (int) nome.charAt(i) == 73 || (int) nome.charAt(i) == 79 || (int) nome.charAt(i) == 85 || (int) nome.charAt(i) == 97 || (int) nome.charAt(i) == 101 || (int) nome.charAt(i) == 105 || (int) nome.charAt(i) == 111 || (int) nome.charAt(i) == 117)
                    codice_fiscale += nome.charAt(i);
            }
            //In caso di cognome di meno di 3 lettere si aggiunge un numero di X sufficienti
            while ( codice_fiscale.length() < 6)
                codice_fiscale += 'X';
        }

        //GETTER dei 5 caratteri relativi al giorno di nascita
        //Carattere relativo all'anno
        //codice_fiscale += data.getAnno().toString();
        //Carattere relativo al mese
        codice_fiscale += data.getMese();
        //Carattere relativo al giorno
        //if ( sesso == true )
            codice_fiscale += data.getGiorno();
        //else
        //    codice_fiscale += (data.getGiorno() + 40).toString();

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
}
