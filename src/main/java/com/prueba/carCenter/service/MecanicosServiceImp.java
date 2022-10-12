package com.prueba.carCenter.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prueba.carCenter.dto.MecanicosDto;
import com.prueba.carCenter.entity.Mecanicos;
import com.prueba.carCenter.exception.MecanicoException;
import com.prueba.carCenter.exception.RequestExceptionHandler;
import com.prueba.carCenter.repository.MecanicosRepository;

@Service
public class MecanicosServiceImp implements MecanicosServiceI {

	@Autowired
	private MecanicosRepository mecanicosRepository;

	@Override
	public List<Mecanicos> consultarMecanicosAll() {
		return mecanicosRepository.findAll();
	}
	
	@Override
	public List<MecanicosDto> mecanicosEstado(String estado) {
		return this.mecanicosRepository.findByEstadoOrderByHorasTrabajadasAsc(estado).stream().map(Mecanicos::toDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public Mecanicos consultarMecanicosById(Integer documento) throws RequestExceptionHandler {
		Optional<Mecanicos> mecanicosBd = mecanicosRepository.findById(documento);
		if (mecanicosBd.isPresent()) {
			return mecanicosBd.get();
		}
		throw new RequestExceptionHandler(HttpStatus.INTERNAL_SERVER_ERROR, "Mecanico NO existe");
	}
	
	@Override
	public String crearMecanico(MecanicosDto mecanicosDto){
		try {
			Mecanicos mecanicos = mecanicosDto.toEntity();
			mecanicosRepository.pamecanicosinsertar(
					mecanicos.getDocumento(), 
					mecanicos.getTipoDocumento(), 
					mecanicos.getPrimerNombre().toUpperCase(), 
					mecanicos.getSegundoNombre().toUpperCase(), 
					mecanicos.getPrimerApellido().toUpperCase(), 
					mecanicos.getSegundoApellido().toUpperCase(), 
					mecanicos.getCelular(), 
					mecanicos.getDireccion(), 
					mecanicos.getEmail().toLowerCase(), 
					mecanicos.getEstado(), 
					mecanicos.getHorasTrabajadas());
			return "Mecanico creado exitosamente";
			
		} catch (NegativeArraySizeException e) {
			e.printStackTrace();
			new RequestExceptionHandler(HttpStatus.INTERNAL_SERVER_ERROR, "Error consumiendo el servicio");
			return "Error consumiendo el servicio";
		} 
		
	}

	@Override
	public String eliminarMecanicoById(Integer documento) {
		
		try {
			mecanicosRepository.deleteById(documento);
			return "Mecanico eliminado exitosamente";
		} catch (RuntimeException e) {
			e.printStackTrace();
			new RequestExceptionHandler(HttpStatus.INTERNAL_SERVER_ERROR, "Error consumiendo el servicio");
			return "Error consumiendo el servicio";
		}
		
	}

	@Override
	public void guardarMecanico(MecanicosDto mecanicosDto) {
		this.mecanicosRepository.save(mecanicosDto.toEntity());
	}
	
}
