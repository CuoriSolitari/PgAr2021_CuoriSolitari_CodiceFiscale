package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

public class CodiceFiscale {

    private String nome;
    private String cognome;
    private char sesso;
    private Data data;
    private String luogo;
    private char car_ctrl;
    private String codice_fiscale;


    public CodiceFiscale(String nome, String cognome, char sesso, Data data, String luogo, char car_ctrl) {

    }

    /**
     * Questo metodo ha una stringa in ingresso e restituisce vero nel caso il codice fiscale sia valido, falso se non  lo è
     *
     * @param codice_fiscale
     * @return
     */
    public static boolean verificaCF(String codice_fiscale){

        //Se la stringa contine meno di 16 caratteri si ferma subito perchè non può essere un codice fiscale
        if (16 != codice_fiscale.length()){
            return false;
        }

        return true;
    }
}
