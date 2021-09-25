package com.venkat.spring.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment env;
	
	@Autowired
	private ExchangeValueRepository excValrepo;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue( @PathVariable String from, @PathVariable String to){
		
		Optional<ExchangeValue> exchangeValOpt = Optional.ofNullable(excValrepo.findByCurrencyfromAndCurrencyto(
				from.toUpperCase(), to.toUpperCase()));

		ExchangeValue excVal=null;

		if  ( exchangeValOpt.isPresent()) {
			excVal=exchangeValOpt.get();
		}else {
			throw new DataNotFoundException();
		
		}
 		
// 		excValrepo.findAll().stream().forEach(System.err::println);
		
//		excVal=new ExchangeValue(1000L, from, to, BigDecimal.valueOf( 65));
		//excVal.setPort(Integer.parseInt( env.getProperty("server.port")));
		return excVal;
	}
}
