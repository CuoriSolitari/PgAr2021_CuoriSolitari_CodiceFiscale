package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

public class Data {

    private int giorno;
    private int mese;
    private int anno;
    private char carattere_mese;

    public Data(int _giorno, int _mese, int _anno) {
        this.giorno = _giorno;
        this.mese = _mese;
        this.anno = _anno;
        this.carattere_mese = carattereMese(_mese);
    }

    public static char carattereMese (int mese) {
        char [] array_mesi = new char[]{'A', 'B', 'C', 'D', 'E', 'H', 'L', 'M', 'P', 'R', 'S', 'T'};
        return array_mesi[mese - 1];
    }

    public static boolean verificaData (int giorno, int mese){
        if (mese == 2){
            if(giorno < 28)
                return false;
        }
        else if (mese == 4 || mese == 6 || mese == 11 || mese == 9){
            if(giorno < 30)
                return false;
        } else {
            if(giorno < 31)
                return false;
        }
        return true;
    }

    public int getGiorno() {
        return giorno;
    }

    public int getMese() {
        return mese;
    }

    public int getAnno() {
        return anno;
    }

    public char getCarattere_mese() {
        return carattere_mese;
    }
}