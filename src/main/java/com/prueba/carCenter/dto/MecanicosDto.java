package com.prueba.carCenter.dto;

import com.prueba.carCenter.entity.Mecanicos;

public class MecanicosDto {

    private Integer documento;
    private String tipoDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String celular;
    private String direccion;
    private String email;
    private String estado;
    private Integer horasTrabajadas;
	
    public Mecanicos toEntity() {
    	Mecanicos mecanicos = new Mecanicos();
    	mecanicos.setDocumento(this.documento);
    	mecanicos.setTipoDocumento(this.tipoDocumento);
    	mecanicos.setPrimerNombre(this.primerNombre);
    	mecanicos.setSegundoNombre(this.segundoNombre);
    	mecanicos.setPrimerApellido(this.primerApellido);
    	mecanicos.setSegundoApellido(this.segundoApellido);
    	mecanicos.setCelular(this.celular);
    	mecanicos.setDireccion(this.direccion);
    	mecanicos.setEmail(this.email);
    	mecanicos.setEstado(this.estado);
    	mecanicos.setHorasTrabajadas(this.horasTrabajadas);
    	return mecanicos;
    }
    
    public Integer getDocumento() {
		return documento;
	}
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

}
