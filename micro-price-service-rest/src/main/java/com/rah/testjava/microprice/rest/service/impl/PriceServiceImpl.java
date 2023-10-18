package com.rah.testjava.microprice.rest.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rah.testjava.microprice.rest.entity.PriceEntity;
import com.rah.testjava.microprice.rest.repository.PriceRepository;
import com.rah.testjava.microprice.rest.service.PriceService;
import com.rah.testjava.microprice.rest.util.MapperUtil;
import com.rah.testjava.microprice.service.model.Price;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PriceServiceImpl implements PriceService {

	private PriceRepository priceRepository;
	private MapperUtil mapper;

	@Override
	public Price getPrice(LocalDate date, Integer productId, Integer brandId, String time) {

		String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9]?)?";

		Predicate<String> predicate = (String value) -> {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		};

		String dateFormat = "%sT%s";

		String dateTimeStr = Optional.ofNullable(time).filter(filter -> !filter.isBlank()).filter(predicate)
				.map(value -> String.format(dateFormat, date, value))
				.orElse(String.format(dateFormat, date, LocalTime.now()));

		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);

		List<PriceEntity> priceEntities = this.priceRepository.findByProductAndBrandAndDateTimeBetween(dateTime);

		List<Price> prices = priceEntities.stream().sorted(Comparator.comparing(PriceEntity::getPriority).reversed())
				.map(price -> {
					log.info("priceEntity: {}", price);
					Price priceModel = this.mapper.mapperObject(price, Price.class);
					log.info("price: {}", priceModel);
					return priceModel;
				}).collect(Collectors.toList());

		return prices.stream().findFirst().orElse(new Price());
	}

}
