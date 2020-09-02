package com.develop.aplicacao.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.develop.aplicacao.rest.model.Exame;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Long>{

}
