package com.prueba.carCenter.entity;

import javax.persistence.*;

import com.prueba.carCenter.dto.MecanicosDto;

@Entity
@Table(name = "MECANICOS")
public class Mecanicos {

    @Id
    @Column(name = "DOCUMENTO", unique = true)
    private Integer documento;
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "HORAS_TRABAJADAS")
    private Integer horasTrabajadas;

    public Mecanicos() {
    }

	public Mecanicos(Integer documento, String tipoDocumento, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, String celular, String direccion, String email,
			String estado, Integer horasTrabajadas) {
		super();
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.celular = celular;
		this.direccion = direccion;
		this.email = email;
		this.estado = estado;
		this.horasTrabajadas = horasTrabajadas;
	}

	public MecanicosDto toDto() {
    	MecanicosDto mecanicosDto = new MecanicosDto();
    	mecanicosDto.setDocumento(this.documento);
    	mecanicosDto.setTipoDocumento(this.tipoDocumento);
    	mecanicosDto.setPrimerNombre(this.primerNombre);
    	mecanicosDto.setSegundoNombre(this.segundoNombre);
    	mecanicosDto.setPrimerApellido(this.primerApellido);
    	mecanicosDto.setSegundoApellido(this.segundoApellido);
    	mecanicosDto.setCelular(this.celular);
    	mecanicosDto.setDireccion(this.direccion);
    	mecanicosDto.setEmail(this.email);
    	mecanicosDto.setEstado(this.estado);
    	mecanicosDto.setHorasTrabajadas(this.horasTrabajadas);
    	return mecanicosDto;
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

	@Override
	public String toString() {
		return "Mecanicos [documento=" + documento + ", tipoDocumento=" + tipoDocumento + ", primerNombre="
				+ primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", celular=" + celular + ", direccion=" + direccion
				+ ", email=" + email + ", estado=" + estado + ", horasTrabajadas=" + horasTrabajadas + "]";
	}

}
