package com.develop.aplicacao.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.develop.aplicacao.rest.model.Laboratorio;

@Repository
public interface LaboratorioRepository extends CrudRepository<Laboratorio, Long> {
	
	@Query("select cs from Laboratorio cs where cs.status = 'ATIVO'")
	public List<Laboratorio> findByLabAtivo();
}
