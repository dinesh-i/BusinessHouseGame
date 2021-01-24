package com.learning.business.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class BusinessHouseGameValidatorImpl implements BusinessHouseGameValidator {

	public BusinessHouseGameValidatorImpl() {
		super();
	}

	@Override
	public void validate(String cellLayout, String diceOutput, int numberOfPlayers) {

		verifyInputValidity(cellLayout, diceOutput, numberOfPlayers);

		validateIfDiceOuputIsEquallyGivenForAllPlayers(diceOutput, numberOfPlayers);

		validityIfBoardIsEmpty(cellLayout);
	}

	private void validityIfBoardIsEmpty(String cellLayout) {
		final List<String> boardLayout = Stream.of(cellLayout.split(",")).map(String::trim)
				.collect(Collectors.toList());
		if (boardLayout.size() == 0)
			throw new RuntimeException("Board Layout can't be empty");
	}

	private void validateIfDiceOuputIsEquallyGivenForAllPlayers(String diceOutput, int numberOfPlayers) {
		final List<Integer> diceOutputList = Stream.of(diceOutput.split(",")).map(s -> Integer.parseInt(s.trim()))
				.collect(Collectors.toList());
		if (diceOutputList.size() % numberOfPlayers != 0)
			throw new RuntimeException("Dice output is not equally given for all players");
	}

	private void verifyInputValidity(String cellLayout, String diceOutput, int numberOfPlayers) {
		if (StringUtils.isEmpty(StringUtils.trim(cellLayout)) || StringUtils.isEmpty(StringUtils.trim(diceOutput))
				|| numberOfPlayers <= 0)
			throw new RuntimeException("Invalid input");
	}

}