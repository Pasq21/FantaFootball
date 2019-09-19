package it.lefosse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lefosse.models.Giocatore;
import it.lefosse.repositories.GiocatoreRepository;

@Service
public class GiocatoreService {

	@Autowired
	private GiocatoreRepository giocatoreRepository;

	public void addGiocatore(String nome,String ruolo,String squadra,double quotazione) {
		Giocatore giocatore=new Giocatore(nome,ruolo,squadra,quotazione);
		giocatoreRepository.save(giocatore);
	}

	public List<Giocatore> list() {
		return (List<Giocatore>) giocatoreRepository.findAll();
	}

	public void modificaGiocatore(String nome, double quotazione, String ruolo, String squadra, long id) {
		Giocatore giocatore = giocatoreRepository.findById(id).get();
		giocatore.setCognome(nome);
		giocatore.setQuotazione(quotazione);
		giocatore.setRuolo(ruolo);
		giocatore.setSquadra(squadra);
		giocatoreRepository.save(giocatore);
	}

	public void eliminaGiocatore(long id) {
		giocatoreRepository.deleteById(id);
	}
	
	public List<Giocatore> trovaPerNome(String nome) {
		return giocatoreRepository.findByCognome(nome);
	}
	
	public List<Giocatore> trovaPerRuolo(String ruolo) {
		return giocatoreRepository.findByRuolo(ruolo);
	}
	
	public List<Giocatore> trovaPerSquadra(String squadra) {
		return giocatoreRepository.findBySquadra(squadra);
	}
	
	public List<Giocatore> trovaPerQuotazioneMaggiore(double quotazione) {
		return giocatoreRepository.findByQuotazioneGreaterThan(quotazione);
		
	}
	
	public List<Giocatore> trovaPerQuotazioneMinore(double quotazione) {
		return giocatoreRepository.findByQuotazioneLessThan(quotazione);
		
	}
	
	
	
	
}