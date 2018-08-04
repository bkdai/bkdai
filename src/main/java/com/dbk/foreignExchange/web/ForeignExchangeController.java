package com.dbk.foreignExchange.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbk.foreignExchange.entity.ResultInfo;
import com.dbk.foreignExchange.service.ForeignExchangeService;

@RestController
public class ForeignExchangeController {
	@Autowired
	private ForeignExchangeService foreignExchangeService;
	@RequestMapping("/Hello World")
     public String index() {
         return "Hello World";
     }
	@GetMapping("/convert/{from}/{to}")
	public ResultInfo convert(HttpServletRequest request, @PathVariable String from,@PathVariable String to) {
		double amount = Double.parseDouble(request.getParameter("amount"));
		return foreignExchangeService.convert(amount, from, to);
	}

}
