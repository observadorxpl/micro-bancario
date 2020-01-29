package com.productbanking.app.models;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BankingProduct {
	@Id
	private String idProduct;

	@NotEmpty
	private String description;

	@NotEmpty
	private Integer numMaxDeposit;

	@NotEmpty
	private Integer numMaxWithdrawal;
	@Valid
	private BankingProductType productType;
	
	@NotEmpty
	private Double commision;
	@NotEmpty
	private Integer productCode;
	@Valid
	private Bank bank;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createAt;

	public BankingProduct(@NotEmpty String description, @NotEmpty Integer numMaxDeposit,
			@NotEmpty Integer numMaxWithdrawal, @Valid BankingProductType productType, @NotEmpty Double commision,
			@NotEmpty Integer productCode, @Valid Bank bank, Date createAt) {
		super();
		this.description = description;
		this.numMaxDeposit = numMaxDeposit;
		this.numMaxWithdrawal = numMaxWithdrawal;
		this.productType = productType;
		this.commision = commision;
		this.productCode = productCode;
		this.bank = bank;
		this.createAt = createAt;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumMaxDeposit() {
		return numMaxDeposit;
	}

	public void setNumMaxDeposit(Integer numMaxDeposit) {
		this.numMaxDeposit = numMaxDeposit;
	}

	public Integer getNumMaxWithdrawal() {
		return numMaxWithdrawal;
	}

	public void setNumMaxWithdrawal(Integer numMaxWithdrawal) {
		this.numMaxWithdrawal = numMaxWithdrawal;
	}

	public BankingProductType getProductType() {
		return productType;
	}

	public void setProductType(BankingProductType productType) {
		this.productType = productType;
	}

	public Double getCommision() {
		return commision;
	}

	public void setCommision(Double commision) {
		this.commision = commision;
	}

	public Integer getProductCode() {
		return productCode;
	}

	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


}
