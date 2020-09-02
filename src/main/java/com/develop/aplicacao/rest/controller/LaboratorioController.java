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

import com.develop.aplicacao.rest.model.Laboratorio;
import com.develop.aplicacao.rest.repository.LaboratorioRepository;

@RestController
@RequestMapping(value = "/laboratorio")
public class LaboratorioController {
	
	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Laboratorio>> laboratorio () {
		
		List<Laboratorio> list = (List<Laboratorio>) laboratorioRepository.findAll();
		
		return new ResponseEntity<List<Laboratorio>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public ResponseEntity<List<Laboratorio>> listarLaboratorio () {
		
		List<Laboratorio> list = (List<Laboratorio>) laboratorioRepository.findAll();
		
		return new ResponseEntity<List<Laboratorio>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Laboratorio> cadastrar(@RequestBody Laboratorio laboratorio) {
		
		Laboratorio laboratorioSalvo = laboratorioRepository.save(laboratorio);
		
		return new ResponseEntity<Laboratorio>(laboratorioSalvo, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add", produces = "application/json")
	public ResponseEntity<Laboratorio> cadastrarLaboratorio(@RequestBody Laboratorio laboratorio) {
		
		Laboratorio laboratorioSalvo = laboratorioRepository.save(laboratorio);
		
		return new ResponseEntity<Laboratorio>(laboratorioSalvo, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Laboratorio> atualizar(@PathVariable("id") Long id, @RequestBody Laboratorio newLaboratorio) {
		
		Optional<Laboratorio> oldLaboratorio = laboratorioRepository.findById(id);
        if(oldLaboratorio.isPresent()){
        	Laboratorio laboratorio = oldLaboratorio.get();
        	laboratorio.setNome(newLaboratorio.getNome());
        	laboratorio.setEndereco(newLaboratorio.getEndereco());
            laboratorioRepository.save(laboratorio);
            return new ResponseEntity<Laboratorio>(laboratorio, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "/update/{id}", produces = "application/json")
	public ResponseEntity<Laboratorio> atualizarLaboratorio(@PathVariable("id") Long id, @RequestBody Laboratorio newLaboratorio) {
		
		Optional<Laboratorio> oldLaboratorio = laboratorioRepository.findById(id);
        if(oldLaboratorio.isPresent()){
        	Laboratorio laboratorio = oldLaboratorio.get();
        	laboratorio.setNome(newLaboratorio.getNome());
        	laboratorio.setEndereco(newLaboratorio.getEndereco());
            laboratorioRepository.save(laboratorio);
            return new ResponseEntity<Laboratorio>(laboratorio, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Laboratorio> delete(@PathVariable("id") Long id) {
		
		Optional<Laboratorio> laboratorio = laboratorioRepository.findById(id);
        if(laboratorio.isPresent()){
            laboratorioRepository.delete(laboratorio.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<Laboratorio> deleteLaboratorio(@PathVariable("id") Long id) {
		
		Optional<Laboratorio> laboratorio = laboratorioRepository.findById(id);
        if(laboratorio.isPresent()){
            laboratorioRepository.delete(laboratorio.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	

}