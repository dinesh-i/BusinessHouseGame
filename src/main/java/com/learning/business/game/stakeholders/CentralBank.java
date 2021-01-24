package com.learning.business.game.stakeholders;

import com.learning.business.game.constants.BusinessHouseGameConstants;

public class CentralBank extends FinancialStakeHolder {

	public CentralBank(Integer id) {
		super(id);
	}

	@Override
	public Integer getInitialMoney() {
		return BusinessHouseGameConstants.INITIAL_MONEY_IN_BANK;
	}

}
