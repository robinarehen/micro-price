package com.rah.testjava.microprice.rest.service;

import java.time.LocalDate;

import com.rah.testjava.microprice.service.model.Price;

public interface PriceService {

	Price getPrice(LocalDate date, Integer productId, Integer brandId, String time);
}
