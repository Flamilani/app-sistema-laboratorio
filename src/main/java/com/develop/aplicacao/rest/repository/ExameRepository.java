package com.develop.aplicacao.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.develop.aplicacao.rest.model.Exame;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Long>{
	
	@Query("select cs from Exame cs where cs.status = 'ATIVO'")
	public List<Exame> findByExameAtivo();
	
	@Query("select cs from Exame cs where cs.nome= :#{#nome} and cs.status = 'ATIVO'")
	public List<Exame> findByNomeExame(@Param("nome") String nome);
	

}
