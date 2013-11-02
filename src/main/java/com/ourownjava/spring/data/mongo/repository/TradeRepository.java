package com.ourownjava.spring.data.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ourownjava.spring.data.mongo.model.Trade;

/**
 * Spring Data MongoDB Repository Example.
 * 
 * @author ourownjava.com
 *
 */
public interface TradeRepository extends MongoRepository<Trade, String>{

	public List<Trade> findByTraderId(final String traderId);
	
	public List<Trade> findByExchangeCode(final String exchangeId);
}
 