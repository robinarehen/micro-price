package com.rah.testjava.microprice.rest.service;

import java.time.LocalDate;
import java.util.Optional;

import com.rah.testjava.microprice.service.model.Price;

public interface PriceService {

	Optional<Price> getPrice(LocalDate date, Integer productId, Integer brandId, String time);
}
