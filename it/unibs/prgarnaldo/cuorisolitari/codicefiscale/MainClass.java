package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

public class MainClass {

    public static void main(String[] args) {
        String prova = "FRMPLA01D26D434N";

        boolean a = CodiceFiscale.verificaCF(prova);
        if (a==false) System.out.println("ciao");
        else System.out.println("bella");
    }
}
