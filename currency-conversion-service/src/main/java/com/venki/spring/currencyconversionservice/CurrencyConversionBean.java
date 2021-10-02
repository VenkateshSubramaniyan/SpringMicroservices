package com.venki.spring.currencyconversionservice;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CurrencyConversionBean {
	
	private Long id;
	
	private String from;
	private String to;
	@JsonAlias(value ="conversionMultiplier")
	private BigDecimal conversionMultiple;
	private BigDecimal calculatedAmount;
	private Integer port;
	public CurrencyConversionBean() {

	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple,
			BigDecimal calculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.calculatedAmount = calculatedAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", calculatedAmount=" + calculatedAmount + "]";
	}
	
	
}
