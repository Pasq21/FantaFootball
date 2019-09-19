package it.lefosse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Giocatore {
	@Id
	@GeneratedValue
	private long id;
	private String cognome;
	private String ruolo;
	private String squadra;
	private double quotazione;
	public Giocatore(String cognome, String ruolo, String squadra, double quotazione) {
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.squadra = squadra;
		this.quotazione = quotazione;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getSquadra() {
		return squadra;
	}
	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}
	public double getQuotazione() {
		return quotazione;
	}
	public void setQuotazione(double quotazione) {
		this.quotazione = quotazione;
	}
	public Giocatore() {
	}
	
	@Override
	public String toString() {
		return "Cognome=" + cognome + ", ruolo=" + ruolo + ", squadra=" + squadra + ", quotazione="
				+ quotazione;
	}
	
	
}
