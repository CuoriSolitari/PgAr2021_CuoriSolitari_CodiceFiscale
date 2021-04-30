package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

public class MainClass {

    public static void main(String[] args) {
        String prova = "FRMPLA01D26D434N";

        int day;
        day = 30;
        int year;
        year=2020;
        int moth;
        moth=3;


        boolean b = Data.verificaData(day,moth,year);
        if(b==false)
            System.out.println("data non valida");
        else
            System.out.println("data corretta");
        if(moth==2 && day > 29)
            System.out.println("il mese di febbraio ha al massimo 29 giorni");


        boolean a = CodiceFiscale.verificaCF(prova);
        if (a==false) System.out.println("ciao");
        else System.out.println("bella");


    }
}
