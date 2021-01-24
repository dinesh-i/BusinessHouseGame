package com.learning.business.game;

import static org.junit.Assert.assertEquals;

import com.learning.business.game.constants.BusinessHouseGameConstants;

public class BusinessHouseGameConfigurationTest {

	@org.junit.Test
	public void shouldMatchInitialConfiguration() {

		assertEquals(5000, BusinessHouseGameConstants.INITIAL_MONEY_IN_BANK.intValue());
		assertEquals(1000, BusinessHouseGameConstants.INITIAL_MONEY_FOR_EACH_PLAYERS.intValue());

		assertEquals(200, BusinessHouseGameConstants.SILVER_HOTEL_VALUE.intValue());
		assertEquals(300, BusinessHouseGameConstants.GOLD_HOTEL_VALUE.intValue());
		assertEquals(500, BusinessHouseGameConstants.PLATINUM_HOTEL_VALUE.intValue());

		assertEquals(50, BusinessHouseGameConstants.SILVER_HOTEL_RENT.intValue());
		assertEquals(150, BusinessHouseGameConstants.GOLD_HOTEL_RENT.intValue());
		assertEquals(300, BusinessHouseGameConstants.PLATINUM_HOTEL_RENT.intValue());

	}

}
