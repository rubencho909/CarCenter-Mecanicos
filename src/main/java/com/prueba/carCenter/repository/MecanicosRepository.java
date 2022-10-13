package com.prueba.carCenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.carCenter.entity.Mecanicos;
@Repository
public interface MecanicosRepository extends JpaRepository<Mecanicos, Integer> {
	
	@Query(value = "SELECT * FROM MECANICOS WHERE ESTADO = ?1 AND ROWNUM < 11 ORDER BY HORAS_TRABAJADAS ASC", nativeQuery = true)
	public List<Mecanicos> findByEstadoOrderByHorasTrabajadasAsc(String estado);
	
	//public List<Mecanicos> findByEstadoOrderByHorasTrabajadasAsc(String estado);
	
	@Query(value = "{call pa_mecanicos_insertar(:documento, :tipo_documento, :primer_nombre, :segundo_nombre, :primer_apellido, :segundo_apellido, :celular, :direccion, :email, :estado, :horas_trabajadas)}", nativeQuery = true)
	void pamecanicosinsertar(
			@Param("documento")Integer documento,
			@Param("tipo_documento")String tipo_documento,
			@Param("primer_nombre")String primer_nombre,
			@Param("segundo_nombre")String segundo_nombre,
			@Param("primer_apellido")String primer_apellido,
			@Param("segundo_apellido")String segundo_apellido,
			@Param("celular")String celular,
			@Param("direccion")String direccion,
			@Param("email")String email,
			@Param("estado")String estado,
			@Param("horas_trabajadas")Integer horas_trabajadas
			);
}
