package model;

public class ProdottiNelCarrello {
    private int idProdottoNelCarrello;
    private int idCarrello;
    private int idProdotto;
    private int quantita;
    private double subtotale;

    // Costruttore vuoto
    public ProdottiNelCarrello() {}

    // Getter e Setter per tutti i campi
    public int getIdProdottoNelCarrello() {
        return idProdottoNelCarrello;
    }

    public void setIdProdottoNelCarrello(int idProdottoNelCarrello) {
        this.idProdottoNelCarrello = idProdottoNelCarrello;
    }

    public int getIdCarrello() {
        return idCarrello;
    }

    public void setIdCarrello(int idCarrello) {
        this.idCarrello = idCarrello;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getSubtotale() {
        return subtotale;
    }

    public void setSubtotale(double subtotale) {
        this.subtotale = subtotale;
    }

	@Override
	public String toString() {
		return "ProdottiNelCarrello [idProdottoNelCarrello=" + idProdottoNelCarrello + ", idCarrello=" + idCarrello
				+ ", idProdotto=" + idProdotto + ", quantita=" + quantita + ", subtotale=" + subtotale + "]";
	}

    // Altri metodi, ad esempio toString(), equals(), hashCode() se necessario
    // ...
    
}
