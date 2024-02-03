package prodotti;

import java.io.Serializable;

public class Prodotti implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idProdotto;

	private String categoria;

	private String descrizione;

	private byte[] fotoprodotto;

	private String nome;

	private double prezzo;

	public Prodotti() {
	}

	public int getIdProdotto() {
		return this.idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public byte[] getFotoprodotto() {
		return this.fotoprodotto;
	}

	public void setFotoprodotto(byte[] fotoprodotto) {
		this.fotoprodotto = fotoprodotto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Prodotti(int idProdotto, String categoria, String descrizione, String nome, double prezzo) {
		super();
		this.idProdotto = idProdotto;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public Prodotti(int idProdotto, String categoria, String descrizione, byte[] fotoprodotto, String nome,
			double prezzo) {
		super();
		this.idProdotto = idProdotto;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.fotoprodotto = fotoprodotto;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Prodotti [idProdotto=" + idProdotto + ", categoria=" + categoria + ", descrizione=" + descrizione
				+ ", nome=" + nome + ", prezzo=" + prezzo + "]";
	}
 
}