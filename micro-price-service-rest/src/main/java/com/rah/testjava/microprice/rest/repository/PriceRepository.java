package com.rah.testjava.microprice.rest.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.testjava.microprice.rest.entity.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

	List<PriceEntity> findByProductAndBrandAndDateTimeBetween(Integer ProductId, Integer BrandId,
			LocalDateTime dateTime);
}
