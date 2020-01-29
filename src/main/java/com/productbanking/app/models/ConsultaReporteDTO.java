package com.productbanking.app.models;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConsultaReporteDTO {
	@NotEmpty
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date rangoInicio;
	
	@NotEmpty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date rangoFin;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getRangoInicio() {
		return rangoInicio;
	}

	public void setRangoInicio(Date rangoInicio) {
		this.rangoInicio = rangoInicio;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getRangoFin() {
		return rangoFin;
	}

	public void setRangoFin(Date rangoFin) {
		this.rangoFin = rangoFin;
	}
    
    
}
