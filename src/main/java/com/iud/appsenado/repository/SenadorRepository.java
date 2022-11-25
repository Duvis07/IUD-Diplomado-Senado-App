package com.iud.appsenado.repository;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;
import org.springframework.data.repository.CrudRepository;

public interface SenadorRepository extends CrudRepository < Senador, Integer> {

}

