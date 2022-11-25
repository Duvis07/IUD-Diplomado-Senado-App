package com.iud.appsenado.service;


import com.iud.appsenado.models.PartidoPolitico;
import com.iud.appsenado.repository.PartidoPoliticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartidoPoliticoService {

    @Autowired
    PartidoPoliticoRepository partidoPoliticoRepository;



    public PartidoPolitico guardarPartidoPolitico ( PartidoPolitico partidoPolitico ) {
        return partidoPoliticoRepository.save ( partidoPolitico );


    }

    public Iterable < PartidoPolitico > obtenerPartidosPoliticos ( ) {
        return partidoPoliticoRepository.findAll ( );
    }


    public  void eliminarPartidoPolitico ( Integer id ) {
        partidoPoliticoRepository.deleteById ( id );
    }


   public Optional < PartidoPolitico > obtenerPartidoPoliticoPorId ( Integer id) {
       return partidoPoliticoRepository.findById ( id);

   }

   public PartidoPolitico actualizarPartidoPolitico ( PartidoPolitico partidoPolitico ) {
       return partidoPoliticoRepository.save ( partidoPolitico );
   }

}



