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
import com.rah.testjava.microprice.rest.util.ConstantUtil;
import com.rah.testjava.microprice.rest.util.MapperUtil;
import com.rah.testjava.microprice.service.model.Price;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

	private PriceRepository priceRepository;
	private MapperUtil mapper;

	@Override
	public Optional<Price> getPrice(LocalDate date, Integer productId, Integer brandId, String time) {

		Predicate<String> predicate = (String value) -> {
			Pattern pattern = Pattern.compile(ConstantUtil.TIME_REGEX);
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		};

		String dateTimeStr = Optional.ofNullable(time).filter(filter -> !filter.isBlank()).filter(predicate)
				.map(value -> String.format(ConstantUtil.DATE_FORMAT, date, value))
				.orElse(String.format(ConstantUtil.DATE_FORMAT, date, LocalTime.now()));

		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);

		List<PriceEntity> priceEntities = this.priceRepository.findByProductAndBrandAndDateTimeBetween(productId, brandId, dateTime);

		List<Price> prices = priceEntities.stream().sorted(Comparator.comparing(PriceEntity::getPriority).reversed())
				.map(price -> this.mapper.mapperObject(price, Price.class)).collect(Collectors.toList());

		return prices.stream().findFirst();
	}

}
