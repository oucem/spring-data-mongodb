package com.ourownjava.spring.data.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author ourownjava.com
 *
 */
@Document(collection = "trade")
public class Trade {
	
	@Id
	private String id;
	
	private String traderId;
	
	private Double value;
	
	private String exchangeCode;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getTraderId() {
		return traderId;
	}

	public void setTraderId(final String traderId) {
		this.traderId = traderId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(final Double value) {
		this.value = value;
	}

	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(final String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

}
 