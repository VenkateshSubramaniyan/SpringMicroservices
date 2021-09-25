package com.venki.spring.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@Autowired
	CurrencyExchangeServiceProxy currExchangeProxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/{qty}")
	public CurrencyConversionBean  convertCurrency( 
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal qty) {
		Map <String,String> urivariables = new HashMap<String,String>();
		urivariables.put("from", from);
		urivariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> response= new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, urivariables);
		System.err.println("venki test");
		CurrencyConversionBean bean=response.getBody();
		bean.setCalculatedAmount(qty.multiply(bean.getConversionMultiple()));

//		return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, qty) ;
		
		return bean;
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/{qty}")
	public CurrencyConversionBean  convertCurrencyUsingFeign( 
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal qty) {
		
		CurrencyConversionBean bean= currExchangeProxy.retriveExchangeValue(from, to) ;
		bean.setCalculatedAmount(qty.multiply(bean.getConversionMultiple()));
		
		return bean;
	}

	
}
