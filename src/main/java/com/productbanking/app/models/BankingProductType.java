package com.productbanking.app.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class BankingProductType {
	@Id
	private String idProductType;

	@NotEmpty
	private String description;

	public BankingProductType(@NotEmpty String description) {
		super();
		this.description = description;
	}

}
