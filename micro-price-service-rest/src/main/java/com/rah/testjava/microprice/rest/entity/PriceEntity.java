package com.rah.testjava.microprice.rest.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "prices")
@Data
@NamedQuery(name = "PriceEntity.findByProductAndBrandAndDateTimeBetween", 
query = "select p from PriceEntity p where p.productId = ?1 and p.brandId = ?2 and ?3 between p.startDate and p.endDate")
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priceList;
	private Integer productId;
	private Integer priority;
	private Double price;
	private String curr;

}
