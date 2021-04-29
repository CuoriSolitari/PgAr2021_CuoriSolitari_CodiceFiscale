package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

public class MainClass {

    public static void main(String[] args) {
        String prova = "aaa";

        boolean a = CodiceFiscale.verificaCF(prova);
        if (a==false) System.out.println("ciao");
    }
}
