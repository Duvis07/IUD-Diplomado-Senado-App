package com.iud.appsenado.interfaces;

import com.iud.appsenado.dto.SenadorDto;
import com.iud.appsenado.models.Senador;

public interface SenadorServiceDto {
    public SenadorDto crearSenador( SenadorDto senadorDto );

    public SenadorDto actualizarSenador( SenadorDto senadorDto , Integer id);

    public Iterable< Senador > obtenerSenadores();

    public SenadorDto obtenerSenadorPorId( Integer id);

    public void eliminarSenador(Integer id);
}

