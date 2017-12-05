package modelo.mapa;

public class Edifici {

    private String idEdifici;
    private String nomEdifici;
    private int numEdifici;

    public Edifici(String idEdifici, String nomEdifici, int numEdifici) {
        this.idEdifici = idEdifici;
        this.nomEdifici = nomEdifici;
        this.numEdifici = numEdifici;
    }

    public String getIdEdifici() {
        return idEdifici;
    }

    public void setIdEdifici(String idEdifici) {
        this.idEdifici = idEdifici;
    }

    public String getNomEdifici() {
        return nomEdifici;
    }

    public void setNomEdifici(String nomEdifici) {
        this.nomEdifici = nomEdifici;
    }

    public int getNumEdifici() {
        return numEdifici;
    }

    public void setNumEdifici(int numEdifici) {
        this.numEdifici = numEdifici;
    }
}

