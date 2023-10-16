package com.rah.testjava.microprice.rest.service.impl;

import org.springframework.stereotype.Service;

import com.rah.testjava.microprice.rest.repository.PriceRepository;
import com.rah.testjava.microprice.rest.service.PriceService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

	private PriceRepository price;

}
