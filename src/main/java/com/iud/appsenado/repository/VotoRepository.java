package com.iud.appsenado.repository;

import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.models.Voto;
import org.springframework.data.repository.CrudRepository;

public interface VotoRepository extends CrudRepository < Voto, Integer > {

}

