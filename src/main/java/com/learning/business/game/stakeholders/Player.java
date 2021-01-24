package com.learning.business.game.stakeholders;

import com.learning.business.game.constants.BusinessHouseGameConstants;

public class Player extends FinancialStakeHolder {

	private int currentCellNumber = -1;

	public Player(Integer id) {
		super(id);
	}

	@Override
	public Integer getInitialMoney() {
		return BusinessHouseGameConstants.INITIAL_MONEY_FOR_EACH_PLAYERS;
	}

	public int getCurrentCellNumber() {
		return currentCellNumber;
	}

	public void setCurrentCellNumber(int currentCellNumber) {
		this.currentCellNumber = currentCellNumber;
	}

}
