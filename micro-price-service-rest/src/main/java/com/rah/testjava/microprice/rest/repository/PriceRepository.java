package com.rah.testjava.microprice.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.testjava.microprice.rest.entity.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

}
