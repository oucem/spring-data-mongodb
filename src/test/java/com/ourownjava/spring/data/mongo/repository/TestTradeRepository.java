package com.ourownjava.spring.data.mongo.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foursquare.fongo.Fongo;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;
import com.ourownjava.spring.data.mongo.model.Trade;

/**
 * Spring Data MongoDB Repository Unit testcase.
 * 
 * @author ourownjava.com
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestTradeRepository {
	
	@Autowired
    private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb(
			"trade-db");
	
	@Autowired
	private TradeRepository tradeRepository;
	
	
	@Test
	@ShouldMatchDataSet(location = "/testData/trade-t1.json")
	public void shouldSaveTrade(){
		tradeRepository.save(createTrade());
	}
	
	
	
	//@UsingDataSet(locations = {"/testData/item/item-i1.json"})
	
	
	
	private Trade createTrade(){
		final Trade trade = new Trade();
		trade.setId("t1");
		trade.setTraderId("papjac");
		trade.setExchangeCode("NYSE");
		trade.setValue(90.3);
		return trade;
	}
	
	
	
	@Configuration
	@EnableMongoRepositories
	@ComponentScan(basePackageClasses = { TradeRepository.class })
	@PropertySource("classpath:application.properties")
	static class MongoConfiguration extends AbstractMongoConfiguration {

		@Override
		protected String getDatabaseName() {
			return "trade-db";
		}

		@Override
		public Mongo mongo() {
			return new Fongo("trade-test").getMongo();
		}

		@Override
		protected String getMappingBasePackage() {
			return "com.ourownjava.spring.data.mongo";
		}
	}

}
