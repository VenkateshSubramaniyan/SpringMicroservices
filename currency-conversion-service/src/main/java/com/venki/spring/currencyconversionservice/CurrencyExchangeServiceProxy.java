package com.venki.spring.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange",url = "http://localhost:8001")
@FeignClient(name="currency-exchange")

public interface CurrencyExchangeServiceProxy {
	
	@GetMapping(value =  "currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retriveExchangeValue( @PathVariable("from") String from , @PathVariable String to );
	
}
