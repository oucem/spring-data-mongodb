package com.ourownjava.spring.data.mongo.model;

/**
 * 
 * @author ourownjava.com
 *
 */
public class Trade {
	
	private String id;
	
	private String traderId;
	
	private Double value;
	
	private String exchangeId;

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

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(final String exchangeId) {
		this.exchangeId = exchangeId;
	}

}
 