package com.rah.testjava.microprice.rest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.rah.testjava.microprice.rest.entity.PriceEntity;
import com.rah.testjava.microprice.rest.repository.PriceRepository;
import com.rah.testjava.microprice.rest.service.impl.PriceServiceImpl;
import com.rah.testjava.microprice.rest.util.MapperUtil;
import com.rah.testjava.microprice.service.model.Price;

public class PriceServiceTest {

	@InjectMocks
	private PriceServiceImpl priceService;

	@Mock
	private PriceRepository priceRepository;

	private MapperUtil mapper;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.mapper = new MapperUtil();
		ReflectionTestUtils.setField(this.priceService, "mapper", this.mapper);
	}

	private String loadJson(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(String.format("src/test/resources/%s", fileName)));
			String json = reader.lines().map(value -> new StringBuilder().append(value.trim()))
					.collect(Collectors.joining());
			reader.close();
			return json;
		} catch (Exception e) {
			return null;
		}
	}

	private void loadMock(String fileName) {
		List<PriceEntity> priceEntities = this.mapper.mapperJsonToObject(this.loadJson(fileName));
		when(this.priceRepository.findByProductAndBrandAndDateTimeBetween(Mockito.anyInt(), Mockito.anyInt(),
				Mockito.any())).thenReturn(priceEntities);
	}

	@Test
	public void getPriceTest1() {

		LocalDate date = LocalDate.parse("2020-06-14");
		Integer productId = 35455;
		Integer brandId = 1;
		String time = "10:00:00";
		String fileName = "test-1.json";

		this.loadMock(fileName);

		Optional<Price> response = this.priceService.getPrice(date, productId, brandId, time);

		assertTrue(response.isPresent());
		Price price = response.get();
		Integer expected = 1;
		assertEquals(expected, price.getPriceList());
	}

	@Test
	public void getPriceTest2() {

		LocalDate date = LocalDate.parse("2020-06-14");
		Integer productId = 35455;
		Integer brandId = 1;
		String time = "16:00:00";

		String fileName = "test-2.json";

		this.loadMock(fileName);

		Optional<Price> response = this.priceService.getPrice(date, productId, brandId, time);

		assertTrue(response.isPresent());
		Price price = response.get();
		Integer expected = 2;
		assertEquals(expected, price.getPriceList());
	}
}
