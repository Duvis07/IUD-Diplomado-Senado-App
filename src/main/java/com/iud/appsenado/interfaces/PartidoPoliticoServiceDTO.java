package com.iud.appsenado.interfaces;

import com.iud.appsenado.dto.PartidoPoliticoDto;
import com.iud.appsenado.models.PartidoPolitico;

public interface PartidoPoliticoServiceDTO {

    public PartidoPoliticoDto crearPartidoPolitico ( PartidoPoliticoDto partidoPoliticoDto );

    public PartidoPoliticoDto actualizarPartidoPolitico ( PartidoPoliticoDto partidoPoliticoDto, Integer id );

    public Iterable < PartidoPolitico > obtenerPartidosPoliticos ( );

    public PartidoPoliticoDto obtenerPartidoPoliticoPorId ( Integer id );

    public void eliminarPartidoPolitico ( Integer id );






}
