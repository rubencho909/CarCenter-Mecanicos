package com.prueba.carCenter.service;

import java.util.List;

import com.prueba.carCenter.dto.MecanicosDto;
import com.prueba.carCenter.entity.Mecanicos;

public interface MecanicosServiceI {
	
	public List<Mecanicos> consultarMecanicosAll();
    public Mecanicos consultarMecanicosById(Integer documento) throws Exception;
    public String crearMecanico(MecanicosDto mecanicosDto);
    public void guardarMecanico(MecanicosDto mecanicosDto);
    public String eliminarMecanicoById(Integer documento);
    public List<MecanicosDto> mecanicosEstado(String estado);

}
