package com.rah.testjava.microprice.rest.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rah.testjava.microprice.rest.service.PriceService;
import com.rah.testjava.microprice.service.api.PriceApi;
import com.rah.testjava.microprice.service.model.Price;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/price")
@AllArgsConstructor
public class PriceController implements PriceApi {

	private PriceService priceService;

	@Override
	public ResponseEntity<Price> getPrice(LocalDate date, Integer productId, Integer brandId) {
		// TODO Auto-generated method stub
		return null;
	}
}
