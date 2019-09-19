package it.lefosse.controller;

import java.util.List;

import javax.naming.directory.ModificationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.lefosse.models.Giocatore;
import it.lefosse.services.GiocatoreService;

@Controller
public class ControllerApp {

	@Autowired
	GiocatoreService giocatoreService;

	@GetMapping("/")
	public String main(Model model) {
		return "intro";
	}

	@GetMapping("/menu")
	public String mainScelta(@RequestParam(name = "scelta") String scelta, Model model) {
		List<Giocatore> listaGiocatori = giocatoreService.list();

		switch (scelta ) {
		case "1": 
			return "inserisci";
		case "2":
			model.addAttribute("listaGioc", listaGiocatori);
			return "modifica";
		case "3":
			model.addAttribute("listaGioc", listaGiocatori);
			return "elimina";
		case "4":
			model.addAttribute("listaGioc", listaGiocatori);
			return "visualizzaAll";
		case "5":
			return "cercaPerNome";
		case "6":
			return "cercaPerRuolo";
		case "7":
			return "cercaPerSquadra";
		default:
			return "cercaPerQuotazioneMaggioreDi";
		}

	}

	@PostMapping("/addGiocatore")
	public String giocInserito(@RequestParam(name = "nome") String nome,
			@RequestParam(name = "quotazione") double quotazione, @RequestParam(name = "ruolo") String ruolo,
			@RequestParam(name = "squadra") String squadra, Model model) {

		String messaggio = "Giocatore inserito con successo!";
		model.addAttribute("messaggio", messaggio);
		giocatoreService.addGiocatore(nome, ruolo, squadra, quotazione);
		return "intro";
	}
	
	@PostMapping("/modificaGioc")
	public String updateGioc(@RequestParam(name = "nome") String nome,
			@RequestParam(name = "quotazione") double quotazione, @RequestParam(name = "ruolo") String ruolo,
			@RequestParam(name = "squadra") String squadra, @RequestParam(name = "id") Long id, Model model) {

		
		giocatoreService.modificaGiocatore(nome, quotazione, ruolo, squadra, id);

		return "intro";
	}

	@PostMapping("/eliminaGioc")
	public String deleteGioc(@RequestParam(name = "id") Long id, Model model) {
		String messaggio = "Giocatore eliminato con successo!";
		model.addAttribute("messaggio", messaggio);
		giocatoreService.eliminaGiocatore(id);
		return "intro";
	}

	@GetMapping("/visualizzaNomeEffettivo")
	public String visualizzaPerNome(@RequestParam(name = "nome") String nome, Model model) {
		List<Giocatore> lista = giocatoreService.trovaPerNome(nome);
		model.addAttribute("listaGioc", lista);
		return "visualizzaAll";
	}

	@GetMapping("/visualizzaRuoloEffettivo")
	public String visualizzaPerRuolo(@RequestParam(name = "ruolo") String ruolo, Model model) {
		List<Giocatore> lista = giocatoreService.trovaPerRuolo(ruolo);
		model.addAttribute("listaGioc", lista);
		return "visualizzaAll";
	}

	@GetMapping("/visualizzaSquadraEffettivo")
	public String visualizzaPerSquadra(@RequestParam(name = "squadra") String squadra, Model model) {
		List<Giocatore> lista = giocatoreService.trovaPerSquadra(squadra);
		model.addAttribute("listaGioc", lista);
		return "visualizzaAll";
	}

	@GetMapping("/cercaQuotazioneMaggiore")
	public String cercaQuotazione(@RequestParam(name = "quotazione") double quotazione,
			@RequestParam(name = "valore") String valore, Model model) {
		if ("maggiore".equals(valore)) {
		List<Giocatore> lista = giocatoreService.trovaPerQuotazioneMaggiore(quotazione);
		model.addAttribute("listaGioc", lista);
		}
		else {
			List<Giocatore> lista = giocatoreService.trovaPerQuotazioneMinore(quotazione);
			model.addAttribute("listaGioc", lista);
		}
		return "visualizzaAll";
	}

}