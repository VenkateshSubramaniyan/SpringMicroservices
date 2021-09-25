package com.venkat.spring.currencyexchangeservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	
	ExchangeValue  findByCurrencyfromAndCurrencyto(String from, String to) ;

}
