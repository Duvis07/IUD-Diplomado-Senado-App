package com.iud.appsenado.repository;

import com.iud.appsenado.models.PartidoPolitico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

public interface PartidoPoliticoRepository extends CrudRepository< PartidoPolitico, Integer> {


}

