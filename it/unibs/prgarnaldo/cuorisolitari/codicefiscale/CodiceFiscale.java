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
     * Questo metodo ha una stringa in ingresso e restituisce vero nel caso il codice fiscale sia valido, falso se non lo è
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
