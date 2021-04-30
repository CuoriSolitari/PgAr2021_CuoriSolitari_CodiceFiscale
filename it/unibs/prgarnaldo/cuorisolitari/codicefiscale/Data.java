package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

    private int giorno;
    private int mese;
    private int anno;

    public Data(int _giorno, int _mese, int _anno) {
        this.giorno = _giorno;
        this.mese = _mese;
        this.anno = _anno;
    }

    /**
     * Questo metodo permette di verificare se una data è valida o no
     *
     * @param day
     * @param mese
     * @param year
     * @return
     */
    public static boolean verificaData(int day, int mese, int year)
    {
        GregorianCalendar cal = new GregorianCalendar (year, mese - 1, day);
        cal.setLenient (false);

        try
        {
            cal.get (Calendar.DATE);
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }

    public int getGiorno()
    {
        return giorno;
    }

    public int getMese()
    {
        return mese;
    }

    public int getAnno()
    {
        return anno;
    }
}
