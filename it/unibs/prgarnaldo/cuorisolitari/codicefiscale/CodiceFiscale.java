package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

public class CodiceFiscale {

    private String nome;
    private String cognome;
    private char sesso;
    private Data data;
    private String luogo;
    private char carCtrl;
    private String codice_fiscale;
    private boolean valido=false;

    public CodiceFiscale(String nome, String cognome, char sesso, Data data, String luogo, char carCtrl) {

    }

    public boolean verificaCF(String codiceFiscale){

        return valido;
    }
}
