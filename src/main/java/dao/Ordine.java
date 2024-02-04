package dao;

import java.sql.Timestamp;

public class Ordine {

	private int idOrdine;
	private int idUtente;
	private Timestamp dataOrdine;

	public Ordine() {
	}

	public Ordine(int idOrdine, int idUtente, Timestamp dataOrdine) {
		this.idOrdine = idOrdine;
		this.idUtente = idUtente;
		this.dataOrdine = dataOrdine;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public Timestamp getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Timestamp dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	@Override
	public String toString() {
		return "Ordine [idOrdine=" + idOrdine + ", idUtente=" + idUtente + ", dataOrdine=" + dataOrdine + "]";
	}
	
}
