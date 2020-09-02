package com.develop.aplicacao.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.aplicacao.rest.model.Exame;
import com.develop.aplicacao.rest.repository.ExameRepository;

@RestController
@RequestMapping(value = "/exame")
public class ExameController {
	
	@Autowired
	private ExameRepository exameRepository;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Exame>> laboratorio () {
		
		List<Exame> list = (List<Exame>) exameRepository.findAll();
		
		return new ResponseEntity<List<Exame>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Exame> cadastrar(@RequestBody Exame exame) {
		
		Exame exameSalvo = exameRepository.save(exame);
		
		return new ResponseEntity<Exame>(exameSalvo, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cadastro", produces = "application/json")
	public ResponseEntity<Exame> cadastrarLaboratorio(@RequestBody Exame exame) {
		
		Exame exameSalvo = exameRepository.save(exame);
		
		return new ResponseEntity<Exame>(exameSalvo, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Exame> atualizar(@PathVariable("id") Long id, @RequestBody Exame newExame) {
		
		Optional<Exame> oldExame = exameRepository.findById(id);
        if(oldExame.isPresent()){
        	Exame exame = oldExame.get();
        	exame.setNome(newExame.getNome());
        	exameRepository.save(exame);
            return new ResponseEntity<Exame>(exame, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Exame> delete(@PathVariable("id") Long id) {
		
		Optional<Exame> exame = exameRepository.findById(id);
        if(exame.isPresent()){
        	exameRepository.delete(exame.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
