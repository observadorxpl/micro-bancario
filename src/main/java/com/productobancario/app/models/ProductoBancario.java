package com.productobancario.app.models;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoBancario {
	@Id
	private String idProducto;

	@NotEmpty
	private String descripcion;

	@NotEmpty
	private Integer numMaxDeposito;

	@NotEmpty
	private Integer numMaxRetiro;
	@Valid
	private TipoProducto tipoProducto;
	
	@NotEmpty
	private Double comision;
	@JsonIgnore
	private Integer prueba;
	
	@NotEmpty
	private Integer codigoProducto;
	public ProductoBancario(@NotEmpty String descripcion, @NotEmpty Integer numMaxDeposito,
			@NotEmpty Integer numMaxRetiro, @Valid TipoProducto tipoProducto, @NotEmpty Double comision,
			@NotEmpty Integer codigoProducto) {
		super();
		this.descripcion = descripcion;
		this.numMaxDeposito = numMaxDeposito;
		this.numMaxRetiro = numMaxRetiro;
		this.tipoProducto = tipoProducto;
		this.comision = comision;
		this.codigoProducto = codigoProducto;
	}
}
