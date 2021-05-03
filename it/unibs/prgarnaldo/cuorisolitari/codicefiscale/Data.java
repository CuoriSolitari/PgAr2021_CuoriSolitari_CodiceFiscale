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
        this.carattere_mese = CarattereMese(_mese);
    }

    public char CarattereMese (int mese) {
        char carattere_mese = 0;
        if ( mese < 6 )
        {
            int ascii = 64 + mese;
            char month = (char) ascii;
            carattere_mese = month;
        }
        else if ( mese == 6 )
            carattere_mese = 'H';
        else if ( mese == 7 )
            carattere_mese = 'L';
        else if ( mese == 8 )
            carattere_mese = 'M';
        else if ( mese == 9 )
            carattere_mese = 'P';
        else if ( mese == 10 )
            carattere_mese = 'R';
        else if ( mese == 11 )
            carattere_mese = 'S';
        else if ( mese == 12 )
            carattere_mese = 'T';

        return carattere_mese;
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