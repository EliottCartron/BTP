package btp.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import btp.model.Prestataire;
import btp.persistence.IPrestataireRepository;
import btp.model.Views;

@RestController
public class PrestataireRestController {

	@Autowired
	private IPrestataireRepository prestataireRepo;

	@GetMapping("/prestataire")
	@JsonView(Views.ViewPrestataire.class)
	public List<Prestataire> findAll() {
		return prestataireRepo.findAll();
	}

	@GetMapping("/prestataire/{id}")
	@JsonView(Views.ViewPrestataire.class)
	public Prestataire find(@PathVariable Long id) {

		Optional<Prestataire> optPrestataire = prestataireRepo.findById(id);

		if (optPrestataire.isPresent()) {
			return optPrestataire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("/prestataire")
	public Prestataire create(@RequestBody Prestataire prestataire) {
		prestataire = prestataireRepo.save(prestataire);

		return prestataire;
	}
	
	@PutMapping("/prestataire/{id}")
	public Prestataire update(@RequestBody Prestataire prestataire, @PathVariable Long id) {
		if (!prestataireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		prestataire = prestataireRepo.save(prestataire);

		return prestataire;
	}

// 	@Patch
//	{}
	
	@DeleteMapping("/prestataire/{id}")
	public void delete (@PathVariable Long id) {
		prestataireRepo.deleteById(id);
	}
}
