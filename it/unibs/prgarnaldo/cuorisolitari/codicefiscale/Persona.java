package it.unibs.prgarnaldo.cuorisolitari.codicefiscale;

public class Persona {
    private String nome;
    private String cognome;
    private boolean sesso;
    private Data data;
    private String luogo;

    public Persona(String _nome, String _cognome, String _sesso, Data _data, String _luogo){
        this.nome = _nome;
        this.cognome = _cognome;
        this.data = _data;
        this.luogo = _luogo;
        if(_sesso.equals("M") == true )
            this.sesso = true;
        else
            this.sesso = false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", sesso=" + sesso +
                ", data=" + data.getAnno() + "-" + data.getMese() + "-" + data.getGiorno() +
                ", luogo='" + luogo + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean isSesso() {
        return sesso;
    }

    public Data getData() {
        return data;
    }

    public String getLuogo() {
        return luogo;
    }
}

