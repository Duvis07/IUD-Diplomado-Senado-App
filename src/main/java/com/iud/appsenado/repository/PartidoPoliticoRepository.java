package com.iud.appsenado.repository;


import com.iud.appsenado.models.PartidoPolitico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoPoliticoRepository extends CrudRepository< PartidoPolitico, Integer> {


}

