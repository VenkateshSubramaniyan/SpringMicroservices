package com.venkat.spring.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ExchangeValue {
	
	@Id
	private Long id;
	
	@JsonProperty(value = "from")
	@Column(name = "currencyfrom")
	private String currencyfrom;
	@Column(name = "currencyto")
	@JsonProperty(value = "to")
	private String currencyto;
	private BigDecimal conversionMultiplier;
	@Transient
	private Integer port;
	
	public ExchangeValue() {
		
	}

	public ExchangeValue(Long id, String currencyfrom, String currencyto, BigDecimal conversionMultiplier) {
		super();
		this.id = id;
		this.currencyfrom = currencyfrom;
		this.currencyto = currencyto;
		this.conversionMultiplier = conversionMultiplier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrencyfrom() {
		return currencyfrom;
	}

	public void setCurrencyfrom(String currencyfrom) {
		this.currencyfrom = currencyfrom;
	}

	public String getCurrencyto() {
		return currencyto;
	}

	public void setCurrencyto(String currencyto) {
		this.currencyto = currencyto;
	}

	public BigDecimal getConversionMultiplier() {
		return conversionMultiplier;
	}

	public void setConversionMultiplier(BigDecimal conversionMultiplier) {
		this.conversionMultiplier = conversionMultiplier;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", currencyfrom=" + currencyfrom + ", currencyto=" + currencyto
				+ ", conversionMultiplier=" + conversionMultiplier + ", port=" + port + "]";
	}
	
	

}
