package it.lefosse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.lefosse.models.Giocatore;

@Repository
public interface GiocatoreRepository extends CrudRepository<Giocatore, Long> {
	 public List<Giocatore> findByCognome(String nome);
	 public List<Giocatore> findByRuolo(String ruolo);
	 public List<Giocatore> findBySquadra(String squadra);
	 public List<Giocatore> findByQuotazioneGreaterThan(double quotazione);
	public List<Giocatore> findByQuotazioneLessThan(double quotazione);
	
}