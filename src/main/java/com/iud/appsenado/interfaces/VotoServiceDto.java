package com.iud.appsenado.interfaces;

import com.iud.appsenado.dto.VotoDto;
import com.iud.appsenado.models.Voto;

public interface VotoServiceDto {

    public VotoDto crearVoto( VotoDto votoDto);

    public VotoDto actualizarVoto( VotoDto votoDto, Integer id);

    public Iterable< Voto > obtenerVotos();

    public VotoDto obtenerVotoPorId(Integer id);

    public void eliminarVoto(Integer id);




}
