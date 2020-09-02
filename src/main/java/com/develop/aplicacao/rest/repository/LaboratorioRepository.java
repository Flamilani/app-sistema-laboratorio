package com.develop.aplicacao.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.develop.aplicacao.rest.model.Laboratorio;

@Repository
public interface LaboratorioRepository extends CrudRepository<Laboratorio, Long> {

}
