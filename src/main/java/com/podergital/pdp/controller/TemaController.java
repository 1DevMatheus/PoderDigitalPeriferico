package com.podergital.pdp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.podergital.pdp.model.TemaModel;
import com.podergital.pdp.repository.TemaRepository;


@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	public TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable Long id){
		return temaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());	
	}
	

	@GetMapping("/temas/{temas}")
	public ResponseEntity<List<TemaModel>> getByTitle(@PathVariable String temas){
		return ResponseEntity.ok(temaRepository.findAllByTemaContainingIgnoreCase(temas));
	}
	
	@PostMapping
	public ResponseEntity<TemaModel> post(@Valid @RequestBody TemaModel temas){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(temaRepository.save(temas));
	}
	
	@PutMapping
	public ResponseEntity<TemaModel> put(@Valid @RequestBody TemaModel temas){
		return temaRepository.findById(temas.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED)
				.body(temaRepository.save(temas)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<TemaModel> temas = temaRepository.findById(id);
		
		if(temas.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		temaRepository.deleteById(id);
	}
}
