package model;

import java.io.Serializable;



public class Utenti implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idUtente;
	private String email;
	private String indirizzo;
	private String password;
	private String username;
	private String nome;
	private String cognome;
	public Utenti(String email, String indirizzo, String password, String username, String nome, String cognome) {
		super();
		this.email = email;
		this.indirizzo = indirizzo;
		this.password = password;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return "Utenti [email=" + email + ", indirizzo=" + indirizzo + ", password=" + password + ", username="
				+ username + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	


}