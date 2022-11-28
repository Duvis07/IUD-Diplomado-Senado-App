package com.iud.appsenado.interfaces;

import com.iud.appsenado.dto.ProyectoDto;
import com.iud.appsenado.models.Proyecto;

public interface ProyectoServiceDto {

        public ProyectoDto crearProyecto ( ProyectoDto proyectoDto );

        public ProyectoDto actualizarProyecto ( ProyectoDto proyectoDto, Integer id );

        public Iterable < Proyecto > obtenerProyectos ( );

        public ProyectoDto obtenerProyectoPorId ( Integer id );

        public void eliminarProyecto ( Integer id );

}
