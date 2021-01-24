package com.learning.business.game;

import org.junit.Before;

public class BusinessHouseGameValidatorTest {

	private BusinessHouseGameValidatorImpl businessHouseGameValidator;

	@Before
	public void setUp() throws Exception {
		businessHouseGameValidator = new BusinessHouseGameValidatorImpl();
	}

	@org.junit.Test(expected = RuntimeException.class)
	public void shouldverifyDiceOutputIsGivenEquallyForEveryPlayer() {
		final int numberOfPlayers = 2;
		final String cellLayout = "J,H,L,H,E,L,H,L,H,J";
		final String diceOutput = "2,2,1";
		businessHouseGameValidator.validate(cellLayout, diceOutput, numberOfPlayers);
	}

	@org.junit.Test(expected = RuntimeException.class)
	public void shouldVerifyBoardLayoutIsNotEmpty() throws Exception {
		final int numberOfPlayers = 2;
		final String cellLayout = "";
		final String diceOutput = "2,2,1,2";
		businessHouseGameValidator.validate(cellLayout, diceOutput, numberOfPlayers);
	}

}
